package studentmanagementsystem;

/**
 *
 * @author Stephen
 */
public class Subject {
    
    private String name;
    private double grade;
    
    public Subject() {
        
    }
    
    /*
     * Mutator methods
     */
    public void setName(String n) {
        name = n;
    }
    
    public void setGrade(double g) {
        grade = g;
    }
    
    /*
     * Accesor methods
     */
    public String getName() {
        return name;
    }
    
    public double getGrade() {
        return grade;
    }

}
