package jaxp.example;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.CharacterData;

public class JAXPParser {
	public static void main(String[] args) {
		DocumentBuilderFactory df;
		DocumentBuilder builder;
		Document document;

		try {
			df = DocumentBuilderFactory.newInstance();
			builder = df.newDocumentBuilder();
			document = builder.parse("src/jaxp/example/students.xml");

			NodeList studentNodesList = document.getElementsByTagName("student");

		    for (int i = 0; i < studentNodesList.getLength(); i++) {
		        Element studentItem = (Element) studentNodesList.item(i);
		        System.out.println(studentItem.getAttribute("id"));

		        NodeList studentItemChildNodes = studentItem.getChildNodes();
		        for (int j = 0; j < studentItemChildNodes.getLength(); j++) {
		            Node childNode = studentItemChildNodes.item(j);

		            // Element
		            if (childNode.getNodeType() == Node.ELEMENT_NODE && "name".equals(childNode.getNodeName())) {
		                System.out.println("name: " + childNode.getFirstChild().getNodeValue());
		            }

		            // Element
		            if (childNode.getNodeType() == Node.ELEMENT_NODE && "gender".equals(childNode.getNodeName())) {
		                System.out.println("gender: " + childNode.getFirstChild().getNodeValue());
		            }

		            // Comment
		            if (childNode.getNodeType() == Node.COMMENT_NODE) {
		                Comment comment = (Comment)childNode;
		                System.out.println("comment: " + comment.getData());
		            }

		            // CharacterData (CDATA)
		            if (childNode.getNodeType() == Node.CDATA_SECTION_NODE) {
		                CharacterData cData = (CharacterData)childNode;
		                System.out.println("CDATA: " + cData.getData());
		            }
		        }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
