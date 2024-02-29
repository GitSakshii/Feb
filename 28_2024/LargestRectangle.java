import java.util.Scanner;
import java.util.Stack;
//Find the area of largest rectangle formed by a histogram
public class LargestRectangle {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println("Enter the size of array");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
           arr[i]=scanner.nextInt();
        }
        Stack<Integer> stack=new Stack<Integer>();
        int[] leftSmall=new int[n];//array to store left small
        int[] rightSmall=new int[n];//Array to store right small value
        for(int i=0;i<n;i++){
            while(!stack.empty()&& arr[stack.peek()]>=arr[i])
            {
                stack.pop();
            }
            if(stack.empty())leftSmall[i]=0;
            else leftSmall[i]=stack.peek();
            stack.push(i);
        }
        //Clear the stack to be reused
        while(!stack.empty()){
            stack.pop();
        }

        for(int i=n-1;i>=0;i--){
            while(!stack.empty()&& arr[stack.peek()]>=arr[i])
            {
                stack.pop();
            }
            if(stack.empty())rightSmall[i]=n-1;
            else rightSmall[i]=stack.peek();
            stack.push(i);
        }
        
        int ans=0;//Initialize ans to zero
        for(int i=0;i<n;i++){
            System.out.println(leftSmall[i]+" "+rightSmall[i]);
            int area=arr[i]*(rightSmall[i]-leftSmall[i]-1);
            ans=Math.max(ans,area);
        }
        System.out.println("Area of largest rectangle formed by histogram:"+ans);
    }
}
