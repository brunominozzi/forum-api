package br.com.alura.forumapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forumapi.controller.dto.TopicoDto;
import br.com.alura.forumapi.model.Topico;
import br.com.alura.forumapi.repository.TopicoRepository;

@RestController
public class TopicosController {
	
	@Autowired
	private TopicoRepository repository;
	
	@RequestMapping("/topicos")
	public List<TopicoDto> list(@RequestParam String nomeCurso){
		
		if(nomeCurso == null) {
			List<Topico> topicos = repository.findAll();
			return TopicoDto.converter(topicos);
		} else {
			List<Topico> topicos = repository.carregarPorNomeDoCurso(nomeCurso);
			return TopicoDto.converter(topicos);
		}
		
	}

}
