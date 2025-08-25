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
package ru.taximaxim.codekeeper.ui.xmlstore;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.SecurePreferencesFactory;
import org.eclipse.equinox.security.storage.StorageException;
import org.eclipse.equinox.security.storage.provider.IProviderHints;
import org.pgcodekeeper.core.DatabaseType;
import org.pgcodekeeper.core.Utils;
import org.pgcodekeeper.core.xmlstore.XmlStore;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;

public final class DbXmlStore extends XmlStore<DbInfo> {

    private static final int KEY_SIZE = 256;
    private static final String CIPHER_KEY = PLUGIN_ID.THIS + ".cipherSecret"; //$NON-NLS-1$
    private static final String ALGORITHM = "AES"; //$NON-NLS-1$
    private static final String FILE_NAME = "dbstore.xml"; //$NON-NLS-1$
    public static final DbXmlStore INSTANCE = new DbXmlStore(Paths.get(
            Platform.getStateLocation(Activator.getContext().getBundle()).append(FILE_NAME).toString()), true);

    private final ISecurePreferences securePrefs;
    private final Path path;

    private List<DbInfo> store = new ArrayList<>();
    private boolean isDirty = true;
    private boolean encrypt;

    private enum Tags {
        DB_STORE("db_store"), //$NON-NLS-1$
        DB_INFO("db_info"), //$NON-NLS-1$
        NAME("name"), //$NON-NLS-1$
        DBNAME("dbname"), //$NON-NLS-1$
        DBUSER("dbuser"), //$NON-NLS-1$
        DBPASS("dbpass"), //$NON-NLS-1$
        DBGROUP("dbgroup"), //$NON-NLS-1$
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
        DB_TYPE("db_type"), //$NON-NLS-1$
        WIN_AUTH("win_auth"), //$NON-NLS-1$
        DOMAIN("domain"), //$NON-NLS-1$
        CON_TYPE("con_type"); //$NON-NLS-1$

        String name;

