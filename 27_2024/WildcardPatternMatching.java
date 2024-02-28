import java.util.Scanner;

public class WildcardPatternMatching {
    public static Boolean solve(String s,String p,int i,int j)
    {
        if(i<0&&j<0)return true;
        if(i>=0&&j<0)return false;
        if(i<0){
            for(int k=0;k<=j;k++){
                if(p.charAt(k)!='*')return false;
            }
            return true;
        }
        if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')return solve(s,p,i-1,j-1);
        else if(p.charAt(j)=='*')return(solve(s,p,i,j-1)||solve(s,p,i-1,j));
        else return false;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter both Strings");
        String A=sc.nextLine();
        String B=sc.nextLine();
        System.out.println(solve(A,B,A.length()-1,B.length()-1));
    }
}
