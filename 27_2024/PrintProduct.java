//Prints the product of all elements of array leaving itself
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class PrintProduct {
    public static long[] product(int[] arr,int n){
        long prod=1;
        long[] resultArr=new long[n];
        for(int i=0;i<n;i++)
        {
            prod=prod*arr[i];
        }
        for(int i=0;i<n;i++){
            resultArr[i]=prod/arr[i];
        }
       return resultArr;
    }
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
        System.out.println("Enter n");
        int n=sc.nextInt();
        System.out.println("Enter Array");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        long []result=product(arr,n);
        for(int i=0;i<n;i++){
            System.out.print(result[i]+" ");
        }
    }
}
