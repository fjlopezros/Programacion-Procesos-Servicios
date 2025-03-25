package trimestre1.tema2.ejercicio06_exchanger;

import java.util.concurrent.Exchanger;

public class Task implements Runnable{
    private Exchanger<String> exchanger;

    public Task(Exchanger<String> exchanger){
        this.exchanger = exchanger;
    }

    @Override
    public void run(){
        try {
            String mensajeEnviado = "Saludos desde Task";
            String mensajeRecibido = exchanger.exchange(mensajeEnviado);
            System.out.println("Soy Task mensaje recibido " + mensajeRecibido);
        } catch (InterruptedException e) {
            System.out.println("Error run() " + e.getMessage());
        }
    }
}
