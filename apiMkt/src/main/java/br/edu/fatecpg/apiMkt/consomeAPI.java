package br.edu.fatecpg.apiMkt;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class consomeAPI {
    public static String consomeApi() throws IOException, InterruptedException {

        String url_produtos = "http://api.escuelajs.co/api/v1/products";

        //Client, Request, Response
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url_produtos)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
