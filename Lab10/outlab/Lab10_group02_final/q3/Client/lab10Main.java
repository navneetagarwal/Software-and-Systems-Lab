import cs251lab10package.*;
//import cs251lab10package.JClient;
//import cs251lab10package.JMessage;
//import cs251lab10package.JPacket;

import java.io.*;
import java.util.*;

public class lab10Main {

	public static void main(String[] args) throws Exception{
		System.out.println("Enter the IP address of Server: " + "\n");
//		RSA rsa = new RSA();
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		String IP = in.readLine();
		JClient client = new JClient();
//		System.out.println(rsa.publicKeyC);
		client.callServer(IP);
		JChatComm chat = new JChatComm(client.socket);
		JMessage oc = new JMessage();
		JPacket od = new JPacket();
		while(true) {
			System.out.print("Me: ");
			String mes = oc.getMessage();
			if(mes.length()>=8)
			if (mes.substring(0,8).equalsIgnoreCase("End Chat")) {
				chat.sendMessage(od.getPacket(mes));   
				chat.endChat();
			}
			chat.sendMessage(od.getPacket(mes));
			chat.receiveMessage();
		}
	}

}
