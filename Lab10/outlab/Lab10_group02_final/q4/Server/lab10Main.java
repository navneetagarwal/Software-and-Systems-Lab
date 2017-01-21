import java.io.IOException;
public class lab10Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JServer server = new JServer();
		System.out.println("Waiting for the Client...");
		if(server.acceptConnection())
		{
			JChatComm chat = new JChatComm(server);
			JMessage oc = new JMessage();
			JPacket od = new JPacket();
			while(true) {	
				chat.receiveMessage();
				if(server.socket.isClosed())
				{
					server.acceptConnection();
				}
				else
				{
					chat.sendMessage(od.getPacket(oc.getMessage()));
				}
			}
		}
		if(!server.serverSocket.isClosed())
			server.serverSocket.close();
	}

}
