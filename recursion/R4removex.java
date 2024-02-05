import java.util.Scanner;

public class R4removex {
    public static String removex(String str)
    {
        if(str.length()==0)return str;
        if(str.charAt(0)=='x')return removex(str.substring(1));
        else
            return str.charAt(0)+removex(str.substring(1));
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();

        String ans=removex(str);
        System.out.println(ans);
    }
}
