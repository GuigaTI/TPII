package br.edu.fatecpg.aplicacaoJpa.service;

import br.edu.fatecpg.aplicacaoJpa.model.Endereco;
import br.edu.fatecpg.aplicacaoJpa.repository.EnderecoBancoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EnderecoBanco {

    @Autowired
    private EnderecoBancoRepository EnderecoBancoRepository;

    // Salva um novo CEP se não existir
    public Endereco saveEndereco(Endereco cep) {
        if (cep == null) {
            return null; // Caso o cep não exista
        }
        // Verifica se o CEP já existe
        if (EnderecoBancoRepository.existsByCodigo(cep.getCodigo())) {
            return null;
        }
        return EnderecoBancoRepository.save(cep); // Salva o novo CEP
    }

    // Retorna todos os CEPs
    public List<Endereco> findEndereco() {
        return EnderecoBancoRepository.findAll();
    }

}

