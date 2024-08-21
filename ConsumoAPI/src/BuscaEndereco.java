import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class BuscaEndereco {

    public String url(){
        System.out.println("Digite um cep: ");
        Scanner scan = new Scanner(System.in);

        return "https://viacep.com.br/ws/"+scan.nextLine()+"/json";
    }
    public String consomeAPI() throws IOException, InterruptedException {
        //Client,Request,Response

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url()))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());


        return response.body();
    }
}
