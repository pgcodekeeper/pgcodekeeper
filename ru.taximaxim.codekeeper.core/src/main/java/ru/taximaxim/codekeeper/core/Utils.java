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
package ru.taximaxim.codekeeper.core;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.UnaryOperator;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.settings.ISettings;

public final class Utils {

    private static final Logger LOG = LoggerFactory.getLogger(Utils.class);

    public static void serialize(String path, Serializable object) {
        serialize(Paths.get(path), object);
    }

    /**
     * Serializes object
     *
     * @param path - full path to file where the serialized object will be
     * @param object - the object that you want to serialize
     */
    public static void serialize(Path path, Serializable object) {
        try {
            if (Files.notExists(path)) {
                Files.createDirectories(path.getParent());
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
                oos.writeObject(object);
                oos.flush();
            }
        } catch (IOException e) {
            LOG.debug(Messages.Utils_log_err_serialize, e);
        }
    }

    public static Document readXml(Reader reader) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Disable DOCTYPE declarations entirely
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true); //$NON-NLS-1$

        // Disable external general entities
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false); //$NON-NLS-1$

        // Disable external parameter entities
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false); //$NON-NLS-1$

        // Prohibit the use of all protocols by external entities (JAXP 1.5+)
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, ""); //$NON-NLS-1$
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, ""); //$NON-NLS-1$

        Document doc = factory.newDocumentBuilder().parse(new InputSource(reader));
        doc.normalize();
        return doc;
    }

    public static void writeXml(Document xml, boolean encrypt, StreamResult stream) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, ""); //$NON-NLS-1$
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, ""); //$NON-NLS-1$

        if (encrypt) {
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        }

        Transformer tf = factory.newTransformer();
        tf.setOutputProperty(OutputKeys.INDENT, "yes"); //$NON-NLS-1$
        tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); //$NON-NLS-1$ //$NON-NLS-2$
        tf.transform(new DOMSource(xml), stream);
    }

    public static boolean isSystemSchema(String schema, DatabaseType dbType) {
        return switch (dbType) {
            case PG -> isPgSystemSchema(schema);
            case MS -> isMsSystemSchema(schema);
            case CH -> isChSystemSchema(schema);
            default -> throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
        };
    }

    public static String getQuotedName(String name, DatabaseType dbType) {
        return getQuoter(dbType).apply(name);
    }

    public static UnaryOperator<String> getQuoter(DatabaseType dbType) {
        return switch (dbType) {
            case PG -> PgDiffUtils::getQuotedName;
            case MS -> MsDiffUtils::quoteName;
            case CH -> ChDiffUtils::getQuotedName;
            default -> throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
        };
    }

    public static boolean isChSystemSchema(String schema) {
        return Consts.SYSTEM.equalsIgnoreCase(schema)
                || Consts.INFORMATION_SCHEMA.equalsIgnoreCase(schema);
    }

    public static boolean isPgSystemSchema(String schema) {
        return Consts.PG_CATALOG.equalsIgnoreCase(schema)
                || Consts.INFORMATION_SCHEMA.equalsIgnoreCase(schema);
    }

    public static boolean isMsSystemSchema(String schema) {
        return Consts.SYS.equalsIgnoreCase(schema);
    }

    public static boolean stringContainsAnyItem(String inputStr, List<String> items) {
        return items.stream().anyMatch(inputStr::contains);
    }

    public static String checkNewLines(String text, ISettings settings) {
        return settings.isKeepNewlines() ? text : text.replace("\r", "");
    }

    private Utils() {
    }
}
