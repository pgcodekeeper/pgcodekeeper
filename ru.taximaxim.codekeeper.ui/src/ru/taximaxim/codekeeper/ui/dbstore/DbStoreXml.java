package ru.taximaxim.codekeeper.ui.dbstore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jface.util.IPropertyChangeListener;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.XmlHistory;

public class DbStoreXml {

    private static final XmlHistory XML_STORE = new XmlHistory
            .Builder(0, "dbstore.xml", "dbstore", "").elementSetTag("dbinfo").build();

    public static final DbStoreXml INSTANCE = new DbStoreXml();

    private final List<IPropertyChangeListener> listeners = new ArrayList<>();

    public void writeStoreToXml(List<DbInfo> list) {
        try {
            XML_STORE.writeDbStoreList(list);
            notifyListeners();
        } catch (IOException e) {
            Log.log(Log.LOG_ERROR, "Error writing db store to xml " + e);
        }
    }


    public List<DbInfo> readStoreFromXml() {
        try {
            return XML_STORE.readDbStoreList();
        } catch (IOException ex) {
            Log.log(Log.LOG_ERROR, "Error reading store from xml " + ex);
        }

        return Collections.emptyList();
    }

    public void addListener(IPropertyChangeListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public void deleteListener(IPropertyChangeListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        listeners.forEach(e -> e.propertyChange(null));
    }


    private DbStoreXml() {

    }
}
