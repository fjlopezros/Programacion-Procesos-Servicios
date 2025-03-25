package trimestre1.tema2.ejercicio06_exchanger;

import java.util.concurrent.Exchanger;

public class ATiTambien implements Runnable{
    private Exchanger<String> exchanger;

    public ATiTambien(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            String mensajeEnviado = "ATiTambien";
            String mensajeRecibido = exchanger.exchange(mensajeEnviado);
            System.out.println("Soy ATiTambien mensaje recibido " + mensajeRecibido);
        } catch (InterruptedException e) {
            System.out.println("Error run() " + e.getMessage());
        }
    }
}
