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
package ru.taximaxim.codekeeper.ui.search;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.eclipse.search.ui.text.IEditorMatchAdapter;
import org.eclipse.search.ui.text.IFileMatchAdapter;
import org.eclipse.search.ui.text.Match;
import org.eclipse.ui.IEditorPart;
import org.pgcodekeeper.core.schema.PgObjLocation;

import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class ReferenceSearchResult extends AbstractTextSearchResult
implements IEditorMatchAdapter, IFileMatchAdapter {

    private static final String RESULT_LABEL = Messages.ReferenceSearchResult_matches;

    private static final Match[] EMPTY_ARRAY = new Match[0];

    private final ReferenceSearchQuery query;

    public ReferenceSearchResult(ReferenceSearchQuery query) {
        this.query = query;
    }

    @Override
    public String getLabel() {
        return RESULT_LABEL.formatted(query.getReference().getQualifiedName(), getMatchCount());
    }

    @Override
    public String getTooltip() {
        return getLabel();
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return null;
    }

    @Override
    public ISearchQuery getQuery() {
        return query;
    }

    @Override
    public IEditorMatchAdapter getEditorMatchAdapter() {
        return this;
    }

    @Override
    public IFileMatchAdapter getFileMatchAdapter() {
        return this;
    }

    @Override
    public Match[] computeContainedMatches(AbstractTextSearchResult result, IFile file) {
        String path = file.getLocation().toOSString();
        return computeContainedMatches(result, path);
    }

    @Override
    public IFile getFile(Object element) {
        if (element instanceof PgObjLocation loc) {
            return ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(loc.getFilePath()));
        }
        return null;
    }

    @Override
    public boolean isShownInEditor(Match match, IEditorPart editor) {
        if (editor instanceof SQLEditor) {
            PgObjLocation loc = (PgObjLocation) match.getElement();
            String path = PgDbParser.getPathFromInput(editor.getEditorInput());
            return loc.getFilePath().equals(path);
        }

        return false;
    }

    @Override
    public Match[] computeContainedMatches(AbstractTextSearchResult result, IEditorPart editor) {
        String path = PgDbParser.getPathFromInput(editor.getEditorInput());
        return computeContainedMatches(result, path);
    }

    private Match[] computeContainedMatches(AbstractTextSearchResult result, String path) {
        if (path == null) {
            return EMPTY_ARRAY;
        }

        Set<Match> matches = new HashSet<>();
        for (Object obj : result.getElements()) {
            PgObjLocation loc = (PgObjLocation) obj;
            if (loc.getFilePath().equals(path)) {
                Collections.addAll(matches, getMatches(loc));
            }
        }

        return matches.toArray(new Match[matches.size()]);
    }
}
