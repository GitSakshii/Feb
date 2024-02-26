package org.example;

// Main class for running file comparison
public class Main {
    public static void main(String[] args) {
        // Create an instance of FileComparator
        FileComparator f=new FileComparator();
        // Paths for text files and XML files to be compared
        String textFile1 = "E:/txtfile1.txt";
        String textFile2 = "E:/txtfile2.txt";
      //  String xmlFile1 = "E:/file1.xml";
        //String xmlFile2 = "E:/file2.xml";
        // Compare text files
        f.compareTextFiles(textFile1,textFile2);
        // Compare XML files
      //  f.compareXMLFiles(xmlFile1, xmlFile2);
    }
}
