package studentmanagementsystem;

/**
 *
 * @author Stephen
 */
public class Subject {
    
    private String name;
    private double grade;
    
    public Subject(String n) {
        name = n;
    }
    
    /*
     * Mutator methods
     */
    public void setName(String n) {
        name = n;
    }
    
    public void setGrade(double g) throws InvalidGrade {
        if ( g < 0 || g > 100) {
            throw new InvalidGrade();
        } else {
            grade = g;
            System.out.println("Grade successfully updated.");
        }
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
    
    @Override
    public String toString() {
        return name + ": " + String.format("%.2f", grade);
    }

}
