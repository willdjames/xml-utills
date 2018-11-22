package br.leitura;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.model.Venda;

public class MainXmlToObj {

	public static void main(String[] args) throws JAXBException {
		
		
		JAXBContext context = JAXBContext.newInstance(Venda.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		Venda venda = (Venda) unmarshaller.unmarshal(new File("src/venda.xml"));
		
		System.out.println(venda);
	}
}
