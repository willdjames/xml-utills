package br.leitura;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.model.Produto;

public class MainLeitorXmlDOM {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		
//		Instancia a fabrica de criar documento na memoria
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
//		Forca o uso de .xsd para validar
		factory.setValidating(true);
//		Indica o uso do namespace no xml
		factory.setNamespaceAware(true);
//		Passa qual formato do schema sera usado
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");

//		Instancia a classe que monta o arquivo para a variavel
		DocumentBuilder builder = factory.newDocumentBuilder();
		
//		Coloca o documento da memoria e referencia para uma variavel
		Document document = builder.parse("src/venda.xml");
		
//		Cria uma expressao para compilar para XPath
		String expression = "/venda/produtos/produto";
		
//		Instancia a fabrica XPath
		XPath xPath = XPathFactory.newInstance().newXPath();
		
//		Compila a expressao acima
		XPathExpression xPathExpression = xPath.compile(expression);
		
//		Pesquisa na arvore DOM a expressao e retorna no caso uma lista de nos
		NodeList nodeList = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);
		
//		OU USA A SOLUCAO MAIS SIMPLES ABAIXO
		
//		Captura uma lista de tags com a refencia passada
//		NodeList nodeList = document.getElementsByTagName("produto");
		
//		Captura um atributo de uma tag
		String moeda = document.getDocumentElement().getAttribute("moeda");

		System.out.println("Moeda:"+ moeda);
		
//		Itera sobre todas as tags PRODUTO
		for(int i=0; i<nodeList.getLength(); i++) {
			
//			Captura o primeiro no da lista acima
			Element element = (Element) nodeList.item(i);
			
//			Captura o conteudo em texto da tag
			String nome = element.getElementsByTagName("nome").item(0).getTextContent();
			Double preco = Double.parseDouble(element.getElementsByTagName("valor").item(0).getTextContent());
			
			Produto produto = new Produto(nome, preco);
			
			System.out.println(produto);
		}
		
		
	}

}
