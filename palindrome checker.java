import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word or phrase: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Yes, it's a palindrome!");
        } else {
            System.out.println("No, it's not a palindrome.");
        }
    }

    // Function to check if a string is a palindrome
    private static boolean isPalindrome(String str) {
        // Remove spaces and punctuation, convert to lowercase
        String cleanStr = str.replaceAll("[^a-zA-Z]", "").toLowerCase();

        int left = 0;
        int right = cleanStr.length() - 1;

        // Check if the string is a palindrome
        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
