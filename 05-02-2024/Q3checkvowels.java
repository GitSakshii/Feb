import java.util.Scanner;

public class Q3checkvowels {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int n=str.length();
        int check=0;
        for(int i=0;i<n/2;i++)
        {
            char l=str.charAt(i),r=str.charAt(n-i-1);
            if(l=='a'||l=='e'||l=='i'||l=='o'||l=='u')
            {
                check++;
            }
            if(r=='a'||r=='e'||r=='i'||r=='o'||r=='u'){
                check--;
            }
        }
        if(check==0)
        {
            System.out.println(true);
        }
        else
            System.out.println(false);

    }
}
