package trimestre1.tema2.ejercicio01_reloj;

import javax.swing.*;
import java.time.LocalTime;

public class Reloj implements Runnable {
    private LocalTime time;
    private JLabel lb;
    private static final long op = 1000;

    public Reloj(JLabel lb) {
        this.lb = lb;
    }

    public void setTime() {
        while (true) {
            time = LocalTime.now();
            lb.setText(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond());
            System.out.println(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond());
            esperarDurante(1);
        }
    }

    private void esperarDurante(int segundos) {
        try {
            Thread.sleep(segundos * op);
        } catch (InterruptedException e) {
            System.out.println("Error esperarDurante(int segundos) " + e.getMessage());
        }
    }

    public void run() {
        this.setTime();
    }
}
