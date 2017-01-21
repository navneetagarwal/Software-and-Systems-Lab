package cs251lab10package;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.Date;
import java.sql.*;
import java.math.BigInteger;
public class JChatComm
{  public Socket socket   = null;

   public JChatComm() {
	   
   }
   
   public JChatComm(Socket S) {
      socket   = S;
   }
   
   public void endChat() throws Exception
   {
   	System.out.println("Ending Chat...");
   	socket.close();
   }

   public void sendMessage(String packet) throws Exception{
	   PrintStream sout=new PrintStream(socket.getOutputStream());
	   sout.println(packet);
//	   DataOutputStream sout = new DataOutputStream(socket.getOutputStream());
//	   sout.writeInt(packet.length);
//	   sout.write(packet);
   }

   public void receiveMessage(RSA rsa) throws Exception
   {
	   BufferedReader sin=new BufferedReader(new InputStreamReader(socket.getInputStream()));
//	   DataInputStream sin = new DataInputStream(socket.getInputStream());
	   String s, time;
	   s = sin.readLine();
//	   int len = sin.readInt();
//	   byte[] message = null;
//	   if(len >0) {
//		   message = new byte[len];
//		   sin.read(message);
//	   }
	   Date date= new Date();
	   Timestamp mytime = new Timestamp(date.getTime());
	   time  = mytime.toString();
	   byte[] array = s.getBytes();
	   byte[] decrypted = rsa.decrypt(array);
	   s = new String(decrypted);
	   System.out.println("Server: \nEncrypted String: " + rsa.bytesToString(decrypted));
	   System.out.println("Decrypted String: " + s);
	   System.out.println("Received at: [" + time + "]");
   }
}