import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.print("Enter temperature value: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter unit of measurement (C for Celsius, F for Fahrenheit): ");
        char unit = scanner.next().charAt(0);

        double convertedTemperature;

        if (unit == 'C' || unit == 'c') {
            // Convert Celsius to Fahrenheit
            convertedTemperature = celsiusToFahrenheit(temperature);
            System.out.println(temperature + " Celsius is equal to " + convertedTemperature + " Fahrenheit.");
        } else if (unit == 'F' || unit == 'f') {
            // Convert Fahrenheit to Celsius
            convertedTemperature = fahrenheitToCelsius(temperature);
            System.out.println(temperature + " Fahrenheit is equal to " + convertedTemperature + " Celsius.");
        } else {
            System.out.println("Invalid unit of measurement. Please enter 'C' or 'F'.");
        }

        scanner.close();
    }

    // Celsius to Fahrenheit conversion
    private static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    // Fahrenheit to Celsius conversion
    private static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
}
