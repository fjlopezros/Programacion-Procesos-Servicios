package trimestre1.tema2.ejercicio06_exchanger;

import java.awt.*;
import java.util.concurrent.Exchanger;

public class Job implements Runnable{
    private Exchanger<String> exchanger;

    public Job(Exchanger<String> exchanger){
        this.exchanger = exchanger;
    }

    @Override
    public void run(){
        try {
            String mensajeEnviado ="Job te saluda";
            String mensajeRecibido = exchanger.exchange(mensajeEnviado);
            System.out.println("Soy Job mensaje recibido " + mensajeRecibido);
        } catch (InterruptedException e) {
            System.out.println("Error run() " + e.getMessage());
        }
    }
}
