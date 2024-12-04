import java.util.Random;
import java.util.Scanner;

public class Ejercicios20sep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int intentos = 10;
        int numSecreto = random.nextInt(100) + 1;

        System.out.println("Adivine el número (de 1 a 100):");

        while (intentos > 0) {
            System.out.print("Ingrese su número: ");
            int numIngresado = scanner.nextInt();

            if (numIngresado == numSecreto) {
                System.out.println("¡Exacto! Usted adivinó el número en " + (11 - intentos) + " intentos.");
                break;
            } else if (numIngresado < numSecreto) {
                System.out.println("Muy bajo");
            } else {
                System.out.println("Muy alto");
            }

            intentos--;
            if (intentos > 0) {
                System.out.println("Le quedan " + intentos + " intentos.");
            } else {
                System.out.println("Lo siento, se han agotado los intentos. El número era: " + numSecreto);
            }
        }

        scanner.close();
    }
}
