package br.com.alura.forumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forumapi.model.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {

}
