package trimestre1.tema2.ejercicio03_hilo;

public class Hilo implements Runnable{

    private int numHilo, miParte, miCuenta = 0;
    private Contador contador;

    public Hilo(int numHilo, int miParte, Contador contador){
        this.numHilo = numHilo;
        this.miParte = miParte;
        this.contador = contador;
    }

    @Override
    public void run() {
        for(int i = 0; i < miParte; i++){
            contador.incrementa();
            miCuenta++;
        }
        System.out.printf("Hilo de %d - miCuenta = %d\n", numHilo,miCuenta);
    }
}
