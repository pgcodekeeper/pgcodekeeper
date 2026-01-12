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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubMonitor;
import org.pgcodekeeper.core.DatabaseType;
import org.pgcodekeeper.core.Utils;
import org.pgcodekeeper.core.WorkDirs;
import org.pgcodekeeper.core.ignorelist.IgnoreSchemaList;
import org.pgcodekeeper.core.loader.DatabaseLoader;
import org.pgcodekeeper.core.loader.FullAnalyze;
import org.pgcodekeeper.core.loader.LibraryLoader;
import org.pgcodekeeper.core.loader.ProjectLoader;
import org.pgcodekeeper.core.model.difftree.DbObjType;
import org.pgcodekeeper.core.model.exporter.ModelExporter;
import org.pgcodekeeper.core.monitor.IMonitor;
import org.pgcodekeeper.core.parsers.antlr.base.AntlrError;
import org.pgcodekeeper.core.parsers.antlr.base.AntlrTaskManager;
import org.pgcodekeeper.core.schema.AbstractDatabase;
import org.pgcodekeeper.core.schema.PgStatement;
import org.pgcodekeeper.core.schema.ms.MsDatabase;
import org.pgcodekeeper.core.settings.ISettings;
import org.pgcodekeeper.core.xmlstore.DependenciesXmlStore;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.properties.UISettings;
import ru.taximaxim.codekeeper.ui.utils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.utils.ProjectUtils;
import ru.taximaxim.codekeeper.ui.utils.UIMonitor;

public final class UIProjectLoader extends ProjectLoader {

    private static final String SQL_EXTENSION = "sql"; // $NON-NLS-1$

    private final IProject iProject;
    private final boolean projectOnly;

    public UIProjectLoader(IProject iProject, UISettings settings, IProgressMonitor monitor) {
        this(iProject, settings, monitor, null, false);
    }

    public UIProjectLoader(IProject iProject, UISettings settings, IProgressMonitor monitor,
            IgnoreSchemaList ignoreSchemaList, boolean projectOnly) {
        super(null, settings, new UIMonitor(monitor), new ArrayList<>(), ignoreSchemaList);
        this.iProject = iProject;
        this.projectOnly = projectOnly;
    }

    @Override
    public AbstractDatabase loadAndAnalyze() throws IOException, InterruptedException {
        AbstractDatabase d = load();
        List<Object> analyzeErrors = new ArrayList<>();
        FullAnalyze.fullAnalyze(d, analyzeErrors);
        markErrors(analyzeErrors);
        errors.addAll(analyzeErrors);
        return d;
    }

    @Override
    public AbstractDatabase load() throws InterruptedException, IOException {
        try {
            return loadDatabaseWithLibraries();
        } catch (CoreException e) {
            throw new IOException(Messages.UIProjectLoader_error_loading_structure, e);
        }
    }

    static void markErrors(List<Object> errors) {
        for (Object error : errors) {
            if (error instanceof AntlrError antlrError) {
                IFile file = FileUtilsUi.getFileForLocation(antlrError);
                if (file != null) {
                    PgUIDumpLoader.addMarker(file, antlrError);
                }
            }
        }
    }

    private void loadChStructure(IContainer baseDir, AbstractDatabase db) throws InterruptedException, CoreException {
        for (String dir : WorkDirs.getDirectoryNames(DatabaseType.CH)) {
            if (WorkDirs.CH_DATABASE.equals(dir)) {
                loadPgChStructure(baseDir, db, dir);
            } else {
                loadSubdir(baseDir.getFolder(new Path(dir)), db);
            }
        }
    }

    private void loadPgStructure(IContainer baseDir, AbstractDatabase db) throws InterruptedException, CoreException {
        for (String dir : WorkDirs.getDirectoryNames(DatabaseType.PG)) {
            if (WorkDirs.PG_SCHEMA.equals(dir)) {
                loadPgChStructure(baseDir, db, dir);
            } else {
                loadSubdir(baseDir.getFolder(new Path(dir)), db);
            }
        }
    }

    private void loadPgChStructure(IContainer baseDir, AbstractDatabase db, String commonDir)
            throws CoreException, InterruptedException {
        IFolder schemasCommonDir = baseDir.getFolder(new Path(commonDir));

        // skip walking SCHEMA folder if it does not exist
        if (!schemasCommonDir.exists()) {
            return;
        }

        // new schemas + content
        // step 2
        // read out schemas names, and work in loop on each
        for (IResource sub : schemasCommonDir.members()) {
            if (sub.getType() != IResource.FOLDER) {
                continue;
            }
            IFolder schemaDir = (IFolder) sub;
            if (isAllowedSchema(schemaDir.getName())) {
                loadSubdir(schemaDir, db);
                for (DbObjType dirSub : WorkDirs.getDirLoadOrder()) {
                    loadSubdir(schemaDir.getFolder(dirSub.name()), db);
                }
            }
        }
    }

