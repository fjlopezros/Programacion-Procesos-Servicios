package trimestre1.repaso.hilosRepaso;

public class Interrumpir implements Runnable {

    Thread hilo;

    public Interrumpir(String nombre) {
        hilo = new Thread(this, nombre);
    }

    @Override
    public void run() {
        int numeroRoto = 17;
        for (int i = 0; i < 50; i++) {
            System.out.println("El hilo está corriendo. " + hilo.getName() + " -- " + i);
            if(i == numeroRoto){
                hilo.interrupt();
                System.out.println("********** Interrumpido -- " + i + " **********");
            }
        }
    }
    public void start(){
        hilo.start();
    }
    public static void main(String[] args) throws InterruptedException {
        Interrumpir h1 = new Interrumpir("Pepe");
        h1.start();
    }
}
