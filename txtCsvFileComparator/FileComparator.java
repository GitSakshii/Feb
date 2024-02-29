import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FileComparator {
    //Function to compare two text Files line by line and word by word
    public void compareTextFiles(String OriginalFile,String ComparisonFile){
        // Read content of both files
        List<String> OriginalTextFile=readFile(OriginalFile);
        List<String> ComparisonTextFile=readFile(ComparisonFile);
        // Iterate through each line of both files
        for(int line=0;line<OriginalTextFile.size();line++){
            String OriginalLine=OriginalTextFile.get(line);
            String ComparisonLine=ComparisonTextFile.get(line);
            // Compare lines
            if(!OriginalLine.equals(ComparisonLine))
            {
               String[] WordsInOriginal=OriginalLine.split(" ");
               String[] WordsInComparison=ComparisonLine.split(" ");
                // Iterate through each word of the lines and compare
                for(int word=0;word<Math.min(WordsInOriginal.length, WordsInComparison.length);word++){
                   if(!WordsInOriginal[word].equals(WordsInComparison[word])){
                       System.out.println(" Sentence "+(line+1)+ " Error in Word :"+(word+1)+"("+WordsInOriginal[word]+","+WordsInComparison[word]+")");
                   }
               }
            }

        }
    }
    // Function to read content of a file
    public List<String> readFile(String filePath)
    {
        List<String>lines=new ArrayList<>();
        try{
            BufferedReader reader=new BufferedReader(new FileReader(filePath));
            String paragraph;
            // Read each paragraph of the file
            while((paragraph=reader.readLine())!=null)
            {
                String[] line=paragraph.split("\\.");
                lines.addAll(Arrays.asList(line));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return lines;
    }
    // Function to compare two CSV files
    public void compareCSVfiles(String OriginalCsv,String ComparatorCsv,int ignoreColumn)throws IOException{
        // Get current date and time for result file naming
        String formattedDateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH_mm_ss"));
        Boolean isDifferent=false;
        String resultfile="E:/result";
        resultfile=resultfile+formattedDateTime+".csv";
        // Read content of both CSV files
        List<String> OriginalFileContent = readCSVfile(OriginalCsv);
        List<String> ComparisonFileContent = readCSVfile(ComparatorCsv);
        // Compare each row of the files
        for (int row = 0; row < ComparisonFileContent.size(); row++) {
            String line1 = OriginalFileContent.get(row);
            String line2 = ComparisonFileContent.get(row);
            // If any difference is found, set the flag to true and break the loop
            if (!line1.equals(line2)) {
                isDifferent = true;
                break; // Exit the loop once a difference is found
            }
        }
        // If there are differences, generate result file
        if(isDifferent) {
            String[] ColumnName = OriginalFileContent.get(0).split(",");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultfile, true))) {
                writer.write("Row and Column"+","+"Actual Content"+","+"Expected Content");
                writer.newLine();
                for (int row = 1; row < ComparisonFileContent.size(); row++) {
                    if(row==ignoreColumn){
                        continue;
                    }
                    String line1 = OriginalFileContent.get(row);
                    String line2 = ComparisonFileContent.get(row);
                    if (!line1.equals(line2)) {
                        String[] words1 = line1.split(",");
                        String[] words2 = line2.split(",");
                        for (int j = 0; j < Math.min(words1.length, words2.length); j++) {
                            if (!words1[j].equals(words2[j])) {
                                writer.write( (row + 1) +" and "+ColumnName[j] + "," + words1[j] + "," + words2[j]);
                                writer.newLine();
                            }
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else {
            System.out.println("Both Files are same!!");
        }
    }

    public List<String> readCSVfile(String file)throws IOException{
        List <String>rows=new ArrayList<>();
        BufferedReader br=new BufferedReader(new FileReader(file));
        String line;
        while((line=br.readLine())!=null){
           rows.add(line);
        }
        return rows;
    }
}
