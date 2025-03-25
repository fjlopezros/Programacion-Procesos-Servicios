package trimestre1.repaso.hilosRepaso;

public class Hilo implements Runnable {

    Thread hilo;

    public Hilo(String nombre) {
        hilo = new Thread(this, nombre);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("El hilo está corriendo. " + hilo.getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Error en el hilo");
            }
        }
    }
    public void start(){
        hilo.start();
    }
    public static void main(String[] args) throws InterruptedException {
        Hilo h1 = new Hilo("Pepe");
        Hilo h2 = new Hilo("Juan");

        h1.start();
        h1.hilo.join();
        h2.start();
    }
}
