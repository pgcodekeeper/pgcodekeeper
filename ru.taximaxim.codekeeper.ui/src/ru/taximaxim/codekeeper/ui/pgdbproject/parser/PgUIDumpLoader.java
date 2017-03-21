package ru.taximaxim.codekeeper.ui.pgdbproject.parser;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
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
import cz.startnet.utils.pgdiff.parsers.antlr.FunctionBodyContainer;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
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

    public PgDatabase loadFile(boolean loadReferences, PgDatabase db)
            throws InterruptedException, IOException, CoreException {
        load(loadReferences, db);

        file.deleteMarkers(MARKER.ERROR, false, IResource.DEPTH_ZERO);
        IDocument doc = null;
        for (AntlrError antlrError : getErrors()) {
            IMarker marker = file.createMarker(MARKER.ERROR);
            int line = antlrError.getLine();
            marker.setAttribute(IMarker.LINE_NUMBER, line);
            marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
            marker.setAttribute(IMarker.MESSAGE, antlrError.getMsg());
            try {
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
            } catch (BadLocationException ex) {
                Log.log(ex);
            }
        }
        return db;
    }

    /**
     * Loads database schema from a ModelExporter directory tree. The root
     * directory must contain a listing.lst file for ordered list of files.
     *
     * @return database schema
     */
    public static PgDatabase loadDatabaseSchemaFromIProject(IProject iProject,
            PgDiffArguments arguments, IProgressMonitor monitor, List<FunctionBodyContainer> funcBodies)
                    throws InterruptedException, IOException, LicenseException, CoreException {
        PgDatabase db = new PgDatabase();
        db.dropPublic();
        db.setArguments(arguments);
        for (ApgdiffConsts.WORK_DIR_NAMES workDirName : ApgdiffConsts.WORK_DIR_NAMES.values()) {
            IFolder iFolder = iProject.getFolder(workDirName.name());
            if (iFolder.exists()) {
                loadSubdir(arguments, iFolder, db, monitor, funcBodies);
            }
        }

        IFolder schemasCommonDir = iProject.getFolder(ApgdiffConsts.WORK_DIR_NAMES.SCHEMA.name());
        // skip walking SCHEMA folder if it does not exist
        if (!schemasCommonDir.exists()) {
            return db;
        }

        // step 2
        // read out schemas names, and work in loop on each
        for (PgSchema schema : db.getSchemas()) {
            IFolder schemaFolder = schemasCommonDir.getFolder(ModelExporter.getExportedFilename(schema));
            for (String dirSub : DIR_LOAD_ORDER) {
                IFolder iFolder = schemaFolder.getFolder(dirSub);
                if (iFolder.exists()) {
                    loadSubdir(arguments, iFolder, db, monitor, funcBodies);
                }
            }
        }
        arguments.getLicense().verifyDb(db);
        return db;
    }

    private static void loadSubdir(PgDiffArguments arguments, IFolder folder, PgDatabase db,
            IProgressMonitor monitor, List<FunctionBodyContainer> funcBodies)
                    throws InterruptedException, IOException, CoreException {
        for (IResource resource : folder.members()) {
            if (resource.getType() == IResource.FILE && "sql".equals(resource.getFileExtension())) { //$NON-NLS-1$
                IFile ifile = (IFile) resource;
                try (PgUIDumpLoader loader = new PgUIDumpLoader(ifile, arguments, monitor)) {
                    loader.loadFile(funcBodies != null, db);
                    if (funcBodies != null) {
                        funcBodies.addAll(loader.getFuncBodyReferences());
                    }
                }
            }
        }
    }

    public static int countFiles(IContainer container) throws CoreException {
        final int[] count = new int[1];
        container.accept(new IResourceProxyVisitor() {

            @Override
            public boolean visit(IResourceProxy proxy) throws CoreException {
                if (proxy.getType() == IResource.FILE) {
                    ++count[0];
                }
                return true;
            }
        }, IResource.FILE);
        return count[0];
    }
}