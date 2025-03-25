package trimestre1.tema2.ejercicio07_semaphore;

import java.util.concurrent.Semaphore;

public class MainSemaforo {
    public static void main(String[] args) {
        Semaphore timbre = new Semaphore(1, true);
        Semaphore asientos = new Semaphore(4, true);

        for(int i = 0; i < 4; i++){
            new Visitante(timbre, asientos, ("pepe" + i)).start();
        }
    }
}
