import java.util.Scanner;

public class Ques1 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        // Input number of rows and columns
        int n= sc.nextInt();
        int m= sc.nextByte();
        // Initialize a 2D array
        int[][] arr=new int[n][m];
        // Input elements into the array and mark rows and columns with 0 if any element is 0
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j]=sc.nextInt();
                if(arr[i][j]==0){
                    arr[0][j]=0;// Mark the first row with 0
                    arr[i][0]=0;// Mark the first column with 0
                }
            }
        }
        // Modify the array based on the marks made in the first row and column
        for(int i=0;i<n;i++)
        {
            if(arr[i][0]==0)
            {
                for(int j=1;j<m;j++)
                {
                    arr[i][j]=0;// Mark the entire row with 0 if the first element is 0
                }
            }
        }
        // Modify the array based on the marks made in the first row and column

        for(int i=0;i<m;i++)
        {
            if(arr[0][i]==0){
                for(int j=1;j<n;j++)
                {
                    arr[j][i]=0;// Mark the entire Column with 0 if the first element is 0
                }
            }

        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}

   
