import java.util.Scanner;

public class R2digits {
    public static int cntdigit(int n)
    {
        if(n==0)return 0;
        return cntdigit(n/10)+1;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println( cntdigit(n));

    }
}
