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
@Table(name = "TAREFA")
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
    @NotBlank
	@Column(name="NOME")
	private String nome;

	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="PRIORIDADE")
	private Prioridade prioridade;

	@Column(name="CATEGORIA")
	private Categoria categoria;
	
	@Column(name="realizada")
	private Boolean realizada;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tarefa")
    private List<SubTarefa> subtarefas;
	
	public Tarefa() {
		// default
	}
	
	public Tarefa(String nome, String descricao, Prioridade prioridade, Categoria categoria) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<SubTarefa> getSubtarefas() {
		return subtarefas;
	}

	public void setSubtarefas(List<SubTarefa> subtarefas) {
		this.subtarefas = subtarefas;
	}
	
	public Boolean getRealizada() {
		return realizada;
	}

	public void setRealizada(Boolean realizada) {
		this.realizada = realizada;
	}
}