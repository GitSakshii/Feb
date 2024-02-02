import java.util.Scanner;
import java.util.Stack;

public class ques3 {
    //Possible balanced strings
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int cnt=0;
        String st=sc.nextLine();
        int n=st.length();
        char ch[]=st.toCharArray();
        int lastch=1;
        for(int i=0;i<n;i++)
        {
            if(ch[i]=='(')
            {
                cnt++;
                lastch=0;
            }
            else if((cnt==0 || lastch==1)&& ch[i]==')')
            {
                cnt++;
                lastch=1;

            }
            else if(cnt!=0&&ch[i]==')')
            {
                cnt--;

            }
        }
        if(cnt==0)
        {
            System.out.println(st);
        }
        else {
            System.out.println(cnt);
        }


    }
}
