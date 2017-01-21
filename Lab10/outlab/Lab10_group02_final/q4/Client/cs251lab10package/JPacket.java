package cs251lab10package;

import java.util.Date;
import java.math.BigInteger;
import java.sql.*;
/**
 * @author harshal
 *
 */
public class JPacket {
	
	public String time;
	
	public JPacket() {
	}
	public String getPacket(String temp,RSA rsa)
	{
		Date date= new Date();
		Timestamp mytime = new Timestamp(date.getTime());
		time  = mytime.toString();
		time = temp + " [" + time + "]";
//		BigInteger[] big = new BigInteger[time.length()];
//		int l = 0;
//		while(l < time.length()) {
//			big[l] = new BigInteger(time.substring(beginIndex) + "");
//			l++;
//		}
		byte[] bit = time.getBytes();
//		BigInteger mesg=new BigInteger(bit);
		bit = rsa.encrypt(bit);
		time = rsa.bytesToString(bit);
		return time;
	}
}