    private void loadMsStructure(IContainer baseDir, AbstractDatabase db)
            throws InterruptedException, IOException, CoreException {
        IFolder securityFolder = baseDir.getFolder(new Path(WorkDirs.MS_SECURITY));

        loadSubdir(securityFolder.getFolder(WorkDirs.MS_SCHEMAS), db, this::isAllowedSchema);
        // DBO schema check requires schema loads to finish first
        AntlrTaskManager.finish(antlrTasks);
        addDboSchema(db);

        loadSubdir(securityFolder.getFolder(WorkDirs.MS_ROLES), db);
        loadSubdir(securityFolder.getFolder(WorkDirs.MS_USERS), db);

        for (String dirSub : WorkDirs.getDirectoryNames(DatabaseType.MS)) {
            if (WorkDirs.isInMsSchema(dirSub)) {
                loadSubdir(baseDir.getFolder(new Path(dirSub)), db, this::isAllowedSchema);
                continue;
            }
            loadSubdir(baseDir.getFolder(new Path(dirSub)), db);
        }
    }

    private void loadSubdir(IFolder folder, AbstractDatabase db)
            throws InterruptedException, CoreException {
        loadSubdir(folder, db, null);
    }

    /**
     * @param checkFilename filter for file names without extensions. Can be null.
     */
    private void loadSubdir(IFolder folder, AbstractDatabase db, Predicate<String> checkFilename)
            throws InterruptedException, CoreException {
        if (!folder.exists()) {
            return;
        }
        filterFile(folder.members(), monitor, db, f -> checkFilename == null || checkFilename.test(f.getName()));
    }

    /**
     * @param checkFile additional filter for loaded sql files
     */
    private void filterFile(IResource[] iResources, IMonitor monitor, AbstractDatabase db,
            Predicate<IResource> checkFile)
                    throws CoreException, InterruptedException {

        Stream<IResource> streamR = Arrays.stream(iResources)
                .filter(r -> r.getType() == IResource.FILE && SQL_EXTENSION.equals(r.getFileExtension()))
                .filter(checkFile);

        for (IResource resource : Utils.streamIterator(streamR)) {
            loadFile((IFile) resource, monitor, db);
        }
    }

    private void loadFile(IFile file, IMonitor monitor, AbstractDatabase db)
            throws CoreException, InterruptedException {
        UISettings copySettings = (UISettings) settings.copy();
        copySettings.setCharsetName(file.getCharset());

        PgUIDumpLoader loader = new PgUIDumpLoader(file, copySettings, monitor);
        if (isOverrideMode) {
            loader.setOverridesMap(overrides);
        }
        loader.loadDatabase(db, antlrTasks);
        launchedLoaders.add(loader);
    }

    private AbstractDatabase buildMsFiles(Collection<IFile> files, SubMonitor mon)
            throws InterruptedException, IOException, CoreException {
        MsDatabase db = (MsDatabase) createDb(settings);

        IPath schemasPath = new Path(WorkDirs.MS_SECURITY).append(WorkDirs.MS_SCHEMAS);
        Set<String> schemaFiles = new HashSet<>();
        boolean isLoaded = false;
        for (IFile file : files) {
            IPath filePath = file.getProjectRelativePath();
            if (!SQL_EXTENSION.equals(file.getFileExtension())
                    || !ProjectUtils.isInProject(filePath, DatabaseType.MS)) {
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
                AntlrTaskManager.finish(antlrTasks);
                addDboSchema(db);
                isLoaded = true;
            }

            if (schemasPath.isPrefixOf(filePath)) {
                schemaFiles.add(filePath.removeFileExtension().lastSegment());
            } else {
                loadFile(file, new UIMonitor(mon), db);
            }
        }
        AntlrTaskManager.finish(antlrTasks);

        AbstractDatabase newDb = createDb(settings);

        // exclude empty schemas (except loaded from schema files) that have been loaded early
        db.getSchemas().stream()
        .filter(sc -> schemaFiles.contains(ModelExporter.getExportedFilename(sc)) || sc.hasChildren())
        .forEach(st -> newDb.addChild(st.deepCopy()));

        db.getAssemblies().forEach(st -> newDb.addChild(st.deepCopy()));
        db.getRoles().forEach(st -> newDb.addChild(st.deepCopy()));
        db.getUsers().forEach(st -> newDb.addChild(st.deepCopy()));
        newDb.getObjReferences().putAll(db.getObjReferences());
        newDb.copyLaunchers(db);
        return newDb;
    }

