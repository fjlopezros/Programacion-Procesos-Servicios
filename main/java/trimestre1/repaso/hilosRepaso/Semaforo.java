package trimestre1.repaso.hilosRepaso;

import java.util.LinkedList;
import java.util.Queue;

public class Semaforo implements Runnable {

    private Queue<Thread> cola;
    private Thread hilo;
    private String nombre;
    private int valorInicial;

    public Semaforo(int valorInicial, String nombre) {
        hilo = new Thread(this, nombre);
        this.valorInicial = valorInicial;
        cola = new LinkedList<>();
    }

    public synchronized void waitSemaphore() {
        valorInicial--;
        if(valorInicial < 0){
            try {
                cola.add(Thread.currentThread());
                wait();
            }catch(InterruptedException e){
                System.out.println("Error waitSemaphore");
            }
        }
    }

    public synchronized void signalSemaphore() {
        valorInicial++;
        if(valorInicial <= 0){
            Thread hilo = cola.poll();
            if(hilo != null){
                notifyAll();
            }
        }
    }

    @Override
    public void run() {
        waitSemaphore();
        System.out.println(Thread.currentThread().getName() + " está ejecutando.");
        try {
            Thread.sleep(2000); // Simula una tarea
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        signalSemaphore();
    }

    public void start() {
        hilo.start();
    }

    public static void main(String[] args) {
        Semaforo semaforo = new Semaforo(1, "Semaforo Compartido");

        Thread hilo1 = new Thread(semaforo, "Hilo 1");
        Thread hilo2 = new Thread(semaforo, "Hilo 2");

        hilo1.start();
        hilo2.start();
    }

}
