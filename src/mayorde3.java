import java.util.Scanner;

public class mayorde3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el primer número: ");
        int num1 = scanner.nextInt();

        System.out.print("Introduce el segundo número: ");
        int num2 = scanner.nextInt();

        System.out.print("Introduce el tercer número: ");
        int num3 = scanner.nextInt();

        int mayor;

        if (num1 > num2) {
            if (num1 > num3) {
                mayor = num1;
            } else {
                mayor = num3;
            }
        } else {
            if (num2 > num3) {
                mayor = num2;
            } else {
                mayor = num3;
            }
        }

        System.out.println("El número mayor es: " + mayor);

        scanner.close();
    }
}