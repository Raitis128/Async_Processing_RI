package com.example.asyncprocessing_ri;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XmlParser {
    public static ArrayList<Currency> getRateFromECB(InputStream stream) throws IOException {

        ArrayList<Currency> currenciesList = new ArrayList<>();

        try {
            DocumentBuilderFactory xmlDocFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder xmlDocBuilder = xmlDocFactory.newDocumentBuilder();
            Document doc = xmlDocBuilder.parse(stream);

            NodeList rateNodes = doc.getElementsByTagName(com.example.asyncprocessing_ri.Constants.CUBE_NODE);

            for (int i = 0; i < rateNodes.getLength(); ++i) {
                Element cube = (Element) rateNodes.item(i);
                if(cube.hasAttribute("currency")){

                    String currencyName = cube.getAttribute("currency");
                    String currencyRate = cube.getAttribute("rate");

                    Currency listElement = new Currency();
                    listElement.currency = currencyName;
                    listElement.rate = currencyRate;

                    currenciesList.add(listElement);
                }
            }
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        return currenciesList;
    }
}
