import java.util.Scanner;

public class radioesfera {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el radio de la esfera: ");
        double radio = scanner.nextDouble();

        double pi = 3.1416;
        double volumen = (4.0 / 3.0) * pi * (radio * radio * radio);

        System.out.println("El volumen de la esfera es: " + volumen);

        scanner.close();
    }
}
