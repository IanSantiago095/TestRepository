
public class multiplos3y5 {
    public static void main(String[] args) {
        int contador = 0;

        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                contador++;
            }
        }

        System.out.println("La cantidad de números menores de 1000 que son múltiplos de 3 y 5 es: " + contador);
    }
}
