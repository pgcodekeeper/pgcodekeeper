/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.xmlstore;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
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
import org.xml.sax.SAXException;

import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.localizations.Messages;

public abstract class XmlStore<T> {

    protected final String fileName;
    private final String rootTag;

    private volatile Document cachedDocument;

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

    protected abstract Path getXmlFile();

    public List<T> readObjects() throws IOException {
        try {
            return getObjects(readXml(false));
        } catch(NoSuchFileException ex) {
            return new ArrayList<>();
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
        writeDocument(createDocument(list));
    }

    protected Document createDocument(List<T> list) throws IOException {
        try {
            Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element root = xml.createElement(rootTag);
            xml.appendChild(root);
            appendChildren(xml, root, list);
            return xml;
        } catch (ParserConfigurationException ex) {
            throw new IOException(MessageFormat.format(
                    Messages.XmlStore_write_error, ex.getLocalizedMessage()), ex);
        }
    }

    protected void writeDocument(Document xml) throws IOException {
        try {
            Path path = getXmlFile();
            Files.createDirectories(path.getParent());
            try (Writer xmlWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
                serializeXml(xml, true, xmlWriter);
            }
        } catch (IOException | TransformerException ex) {
            throw new IOException(MessageFormat.format(
                    Messages.XmlStore_write_error, ex.getLocalizedMessage()), ex);
        }
    }

    protected abstract void appendChildren(Document xml, Element root, List<T> list);

    /**
     * Reads (well-formed) list XML and checks it for basic validity:
     * root node must be <code>&lt;rootTagName&gt;</code>
     *
     * @param useCached immediately return the Document read in the previous call to this method
     */
    protected Document readXml(boolean useCached) throws IOException {
        Document xml = cachedDocument;
        if (useCached && xml != null) {
            return xml;
        }
        try (Reader reader = Files.newBufferedReader(getXmlFile(), StandardCharsets.UTF_8)) {
            xml = Utils.readXml(reader);

            if (!xml.getDocumentElement().getNodeName().equals(rootTag)) {
                throw new IOException(Messages.XmlStore_root_error);
            }

            cachedDocument = xml;
            return xml;
        } catch (NoSuchFileException ex) {
            throw ex;
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            throw new IOException(MessageFormat.format(
                    Messages.XmlStore_read_error, ex.getLocalizedMessage()), ex);
        }
    }

    private void serializeXml(Document xml, boolean formatting,
            Writer writer) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");

        Transformer tf = factory.newTransformer();
        if (formatting) {
            tf.setOutputProperty(OutputKeys.INDENT, "yes"); //$NON-NLS-1$
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        tf.transform(new DOMSource(xml), new StreamResult(writer));
    }
}
