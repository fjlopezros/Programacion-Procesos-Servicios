package trimestre1.tema2.prueba00_hilo;

public class Main {
    public static void main(String[] args) {
        Mouse raton = new Mouse("yerry", 2);
        Mouse raton1 = new Mouse("perez", 5);
        Mouse raton2 = new Mouse("micky", 4);
        Mouse raton3 = new Mouse("stuard", 1);

        long ini = System.currentTimeMillis();


        raton.comer();
        raton1.comer();
        raton2.comer();
        raton3.comer();

        long fin = System.currentTimeMillis();

        double tiempoTranscurrido = (double) (fin - ini) / Mouse.SEG_MILL;
        System.out.printf("Ha trancurrido %.2f segundos \n", tiempoTranscurrido);
    }
}
