import java.util.Arrays;
import java.util.Scanner;

public class scrambledString {
    static boolean isScramble(String S1, String S2)
    {

        if (S1.length() != S2.length())
        {
            return false;
        }

        int n = S1.length();

        if (n == 0)
        {
            return true;
        }
        if (S1.equals(S2))
        {
            return true;
        }

        char[] tempArray1 = S1.toCharArray();
        char[] tempArray2 = S2.toCharArray();

        // Checking condition for Anagram
        Arrays.sort(tempArray1);
        Arrays.sort(tempArray2);

        String copy_S1 = new String(tempArray1);
        String copy_S2 = new String(tempArray2);

        if (!copy_S1.equals(copy_S2))
        {
            return false;
        }

        for(int i = 1; i < n; i++)
        {

            if (isScramble(S1.substring(0, i),
                    S2.substring(0, i)) &&
                    isScramble(S1.substring(i, n),
                            S2.substring(i, n)))
            {
                return true;
            }

            if (isScramble(S1.substring(n - i, n),
                    S2.substring(0, i)) &&
                    isScramble(S1.substring(0, n - i),
                            S2.substring(i, n)))
            {
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        System.out.println(isScramble(s1,s2));
    }
}
