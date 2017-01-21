package cs251lab10package;

import java.io.*;

/**
 * @author harshal
 *
 */
public class JMessage {

	public JMessage() {
		message = "";
	}
	String message;
	
	
	public String getMessage() throws IOException
	{
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
