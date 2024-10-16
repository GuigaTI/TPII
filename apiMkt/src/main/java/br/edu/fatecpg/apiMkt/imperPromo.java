package br.edu.fatecpg.apiMkt;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class imperPromo {
    public static void promo(int val) throws IOException, InterruptedException {
        String json = consomeAPI.consomeApi();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        List<JsonNode> jsonList = new ArrayList<>();
        jsonNode.forEach(jsonList::add);
        List<String> promoList = jsonList.stream()
                .filter(node -> node.get("price").asInt() <= val)
                .map(node -> node.get("title").asText())
                .map(String::toUpperCase)
                .toList();

        System.out.println("Número de promoções encontradas: " + promoList.size());
        promoList.forEach(System.out::println);
    }
    public static void imper() throws IOException, InterruptedException {
        String json = consomeAPI.consomeApi();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        List<JsonNode> jsonList = new ArrayList<>();
        jsonNode.forEach(jsonList::add);
        List<String> imperList = jsonList.stream()
                .filter(node -> node.get("price").asInt() <= 30)
                .map(node -> node.get("title").asText())
                .toList();

        System.out.println("Número de promoções encontradas: " + imperList.size());
        imperList.forEach(System.out::println);
    }
}
