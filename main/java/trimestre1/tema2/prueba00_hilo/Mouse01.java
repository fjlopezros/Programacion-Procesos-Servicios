package trimestre1.tema2.prueba00_hilo;

public class Mouse01 extends Thread{

    private String nombre;
    private int tiempoComiendo;
    public static final int SEG_MILL = 1000;

    public Mouse01(String nombre, int tiempoComiendo){
        this.nombre = nombre;
        this.tiempoComiendo = tiempoComiendo;
    }

    public void comer(){
        try {
            System.out.printf("El raton %s va a comer \n", nombre);
            Thread.sleep((long) tiempoComiendo * SEG_MILL);
            System.out.printf("---> El raton %s ya ha comido \n", nombre);
        } catch (InterruptedException e) {
            System.out.println("El proceso se ha interrumpido " + e.getMessage());
            //e.printStackTrace();
        }
    }
    public void run(){
        this.comer();
    }
}
