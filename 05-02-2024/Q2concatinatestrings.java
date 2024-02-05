import java.util.Scanner;

public class Q2concatinatestrings {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        String str=sc.nextLine();
        int n=str.length();
        char prev=' ';
        String ans="";
        for(int i=0;i<n;i++)
        {
            char ch=str.charAt(i);
            if(ch>=48&&ch<=57){

            }
           else if(prev==' ')
            {
                if(ch<122&&ch>97)
                {

                    ans+=(char)(ch-32)+"";
                    prev=ch;
                }
                else {
                    ans+=ch+"";
                    prev=ch;
                }

            }
           else {
                ans += ch + "";
                prev=ch;
            }

        }

        System.out.println(ans);

    }
}
