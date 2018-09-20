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

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.MARKER;

/**
 * {@link PgDumpLoader} extension that works with workspace {@link IResource} structure
 * instead of actual file system.<br>
 * Converts ANTLR parsing errors to {@link IMarker}s for {@link IResource}s.
 */
public class PgUIDumpLoader extends PgDumpLoader {

    private final IFile file;

    public PgUIDumpLoader(IFile ifile, PgDiffArguments args, IProgressMonitor monitor, int monitoringLevel)
            throws CoreException {
        super(ifile.getContents(), ifile.getLocation().toOSString(), args, monitor, monitoringLevel);
        file = ifile;
    }

    /**
     * This constructor sets the monitoring level to the default of 1.
     * @throws CoreException
     */
    public PgUIDumpLoader(IFile ifile, PgDiffArguments args, IProgressMonitor monitor)
            throws CoreException {
        this(ifile, args, monitor, 1);
    }

    /**
     * This constructor uses {@link NullProgressMonitor}.
     * @throws CoreException
     */
    public PgUIDumpLoader(IFile ifile, PgDiffArguments args) throws CoreException {
        this(ifile, args, new NullProgressMonitor(), 0);
    }

    public PgDatabase loadFile(PgDatabase db) throws InterruptedException, IOException {
        try {
            load(db);
            return db;
        } finally {
            updateMarkers();
        }
    }

    private void updateMarkers() {
        try {
            file.deleteMarkers(MARKER.ERROR, false, IResource.DEPTH_ZERO);
        } catch (CoreException ex) {
            Log.log(ex);
        }
        IDocument doc = null;
        for (AntlrError antlrError : getErrors()) {
            try {
                IMarker marker = file.createMarker(MARKER.ERROR);
                int line = antlrError.getLine();
                marker.setAttribute(IMarker.LINE_NUMBER, line);
                marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
                marker.setAttribute(IMarker.MESSAGE, antlrError.getMsg());
                int start = antlrError.getStart();
                int stop = antlrError.getStop();
                if (start == -1 || stop == -1) {
                    if (doc == null) {
                        // load only when this case actually happens
                        IDocumentProvider provider = new TextFileDocumentProvider();
                        provider.connect(file);
                        doc = provider.getDocument(file);
                    }
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
}