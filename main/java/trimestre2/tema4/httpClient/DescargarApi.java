package trimestre2.tema4.httpClient;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class DescargarApi {
    public static void main(String[] args) {
        //Atributos
        String url = "https://jsonplaceholder.typicode.com/posts/18";
        String esquema = "https://";
        String servidor = "dle.rae.es/";
        String recurso = "Efímero".toLowerCase();
        String path = "rae.html";

        //Descargo el archivo si el estado del código es válido
        int codigoEstado = guardarPagina(url, path);
        System.out.println(
                (codigoEstado == HttpURLConnection.HTTP_OK)
                        ? "Descarga completada: " + path
                        : "Error en la descarga, código: " + codigoEstado
        );

    }

    private static int guardarPagina(String url, String path) {
        //Formato utf8
        //recurso = URLEncoder.encode(recurso, StandardCharsets.UTF_8);
        //Construir la dirección
        //String direccion = esquema + servidor + recurso;

        //Http cliente
        try (HttpClient cliente = HttpClient
                .newBuilder() //Inicia la construcción de la petición
                .version(HttpClient.Version.HTTP_1_1) //Version 1
                .followRedirects(HttpClient.Redirect.NORMAL) // Redirección automática (soporta GET y HEAD)
                .build()) // Construye la petición
        {

            // Petición
            HttpRequest peticion = HttpRequest
                    .newBuilder() // Inicia la construcción de la petición
                    .GET() // Petición GET
                    .uri(URI.create(url)) //Definir la URL de la petición
                    //.headers("Content-Type", "text/plain") // Añade la cabecera Content-Type
                    //.setHeader("User-Agent", "Mozilla/5.0") // Añade el encabezado User-Agent
                    .build(); // Construye la petición

            //Respuesta
            HttpResponse<Path> respuesta = cliente
                    .send(peticion, //Envía la petición
                            HttpResponse. // Como guardar la respuesta
                                    BodyHandlers. // Guarda el cuerpo de la respuesta
                                    ofFile(Path.of(path))); // Convierte la ruta(String) en un objeto Path

            return respuesta.statusCode();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
