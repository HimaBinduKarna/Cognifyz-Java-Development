import java.util.Scanner;

public class grade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of grades
        System.out.print("Enter the number of grades: ");
        int numberOfGrades = scanner.nextInt();

        // Validate that the number of grades is greater than 0
        if (numberOfGrades <= 0) {
            System.out.println("Please enter a valid number of grades greater than 0.");
            return;
        }

        // Initialize variables
        int totalGrades = 0;

        // Loop to input each grade
        for (int i = 1; i <= numberOfGrades; i++) {
            System.out.print("Enter grade #" + i + ": ");
            int grade = scanner.nextInt();

            // Validate that the grade is between 0 and 100
            if (grade < 0 || grade > 100) {
                System.out.println("Please enter a valid grade between 0 and 100.");
                return;
            }

            totalGrades += grade;
        }

        // Calculate and display the average
        double average = (double) totalGrades / numberOfGrades;
        System.out.println("The average grade is: " + average);

        // Close the scanner
        scanner.close();
    }
}
