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
package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.stream.Stream;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.AbstractHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ide.ResourceUtil;

import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation.LocationType;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class SQLEditorHyperLinkDetector extends AbstractHyperlinkDetector {

    @Override
    public IHyperlink[] detectHyperlinks(ITextViewer textViewer, IRegion region,
            boolean canShowMultipleHyperlinks) {
        String project;
        SQLEditor editor = getAdapter(SQLEditor.class);
        IEditorInput input = editor.getEditorInput();
        if (input instanceof SQLEditorInput sqlInput) {
            project = sqlInput.getProject();
        } else {
            IResource res = ResourceUtil.getResource(input);
            project = res == null ? null : res.getProject().getName();
        }

        Stream<IHyperlink> links = getLinks(project, editor, region.getOffset());
        IHyperlink[] result = links.toArray(IHyperlink[]::new);
        return result.length == 0 ? null : result;
    }

    private Stream<IHyperlink> getLinks(String project, SQLEditor editor, int offset) {
        Stream<IHyperlink> links = Stream.empty();

        PgDbParser parser = editor.getParser();

        for (PgObjLocation obj : parser.getObjsForEditor(editor.getEditorInput())) {
            if (offset >= obj.getOffset() && offset < (obj.getOffset() + obj.getObjLength())) {
                Stream<IHyperlink> stream = parser.getAllObjReferences()
                        .filter(obj::compare)
                        .filter(def -> {
                            LocationType type = def.getLocationType();
                            if (type == LocationType.DEFINITION) {
                                return true;
                            }
                            if (type == LocationType.VARIABLE) {
                                // search only on current file
                                return def.getFilePath().equals(obj.getFilePath());
                            }

                            return false;
                        })
                        .map(def -> new SQLEditorHyperLink(
                                new Region(def.getOffset(), def.getObjLength()),
                                new Region(obj.getOffset(), obj.getObjLength()),
                                obj.getObjName(), def.getFilePath(),
                                def.getLineNumber(), editor.getDbType(), project));
                links = Stream.concat(links, stream);
            }
        }
        return links;
    }
}