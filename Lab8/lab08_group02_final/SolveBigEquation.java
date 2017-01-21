import  java.math.BigDecimal;
import java.math.BigInteger;
import java.lang.*;
import java.math.RoundingMode;
class SolveBigEquation{
	public static BigDecimal NthRoots(BigDecimal num,int n){
	BigDecimal z=new BigDecimal(n);
	// BigDecimal b=new BigDecimal(num);
	BigDecimal s=new BigDecimal("1");
	BigDecimal x_prev=new BigDecimal("1");
	BigDecimal x=new BigDecimal("1");
	int t=n-1;
	x=s.divide(z).multiply(((z.subtract(s)).multiply(x_prev)).add(num.divide(x_prev.pow(t))));
	// System.out.println(x_prev.pow(t));
	// x=1/z*((z-1)*x_prev+num/Math.pow(x_prev,z-1));
	BigDecimal y=new BigDecimal("1");
	BigDecimal a=new BigDecimal("0.000001");
	x_prev=x.add(s);
	while(x_prev.subtract(x).compareTo(a)==1)
	{
		x_prev=x;
		y=x_prev;
		x=s.divide(z).multiply(((z.subtract(s)).multiply(y)).add(num.divide(y.pow(t),7,RoundingMode.HALF_UP)));
	}
	return x;
}
public static BigDecimal factorial(int n) {
       BigDecimal fact = new BigDecimal("1");
       for (int i = 1; i <= n; i++) {
           fact = fact.multiply(new BigDecimal(i));
       }
       return fact;
   }
public static void main(String args[]){
	BigDecimal x=new BigDecimal(factorial(50)+"");
	BigDecimal y=new BigDecimal(factorial(100)+"");
	BigDecimal con=new BigDecimal("2");
	BigDecimal ancon=new BigDecimal("4");
	BigDecimal yet=new BigDecimal("-1");
	BigDecimal result=new BigDecimal("1");
	BigDecimal result1=new BigDecimal("1");
	result=x.add(NthRoots(x.pow(2).add(y.multiply(ancon)),2));
	result=result.divide(con);
	result1=x.subtract(NthRoots(x.pow(2).add(y.multiply(ancon)),2));
	result1=result1.multiply(yet).divide(con);
	// result=result.setScale(3,RoundingMode.CEILING);
	// result1=result1.setScale(3,RoundingMode.CEILING);
	System.out.println(result.multiply(yet).setScale(3,RoundingMode.CEILING));
	System.out.println(result1.multiply(yet).setScale(3,RoundingMode.CEILING));
	System.out.println(result1.multiply(yet).setScale(3,RoundingMode.CEILING));
	System.out.println(result.multiply(yet).setScale(3,RoundingMode.CEILING));
	System.out.println(result1.setScale(3,RoundingMode.CEILING));
	System.out.println(result.setScale(3,RoundingMode.CEILING));
	System.out.println(result.setScale(3,RoundingMode.CEILING));
	System.out.println(result1.setScale(3,RoundingMode.CEILING));
}
}