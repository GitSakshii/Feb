import java.util.Scanner;

public class gasStation {
    public static boolean check(int[] A, int[] B,int i){
        int n=A.length;
        int  tank=0;
        for(int j=i;j<n;j++)
        {
            tank=tank+A[j]-B[j];

            if(tank<0)return false;
        }
        if(i!=0){
            for(int j=0;j<=i;j++){
                tank=tank+A[j]-B[j];
                if(tank<0)return false;
            }}
        return true;
    }
    public static int canCompleteCircuit(int[] A, int[] B) {
        int n=A.length;
        for(int i=0;i<n;i++){
            if(A[i]>=B[i]){
                if(check(A,B,i))return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] A=new int[n];
        int[] B=new int[n];
        for(int i=0;i<n;i++){
            A[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            B[i]=sc.nextInt();
        }
        System.out.println(canCompleteCircuit(A,B));

    }
}
