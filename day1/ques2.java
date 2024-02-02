import java.util.Arrays;
import java.util.Scanner;

public class ques2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int n=str.length();
        char a[]=str.toCharArray();
        int ans=0;
        Arrays.sort(a);
        for(int i=0;i<n-1;i++)
        {
            if(a[i]==a[i+1])
            {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
