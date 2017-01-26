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

import br.com.listadetarefas.model.Tarefa;
import br.com.listadetarefas.service.TarefaService;

@RestController
public class TarefaController {

	@Autowired
	TarefaService tarefaService;
	
	// Routes (End Points)
	
	@RequestMapping(method=RequestMethod.GET, value="/tarefas", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Tarefa>> retornarClientes() {
		
		Collection<Tarefa> tarefas = tarefaService.buscaTarefas();
		
		return new ResponseEntity<>(tarefas, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/tarefas", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tarefa> cadastrarCliente(@RequestBody Tarefa tarefa) {
		
		Tarefa tarefaCadastrado = tarefaService.salvarNoBanco(tarefa);
		
		return new ResponseEntity<>(tarefaCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/tarefas/{id}")
	public ResponseEntity<Tarefa> removerCliente(@PathVariable Long id) {
		
		Tarefa tarefaEncontrada = tarefaService.buscaPorId(id);
		
		if(tarefaEncontrada == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		tarefaService.excluirTarefa(tarefaEncontrada);
		return new ResponseEntity<>(HttpStatus.OK);
	}	
}