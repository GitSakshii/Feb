import java.util.ArrayList;
import java.util.List;


public class Server {
    private int serverId;//ID of the server
    private int serverSize;//Size of the server in MB
    List <File> files;
    public Server(int serverId,int serverSize){
        this.serverId=serverId;
        this.serverSize=serverSize;
        this.files=new ArrayList<>();
    }
    public int getServerId(){return serverId;}
    public void uploadFile(File file1)  {
        try {
            // Checking if there is enough free space on the server
            if (calculateFreeSpace() < file1.getFileSize()) {
                // Throwing exception if there is insufficient space
                throw new DFSException.NotenoughspaceException();
            }
            // Adding the file to the server and updating server size
            files.add(file1);
            serverSize -= file1.getFileSize();
        }catch (DFSException.NotenoughspaceException e){
            System.out.println( e.getMessage());
        }
    }

    public File getfile(String fileName){
        for(File f:files){
            if(f.getFileName().equals(fileName))return f;
        }
        return null;
    }
    public void downloadFile(String fileName)  {
        for (File file : files) {
            if (file.getFileName().equals(fileName)) {
                System.out.println("File is Downloaded");
                return;
            }
        }
        System.out.println("Not downloaded");
    }

    // Method to replicate a file from this server to another server
    public void replicateFile(File file, Server destinationServer)  {
        System.out.println("File Replicated");
        destinationServer.uploadFile(file);
    }

    // Method to calculate the free space on the server
    public int calculateFreeSpace() {
        int usedSpace = 0;
        for (File file : files) {
            usedSpace += file.getFileSize();
        }
        return serverSize - usedSpace;
    }
}
