//Given a string S, compute recursively a new string where
// identical chars that are adjacent in the original string are
// separated from each other by a "*".
import java.util.Scanner;

public class R4seperateidenticals {

    public static String seperate(String str)
    {
       if(str.length()==1)return str;
        // Check if the first character is identical to the second character
       if(str.charAt(0)==str.charAt(1))
           // If identical, return the first character followed by '*' and recursively process the rest of the string
           return str.charAt(0)+"*"+seperate(str.substring(1));
        // If the first character is not identical to the second character, return the first character
        // and recursively process the rest of the string
       return str.charAt(0)+seperate(str.substring(1));
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(seperate(str));
    }
}
