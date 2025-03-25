package trimestre2.tema4.httpUrlConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class GetApi {
    public static void main(String[] args) {
        //URL de la API
        String urlApi = "https://rickandmortyapi.com/api/episode";
        try {
            //URL con instancia de URI
            URL url = new URI(urlApi).toURL();

            //HTTP URL CONNECTION
            HttpURLConnection connection;

            //Abro la conexión
            connection = (HttpURLConnection) url.openConnection();

            //Cambio la petición de la conexión
            connection.setRequestMethod("GET");

            //hago un buffered con el flujo de la conexión
            BufferedReader leerWeb = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String linea;

            //Voy leyendo y mostrando la web
            while ((linea = leerWeb.readLine()) != null) {
                System.out.println(linea);
            }

            //Cierro el buffered
            leerWeb.close();

        } catch (URISyntaxException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
