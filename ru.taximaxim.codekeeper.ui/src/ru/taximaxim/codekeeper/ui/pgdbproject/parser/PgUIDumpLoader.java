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
package ru.taximaxim.codekeeper.ui.pgdbproject.parser;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;
import org.eclipse.ui.texteditor.IDocumentProvider;

import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.loader.PgDumpLoader;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrError;
import ru.taximaxim.codekeeper.core.parsers.antlr.ErrorTypes;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.MARKER;

/**
 * {@link PgDumpLoader} extension that works with workspace {@link IResource} structure
 * instead of actual file system.<br>
 * Converts ANTLR parsing errors to {@link IMarker}s for {@link IResource}s.
 */
public class PgUIDumpLoader extends PgDumpLoader {

    private final IFile file;

    public PgUIDumpLoader(IFile ifile, PgDiffArguments args, IProgressMonitor monitor, int monitoringLevel) {
        super(() -> {
            try {
                return ifile.getContents();
            } catch (CoreException ex) {
                throw new IOException(ex.getLocalizedMessage(), ex);
            }
        }, ifile.getLocation().toOSString(), args, monitor, monitoringLevel);
        file = ifile;
    }

    /**
     * This constructor sets the monitoring level to the default of 1.
     * @throws CoreException
     */
    public PgUIDumpLoader(IFile ifile, PgDiffArguments args, IProgressMonitor monitor) {
        this(ifile, args, monitor, 1);
    }

    /**
     * This constructor uses {@link NullProgressMonitor}.
     * @throws CoreException
     */
    public PgUIDumpLoader(IFile ifile, PgDiffArguments args) {
        this(ifile, args, new NullProgressMonitor(), 0);
    }

    public AbstractDatabase loadFile(AbstractDatabase db) throws InterruptedException, IOException {
        loadDatabase(db, antlrTasks);
        finishLoaders();
        return db;
    }

    @Override
    protected void finishLoaders() throws InterruptedException, IOException {
        try {
            super.finishLoaders();
        } finally {
            updateMarkers();
        }
    }

    protected void updateMarkers() {
        try {
            file.deleteMarkers(MARKER.ERROR, false, IResource.DEPTH_ZERO);
        } catch (CoreException ex) {
            Log.log(ex);
        }
        for (Object error : getErrors()) {
            if (error instanceof AntlrError antlrError) {
                addMarker(file, antlrError);
            }
        }
    }

    public static void addMarker(IFile file, AntlrError antlrError) {
        try {
            IMarker marker = file.createMarker(MARKER.ERROR);
            int line = antlrError.getLineNumber();
            marker.setAttribute(IMarker.LINE_NUMBER, line);
            marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
            marker.setAttribute(IMarker.MESSAGE, antlrError.getMsg());
            marker.setAttribute(IMarker.BOOKMARK, antlrError.getMsg());
            if (antlrError.getErrorType() == ErrorTypes.MISPLACEERROR) {
                marker.setAttribute(MARKER.ERROR_TYPE, MARKER.MISPLACE_ERROR);
            }
            int start = antlrError.getStart();
            int stop = antlrError.getStop();
            if (start == -1 || stop == -1) {
                // load only when this case actually happens
                IDocumentProvider provider = new TextFileDocumentProvider();
                provider.connect(file);
                IDocument doc = provider.getDocument(file);
                int lineOffset = doc.getLineOffset(line - 1);
                start = lineOffset + antlrError.getCharPositionInLine();
                stop = start;
            }
            marker.setAttribute(IMarker.CHAR_START, start);
            marker.setAttribute(IMarker.CHAR_END, stop + 1);

        } catch (BadLocationException | CoreException ex) {
            Log.log(ex);
        }
    }
}