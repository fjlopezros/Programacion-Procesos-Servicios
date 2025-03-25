package trimestre1.tema1.proyecto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Vista extends JFrame {

    private JTable tabla,tabla2;
    private JScrollPane scrollPane, scrollPane2;
    private DefaultTableModel tablaModel,tablaModel2;
    private JLabel titulo;
    private JButton boton, botonGuardar1, botonGuardar2;
    private JPanel panelPie;

    public Vista() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 700);
        setLayout(new BorderLayout());
        setTitle("Vista");

        Controlador controlador = new Controlador(this);

        titulo = new JLabel("Proyecto: Procesos y Servicios", SwingConstants.CENTER);
        panelPie = new JPanel(new BorderLayout());

        tablaModel = new DefaultTableModel(new Object[]{"Nombre",
                "Contrasena",
                "UID",
                "GID",
                "Datos",
                "Directorio",
                "Shell"}, 0);
        tabla = new JTable(tablaModel);
        tabla.setEnabled(false);
        scrollPane = new JScrollPane(tabla);
        this.add(scrollPane, BorderLayout.EAST);

        tablaModel2 = new DefaultTableModel(new Object[]{"Nombre",
                "Contrasena",
                "UID",
                "GID",
                "Datos",
                "Directorio",
                "Shell"}, 0);
        tabla2 = new JTable(tablaModel2);
        tabla2.setEnabled(false);
        scrollPane2 = new JScrollPane(tabla2);
        this.add(scrollPane2, BorderLayout.WEST);


        boton = new JButton("Mostar Datos");
        boton.setActionCommand("ruta");
        boton.addActionListener(controlador);

        botonGuardar1 = new JButton("Guardar Usuarios");
        botonGuardar1.setActionCommand("guardar");
        botonGuardar1.addActionListener(controlador);

        botonGuardar2 = new JButton("Guardar Registros");
        botonGuardar2.setActionCommand("guardar2");
        botonGuardar2.addActionListener(controlador);

        panelPie.add(boton, BorderLayout.CENTER);
        panelPie.add(botonGuardar1, BorderLayout.EAST);
        panelPie.add(botonGuardar2, BorderLayout.WEST);

        this.add(titulo, BorderLayout.NORTH);
        this.add(panelPie, BorderLayout.SOUTH);
    }

    public DefaultTableModel getTablaModel() {
        return tablaModel;
    }
    public DefaultTableModel getTablaModel2() {
        return tablaModel2;
    }

    public JButton getBoton() {
        return boton;
    }
}
