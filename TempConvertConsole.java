import java.util.Scanner;

// Console-based Temperature Converter
public class TempConvertConsole {

    // Conversion formulas
    public static double celsiusToFahrenheit(double c) {
        return (c * 9/5) + 32;
    }

    public static double celsiusToKelvin(double c) {
        return c + 273.15;
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5/9;
    }

    public static double fahrenheitToKelvin(double f) {
        return (f - 32) * 5/9 + 273.15;
    }

    public static double kelvinToCelsius(double k) {
        return k - 273.15;
    }

    public static double kelvinToFahrenheit(double k) {
        return (k - 273.15) * 9/5 + 32;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Menu-driven UI
            System.out.println("\n===== Temperature Converter =====");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Celsius to Kelvin");
            System.out.println("3. Fahrenheit to Celsius");
            System.out.println("4. Fahrenheit to Kelvin");
            System.out.println("5. Kelvin to Celsius");
            System.out.println("6. Kelvin to Fahrenheit");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            // Exit option
            if (choice == 7) {
                System.out.println("Exiting... Bye!");
                break;
            }

            // Take user input
            System.out.print("Enter temperature value: ");
            double value = sc.nextDouble();
            double result = 0;

            // Perform conversion based on user choice
            switch (choice) {
                case 1: result = celsiusToFahrenheit(value); break;
                case 2: result = celsiusToKelvin(value); break;
                case 3: result = fahrenheitToCelsius(value); break;
                case 4: result = fahrenheitToKelvin(value); break;
                case 5: result = kelvinToCelsius(value); break;
                case 6: result = kelvinToFahrenheit(value); break;
                default: 
                    System.out.println("Invalid choice!"); 
                    continue;
            }

            // Display result
            System.out.println("Converted Value: " + result);
        }

        sc.close();
    }
}
