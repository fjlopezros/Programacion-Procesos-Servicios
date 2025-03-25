package trimestre1.repaso.hilosRepaso;

import java.util.LinkedList;
import java.util.Queue;

public class Cola {
    public static void main(String[] args) {
        Queue<String> cola = new LinkedList<>();

        //Enqueue: Añadir elementos
        cola.add("Elemento 1");
        cola.add("Elemento 2");

        //Mostar todos los elementos
        for(String c : cola){
            System.out.println(c);
        }

        //Peek: Ver el primer elemento
        System.out.println("Primer elemento: " + cola.peek());

        //Dequeue: Eliminar elementos de la cola
        System.out.println("Removido: " + cola.poll());

        //Verificar si esta vacia
        System.out.println("¿Esta vacia? " + cola.isEmpty());

        //Eliminar el ultimo elemento
        System.out.println("Removido: " + cola.poll());

        System.out.println("¿Esta vacia? " + cola.isEmpty());
    }
}
