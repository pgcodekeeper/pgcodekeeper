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
package ru.taximaxim.codekeeper.core.loader.jdbc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ru.taximaxim.codekeeper.core.Utils;

public class XmlReader {

    private static final String ROOT = "root";

    private final Map <String, String> result;

    private XmlReader(Map<String, String> result) {
        this.result = result;
    }

    public double getDouble(String columnName) {
        String val = result.get(columnName);
        return val == null ? 0 : Double.parseDouble(val);
    }

    public long getLong(String columnName) {
        String val = result.get(columnName);
        return val == null ? 0 : Long.parseLong(val);
    }

    public boolean getBoolean(String columnName) {
        String o = result.get(columnName);
        return "1".equals(o);
    }

    public String getString(String columnName) {
        return result.get(columnName);
    }

    public float getFloat(String columnName) {
        String val = result.get(columnName);
        return val == null ? 0 : Float.parseFloat(val);
    }

    public int getInt(String columnName) {
        String val = result.get(columnName);
        return val == null ? 0 : Integer.parseInt(val);
    }

    public short getShort(String columnName) {
        String val = result.get(columnName);
        return val == null ? 0 : Short.parseShort(val);
    }

    public static List<XmlReader> readXML(String xml) throws XmlReaderException {
        if (xml == null) {
            return new ArrayList<>();
        }

        try (Reader reader = new InputStreamReader(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)))) {
            Document doc = Utils.readXml(reader);

            if (!ROOT.equals(doc.getDocumentElement().getNodeName())) {
                throw new IOException("XML root element name is not as requested.");
            }

            Element root = (Element) doc.getElementsByTagName(ROOT).item(0);
            NodeList nList = root.getChildNodes();
            int size = nList.getLength();
            List<XmlReader> readers = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    readers.add(parseElement(node));
                }
            }

            return readers;
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            throw new XmlReaderException(ex.getLocalizedMessage(), ex);
        }
    }

    private static XmlReader parseElement(Node node) {
        NamedNodeMap params = node.getAttributes();
        int size = params.getLength();
        Map<String, String> attr = new HashMap<>(size);

        for (int i = 0; i < size; i++) {
            Node param = params.item(i);
            if (param.getNodeType() == Node.ATTRIBUTE_NODE) {
                attr.put(param.getNodeName(), param.getTextContent());
            }
        }

        return new XmlReader(attr);
    }
}