package br.leitura;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import org.xml.sax.SAXException;

import br.model.Produto;

public class MainLeitorXmlStax {

	public static void main(String[] args) throws FileNotFoundException, SAXException, XMLStreamException {

//		Cria arquivo
		InputStream inputStream = new FileInputStream("src/venda.xml");

//		Cria fabrica
		XMLInputFactory factory = XMLInputFactory.newInstance();
		
//		Prepara o evento com leitor que recebe o arquivo
		XMLEventReader reader = factory.createXMLEventReader(inputStream);
		
		Produto produto = new Produto();
		
		List<Produto> list = new ArrayList<>();
		
//		Enquanto existir proximo evento
		while(reader.hasNext()) {
			
//			Captura o proximo evento
			XMLEvent event = reader.nextEvent();
			
//			Se eh comeco e a tag eh produto
			if(event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("produto")) {
				produto = new Produto();
//			Se eh comeco e eh nome
			}else if(event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("nome")) {
				event = reader.nextEvent();
				String characters = event.asCharacters().getData();
				produto.setNome(characters);
			}else if(event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("valor")) {
				event = reader.nextEvent();
				String data = event.asCharacters().getData();
				produto.setPreco(Double.parseDouble(data));
//			Finaliza a leitura se for fechamento da tag produto
			}else if(event.isEndElement() && event.asEndElement().getName().getLocalPart().equals("produto")) {
				list.add(produto);
			}
		}

		System.out.println(list);
	}

}
