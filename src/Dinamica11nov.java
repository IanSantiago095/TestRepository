import java.util.HashSet;

public class Dinamica11nov {

    public static int sumaDeValores(int[] arreglo) {
        int suma = 0;
        for (int valor : arreglo) {
            suma += valor;
        }
        return suma;
    }

    public static int valoresUnicos(Object[] arreglo) {
        HashSet<Object> conjuntoUnicos = new HashSet<>();
        for (Object elemento : arreglo) {
            conjuntoUnicos.add(elemento);
        }
        return conjuntoUnicos.size();
    }

    public static void main(String[] args) {
        // Prueba de la suma de valores
        int[] numeros = {1, 2, 3, 4, 5};
        System.out.println("Suma de valores: " + sumaDeValores(numeros));

        // Prueba de los valores únicos
        Object[] objetos = {1, "hola", 2, 1, "mundo", "hola"};
        System.out.println("Cantidad de valores únicos: " + valoresUnicos(objetos));
    }
}