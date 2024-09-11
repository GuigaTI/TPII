package br.edu.fatecpg.spring.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
public class ConsomeAPI {
    public static String obterMarcas(String tipo) throws IOException, InterruptedException {

        String url = "https://parallelum.com.br/fipe/api/v1/"+tipo+"/marcas";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String obterModelos(String tipo,int cdMarca) throws IOException, InterruptedException {

        String url = "https://parallelum.com.br/fipe/api/v1/"+tipo+"/marcas/"+cdMarca+"/modelos/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String obterAnos(String tipo,int cdMarca,int cdModelo) throws IOException, InterruptedException {

        String url = "https://parallelum.com.br/fipe/api/v1/"+tipo+"/marcas/"+cdMarca+"/modelos/"+cdModelo+"/anos/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String obterValores(String tipo,int cdMarca,int cdModelo,String ano) throws IOException, InterruptedException {

        String url = "https://parallelum.com.br/fipe/api/v1/"+tipo+"/marcas/"+cdMarca+"/modelos/"+cdModelo+"/anos/"+ano;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}
