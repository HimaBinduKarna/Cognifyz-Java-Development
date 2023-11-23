import java.io.*;

public class file {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // Get user input for encryption or decryption
            System.out.print("Enter 'E' for encryption or 'D' for decryption: ");
            char choice = br.readLine().charAt(0);

            // Get user input for file name or path
            System.out.print("Enter the file name or path: ");
            String filePath = br.readLine();

            // Read the content of the file
            String fileContent = readFile(filePath);

            // Perform encryption or decryption based on user choice
            String result;
            if (choice == 'E' || choice == 'e') {
                System.out.print("Enter the encryption key (an integer): ");
                int key = Integer.parseInt(br.readLine());
                result = encrypt(fileContent, key);
            } else if (choice == 'D' || choice == 'd') {
                System.out.print("Enter the decryption key (an integer): ");
                int key = Integer.parseInt(br.readLine());
                result = decrypt(fileContent, key);
            } else {
                System.out.println("Invalid choice. Please enter 'E' or 'D'.");
                return;
            }

            // Save the result to a new file
            System.out.print("Enter the output file name: ");
            String outputFileName = br.readLine();
            writeFile(outputFileName, result);

            System.out.println("Operation completed successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();
        return content.toString();
    }

    private static void writeFile(String fileName, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(content);
        writer.close();
    }

    private static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                result.append((char) ((character - base + key) % 26 + base));
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }

    private static String decrypt(String text, int key) {
        return encrypt(text, 26 - key); // Decryption is essentially encryption with the opposite key
    }
}
