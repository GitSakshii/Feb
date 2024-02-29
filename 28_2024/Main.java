import java.util.Scanner;
import java.util.Stack;

public class Main {
  //Funciton to simplify the given Unix-style file path
    public static String simplifyPath(String path) {
        //Split the path by "/"
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<>();
        //Traverse through each directory in the path
        for (String dir : dirs) {
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!dir.equals("") && !dir.equals(".")) {
                stack.push(dir);
            }
        }
        //If the stack is empty return "/"
        if (stack.isEmpty()) {
            return "/";
        }

        String ans= "";
        for (String dir : stack) {
            ans+="/"+dir;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String path= sc.nextLine();
        System.out.println(simplifyPath(path));
    }
}
