package br.edu.fatecpg.spring.ConsomeAPI.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record Serie(
        @JsonAlias("Title") String titulo,

        @JsonAlias("Runtime") String duraco,

        @JsonAlias("Country") String pais,

        @JsonAlias("Poster") String poster) {

    @Override
    public String toString() {
        return "Serie: " +
                "Titulo: " + titulo + '\n' +
                "Duração: " + duraco + '\n' +
                "Pais: " + pais + '\n' +
                "Poster " + poster + '\n';
    }
}

