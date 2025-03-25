package trimestre1.tema1.proyecto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Controlador implements ActionListener {

    private static Vista vista;
    private static String rutaSeleccionada;

    public Controlador(Vista vista) {
        this.vista = vista;


        vista.setVisible(true);
    }

    public void mostarTabla() {
        vista.getTablaModel().setRowCount(0);
        List<String[]> lineas = Modelo.leerFichero(1);
        for (String[] linea : lineas) {
            vista.getTablaModel().addRow(new Object[]{
                    linea[0],
                    linea[1],
                    linea[2],
                    linea[3],
                    linea[4],
                    linea[5],
                    linea[6]
            });
        }
        List<String[]> lineas2 = Modelo.leerFichero(2);
        for (String[] linea2 : lineas2) {
            vista.getTablaModel2().addRow(new Object[]{
                    linea2[0],
                    linea2[1],
                    linea2[2],
                    linea2[3],
                    linea2[4],
                    linea2[5],
                    linea2[6]
            });
        }
    }

    public String seleccionarRuta(){
        JFileChooser elegirRuta = new JFileChooser();
        int aprovado = elegirRuta.showOpenDialog(null);
        if (aprovado == JFileChooser.APPROVE_OPTION) {
            File fichero = elegirRuta.getSelectedFile();
            rutaSeleccionada = fichero.getAbsolutePath();
        }
        return rutaSeleccionada;
    }

    public void escribir(int opcion){
        try(FileWriter escritor = new FileWriter(seleccionarRuta() + ".txt")){
            escritor.write("");
            List<String[]> lineas = Modelo.leerFichero(opcion);
            for (String[] linea : lineas) {
                escritor.write(Arrays.toString(linea)+"\n");
            }
        }catch(IOException ex){
            System.out.println("Error al escribir el archivo " + ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "ruta":
                JOptionPane.showMessageDialog(null, "Archivo seleccionado: " + seleccionarRuta());
                mostarTabla();
                break;
            case "guardar":
                escribir(1);
                break;
            case "guardar2":
                escribir(2);
                break;
        }
    }

    public static String getRutaSeleccionada() {
        return rutaSeleccionada;
    }

}

