import java.io.*;
import java.util.Date;
import java.net.*;
import java.sql.*;
public class JChatComm{
	JServer server;
	JChatComm(){

	}
	JChatComm(JServer seer){
		
		server = seer;
	}
	public void sendMessage(String packet) throws IOException{
		
		PrintStream cout=new PrintStream(server.socket.getOutputStream());
	
		cout.println(packet);
	}
	public void receiveMessage(RSA rsa) throws IOException{
		BufferedReader cin=new BufferedReader(new InputStreamReader(server.socket.getInputStream()));
		String s= cin.readLine();
		Date date =new Date();
		Timestamp mytime=new Timestamp(date.getTime());
		String time  = mytime.toString();		   
		   byte[] array = s.getBytes();
		   byte[] decrypted = rsa.decrypt(array);
		   s = new String(decrypted);
		   System.out.println("Server: \nEncrypted String: " + rsa.bytesToString(decrypted));
		   System.out.println("Decrypted String: " + s);
		   System.out.println("Received at: [" + time + "]");
		if(s.length() >= 8)
		{
			if ((s.substring(0,8)).equalsIgnoreCase("END Chat"))
			{
				endChat();
			}
		}

	}
	public void endChat(){
		System.out.println("Ending Chat...");
		try {
			server.socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
