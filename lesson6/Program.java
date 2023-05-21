package lesson6.srp2;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class Program {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        System.out.println("Укажите заказ:");

        Order order = new Order("", "", 0, 0);

        InputFromConsole inputFromConsole = new InputFromConsole(order);
        inputFromConsole.inputFromConsole();

        SaveToJson saveToJson = new SaveToJson(order);
        saveToJson.saveToJson();

        SaveToXml saveToXml = new SaveToXml(order);
        saveToXml.saveToXml();
    }
}
