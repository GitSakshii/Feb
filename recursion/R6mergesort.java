import java.util.Scanner;

public class R6mergesort {
    public static void merge(int[] arr,int s,int mid,int e)
    {
        int n1=mid-s+1;
        int n2=e-mid;
        int []arr1=new int[n1];
        int [] arr2=new int[n2];
        for(int i=0;i<n1;i++)
        {
            arr1[i]=arr[s+i];
        }
        for(int i=0;i<n2;i++)
        {
            arr2[i]=arr[mid+1+i];
        }
        int i=0; int j=0;
        int k=s;
        while(i<n1&&j<n2)
        {
            if(arr1[i]<arr2[j])
            {
                arr[k++]=arr1[i++];
            }
            else {
                arr[k++]=arr2[j++];
            }

        }
        while (i<n1)
        {
            arr[k++]=arr1[i++];
        }
        while(j<n2)
        {
            arr[k++]=arr2[j++];
        }


    }
    public static void mergesort(int[] arr,int s,int e)
    {
        if(s<e){
        int mid=(s+e)/2;
        mergesort(arr,s,mid);
        mergesort(arr,mid+1,e);
        merge(arr,s,mid,e);
        }
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
        mergesort(arr,0,n-1);
        for(int i =0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
