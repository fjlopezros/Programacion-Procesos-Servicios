package trimestre1.repaso.procesosRepaso;

import java.io.IOException;

public class Proceso {
    public static void main(String[] args){
        ProcessBuilder proceso = new ProcessBuilder();
        proceso.command("ping", "-n", "3", "google.com");
        try {
            Process process = proceso.start();
            System.out.println("Id del proceso: " + process.pid());

            int exitCode = process.waitFor();
            System.out.println("Se espera un 0 -> " + exitCode);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("El proceso fue interrumpido: " + e.getMessage());
        }
    }
}
