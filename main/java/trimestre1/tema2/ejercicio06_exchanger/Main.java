package trimestre1.tema2.ejercicio06_exchanger;

import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(new Task(exchanger)).start();
        new Thread(new Job(exchanger)).start();
        new Thread(new QueTeDen(exchanger)).start();
        new Thread(new ATiTambien(exchanger)).start();
    }
}
