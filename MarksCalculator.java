import java.util.Scanner;

public class MarksCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Define subjects and take marks input
        String[] subjects = {"Math", "Science", "English", "History", "Geography"};
        double[] marks = new double[subjects.length];

        for (int i = 0; i < subjects.length; i++) {
            marks[i] = getValidMark(scanner, subjects[i]);
        }

        // Step 2: Calculate total marks
        double totalMarks = calculateTotal(marks);

        // Step 3: Calculate average percentage
        double averagePercentage = totalMarks / subjects.length;

        // Step 4: Determine grade
        String grade = determineGrade(averagePercentage);

        // Step 5: Display results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    // Method to get valid marks for each subject (0-100)
    private static double getValidMark(Scanner scanner, String subject) {
        double mark;
        while (true) {
            System.out.print("Enter marks for " + subject + " (out of 100): ");
            mark = scanner.nextDouble();
            if (mark >= 0 && mark <= 100) {
                break;
            } else {
                System.out.println("Please enter a mark between 0 and 100.");
            }
        }
        return mark;
    }

    // Method to calculate the total marks
    private static double calculateTotal(double[] marks) {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total;
    }

    // Method to determine grade based on average percentage
    private static String determineGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else if (averagePercentage >= 50) {
            return "E";
        } else {
            return "F";
        }
    }
}
