import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        scanner.close();

        int length = password.length();
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;

        for (int i = 0; i < length; i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (isSpecialCharacter(ch)) {
                hasSpecialCharacter = true;
            }
        }

        int strength = calculateStrength(length, hasUppercase, hasLowercase, hasNumber, hasSpecialCharacter);

        if (strength >= 4) {
            System.out.println("Password is Strong.");
        } else if (strength == 3) {
            System.out.println("Password is Moderate.");
        } else if (strength == 2) {
            System.out.println("Password is Weak.");
        } else {
            System.out.println("Password is Very Weak.");
        }
    }

    public static boolean isSpecialCharacter(char ch) {
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:'\",.<>?";
        return specialCharacters.contains(String.valueOf(ch));
    }

    public static int calculateStrength(int length, boolean hasUppercase, boolean hasLowercase, boolean hasNumber, boolean hasSpecialCharacter) {
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

        if (hasNumber) {
            strength++;
        }

        if (hasSpecialCharacter) {
            strength++;
        }

        return strength;
    }
}
