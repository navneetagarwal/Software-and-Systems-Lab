import java.net.*;
import java.io.*;

public class JServer {
	public ServerSocket serverSocket;
	public Socket socket;
	
	public JServer() throws IOException {
		// TODO Auto-generated constructor stub
			serverSocket=new ServerSocket(6210);
		
	}
	
	public boolean acceptConnection() throws IOException
	{
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		socket =serverSocket.accept();
		System.out.println("Client Connected: ");
		BufferedReader ClientIn=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream ServerOut=new PrintStream(socket.getOutputStream());
		String s;
		s=ClientIn.readLine();
		if(s.equalsIgnoreCase( "Hey! Want to chat?"))
		{
			System.out.println("Do you want to chat with this Client");
			if(socket.isConnected() )
			{
				if(stdin.readLine().equalsIgnoreCase("Yes"))
				{
					if(socket.isConnected())
					{
						ServerOut.println("Sure!");
						return true;
					}
				}
				else
				{
					if(socket.isConnected())
						socket.close();
					if(!serverSocket.isClosed())
						serverSocket.close();
					System.out.println("Connection Terminated");
					return false;
				}
			}
		}
		return false;
	}
}
