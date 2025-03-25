package trimestre1.tema1.proyecto;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Modelo {

    private static final String OS_WINDOWS = "windows";
    private static final String OS_LINUX = "linux";
    private static final String OS_MAC = "mac";
    private static String[] comandoWin = {"cmd.exe", "/c", "type", Controlador.getRutaSeleccionada()};
    private static String[] comandoLin = {"bash", "-c", "sudo cat /etc/passwd"};
    private static List<String[]> lineasUsuario = new ArrayList<>();
    private static List<String[]> lineasRegistro = new ArrayList<>();


    public static List<String[]> leerFichero(int opcion) {
        lineasUsuario.clear();
        lineasRegistro.clear();

        try {
            Process proceso = new ProcessBuilder(getCommand()).start();
            if (proceso.waitFor() == 0) {
                try (BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                    lector.readLine();
                    String linea;

                    while ((linea = lector.readLine()) != null) {
                        String[] campos = linea.split(":");
                        if (Integer.parseInt(campos[2]) >= 1000) {
                            lineasUsuario.add(campos);
                        } else {
                            lineasRegistro.add(campos);
                        }
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al ejecutar el processo " + e.getMessage());
            //e.printStackTrace();
        }
        if (opcion == 1) {
            return lineasUsuario;
        } else {
            return lineasRegistro;
        }
    }

    private static String[] getCommand() {
        if (Modelo.getOsName().equals(OS_WINDOWS)) {
            return comandoWin;
        } else{
            return comandoLin;
        }
    }

    public static String getOsName(){
        String osName = System.getProperty("os.name").toLowerCase();
        if (isWindows(osName)) {
            return OS_WINDOWS;
        } else if (isLinux(osName)) {
            return OS_LINUX;
        } else {
            return OS_MAC;
        }
    }
    private static boolean isWindows(String osName) {
        return osName.toLowerCase().contains(OS_WINDOWS);
    }

    private static boolean isLinux(String osName) {
        return osName.toLowerCase().contains(OS_LINUX);
    }
}
