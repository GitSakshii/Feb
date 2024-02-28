import java.util.*;

public class restoreTree {
   static public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
     public TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }
  }
    public static void setValues(TreeNode root, Vector<Integer> arr, int[]index){

        if(root==null)return;
        setValues(root.left,arr,index);
        root.val=arr.get(index[0]);
        index[0]++;
        setValues(root.right,arr,index);
    }
    static public void inorderTraversal(TreeNode root,Vector<Integer>arr){
        if(root==null)return;
        inorderTraversal(root.left,arr);
        arr.add(root.val);
        inorderTraversal(root.right,arr);

    }
    //Method to print the elements of tree using inorder traversal
    static void inorder(TreeNode temp)
    {
        if (temp == null)
            return;

        inorder(temp.left);
        System.out.print(temp.val+ " ");
        inorder(temp.right);
    }
    static TreeNode root;
    static TreeNode temp = root;
    static void insert(TreeNode temp,int key)
    {
        if(temp==null){
            root=new TreeNode(key);
            return;
        }
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(temp);
        while(!q.isEmpty()){
            temp=q.peek();
            q.remove();
            if (temp.left == null) {
                temp.left = new TreeNode(key);
                break;
            }
            else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new TreeNode(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of elements in tree:");
        int n=sc.nextInt();
        System.out.println("Enter tree elements");

        for(int i=0;i<n;i++){
         int key=sc.nextInt();
         insert(root,key);
        }
       inorder(root);
        Vector<Integer>arr=new Vector<Integer>();
        inorderTraversal(root,arr);
        //before Restoring
        inorder(root);
        Collections.sort(arr);
        int[] index={0};
        setValues(root,arr,index);
        System.out.println();
        //After restoring
        inorder(root);
    }
}
