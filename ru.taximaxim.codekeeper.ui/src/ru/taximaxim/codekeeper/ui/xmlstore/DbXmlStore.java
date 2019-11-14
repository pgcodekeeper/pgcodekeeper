package ru.taximaxim.codekeeper.ui.xmlstore;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.SecurePreferencesFactory;
import org.eclipse.equinox.security.storage.StorageException;
import org.eclipse.equinox.security.storage.provider.IProviderHints;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cz.startnet.utils.pgdiff.xmlstore.XmlStore;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;

public class DbXmlStore extends XmlStore<DbInfo> {

    public static final DbXmlStore INSTANCE = new DbXmlStore();

    private static final String FILE_NAME = "dbstore.xml"; //$NON-NLS-1$

    private final List<IPropertyChangeListener> listeners = new ArrayList<>();

    private final ISecurePreferences securePrefs;

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
        PGDUMP_EXE_PATH("pgdump_exe_path"), //$NON-NLS-1$
        PGDUMP_CUSTOM_PARAMS("pgdump_custom_params"), //$NON-NLS-1$
        PG_DUMP_SWITCH("pg_dump_switch"), //$NON-NLS-1$
        PROPERTY_LIST("property_list"), //$NON-NLS-1$
        PROPERTY("property"), //$NON-NLS-1$
        PROPERTY_NAME("name"), //$NON-NLS-1$
        PROPERTY_VALUE("value"), //$NON-NLS-1$
        MSSQL("mssql"), //$NON-NLS-1$
        WIN_AUTH("win_auth"), //$NON-NLS-1$
        DOMAIN("domain"); //$NON-NLS-1$

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

        ISecurePreferences pref;
        try {
            // it's necessary for disable dialog "Secure Storage - Password Hint Needed"
            // "https://www.eclipse.org/lists/equinox-dev/msg08899.html"
            // "https://bugs.eclipse.org/bugs/show_bug.cgi?id=260899"
            Map<String, Boolean> options = new HashMap<>();
            options.put(IProviderHints.PROMPT_USER, false);
            pref = SecurePreferencesFactory
                    .open(null, options).node(PLUGIN_ID.THIS);
        } catch (IOException e) {
            Log.log(e);
            // it's necessary for guaranteed creation of Secure Storage
            pref = SecurePreferencesFactory.getDefault().node(PLUGIN_ID.THIS);
        }

        securePrefs = pref;
    }

    @Override
    protected Path getXmlFile() {
        return Paths.get(Platform.getStateLocation(Activator.getContext().getBundle())
                .append(fileName).toString());
    }

    @Override
    public void writeObjects(List<DbInfo> list) {
        try {
            super.writeObjects(list);
            saveToSecureStorage(list);
            notifyListeners();
        } catch (StorageException e) {
            Log.log(Log.LOG_ERROR, "Error writing to secure storage: " + e); //$NON-NLS-1$
        } catch (IOException e) {
            Log.log(Log.LOG_ERROR, "Error writing db store to xml " + e); //$NON-NLS-1$
        }
    }

    private void saveToSecureStorage(List<DbInfo> list) throws StorageException, IOException {
        securePrefs.clear();
        for (DbInfo dbInfo : list) {
            securePrefs.put(dbInfo.getName(), dbInfo.getDbPass(), true);
        }
        securePrefs.flush();
    }

    @Override
    protected void appendChildren(Document xml, Element root, List<DbInfo> list) {
        for (DbInfo dbInfo : list) {
            Element keyElement = xml.createElement(Tags.DB_INFO.toString());
            root.appendChild(keyElement);

            createSubElement(xml, keyElement, Tags.NAME.toString(), dbInfo.getName());
            createSubElement(xml, keyElement, Tags.DBNAME.toString(), dbInfo.getDbName());
            createSubElement(xml, keyElement, Tags.DBUSER.toString(), dbInfo.getDbUser());
            createSubElement(xml, keyElement, Tags.DBPASS.toString(), ""); //$NON-NLS-1$
            createSubElement(xml, keyElement, Tags.DBHOST.toString(), dbInfo.getDbHost());
            createSubElement(xml, keyElement, Tags.DBPORT.toString(), String.valueOf(dbInfo.getDbPort()));
            createSubElement(xml, keyElement, Tags.READ_ONLY.toString(), String.valueOf(dbInfo.isReadOnly()));
            createSubElement(xml, keyElement, Tags.GENERATE_NAME.toString(), String.valueOf(dbInfo.isGeneratedName()));
            createSubElement(xml, keyElement, Tags.MSSQL.toString(), String.valueOf(dbInfo.isMsSql()));
            createSubElement(xml, keyElement, Tags.WIN_AUTH.toString(), String.valueOf(dbInfo.isWinAuth()));
            createSubElement(xml, keyElement, Tags.DOMAIN.toString(), dbInfo.getDomain());
            createSubElement(xml, keyElement, Tags.PG_DUMP_SWITCH.toString(), String.valueOf(dbInfo.isPgDumpSwitch()));
            createSubElement(xml, keyElement, Tags.PGDUMP_CUSTOM_PARAMS.toString(), dbInfo.getPgdumpCustomParams());
            createSubElement(xml, keyElement, Tags.PGDUMP_EXE_PATH.toString(), dbInfo.getPgdumpExePath());

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
                    tag = Tags.valueOf(param.getNodeName().toUpperCase(Locale.ROOT));
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
                case DOMAIN:
                case PG_DUMP_SWITCH:
                case PGDUMP_CUSTOM_PARAMS:
                case PGDUMP_EXE_PATH:
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

        String dbPass = object.get(Tags.DBPASS);
        try {
            dbPass = securePrefs.get(object.get(Tags.NAME), dbPass);
        } catch (StorageException e) {
            Log.log(Log.LOG_ERROR, "Error reading from secure storage: " + e); //$NON-NLS-1$
        }

        return new DbInfo(object.get(Tags.NAME), object.get(Tags.DBNAME),
                object.get(Tags.DBUSER), dbPass, object.get(Tags.DBHOST),
                Integer.parseInt(object.get(Tags.DBPORT)),
                Boolean.parseBoolean(object.get(Tags.READ_ONLY)),
                Boolean.parseBoolean(object.get(Tags.GENERATE_NAME)),
                ignoreFiles, properties,
                Boolean.parseBoolean(object.get(Tags.MSSQL)),
                Boolean.parseBoolean(object.get(Tags.WIN_AUTH)),
                object.get(Tags.DOMAIN), object.get(Tags.PGDUMP_EXE_PATH),
                object.get(Tags.PGDUMP_CUSTOM_PARAMS),
                Boolean.parseBoolean(object.get(Tags.PG_DUMP_SWITCH)));
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