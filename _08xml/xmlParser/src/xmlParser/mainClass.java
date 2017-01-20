package xmlParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;





public class mainClass {

	public static void main(String[] args) {
		Document xml = null;
		
		try {
			InputSource is = new InputSource(new FileReader("C:/tmp/clients.xml"));
			xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
			
			//Root Element 취득
			Element element = xml.getDocumentElement();
			
			//Root Element의 자식 node목록 취득
			NodeList list = element.getChildNodes();
				
			if(list.getLength() > 0){
				for(int i = 0; i<list.getLength(); ++i){
					//자식 태그를 한번 더 취득
					NodeList childList = list.item(i).getChildNodes();
					
					if(childList.getLength() > 0){
						for(int j = 0; j< childList.getLength(); j++){
							if(childList.item(j).getNodeName().equals("#text")==false){
								System.out.println("XML 태그 명 : " + childList.item(j).getNodeName() + "," 
										+"XML 값 : " + childList.item(j).getTextContent());
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}











