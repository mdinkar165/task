import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Temperature Converter!");
        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter the unit of measurement (Celsius or Fahrenheit): ");
        scanner.nextLine(); // Consume the newline character
        String unit = scanner.nextLine().toLowerCase();

        double convertedTemperature = 0.0;

        if (unit.equals("celsius")) {
            convertedTemperature = celsiusToFahrenheit(temperature);
            System.out.println(temperature + " degrees Celsius is equal to " + convertedTemperature + " degrees Fahrenheit.");
        } else if (unit.equals("fahrenheit")) {
            convertedTemperature = fahrenheitToCelsius(temperature);
            System.out.println(temperature + " degrees Fahrenheit is equal to " + convertedTemperature + " degrees Celsius.");
        } else {
            System.out.println("Invalid unit of measurement. Please enter 'Celsius' or 'Fahrenheit'.");
        }

        scanner.close();
    }

    // Convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}