package ru.taximaxim.codekeeper.ui.xmlstore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.eclipse.jface.util.IPropertyChangeListener;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DbXmlStore extends XmlStore {

    public static final DbXmlStore INSTANCE = new DbXmlStore();

    private static final String FILE_NAME = "dbstore.xml"; //$NON-NLS-1$

    private final List<IPropertyChangeListener> listeners = new ArrayList<>();

    private enum Tags {
        DB_STORE("db_store"), //$NON-NLS-1$
        DB_INFO("db_info"), //$NON-NLS-1$
        NAME("name"), //$NON-NLS-1$
        DBNAME("dbname"), //$NON-NLS-1$
        DBUSER("dbuser"), //$NON-NLS-1$
        DBPASS("dbpass"), //$NON-NLS-1$
        DBHOST("dbhost"), //$NON-NLS-1$
        DBPORT("dbport"), //$NON-NLS-1$
        READ_ONLY("read_only"), //$NON-NLS-1$
        IGNORE_LIST("ignore_list"), //$NON-NLS-1$
        IGNORE_FILE("ignore_file"); //$NON-NLS-1$

        String name;

        private Tags(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private DbXmlStore() {
        super(FILE_NAME, Tags.DB_STORE.toString());
    }


    public List<DbInfo> readDbStoreList() throws IOException {
        try (Reader xmlReader = new InputStreamReader(new FileInputStream(
                getXmlFile()), StandardCharsets.UTF_8)) {
            return readObjects(readXml(xmlReader));
        } catch (IOException | SAXException ex) {
            throw new IOException(MessageFormat.format(
                    Messages.XmlHistory_read_error, ex.getLocalizedMessage()), ex);
        }
    }

    public void writeDbStoreList(List<DbInfo> dbStoreList) {
        try {
            File storeFile = getXmlFile();
            storeFile.getParentFile().mkdirs();
            storeFile.createNewFile();
            try (Writer xmlWriter = new OutputStreamWriter(new FileOutputStream(storeFile), StandardCharsets.UTF_8)) {
                Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
                Element root = xml.createElement(Tags.DB_STORE.toString());
                xml.appendChild(root);

                for (DbInfo dbInfo : dbStoreList) {
                    Element keyElement = xml.createElement(Tags.DB_INFO.toString());
                    root.appendChild(keyElement);

                    createSubElement(xml, keyElement, Tags.NAME.toString(), dbInfo.getName());
                    createSubElement(xml, keyElement, Tags.DBNAME.toString(), dbInfo.getDbName());
                    createSubElement(xml, keyElement, Tags.DBUSER.toString(), dbInfo.getDbUser());
                    createSubElement(xml, keyElement, Tags.DBPASS.toString(), dbInfo.getDbPass());
                    createSubElement(xml, keyElement, Tags.DBHOST.toString(), dbInfo.getDbHost());
                    createSubElement(xml, keyElement, Tags.DBPORT.toString(), String.valueOf(dbInfo.getDbPort()));
                    createSubElement(xml, keyElement, Tags.READ_ONLY.toString(), String.valueOf(dbInfo.isReadOnly()));

                    Element ignoreList = xml.createElement(Tags.IGNORE_LIST.toString());
                    keyElement.appendChild(ignoreList);
                    for (String file : dbInfo.getIgnoreFiles()) {
                        createSubElement(xml, ignoreList, Tags.IGNORE_FILE.toString(), file);
                    }
                }

                serializeXml(xml, true, xmlWriter);
                notifyListeners();
            }
        } catch (IOException | TransformerException | ParserConfigurationException e) {
            Log.log(Log.LOG_ERROR, "Error writing db store to xml " + e); //$NON-NLS-1$
        }
    }

    private List<DbInfo> readObjects(Document xml) {
        List<DbInfo> objects = new ArrayList<>();

        Element root = (Element) xml.getElementsByTagName(rootTag).item(0);
        NodeList nList = root.getChildNodes();
        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                objects.add(parseElement(node.getChildNodes()));
            }
        }

        return objects;
    }

    private DbInfo parseElement(NodeList params) {
        List<String> ignoreFiles = new ArrayList<>();
        Map<Tags, String> object = new EnumMap<>(Tags.class);

        for (int i = 0; i < params.getLength(); i++) {
            Node param = params.item(i);
            if (param.getNodeType() == Node.ELEMENT_NODE) {
                Tags tag = Tags.valueOf(param.getNodeName().toUpperCase());
                switch (tag) {
                case NAME:
                case DBNAME:
                case DBUSER:
                case DBPASS:
                case DBHOST:
                case DBPORT:
                case READ_ONLY:
                    object.put(tag, param.getTextContent());
                    break;
                case IGNORE_LIST:
                    fillIgnoreFileList(param.getChildNodes(), ignoreFiles);
                    break;
                default:
                    break;
                }
            }
        }

        return new DbInfo(object.get(Tags.NAME), object.get(Tags.DBNAME),
                object.get(Tags.DBUSER), object.get(Tags.DBPASS), object.get(Tags.DBHOST),
                Integer.parseInt(object.get(Tags.DBPORT)),
                Boolean.parseBoolean(object.get(Tags.READ_ONLY)), ignoreFiles);
    }

    private void fillIgnoreFileList(NodeList xml, List<String> list) {
        for (int i = 0; i < xml.getLength(); i++) {
            Node file = xml.item(i);
            if (Tags.IGNORE_FILE.toString().equals(file.getNodeName())) {
                list.add(file.getTextContent());
            }
        }
    }

    public void addListener(IPropertyChangeListener listener) {
        listeners.add(listener);
    }

    public void deleteListener(IPropertyChangeListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        listeners.forEach(e -> e.propertyChange(null));
    }
}