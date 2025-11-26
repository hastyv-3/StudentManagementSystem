package studentmanagementsystem;

import java.util.ArrayList;

/**
 *
 * @author Stephen
 */
public class Student {

    private String id;
    private String name;
    private double[] grades;
    private ArrayList<Subject> subjects;

    public Student() {

    }

    /*
     * Mutator methods
     */
    public void setId(String i) {
        id = i;
    }

    public void setName(String n) {
        name = n;
    }

    public void setGrades(double[] g) {
        grades = g;
    }

    public void setSubjects(ArrayList<Subject> s) {
        subjects = s;
    }
    
    /*
     * Accessor methods
     */
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double[] getGrades() {
        return grades;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
}
