package br.edu.fatecpg.spring.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface IConverteDado {

    <T> T obterDado(String json,Class<T> classe) throws JsonProcessingException;


}