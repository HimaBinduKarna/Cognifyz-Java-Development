import java.security.SecureRandom;
import java.util.Scanner;

public class password1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();

        System.out.print("Include numbers? (y/n): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("y");

        // Generate the password
        String password = generatePassword(length, includeNumbers, includeLowercase, includeUppercase, includeSpecialChars);

        // Display the generated password
        System.out.println("Your generated password is: " + password);

        scanner.close();
    }

    private static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase,
                                           boolean includeUppercase, boolean includeSpecialChars) {
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberChars = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

        StringBuilder validChars = new StringBuilder();

        // Build the set of valid characters based on user preferences
        if (includeLowercase) {
            validChars.append(lowercaseChars);
        }
        if (includeUppercase) {
            validChars.append(uppercaseChars);
        }
        if (includeNumbers) {
            validChars.append(numberChars);
        }
        if (includeSpecialChars) {
            validChars.append(specialChars);
        }

        // Ensure at least one character set is selected
        if (validChars.length() == 0) {
            System.out.println("Error: Please include at least one character set.");
            System.exit(1);
        }

        // Generate the password using SecureRandom
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            password.append(validChars.charAt(randomIndex));
        }

        return password.toString();
    }
}
