import java.util.ArrayList;

public class ArrayArralist {
    public static void main(String[] args) {
        int TAMANIO_ARRAY = 100;
        int[] array1 = new int[TAMANIO_ARRAY];
        for (int i = 0; i < TAMANIO_ARRAY; i++) {
            array1[i] = i + 1;
        }

        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int i = 101; i <= 200; i++) {
            arrayList2.add(i);
        }

        ArrayList<Integer> combinado = new ArrayList<>();
        for (int i = 0; i < TAMANIO_ARRAY; i++) {
            combinado.add(array1[i]);
        }
        combinado.addAll(arrayList2);

        System.out.println("Array (1-100):");
        for (int i = 0; i < TAMANIO_ARRAY; i++) {
            System.out.print(array1[i] + " ");
        }

        System.out.println("\n\nArrayList (101-200):");
        for (int i = 0; i < arrayList2.size(); i++) {
            System.out.print(arrayList2.get(i) + " ");
        }

        System.out.println("\n\nArrayList combinado (1-200):");
        for (int i = 0; i < combinado.size(); i++) {
            System.out.print(combinado.get(i) + " ");
        }
    }
}