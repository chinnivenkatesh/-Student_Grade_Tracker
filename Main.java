import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    static class Student {
    String name;
    ArrayList<Integer> grades;

    Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    void addGrade(int grade) {
        grades.add(grade);
    }

    double getAverage() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
        return (double) sum / grades.size();
    }

    int getHighest() {
        if (grades.isEmpty()) return 0;
        int high = grades.get(0);
        for (int g : grades) {
            if (g > high) high = g;
        }
        return high;
    }

    int getLowest() {
        if (grades.isEmpty()) return 0;
        int low = grades.get(0);
        for (int g : grades) {
            if (g < low) low = g;
        }
        return low;
    }
}
    public static void main(String[] args) {
        boolean run = true;
        System.out.println("🎓 Welcome to Student Grade Tracker");

        while (run) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student and Grades");
            System.out.println("2. Show Summary Report");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    showSummary();
                    break;
                case 3:
                    run = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = new Student(name);

        System.out.print("Enter number of grades: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter grade #" + (i + 1) + ": ");
            int grade = scanner.nextInt();
            student.addGrade(grade);
        }

        students.add(student);
        System.out.println(" Student added successfully!");
    }

    static void showSummary() {
        if (students.isEmpty()) {
            System.out.println(" No students added yet.");
            return;
        }

        System.out.println("\n Student Summary Report:");
        for (Student s : students) {
            System.out.println("\nStudent: " + s.name);
            System.out.println("Grades: " + s.grades);
            System.out.printf("Average: %.2f\n", s.getAverage());
            System.out.println("Highest Grade: " + s.getHighest());
            System.out.println("Lowest Grade: " + s.getLowest());
        }
    }
}
