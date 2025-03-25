package trimestre1.tema2.ejercicio06_exchanger;

import java.util.concurrent.Exchanger;

public class QueTeDen implements Runnable {

    private Exchanger<String> exchanger;

    public QueTeDen(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            String mensajeEnviado = "Que te Den";
            String mensajeRecibido = exchanger.exchange(mensajeEnviado);
            System.out.println("Soy Que te Den mensaje recibido " + mensajeRecibido);
        } catch (InterruptedException e) {
            System.out.println("Error run() " + e.getMessage());
        }
    }
}
