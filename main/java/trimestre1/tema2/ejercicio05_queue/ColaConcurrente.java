package trimestre1.tema2.ejercicio05_queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ColaConcurrente implements Runnable{

    public static Queue<Integer> cola = new ConcurrentLinkedDeque<>();
    private int numero;

    public ColaConcurrente(int numero){
        this.numero = numero;
    }

    @Override
    public void run(){
        cola.add(numero);
        System.out.println("Begin........... " + numero);

        for(Integer num: cola){
            System.out.print(num + " - ");
        }

        System.out.println("Tamaño de la cola " + cola.size());
        System.out.println("End........... " + numero);
    }
}
