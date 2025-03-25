package trimestre2.tema3.Ejercicio1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DireccionIP {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("localhost");
            System.out.println(ip);
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        }
    }
}
