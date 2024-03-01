import java.util.Scanner;

public class roottoleafsum {
    class Node{
        int val;
        Node left ,right;
        public Node(int item){
            val =item;
            left=right=null;
        }
    }
    Node root;
    static int ans=0;
    static void printans(Node node, int val)
    {
        if (node == null)
            return ;

        val=(val*10)+node.val;
        if (node.left == null && node.right == null){
            ans=ans+val%1003;
            return;}
        else
        {
            /* otherwise try both subtrees */
            printans(node.left,val);
            printans(node.right,val );
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        roottoleafsum tree = new roottoleafsum();
        tree.root=tree.new Node(1);
        tree.root.left=tree.new Node(2);
        tree.root.right=tree.new Node(3);
        if(tree.root==null) System.out.println(0);
        else {
            printans(tree.root,0);
            System.out.println(ans);
        }


    }
}
