import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileEncryptionDecryption {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("File Encryption/Decryption Program");
        System.out.print("Enter 'E' for encryption or 'D' for decryption: ");
        char choice = scanner.nextLine().toUpperCase().charAt(0);

        if (choice == 'E' || choice == 'D') {
            System.out.print("Enter the input file name or path: ");
            String inputFileName = scanner.nextLine();

            System.out.print("Enter the output file name: ");
            String outputFileName = scanner.nextLine();

            try {
                if (choice == 'E') {
                    encryptFile(inputFileName, outputFileName);
                    System.out.println("File encrypted successfully!");
                } else {
                    decryptFile(inputFileName, outputFileName);
                    System.out.println("File decrypted successfully!");
                }
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        } else {
            System.err.println("Invalid choice. Please enter 'E' for encryption or 'D' for decryption.");
        }

        scanner.close();
    }

    private static void encryptFile(String inputFileName, String outputFileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

        int key = 3; // Caesar cipher key (adjust as needed)

        int currentChar;
        while ((currentChar = reader.read()) != -1) {
            if (Character.isLetter(currentChar)) {
                char encryptedChar = (char) (currentChar + key);
                writer.write(encryptedChar);
            } else {
                writer.write(currentChar);
            }
        }

        reader.close();
        writer.close();
    }

    private static void decryptFile(String inputFileName, String outputFileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

        int key = -3; // Caesar cipher key (should match the encryption key)

        int currentChar;
        while ((currentChar = reader.read()) != -1) {
            if (Character.isLetter(currentChar)) {
                char decryptedChar = (char) (currentChar + key);
                writer.write(decryptedChar);
            } else {
                writer.write(currentChar);
            }
        }

        reader.close();
        writer.close();
    }
}
