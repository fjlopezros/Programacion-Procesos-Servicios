package trimestre1.tema2.prueba00_hilo;

public class Main01 {
    public static void main(String[] args) {
        Mouse01 raton = new Mouse01("yerry", 2);
        Mouse01 raton1 = new Mouse01("perez", 5);
        Mouse01 raton2 = new Mouse01("micky", 4);
        Mouse01 raton3 = new Mouse01 ("stuard", 1);

        long ini = System.currentTimeMillis();

        raton.start();
        raton1.start();
        raton2.start();
        raton3.start();

//        raton.run();
//        raton1.run();
//        raton2.run();
//        raton3.run();

        long fin = System.currentTimeMillis();

        double tiempoTranscurrido = (double) (fin - ini) / Mouse01.SEG_MILL;
        System.out.printf("Ha trancurrido %.2f segundos \n", tiempoTranscurrido);
    }
}
