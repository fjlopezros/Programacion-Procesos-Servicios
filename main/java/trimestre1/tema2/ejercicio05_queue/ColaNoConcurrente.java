package trimestre1.tema2.ejercicio05_queue;

import java.util.LinkedList;
import java.util.Queue;

public class ColaNoConcurrente implements Runnable{
    public static Queue<Integer> cola = new LinkedList<Integer>();
    private int numero;

    public ColaNoConcurrente(int numero){
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