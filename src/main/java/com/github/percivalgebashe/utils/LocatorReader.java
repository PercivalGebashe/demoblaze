package com.github.percivalgebashe.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class LocatorReader {

    private static DocumentBuilderFactory factory;
    private static DocumentBuilder builder;
    private static Document document;

    static {
        try{
            factory = DocumentBuilderFactory.newInstance();
        }catch (FactoryConfigurationError e){
            System.out.println("FCE: " + e.getMessage());
        }
        try{
            builder = factory.newDocumentBuilder();
        }catch (ParserConfigurationException e){
            System.out.println("PCE: " + e.getMessage());
        }

        try{
            document = builder.parse(".\\src\\main\\resources\\locators.xml");
        }catch (IllegalArgumentException e){
            System.out.println("IAE: " + e.getMessage());
        }catch (IOException e){
            System.out.println("IOE: " + e.getMessage());
        }catch (SAXException e){
            System.out.println("SAXE: " + e.getMessage());
        }
        Element root = document.getDocumentElement();

        root.normalize();


    }


    public static String getLocator(String pageName, String locatorName){

        NodeList pageList = document.getElementsByTagName("page");

        for (int i = 0; i < pageList.getLength(); i++) {
            Element page = (Element) pageList.item(i);
            if (page.getAttribute("name").equalsIgnoreCase(pageName)) {
                NodeList locatorList = page.getElementsByTagName("locator");

                for (int j = 0; j < locatorList.getLength(); j++) {
                    Element locator = (Element) locatorList.item(j);
                    if (locator.getAttribute("name").equalsIgnoreCase(locatorName)) {
                        return locator.getTextContent();
                    }
                }
            }
        }
        throw new IllegalArgumentException("Page: " + pageName + " or " + "Locator Name: " + locatorName + " Not found");
    }
}
