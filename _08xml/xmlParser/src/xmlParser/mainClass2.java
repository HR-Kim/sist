package xmlParser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class mainClass2 {

	public static void main(String[] args) {
		File file = new File("./WebContent/clients.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			
			doc.getDocumentElement().normalize();
			
			NodeList nodeList = doc.getElementsByTagName("고객");
			Node fstNode = nodeList.item(0);
			Element fstElement = (Element) fstNode;
			NodeList fstnodeElementList = fstElement.getElementsByTagName("주소");
			
			Element fstnodeElement = (Element) fstnodeElementList.item(0);
			
			NodeList fstNm = fstnodeElement.getChildNodes();
			
			System.out.println("URL : " + ((Node) fstNm.item(0)).getNodeValue());
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
