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

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ru.taximaxim.codekeeper.core.xmlstore.XmlStore;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;

public class IgnoreListsXmlStore extends XmlStore<String> {

    private static final String SETTINGS = ".settings"; //$NON-NLS-1$

    private static final String ROOT_TAG = "IgnoreListsPathsStore"; //$NON-NLS-1$
    private static final String ENTRY = "IgnoreListPath"; //$NON-NLS-1$

    private final Path path;

    public IgnoreListsXmlStore(Path path) {
        super(path.getFileName().toString(), ROOT_TAG);
        this.path = path;
    }

    public IgnoreListsXmlStore(IProject proj) {
        this(Paths.get(proj.getLocation().append(SETTINGS)
                .append(FILE.IGNORE_LISTS_STORE).toString()));
    }

    @Override
    public Path getXmlFile() {
        return path;
    }

    @Override
    protected String parseElement(Node node) {
        return node.getTextContent();
    }

    @Override
    protected void appendChildren(Document xml, Element root,
            List<String> list) {
        for (String path : list) {
            Element newElement = xml.createElement(ENTRY);
            newElement.setTextContent(path);
            root.appendChild(newElement);
        }
    }
}