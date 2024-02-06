import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class R11reversequeue {
    public static Queue<Integer> reverseq(Queue<Integer> q)
    {
        if (q.isEmpty())
            return q;
        // Dequeue current item (from front)
        int temp=q.peek();
        q.remove();
        // Reverse remaining queue
        q=reverseq(q);
        // Enqueue current item (to rear)
        q.add(temp);
        return q;
    }
    public static void main(String [] args)
    {
        Queue<Integer> q=new LinkedList<>();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i =0;i<n;i++)
        {
            int tmp=sc.nextInt();
            q.add(tmp);
        }
        reverseq(q);
        //print elements
        while (!q.isEmpty())
        {
            System.out.print(q.peek() + " ");
            q.remove();
        }
    }
}
