import java.util.Scanner;

public class TablaDeMultiplicar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;

        System.out.println("Ingrese un numero");
        num = scanner.nextInt();

        for(int i=1; i<=10; i++){
            System.out.println(num+" * "+i+" = "+num*i);
        }

        scanner.close();
    }
}
