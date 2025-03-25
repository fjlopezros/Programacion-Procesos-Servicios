package trimestre2.tema4.urlConnection;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class DescargarFoto {
    public static void main(String[] args) {
        //URL de la foto
        String urlFoto = "https://www.pngkey.com/png/detail/14-148130_minion-imagenes-de-100x100-pixeles.png";
        try {
            //URL con instancia de URI
            URL url = new URI(urlFoto).toURL();

            //Abro una conexión hacia la url
            URLConnection connection = url.openConnection();

            //Cojo el flujo
            InputStream traerStream = connection.getInputStream();
            //Suelto el flujo
            OutputStream sueltoStream = new FileOutputStream("minion.png");

            //Voy leyendo el flujo que cojo para ir escribiendo donde lo suelte
            int byteLeido;
            while ((byteLeido = traerStream.read()) != -1) {
                sueltoStream.write(byteLeido);
            }

            //Cierro los stream
            sueltoStream.close();
            traerStream.close();

        } catch (URISyntaxException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
