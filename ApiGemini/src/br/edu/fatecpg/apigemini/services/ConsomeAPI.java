package br.edu.fatecpg.apigemini.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsomeAPI {

    private static final String API_KEY = "Digite a chave da sua API aqui";
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=" + API_KEY;
    private static final Pattern RESP_PATTERN =
            Pattern.compile("\"text\"\\s*:\\s*\"([^\"]+)\"");


    //fazerPergunta()
    public static String fazerPergunta(String pergunta) throws IOException, InterruptedException {
        if(apiDisponivel()){
            String jsonRequest = gerarJsonRequest(pergunta);
            String respostaJson = enviarRequisicao(jsonRequest);
            return extrairReposta(respostaJson);
        }
        else{
            return "API Indisponivel";
        }

    }

    private static String extrairReposta(String respostaJson) {
            StringBuilder resposta = new StringBuilder();
            for (String linha : respostaJson.lines().toList()) {
                Matcher matcher = RESP_PATTERN.matcher(linha);
                if (matcher.find()) {
                    resposta.append(matcher.group(1)).append(" ");
                }
            }
            return "Resposta: " + resposta.toString().trim();
        }
    private static boolean apiDisponivel() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.statusCode() == 200; // Verifica se o status é 200 OK
        } catch (Exception e) {
            return false; // Se houver qualquer exceção, considera a API como não disponível
        }
    }

    private static String enviarRequisicao(String jsonRequest) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }

    //gerarJsonRequest()
    private static String gerarJsonRequest(String pergunta) {
        String promptFormatado = "O resultado gerado não deve possuir caracteres especiais:" + pergunta;
        return "{\"contents\":[{\"parts\":[{\"text\":\""+promptFormatado+"\"}]}]}";
    }
}
