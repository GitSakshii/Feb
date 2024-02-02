import java.util.Scanner;

public class ques1 {
    static Boolean isequal(String s1,String s2)
    {
        int n=s1.length();
        if (s1.equals(s2)) return true;
        if(n%2==0) {

            String a1 = s1.substring(0, n / 2);
            String a2 = s1.substring(n / 2);
            String b1 = s2.substring(0, n / 2);
            String b2 = s2.substring(n / 2 );
            if ((isequal(a1, b1) && isequal(a2, b2)) || (isequal(a1, b2) && isequal(a2, b1))) return true;
        }
        return false;

    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s1,s2;
        s1=sc.nextLine();
        s2=sc.nextLine();
        int n=s1.length();
        int m=s2.length();
        if(m==n && n%2==0)
        {
           if(isequal(s1,s2)) System.out.println("True");
           else
               System.out.println("False");
        }
    }
}
