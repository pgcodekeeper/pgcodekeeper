package ru.taximaxim.codekeeper.ui;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * @author botov_av
 * Get List<String> from XML string and get XML string from List<String>
 */
public class XMLStringBuild {
    private static final String TAG_NAME = "ignored_objects"; //$NON-NLS-1$
    private static final String ELEMENT_NAME = "obj"; //$NON-NLS-1$

    private static Document createNewXml() {
        try {
            Document xml = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().newDocument();
            Element root = xml.createElement(TAG_NAME);
            xml.appendChild(root);
            return xml;
        } catch (ParserConfigurationException ex) {
            throw new IllegalStateException(ex);
        }
    }

    public static String getXMLStringFromList(List<String> listToConvert) {

        Document xml = createNewXml();
        Element element = xml.getDocumentElement();

        for (String listElement : listToConvert) {
            Element newElement = xml.createElement(ELEMENT_NAME);
            newElement.setTextContent(listElement);
            element.insertBefore(newElement, element.getFirstChild());
        }
        return getStringFromXML(xml);
    }

    public static List<String> getListFromXMLString(String xmlString) {
        Document xml = readFromString(xmlString);

        List<String> elements = new ArrayList<>();
        NodeList nlElement = ((Element) xml.getElementsByTagName(TAG_NAME).item(0))
                .getElementsByTagName(ELEMENT_NAME);
        for (int i = 0; i < nlElement.getLength(); ++i) {
            Node element = nlElement.item(i);
            if (element.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            elements.add(i, element.getTextContent());
        }

        return elements;
    }

    private static Document readFromString(String xmlString) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();            
            Document xml = builder.parse(new InputSource(
                    new StringReader(xmlString)));
            xml.getDocumentElement().normalize();

            if (!xml.getDocumentElement().getNodeName().equals(TAG_NAME)) {
                throw new IOException();
            }
            return xml;
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            throw new IllegalStateException(
                    Messages.xMLStringBuild_Exception_thrown_during_parse_ignore_objects_preferences,
                    ex);
        }
    }

    private static String getStringFromXML(Document doc) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer
                    .setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no"); //$NON-NLS-1$
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            return writer.getBuffer().toString().replaceAll("\n|\r", ""); //$NON-NLS-1$ //$NON-NLS-2$
        } catch (TransformerException e) {
            throw new IllegalStateException(
                    Messages.xMLStringBuild_Can_not_transform_xml_to_string, e);
        }
    }
    
    private XMLStringBuild() {}
}