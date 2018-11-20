package br.leitura;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.handler.ProdutoHandler;

public class MainLeitorXml2 {
	
	public static void main(String[] args) throws SAXException, IOException {
		
//		Prepara o source para leitura
		InputStream byteStream = new FileInputStream("src/venda.xml");
		InputSource input = new InputSource(byteStream);
		
//		Fabrica para ler o arquivo
		XMLReader reader = XMLReaderFactory.createXMLReader();

//		Instancia a logica do leitor
		ProdutoHandler handler = new ProdutoHandler();

//		Le o conteudo
		reader.setContentHandler(handler);

//		Recebe o arquivo source
		reader.parse(input);
		
		System.out.println(handler.arrayList);
		
		
	}

}
