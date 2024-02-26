
package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.FileReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

// Class to compare text files and XML files
public class FileComparator {
    // Method to compare text files
    public void compareTextFiles(String file1, String file2) {
        // Read words from both files
        Set<String> wordsInFile1 = readFileWords(file1);
        Set<String> wordsInFile2 = readFileWords(file2);

        // Find words unique to each file
        Set<String> uniqueToFirstFile = new HashSet<>(wordsInFile1);
        uniqueToFirstFile.removeAll(wordsInFile2);

        Set<String> uniqueToSecondFile = new HashSet<>(wordsInFile2);
        uniqueToSecondFile.removeAll(wordsInFile1);

        // Print unique words for each file
        System.out.println("Words unique to " + file1 + ": " + uniqueToFirstFile);
        System.out.println("Words unique to " + file2 + ": " + uniqueToSecondFile);
    }

    // Method to read words from a text file
    private Set<String> readFileWords(String fileName) {
        Set<String> words = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Read each line and split into words
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                // Add words to set
                for (String word : lineWords) {
                    words.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

   
}
