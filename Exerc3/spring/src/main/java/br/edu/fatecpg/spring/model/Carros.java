package br.edu.fatecpg.spring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record Carros(@JsonAlias("Marca") String marca,

                    @JsonAlias("Valor") String valor,

                    @JsonAlias("Modelo") String modelo,

                    @JsonAlias("AnoModelo") String ano,

                    @JsonAlias("Combustivel") String combustivel)
{

    @Override
    public String toString() {
        return  "Marca: " + marca + '\n' +
                "Valor: " + valor + '\n' +
                "Modelo: " + modelo + '\n' +
                "Ano: " + ano + '\n' +
                "Combustivel: " + combustivel + '\n';
    }
}