import java.util.Arrays;
import java.util.Scanner;

public class Quest4 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextByte();
        int[][] arr=new int[n][m];
        int [] a1=new int[n*m];
        int k=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j]=sc.nextInt();
                a1[k++]=arr[i][j];

            }
        }

        Arrays.sort(a1);
        for(int i=0;i<n;i++)
        {
            System.out.print(a1[i]+" ");

        }



    }
}
