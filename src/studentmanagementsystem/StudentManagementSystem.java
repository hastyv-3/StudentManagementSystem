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
            System.out.println("5. Add Subject");
            System.out.println("6. Generate Report");
            System.out.println("7. Save Student Data to File");
            System.out.println("8. Load Student Data to File");
            System.out.println("9. Exit");
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
                    addSubject();
                    break;
                case 6:
                    generateReport();
                    break;
                case 7:
                    saveFile();
                    break;
                case 8:
                    loadFile();
                    break;
                case 9:
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
        System.out.println("Student successfully added.");

    }

    // removes student from HashMap given id
    private void removeStudent() {
        String input;

        System.out.println();
        System.out.println("***Remove Student***");
        System.out.println("Enter student's id: ");
        input = keyboard.nextLine();

        if (students.containsKey(input)) {
            students.remove(input);
            System.out.println("Student successfully removed.");
        } else {
            System.out.println("Student id not found.");
        }

    }

    // change's students name
    private void updateStudent() {
        String input;

        System.out.println("Enter student's id: ");
        input = keyboard.nextLine();

        if (students.containsKey(input)) {
            System.out.println("Enter student's new name: ");
            students.get(input).setName(keyboard.nextLine());
            System.out.println("Student record successfully updated.");
        } else {
            System.out.println("Student id not found.");
        }

    }

    // view student in HashMap given id
    private void viewStudent() {
        String input;

        System.out.println();
        System.out.println("***View Student***");
        System.out.println("Enter student's id: ");
        input = keyboard.nextLine();

        if (students.containsKey(input)) {
            System.out.println(students.get(input));
        } else {
            System.out.println("Student id not found.");
        }

    }

    private void addSubject() {
        String input;

        System.out.println();
        System.out.println("***Add Subject***");
        System.out.println("Enter student's id: ");
        input = keyboard.nextLine();

        if (students.containsKey(input)) {
            Student student = students.get(input);
            System.out.println("Enter subject name: ");
            input = keyboard.nextLine();

            if (!student.getSubjects().containsKey(input)) {
                student.getSubjects().put(input, new Subject(input));
            }

            Subject subject = student.getSubject(input);
            System.out.println("Enter subject grade: ");
            try {
                double grade = keyboard.nextDouble();
                subject.setGrade(grade);
                System.out.println("Grade successfully added.");
            } catch (InvalidGrade e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Student id not found.");
        }

    }

    private void generateReport() {

    }

    private void saveFile() {

    }

    private void loadFile() {

    }
}
