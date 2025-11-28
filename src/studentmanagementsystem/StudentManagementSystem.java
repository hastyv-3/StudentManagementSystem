package studentmanagementsystem;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Stephen
 */
public class StudentManagementSystem {

    private HashMap<String, Student> students;
    private Scanner keyboard;

    public StudentManagementSystem() {
        students = new HashMap<String, Student>();
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

    // adds student to HashMap with id being key
    private void addStudent() {
        String input1;
        String input2;
        
        System.out.println();
        System.out.println("***Add Student***");
        System.out.println("Enter student's name: ");
        input1 = keyboard.nextLine();
        
        System.out.println("Enter student's id: ");
        input2 = keyboard.nextLine();
        
        students.put(input2, new Student(input2, input1));

    }

    // removes student from HashMap given id
    private void removeStudent() {
        String input;
        
        System.out.println();
        System.out.println("***Remove Student***");
        System.out.println("Enter student's id: ");
        input = keyboard.nextLine();
        
        students.remove(input);

    }

    private void updateStudent() {

    }

    // view student in HashMap given id
    private void viewStudent() {
        String input;
        
        System.out.println();
        System.out.println("***View Student***");
        System.out.println("Enter student's id: ");
        input = keyboard.nextLine();
        
        System.out.println(students.get(input));

    }

    private void generateReport() {

    }

    private void saveFile() {

    }

    private void loadFile() {

    }
}
