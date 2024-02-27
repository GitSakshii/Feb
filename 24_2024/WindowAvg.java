import java.util.Scanner;
import java.util.Vector;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class WindowAvg {
    public static Vector<Integer> calc_mov_avg(Vector<Integer>v,int n,int w){
        Vector<Integer>ans=new Vector<>();
        int sum=0;
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
          int n=sc.nextInt();
        Vector<Integer>v=new Vector<>();
        for(int i=0;i<n;i++){
            v.add(sc.nextInt());
        }
        int w=sc.nextInt();
        Vector<Integer> ans=calc_mov_avg(v,n,w);
        int ws=ans.size();
        System.out.println(ws);
        for (int i=0;i<ws;i++){
            System.out.print(ans.get(i));
        }
    }
}
