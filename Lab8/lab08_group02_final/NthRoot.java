import  java.math.BigDecimal;
import java.math.BigInteger;
import java.lang.*;
import java.math.RoundingMode;
import java.util.Scanner;
class NthRoot{
	public BigDecimal NthRoots(BigInteger num,int n){
	BigDecimal z=new BigDecimal(n);
	BigDecimal b=new BigDecimal(num);
	BigDecimal s=new BigDecimal("1");
	BigDecimal x_prev=new BigDecimal("1");
	BigDecimal x=new BigDecimal("1");
	int t=n-1;
	x=s.divide(z,8,RoundingMode.HALF_UP).multiply(((z.subtract(s)).multiply(x_prev)).add(b.divide(x_prev.pow(t),8,RoundingMode.HALF_UP)));
	// System.out.println(x_prev.pow(t));
	// x=1/z*((z-1)*x_prev+num/Math.pow(x_prev,z-1));
	BigDecimal y=new BigDecimal("1");
	BigDecimal a=new BigDecimal("0.000001");
	x_prev=x.add(s);
	while(x_prev.subtract(x).compareTo(a)==1)
	{
		x_prev=x;
		y=x_prev;
		x=s.divide(z,8,RoundingMode.HALF_UP).multiply(((z.subtract(s)).multiply(y)).add(b.divide(y.pow(t),8,RoundingMode.HALF_UP)));
	}
	return x;
}
public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	BigInteger kk = sc.nextBigInteger();
	// BigInteger kk=new BigInteger("61");
	NthRoot ob =new NthRoot();
	int b=sc.nextInt();
	BigDecimal oldBD=ob.NthRoots(kk,b);
	BigDecimal newBD = oldBD.setScale(6,RoundingMode.HALF_UP);
	System.out.println(newBD);
}

}
