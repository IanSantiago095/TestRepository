import java.util.Scanner;

public class numerocifras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un número entero positivo: ");
        int numero = scanner.nextInt();

        int cifras = String.valueOf(numero).length();
        System.out.println("El número tiene " + cifras + " cifras.");

        scanner.close();
    }
}
