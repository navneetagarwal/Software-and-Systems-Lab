import java.io.IOException;
public class lab10Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JServer server = new JServer();
		RSA rsa= new RSA();
		System.out.println("Waiting for the Client...");
		if(server.acceptConnection(rsa))
		{
			JChatComm chat = new JChatComm(server);
			JMessage oc = new JMessage();
			JPacket od = new JPacket();
			while(true) {
				chat.receiveMessage(rsa);
				if(server.socket.isClosed())
				{
					server.acceptConnection(rsa);
				}
				else
				{
					chat.sendMessage(od.getPacket(oc.getMessage(),rsa));
				}
			}
		}
		if(!server.serverSocket.isClosed())
			server.serverSocket.close();
	}

}
