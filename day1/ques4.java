import java.util.Scanner;

public class ques4 {
    //Multiply strings
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        // Input two strings
        String a=sc.nextLine();
        String b=sc.nextLine();
        // Convert Strings to char arrays
        char A[]=a.toCharArray();
        char B[]=b.toCharArray();
        // Get lengths of input strings
        int n=a.length();
        int m=b.length();

        int ans=0; // Initialize the result
        int pow=1; // Initialize the power of 10

        // Iterate through each digit of the first number (from right to left)
        for(int i=n-1;i>=0;i--)
        {
            int prod=0;// Initialize the product
            int pr=0;// Initialize the partial product
            int p=1;// Initialize the power of 10 for positionin
            int cary=0;// Initialize the carry
            int r=0;
            // Iterate through each digit of the second number (from right to left)
            for(int j=m-1;j>=0;j--)
            {
                // Multiply the digits and add the carry
                 pr=(A[i]-'0')*(B[j]-'0');
                 r=pr+cary;
                // Update carry and remainder
                 cary=r/10;
                 r=r%10;
                // Add the current digit to the product
                prod=prod+(r*p);
                p=p*10;
            }
            r=cary;
            // Add the carry to the product
            prod=prod+r*p;
            // Add the current partial product to the final result

            ans= ans+prod*pow;
            // Update the positioning factor
            pow=pow*10;

        }
        // Print the final result
        System.out.println(ans);

    }
}

   
