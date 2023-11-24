import java.util.Scanner;
import java.math.BigInteger;

public class Multiplication{

    public static BigInteger recursiveMul(BigInteger a, BigInteger b)
    {
      if(a.compareTo(BigInteger.TEN)<0 || b.compareTo(BigInteger.TEN)<0){
         return a.multiply(b);
      }
      
      int n = Math.max(a.toString().length(), b.toString().length());
      BigInteger temp = BigInteger.TEN.pow(n/2);

      BigInteger a1 = a.divide(temp);
      BigInteger a2 = a.mod(temp);
      BigInteger b1 = b.divide(temp);
      BigInteger b2 = b.mod(temp);

      BigInteger p = recursiveMul(a1, b1);
      BigInteger q = recursiveMul(a1.add(a2), b1.add(b2)).subtract(p).subtract(recursiveMul(a2, b2));
      BigInteger r = recursiveMul(a2, b2);

      return p.multiply(temp.pow(2)).add(q.multiply(temp)).add(r);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the first number:");
        BigInteger a = sc.nextBigInteger();
        System.out.println("Enter the second number:");
        BigInteger b = sc.nextBigInteger();

        BigInteger result = recursiveMul(a,b);
        System.out.println("The result is "+result);

        sc.close();
    }
}