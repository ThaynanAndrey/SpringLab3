package br.com.listadetarefas.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "LISTA_DE_TAREFA")
public class ListaDeTarefas {

	@Id
	@Column(name="LISTA_DE_TAREFA_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
    @NotBlank
	@Column(name="NOME")
	private String nome;
	
	@OneToMany(targetEntity = Tarefa.class, mappedBy = "listaDeTarefas", cascade = CascadeType.ALL)
    private List<Tarefa> tarefas;

	public ListaDeTarefas(Long id, String nome, List<Tarefa> tarefas) {
		super();
		this.id = id;
		this.nome = nome;
		this.tarefas = tarefas;
	}

	public ListaDeTarefas() {
		//Default
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
}