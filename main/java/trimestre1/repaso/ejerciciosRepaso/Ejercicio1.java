package trimestre1.repaso.ejerciciosRepaso;

import java.util.Random;
/**
 * Ejercicio 1: Sincronización de Hilos con Join y Sleep
 * <p>
 * Diseña una aplicación que simule una línea de producción de tres etapas: Fabricación, Ensamblaje, y Embalaje.
 * Cada etapa será un hilo independiente que debe ejecutarse en orden.
 * <p>
 * El hilo Fabricación tarda entre 1 y 3 segundos en completar su tarea (usa Thread.sleep para simularlo).
 * Una vez terminado, debe notificar al hilo Ensamblaje para que inicie su tarea.
 * El hilo Ensamblaje tarda entre 2 y 4 segundos y, al finalizar, debe notificar al hilo Embalaje para que comience.
 * El hilo Embalaje tarda entre 1 y 2 segundos en completar su tarea.
 * <p>
 * Utiliza el método join para garantizar que cada hilo espere
 * al anterior antes de comenzar. Al final de la ejecución, el programa
 * debe mostrar un mensaje indicando que todo el proceso se ha completado
 */
public class Ejercicio1 implements Runnable {

    private final String tarea;
    private final int tiempo;

    public Ejercicio1(String tarea, int tiempo) {
        this.tarea = tarea;
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        System.out.println("Iniciando " + tarea);
        try {
            Thread.sleep(tiempo); // Simula el tiempo de la tarea
        } catch (InterruptedException e) {
            System.out.println("Error en la tarea: " + tarea);
        }
        System.out.println("Tarea " + tarea + " completada en " + tiempo + " ms.");
    }

    public static void main(String[] args) {
        Random random = new Random();

        // Generar tiempos aleatorios para cada tarea
        int tiempoFabricacion = 1000 + random.nextInt(2000); // 1-3 segundos
        int tiempoEnsamblaje = 2000 + random.nextInt(2000);  // 2-4 segundos
        int tiempoEmbalaje = 1000 + random.nextInt(1000);    // 1-2 segundos

        // Crear las tareas
        Thread fabricacion = new Thread(new Ejercicio1("Fabricación", tiempoFabricacion));
        Thread ensamblaje = new Thread(new Ejercicio1("Ensamblaje", tiempoEnsamblaje));
        Thread embalaje = new Thread(new Ejercicio1("Embalaje", tiempoEmbalaje));

        try {
            // Sincronizar las tareas usando join
            fabricacion.start();
            // Esperar a que termine
            fabricacion.join();

            ensamblaje.start();
            ensamblaje.join();

            embalaje.start();
            embalaje.join();

            System.out.println("Proceso completo: Todas las tareas han finalizado.");
        } catch (InterruptedException e) {
            System.out.println("Error en la sincronización de las tareas.");
        }
    }
}
