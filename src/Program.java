import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RobotHazardAuditor auditor = new RobotHazardAuditor();

        try {
            System.out.println("Enter Arm Precision (0.0 - 1.0):");
            double armPrecision = sc.nextDouble();

            auditor.validateArmPrecision(armPrecision);

            System.out.println("Arm precision accepted.");

        } catch (RobotSafetyException e) {
            System.out.println(e.getMessage());
        }
    }
}
