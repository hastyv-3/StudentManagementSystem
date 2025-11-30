package studentmanagementsystem;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Stephen
 */
public class StudentManagementSystem {

    private HashMap<String, Student> students;
    private Scanner keyboard;
    private File file;

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

            String str = keyboard.nextLine();

            try {
                input = Integer.parseInt(str);
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
                        generateReports();
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
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number between 1-9");
            }

        }
    }
    // adds student to HashMap with id being key

    private void addStudent() {
        String input1;
        String input2;

        System.out.println();
        System.out.println("***Add Student***");
        System.out.print("Enter student's name: ");
        input1 = keyboard.nextLine();

        System.out.print("Enter student's id: ");
        input2 = keyboard.nextLine();

        students.put(input2, new Student(input2, input1));
        System.out.println("Student successfully added.");

    }

    // removes student from HashMap given id
    private void removeStudent() {
        String input;

        System.out.println();
        System.out.println("***Remove Student***");
        System.out.print("Enter student's id: ");
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

        System.out.print("Enter student's id: ");
        input = keyboard.nextLine();

        if (students.containsKey(input)) {
            System.out.print("Enter student's new name: ");
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
        System.out.print("Enter student's id: ");
        input = keyboard.nextLine();
        System.out.println();

        if (students.containsKey(input)) {
            System.out.println(students.get(input));
            System.out.println("=>Subjects<=");
            for (Subject subjectName : students.get(input).getSubjects().values()) {
                System.out.println(subjectName.getName() + ": " + subjectName.getGrade());
            }
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

    /*
     * REPORTS
     */
    private void generateReports() {
        boolean inReports = true;
        int input;

        while (inReports) {
            System.out.println();
            System.out.println("***Generate Reports***");
            System.out.println("1. Get student's average");
            System.out.println("2. Highest grade in subject");
            System.out.println("3. Lowest grade in subject");
            System.out.println("4. Students sorted by average");
            System.out.println("5. Back to main menu.");
            System.out.print("Enter choice: ");

            String str = keyboard.nextLine();

            try {
                input = Integer.parseInt(str);
                keyboard.nextLine();

                switch (input) {
                    case 1:
                        reportAverage();
                        break;
                    case 2:
                        reportHighest();
                        break;
                    case 3:
                        reportLowest();
                        break;
                    case 4:
                        reportAverageSorted();
                        break;
                    case 5:
                        inReports = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a number between 1-9");
            }
        }
    }

    private void reportAverage() {
        System.out.println();
        System.out.println("***Student Average***");
        System.out.print("Enter student ID: ");
        String input = keyboard.nextLine();

        if (students.containsKey(input)) {
            Student student = students.get(input);

            if (student.getSubjects().isEmpty()) {
                System.out.println("No grades on record.");
            } else {
                System.out.println("Student: " + student.getName());
                System.out.println("Average: " + student.calculateAverageGrade());
            }
        } else {
            System.out.println("Student ID not found.");
        }

    }

    private void reportHighest() {
        System.out.println();
        System.out.println("***Highest Grade in Subject***");
        System.out.print("Enter subject name: ");
        String input = keyboard.nextLine();

        double high = -1;
        Student topStudent = null;
        boolean found = false;

        for (Student s : students.values()) {
            if (s.getSubjects().containsKey(input)) {
                double grade = s.getSubject(input).getGrade();

                if (grade > high) {
                    high = grade;
                    topStudent = s;
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No grades to report in " + input);
        } else {
            System.out.println();
            System.out.println("***Report***");
            System.out.println("Highest grade in " + input + ": " + high);
            System.out.println(topStudent);
        }

    }

    private void reportLowest() {
        System.out.println();
        System.out.println("***Lowest Grade in Subject***");
        System.out.print("Enter subject name: ");
        String input = keyboard.nextLine();

        double low = 101;
        Student bottomStudent = null;
        boolean found = false;

        for (Student s : students.values()) {
            if (s.getSubjects().containsKey(input)) {
                double grade = s.getSubject(input).getGrade();

                if (grade < low) {
                    low = grade;
                    bottomStudent = s;
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No grades to report in " + input);
        } else {
            System.out.println();
            System.out.println("***Report***");
            System.out.println("Lowest grade in " + input + ": " + low);
            System.out.println(bottomStudent);
        }

    }

    private void reportAverageSorted() {
        System.out.println();
        System.out.println("***Students Sorted by Average***");

        if (students.isEmpty()) {
            System.out.println("No students on file.");
        } else {
            ArrayList<Student> list = new ArrayList<>();
            for (Student s : students.values()) {
                list.add(s);
            }

            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    double avg1 = list.get(i).calculateAverageGrade();
                    double avg2 = list.get(j).calculateAverageGrade();

                    if (avg2 > avg1) {
                        Student temp = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, temp);
                    }
                }
            }
            for (Student s : list) {
                System.out.println("Name: " + s.getName() + " | Average: " + String.format("%.2f", s.calculateAverageGrade()));

            }
        }

    }

    private void saveFile() {
        if (!students.isEmpty()) {
            try {
                PrintWriter outputFile = new PrintWriter("students.txt");
                for (Student s : students.values()) {
                    if (s.getSubjects().isEmpty()) {
                        outputFile.println(s.getId() + "," + s.getName());
                    } else {
                        for (String subjectName : s.getSubjects().keySet()) {
                            Subject subject = s.getSubjects().get(subjectName);
                            outputFile.println(s.getId() + "," + s.getName() + "," + subject.getName() + "," + subject.getGrade());
                        }
                    }
                }
                System.out.println("Student data successfully saved.");
                outputFile.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
        } else {
            System.out.println("No student data to save.");

        }
    }

    /*
     * File Handling
     */
    private void loadFile() {
        try {
            File file = new File("students.txt");
            Scanner inputFile = new Scanner(file);

            students.clear();
            while (inputFile.hasNextLine()) {
                String inputLine = inputFile.nextLine();

                String[] tokens = inputLine.split(",");

                String id = tokens[0];
                String name = tokens[1];

                Student student;
                if (students.containsKey(id)) {
                    student = students.get(id);

                } else {
                    student = new Student(id, name);
                    students.put(id, student);
                }

                String subjectName = tokens[2];
                double grade = Double.parseDouble(tokens[3]);

                Subject subject;
                if (student.getSubjects().containsKey(subjectName)) {
                    subject = student.getSubject(subjectName);
                } else {
                    subject = new Subject(subjectName);
                    student.getSubjects().put(subjectName, subject);
                }

                subject.setGrade(grade);

            }
            System.out.println("Student data successfully loaded.");
            inputFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");

        } catch (InvalidGrade e) {
            System.out.println("Error: grade should be between 0-100");
        }

    }
}
