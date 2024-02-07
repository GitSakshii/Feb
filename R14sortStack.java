import java.util.*;
public class R14sortStack {
    static void sortedInsert(Stack<Integer> s, int x)
    {
        // Base case
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }

        // If top is greater remove the top item
        int temp = s.pop();
        sortedInsert(s, x);
        s.push(temp);
    }
    static void sortStack(Stack<Integer> s)
    {
        // If stack is not empty
        if (!s.isEmpty()) {
            // Remove the top item
            int x = s.pop();

            // Sort remaining stack
            sortStack(s);

            // Push the top item back in sorted stack
            sortedInsert(s, x);
        }
    }

    public static void main(String[] args)
    {
     Scanner sc=new Scanner(System.in);
     int n=sc.nextInt();
     Stack<Integer> s= new Stack<>();
     while(n!=0)
     {
         int tmp=sc.nextInt();
         s.push(tmp);
         n--;
     }
     sortStack(s);
     while(!s.isEmpty())
     {

         System.out.print(s.peek()+ " ");
         s.pop();
     }
    }
}
