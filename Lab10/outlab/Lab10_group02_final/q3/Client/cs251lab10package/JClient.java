package cs251lab10package;

import java.net.*;
import java.math.BigInteger;
import java.io.*;
import java.util.*;


public class JClient {

	public JClient() {
		
	}
	
	public Socket socket;
	
	public void callServer(String IP) throws Exception{
	
	Random randomGenerator = new Random();
    int timeout = randomGenerator.nextInt(5001) + 5000;		
	socket=new Socket(IP,5123);
	String s;
	PrintStream sout=new PrintStream(socket.getOutputStream());
//	System.out.println(rsa.publicKeyC);
//	s = "Hey! Want to chat? My public key is " + rsa.publicKeyC.toString();
	s = "Hey! Want to chat?";
	sout.println(s);
	System.out.println("Me: " + s);
	socket.setSoTimeout(timeout);
	BufferedReader sin=new BufferedReader(new InputStreamReader(socket.getInputStream()));
	s=sin.readLine();
	System.out.print("Server: "+s+"\n");
//	s = s.substring(23);
//	System.out.println(s);
//	BigInteger big = new BigInteger(s);
//	rsa.setPublickeyS(big);
	socket.setSoTimeout(0);
	}
}
