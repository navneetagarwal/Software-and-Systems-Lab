package cs251lab10package;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;

public class RSA {
   private final static SecureRandom random = new SecureRandom();

   private BigInteger privateKey;
   public BigInteger publicKeyS;
   public BigInteger publicKeyC;
   private BigInteger N;
   private BigInteger phi;
   private BigInteger p;
   private BigInteger q;
   private Random r;
   
   //Primes 65537 65557
   // generate an N-bit (roughly) public and private key
   public RSA() {
//      publicKeyC = BigInteger.probablePrime(30, random);
//      phi = new BigInteger("4296278016");
//      N = new BigInteger("4296409109");
//      privateKey = publicKeyC.modInverse(phi);
      r = new Random();
      p = new BigInteger("65537");
      q = new BigInteger("65557");
      N = p.multiply(q);
      phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
      publicKeyC = BigInteger.probablePrime(16, r);
      while (phi.gcd(publicKeyC).compareTo(BigInteger.ONE) > 0 && publicKeyC.compareTo(phi) < 0 ) {
    	  publicKeyC.add(BigInteger.ONE);
      }
      privateKey = publicKeyC.modInverse(phi);
   }
   
   public String bytesToString(byte[] encrypted) {
		String test = "";
		for (byte b : encrypted) {
			test += Byte.toString(b);
		}
		return test;
	}
   
   public byte[] encrypt(byte[] message) {
		return (new BigInteger(message)).modPow(publicKeyS, N).toByteArray();
	}

  public byte[] decrypt(byte[] message) {
		return (new BigInteger(message)).modPow(privateKey, N).toByteArray();
	}
// public BigInteger encrypt(BigInteger message) {
//      return message.modPow(publicKeyS, N);
//   }
// public BigInteger decrypt(BigInteger encrypted) {
//     return encrypted.modPow(privateKey, N);
//  }
  
  public void setPublickeyS(BigInteger key)
  {
	  publicKeyS = key;
  }
  
  public BigInteger getpublicKeyC()
  {
	  return publicKeyC;
  }
		  

}