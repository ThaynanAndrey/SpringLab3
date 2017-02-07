package br.com.listadetarefas.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "TAREFA")
public class Tarefa {

	@Id
	@Column(name="TAREFA_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
    @NotBlank
	@Column(name="NOME")
	private String nome;

	@ManyToOne
    @JoinColumn(name = "LISTA_DE_TAREFA_ID")
    private ListaDeTarefas listaDeTarefas;

	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="PRIORIDADE")
	private String prioridade;

	@Column(name="CATEGORIA")
	private String categoria;
	
	@Column(name="realizada")
	private Boolean realizada;
	
	@OneToMany(mappedBy = "tarefa", cascade = CascadeType.ALL)
    private List<SubTarefa> subtarefas;
	
	public Tarefa(Long id, String nome, ListaDeTarefas listaDeTarefas, String descricao, String prioridade,
			String categoria, Boolean realizada, List<SubTarefa> subtarefas) {
		this.id = id;
		this.nome = nome;
		this.listaDeTarefas = listaDeTarefas;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.categoria = categoria;
		this.realizada = realizada;
		this.subtarefas = subtarefas;
	}

	public Tarefa() {
		// default
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

	public void setListaDeTarefas(ListaDeTarefas listaDeTarefas) {
		this.listaDeTarefas = listaDeTarefas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Boolean getRealizada() {
		return realizada;
	}

	public void setRealizada(Boolean realizada) {
		this.realizada = realizada;
	}

	public List<SubTarefa> getSubtarefas() {
		return subtarefas;
	}

	public void setSubtarefas(List<SubTarefa> subtarefas) {
		this.subtarefas = subtarefas;
	}
}