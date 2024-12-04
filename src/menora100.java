import java.util.Scanner;

public class menora100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número menor a 100: ");
        int numero = scanner.nextInt();

        if (numero >= 100) {
            System.out.println("El número ingresado no es menor a 100.");
        } else {
            int suma = 0;

            for (int i = 1; i <= numero; i++) {
                suma += i;
            }

            int sumadoble = 2 * suma;

            System.out.println("La suma de los números entre 1 y " + numero + " es: " + suma);
            System.out.println("El doble de la suma es: " + sumadoble);
        }

        scanner.close();
    }
}
