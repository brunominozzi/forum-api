package br.com.alura.forumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forumapi.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nomeCurso);

}
