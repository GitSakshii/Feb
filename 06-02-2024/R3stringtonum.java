// Recursive function to convert a string representation of a number to an integer
import java.util.Scanner;

public class R3stringtonum {

    public static int strtonum(String str,int n)
    {
        if(n==-1)return 0;
        int s=str.charAt(n)-'0';
        return s+(strtonum(str,n-1)*10);
        // Recursively process the remaining characters and multiply by 10 to shift digits to the left
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(strtonum(str,str.length()-1));
    }
}
