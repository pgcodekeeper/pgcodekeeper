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
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ListXmlStore extends XmlStore {

    private final int maxEntries;
    private final String elementTag;

    public ListXmlStore(int maxEntries, String fileName, String rootTag, String elementTag) {
        super(fileName, rootTag);
        this.maxEntries = maxEntries;
        this.elementTag = elementTag;
    }

    public LinkedList<String> getHistory() throws IOException {
        LinkedList<String> history;
        try (Reader xmlReader = new InputStreamReader(new FileInputStream(
                getXmlFile()), StandardCharsets.UTF_8)) {
            history = readList(readXml(xmlReader));
        } catch (FileNotFoundException ex) {
            history = new LinkedList<>();
        } catch (IOException | SAXException ex) {
            throw new IOException(MessageFormat.format(
                    Messages.XmlHistory_read_error, ex.getLocalizedMessage()), ex);
        }
        return history;
    }

    /**
     * Adds newEntry to the front of history XML.
     * Removes elements that exceed size limit from the back of the list.
     * @throws IOException
     */
    public void addHistoryEntry(String newEntry) throws IOException {
        LinkedList<String> historyEntries = getHistory();
        if (!newEntry.isEmpty()) {
            historyEntries.remove(newEntry);
            historyEntries.add(0, newEntry);
            while (historyEntries.size() > maxEntries) {
                historyEntries.removeLast();
            }

            dumpListToFile(historyEntries);
        }
    }

    private void dumpListToFile(List<String> listToDump) throws IOException{
        File histFile = getXmlFile();
        try {
            histFile.getParentFile().mkdirs();
            histFile.createNewFile();

            try (Writer xmlWriter = new OutputStreamWriter(new FileOutputStream(histFile), StandardCharsets.UTF_8)) {
                serializeList(listToDump, false, xmlWriter);
            }
        } catch (IOException | TransformerException ex) {
            throw new IOException(MessageFormat.format(
                    Messages.XmlHistory_write_error, ex.getLocalizedMessage()), ex);
        }
    }

    private LinkedList<String> readList(Document xml) {
        LinkedList<String> list = new LinkedList<>();

        Element root = (Element) xml.getElementsByTagName(rootTag).item(0);

        NodeList nlItems = root.getElementsByTagName(elementTag);
        for (int i = 0; i < nlItems.getLength(); ++i) {
            Node nListItem = nlItems.item(i);
            if (nListItem.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            list.add(nListItem.getTextContent());
        }

        return list;
    }

    public void setHistory(List<String> list) throws IOException{
        LinkedList<String> linkedList = new LinkedList<>(list);
        while (linkedList.size() > maxEntries) {
            linkedList.removeLast();
        }

        dumpListToFile(linkedList);
    }

    public <T> void serializeList(List<T> listToConvert, boolean noFormatting,
            Writer writer) throws TransformerException, IOException {
        Document xml;
        try {
            xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException ex) {
            throw new IOException(ex);
        }

        Element root = xml.createElement(rootTag);
        xml.appendChild(root);

        for (T listElement : listToConvert) {
            createSubElement(xml, root, elementTag, listElement.toString());
        }

        serializeXml(xml, noFormatting, writer);
    }
}
