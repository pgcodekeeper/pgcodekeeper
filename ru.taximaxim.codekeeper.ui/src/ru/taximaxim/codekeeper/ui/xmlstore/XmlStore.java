package ru.taximaxim.codekeeper.ui.xmlstore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.URIUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public abstract class XmlStore<T> {

    protected final String fileName;
    protected final String rootTag;

    protected XmlStore(String fileName, String rootTag) {
        this.fileName = fileName;
        this.rootTag = rootTag;
    }

    protected Element createSubElement(Document xml, Element parent, String name, String value) {
        Element newElement = xml.createElement(name);
        newElement.setTextContent(value);
        parent.appendChild(newElement);
        return newElement;
    }

    protected File getXmlFile() throws IOException {
        File fileHistory;
        try {
            fileHistory = new File(URIUtil.toURI(Platform.getInstanceLocation().getURL()));
        } catch (URISyntaxException ex) {
            throw new IOException(ex.getLocalizedMessage(), ex);
        }
        fileHistory = new File(fileHistory, ".metadata"); //$NON-NLS-1$
        fileHistory = new File(fileHistory, ".plugins"); //$NON-NLS-1$
        fileHistory = new File(fileHistory, PLUGIN_ID.THIS);
        fileHistory = new File(fileHistory, fileName);
        return fileHistory;
    }

    public List<T> readObjects() throws IOException {
        try (Reader xmlReader = new InputStreamReader(new FileInputStream(
                getXmlFile()), StandardCharsets.UTF_8)) {
            return getObjects(readXml(xmlReader));
        } catch (FileNotFoundException ex) {
            return new ArrayList<>();
        } catch (IOException | SAXException ex) {
            throw new IOException(MessageFormat.format(
                    Messages.XmlHistory_read_error, ex.getLocalizedMessage()), ex);
        }
    }

    protected List<T> getObjects(Document xml) {
        List<T> objects = new ArrayList<>();
        Element root = (Element) xml.getElementsByTagName(rootTag).item(0);
        NodeList nList = root.getChildNodes();
        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                objects.add(parseElement(node));
            }
        }
        return objects;
    }

    protected abstract T parseElement(Node node);

    public void writeObjects(List<T> list) throws IOException {
        try {
            File file = getXmlFile();
            file.getParentFile().mkdirs();
            file.createNewFile();
            try (Writer xmlWriter = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
                Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
                Element root = xml.createElement(rootTag);
                xml.appendChild(root);
                appendChildren(xml, root, list);
                serializeXml(xml, true, xmlWriter);
            }


        } catch (IOException | ParserConfigurationException | TransformerException ex) {
            throw new IOException(MessageFormat.format(
                    Messages.XmlHistory_write_error, ex.getLocalizedMessage()), ex);
        }
    }

    protected abstract void appendChildren(Document xml, Element root, List<T> list);

    /**
     * Reads (well-formed) list XML and checks it for basic validity:
     * root node must be <code>&lt;rootTagName&gt;</code>
     */
    protected Document readXml(Reader reader) throws IOException, SAXException {
        try {
            Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse(new InputSource(reader));
            xml.normalize();

            if (!xml.getDocumentElement().getNodeName().equals(rootTag)) {
                throw new IOException(Messages.XmlStringList_root_name_invalid);
            }

            return xml;
        } catch (ParserConfigurationException ex) {
            throw new IOException(ex);
        }
    }

    private void serializeXml(Document xml, boolean formatting,
            Writer writer) throws TransformerException {
        Transformer tf =  TransformerFactory.newInstance().newTransformer();
        if (formatting) {
            tf.setOutputProperty(OutputKeys.INDENT, "yes"); //$NON-NLS-1$
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        tf.transform(new DOMSource(xml), new StreamResult(writer));
    }
}
