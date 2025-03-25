package trimestre1.tema2.ejercicio02_hilo;

public class Main {
    public static void main(String[] args) {
        Thread hilo1 = new Thread(new Hilo("Pepe",3));
        Thread hilo2 = new Thread(new Hilo("Jose",3));
        System.out.println("Lanzamiento de hilo");
        try {
            hilo1.start();
            hilo2.start();

            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("Error hilo1 join() " + e.getMessage());
        }

        System.out.println("Fin del programa");
    }
}
