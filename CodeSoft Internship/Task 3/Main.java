import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nRoll Number: " + rollNumber + "\nGrade: " + grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return students;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem studentManagementSystem = new StudentManagementSystem();

        while (true) {
            System.out.println("Student Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    Student newStudent = new Student(name, rollNumber, grade);
                    studentManagementSystem.addStudent(newStudent);
                    break;
                case 2:
                    System.out.print("Enter the roll number of the student to remove: ");
                    int rollToRemove = scanner.nextInt();
                    studentManagementSystem.removeStudent(rollToRemove);
                    break;
                case 3:
                    System.out.print("Enter the roll number of the student to search for: ");
                    int rollToSearch = scanner.nextInt();
                    Student foundStudent = studentManagementSystem.searchStudent(rollToSearch);
                    if (foundStudent != null) {
                        System.out.println("Student found:\n" + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    List<Student> allStudents = studentManagementSystem.getAllStudents();
                    if (allStudents.isEmpty()) {
                        System.out.println("No students in the system.");
                    } else {
                        System.out.println("All Students:");
                        for (Student student : allStudents) {
                            System.out.println(student + "\n");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Exiting Student Management System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
