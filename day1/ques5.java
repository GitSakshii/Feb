import java.util.Scanner;
/*Total Strings

Problem statement
You are given a positive integer 'N'. Your task is to find the number of
strings of length ‘N’ that can be formed using only the characters ‘a’, ‘b’ and ‘c’.
 The strings formed should be such that the number of ‘b’ and ‘c’ in the string is at most
  1 and 2, respectively.
*/
public class ques5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // Input the value of N

        int result = countStrings(N);// Output the result

        System.out.println(result);
    }
    // Function to count valid strings of length N
    public static int countStrings(int N) {

        if (N == 0) {
            return 1; // Base case: If N is 0, return 1 (empty string)
        }
        // Recursive calls to count valid strings by considering different endings
        int countA = countStrings(N - 1);// Add 'a' to the end
        int countB = (N >= 2) ? countStrings(N - 2) : 0;// Add 'ab' to the end
        int countC = (N >= 3) ? countStrings(N - 3) : 0;// Add 'abc' to the end
        return countA + countB + countC;
    }
    }
