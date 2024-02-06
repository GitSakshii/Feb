//10.Program to calculate value of nCr using Recursion
//Given two numbers N and r, find the value of NCr using recursion
import java.util.Scanner;

public class R10ncr {
    public static int ncr(int n,int r){
        if(r==0)return 1; // Base case: if r is 0, returns 1 to terminate the recursion
        return n*ncr(n-1,r-1)/r;// Recursively calculate nCr using the formula: nCr = n * (n-1)C(r-1) / r
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int r=sc.nextInt();
        if(n-r<r)r=n-r;// If r is greater than n-r, update r to n-r
        System.out.println(ncr(n,r));
    }
}
