import java.util.Date;
import java.sql.*;

public class JPacket {

	public String time;
	
	public JPacket() {
	}
	public String getPacket(String temp,RSA rsa)
	{
		Date date= new Date();
		Timestamp mytime = new Timestamp(date.getTime());
		time  = mytime.toString();

		time = temp + " [ " + time+" ] ";
		byte[] bit = time.getBytes();
		bit = rsa.encrypt(bit);
		time = rsa.bytesToString(bit);
		return time;
	}
}
