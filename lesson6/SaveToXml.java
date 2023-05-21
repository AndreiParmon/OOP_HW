package lesson6.srp2;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class SaveToXml {
    private Order order;

    public SaveToXml(Order order) {
        this.order = order;
    }

    public void saveToXml() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element newOrder = document.createElement("Order");

        Element clientName = document.createElement("clientName");
        clientName.appendChild(document.createTextNode(order.getClientName()));
        newOrder.appendChild(clientName);

        Element product = document.createElement("product");
        product.appendChild(document.createTextNode(order.getProduct()));
        newOrder.appendChild(product);

        Element qnt = document.createElement("qnt");
        qnt.appendChild(document.createTextNode("" + order.getQnt()));
        newOrder.appendChild(qnt);

        Element price = document.createElement("price");
        price.appendChild(document.createTextNode("" + order.getPrice()));
        newOrder.appendChild(price);

        document.appendChild(newOrder);

        DOMSource source = new DOMSource(document);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult("order.xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);

        System.out.println("XML-файл успешно создан");
    }
}
