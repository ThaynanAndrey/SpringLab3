package br.com.listadetarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.listadetarefas.model.SubTarefa;

@Repository
public interface SubTarefaRepository extends JpaRepository<SubTarefa, Long> {

}
