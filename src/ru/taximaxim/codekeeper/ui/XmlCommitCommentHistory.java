package ru.taximaxim.codekeeper.ui;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.runtime.Platform;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * Commit history operations.
 * Commit history is stored in an XML in
 * OSGI_INSTANCE_LOCATION/.metadata/.plugins/THIS_PLUGIN_ID/commit_comments.xml
 * 
 * @author Alexander Levsha
 */
public class XmlCommitCommentHistory {
    
    private static final int MAX_STORED_COMMENTS = 40;
    
    private static final String XML_FILENAME = "commit_comments.xml"; //$NON-NLS-1$
    
    private static final String COMMENTS_TAG = "comments"; //$NON-NLS-1$
    private static final String COMMENT_TAG = "c"; //$NON-NLS-1$

    /**
     * @return List of commit comments or null
     */
    public static List<String> read() {
        Document xml = readXml();
        if (xml == null) {
            return null;
        }
        
        List<String> comments = new ArrayList<>();
        NodeList nlComments = xml.getDocumentElement().getElementsByTagName(COMMENT_TAG);
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
     * Adds a comment string to XML comment storage
     * if the comment string doesn't equal the topmost element
     * (in other words prohibits identical consecutive elements).<br>
     * Shrinks storage by removing last elements if it exceeds max size.
     */
    public static void add(String newComment) {
        List<String> previousComments = read();
        if (previousComments != null && newComment.equals(previousComments.get(0))) {
            return;
        }
        
        Document xml = readXml();
        if (xml == null) {
            xml = createNewXml();
        }
        Element eComments = xml.getDocumentElement();
        
        Element eNewComment = xml.createElement(COMMENT_TAG);
        eNewComment.setTextContent(newComment);
        eComments.insertBefore(eNewComment, eComments.getFirstChild());
        
        NodeList nlComments = eComments.getElementsByTagName(COMMENT_TAG);
        for (int i = nlComments.getLength() - 1; i >= 0; --i) {
            if (i < MAX_STORED_COMMENTS) {
                break;
            }
            eComments.removeChild(nlComments.item(i));
        }
        
        writeXml(xml);
    }
    
    /**
     * Reads (well-formed) storage XML and checks it for basic validity:
     * root node must be <code>&lt;comments&gt;</code>
     * 
     * @param createIfNotExists creates the XML storage file is it doesn't exist.
     *                          Use when adding elements.
     * @return XML DOM or null if the file doesn't exist or XML is invalid
     */
    private static Document readXml() {
        File fileComments = getXmlFile();
        if (!fileComments.exists()) {
            return null;
        }
        
        try {
            Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse(fileComments);
            xml.getDocumentElement().normalize();
            if (!xml.getDocumentElement().getNodeName().equals(COMMENTS_TAG)) {
                throw new IOException();
            }
            return xml;
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            throw new IllegalStateException(
                    Messages.xmlCommitCommentHistory_error_reading_comment_history_xml, ex);
        }
    }
    
    /**
     * @return a new DOM with an empty <code>&lt;comments&gt;</code> root node
     */
    private static Document createNewXml() {
        try {
            Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .newDocument();
            Element root = xml.createElement(COMMENTS_TAG);
            xml.appendChild(root);
            return xml;
        } catch (ParserConfigurationException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    private static void writeXml(Document xml) {
        try {
            Transformer transform = TransformerFactory.newInstance().newTransformer();
            DOMSource src = new DOMSource(xml);
            File fileXml = getXmlFile();
            if (!fileXml.exists()) {
                try {
                    fileXml.getParentFile().mkdirs();
                    fileXml.createNewFile();
                } catch (IOException ex) {
                    throw new IllegalStateException(
                            Messages.xmlCommitCommentHistory_error_while_trying_to_write_comment, ex);
                }
            }
            StreamResult stream = new StreamResult(fileXml);
            transform.transform(src, stream);
        } catch (TransformerException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    private static File getXmlFile() {
        File fileComments;
        try {
            fileComments = new File(Platform.getInstanceLocation().getURL().toURI());
        } catch(URISyntaxException ex) {
            throw new IllegalStateException(ex);
        }
        fileComments = new File(fileComments, ".metadata"); //$NON-NLS-1$
        fileComments = new File(fileComments, ".plugins"); //$NON-NLS-1$
        fileComments = new File(fileComments, UIConsts.PLUGIN_ID);
        fileComments = new File(fileComments, XML_FILENAME);
        return fileComments;
    }
    
    private XmlCommitCommentHistory() {
    }
}
