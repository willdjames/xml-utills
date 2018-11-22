package br.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Venda {

	
	private String formaPagamento;
	
	@XmlElementWrapper(name="produtos")
	@XmlElement(name="produto")
	private List<Produto> produtos;
	
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public String getFormaDePagamento() {
		return formaPagamento;
	}
	
	public void setFormaDePagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	@Override
	public String toString() {
	
		return "{ "+ formaPagamento + ", "+ produtos+" }";
	}
	
}
