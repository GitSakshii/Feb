import java.io.Serializable;
/**
 * This class represents a Student with a name and marks.
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String Name ;
    private int Marks;
    // Constructor
    Student(String Name,int marks){
       this.Name=Name;
       this.Marks= marks;
    }
    public String getName(){
        return Name;
    }
    public int getMarks(){
        return Marks;
    }
    void display (){
        System.out.println("Name: " + getName()+" "+"Marks: "+getMarks());

    }

}
