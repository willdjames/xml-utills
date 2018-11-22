package br.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType( XmlAccessType.FIELD)
public class Produto {

	private String nome;
	
	@XmlElement(name="valor")
	private Double preco;

	public Produto(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	public Produto() {
	}

	public String getNome() {
		return nome;
	}

	public Double getPreco() {
		return preco;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "{"+ this.nome+ ", "+ this.preco+ "}";
	}
	
	
}