    private AbstractDatabase buildPgChFiles(Collection<IFile> files, SubMonitor mon, String schemasDir)
            throws InterruptedException, CoreException {
        Set<String> schemaDirnamesLoaded = new HashSet<>();
        IPath schemasPath = new Path(schemasDir);
        AbstractDatabase db = createDb(settings);

        for (IFile file : files) {
            IPath filePath = file.getProjectRelativePath();
            if (!SQL_EXTENSION.equals(file.getFileExtension()) || !ProjectUtils.isInProject(filePath, settings.getDbType())) {
                // skip non-sql or non-project files
                // still report work
                mon.worked(1);
                continue;
            }

            if (schemasPath.isPrefixOf(filePath)) {
                IPath relSchemasPath = filePath.makeRelativeTo(schemasPath);
                String schemaDirname;
                // 2 = [SCHEMA/]x/x.sql
                boolean schemaDefSql = relSchemasPath.segmentCount() == 2;
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
                    loadFile(proj.getFile(schemaPath), null, db);
                }
            }

            loadFile(file, new UIMonitor(mon), db);
        }
        return db;
    }

    private AbstractDatabase loadDatabaseWithLibraries()
            throws InterruptedException, IOException, CoreException {
        AbstractDatabase db = createDb(settings);
        loadDbStructure(iProject,  db);

        if (!projectOnly) {
            loadLibraries(db, settings);
        }

        if (!settings.isIgnorePrivileges() && !projectOnly) {
            isOverrideMode = true;
            // read overrides from special folder
            IFolder privs = iProject.getFolder(WorkDirs.OVERRIDES);
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

    private void loadDbStructure(IContainer dir, AbstractDatabase db)
            throws InterruptedException, IOException, CoreException {
        if (dir.exists()) {
            switch (settings.getDbType()) {
            case PG:
                loadPgStructure(dir, db);
                break;
            case MS:
                loadMsStructure(dir, db);
                break;
            case CH:
                loadChStructure(dir, db);
                break;
            default:
                throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + settings.getDbType());
            }
        }
        AntlrTaskManager.finish(antlrTasks);
    }

    private void loadLibraries(AbstractDatabase db, ISettings settings)
            throws InterruptedException, IOException {
        LibraryLoader ll = new LibraryLoader(db,
                Paths.get(Platform.getStateLocation(Activator.getContext().getBundle())
                        .append("dependencies").toString()), errors); //$NON-NLS-1$
        ll.loadXml(new DependenciesXmlStore(Paths.get(iProject.getLocation()
                .append(DependenciesXmlStore.FILE_NAME).toString())), settings);
    }

    @Override
    protected void finishLoader(DatabaseLoader l) {
        super.finishLoader(l);
        PgUIDumpLoader loader = (PgUIDumpLoader) l;
        loader.updateMarkers();
    }

    public static AbstractDatabase buildFiles(Collection<IFile> files, DatabaseType dbType, IProgressMonitor monitor)
            throws InterruptedException, IOException, CoreException {
        UIProjectLoader loader = new UIProjectLoader(null, new UISettings(null, null, dbType), monitor);
        SubMonitor mon = SubMonitor.convert(monitor, files.size());
        AbstractDatabase db = switch (dbType) {
            case PG -> loader.buildPgChFiles(files, mon, WorkDirs.PG_SCHEMA);
            case CH -> loader.buildPgChFiles(files, mon, WorkDirs.CH_DATABASE);
            case MS -> loader.buildMsFiles(files, mon);
            default -> throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
        };
        loader.finishLoaders();
        return db;
    }

    public static PgStatement parseStatement(IFile file, Collection<DbObjType> types)
            throws InterruptedException, IOException, CoreException {
        DatabaseType dbType = ProjectUtils.getDatabaseType(file.getProject());
        return buildFiles(Arrays.asList(file), dbType, new NullProgressMonitor())
                .getDescendants()
                .filter(e -> types.contains(e.getStatementType()))
                .findAny().orElse(null);
    }
}
