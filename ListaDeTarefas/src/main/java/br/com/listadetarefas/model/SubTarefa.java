package br.com.listadetarefas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "SUBTAREFA")
public class SubTarefa {

	@Id
	@Column(name="SUB_TAREFA_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
    @NotBlank
	@Column(name="NOME")
	private String nome;
	
	@Column(name="realizada")
	private Boolean realizada;
	
	@ManyToOne
    @JoinColumn(name = "TAREFA_ID")
    private Tarefa tarefa;

	public SubTarefa() {
		// default
	}
	
	public SubTarefa(Long id, String nome, Boolean realizada, Tarefa tarefa) {
		this.id = id;
		this.nome = nome;
		this.realizada = realizada;
		this.tarefa = tarefa;
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

	public Boolean getRealizada() {
		return realizada;
	}

	public void setRealizada(Boolean realizada) {
		this.realizada = realizada;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
}