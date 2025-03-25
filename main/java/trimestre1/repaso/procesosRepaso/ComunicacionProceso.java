package trimestre1.repaso.procesosRepaso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ComunicacionProceso {
    public static void main(String[] args) {
        ProcessBuilder proceso = new ProcessBuilder();
        proceso.command("ping", "-n", "3", "google.com");
        try {
            Process process = proceso.start();
            System.out.println("Id del proceso: " + process.pid());

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("Se espera un 0 -> " + exitCode);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("El proceso fue interrumpido: " + e.getMessage());
        }
    }
}
