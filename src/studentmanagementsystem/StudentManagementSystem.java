package studentmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Stephen
 */
public class StudentManagementSystem {
    private ArrayList<Student> students;
    private Scanner keyboard;
    
    public StudentManagementSystem() {
        
    }
    
    /*
     * Mutator methods
     */
    public void setStudents(ArrayList<Student> s) {
        students = s;
    }
    
    /*
     * Accessor methods
     */    
    public ArrayList<Student> getStudents() {
       return students;
    }
}