        private Tags(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public DbXmlStore(Path path, boolean encrypt) {
        super(path.getFileName().toString(), Tags.DB_STORE.toString());
        this.path = path;
        this.encrypt = encrypt;

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

    public static List<DbInfo> getStore() {
        return INSTANCE.readStore();
    }

    private List<DbInfo> readStore() {
        if (isDirty) {
            store = readStoreFromXml();
            isDirty = false;
        }

        return store;
    }

    private List<DbInfo> readStoreFromXml() {
        try {
            return readObjects();
        } catch (IOException e) {
            Log.log(e);
            return new ArrayList<>();
        }
    }

    @Override
    protected Path getXmlFile() {
        return path;
    }

    @Override
    public void writeObjects(List<DbInfo> list) throws IOException {
        isDirty = true;
        super.writeObjects(list);
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
            createSubElement(xml, keyElement, Tags.DBGROUP.toString(), dbInfo.getDbGroup());
            createSubElement(xml, keyElement, Tags.DBHOST.toString(), dbInfo.getDbHost());
            createSubElement(xml, keyElement, Tags.DBPORT.toString(), String.valueOf(dbInfo.getDbPort()));
            createSubElement(xml, keyElement, Tags.READ_ONLY.toString(), String.valueOf(dbInfo.isReadOnly()));
            createSubElement(xml, keyElement, Tags.GENERATE_NAME.toString(), String.valueOf(dbInfo.isGeneratedName()));
            createSubElement(xml, keyElement, Tags.MSSQL.toString(), String.valueOf(dbInfo.getDbType() == DatabaseType.MS));
            createSubElement(xml, keyElement, Tags.DB_TYPE.toString(), String.valueOf(dbInfo.getDbType()));
            createSubElement(xml, keyElement, Tags.WIN_AUTH.toString(), String.valueOf(dbInfo.isWinAuth()));
            createSubElement(xml, keyElement, Tags.DOMAIN.toString(), dbInfo.getDomain());
            createSubElement(xml, keyElement, Tags.PG_DUMP_SWITCH.toString(), String.valueOf(dbInfo.isPgDumpSwitch()));
            createSubElement(xml, keyElement, Tags.PGDUMP_CUSTOM_PARAMS.toString(), dbInfo.getPgdumpCustomParams());
            createSubElement(xml, keyElement, Tags.PGDUMP_EXE_PATH.toString(), dbInfo.getPgdumpExePath());
            createSubElement(xml, keyElement, Tags.CON_TYPE.toString(), dbInfo.getConType());

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
                case DBGROUP:
                case DBHOST:
                case DBPORT:
                case READ_ONLY:
                case GENERATE_NAME:
                case MSSQL:
                case DB_TYPE:
                case WIN_AUTH:
                case DOMAIN:
                case PG_DUMP_SWITCH:
                case PGDUMP_CUSTOM_PARAMS:
                case PGDUMP_EXE_PATH:
                case CON_TYPE:
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

        String dbPass = object.getOrDefault(Tags.DBPASS, ""); //$NON-NLS-1$
        // backwards compatibility
        if (dbPass.isBlank()) {
            try {
                dbPass = securePrefs.get(object.get(Tags.NAME), dbPass);
            } catch (StorageException e) {
                Log.log(Log.LOG_ERROR, "Error reading from secure storage: " + e); //$NON-NLS-1$
            }
        }

        String dbTypeText = object.get(Tags.DB_TYPE);
        DatabaseType dbType;
        if (dbTypeText != null) {
            dbType = DatabaseType.getValue(dbTypeText);
        } else {
            // backwards compatibility
            dbType = (Boolean.parseBoolean(object.get(Tags.MSSQL)) ? DatabaseType.MS : DatabaseType.PG);
        }
        return new DbInfo(object.get(Tags.NAME), object.get(Tags.DBNAME),
                object.get(Tags.DBUSER), dbPass, object.get(Tags.DBHOST),
                Integer.parseInt(object.get(Tags.DBPORT)),
                Boolean.parseBoolean(object.get(Tags.READ_ONLY)),
                Boolean.parseBoolean(object.get(Tags.GENERATE_NAME)),
                ignoreFiles, properties, dbType,
                Boolean.parseBoolean(object.get(Tags.WIN_AUTH)),
                object.get(Tags.DOMAIN), object.get(Tags.PGDUMP_EXE_PATH),
                object.get(Tags.PGDUMP_CUSTOM_PARAMS),
                Boolean.parseBoolean(object.get(Tags.PG_DUMP_SWITCH)),
                !object.containsKey(Tags.DBGROUP) ? "" : object.get(Tags.DBGROUP), //$NON-NLS-1$
                        !object.containsKey(Tags.CON_TYPE) ? "" : object.get(Tags.CON_TYPE)); //$NON-NLS-1$
    }

    private void fillIgnoreFileList(NodeList xml, List<String> list) {
        for (int i = 0; i < xml.getLength(); i++) {
            Node file = xml.item(i);
            if (Tags.IGNORE_FILE.toString().equals(file.getNodeName())) {
                list.add(file.getTextContent());
            }
        }
    }

    @Override
    protected void writeDocument(Document xml, Path path) throws IOException, TransformerException {
        if (encrypt) {
            try {
                encryptDocument(xml, path.toString(), getSecret());
            } catch (GeneralSecurityException | StorageException e) {
                throw new IOException(e);
            }
        } else {
            super.writeDocument(xml, path);
        }
    }

    @Override
    protected Document readXml() throws IOException {
        try {
            // backwards compatibility
            return super.readXml();
        } catch (IOException ex) {
            try {
                return decryptFileToDoc(getXmlFile().toString(), getSecret());
            } catch (Exception e) {
                throw new IOException(e);
            }
        }
    }

    private SecretKey getSecret() throws StorageException, NoSuchAlgorithmException, IOException {
        String encodedKey = securePrefs.get(CIPHER_KEY, null);
        if (encodedKey != null && !encodedKey.isEmpty()) {
            byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
            return new SecretKeySpec(decodedKey, ALGORITHM);
        }

        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(KEY_SIZE);
        var secret = keyGen.generateKey();
        securePrefs.put(CIPHER_KEY, Base64.getEncoder().encodeToString(secret.getEncoded()), true);
        securePrefs.flush();
        return secret;
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

    private void encryptDocument(Document xmlDoc, String outputFile, SecretKey secret)
            throws GeneralSecurityException, IOException, TransformerException {
        byte[] iv = new byte[16];
        Utils.getRandom().nextBytes(iv);

        Cipher cipher = createCipher(secret, iv, Cipher.ENCRYPT_MODE);

        try (FileOutputStream out = new FileOutputStream(outputFile)) {
            out.write(iv);

            try (CipherOutputStream cipherOut = new CipherOutputStream(out, cipher)) {
                Utils.writeXml(xmlDoc, true, new StreamResult(cipherOut));
            }
        }
    }

    private Document decryptFileToDoc(String inputFile, SecretKey secret)
            throws IOException, GeneralSecurityException, ParserConfigurationException, SAXException {
        try (FileInputStream in = new FileInputStream(inputFile)) {
            byte[] iv = new byte[16];
            if (in.read(iv) != 16) {
                throw new IOException("IV not found or invalid!"); //$NON-NLS-1$
            }
            Cipher cipher = createCipher(secret, iv, Cipher.DECRYPT_MODE);

            try (CipherInputStream cipherIn = new CipherInputStream(in, cipher);
                    var input = new InputStreamReader(cipherIn, StandardCharsets.UTF_8.newDecoder());
                    var reader = new BufferedReader(input)) {
                return Utils.readXml(reader);
            }
        }
    }

    private Cipher createCipher(SecretKey secret, byte[] iv, int mode) throws GeneralSecurityException {
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        Cipher cipher = Cipher.getInstance(secret.getAlgorithm());
        cipher.init(mode, secret, ivSpec);
        return cipher;
    }
}

