import java.io.*;
import java.util.*;

public class RecordManager {
    // Method to add a new student
    public void AddStudents(Scanner sc){
        sc.nextLine();
        System.out.println("Enter Student Name");
        String name=sc.nextLine();
        System.out.println("Enter marks");
        int marks=sc.nextInt();
        sc.nextLine();
        Student student=new Student(name,marks);
        List<Student> students=readListFromFile();
        students.add(student);
        updateListInFile(students);
        System.out.println("Student added!!");
    }
    // Method to display all students
    public void displayStudents(){
        List<Student>students=readListFromFile();
     for(Student st:students){
         st.display();
     }
    }
    // Method to read students from file
    public  List<Student> readListFromFile(){
        List<Student> students = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Main.file_name))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof Student) {
                        Student student = (Student) obj;
                        students.add(student);}
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }
    public void updateListInFile(List<Student>students){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Main.file_name))) {
            for (Student student : students) {
                oos.writeObject(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sortStudentsByMarks() {
        List<Student> students = readListFromFile();
        Collections.sort(students, Comparator.comparingInt(Student::getMarks));
        System.out.println("Students sorted by marks:");
        for (Student student : students) {
            student.display();
        }
    }

}
