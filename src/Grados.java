import java.util.Scanner;

public class Grados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la temperatura en grados Celsius: ");
        double celsius = scanner.nextDouble();

        double fahrenheit = convertirAFahrenheit(celsius);

        System.out.println("La temperatura en Fahrenheit es: " + fahrenheit);

        scanner.close();
    }

    public static double convertirAFahrenheit(double celsius) {
        return 32 + (9 * celsius / 5);
    }
}
