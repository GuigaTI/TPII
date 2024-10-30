package br.edu.fatecpg.aplicacaoJpa.repository;

import br.edu.fatecpg.aplicacaoJpa.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoBancoRepository extends JpaRepository<Endereco,Long> {
    boolean existsByCodigo(String codigo); // Verifica se o CEP já existe

    Optional<Endereco> findByCodigo(String codigo); }

