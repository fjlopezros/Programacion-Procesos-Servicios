package trimestre1.tema1.maquinasVirtuales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author FranLopez
 */
public class Metodos {

    private static final String VMexistentes = "VBoxManage list vms";
    private static final String VMejecucion = "VBoxManage list runningvms";
    private static final String VMOSadmitidos = "VBoxManage list ostypes";

    /**
     * Ejecuta un comando en la línea de comandos del sistema operativo.
     *
     * <p>
     * Este método detecta el sistema operativo en el que se está ejecutando la
     * aplicación y configura el comando adecuadamente para ejecutarlo.
     * Actualmente soporta sistemas Windows y Linux. Si el sistema operativo no
     * es soportado, se imprime un mensaje de error.</p>
     *
     * @param comando el comando a ejecutar en la línea de comandos.
     */
    private void ejecutarComando(String comando) {
        try {
            Process proceso = Runtime.getRuntime().exec(comando);

            int codigoSalida = proceso.waitFor();
            if (codigoSalida != 0) {
                System.out.println("Error: El comando no se ejecutó correctamente.");
            } else {
                BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                String linea;
                while ((linea = lector.readLine()) != null) {
                    System.out.println(linea);
                }
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al ejecutar el comando: " + e.getMessage());
        }
    }

    /**
     * Muestra un menú de opciones para gestionar máquinas virtuales utilizando
     * la interfaz de línea de comandos de VirtualBox.
     * Este método permite al usuario:
     * <ul>
     * <li>Mostrar máquinas virtuales existentes.</li>
     * <li>Mostrar máquinas virtuales en ejecución.</li>
     * <li>Mostrar los sistemas operativos admitidos.</li>
     * <li>Crear una nueva máquina virtual.</li>
     * <li>Salir de la aplicación.</li>
     * </ul>
     *
     * El método utiliza un bucle infinito que solo se detiene cuando el usuario
     * selecciona la opción de salir. La entrada del usuario se maneja a través
     * de la clase {@link Scanner}.
     *
     * @throws java.util.InputMismatchException si la entrada no es un entero
     * válido.
     */
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        while (true) {
            System.out.println("VirtualBox CLI Manager");
            System.out.println("1. Mostrar máquinas virtuales existentes");
            System.out.println("2. Mostrar máquinas virtuales en ejecución");
            System.out.println("3. Mostrar los sistemas operativos admitidos");
            System.out.println("4. Crear una máquina virtual");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    ejecutarComando(VMexistentes);
                    break;
                case 2:
                    ejecutarComando(VMejecucion);
                    break;
                case 3:
                    ejecutarComando(VMOSadmitidos);
                    break;
                case 4:
                    System.out.print("Ingrese el nombre de la nueva VM: ");
                    String vmName = scanner.nextLine();
                    System.out.print("Ingrese el tipo de sistema operativo (use 'VBoxManage list ostypes' para ver opciones): ");
                    String osType = scanner.nextLine();
                    String command = "VBoxManage createvm --name " + vmName + " --ostype " + osType + " --register";
                    ejecutarComando(command);
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        }
    }
}