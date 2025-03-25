package trimestre2.tema3.ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatCliente {
    public static void main(String[] args) throws IOException {
        Socket cliente = new Socket(
                ChatServer.SERVER_HOSTNAME,
                ChatServer.SERVER_PORT
        );

        BufferedReader recibir = new BufferedReader(
                new InputStreamReader(cliente.getInputStream())
        );
        PrintWriter enviar = new PrintWriter(
                cliente.getOutputStream(),
                true
        );

        BufferedReader leerTeclado = new BufferedReader(
                new InputStreamReader(System.in)
        );

        String nombreUsuario = System.getProperty("user.name");

        String mensaje = "";
        while (isFinished(mensaje)) {
            System.out.printf("%s>>", nombreUsuario);
            mensaje = leerTeclado.readLine();

            if (isFinished(mensaje)) {
                enviar.println(nombreUsuario + ": " + mensaje);
                System.out.println("Servidor: " + recibir.readLine());
            }
        }
        cliente.close();
    }
    private static boolean isFinished(String mensaje){
        return !mensaje.equals(ChatServer.COMMAND_CHAT_END);
    }
}
