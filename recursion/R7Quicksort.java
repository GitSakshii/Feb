import java.util.Scanner;

public class R7Quicksort {
    public static int partition(int[] arr,int s,int e)
    {
        int pivot=arr[e];
        int i=s-1;
        for(int j=s;j<=e;j++)
        {
            if(arr[j]<pivot)
            {
                i++;
                int tmp=arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
            }
        }
        int tmp=arr[i+1];
        arr[i+1]=arr[e];
        arr[e]=tmp;
        return(i+1);
    }
    public static void quickSort(int[] arr,int s,int e)
    {
        if(s<e)
        {
            int pi=partition(arr,s,e);
            quickSort(arr,s,pi-1);
            quickSort(arr,pi+1,e);
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
        quickSort(arr,0,n-1);
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }

    }
}
