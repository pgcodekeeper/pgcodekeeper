package ru.taximaxim.codekeeper.ui;

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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.transform.TransformerException;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.URIUtil;
import org.xml.sax.SAXException;

import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public final class XmlHistory {

    private final int maxEntries;
    private final String fileName;
    private final String rootTag;
    private final String elementTag;
    private final String elementSetTag;

    private XmlHistory(Builder builder) {
        this.maxEntries = builder.maxEntries;
        this.fileName = builder.fileName;
        this.rootTag = builder.rootTag;
        this.elementTag = builder.elementTag;
        this.elementSetTag = builder.elementSetTag;
    }

    public static class Builder {
        private final int maxEntries;
        private final String fileName;
        private final String rootTag;
        private final String elementTag;
        private String elementSetTag = "elementSetTag"; //$NON-NLS-1$

        public Builder(int maxEntries, String fileName, String rootTag,
                String elementTag) {
            this.maxEntries = maxEntries;
            this.fileName = fileName;
            this.rootTag = rootTag;
            this.elementTag = elementTag;
        }
        public Builder elementSetTag(String value) {
            elementSetTag = value;
            return this;
        }
        public XmlHistory build() {
            return new XmlHistory(this);
        }
    }

    public Map<String, List<String>> getMapHistory() throws IOException {
        Map<String, List<String>> history;
        try (Reader xmlReader = new InputStreamReader(new FileInputStream(
                getHistoryXmlFile()), StandardCharsets.UTF_8)) {
            XmlStringList xml = new XmlStringList(rootTag, elementTag, elementSetTag);
            history = xml.deserializeMap(xmlReader);
        } catch (FileNotFoundException e) {
            history = new LinkedHashMap<>();
        } catch (IOException | SAXException e) {
            throw new IOException(MessageFormat.format(
                    Messages.XmlHistory_read_error, e.getLocalizedMessage()), e);
        }
        return history;
    }

    public LinkedList<String> getHistory() throws IOException {
        LinkedList<String> history;
        try (Reader xmlReader = new InputStreamReader(new FileInputStream(
                getHistoryXmlFile()), StandardCharsets.UTF_8)) {
            XmlStringList xml = new XmlStringList(rootTag, elementTag);
            history = xml.deserializeList(xmlReader);
        } catch (FileNotFoundException ex) {
            history = null;
        } catch (IOException | SAXException ex) {
            throw new IOException(MessageFormat.format(
                    Messages.XmlHistory_read_error, ex.getLocalizedMessage()), ex);
        }
        return history;
    }

    private File getHistoryXmlFile() throws IOException {
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
     * Adds newEntry to the front of history XML.
     * Removes elements that exceed size limit from the back of the list.
     * @throws IOException
     */
    public void addHistoryEntry(String newEntry) throws IOException {
        LinkedList<String> historyEntries = getHistory();
        if (historyEntries == null) {
            historyEntries = new LinkedList<>();
        }
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
        File histFile = getHistoryXmlFile();
        try {
            histFile.getParentFile().mkdirs();
            histFile.createNewFile();

            try (Writer xmlWriter = new OutputStreamWriter(new FileOutputStream(histFile), StandardCharsets.UTF_8)) {
                XmlStringList xml = new XmlStringList(rootTag, elementTag);
                xml.serializeList(listToDump, false, xmlWriter);
            }
        } catch (IOException | TransformerException ex) {
            throw new IOException(MessageFormat.format(
                    Messages.XmlHistory_write_error, ex.getLocalizedMessage()), ex);
        }
    }

    public void setHistory(List<String> list) throws IOException{
        LinkedList<String> linkedList = new LinkedList<>(list);
        while (linkedList.size() > maxEntries) {
            linkedList.removeLast();
        }

        dumpListToFile(linkedList);
    }

    /**
     * @param addEntry adds entry if true, removes if false
     * @throws IOException
     */
    public void updateCheckedSetHistoryEntries(String checkSetName,
            List<String> values, boolean addEntry) throws IOException {
        if (values.isEmpty() && addEntry) {
            // do not add entries with no elements
            return;
        }
        Map<String, List<String>> checkedSets = new LinkedHashMap<>();
        if (addEntry) {
            checkedSets.put(checkSetName, values);
        }

        Map<String, List<String>> oldCheckedSets = getMapHistory();
        oldCheckedSets.remove(checkSetName);

        Iterator<String> it = oldCheckedSets.keySet().iterator();
        for (int count = 1; count < maxEntries && it.hasNext(); count++) {
            String key = it.next();
            checkedSets.put(key, oldCheckedSets.get(key));
        }

        File historyFile = getHistoryXmlFile();
        try {
            historyFile.getParentFile().mkdirs();
            historyFile.createNewFile();
            try (Writer xmlWriter = new OutputStreamWriter(new FileOutputStream(historyFile), StandardCharsets.UTF_8)) {
                XmlStringList xml = new XmlStringList(rootTag, elementTag, elementSetTag);
                xml.serializeMap(checkedSets, false, xmlWriter);
            }
        } catch (IOException | TransformerException e) {
            throw new IOException(MessageFormat.format(
                    Messages.XmlHistory_write_error, e.getLocalizedMessage()), e);
        }

    }
}
