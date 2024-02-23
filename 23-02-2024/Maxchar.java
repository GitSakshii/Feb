import java.util.Scanner;

public class Maxchar {
    public static char getMaxChars(String str){
        int max=-1;
        int[] arr=new int[128];
        char ans='\0';
        int n=str.length();
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            int k=(int)(ch);
            arr[k]++;
            if(arr[k]>max){
                max=arr[k];
                ans=ch;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String");
        String str=sc.nextLine();
        int n=str.length();
        System.out.println(getMaxChars(str));

    }
}
