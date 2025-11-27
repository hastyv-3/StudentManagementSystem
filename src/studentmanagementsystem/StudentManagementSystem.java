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
        students = new ArrayList<Student>();
        keyboard = new Scanner(System.in);
    }

    public void start() {
        // controls while loop
        boolean inUse = true;
        int input;

        // print menu
        while (inUse) {
            System.out.println("===========================");
            System.out.println("|Student Management System|");
            System.out.println("===========================");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Update Student");
            System.out.println("4. View Student");
            System.out.println("5. Generate Report");
            System.out.println("6. Save Student Data to File");
            System.out.println("7. Load Student Data to File");
            System.out.println("8. Exit");
            System.out.println();
            System.out.print("Enter choice: ");

            input = keyboard.nextInt();
            keyboard.nextLine();

            switch (input) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    viewStudent();
                    break;
                case 5:
                    generateReport();
                    break;
                case 6:
                    saveFile();
                    break;
                case 7:
                    loadFile();
                    break;
                case 8:
                    inUse = false;
                    break;
            }

        }

    }

    private void addStudent() {

    }

    private void removeStudent() {

    }

    private void updateStudent() {

    }

    private void viewStudent() {

    }

    private void generateReport() {

    }

    private void saveFile() {

    }

    private void loadFile() {

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
