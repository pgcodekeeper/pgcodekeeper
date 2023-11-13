/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

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
            LOG.debug("Error while serialize object!", e);
        }
    }

    /**
     * Deserializes object
     *
     * @param inputStream
     *            - stream of serialized file
     *
     * @return deserialized object or null if not found
     */
    public static Object deserialize(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try (ObjectInputStream oin = new ObjectInputStream(inputStream)) {
            return oin.readObject();
        } catch (ClassNotFoundException | IOException e) {
            LOG.debug("Error while deserialize object!", e);
        }
        return null;
    }

    public static Document readXml(Reader reader) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        Document doc = factory.newDocumentBuilder().parse(new InputSource(reader));
        doc.normalize();
        return doc;
    }

    public static boolean isSystemSchema(String schema, boolean isPostgres) {
        return isPostgres ? isPgSystemSchema(schema) : isMsSystemSchema(schema);
    }

    public static boolean isPgSystemSchema(String schema) {
        return Consts.PG_CATALOG.equalsIgnoreCase(schema)
                || Consts.INFORMATION_SCHEMA.equalsIgnoreCase(schema);
    }

    public static boolean isMsSystemSchema(String schema) {
        return Consts.SYS.equalsIgnoreCase(schema);
    }

    public static void appendCols(StringBuilder sbSQL, Collection<String> cols, boolean isPostgres) {
        sbSQL.append('(');
        for (var col : cols) {
            sbSQL.append(isPostgres ? PgDiffUtils.getQuotedName(col) : MsDiffUtils.quoteName(col)).append(", ");
        }
        sbSQL.setLength(sbSQL.length() - 2);
        sbSQL.append(')');
    }

    /**
     * Appends parameters/options at StringBuilder. This StringBuilder used in
     * schema package Constraint's classes in the method getDifinition()
     *
     * @param sbSQL
     *            - the StringBuilder from method getDifinition()
     *
     * @param options
     *            - the Map<String, String> where key is parameter/option and
     *            value is value of this parameter/option
     *
     * @param isPostgres
     *            - the boolean variable in package schema what's need us for
     *            correct delimiter, because in postgres and microsoft server is
     *            different
     */
    public static void appendOptions(StringBuilder sbSQL, Map<String, String> options, boolean isPostgres) {
        sbSQL.append('(');
        for (var option : options.entrySet()) {
            sbSQL.append(option.getKey());
            if (option.getValue() != null) {
                sbSQL.append(isPostgres ? '=' : " = ").append(option.getValue());
            }
            sbSQL.append(", ");
        }
        sbSQL.setLength(sbSQL.length() - 2);
        sbSQL.append(')');
    }

    private Utils() {
    }
}
