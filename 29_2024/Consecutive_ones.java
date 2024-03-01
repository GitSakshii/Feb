
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Consecutive_ones {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n");
         int n=sc.nextInt();
         int[] arr=new int[n];
         for(int i=0;i<n;i++){
             arr[i]=sc.nextInt();//Take input the user
         }
         int startIdx=-1,endIdx=-1;
        System.out.println("Enter k");
         int k=sc.nextInt();
         int i=0,j=0;
         int ans=0;
         while(i<n&&j<n){
             if(arr[j]==0)
             {
                 k--;
             }
             while(k<0){
                 if(arr[i]==0)
                 {
                     k++;
                 }
                 i++;
             }
             if(j-i+1>ans)
             {
                 ans=j-i+1;
                 startIdx=i;
                 endIdx=j;
             }

             j++;

         }
        for(int idx=startIdx;idx<endIdx;idx++)
        {
            System.out.print(idx+",");
        }
        System.out.println(endIdx);
    }
}
