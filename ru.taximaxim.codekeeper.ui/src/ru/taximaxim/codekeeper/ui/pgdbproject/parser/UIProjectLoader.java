package ru.taximaxim.codekeeper.ui.pgdbproject.parser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ide.ResourceUtil;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.FullAnalyze;
import cz.startnet.utils.pgdiff.loader.ProjectLoader;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.StatementBodyContainer;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.MS_WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.AbstractModelExporter;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.properties.PgLibrary;

public class UIProjectLoader extends ProjectLoader {

    private final IProject iProject;
    private final List<StatementBodyContainer> statementBodies;

    public UIProjectLoader(IProgressMonitor monitor, List<StatementBodyContainer> statementBodies) {
        this(null, null, monitor, statementBodies, null);
    }

    public UIProjectLoader(IProject iProject, PgDiffArguments arguments, IProgressMonitor monitor,
            List<StatementBodyContainer> statementBodies, List<AntlrError> errors) {
        super(null, arguments, monitor, errors);
        this.iProject = iProject;
        this.statementBodies = statementBodies;
    }

    /**
     * Loads database schema from a ModelExporter directory tree.
     *
     * @return database schema
     */
    public PgDatabase loadDatabaseSchemaFromPgProject()
            throws InterruptedException, IOException, CoreException {
        PgDatabase db = new PgDatabase();
        db.setArguments(arguments);
        for (WORK_DIR_NAMES workDirName : WORK_DIR_NAMES.values()) {
            // legacy schemas
            loadSubdir(iProject.getFolder(workDirName.name()), db);
        }

        IFolder schemasCommonDir = iProject.getFolder(WORK_DIR_NAMES.SCHEMA.name());
        // skip walking SCHEMA folder if it does not exist
        if (!schemasCommonDir.exists()) {
            return db;
        }

        // new schemas + content
        // step 2
        // read out schemas names, and work in loop on each
        for (IResource sub : schemasCommonDir.members()) {
            if (sub.getType() == IResource.FOLDER) {
                IFolder schemaDir = (IFolder) sub;
                loadSubdir(schemaDir, db);
                for (String dirSub : DIR_LOAD_ORDER) {
                    loadSubdir(schemaDir.getFolder(dirSub), db);
                }
            }
        }
        FullAnalyze.fullAnalyze(db, errors);
        return db;
    }

    /**
     * Loads database schema from a MsModelExporter directory tree.
     *
     * @return database schema
     */
    public PgDatabase loadDatabaseSchemaFromMsProject() throws InterruptedException, IOException, CoreException {
        PgDatabase db = new PgDatabase();
        db.setArguments(arguments);

        IFolder securityFolder = iProject.getFolder("Security"); //$NON-NLS-1$
        loadSubdir(securityFolder.getFolder("Schemas"), db); //$NON-NLS-1$
        // TODO users, roles
        addDboSchema(db);

        // content
        for (String dirSub : MS_DIR_LOAD_ORDER) {
            loadSubdir(iProject.getFolder(dirSub), db);
        }

        return db;
    }

    private void loadSubdir(IFolder folder, PgDatabase db) throws InterruptedException, IOException, CoreException {
        if (!folder.exists()) {
            return;
        }
        for (IResource resource : folder.members()) {
            if (resource.getType() == IResource.FILE && "sql".equals(resource.getFileExtension())) { //$NON-NLS-1$
                loadFile((IFile) resource, monitor, db);
            }
        }
    }

    private void loadFile(IFile file, IProgressMonitor monitor, PgDatabase db)
            throws IOException, CoreException, InterruptedException {
        PgDiffArguments arguments = db.getArguments().clone();
        arguments.setInCharsetName(file.getCharset());

        List<AntlrError> errList = null;
        try (PgUIDumpLoader loader = new PgUIDumpLoader(file, arguments, monitor)) {
            errList = loader.getErrors();
            loader.setLoadReferences(statementBodies != null);
            loader.loadFile(db);
            if (statementBodies != null) {
                statementBodies.addAll(loader.getStatementBodyReferences());
            }
        } finally {
            if (errors != null && errList != null && !errList.isEmpty()) {
                errors.addAll(errList);
            }
        }
    }

