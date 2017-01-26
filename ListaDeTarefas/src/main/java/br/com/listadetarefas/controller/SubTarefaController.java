package br.com.listadetarefas.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.listadetarefas.model.SubTarefa;
import br.com.listadetarefas.service.SubTarefaService;

@RestController
public class SubTarefaController {

	@Autowired
	SubTarefaService subTarefaService;
	
	// Routes (End Points)
	
	@RequestMapping(method=RequestMethod.GET, value="/subtarefas", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<SubTarefa>> retornarSubTarefas() {
		
		Collection<SubTarefa> subTarefas = subTarefaService.buscaSubTarefas();
		
		return new ResponseEntity<>(subTarefas, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/subtarefas/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SubTarefa> retornaTarefaEspecifica(@PathVariable Long id) {
		
		SubTarefa subTarefa = subTarefaService.buscaPorId(id);
		
		return new ResponseEntity<>(subTarefa, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/subtarefas", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SubTarefa> cadastrarCliente(@RequestBody SubTarefa subTarefa) {
		
		SubTarefa subTarefaCadastrada = subTarefaService.salvarNoBanco(subTarefa);
		
		return new ResponseEntity<>(subTarefaCadastrada, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/subtarefas/{id}")
	public ResponseEntity<SubTarefa> removerCliente(@PathVariable Long id) {
		
		SubTarefa subTarefaEncontrada = subTarefaService.buscaPorId(id);
		
		if(subTarefaEncontrada == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		subTarefaService.excluirSubTarefa(subTarefaEncontrada);
		return new ResponseEntity<>(HttpStatus.OK);
	}	
}