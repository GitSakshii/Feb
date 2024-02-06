//8.Problem statement
//Given an integer N, count and return the number of zeros that are
// present in the given integer using recursion.
import java.util.Scanner;

public class R8cntzeros {
    public static int zeros(int n)
    {
        if(n==0)return 0;

        if(n%10==0)return 1+zeros(n/10);
        // If the last digit of n is 0, increment count by 1 and recursively count zeros in the rest of the number

        return zeros(n/10);
        // If the last digit of n is not 0, recursively count zeros in the rest of the number


    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(zeros(n));
    }
}
