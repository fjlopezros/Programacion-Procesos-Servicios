package trimestre1.tema2.ejercicio01_reloj;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Vamos a crear dos clases: una Main para ejecutar todo esto y otra Reloj,
 * que se encargará de pintar la hora en la etiqueta lbHora de esta ventana.
 * Esta última clase tendrá dos propiedades:
 * - Una para la hora (LocalTime).
 * - Otra para el JLabel.
 * Para ello, dicha clase debe admitir en el constructor un parámetro de
 * tipo JLabel.
 * La clase Reloj tendrá el método setTime(), que se encargará de recalcular la hora
 * cada segundo, formatearla y mostrarla en el JLabel.
 * <p>
 * En esta pantalla, cuando se pulse el botón "Go", se debe plasmar en lbHora la
 * hora que genera el objeto Reloj en formato HH:mm:ss.
 * <p>
 * Comprobar el resultado y comentarlo en clase.
 * Después, modifica la clase Reloj para que se comporte como un hilo y haz los
 * cambios necesarios en esta clase.
 *
 * @author diego
 */
public class VentanaReloj extends JFrame implements ActionListener {

    private JLabel lbHora;
    private JTextField tfEntradaTexto;
    private JButton btAceptar;
    private JButton btSetClockOn;
    private JPanel pReloj;

    public VentanaReloj() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ventana con reloj");
        setSize(400, 400);
        setLayout(new BorderLayout());
        lbHora = new JLabel("00:00:00");
        tfEntradaTexto = new JTextField("", 30);
        btAceptar = new JButton("Aceptar");
        btAceptar.addActionListener(this);
        btSetClockOn = new JButton("Go");
        pReloj = new JPanel();
        pReloj.add(lbHora);
        pReloj.add(btSetClockOn);
        btSetClockOn.addActionListener(this);

        add(pReloj, BorderLayout.NORTH);
        add(tfEntradaTexto, BorderLayout.CENTER);
        add(btAceptar, BorderLayout.SOUTH);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btSetClockOn)) {
            System.out.println("funciona");
            Reloj r = new Reloj(lbHora);
            Thread hilo = new Thread(r);
            hilo.start();
            btSetClockOn.setEnabled(false);
        } else if (e.getSource().equals(btAceptar)) {
            System.exit(0);
        }
    }
}
