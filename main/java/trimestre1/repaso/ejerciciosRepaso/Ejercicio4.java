package trimestre1.repaso.ejerciciosRepaso;

import java.util.Random;
import java.util.Scanner;

/**
 * Ejercicio 4: Simulación de Tareas de Limpieza Automática
 * Enunciado
 * Diseña un programa que simule la limpieza automática de habitaciones en un hotel.
 * Cada habitación tiene una tarea de limpieza asignada que tarda entre 2 y 5 segundos.
 * <p>
 * Cada tarea de limpieza se ejecuta en un hilo independiente.
 * Después de que todas las habitaciones están limpias, se debe enviar una notificación
 * indicando que la limpieza del día ha finalizado.
 * El programa debe permitir interrumpir la limpieza de una habitación específica si se marca como "inhabitable".
 * Requisitos:
 * <p>
 * Usa join para esperar a que terminen todas las tareas de limpieza antes de mostrar la notificación final.
 * Permite interrumpir un hilo utilizando interrupt si la habitación se marca como inhabitable.
 * Usa mensajes informativos para indicar el estado de cada habitación.
 * Extras:
 * <p>
 * Usa una estructura como un BlockingQueue para gestionar las habitaciones pendientes de limpieza.
 */
public class Ejercicio4 implements Runnable {

    private Thread t;

    public Ejercicio4(String nombre) {
        t = new Thread(this, nombre);
    }


    @Override
    public void run() {
        Random random = new Random();
        int num = 2 + random.nextInt(5);
        System.out.println("Preparando para limpiar la habitacion: " + t.getName());
        try {
            Thread.sleep(num);
            System.out.println("Limpiando la habitacion: " + t.getName());
            t.join();
        } catch (InterruptedException e) {
            System.out.println(t.getName() + " fue interrumpida.");
        }
        System.out.println("Limpieza finalizada para " + t.getName());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantas habitaciones tiene su hotel?");
        int h = sc.nextInt();

        for (int i = 0; i < h; i++) {
            Thread habitacion = new Thread(new Ejercicio4("Habitación " + (i+1)));
            habitacion.start();
        }

    }
}
