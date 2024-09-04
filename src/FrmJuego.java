
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

//Metodo constructor
public class FrmJuego extends JFrame { //Clase de FmrJuego

    JLabel lblDado1, lblDado2, lblLanzamientos, lblCenas; //Se llaman dos variables y se declaran
    Dado dado1, dado2;
    Random r = new Random();

    private int lanzamientos, cenas;

    public FrmJuego() {

        setTitle("Juguemos a los dados."); //Titulo de la Aplicacion.
        setSize(800, 300); //Ancho y Altura de la pantalla.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Cerrar la aplicacion presionando la X.

        //Se crean dos nuevas instancias y la etiquetas de los dados.
        lblDado1 = new JLabel();
        lblDado2 = new JLabel();
        lblLanzamientos = new JLabel();
        lblCenas = new JLabel();
        //Se instancia dos clases 
        JLabel lbl1 = new JLabel();
        JLabel lbl2 = new JLabel();
        //Se crea declaran Botones
        JButton botonInicia = new JButton();
        JButton botonLanzar = new JButton();

        //Se crean dos nuevas instancias
        dado1 = new Dado();
        dado2 = new Dado();

        String rutaDado = "/imagenes/3.png"; //Ruta para importar una imagen.
        ImageIcon imgDado = new ImageIcon(getClass().getResource(rutaDado)); //Carga la imagen desde la ruta.

        // Declarar las imagenes en sus respectivas instancias.
        lblDado1.setIcon(imgDado);
        lblDado2.setIcon(imgDado);

        //Permite modificar la posicion horizontal,vertical,ancho y largo.
        lblDado1.setBounds(10, 10, imgDado.getIconWidth(), imgDado.getIconHeight());
        lblDado2.setBounds(20 + imgDado.getIconWidth(), 10, imgDado.getIconWidth(), imgDado.getIconHeight());

        //Declarar los textos
        lbl1.setText("Lanzamientos");
        lbl2.setText("Cenas");

        //Permite modificar la posicion horizontal,vertical,ancho y largo.
        lbl1.setBounds(50 + 2 * imgDado.getIconWidth(), 10, 100, 25);
        lbl2.setBounds(160 + 2 * imgDado.getIconWidth(), 10, 100, 25);

        //Declarar los textos
        lblLanzamientos.setBackground(new Color(0, 0, 0)); // Color de fondo.
        lblLanzamientos.setForeground(new Color(51, 255, 0)); // Color del texto
        lblLanzamientos.setBounds(50 + 2 * imgDado.getIconWidth(), 40, 100, 100); //Ubicacion
        lblLanzamientos.setOpaque(true); //Hacer Visible la ventana
        lblLanzamientos.setFont(new Font("Tahoma", 1, 72)); // Letra
        lblLanzamientos.setHorizontalAlignment(SwingConstants.CENTER); //Alineacion horizontal del texto.

        lblCenas.setBackground(new Color(0, 0, 0)); // Color de fondo.
        lblCenas.setForeground(new Color(51, 255, 0)); // Color del texto
        lblCenas.setBounds(160 + 2 * imgDado.getIconWidth(), 40, 100, 100); //Ubicacion
        lblCenas.setOpaque(true); //Hacer Visible la ventana
        lblCenas.setFont(new Font("Tahoma", 1, 72)); // Letra
        lblCenas.setHorizontalAlignment(SwingConstants.CENTER); //Alineacion horizontal del texto.

        lanzamientos = 0;
        cenas = 0;
        mostrarContadores();

        botonInicia.setText("Iniciar"); // se crea el boton Iniciar
        botonInicia.setBounds(10, 190, 100, 25); //Modificar ubicacion del boton
        botonInicia.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                botonIniciarClick(e);
            }
        });

        botonLanzar.setText("Lanzar"); // se crea el boton Lanzar
        botonLanzar.setBounds(120, 190, 100, 25); //Modificar ubicacion del boton
        botonLanzar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                botonLanzarClick(e);
            }
        });

        // Muestra los dados en la pantalla
        getContentPane().setLayout(null);
        getContentPane().add(lblDado1);
        getContentPane().add(lblDado2);
        getContentPane().add(lbl1);
        getContentPane().add(lbl2);
        getContentPane().add(lblLanzamientos);
        getContentPane().add(botonInicia);
        getContentPane().add(lblCenas);
        getContentPane().add(botonLanzar);
    }

    private void botonIniciarClick(ActionEvent e) {
        lanzamientos = 0;
        cenas = 0;
        mostrarContadores();
    }

    private void botonLanzarClick(ActionEvent e) {
        dado1.lanzar(r);
        dado2.lanzar(r);

        dado1.mostrar(lblDado1);
        dado1.mostrar(lblDado2);

        lanzamientos++;

        if (dado1.getNumero() + dado2.getNumero() >= 11) {
            cenas++;
        }
        mostrarContadores();

    }

    private void mostrarContadores() {
        lblLanzamientos.setText(String.valueOf(lanzamientos));
        lblCenas.setText(String.valueOf(cenas));
    }
}
