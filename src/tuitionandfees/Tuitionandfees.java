package tuitionandfees;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Tuitionandfees{
    public static void main(String[] args) {
        // Constants
        final double TUITION_BASE = 40720;
        final double PER_CREDIT_COST = 1280;
        final int CREDIT_THRESHOLD = 18;
        final int MIN_CREDIT_FULL_TUITION = 12;
        final int HEALTH_FEE_CREDITS = 9;
        final int STUDENT_SERVICE_FEE_CREDITS = 6;
        final double HEALTH_SERVICE_FEE = 310;
        final double STUDENT_SERVICE_FEE = 300;
        final double TECHNOLOGY_FEE = 448;

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of credits you are taking this semester: ");
        int credits = scanner.nextInt();

        // Calculate tuition
        double tuition;
        if (credits >= MIN_CREDIT_FULL_TUITION && credits <= CREDIT_THRESHOLD) {
            tuition = TUITION_BASE;
        } else if (credits > CREDIT_THRESHOLD) {
            tuition = TUITION_BASE + (credits - CREDIT_THRESHOLD) * PER_CREDIT_COST;
        } else {
            tuition = credits * PER_CREDIT_COST;
        }

        // Calculate fees
        double healthServiceFee = (credits >= HEALTH_FEE_CREDITS) ? HEALTH_SERVICE_FEE : 0;
        double studentServiceFee = (credits >= STUDENT_SERVICE_FEE_CREDITS) ? STUDENT_SERVICE_FEE : 0;
        double technologyFee = TECHNOLOGY_FEE;  // All students are charged this fee

        // Calculate total cost
        double totalCost = tuition + healthServiceFee + studentServiceFee + technologyFee;

        // Format output with commas
        DecimalFormat df = new DecimalFormat("#,###.00");

        // Output the results
        System.out.println("Tuition: $" + df.format(tuition));
        System.out.println("Health Service Fee: $" + df.format(healthServiceFee));
        System.out.println("Student Service Fee: $" + df.format(studentServiceFee));
        System.out.println("Technology Fee: $" + df.format(technologyFee));
        System.out.println("Total Tuition and Fees: $" + df.format(totalCost));
    }
}
