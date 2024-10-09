import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class buscaComentarios {
    public String consomeApi() throws IOException, InterruptedException {

        String url_comentarios="https://jsonplaceholder.typicode.com/comments";

        //Client, Request, Response
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url_comentarios)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
