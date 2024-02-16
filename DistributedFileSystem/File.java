public class File {
    String fileName;//Name of the file
    int fileSize;//Size of the file
    Boolean isReplicated;//indicates whether the file is replicated
    // Constructor to initialize the file attributes
    public File(String fileName, int fileSize, boolean isReplicated) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.isReplicated = isReplicated;
    }

    // Method to get the size of the file
    public int getFileSize() {
        return fileSize;
    }

    // Method to get the name of the file
    public String getFileName() {
        return fileName;
    }



}
