import java.util.Scanner;

public class R7multiplication {
    public static int multiply(int m,int n)
    {
        // Base case: if m is 0, return 0
        if(m==0)return 0;
        return n+multiply(m-1,n);
        // Recursively perform multiplication of m-1 and n, then add n to the result
    }
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        int m =sc.nextInt(),n=sc.nextInt();
        int a,b;
        // Determine the smaller and larger integers
        if(m<n)
        {
           a=m;b=n;
        }
        else
        {
          b=m;a=n;
        }
        System.out.println(multiply(a,b));
    }
}
