//6.Problem statement
//Write a recursive function that returns the sum of
// the digits of a given integer.
import java.util.Scanner;

public class R6sumofdig {
    public static int sum(int n)
    {
        if(n==0)return 0; // Base case: if n is 0, return 0
        return n%10+sum(n/10);
        // Calculate the last digit of n and add it to the sum of the digits of the remaining number
    }
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();//takes input
        System.out.println(sum(n));
    }
}
