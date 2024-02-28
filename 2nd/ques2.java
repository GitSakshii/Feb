//Sum Of Zeroes
import java.util.Scanner;

public class ques2 {
    public static  void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        //Input number of rows and columns
        int n= sc.nextInt();
        int m= sc.nextByte();
        //Initialize 2d array
        int[][] arr=new int[n][m];
         // Input elements into the array and mark rows and columns with 0 if any element is 0
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }


        int ans=0;//Initialize answer as 0
        //Count number of ones surrounding each zero
       for(int i=0;i<n;i++)
       {
           for(int j=0;j<m;j++) {
               
               if (arr[i][j] == 0) {

                   int a = i + 1, b = i - 1, c = j + 1, d = j - 1;
                   if (a < n) {
                       ans += arr[i+1][j];
                   }
                   if (b >=0) {
                       ans += arr[i-1][j];
                   }
                   if (c < m) {
                       ans += arr[i][j+1];
                   }
                   if (d >= 0) {
                       ans += arr[i][j-1];

                   }
               }
           }
       }
        System.out.println(ans);
    }
}
