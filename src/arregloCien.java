public class arregloCien {
    public static void main(String[] args) {
        int[] arreglo = new int[100];

        for (int i = 0; i < 100; i++) {
            arreglo[i] = 1000 + i;
        }

        for (int i = 99; i >= 0; i--) {
            System.out.println(arreglo[i]);
        }
    }
}