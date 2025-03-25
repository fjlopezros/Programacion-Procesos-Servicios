package trimestre1.tema2.ejercicio04_hilo;

public class Hilo implements Runnable{

    @Override
    public void run() {
        int i = 0;
        while(i < 100){
            if(Thread.interrupted()){
                System.out.println("Interrumpido " + i);
            }
            i++;
        }
    }
}
