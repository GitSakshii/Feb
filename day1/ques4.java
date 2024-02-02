import java.util.Scanner;

public class ques4 {
    //Multiply strings
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        String b=sc.nextLine();
        char A[]=a.toCharArray();
        char B[]=b.toCharArray();
        int n=a.length();
        int m=b.length();
        int ans=0; int pow=1;


        for(int i=n-1;i>=0;i--)
        {
            int prod=0;
            int pr=0;
            int p=1;
            int cary=0;
            int r=0;
            for(int j=m-1;j>=0;j--)
            {
                 pr=(A[i]-'0')*(B[j]-'0');
                 r=pr+cary;
                 cary=r/10;
                 r=r%10;
                prod=prod+(r*p);
                p=p*10;
            }
            r=cary;
            prod=prod+r*p;
           ans= ans+prod*pow;
            pow=pow*10;

        }
        System.out.println(ans);

    }
}
