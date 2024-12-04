import java.util.Scanner;

public class Ejercicio11Sep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int intentos = 10;
        int numSecreto = (int) (Math.random() * 100) + 1; // Número aleatorio entre 1 y 100

        System.out.println("Adivine el número (de 1 a 100):");
        int numIngresado = scanner.nextInt();

        while (numSecreto != numIngresado && intentos > 1) {
            if (numSecreto > numIngresado) {
                System.out.println("Muy bajo");
            } else {
                System.out.println("Muy alto");
            }
            intentos--;
            System.out.println("Le quedan " + intentos + " intentos:");
            numIngresado = scanner.nextInt();
        }

        if (numSecreto == numIngresado) {
            System.out.println("¡Exacto! Usted adivinó en " + (11 - intentos) + " intentos.");
        } else {
            System.out.println("El número era: " + numSecreto);
        }

        scanner.close();
    }
}
