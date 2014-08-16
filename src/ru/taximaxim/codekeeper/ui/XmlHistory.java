package ru.taximaxim.codekeeper.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import javax.xml.transform.TransformerException;

import org.eclipse.core.runtime.Platform;
import org.xml.sax.SAXException;

import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class XmlHistory {
    
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

    public LinkedHashMap<String, LinkedList<String>> getMapHistory() {
        LinkedHashMap<String, LinkedList<String>> history;
        try (Reader xmlReader = new FileReader(getHistoryXmlFile())) {
            XmlStringList xml = new XmlStringList(rootTag, elementTag, elementSetTag);
            history = xml.deserializeMap(xmlReader);
        } catch (FileNotFoundException e) {
            history = new LinkedHashMap<String, LinkedList<String>>();
        } catch (IOException | SAXException e) {
            throw new IllegalStateException(Messages.XmlHistory_read_error, e);
        }
        return history;
    }
    
    public LinkedList<String> getHistory() {
        LinkedList<String> history;
        try (Reader xmlReader = new FileReader(getHistoryXmlFile())) {
            XmlStringList xml = new XmlStringList(rootTag, elementTag);
            history = xml.deserializeList(xmlReader);
        } catch (FileNotFoundException ex) {
            history = null;
        } catch (IOException | SAXException ex) {
            throw new IllegalStateException(Messages.XmlHistory_read_error, ex);
        }
        return history;
    }

    private File getHistoryXmlFile() {
        File fileHistory;
        try {
            fileHistory = new File(Platform.getInstanceLocation().getURL().toURI());
        } catch(URISyntaxException ex) {
            throw new IllegalStateException(ex);
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
     */
    public void addHistoryEntry(String newEntry) {
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

            File histFile = getHistoryXmlFile();
            try {
                histFile.getParentFile().mkdirs();
                histFile.createNewFile();
                
                try (Writer xmlWriter = new OutputStreamWriter(new FileOutputStream(histFile), "UTF-8")) { //$NON-NLS-1$
                    XmlStringList xml = new XmlStringList(rootTag, elementTag);
                    xml.serializeList(historyEntries, false, xmlWriter);
                }
            } catch (IOException | TransformerException ex) {
                throw new IllegalStateException(
                        Messages.XmlHistory_write_error, ex);
            }
        }
    }
    
    /**
     * @param addEntry adds entry if true, removes if false
     */
    public void updateCheckedSetHistoryEntries(String checkSetName, 
            LinkedList<String> values, boolean addEntry) {
        if (values.isEmpty()) {
            return;
        }
        LinkedHashMap<String, LinkedList<String>> checkedSets = 
                new LinkedHashMap<String, LinkedList<String>>();
        if (addEntry) {
            checkedSets.put(checkSetName, values);
        }
        
        LinkedHashMap<String, LinkedList<String>> oldCheckedSets = getMapHistory();
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
            try (Writer xmlWriter = new OutputStreamWriter(new FileOutputStream(historyFile), "UTF-8")) { //$NON-NLS-1$
                XmlStringList xml = new XmlStringList(rootTag, elementTag, elementSetTag);
                xml.serializeMap(checkedSets, false, xmlWriter);
            }
        } catch (IOException | TransformerException e) {
            throw new IllegalStateException(
                    Messages.XmlHistory_write_error, e);
        }
        
    }
}
