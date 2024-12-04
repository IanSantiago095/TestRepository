public class TablasdeMultiplicar {
    public static void main(String[] args) {
        int[][] tablas = new int[100][100];

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                tablas[i][j] = (i + 1) * (j + 1);
            }
        }

        System.out.println("Tablas de multiplicar:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%4d ", tablas[i][j]);
            }
            System.out.println();
        }

    }
}
