import java.net.*;
import java.io.*;
import java.math.BigInteger;

public class JServer {
	public ServerSocket serverSocket;
	public Socket socket;
	
	public JServer() throws IOException {
		// TODO Auto-generated constructor stub
			serverSocket=new ServerSocket(5123);
		
	}
	
	public boolean acceptConnection(RSA rsa) throws IOException
	{
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		socket =serverSocket.accept();
		System.out.println("Client Connected: ");
		BufferedReader ClientIn=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream ServerOut=new PrintStream(socket.getOutputStream());
		String s;
		s=ClientIn.readLine();
		System.out.println(s);
		if(s.substring(0,36).equalsIgnoreCase( "Hey! Want to chat? My public key is "))
		{
			BigInteger big = new BigInteger(s.substring(36));
			System.out.println(big);
			System.out.println("Do you want to chat with this Client");
			if(socket.isConnected() )
			{
				if(stdin.readLine().equalsIgnoreCase("Yes"))
				{
					if(socket.isConnected())
					{
						String key = rsa.getpublicKeyS().toString();
						rsa.setPublickeyC(big);
						ServerOut.println("Sure! My public key is " + key);
						System.out.println("Sure! My public key is " + key);
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
