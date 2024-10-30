package br.edu.fatecpg.aplicacaoJpa.controller;

import br.edu.fatecpg.aplicacaoJpa.model.Endereco;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class buscaEndereco {
    public static Endereco consultarCepNaApi(String codigo) {
        try {
            String urlString = "https://viacep.com.br/ws/" + codigo + "/json/";
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == 200) {
                ObjectMapper objectMapper = new ObjectMapper();
                Endereco cep = objectMapper.readValue(connection.getInputStream(), Endereco.class);
                return cep;
            }
        } catch (IOException e) {
            System.out.println("Erro ao consultar a API: " + e.getMessage());
        }
        return null; // Retorna null se não conseguir obter os dados
    }
}
