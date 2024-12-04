import java.util.Scanner;

public class Declarastring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Por favor, introduce tu nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Bienvenido " + nombre);

        scanner.close();
    }
}
