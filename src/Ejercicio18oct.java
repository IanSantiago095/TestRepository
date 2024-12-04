import java.util.Random;

public class Ejercicio18oct {
    public static void main(String[] args) {
        int[] arreglo = new int[100];
        Random random = new Random();


        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = random.nextInt(501) + 500;
        }

        System.out.println("Arreglo antes del ordenamiento:");
        mostrarArreglo(arreglo);

        ordenarBurbuja(arreglo);

        System.out.println("\nArreglo después del ordenamiento:");
        mostrarArreglo(arreglo);
    }

    public static void ordenarBurbuja(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    public static void mostrarArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
