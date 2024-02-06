import java.util.Scanner;

public class R13reversepower {
    public static long power(int n,int r) {
        if(r==0)return 1;// Base case: if r is 0, return 1
        if(n==0)return 0;// Base case: if n is 0, return 0
        // Recursively calculate the power of n to r-1 and multiply with n,
        // then take modulo 1000000007
        return (n*power(n,r-1))%1000000007;

    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
       int n=sc.nextInt();
       //reverse the given number
       int w=n, r=0;
       while(w!=0)
       {

           r=(r*10)+w%10;
           w=w/10;
       }
        System.out.println(r);
        System.out.println(power(n,r));
    }
}
