
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Dado {

    private int numero; //Dato privado

    public void lanzar(Random r) {
        numero = r.nextInt(6) + 1; //genera numeros del 1 al 6

    }

    public void mostrar(JLabel lbl) {
        String rutaDado = "/imagenes/" + numero + ".png"; //Ruta para importar una imagen.
        ImageIcon imgDado = new ImageIcon(getClass().getResource(rutaDado)); //Carga la imagen desde la 
        //ruta.
        lbl.setIcon(imgDado); //Asignar imagen.

    }

    public int getNumero() {
        return numero;
    }
}
