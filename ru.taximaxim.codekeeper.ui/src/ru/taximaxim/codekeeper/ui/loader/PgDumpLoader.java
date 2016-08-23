package ru.taximaxim.codekeeper.ui.loader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.FunctionBodyContainer;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.ui.UIConsts;

public class PgDumpLoader extends cz.startnet.utils.pgdiff.loader.PgDumpLoader{

    public PgDumpLoader(InputStream input, String inputObjectName,
            PgDiffArguments args, IProgressMonitor monitor, int monitoringLevel) {
        super(input, inputObjectName, args, monitor, monitoringLevel);
    }

    /**
     * This constructor sets the monitoring level to the default of 1.
     */
    public PgDumpLoader(InputStream input, String inputObjectName,
            PgDiffArguments args, IProgressMonitor monitor) {
        super(input, inputObjectName, args, monitor, 1);
    }

    /**
     * This constructor uses {@link NullProgressMonitor}.
     */
    public PgDumpLoader(InputStream input, String inputObjectName,
            PgDiffArguments args) {
        super(input, inputObjectName, args, new NullProgressMonitor(), 0);
    }

    /**
     * Loads database schema from a ModelExporter directory tree. The root
     * directory must contain a listing.lst file for ordered list of files.
     *
     * @param dirPath path to the directory tree root
     *
     * @return database schema
     * @throws InterruptedException
     */
    public static PgDatabase loadDatabaseSchemaFromIProject(IProject iProject,
            PgDiffArguments arguments, IProgressMonitor monitor, int monLvl,
            List<FunctionBodyContainer> funcBodies)
            throws InterruptedException, IOException, LicenseException, CoreException {
        PgDatabase db = new PgDatabase();
        db.setArguments(arguments);
        List<IFolder> folders = new ArrayList<>();
        for (ApgdiffConsts.WORK_DIR_NAMES workDirName : ApgdiffConsts.WORK_DIR_NAMES.values()) {
            IFolder iFolder = iProject.getFolder(workDirName.toString());
            if (iFolder.exists()) {
                folders.add(iFolder);
            }
        }
        loadSubdirs(arguments, folders, db, monitor, monLvl, funcBodies);

        IResource schemasCommonDir = iProject.findMember(ApgdiffConsts.WORK_DIR_NAMES.SCHEMA.name());
        // skip walking SCHEMA folder if it does not exist
        if (schemasCommonDir == null && schemasCommonDir instanceof IFolder) {
            return db;
        }

        // step 2
        // read out schemas names, and work in loop on each
        IFolder schemaFolder;
        for (PgSchema schema : db.getSchemas()) {
            schemaFolder = ((IFolder) schemasCommonDir).getFolder(ModelExporter.getExportedFilename(schema));
            if (schemaFolder != null) {
                folders.clear();
                for (String dirLoadOrder : DIR_LOAD_ORDER) {
                    IFolder iFolder = schemaFolder.getFolder(dirLoadOrder);
                    if (iFolder.exists()) {
                        folders.add(iFolder);
                    }
                }
                loadSubdirs(arguments, folders, db, monitor, monLvl, funcBodies);
            }
        }
        arguments.getLicense().verifyDb(db);
        return db;
    }

    private static void loadSubdirs(PgDiffArguments arguments,
            List<IFolder> folders, PgDatabase db, IProgressMonitor monitor, int monLvl,
            List<FunctionBodyContainer> funcBodies) throws InterruptedException, IOException, CoreException {

        for (IFolder iFolder : folders) {
            IResource[] iResources = iFolder.members();
            for (IResource iResource : iResources){
                if (iResource instanceof IFile && "sql".equals(iResource.getFileExtension())) {
                    ((IFile) iResource).deleteMarkers(UIConsts.MARKER.ERROR, false, IResource.DEPTH_ZERO);
                    try (PgDumpLoader loader = new PgDumpLoader(((IFile)iResource).getContents(), iResource.getLocation().toOSString(), arguments, monitor, monLvl)){
                        loader.load(funcBodies != null, db);

                        for (AntlrError antlrError : loader.getErrors()) {
                            IMarker marker = ((IFile) iResource).createMarker(UIConsts.MARKER.ERROR);
                            marker.setAttribute(IMarker.LINE_NUMBER, antlrError.getLine());
                            marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
                            marker.setAttribute(IMarker.MESSAGE, antlrError.getMsg());
                            marker.setAttribute(IMarker.CHAR_START, antlrError.getStart());
                            marker.setAttribute(IMarker.CHAR_END, antlrError.getStop() + 1);
                            marker.setAttribute(IMarker.TEXT, antlrError.getText());
                        }
                        if (funcBodies != null) {
                            funcBodies.addAll(loader.getFuncBodyReferences());
                        }
                    }
                }
            }
        }
    }
}
