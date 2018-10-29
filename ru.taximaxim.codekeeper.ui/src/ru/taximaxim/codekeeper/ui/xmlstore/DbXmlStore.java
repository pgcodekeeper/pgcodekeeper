package ru.taximaxim.codekeeper.ui.xmlstore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import cz.startnet.utils.pgdiff.xmlstore.XmlStore;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DbXmlStore extends XmlStore<DbInfo> {

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
        GENERATE_NAME("generate_name"), //$NON-NLS-1$
        IGNORE_LIST("ignore_list"), //$NON-NLS-1$
        IGNORE_FILE("ignore_file"), //$NON-NLS-1$
        PROPERTY_LIST("property_list"), //$NON-NLS-1$
        PROPERTY("property"), //$NON-NLS-1$
        PROPERTY_NAME("name"), //$NON-NLS-1$
        PROPERTY_VALUE("value"), //$NON-NLS-1$
        MSSQL("mssql"), //$NON-NLS-1$
        WIN_AUTH("win_auth"); //$NON-NLS-1$

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

    @Override
    protected File getXmlFile() throws IOException {
        File fileHistory = Platform.getStateLocation(Activator.getContext().getBundle()).toFile();
        fileHistory = new File(fileHistory, fileName);
        return fileHistory;
    }

    // TODO suppress this override when legacy preference support is removed
    @Override
    public List<DbInfo> readObjects() throws IOException {
        try (Reader xmlReader = new InputStreamReader(new FileInputStream(
                getXmlFile()), StandardCharsets.UTF_8)) {
            return getObjects(readXml(xmlReader));
        } catch (IOException | SAXException ex) {
            throw new IOException(MessageFormat.format(
                    Messages.XmlHistory_read_error, ex.getLocalizedMessage()), ex);
        }
    }

    @Override
    public void writeObjects(List<DbInfo> list) {
        try {
            super.writeObjects(list);
            notifyListeners();
        } catch (IOException e) {
            Log.log(Log.LOG_ERROR, "Error writing db store to xml " + e); //$NON-NLS-1$
        }
    }

    @Override
    protected void appendChildren(Document xml, Element root, List<DbInfo> list) {
        for (DbInfo dbInfo : list) {
            Element keyElement = xml.createElement(Tags.DB_INFO.toString());
            root.appendChild(keyElement);

            createSubElement(xml, keyElement, Tags.NAME.toString(), dbInfo.getName());
            createSubElement(xml, keyElement, Tags.DBNAME.toString(), dbInfo.getDbName());
            createSubElement(xml, keyElement, Tags.DBUSER.toString(), dbInfo.getDbUser());
            createSubElement(xml, keyElement, Tags.DBPASS.toString(), dbInfo.getDbPass());
            createSubElement(xml, keyElement, Tags.DBHOST.toString(), dbInfo.getDbHost());
            createSubElement(xml, keyElement, Tags.DBPORT.toString(), String.valueOf(dbInfo.getDbPort()));
            createSubElement(xml, keyElement, Tags.READ_ONLY.toString(), String.valueOf(dbInfo.isReadOnly()));
            createSubElement(xml, keyElement, Tags.GENERATE_NAME.toString(), String.valueOf(dbInfo.isGeneratedName()));
            createSubElement(xml, keyElement, Tags.MSSQL.toString(), String.valueOf(dbInfo.isMsSql()));
            createSubElement(xml, keyElement, Tags.WIN_AUTH.toString(), String.valueOf(dbInfo.isWinAuth()));

            Element ignoreList = xml.createElement(Tags.IGNORE_LIST.toString());
            keyElement.appendChild(ignoreList);
            for (String file : dbInfo.getIgnoreFiles()) {
                createSubElement(xml, ignoreList, Tags.IGNORE_FILE.toString(), file);
            }

            Element propertyList = xml.createElement(Tags.PROPERTY_LIST.toString());
            keyElement.appendChild(propertyList);
            for (Entry<String, String> property : dbInfo.getProperties().entrySet()) {
                Element propertyTag = createSubElement(xml, propertyList, Tags.PROPERTY.toString(), null);
                createSubElement(xml, propertyTag, Tags.PROPERTY_NAME.toString(), property.getKey());
                createSubElement(xml, propertyTag, Tags.PROPERTY_VALUE.toString(), property.getValue());
            }
        }
    }

    @Override
    protected DbInfo parseElement(Node node) {
        NodeList params = node.getChildNodes();
        List<String> ignoreFiles = new ArrayList<>();
        Map<String, String> properties = new HashMap<>();
        Map<Tags, String> object = new EnumMap<>(Tags.class);

        for (int i = 0; i < params.getLength(); i++) {
            Node param = params.item(i);
            if (param.getNodeType() == Node.ELEMENT_NODE) {
                Tags tag;
                try {
                    tag = Tags.valueOf(param.getNodeName().toUpperCase());
                } catch (IllegalArgumentException ex) {
                    Log.log(ex);
                    continue;
                }
                switch (tag) {
                case NAME:
                case DBNAME:
                case DBUSER:
                case DBPASS:
                case DBHOST:
                case DBPORT:
                case READ_ONLY:
                case GENERATE_NAME:
                case MSSQL:
                case WIN_AUTH:
                    object.put(tag, param.getTextContent());
                    break;
                case IGNORE_LIST:
                    fillIgnoreFileList(param.getChildNodes(), ignoreFiles);
                    break;
                case PROPERTY_LIST:
                    fillPropertyList(param.getChildNodes(), properties);
                    break;
                default:
                    break;
                }
            }
        }

        return new DbInfo(object.get(Tags.NAME), object.get(Tags.DBNAME),
                object.get(Tags.DBUSER), object.get(Tags.DBPASS), object.get(Tags.DBHOST),
                Integer.parseInt(object.get(Tags.DBPORT)),
                Boolean.parseBoolean(object.get(Tags.READ_ONLY)),
                Boolean.parseBoolean(object.get(Tags.GENERATE_NAME)),
                ignoreFiles, properties,
                Boolean.parseBoolean(object.get(Tags.MSSQL)),
                Boolean.parseBoolean(object.get(Tags.WIN_AUTH)));
    }

    private void fillIgnoreFileList(NodeList xml, List<String> list) {
        for (int i = 0; i < xml.getLength(); i++) {
            Node file = xml.item(i);
            if (Tags.IGNORE_FILE.toString().equals(file.getNodeName())) {
                list.add(file.getTextContent());
            }
        }
    }

    private void fillPropertyList(NodeList xml, Map<String, String> map) {
        for (int i = 0; i < xml.getLength(); i++) {
            Node property = xml.item(i);
            if (Tags.PROPERTY.toString().equals(property.getNodeName())) {
                NodeList propertyChilds = property.getChildNodes();

                String propertyName = null;
                String propertyValue = null;
                for (int k = 0; k < propertyChilds.getLength(); k++) {
                    Node child = propertyChilds.item(k);
                    if (Tags.PROPERTY_NAME.toString().equals(child.getNodeName())) {
                        propertyName = child.getTextContent();
                    } else if(Tags.PROPERTY_VALUE.toString().equals(child.getNodeName())) {
                        propertyValue = child.getTextContent();
                    }
                }

                if (propertyName != null && propertyValue != null) {
                    map.put(propertyName, propertyValue);
                }
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