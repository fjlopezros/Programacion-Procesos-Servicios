package trimestre2.tema4.gson;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RespuestaGson {
    public static void main(String[] args) {
        String url = "https://jsonplaceholder.typicode.com/posts/18";
        try {
            //Creo un http cliente
            HttpClient cliente = HttpClient.newHttpClient();

            // Petición
            HttpRequest peticion = HttpRequest
                    .newBuilder() // Inicio la construcción de la petición
                    .uri(URI.create(url)) // URL de la petición
                    .GET() // petición GET
                    .build(); //Construyo la petición

            //Respuesta
            HttpResponse<String> respuesta = cliente
                    .send(peticion, //Envío la petición
                            HttpResponse. // Como guardar la respuesta
                                    BodyHandlers // Guarda el cuerpo de la respuesta
                                    .ofString()); // Guarda la respuesta como un String

            //Estado de la respuesta
            System.out.println("Codigo de estado: " + respuesta.statusCode());

            //Cuerpo de la respuesta
            String json = respuesta.body();
            System.out.println("Respuesta JSon: " + json);

            //Parsear el Json a Gson
            Gson gson = new Gson();
            Post post = gson.fromJson(json, Post.class);

            // Imprimir los datos del objeto Post
            System.out.println("- ID de usuario: " + post.getUserId());
            System.out.println("- ID del post: " + post.getId());
            System.out.println("- Título del post: " + post.getTitle());
            System.out.println("- Cuerpo del post: " + post.getBody());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
