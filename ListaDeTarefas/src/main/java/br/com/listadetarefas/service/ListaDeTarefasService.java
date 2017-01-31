package br.com.listadetarefas.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.listadetarefas.model.ListaDeTarefas;
import br.com.listadetarefas.repository.ListaDeTarefasRepository;

@Service
public class ListaDeTarefasService {

	
	@Autowired
	private ListaDeTarefasRepository listaDeTarefasRepository;
	
	public ListaDeTarefas salvarNoBanco(ListaDeTarefas listaDetarefas) {
		
		return listaDeTarefasRepository.save(listaDetarefas);
	}
	
	public Collection<ListaDeTarefas> buscaTarefas() {
		
		return this.listaDeTarefasRepository.findAll();
	}
	
	public void excluirTarefa(ListaDeTarefas tarefa) {
		this.listaDeTarefasRepository.delete(tarefa);
	}
	
	public ListaDeTarefas buscaPorId(Long id) {
		return this.listaDeTarefasRepository.findOne(id);
	}
}