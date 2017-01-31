package br.com.listadetarefas.controller;

import java.util.Collection;
import java.util.List;

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

import br.com.listadetarefas.model.ListaDeTarefas;
import br.com.listadetarefas.model.Tarefa;
import br.com.listadetarefas.service.ListaDeTarefasService;

@CrossOrigin(origins="*")
@RestController
public class ListaDeTarefasController {

	@Autowired
	ListaDeTarefasService listaDeTarefasService;
	
	// Routes (End Points)
	
	@RequestMapping(method=RequestMethod.GET, value="/listaDeTarefas", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<ListaDeTarefas>> retornarListaDeTarefas() {
		
		Collection<ListaDeTarefas> listaDeTarefas = listaDeTarefasService.buscaTarefas();
		
		return new ResponseEntity<>(listaDeTarefas, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/listaDeTarefas/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListaDeTarefas> retornaListaDeTarefasEspecifica(@PathVariable Long id) {
		
		ListaDeTarefas listaDeTarefas = listaDeTarefasService.buscaPorId(id);
		
		if(listaDeTarefas == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(listaDeTarefas, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/listaDeTarefas", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListaDeTarefas> cadastrarTarefa(@RequestBody ListaDeTarefas listaDeTarefas) {
		
		ListaDeTarefas listaDeTarefasCadastradas = listaDeTarefasService.salvarNoBanco(listaDeTarefas);
		
		return new ResponseEntity<>(listaDeTarefasCadastradas, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/listaDeTarefas", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListaDeTarefas> editarTarefa(@RequestBody ListaDeTarefas listaDeTarefas) {
		
		ListaDeTarefas listaDeTarefasEditada = listaDeTarefasService.salvarNoBanco(listaDeTarefas);
		
		return new ResponseEntity<>(listaDeTarefasEditada, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/listaDeTarefas/{id}")
	public ResponseEntity<Tarefa> removerTarefa(@PathVariable Long id) {
		
		ListaDeTarefas listaDeTarefasEncontrada = listaDeTarefasService.buscaPorId(id);
		
		if(listaDeTarefasEncontrada == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		listaDeTarefasService.excluirTarefa(listaDeTarefasEncontrada);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/listaDeTarefas/{id}/tarefas")
	public ResponseEntity<Collection<Tarefa>> retornarTodasTarefasDeUmaLista(@PathVariable Long id) {
		
		ListaDeTarefas listaDeTarefasEncontrada = listaDeTarefasService.buscaPorId(id);
		
		if(listaDeTarefasEncontrada == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<Tarefa> tarefas = listaDeTarefasEncontrada.getTarefas();
		
		return new ResponseEntity<>(tarefas, HttpStatus.OK);
	}
}