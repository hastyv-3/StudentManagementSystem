package studentmanagementsystem;

import java.util.HashMap;

/**
 *
 * @author Stephen
 */
public class Student {

    private String id;
    private String name;
    private HashMap<String, Subject> subjects;

    public Student(String i, String n) {
        id = i;
        name = n;
        subjects = new HashMap<>();

    }

    /*
     * Mutator methods
     */
    public void setName(String n) {
        name = n;
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

    public HashMap<String, Subject> getSubjects() {
        return subjects;
    }
    
    public Subject getSubject(String s) {
        return subjects.get(s);
    }
    
    /*
     * Calculations
     */
    // Average grade
    public double calculateAverageGrade() {
        double sum = 0;
        for (Subject s: subjects.values()) {
            sum += s.getGrade();
        }
        
        return sum / subjects.size();
    }
    
    public double getHighestGrade() {
        double high = 0;
        for (Subject s: subjects.values()) {
            if (s.getGrade() > high) {
                high = s.getGrade();
            }
        }
        
        return high;
    }
    
    public double getLowestGrade() {
        double low = 101;
        for (Subject s: subjects.values()) {
            if (s.getGrade() < low) {
                low = s.getGrade();
            }
        }
        
        return low;
    }
    @Override
    public String toString() {
        return "ID: " + this.id + "\nName: " + this.name;
    }
    
}
