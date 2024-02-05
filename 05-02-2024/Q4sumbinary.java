import java.util.Scanner;


public class Q4sumbinary {

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        int n=s1.length();
        int m=s2.length();
        n=n-1;
        m=m-1;
        String ans="";
        char carry ='0';
        while(n>=0&&m>=0)
        {
           char a=s1.charAt(n);
           char b=s2.charAt(m);
           if(carry=='1'&&(a=='1'&&b=='0'||a=='0'&&b=='1'))
           {
               ans+='0'+"";
               carry='1';
           }
           else if(carry=='0'&&(a=='1'&&b=='0'||a=='0'&&b=='1')){
               ans+='1'+"";

           }
           else if(carry=='1'&&a=='0'&&b=='0')
           {
               ans+='1'+"";
               carry='0';
           }
           else if(carry=='0'&&a=='1'&&b=='1')
           {
               ans+='0'+"";
               carry='1';
           }
           else
           {
               ans+='0'+"";
               carry='0';

           }
           n--;
           m--;
        }
        while(n>=0)
        {
            char a=s1.charAt(n);
            if(a=='1'&&carry=='1')
            {
                ans+='0'+"";
                carry='1';
            }
           else if(a=='0' && carry=='1')
            {
                ans+='1'+"";
                carry='0';
            }
           else {
                ans+='1'+"";
                carry='0';
            }
           n--;

        }
        while(m>=0)
        {
            char a=s2.charAt(m);
            if(a=='1'&&carry=='1')
            {
                ans+='0'+"";
                carry='1';
            }
            else if(a=='0' && carry=='1')
            {
                ans+='1'+"";
                carry='0';
            }
            else {
                ans+='1'+"";
                carry='0';
            }
            m--;

        }
        if(carry=='1')
        {
            ans+='1'+"";
        }

        for (int i=ans.length()-1;i>=0;i--)
        {
            System.out.println(ans.charAt(i));
        }

    }
}
