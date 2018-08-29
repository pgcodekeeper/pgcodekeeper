package cz.startnet.utils.pgdiff.loader.jdbc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlReader {

    private static final String ROOT = "root";

    private final Map <String, String> result;

    private XmlReader(Map<String, String> result) {
        this.result = result;
    }

    public double getDouble(String columnName) throws XmlReaderException {
        String val = result.get(columnName);
        return val == null ? 0 : Double.parseDouble(val);
    }

    public long getLong(String columnName) throws XmlReaderException {
        String val = result.get(columnName);
        return val == null ? 0 : Long.parseLong(val);
    }

    public boolean getBoolean(String columnName) throws XmlReaderException {
        String o = result.get(columnName);
        return "1".equals(o) ? true : false;
    }

    public String getString(String columnName) throws XmlReaderException {
        return result.get(columnName);
    }

    public float getFloat(String columnName) throws XmlReaderException {
        String val = result.get(columnName);
        return val == null ? 0 : Float.parseFloat(val);
    }

    public int getInt(String columnName) throws XmlReaderException {
        String val = result.get(columnName);
        return val == null ? 0 : Integer.parseInt(val);
    }

    public short getShort(String columnName) throws XmlReaderException {
        String val = result.get(columnName);
        return val == null ? 0 : Short.parseShort(val);
    }

    public static List<XmlReader> readXML(String xml) throws XmlReaderException {
        if (xml == null) {
            return new ArrayList<>();
        }

        try (Reader reader = new InputStreamReader(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)))) {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse(new InputSource(reader));
            doc.normalize();

            if (!doc.getDocumentElement().getNodeName().equals(ROOT)) {
                throw new IOException("XML root element name is not as requested.");
            }

            List<XmlReader> readers = new ArrayList<>();
            Element root = (Element) doc.getElementsByTagName(ROOT).item(0);
            NodeList nList = root.getChildNodes();
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    readers.add(parseElement(node));
                }
            }

            return readers;
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            throw new XmlReaderException(ex.getLocalizedMessage(), ex);
        }
    }

    private static XmlReader parseElement(Node node) {
        NamedNodeMap params = node.getAttributes();
        Map<String, String> attr = new HashMap<>();

        for (int i = 0; i < params.getLength(); i++) {
            Node param = params.item(i);
            if (param.getNodeType() == Node.ATTRIBUTE_NODE) {
                attr.put(param.getNodeName(), param.getTextContent());
            }
        }

        return new XmlReader(attr);
    }
}