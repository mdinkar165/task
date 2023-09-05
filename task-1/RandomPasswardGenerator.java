import java.security.SecureRandom;
import java.util.Scanner;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();

        if (length <= 0) {
            System.out.println("Invalid input. Please enter a positive length.");
            return;
        }

        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("yes");

        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberChars = "0123456789";
        String specialChars = "!@#$%^&*()-_+=<>?";

        StringBuilder password = new StringBuilder();

        while (password.length() < length) {
            if (includeLowercase) {
                password.append(lowercaseChars.charAt(random.nextInt(lowercaseChars.length())));
            }
            if (includeUppercase) {
                password.append(uppercaseChars.charAt(random.nextInt(uppercaseChars.length())));
            }
            if (includeNumbers) {
                password.append(numberChars.charAt(random.nextInt(numberChars.length())));
            }
            if (includeSpecialChars) {
                password.append(specialChars.charAt(random.nextInt(specialChars.length())));
            }
        }

        // Shuffle the characters in the password
        char[] passwordArray = password.toString().toCharArray();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(length);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[randomIndex];
            passwordArray[randomIndex] = temp;
        }

        String generatedPassword = new String(passwordArray);

        System.out.println("Generated password: " + generatedPassword);

        scanner.close();
    }
}