//Q9For a given array with N elements, you need to find the length of the longest subsequence from the array such that all the elements of the subsequence are sorted in strictly increasing order.
//
//        Strictly Increasing Sequence is when each term in the sequence is larger than the preceding term.
import java.util.Scanner;

public class R9longestsubsequence {
    public static int longestsub(int [] arr,int prev,int cur,int n)
    {
        if(cur==n) return 0;// Base case: if the current index reaches the end of the array, return 0
        int with=0; // Initialize the length of the subsequence with the current element included
       if(prev<0||arr[cur]>arr[prev])
       {
           // Recursively calculate the length of the subsequence with the current element included
           with=1+longestsub(arr,cur,cur+1,n);
       }
       int without=longestsub(arr,prev,cur+1,n);
        // Recursively calculate the length of the subsequence without the current element included
       return Math.max(with,without);
        // Return the maximum length among the two cases (with and without the current element)
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        // Call the recursive function to find the length of the longest increasing subsequence
        // Starting with the first element (-1 indicates no previous element)
        System.out.println(longestsub(arr,-1,0,n));
    }
}
