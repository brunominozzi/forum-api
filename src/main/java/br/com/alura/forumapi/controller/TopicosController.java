package br.com.alura.forumapi.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forumapi.controller.dto.TopicoDto;
import br.com.alura.forumapi.controller.form.TopicoForm;
import br.com.alura.forumapi.model.Topico;
import br.com.alura.forumapi.repository.CursoRepository;
import br.com.alura.forumapi.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
	
	@Autowired
	private TopicoRepository repository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<TopicoDto> list(String nomeCurso){
		
		if(nomeCurso == null) {
			List<Topico> topicos = repository.findAll();
			return TopicoDto.converter(topicos);
		} else {
			List<Topico> topicos = repository.carregarPorNomeDoCurso(nomeCurso);
			return TopicoDto.converter(topicos);
		}
		
	}

	@PostMapping
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm  form, UriComponentsBuilder uriBuilder) {
		
		Topico topico = form.converter(cursoRepository);
		repository.save(topico);
		  
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri(); 
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}
}
