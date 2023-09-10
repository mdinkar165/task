import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of grades: ");
        int numGrades = scanner.nextInt();

        if (numGrades <= 0) {
            System.out.println("Please enter a valid number of grades.");
            return;
        }

        double[] grades = new double[numGrades];
        double total = 0.0;

        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade #" + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
            total += grades[i];
        }

        double average = total / numGrades;

        System.out.println("Grades entered:");
        for (int i = 0; i < numGrades; i++) {
            System.out.println("Grade #" + (i + 1) + ": " + grades[i]);
        }

        System.out.println("Average grade: " + average);

        scanner.close();
    }
}
