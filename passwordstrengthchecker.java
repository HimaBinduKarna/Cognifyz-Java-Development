import java.util.Scanner;

public class password {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        int length = password.length();
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else {
                hasSpecialChar = true;
            }
        }

        // Check password strength
        int strength = 0;
        if (length >= 8) {
            strength++;
        }
        if (hasUppercase) {
            strength++;
        }
        if (hasLowercase) {
            strength++;
        }
        if (hasDigit) {
            strength++;
        }
        if (hasSpecialChar) {
            strength++;
        }

        // Provide feedback on password strength
        if (strength == 5) {
            System.out.println("Password is very strong!");
        } else if (strength >= 3) {
            System.out.println("Password is strong.");
        } else if (strength >= 2) {
            System.out.println("Password is moderate.");
        } else {
            System.out.println("Password is weak. Please consider improving it.");
        }
    }
}
