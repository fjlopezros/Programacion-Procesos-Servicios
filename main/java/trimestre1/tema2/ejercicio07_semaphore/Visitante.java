package trimestre1.tema2.ejercicio07_semaphore;

import java.util.concurrent.Semaphore;

public class Visitante implements Runnable {

    Thread hilo;
    Semaphore timbre;
    Semaphore asientos;

    public Visitante(Semaphore timbre,Semaphore asientos, String nombre) {
        hilo = new Thread(this, nombre);
        this.timbre = timbre;
        this.asientos = asientos;
    }


    @Override
    public void run() {
        System.out.println(hilo.getName() + " -- Llegando a casa");
        try {
            asientos.acquire();
            System.out.println(hilo.getName() + " -- Se sienta en el porche");

            timbre.acquire();

            System.out.println(hilo.getName() + " -- Tocando el timbre");
            Thread.sleep(10000);

            System.out.println(hilo.getName() + " -- Fin tocar timbre");
            timbre.release();

            System.out.println(hilo.getName() + " -- Deja libre un asiento en el porche");
            System.out.println(hilo.getName() + " -- Entra en casa");
            asientos.release();
        } catch (InterruptedException e) {
            System.out.println("Error run() " + e.getMessage());
        }
    }

    public void start() {
        hilo.start();
    }
}
