import java.util.Scanner;

public class MaxForEachWindow {
    //brute force approach
    //Method to return an array of maximum value of each sliding window
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        //Calculate the size of result array
        int n2=n-k+1;
        int[] ans=new int[n2];
        int m=0;//Index for result array
        int i=0;//Index for sliding Window
        //Iterate through each sliding window
        while(i<n-k+1)
        {
            int l=i;//Start Index of current Window
            int j=l+k;//End Index of current Window
            max=nums[l];//Initialize max value for the current window
            l++;
            while(l<j)
            {
                //Update max value if current element is greater
                if(nums[l]>max)
                {
                    max=nums[l];
                }
                l++;//Move to next element in the window
            }
            ans[m++]=max;//Store the next element in the window
            i++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] nums=new int[n];//Initialize array to store elements
        //Input elements of the array
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        int k=sc.nextInt();//Input size of sliding window
         int [] ans=maxSlidingWindow(nums,k);//Find maximum for each window
        //Output the maximum for each window
         for(int i=0;i<n;i++){
             System.out.println();
        }
    }
}
