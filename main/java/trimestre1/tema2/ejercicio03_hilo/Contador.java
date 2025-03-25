package trimestre1.tema2.ejercicio03_hilo;

public class Contador {
    private int contador;

    public int getContador(){
        return contador;
    }

    synchronized public int incrementa(){
        return contador++;
    }
}
