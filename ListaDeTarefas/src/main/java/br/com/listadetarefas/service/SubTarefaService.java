package br.com.listadetarefas.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.listadetarefas.model.SubTarefa;
import br.com.listadetarefas.repository.SubTarefaRepository;

@Service
public class SubTarefaService {

	@Autowired
	private SubTarefaRepository subTarefaRepository;
	
	public SubTarefa salvarNoBanco(SubTarefa subTarefa) {
		
		return subTarefaRepository.save(subTarefa);
	}
	
	public Collection<SubTarefa> buscaSubTarefas() {
		
		return this.subTarefaRepository.findAll();
	}
	
	public void excluirSubTarefa(SubTarefa subTarefa) {
		this.subTarefaRepository.delete(subTarefa);
	}
	
	public SubTarefa buscaPorId(Long id) {
		
		return this.subTarefaRepository.findOne(id);
	}	
}