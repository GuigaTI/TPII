package br.edu.fatecpg.spring.ConsomeAPI.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsomeAPI {

    public static String obterDado() throws IOException, InterruptedException {

        String url = "https://www.omdbapi.com/?t="+pedirDado()+"&apikey=212353bf";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String pedirDado(){
        Scanner scan = new Scanner((System.in));
        String titulo;
        titulo = scan.nextLine();
        titulo = titulo.replaceAll(" ","+");
        return titulo;
    }

}
