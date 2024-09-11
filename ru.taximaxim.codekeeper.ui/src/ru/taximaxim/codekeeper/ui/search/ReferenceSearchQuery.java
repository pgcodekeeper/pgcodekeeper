/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.text.Match;

import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class ReferenceSearchQuery implements ISearchQuery {

    private final ReferenceSearchResult result;

    private final PgObjLocation ref;
    private final PgDbParser parser;

    public ReferenceSearchQuery(PgObjLocation ref, IProject proj) {
        this.ref = ref;
        this.parser = PgDbParser.getParser(proj);
        this.result = new ReferenceSearchResult(this);
    }

    @Override
    public IStatus run(IProgressMonitor monitor) {
        ReferenceSearchResult res = (ReferenceSearchResult) getSearchResult();
        res.removeAll();

        List<PgObjLocation> locs = parser.getAllObjReferences().filter(ref::compare).toList();
        SubMonitor sub = SubMonitor.convert(monitor, locs.size());
        for (PgObjLocation loc : locs) {
            PgObjLocation copy = getLocationCopy(loc);
            if (copy != null) {
                res.addMatch(new Match(copy, loc.getOffset(), loc.getObjLength()));
            }
            sub.worked(1);
            if (sub.isCanceled()) {
                return Status.CANCEL_STATUS;
            }
        }
        sub.done();

        return Status.OK_STATUS;
    }

    private PgObjLocation getLocationCopy(PgObjLocation loc) {
        String sql = getLineFromFile(loc.getFilePath(), loc.getLineNumber());
        if (sql == null) {
            return null;
        }

        return new PgObjLocation.Builder()
                .setOffset(loc.getOffset())
                .setLineNumber(loc.getLineNumber())
                .setCharPositionInLine(loc.getCharPositionInLine())
                .setFilePath(loc.getFilePath())
                .setSql(sql)
                .build();
    }

    private String getLineFromFile(String filePath, int lineNumber) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            int skip = lineNumber - 1;
            return lines.skip(skip).findFirst().orElse(null);
        } catch (IOException e) {
            Log.log(e);
            return null;
        }
    }

    public PgObjLocation getReference() {
        return ref;
    }

    @Override
    public String getLabel() {
        return "Searching for '" + ref.getQualifiedName() + '\''; //$NON-NLS-1$
    }

    @Override
    public boolean canRerun() {
        return true;
    }

    @Override
    public boolean canRunInBackground() {
        return true;
    }

    @Override
    public ISearchResult getSearchResult() {
        return result;
    }
}
