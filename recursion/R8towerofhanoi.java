import java.util.Scanner;

public class R8towerofhanoi {
    static void toh(int n,char from,char to,char aux)
    {
        if(n==0)return;
        toh(n-1,from,aux,to);
        System.out.println(from +" "+to);
        toh(n-1,aux,to,from);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        toh(n,'a','c','b');
    }
}
