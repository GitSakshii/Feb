import java.util.*;

public class DFSSystem {
    List<Server> server;
    DFSSystem(){
        this.server=new ArrayList<>();
    }
    // Method to add a server to the DFS system
    public void addServer(Scanner sc) {
        // Adding the server to the list of servers
        System.out.println("Enter Server ID");
        int serverId=sc.nextInt();
        System.out.println("Enter Server Size");
        int serverSize=sc.nextInt();
        Server server1=new Server(serverId,serverSize);
        server.add(server1);
        // Printing a success message
        System.out.println("Server added successfully");
    }

    // Method to upload a file to a specific server in the DFS system
    public void uploadFile(Scanner sc)  {
        try {
            sc.nextLine();
            System.out.println("Enter file name:");
            String fileName = sc.nextLine();
            System.out.println("Enter file Size");
            int size = sc.nextInt();
            sc.nextLine();
            File f = new File(fileName, size, false);
            System.out.println("Enter Server id");
            int id = sc.nextInt();
            sc.nextLine();
            int check=0;
            // Checking if the server exists in the system
            for (Server s : server) {
                if (s.getServerId() == id) {
                    check=1;
                    s.uploadFile(f);
                    System.out.println("File Uploaded Successfully");
                    break;
                }
            }
            if(check==0)throw new DFSException.ServerdoesnotexistException();
        }catch(DFSException.ServerdoesnotexistException e){
            System.out.println(e.getMessage());
        }
    }

    // Method to download a file from a specific server in the DFS system
    public void downloadFile(Scanner sc) {
        System.out.println("Enter Server ID");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter File Name");
        String fileName=sc.nextLine();
        for(Server s:server){
            if(s.getServerId()==id){
                s.downloadFile(fileName);
            }
        }


    }

    // Method to replicate a file from a source server to a destination server in the DFS system
    public void replicateFile(Scanner sc)  {
        try {
            System.out.println("Enter Source Server ID");
            int sourceServer = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Destination Server ID");
            int destinationServer = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter File Name");

            String fileName = sc.nextLine();
            Server s1 = null;
            Server s2 = null;
            File F = null;
            // Iterating through all servers in the system
            for (Server s : server) {
                // Checking if the source server exists in the system
                if (s.getServerId() == sourceServer) {
                    s1 = s;
                    // Checking if the file exists on the source server

                    if (s.getfile(fileName) != null) {
                        F = s.getfile(fileName);
                    }

                }
                // Checking if the destination server exists in the system
                if (s.getServerId() == destinationServer) {
                    s2 = s;

                }
            }
            // Handling different scenarios based on server and file existence
            if (s1 == null||s2==null) {
                // Throwing exception if the source server or destination server does not exist
                throw new DFSException.ServerdoesnotexistException();
            } else if (F != null) {
                // Replicating the file to the destination server if both servers and file exist
                s1.replicateFile(F, s2);
            } else {
                // Throwing exception if the file does not exist on the source server
                throw new DFSException.Filedoesnotexist();
            }
        }catch (DFSException.ServerdoesnotexistException|DFSException.Filedoesnotexist e){
            System.out.println(e.getMessage());
        }
    }
}
