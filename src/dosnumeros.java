import java.util.Scanner;

public class dosnumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        int num1 = scanner.nextInt();

        System.out.print("Ingrese el segundo número: ");
        int num2 = scanner.nextInt();

        int resultado = (3 * num1) + (2 * num2);

        System.out.println("El resultado es: " + resultado);

        scanner.close();
    }
}
