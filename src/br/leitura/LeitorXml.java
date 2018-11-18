package br.leitura;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.model.Produto;

public class LeitorXml extends DefaultHandler {
	
	private Produto produto;
	private StringBuilder builder;
	public List<Produto> arrayList  = new ArrayList<>();

//	Evento ao abrir a tag
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			
		if(qName.equalsIgnoreCase("produto")) {
			this.produto = new Produto();
		}
		
		builder = new StringBuilder();
	}
	
//	Le o conteudo da teg aberta
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		this.builder.append(new String(ch, start, length));
	}
	
	
//	Evento quando termina de ler a tag
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if(qName.equalsIgnoreCase("produto")) {
			arrayList.add(produto);
		}else if(qName.equalsIgnoreCase("nome")) {
			this.produto.setNome(builder.toString());
		}else if(qName.equalsIgnoreCase("valor")) {
			this.produto.setPreco(Double.parseDouble(this.builder.toString()));
		}
	}

}
