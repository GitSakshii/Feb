import java.util.Scanner;

public class R2ispallindrome {

    public static boolean ispallindrome(String str,int s,int e)
    {
        if(s==e)return true;//if start and end index iterators reaches same index then it returns true
        //for eg in case of aba when start and end idx reaches 1 it returns true
        if(str.charAt(s)!=str.charAt(e))return false;/*if character from left half is not equal to character at right half
        then the function terminate by returning false*/
        if(s<e+1)//checks if there  are more characters to compare
        {
            return ispallindrome(str,s+1,e-1);
        }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int n=str.length();//takes input
        System.out.println(ispallindrome(str,0,n-1));
    }
}
