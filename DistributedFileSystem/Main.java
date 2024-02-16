import java.sql.Statement;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        DFSSystem d=new DFSSystem();
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
      while(true){
          System.out.println("   Menu");
          System.out.println("   1.Add Server");
          System.out.println("   2.Upload File");
          System.out.println("   3.Download File");
          System.out.println("   4.Replicate File");
          System.out.println("   5.Calculate free Space");
          System.out.println("   6.exit");
          int ch=sc.nextInt();
          switch (ch){
              case 1:
                  d.addServer(sc);
                  break;
              case 2:
                  d.uploadFile(sc);
                  break;
              case 3:
                  d.downloadFile(sc);
                  break;
              case 4:
                  d.replicateFile(sc);
                  break;
              case 5:
                  sc.nextLine();
                  System.out.println("Enter Server ID");
                  int id=sc.nextInt();
                  sc.nextLine();
                  for(Server s: d.server){
                      if(s.getServerId()==id){
                          System.out.println( s.calculateFreeSpace());
                          break;
                      }
                  }
                  break;
              case 6:
                  System.out.println("Exiting...");
                  sc.close();
                  System.exit(0);
              default:
                  System.out.println("Enter valid option");
          }
      }
    }
}
