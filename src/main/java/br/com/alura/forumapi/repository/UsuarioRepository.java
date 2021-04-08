package br.com.alura.forumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forumapi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
