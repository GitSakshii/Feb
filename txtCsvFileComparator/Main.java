import java.io.IOException;
import java.util.List;
import java.util.Scanner;

// Main class to run the file comparison program
public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        FileComparator fileComparator =new FileComparator();
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Compare Text Files");
            System.out.println("2. Compare CSV Files");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    compareTextFilesOption(fileComparator, scanner);
                    break;
                case 2:
                    compareCSVFilesOption(fileComparator, scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

    }
    private static void compareTextFilesOption(FileComparator f, Scanner scanner) {
        System.out.println("Comparing Text Files:");
        System.out.println("Default File Paths:");
        System.out.println("Original Text File: E:/txtfile1.txt");
        System.out.println("Comparison Text File: E:/txtfile2.txt");
        System.out.print("Do you want to use default paths? (Y/N): ");
        char choice = scanner.next().charAt(0);

        String originalTextFile, comparisonTextFile;
        if (choice=='Y')  {
            originalTextFile = "E:/txtfile1.txt";
            comparisonTextFile = "E:/txtfile2.txt";
        } else {
            System.out.print("Enter path for Original Text File: ");
            originalTextFile = scanner.nextLine();
            System.out.print("Enter path for Comparison Text File: ");
            comparisonTextFile = scanner.nextLine();
        }

        f.compareTextFiles(originalTextFile, comparisonTextFile);
    }

    private static void compareCSVFilesOption(FileComparator f, Scanner scanner) {
        System.out.println("Comparing CSV Files:");
        System.out.println("Default File Paths:");
        System.out.println("Original CSV File: E:/csvFile1.csv");
        System.out.println("Comparison CSV File: E:/csvFile2.csv");
        System.out.print("Do you want to use default paths? (Y/N): ");
        char choice = scanner.next().charAt(0);

        String originalCSVFile, comparisonCSVFile,ignoreColumn;
        if (choice=='Y') {
            originalCSVFile = "E:/csvFile1.csv";
            comparisonCSVFile = "E:/csvFile2.csv";
            ignoreColumn="Salary";
        } else {
            System.out.print("Enter path for Original CSV File: ");
            originalCSVFile = scanner.nextLine();
            System.out.print("Enter path for Comparison CSV File: ");
            comparisonCSVFile = scanner.nextLine();
            System.out.println("Enter the Column to be ignored");
            ignoreColumn=scanner.nextLine();
        }

        try {
            int ignoreColumnIndex=10;
          List<String> Content= f.readFile(originalCSVFile);
          String[] Column=Content.get(0).split(" ");
          for(int word=0;word<Column.length;word++){
              if(Column[word].equals(ignoreColumn))
              {
                  ignoreColumnIndex=word;
              }
          }
            f.compareCSVfiles(originalCSVFile, comparisonCSVFile,ignoreColumnIndex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}