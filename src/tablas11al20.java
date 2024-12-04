public class tablas11al20 {
    public static void main(String[] args) {
        for (int tabla = 11; tabla <= 20; tabla++) {
            System.out.println("Tabla del " + tabla + ":");
            for (int i = 1; i <= 10; i++) {
                System.out.println(tabla + " * " + i + " = " + (tabla * i));
            }
            System.out.println(); // Espacio entre tablas.
        }
    }
}
