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
        subjects = new HashMap<String, Subject>();

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
    // Adding a subject to students schedule
    public void addSubject(String subject, double grade) {
        subjects.put(subject, new Subject(subject, grade));
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
    
}
