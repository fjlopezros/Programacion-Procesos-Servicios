package trimestre1.tema2.ejercicio05_queue;

public class Main {
    public static void main(String[] args) {

        for(int i = 0; i < 10; i++){
            new Thread(new ColaConcurrente(i)).start();
        }
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        System.out.println("TAMAÑO FINAL DE LA COLA " + ColaConcurrente.cola.size());
        System.out.println(ColaConcurrente.cola);
    }
}
