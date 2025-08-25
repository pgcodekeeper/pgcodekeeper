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

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.pgcodekeeper.core.xmlstore.XmlStore;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

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
    protected Path getXmlFile() {
        return Paths.get(Platform.getStateLocation(Activator.getContext().getBundle())
                .append(fileName).toString());
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
