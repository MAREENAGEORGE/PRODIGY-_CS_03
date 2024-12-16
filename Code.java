import java.util.Scanner;

public class PasswordStrengthChecker {

    public static String checkPasswordStrength(String password) {
        int strengthScore = 0;

        // Criteria checks
        boolean lengthCriteria = password.length() >= 8;
        boolean uppercaseCriteria = password.matches(".*[A-Z].*");
        boolean lowercaseCriteria = password.matches(".*[a-z].*");
        boolean digitCriteria = password.matches(".*\\d.*");
        boolean specialCharCriteria = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

        // Increase strength score based on criteria met
        if (lengthCriteria) strengthScore++;
        if (uppercaseCriteria) strengthScore++;
        if (lowercaseCriteria) strengthScore++;
        if (digitCriteria) strengthScore++;
        if (specialCharCriteria) strengthScore++;

        // Provide feedback based on strength score
        if (strengthScore == 5) {
            return "Strong password!";
        } else if (strengthScore >= 3) {
            return "Moderate password. Consider adding more complexity.";
        } else {
            return "Weak password. Use a mix of uppercase, lowercase, numbers, and special characters.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        String feedback = checkPasswordStrength(password);
        System.out.println("\nPassword Analysis:");
        System.out.println("Password: " + password);
        System.out.println("Feedback: " + feedback);

        scanner.close();
    }
}
