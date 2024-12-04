import java.net.URL;
import javax.swing.*;

public class Actividad6nov {

    public static void mostrarImagen(String ruta) {
        try {
            JFrame frame = new JFrame("Visualizador de Imagen");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 700);

            ImageIcon imagen = new ImageIcon(new URL(ruta));

            JLabel etiqueta = new JLabel(imagen);
            etiqueta.setHorizontalAlignment(SwingConstants.CENTER);

            frame.add(etiqueta);
            frame.setVisible(true);
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String urlImagen = "https://i.pinimg.com/736x/ec/46/87/ec4687633fa44593b2d19a70826b6f57.jpg";
        mostrarImagen(urlImagen);
    }
}