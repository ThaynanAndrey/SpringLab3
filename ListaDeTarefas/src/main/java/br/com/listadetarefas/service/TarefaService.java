package br.com.listadetarefas.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.listadetarefas.model.Tarefa;
import br.com.listadetarefas.repository.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	public Tarefa salvarNoBanco(Tarefa tarefa) {
		
		return tarefaRepository.save(tarefa);
	}
	
	public Collection<Tarefa> buscaTarefas() {
		
		return this.tarefaRepository.findAll();
	}
	
	public void excluirTarefa(Tarefa tarefa) {
		this.tarefaRepository.delete(tarefa);
	}
	
	public void excluirTodasTarefas() {
		this.tarefaRepository.deleteAll();
	}
	
	public Tarefa buscaPorId(Long id) {
		return this.tarefaRepository.findOne(id);
	}
}