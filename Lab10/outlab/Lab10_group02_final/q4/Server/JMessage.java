import java.io.*;

public class JMessage {
	String message;
	public JMessage() {
		message = "";
	}
	
	
	
	public String getMessage() throws IOException
	{
		System.out.print("Me: ");
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		message = stdin.readLine();
		int lengt = message.length();
		if(lengt < 140)
		{
			return message;
		}
		else
		{
			System.out.println("Message reduced to 140 characters");
			message = message.substring(0, 140);
			return message;
		}
	}
}	