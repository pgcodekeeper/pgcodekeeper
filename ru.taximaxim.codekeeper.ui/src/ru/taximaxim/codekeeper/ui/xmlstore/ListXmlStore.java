package ru.taximaxim.codekeeper.ui.xmlstore;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import cz.startnet.utils.pgdiff.xmlstore.XmlStore;
import ru.taximaxim.codekeeper.ui.Activator;

public class ListXmlStore extends XmlStore<String> {

    private final int maxEntries;
    private final String elementTag;

    public ListXmlStore(int maxEntries, String fileName, String rootTag, String elementTag) {
        super(fileName, rootTag);
        this.maxEntries = maxEntries;
        this.elementTag = elementTag;
    }

    /**
     * Adds newEntry to the front of history XML.
     * Removes elements that exceed size limit from the back of the list.
     * @throws IOException
     */
    public void addHistoryEntry(String newEntry) throws IOException {
        if (!newEntry.isEmpty()) {
            List<String> historyEntries = readObjects();
            historyEntries.remove(newEntry);
            historyEntries.add(0, newEntry);
            if (historyEntries.size() > maxEntries) {
                historyEntries = historyEntries.subList(0, maxEntries);
            }

            writeObjects(historyEntries);
        }
    }

    @Override
    protected File getXmlFile() throws IOException {
        File fileHistory = Platform.getStateLocation(Activator.getContext().getBundle()).toFile();
        fileHistory = new File(fileHistory, fileName);
        return fileHistory;
    }

    @Override
    public void writeObjects(List<String> list) throws IOException {
        super.writeObjects(list.size() > maxEntries ? list.subList(0, maxEntries) : list);
    }

    @Override
    protected void appendChildren(Document xml, Element root, List<String> list) {
        for (Object listElement : list) {
            createSubElement(xml, root, elementTag, listElement.toString());
        }
    }

    @Override
    protected String parseElement(Node node) {
        return node.getTextContent();
    }
}
