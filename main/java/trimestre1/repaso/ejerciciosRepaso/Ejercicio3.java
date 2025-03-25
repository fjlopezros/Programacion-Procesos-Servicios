package trimestre1.repaso.ejerciciosRepaso;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Ejercicio 3: Simulación de Descarga de Recursos con Interrupción
 * Enunciado
 * Crea una aplicación que simule la descarga de varios recursos desde internet.
 * Cada recurso se representa como un hilo independiente y tiene un tiempo de descarga aleatorio:
 * <p>
 * La descarga debe ejecutarse en paralelo.
 * Implementa un botón (o comando en consola) que permita cancelar todas las descargas simultáneamente.
 * Requisitos:
 * <p>
 * Usa Thread.sleep para simular el tiempo de descarga (entre 1 y 5 segundos por recurso).
 * Usa el método interrupt para detener todos los hilos en ejecución si el usuario decide cancelar las descargas.
 * Muestra un mensaje indicando qué descargas terminaron correctamente y cuáles fueron canceladas.
 * Extras:
 * <p>
 * Implementa un límite máximo de descargas simultáneas usando un Semaphore.
 */
public class Ejercicio3 implements Runnable {

    private final Thread hilo;
    private Semaphore semaforo = new Semaphore(2);

    public Ejercicio3() {
        hilo = new Thread(this);
    }

    @Override
    public void run() {
        try {
            semaforo.acquire();
            Random random = new Random();
            int tiempoAleatorio = 1 + random.nextInt(10);

            System.out.println(hilo.getName() + ", descarga iniciada");

            Thread.sleep(tiempoAleatorio * 1000);
            System.out.println(hilo.getName() + ", descarga en curso");

        } catch (InterruptedException e) {
            System.out.println("Error con el hilo " + e.getMessage());
        }
        semaforo.release();
        System.out.println(hilo.getName() + ", descarga finalizada");
    }

    public static void main(String[] args) {
        Ejercicio3 h1 = new Ejercicio3();
        Ejercicio3 h2 = new Ejercicio3();
        Ejercicio3 h3 = new Ejercicio3();

        h1.hilo.start();
        h2.hilo.start();
        h3.hilo.start();
    }
}
