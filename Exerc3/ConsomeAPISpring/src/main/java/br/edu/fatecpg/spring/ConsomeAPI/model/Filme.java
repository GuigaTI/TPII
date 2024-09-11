package br.edu.fatecpg.spring.ConsomeAPI.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record Filme(@JsonAlias("Title") String titulo,

                    @JsonAlias("Runtime") String duraco,

                    @JsonAlias("Country") String pais,

                    @JsonAlias("Poster") String poster,

                    @JsonAlias("Genre") String genero)
{
    @Override
    public String toString() {
        return "Serie: " +
                "Titulo: " + titulo + '\n' +
                "Duração: " + duraco + '\n' +
                "Pais: " + pais + '\n' +
                "Genero " + genero + '\n' +
                "Poster " + poster + '\n';
    }
}
