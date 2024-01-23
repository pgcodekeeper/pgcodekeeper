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
package ru.taximaxim.codekeeper.ui.pgdbproject.parser;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

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
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ide.ResourceUtil;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.Consts.MS_WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.core.Consts.WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.DatabaseLoader;
import ru.taximaxim.codekeeper.core.loader.FullAnalyze;
import ru.taximaxim.codekeeper.core.loader.LibraryLoader;
import ru.taximaxim.codekeeper.core.loader.ProjectLoader;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreSchemaList;
import ru.taximaxim.codekeeper.core.model.exporter.AbstractModelExporter;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrError;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.xmlstore.DependenciesXmlStore;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class UIProjectLoader extends ProjectLoader {

    private static final String SQL_EXTENSION = "sql"; // $NON-NLS-1$

    private final IProject iProject;
    private final boolean projectOnly;

    public UIProjectLoader(IProject iProject, PgDiffArguments arguments, IProgressMonitor monitor) {
        this(iProject, arguments, monitor, null, false);
    }

    public UIProjectLoader(IProject iProject, PgDiffArguments arguments, IProgressMonitor monitor,
            IgnoreSchemaList ignoreSchemaList, boolean projectOnly) {
        super(null, arguments, monitor, new ArrayList<>(), ignoreSchemaList);
        this.iProject = iProject;
        this.projectOnly = projectOnly;
    }

    @Override
    public PgDatabase loadAndAnalyze() throws IOException, InterruptedException {
        PgDatabase d = load();
        List<Object> analyzeErrors = new ArrayList<>();
        FullAnalyze.fullAnalyze(d, analyzeErrors);
        markErrors(analyzeErrors);
        errors.addAll(analyzeErrors);
        return d;
    }

    @Override
    public PgDatabase load() throws InterruptedException, IOException {
        try {
            return loadDatabaseWithLibraries();
        } catch (CoreException e) {
            throw new IOException(Messages.UIProjectLoader_error_loading_structure, e);
        }
    }

    static void markErrors(List<Object> errors) {
        for (Object error : errors) {
            if (error instanceof AntlrError) {
                AntlrError antlrError = (AntlrError) error;
                IFile file = FileUtilsUi.getFileForLocation(antlrError);
                if (file != null) {
                    PgUIDumpLoader.addMarker(file, antlrError);
                }
            }
        }
    }

    private void loadPgStructure(IContainer baseDir, PgDatabase db)
            throws InterruptedException, CoreException {
        if (!baseDir.exists()) {
            return;
        }

        for (WORK_DIR_NAMES workDirName : WORK_DIR_NAMES.values()) {
            // legacy schemas
            loadSubdir(baseDir.getFolder(new Path(workDirName.name())), db, this::checkIgnoreSchemaList) ;
        }

        IFolder schemasCommonDir = baseDir.getFolder(new Path(WORK_DIR_NAMES.SCHEMA.name()));
        // skip walking SCHEMA folder if it does not exist
        if (schemasCommonDir.exists()) {
            // new schemas + content
            // step 2
            // read out schemas names, and work in loop on each
            for (IResource sub : schemasCommonDir.members()) {
                if (sub.getType() == IResource.FOLDER) {
                    IFolder schemaDir = (IFolder) sub;
                    if (checkIgnoreSchemaList(schemaDir.getName())) {
                        loadSubdir(schemaDir, db);
                        for (DbObjType dirSub : DIR_LOAD_ORDER) {
                            loadSubdir(schemaDir.getFolder(dirSub.name()), db);
                        }
                    }
                }
            }
        }
    }

    private void loadMsStructure(IContainer baseDir, PgDatabase db)
            throws InterruptedException, IOException, CoreException {
        if (!baseDir.exists()) {
            return;
        }

        IFolder securityFolder = baseDir.getFolder(new Path(MS_WORK_DIR_NAMES.SECURITY.getDirName()));

        loadSubdir(securityFolder.getFolder(MS_SCHEMAS_FOLDER), db, this::checkIgnoreSchemaList);
        // DBO schema check requires schema loads to finish first
        AntlrParser.finishAntlr(antlrTasks);
        addDboSchema(db);

        loadSubdir(securityFolder.getFolder(MS_ROLES_FOLDER), db);
        loadSubdir(securityFolder.getFolder(MS_USERS_FOLDER), db);

        for (MS_WORK_DIR_NAMES dirSub : MS_WORK_DIR_NAMES.values()) {
            if (dirSub.isInSchema()) {
                loadSubdir(baseDir.getFolder(new Path(dirSub.getDirName())), db,
                        msFileName -> checkIgnoreSchemaList(msFileName.substring(0, msFileName.indexOf('.'))));
            } else {
                loadSubdir(baseDir.getFolder(new Path(dirSub.getDirName())), db);
            }
        }
    }

    private void loadSubdir(IFolder folder, PgDatabase db)
            throws InterruptedException, CoreException {
        loadSubdir(folder, db, null);
    }

    /**
     * @param checkFilename filter for file names without extensions. Can be null.
     */
    private void loadSubdir(IFolder folder, PgDatabase db, Predicate<String> checkFilename)
            throws InterruptedException, CoreException {
        if (!folder.exists()) {
            return;
        }
        filterFile(folder.members(), monitor, db, f -> checkFilename == null ||
                checkFilename.test(f.getName().substring(0, f.getName().length() - 4)));
    }

    /**
     * @param checkFile additional filter for loaded sql files
     */
    private void filterFile(IResource[] iResources, IProgressMonitor monitor, PgDatabase db,  Predicate<IResource> checkFile)
            throws CoreException, InterruptedException {

        Stream<IResource> streamR = Arrays.stream(iResources)
                .filter(r -> r.getType() == IResource.FILE && SQL_EXTENSION.equals(r.getFileExtension()))
                .filter(checkFile);

        for (IResource resource : PgDiffUtils.sIter(streamR)) {
            loadFile((IFile) resource, monitor, db);
        }
    }

    private void loadFile(IFile file, IProgressMonitor monitor, PgDatabase db)
            throws CoreException, InterruptedException {
        PgDiffArguments arguments = db.getArguments().copy();
        arguments.setInCharsetName(file.getCharset());

        PgUIDumpLoader loader = new PgUIDumpLoader(file, arguments, monitor);
        if (isOverrideMode) {
            loader.setOverridesMap(overrides);
        }
        loader.loadDatabase(db, antlrTasks);
        launchedLoaders.add(loader);
    }

    private PgDatabase buildMsFiles(Collection<IFile> files, SubMonitor mon)
            throws InterruptedException, IOException, CoreException {
        PgDiffArguments args = new PgDiffArguments();
        args.setDbType(DatabaseType.MS);
        PgDatabase db = new PgDatabase(args);

        IPath schemasPath = new Path(MS_WORK_DIR_NAMES.SECURITY.getDirName()).append(MS_SCHEMAS_FOLDER);
        Set<String> schemaFiles = new HashSet<>();
        boolean isLoaded = false;
        for (IFile file : files) {
            IPath filePath = file.getProjectRelativePath();
            if (!SQL_EXTENSION.equals(file.getFileExtension()) || !isInMsProject(filePath)) {
                // skip non-sql or non-project files
                // still report work
                mon.worked(1);
                continue;
            }

            if (!isLoaded) {
                // load all schemas, because we don't know in which schema the object
                IProject proj = file.getProject();
                loadSubdir(proj.getFolder(schemasPath), db);
                // DBO schema check requires schema loads to finish first
                AntlrParser.finishAntlr(antlrTasks);
                addDboSchema(db);
                isLoaded = true;
            }

            if (schemasPath.isPrefixOf(filePath)) {
                schemaFiles.add(filePath.removeFileExtension().lastSegment());
            } else {
                loadFile(file, mon, db);
            }
        }
        AntlrParser.finishAntlr(antlrTasks);

        PgDatabase newDb = new PgDatabase(args);

        // exclude empty schemas (except loaded from schema files) that have been loaded early
        db.getSchemas().stream()
        .filter(sc -> schemaFiles.contains(AbstractModelExporter.getExportedFilename(sc)) || sc.hasChildren())
        .forEach(st -> newDb.addChild(st.deepCopy()));

        db.getAssemblies().forEach(st -> newDb.addChild(st.deepCopy()));
        db.getRoles().forEach(st -> newDb.addChild(st.deepCopy()));
        db.getUsers().forEach(st -> newDb.addChild(st.deepCopy()));
        newDb.getObjReferences().putAll(db.getObjReferences());
        newDb.copyLaunchers(db);
        return newDb;
    }

    private PgDatabase buildPgFiles(Collection<IFile> files, SubMonitor mon)
            throws InterruptedException, CoreException {
        Set<String> schemaDirnamesLoaded = new HashSet<>();
        IPath schemasPath = new Path(WORK_DIR_NAMES.SCHEMA.name());
        PgDatabase db = new PgDatabase(new PgDiffArguments());

        for (IFile file : files) {
            IPath filePath = file.getProjectRelativePath();
            if (!SQL_EXTENSION.equals(file.getFileExtension()) || !isInProject(filePath)) {
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

    private PgDatabase loadDatabaseWithLibraries()
            throws InterruptedException, IOException, CoreException {
        PgDatabase db = new PgDatabase(arguments);
        loadDbStructure(iProject,  db);

        if (!projectOnly) {
            loadLibraries(db, arguments);
        }

        if (!arguments.isIgnorePrivileges() && !projectOnly) {
            isOverrideMode = true;
            // read overrides from special folder
            IFolder privs = iProject.getFolder(Consts.OVERRIDES_DIR);
            try {
                loadDbStructure(privs, db);
                replaceOverrides();
            } finally {
                isOverrideMode = false;
            }
        }
        finishLoaders();

        return db;
    }

    private void loadDbStructure(IContainer dir, PgDatabase db) throws InterruptedException, IOException, CoreException {
        switch (arguments.getDbType()) {
        case PG:
            loadPgStructure(dir, db);
            break;
        case MS:
            loadMsStructure(dir, db);
            break;
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + arguments.getDbType());
        }
        AntlrParser.finishAntlr(antlrTasks);
    }

    private void loadLibraries(PgDatabase db, PgDiffArguments arguments) throws InterruptedException, IOException {
        LibraryLoader ll = new LibraryLoader(db,
                Paths.get(Platform.getStateLocation(Activator.getContext().getBundle())
                        .append("dependencies").toString()), errors); //$NON-NLS-1$
        ll.loadXml(new DependenciesXmlStore(Paths.get(iProject.getLocation()
                .append(DependenciesXmlStore.FILE_NAME).toString())), arguments);
    }

    @Override
    protected void finishLoader(DatabaseLoader l) {
        super.finishLoader(l);
        PgUIDumpLoader loader = (PgUIDumpLoader) l;
        loader.updateMarkers();
    }

    public static PgDatabase buildFiles(Collection<IFile> files,  DatabaseType dbType, IProgressMonitor monitor)
            throws InterruptedException, IOException, CoreException {
        UIProjectLoader loader = new UIProjectLoader(null, null, monitor);
        SubMonitor mon = SubMonitor.convert(monitor, files.size());
        PgDatabase db;
        switch (dbType) {
        case PG:
            db = loader.buildPgFiles(files, mon);
            break;
        case MS:
            db = loader.buildMsFiles(files, mon);
            break;
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
        }
        loader.finishLoaders();
        return db;
    }

    public static PgStatement parseStatement(IFile file, Collection<DbObjType> types)
            throws InterruptedException, IOException, CoreException {
        return buildFiles(Arrays.asList(file), DatabaseType.PG, new NullProgressMonitor())
                .getDescendants()
                .filter(e -> types.contains(e.getStatementType()))
                .findAny().orElse(null);
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
        return dir != null && Arrays.stream(Consts.WORK_DIR_NAMES.values())
                .map(Enum::name).anyMatch(dir::equals);
    }

    private static boolean isInMsProject(IPath path) {
        String dir = path.segment(0);
        return dir != null && Arrays.stream(Consts.MS_WORK_DIR_NAMES.values())
                .map(MS_WORK_DIR_NAMES::getDirName).anyMatch(dir::equals);
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

    public static boolean isInProject(IResourceDelta delta, DatabaseType dbType) {
        switch (dbType) {
        case PG:
            return isInProject(delta.getProjectRelativePath());
        case MS:
            return isInMsProject(delta.getProjectRelativePath());
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
        }
    }

    public static boolean isPrivilegeFolder(IResourceDelta delta) {
        return Consts.OVERRIDES_DIR.equals(delta.getProjectRelativePath().segment(0));
    }

    public static boolean isInProject(IEditorInput editorInput) {
        IResource res = ResourceUtil.getResource(editorInput);
        return res != null && isInProject(res);
    }

    /**
     * @param path project relative path
     * @param isMsSql is MS project
     * @return whether the path corresponds to a schema sql file
     */
    public static boolean isSchemaFile(IPath path, DatabaseType dbType) {
        switch (dbType) {
        case PG:
            return isPgSchemaFile(path);
        case MS:
            return isMsSchemaFile(path);
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
        }
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
                && path.segment(0).equals(MS_WORK_DIR_NAMES.SECURITY.getDirName())
                && MS_SCHEMAS_FOLDER.equals(path.segment(1))
                && path.segment(2).endsWith(".sql"); //$NON-NLS-1$
    }
}
