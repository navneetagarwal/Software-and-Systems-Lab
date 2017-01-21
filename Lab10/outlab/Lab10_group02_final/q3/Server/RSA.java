
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;

    

public class RSA {
   private final static SecureRandom random = new SecureRandom();

   private BigInteger privateKey;
   private BigInteger p;
   private BigInteger q;
   public BigInteger publicKeyS;
   public BigInteger publicKeyC;
   private BigInteger N;
   private BigInteger phi;
   private Random r;
   
   //Primes 65537 65557
   // generate an N-bit (roughly) public and private key
   RSA() {
       
       r = new Random();
        p = new BigInteger("65537") ;
        q = new BigInteger("65557");
        N = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        publicKeyS = BigInteger.probablePrime(16, r);
        while (phi.gcd(publicKeyS).compareTo(BigInteger.ONE) > 0 && publicKeyS.compareTo(phi) < 0 ) {
            publicKeyS.add(BigInteger.ONE);
        }
        privateKey = publicKeyS.modInverse(phi);
//      publicKeyS = BigInteger.probablePrime(30, random);
//      phi = new BigInteger("4296278016");
//      N = new BigInteger("4296409109");
//      privateKey = publicKeyS.modInverse(phi);
   }

  public byte[] encrypt(byte[] message) {
		return (new BigInteger(message)).modPow(publicKeyC, N).toByteArray();
	}

  public byte[] decrypt(byte[] message) {
		return (new BigInteger(message)).modPow(privateKey, N).toByteArray();
	}
   
  public void setPublickeyC(BigInteger key)
  {
      publicKeyC = key;
  }
  
  public BigInteger getpublicKeyS()
  {
      return publicKeyS;
  }
   public String bytesToString(byte[] encrypted) {
		String test = "";
		for (byte b : encrypted) {
			test += Byte.toString(b);
		}
		return test;
	}
   }
