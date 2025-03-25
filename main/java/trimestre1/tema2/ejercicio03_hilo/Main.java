package trimestre1.tema2.ejercicio03_hilo;

public class Main {

    public static final int NUM_HILOS = 5;
    public static final int NUM_INCREMENTOS = 15;

    public static void main(String[] args) {
        Contador c = new Contador();
        Thread[] hilos = new Thread[NUM_HILOS];

        for (int i = 0; i < NUM_HILOS; i++) {
            hilos[i] = new Thread(new Hilo(i, NUM_INCREMENTOS / NUM_HILOS, c));
            hilos[i].start();
        }

        for (Thread h : hilos) {
            try {
                h.join();
            } catch (InterruptedException e) {
                System.out.println("Error " + e.getMessage());
            }
        }
        System.out.printf("Cuenta gloval: %s\n", c.getContador());
    }
}