    public PgDatabase buildFiles(Collection<IFile> files, boolean isMsSql)
            throws InterruptedException, IOException, CoreException {
        SubMonitor mon = SubMonitor.convert(monitor, files.size());
        return isMsSql ? buildMsFiles(files, mon) :
            buildPgFiles(files, mon);
    }

    private PgDatabase buildMsFiles(Collection<IFile> files, SubMonitor mon)
            throws InterruptedException, IOException, CoreException {
        PgDatabase db = new PgDatabase();
        PgDiffArguments args = new PgDiffArguments();
        Set<String> schemaFiles = new HashSet<>();
        args.setMsSql(true);
        db.setArguments(args);

        IPath schemasPath = new Path(MS_WORK_DIR_NAMES.SECURITY.getName()).append("Schemas"); //$NON-NLS-1$
        boolean isLoaded = false;
        for (IFile file : files) {
            IPath filePath = file.getProjectRelativePath();
            if (!"sql".equals(file.getFileExtension()) || !isInMsProject(filePath)) { //$NON-NLS-1$
                // skip non-sql or non-project files
                // still report work
                mon.worked(1);
                continue;
            }

            if (!isLoaded) {
                // load all schemas, because we don't know in which schema the object
                IProject proj = file.getProject();
                loadSubdir(proj.getFolder(schemasPath), db);
                addDboSchema(db);
                isLoaded = true;
            }

            if (schemasPath.isPrefixOf(filePath)) {
                schemaFiles.add(filePath.removeFileExtension().lastSegment());
            } else {
                loadFile(file, mon, db);
            }
        }

        PgDatabase newDb = new PgDatabase();
        newDb.setArguments(args);

        // exclude empty schemas (except loaded from schema files) that have been loaded early
        db.getSchemas().stream()
        .filter(sc -> schemaFiles.contains(AbstractModelExporter.getExportedFilename(sc))
                || sc.hasChildren())
        .forEach(st -> {
            st.dropParent();
            newDb.addSchema(st);
        });

        return newDb;
    }

    private PgDatabase buildPgFiles(Collection<IFile> files, SubMonitor mon)
            throws InterruptedException, IOException, CoreException {
        Set<String> schemaDirnamesLoaded = new HashSet<>();
        IPath schemasPath = new Path(WORK_DIR_NAMES.SCHEMA.name());
        PgDatabase db = new PgDatabase();
        db.setArguments(new PgDiffArguments());

        for (IFile file : files) {
            IPath filePath = file.getProjectRelativePath();
            if (!"sql".equals(file.getFileExtension()) || !isInProject(filePath)) { //$NON-NLS-1$
                // skip non-sql or non-project files
                // still report work
                mon.worked(1);
                continue;
            }

            if (schemasPath.isPrefixOf(filePath)) {
                IPath relSchemasPath = filePath.makeRelativeTo(schemasPath);
                String schemaDirname;
                // 1 = [SCHEMA/]x.sql, legacy
                // 2 = [SCHEMA/]x/x.sql, new schema location
                boolean schemaDefSql = relSchemasPath.segmentCount() <= 2;
                if (schemaDefSql) {
                    // schema definition SQL-file
                    schemaDirname = relSchemasPath.removeFileExtension().lastSegment();
                } else {
                    // schema-contained object
                    // preload its schema so that search_path parses normally
                    schemaDirname = relSchemasPath.segment(0);
                }
                if (!schemaDirnamesLoaded.add(schemaDirname)) {
                    // schema already loaded, skip
                    if (schemaDefSql) {
                        // report schema pre-built if the same schema was to be built normally as well
                        mon.worked(1);
                        continue;
                    }
                } else if (!schemaDefSql) {
                    // pre-load schema for object's search path
                    // otherwise we're dealing with the schema file itself, allow it to load normally
                    // don't pass progress monitor since this file isn't in the original load-set
                    String schemaFilename = schemaDirname + ".sql"; //$NON-NLS-1$
                    IProject proj = file.getProject();
                    IPath schemaPath = schemasPath.append(schemaDirname).append(schemaFilename);
                    if (!proj.exists(schemaPath)) {
                        // new schema location not found, use legacy
                        schemaPath = schemasPath.append(schemaFilename);
                    }

                    loadFile(proj.getFile(schemaPath), null, db);
                }
            }

            loadFile(file, mon, db);
        }
        return db;
    }

