package ru.taximaxim.codekeeper.ui.xmlstore;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.URISyntaxException;

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
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public abstract class XmlStore {

    protected final String fileName;
    protected final String rootTag;

    protected XmlStore(String fileName, String rootTag) {
        this.fileName = fileName;
        this.rootTag = rootTag;
    }

    protected void createSubElement(Document xml, Element parent, String name, String value) {
        Element newElement = xml.createElement(name);
        newElement.setTextContent(value);
        parent.appendChild(newElement);
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


    protected void serializeXml(Document xml, boolean formatting,
            Writer writer) throws TransformerException {
        Transformer tf =  TransformerFactory.newInstance().newTransformer();
        if (formatting) {
            tf.setOutputProperty(OutputKeys.INDENT, "yes"); //$NON-NLS-1$
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        tf.transform(new DOMSource(xml), new StreamResult(writer));
    }
}
