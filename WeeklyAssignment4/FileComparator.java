
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

    // Method to compare XML files
    public void compareXMLFiles(String xmlPath1, String xmlPath2) {
        try {
            // Parse the first XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc1 = builder.parse(new File(xmlPath1));

            // Parse the second XML file
            Document doc2 = builder.parse(new File(xmlPath2));

            // Compare the documents
            compareNodes(doc1.getDocumentElement(), doc2.getDocumentElement());

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    // Recursive method to compare nodes in XML files
    private static void compareNodes(Node node1, Node node2) {
        // Compare node names
        if (!node1.getNodeName().equals(node2.getNodeName())) {
            System.out.println("Different node name: " + node1.getNodeName() + " vs " + node2.getNodeName());
        }

        // Compare text content of nodes
        String textContent1 = node1.getTextContent().trim();
        String textContent2 = node2.getTextContent().trim();
        if (!textContent1.equals(textContent2)) {
            System.out.println("Different text content for node " + node1.getNodeName() + ": " + textContent1 + " vs " + textContent2);
        }

        // Compare child nodes
        NodeList children1 = node1.getChildNodes();
        NodeList children2 = node2.getChildNodes();

        for (int i = 0; i < children1.getLength(); i++) {
            Node child1 = children1.item(i);
            if (child1.getNodeType() == Node.ELEMENT_NODE) {
                boolean found = false;
                for (int j = 0; j < children2.getLength(); j++) {
                    Node child2 = children2.item(j);
                    if (child2.getNodeType() == Node.ELEMENT_NODE && child1.getNodeName().equals(child2.getNodeName())) {
                        compareNodes(child1, child2); // Recursively compare child nodes
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Extra node in file1.xml: " + child1.getNodeName());
                }
            }
        }

        for (int i = 0; i < children2.getLength(); i++) {
            Node child2 = children2.item(i);
            if (child2.getNodeType() == Node.ELEMENT_NODE) {
                boolean found = false;
                for (int j = 0; j < children1.getLength(); j++) {
                    Node child1 = children1.item(j);
                    if (child1.getNodeType() == Node.ELEMENT_NODE && child2.getNodeName().equals(child1.getNodeName())) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Extra node in file2.xml: " + child2.getNodeName());


                }
            }
        }
    }
}