    public static PgStatement parseStatement(IFile file, Collection<DbObjType> types)
            throws InterruptedException, IOException, CoreException {
        return new UIProjectLoader(new NullProgressMonitor(), null)
                .buildFiles(Arrays.asList(file), false).getDescendants()
                .filter(e -> types.contains(e.getStatementType())).findAny().orElse(null);
    }

    public static void loadLibraries(PgDatabase db, PgDiffArguments arguments,
            Collection<PgLibrary> libs) throws InterruptedException, IOException, URISyntaxException {
        for (PgLibrary lib : libs) {
            loadLibrary(db, arguments, lib.isIgnorePriv(), lib.getPath());
        }
    }

    public static int countFiles(IContainer container) throws CoreException {
        int[] count = new int[1];
        container.accept(p -> {
            if (p.getType() == IResource.FILE) {
                ++count[0];
            }
            return true;
        }, 0);
        return count[0];
    }

    /**
     * @param path project relative path of checked resource
     * @return whether this resource is within the main database schema hierarchy
     */
    private static boolean isInProject(IPath path) {
        String dir = path.segment(0);
        return dir == null ? false : Arrays.stream(ApgdiffConsts.WORK_DIR_NAMES.values())
                .map(Enum::name).anyMatch(dir::equals);
    }

    private static boolean isInMsProject(IPath path) {
        String dir = path.segment(0);
        return dir == null ? false : Arrays.stream(ApgdiffConsts.MS_WORK_DIR_NAMES.values())
                .map(MS_WORK_DIR_NAMES::getName).anyMatch(dir::equals);
    }

    public static boolean isInProject(IResource resource) {
        try {
            IProject project = resource.getProject();
            if (!project.hasNature(NATURE.ID)) {
                return false;
            }

            if (project.hasNature(NATURE.MS)) {
                return isInMsProject(resource.getProjectRelativePath());
            }

            return isInProject(resource.getProjectRelativePath());
        } catch (CoreException ex) {
            Log.log(ex);
            return false;
        }
    }

    public static boolean isInProject(IResourceDelta delta, boolean isMsSql) {
        if (isMsSql) {
            return isInMsProject(delta.getProjectRelativePath());
        }
        return isInProject(delta.getProjectRelativePath());
    }

    public static boolean isInProject(IEditorInput editorInput) {
        IResource res = ResourceUtil.getResource(editorInput);
        return res == null ? false : isInProject(res);
    }

    /**
     * @param path project relative path
     * @param is MS project
     * @return whether the path corresponds to a schema sql file
     */
    public static boolean isSchemaFile(IPath path, boolean isMsSql) {
        return isMsSql ? isMsSchemaFile(path) : isPgSchemaFile(path);
    }

    /**
     * @param path project relative path
     * @return whether the path corresponds to a schema sql file
     *     like this: /SCHEMA/schema_name.sql or /SCHEMA/schema_name/schema_name.sql
     */
    private static boolean isPgSchemaFile(IPath path) {
        int c = path.segmentCount();
        return (c == 2 || c == 3) // legacy or new schemas
                && path.segment(0).equals(WORK_DIR_NAMES.SCHEMA.name())
                && path.segment(c - 1).endsWith(".sql"); //$NON-NLS-1$
    }

    /**
     * @param path project relative path
     * @return whether the path corresponds to a schema sql file
     *          like this: /Security/Schemas/schema_name.sql
     */
    private static boolean isMsSchemaFile(IPath path) {
        return path.segmentCount() == 3
                && path.segment(0).equals(MS_WORK_DIR_NAMES.SECURITY.getName())
                && "Schemas".equals(path.segment(1)) //$NON-NLS-1$
                && path.segment(2).endsWith(".sql"); //$NON-NLS-1$
    }
}
