package trimestre2.tema4.gson;

//Clase Post para representar un objeto
// en Java que coincide con la estructura
// de los datos JSON que recibes de una API
public class Post {
    //Atributos
    private int userId;
    private int id;
    private String title;
    private String body;

    //Getters
    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
