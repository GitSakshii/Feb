

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class LinkedList {
    Node head; // head of list

    // Linked list Node.
    // This inner class is made static
    // so that main() can access it
    static class Node {

        char data;
        Node next;

        // Constructor
        Node(char d)
        {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String:");
        String str=sc.nextLine();
        int n=str.length();
        Node newnode=new Node(str.charAt(0));
        list.head=newnode;
        int i=1;
        Node Last=list.head;
        while(i<n){
            newnode=new Node(str.charAt(i));
            Last.next=newnode;
            Last=Last.next;
            i++;

        }
        System.out.println("Start Index and End Index");
        int start=sc.nextInt();
        int end=sc.nextInt();
        int dif=end-start-1;
        LinkedList slice=new LinkedList();
        Node temp=list.head;

        while(start!=0){
           temp=temp.next;
           start--;
        }
        slice.head=temp;
        Node last=temp;
        while(dif!=0){
            last=temp.next;
            temp=temp.next;
           dif--;
        }
        last.next=null;
        printList(slice);
    }
    public static void printList(LinkedList list)
    {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + "");

            // Go to next node
            currNode = currNode.next;
        }
    }
}
