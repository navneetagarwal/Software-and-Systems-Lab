
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
	public void receiveMessage() throws IOException{
		BufferedReader cin=new BufferedReader(new InputStreamReader(server.socket.getInputStream()));
		String s= cin.readLine();
		Date date =new Date();
		Timestamp mytime=new Timestamp(date.getTime());
		String time=mytime.toString();
		System.out.println("Client: "+s);
		System.out.println("Received at:" + time);
		if ((s.substring(0,8)).equalsIgnoreCase("END Chat"))
		{
			endChat();
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
