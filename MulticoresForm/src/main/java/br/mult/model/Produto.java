package br.mult.model;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min=3, max=20, message="O tamanho do nome deve ser entre {min} e {max}")
	private String nome;
	
	@NotNull
	@Size(min=3, max=300, message="O tamanho do descricao deve ser entre {min} e {max}")
	private double valor;
	
	private Blob a;
	public Produto() {
		
	}
	
	public Produto(Long id, String nome, double valor){
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	
}
