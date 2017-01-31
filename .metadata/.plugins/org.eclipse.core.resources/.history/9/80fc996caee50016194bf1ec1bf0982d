package br.com.listadetarefas.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.listadetarefas.model.Tarefa;
import br.com.listadetarefas.service.TarefaService;

@CrossOrigin(origins="*")
@RestController
public class TarefaController {

	@Autowired
	TarefaService tarefaService;
	
	// Routes (End Points)
	
	@RequestMapping(method=RequestMethod.GET, value="/tarefas", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Tarefa>> retornarTarefas() {
		
		Collection<Tarefa> tarefas = tarefaService.buscaTarefas();
		
		return new ResponseEntity<>(tarefas, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/tarefas/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tarefa> retornaTarefaEspecifica(@PathVariable Long id) {
		
		Tarefa tarefa = tarefaService.buscaPorId(id);
		
		if(tarefa == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(tarefa, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/tarefas", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tarefa> cadastrarTarefa(@RequestBody Tarefa tarefa) {
		
		Tarefa tarefaCadastrado = tarefaService.salvarNoBanco(tarefa);
		
		return new ResponseEntity<>(tarefaCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/tarefas", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tarefa> editarTarefa(@RequestBody Tarefa tarefa) {
		
		Tarefa tarefaEditada = tarefaService.salvarNoBanco(tarefa);
		
		return new ResponseEntity<>(tarefaEditada, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/tarefas/{id}")
	public ResponseEntity<Tarefa> removerTarefa(@PathVariable Long id) {
		
		Tarefa tarefaEncontrada = tarefaService.buscaPorId(id);
		
		if(tarefaEncontrada == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		tarefaService.excluirTarefa(tarefaEncontrada);
		return new ResponseEntity<>(HttpStatus.OK);
	}	
}