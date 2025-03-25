package trimestre1.tema2.ejercicio02_hilo;

import java.time.Duration;

public class Hilo implements Runnable {

    private String nombreHilo;
    private int repeticion;


    public Hilo(String nombreHilo, int repeticion) {
        this.nombreHilo = nombreHilo;
        this.repeticion = repeticion;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < repeticion; i++) {
                System.out.println("Hilo " + nombreHilo + " - " + i);
                Thread.sleep(Duration.ofSeconds(5));
            }
        }catch(InterruptedException e){
            System.out.println("Error run() " + e.getMessage());
        }
        System.out.println("Cerrando hilo..." + nombreHilo);

    }
}
