package ru.taximaxim.codekeeper.ui;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.runtime.Platform;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class XMLListBuilder {
    
    private String tagName;
    private String elementName;
    
    public XMLListBuilder(String tagName, String elementName) {
        this.tagName = tagName;
        this.elementName = elementName;
    }
        
    /**
     * @return a new DOM with an empty <code>&lt;tagName&gt;</code> root node
     */
    private Document createNewXml() {
        try {
            Document xml = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().newDocument();
            Element root = xml.createElement(tagName);
            xml.appendChild(root);
            return xml;
        } catch (ParserConfigurationException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    /**
     * Creates List<String> from XML string
     * @param xmlString
     * @return
     */
    public List<String> getListFromXMLString(String xmlString) {
        return readList(readXml(xmlString));
    }
    
    public List<String> read() {
        return readList(readXml(getXmlFile()));
    }
    
    /**
     * Reads (well-formed) storage XML and checks it for basic validity:
     * root node must be <code>&lt;tagName&gt;</code>
     * @param file
     * @return XML DOM or null if the file doesn't exist or XML is invalid
     */
    private Document readXml(File file) {
        if (!file.exists()) {
            return null;
        }
        
        try {
            Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse(file);
            return checkNormalize(xml);
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            throw new IllegalStateException(
                    Messages.xmlCommitCommentHistory_error_reading_comment_history_xml, ex);
        }
    }
    
    /**
     * Read document from XML string
     * @param xmlString
     * @return XML document
     */
    private Document readXml(String xmlString) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document xml = builder.parse(new InputSource(
                    new StringReader(xmlString)));
            return checkNormalize(xml);
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            throw new IllegalStateException(
                    Messages.xMLStringBuild_Exception_thrown_during_parse_ignore_objects_preferences,
                    ex);
        }
    }
    
    private Document checkNormalize(Document xml)
            throws IOException {
        xml.getDocumentElement().normalize();
        if (!xml.getDocumentElement().getNodeName().equals(tagName)) {
            throw new IOException();
        }

        return xml;
    }
    
    /**
     * @return List of strings or null
     */
    private List<String> readList(Document xml) {
        if (xml == null) {
            return null;
        }
        
        List<String> comments = new ArrayList<>();
        NodeList nlComments = xml.getDocumentElement().getElementsByTagName(elementName);
        for (int i = 0; i < nlComments.getLength(); ++i) {
            Node nComment = nlComments.item(i);
            if (nComment.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            
            comments.add(nComment.getTextContent());
        }
        
        return comments;
    }

    /**
     * Transform XML document to StreamResult
     * @param xmlDocument XML document
     * @param streamResult StreamResult
     */
    private void transform(Document xmlDocument, StreamResult streamResult) {
        try {
            TransformerFactory.newInstance().newTransformer()
                    .transform(new DOMSource(xmlDocument), streamResult);
        } catch (TransformerException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    public String getXMLStringFromList(List<String> listToConvert) {
    
        Document xml = createNewXml();
        Element element = xml.getDocumentElement();
    
        for (String listElement : listToConvert) {
            element.insertBefore(
                    createNewElement(xml, listElement), element.getFirstChild());
        }
        
        StringWriter writer = new StringWriter();
        transform(xml, new StreamResult(writer));
        return writer.getBuffer().toString().replaceAll("\n|\r", ""); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private Element createNewElement(Document xml, String content) {
        Element newElement = xml.createElement(elementName);
        newElement.setTextContent(content);
        return newElement; 
    }    

    private File getXmlFile() {
        File fileComments;
        try {
            fileComments = new File(Platform.getInstanceLocation().getURL().toURI());
        } catch(URISyntaxException ex) {
            throw new IllegalStateException(ex);
        }
        fileComments = new File(fileComments, ".metadata"); //$NON-NLS-1$
        fileComments = new File(fileComments, ".plugins"); //$NON-NLS-1$
        fileComments = new File(fileComments, UIConsts.PLUGIN_ID);
        fileComments = new File(fileComments, UIConsts.COMMENTS_XML_FILENAME);
        return fileComments;
    }
    
    /**
     * Adds a comment string to XML comment storage
     * if the comment string doesn't equal the topmost element
     * (in other words prohibits identical consecutive elements).<br>
     * Shrinks storage by removing last elements if it exceeds max size.
     */
    public void add(String newComment) {
        File xmlFile = getXmlFile();
        Document xml = readXml(xmlFile);
        List<String> previousComments = readList(xml);
        
        if (previousComments != null && newComment.equals(previousComments.get(0))) {
            return;
        }
        
        if (xml == null) {
            xml = createNewXml();
        }
        Element eComments = xml.getDocumentElement();
        eComments.insertBefore(createNewElement(xml, newComment), eComments.getFirstChild());
        
        NodeList nlComments = eComments.getElementsByTagName(elementName);
        for (int i = nlComments.getLength() - 1; i >= 0; --i) {
            if (i < UIConsts.MAX_STORED_COMMENTS) {
                break;
            }
            eComments.removeChild(nlComments.item(i));
        }
        
        if (!xmlFile.exists()) {
            try {
                xmlFile.getParentFile().mkdirs();
                xmlFile.createNewFile();
            } catch (IOException ex) {
                throw new IllegalStateException(
                        Messages.xmlCommitCommentHistory_error_while_trying_to_write_comment,
                        ex);
            }
        }
        
        transform(xml, new StreamResult(xmlFile));
    }
}
