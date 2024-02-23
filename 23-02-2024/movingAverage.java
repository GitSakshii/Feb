import java.util.Scanner;
import java.util.Vector;

public class movingAverage {
   static Vector<Integer>calc_mov_avg(int n,Vector<Integer>v,int w){
        Vector<Integer>ans=new Vector<>();
        int  sum=0;
        for(int i=0;i<w;i++){
            sum=sum+v.get(i);
        }
        ans.add((int)Math.ceil((double)sum/w));
       for (int i = 1; i <= n - w; i++) {
           sum = sum - v.get(i - 1) + v.get(i + w - 1); // Update the sum by removing the leftmost element and adding the rightmost element of the window
           ans.add((int) Math.ceil((double) sum / w)); // Add the average of the current window
       }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Vector <Integer>v=new Vector<>();
        System.out.println("size:");
        int n=sc.nextInt();
        System.out.println("Vector:");
        for(int i=0;i<n;i++){
            v.add(sc.nextInt());
        }
        System.out.println("Enter Window Size:");
        int w=sc.nextInt();
        Vector<Integer> ans=calc_mov_avg(n,v,w);
        int ws=ans.size();
        System.out.println(ws);
        for (int i=0;i<ws;i++){
            System.out.print(ans.get(i));
        }
    }
}
