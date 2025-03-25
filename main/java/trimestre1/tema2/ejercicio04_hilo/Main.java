package trimestre1.tema2.ejercicio04_hilo;

public class Main {
    public static void main(String[] args) {
        Thread hilo = new Thread(new Hilo2());

        System.out.println("Estado del hilo: " + hilo.getState());

        hilo.start();
        System.out.println("Estado del hilo: " + hilo.getState());

        hilo.interrupt();

        try{
            hilo.join();

        }catch(InterruptedException e){
            System.out.println("Error " + e.getMessage());
        }

        System.out.println("Estado del hilo: " + hilo.getState());
    }
}
