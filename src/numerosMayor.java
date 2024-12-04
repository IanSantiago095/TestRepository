import java.util.Scanner;

public class numerosMayor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mayor = 0;

        System.out.println("Ingrese 5 números:");

        for (int i = 1; i <= 5; i++) {
            System.out.print("Número " + i + ": ");
            int num = scanner.nextInt();
            if (i == 1 || num > mayor) {
                mayor = num;
            }
        }

        System.out.println("El número mayor ingresado es: " + mayor);

        scanner.close();
    }
}
