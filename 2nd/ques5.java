import java.util.Scanner;

public class ques5 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextByte();
        int[][] arr=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }

        int a=0;
        int x=sc.nextInt();
       for(int i=0;i<n;i++)
       {
           if(arr[i][0]>x)break;
           if(arr[i][0]==x){
               a=1;break;
           }
           else if(arr[i][0]<x&&arr[i][m-1]>x)
           {
               int low=0,high=m-1;
               int mid;
               while(low<high)
               {
                   mid=(low+high)/2;
                   if(arr[i][mid]==x){
                       a=1;break;
                   }
                   else if(arr[i][mid]<x)
                   {
                       low=mid+1;
                   }
                   else {
                       high=mid;
                   }
               }

           }

       }
       if(a==0) System.out.println("No");
       else System.out.println("Yes");
    }
}
