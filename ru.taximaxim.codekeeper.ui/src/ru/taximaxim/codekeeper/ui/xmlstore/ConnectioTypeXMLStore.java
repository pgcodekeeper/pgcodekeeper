/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.pgcodekeeper.core.xmlstore.XmlStore;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.dbstore.ConnectionTypeInfo;

public final class ConnectioTypeXMLStore extends XmlStore<ConnectionTypeInfo> {

    private static final String FILE_NAME = "contypestore.xml"; //$NON-NLS-1$
    public static final ConnectioTypeXMLStore INSTANCE = new ConnectioTypeXMLStore(
            Paths.get(Platform.getStateLocation(Activator.getContext().getBundle()).append(FILE_NAME).toString()));

    private final Path path;

    private enum Tags {
        CON_TYPE_STORE("con_type_store"), //$NON-NLS-1$
        CON_TYPE_INFO("con_type_info"), //$NON-NLS-1$
        NAME("name"), //$NON-NLS-1$
        COLOR("color"); //$NON-NLS-1$

        String name;

        private Tags(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public ConnectioTypeXMLStore(Path path) {
        super(path.getFileName().toString(), Tags.CON_TYPE_STORE.toString());
        this.path = path;
    }

    public static List<ConnectionTypeInfo> readStoreFromXml() {
        try {
            return INSTANCE.readObjects();
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
    protected ConnectionTypeInfo parseElement(Node node) {
        NodeList params = node.getChildNodes();
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
                object.put(tag, param.getTextContent());
            }
        }
        return new ConnectionTypeInfo(object.get(Tags.NAME), object.get(Tags.COLOR));
    }

    @Override
    protected void appendChildren(Document xml, Element root, List<ConnectionTypeInfo> list) {
        for (var сonTypeInfo : list) {
            Element keyElement = xml.createElement(Tags.CON_TYPE_INFO.toString());
            root.appendChild(keyElement);

            createSubElement(xml, keyElement, Tags.NAME.toString(), сonTypeInfo.getName());
            createSubElement(xml, keyElement, Tags.COLOR.toString(), сonTypeInfo.getColor());
        }
    }
}
