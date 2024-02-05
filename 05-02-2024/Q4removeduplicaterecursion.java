import java.util.Scanner;

public class Q4removeduplicaterecursion {

    public static String removedup(String str)
    {
        if(str.length()<=1)return str;
        if(str.charAt(0)==str.charAt(1))return removedup(str.substring(1));
        else return str.charAt(0)+removedup(str.substring(1));
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(removedup(str));
    }

}
