import jdk.dynalink.beans.StaticClass;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents the main entry point of the program.
 */
public class Main {
    // File to store student records
    static File file_name=new File("file.txt");
    public static void main(String[] args) {

        try {
            // Create a new file if it doesn't exist
            if (file_name.createNewFile()){
                System.out.println("File created: " + file_name);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        Scanner sc=new Scanner(System.in);
        // Create a RecordManager object to manage student records

        RecordManager r=new RecordManager();
        while(true){
            System.out.println("          Menu");
            System.out.println("   1.Add Students");
            System.out.println("   2.Display students");
            System.out.println("   3.Sort Students by marks");
            System.out.println("   4.Exit");
            char ch=sc.next().charAt(0);
            switch (ch){
                case '1':
                    r.AddStudents(sc);
                    break;
                case '2':
                    r.displayStudents();
                    break;
                case '3':
                    r.sortStudentsByMarks();
                    break;
                case '4':
                    sc.close();
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice. Please Try again!!");


            }

        }
    }
}
