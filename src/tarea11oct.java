public class tarea11oct {
    public static void main(String[] args) {
        System.out.printf("--------------------%n");
        System.out.printf("Java int printf chart%n");
        System.out.printf("(number: 123457890)%n");
        System.out.printf("--------------------%n");
        System.out.printf("| %-8s |  %s  |%n", "PATTERN", "RESULT");
        System.out.printf("--------------------%n");
        System.out.printf("| %-8s | %d|%n", "%d", 123457890);
        System.out.printf("| %-8s | %,d|%n", "%,d", 123457890);
        System.out.printf("| %-8s | %,15d|%n", "%,15d", 123457890);
        System.out.printf("| %-8s | %+,15d|%n", "%+,15d", 123457890);
        System.out.printf("| %-8s | %-+,15d|%n", "%-+,15d", 123457890);
        System.out.printf("| %-8s | %0,15d|%n", "%0.15d", 123457890);
    }
}
