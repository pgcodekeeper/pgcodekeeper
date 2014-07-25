package ru.taximaxim.codekeeper.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.URISyntaxException;
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
    
    public XmlHistory(int maxEntries, String fileName, String rootTag, String elementTag) {
        this.maxEntries = maxEntries;
        this.fileName = fileName;
        this.rootTag = rootTag;
        this.elementTag = elementTag;
    }

    public LinkedList<String> getHistory() {
        LinkedList<String> history;
        try (Reader xmlReader = new FileReader(getHistoryXmlFile())) {
            XmlStringList xml = new XmlStringList(rootTag, elementTag);
            history = xml.deserialize(xmlReader);
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
        LinkedList<String> scripts = getHistory();
        if (scripts == null) {
            scripts = new LinkedList<>();
        }
        if (!newEntry.isEmpty()) {

            scripts.remove(newEntry);
            scripts.add(0, newEntry);
            while (scripts.size() > maxEntries) {
                scripts.removeLast();
            }

            File histFile = getHistoryXmlFile();
            try {
                histFile.getParentFile().mkdirs();
                histFile.createNewFile();
                
                try (Writer xmlWriter = new FileWriter(histFile)) {
                    XmlStringList xml = new XmlStringList(rootTag, elementTag);
                    xml.serialize(scripts, false, xmlWriter);
                }
            } catch (IOException | TransformerException ex) {
                throw new IllegalStateException(
                        Messages.XmlHistory_write_error, ex);
            }
        }
    }
}
