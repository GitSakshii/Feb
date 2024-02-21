import java.io.*;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
     private static final String file_name="C:/Users/HP/Downloads/employees.csv";
     private static final File outputfile=new File("outputfile.csv");
    public static void main(String[] args) {

       try
       {
           // Create a new file if it doesn't exist
           if (outputfile.createNewFile()){
               System.out.println("File created: " + file_name);
           }
           List<Employee>employees=readEmployeeData(file_name);
           if(employees.isEmpty()){
               System.out.println("No data found in input file");
               return;
           }
           System.out.println("All Employees data");
           for(Employee e:employees){
               System.out.println(e.getName()+","+e.getSalary());
           }
           double averageSalary=averageSalaryCalculation(employees);
           System.out.println(averageSalary);
           WriteEmployeedata(employees,averageSalary);


       }catch (IOException e){
           e.printStackTrace();
       }

    }
    private static List<Employee> readEmployeeData(String file_name)throws IOException{
       List<Employee>employees=new ArrayList<>();

        BufferedReader br=new BufferedReader(new FileReader(file_name));
        String line=br.readLine();
        while((line=br.readLine())!=null){

           String[] employee=line.split(",");

           if(employee.length==11) {
               String name = employee[1];
               try{
               double salary = Double.parseDouble(employee[7].trim());

               employees.add(new Employee(name,salary));
               } catch (NumberFormatException ex) {
                   System.err.println("Invalid salary format for employee: " + name);
               }
           }
           else {
               System.out.println("Invalid data format in csv");
           }

        }
        return employees;
    }
    private static double averageSalaryCalculation(List<Employee>employees){
        double sum=0;
        int NumberOfEmployees=0;
        for (Employee e:employees){
           sum=sum+e.getSalary();
           NumberOfEmployees++;
        }
        return sum/NumberOfEmployees;
    }
    private static void WriteEmployeedata(List<Employee>employees,double average)throws IOException{
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(outputfile))) {
         for (Employee e:employees){
             if(e.getSalary()>average){
             writer.write(e.getName()+","+e.getSalary());
             writer.newLine();}
         }
        }
    }
}
