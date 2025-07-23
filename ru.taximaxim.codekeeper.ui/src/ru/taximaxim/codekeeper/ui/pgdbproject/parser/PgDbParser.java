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
import java.io.InputStream;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Stream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.BuildAction;
import org.eclipse.ui.ide.ResourceUtil;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.loader.DatabaseLoader;
import ru.taximaxim.codekeeper.core.loader.FullAnalyze;
import ru.taximaxim.codekeeper.core.loader.ParserListenerMode;
import ru.taximaxim.codekeeper.core.loader.PgDumpLoader;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.meta.MetaStatement;
import ru.taximaxim.codekeeper.core.schema.meta.MetaUtils;
import ru.taximaxim.codekeeper.core.settings.ISettings;
import ru.taximaxim.codekeeper.core.utils.FileUtils;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.properties.UISettings;
import ru.taximaxim.codekeeper.ui.utils.ProjectUtils;

public final class PgDbParser implements IResourceChangeListener {

    private static final String FILTER_PATTERN = """
        maxdepth=10;\
        java.lang.Enum;\
        java.lang.Object;\
        java.util.ArrayList;\
        java.util.concurrent.ConcurrentHashMap$Segment;\
        java.util.concurrent.ConcurrentHashMap;\
        java.util.concurrent.locks.AbstractOwnableSynchronizer;\
        java.util.concurrent.locks.AbstractQueuedSynchronizer;\
        java.util.concurrent.locks.ReentrantLock$NonfairSync;\
        java.util.concurrent.locks.ReentrantLock$Sync;\
        java.util.concurrent.locks.ReentrantLock;\
        java.util.HashMap;\
        java.util.HashSet;\
        java.util.LinkedHashMap;\
        java.util.LinkedHashSet;\
        java.util.Map$Entry;\
        ru.taximaxim.codekeeper.core.ContextLocation;\
        ru.taximaxim.codekeeper.core.DangerStatement;\
        ru.taximaxim.codekeeper.core.model.difftree.DbObjType;\
        ru.taximaxim.codekeeper.core.schema.ArgMode;\
        ru.taximaxim.codekeeper.core.schema.Argument;\
        ru.taximaxim.codekeeper.core.schema.GenericColumn;\
        ru.taximaxim.codekeeper.core.schema.ICast$CastContext;\
        ru.taximaxim.codekeeper.core.schema.meta.MetaCast;\
        ru.taximaxim.codekeeper.core.schema.meta.MetaCompositeType;\
        ru.taximaxim.codekeeper.core.schema.meta.MetaConstraint;\
        ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;\
        ru.taximaxim.codekeeper.core.schema.meta.MetaFunction;\
        ru.taximaxim.codekeeper.core.schema.meta.MetaOperator;\
        ru.taximaxim.codekeeper.core.schema.meta.MetaRelation;\
        ru.taximaxim.codekeeper.core.schema.meta.MetaStatement;\
        ru.taximaxim.codekeeper.core.schema.PgObjLocation$LocationType;\
        ru.taximaxim.codekeeper.core.schema.PgObjLocation;\
        ru.taximaxim.codekeeper.core.schema.PgObjLocation.LocationType;\
        ru.taximaxim.codekeeper.core.utils.ModPair;\
        ru.taximaxim.codekeeper.core.utils.Pair;\
        ru.taximaxim.codekeeper.ui.pgdbproject.parser.ProjectReferencesStorage;\
        !*""";

    private static final ObjectInputFilter DESERIALIZATION_FILTER = ObjectInputFilter.Config
        .createFilter(FILTER_PATTERN);

    private static final ConcurrentMap<IProject, PgDbParser> PROJ_PARSERS = new ConcurrentHashMap<>();

    private final ProjectReferencesStorage referencesStorage = new ProjectReferencesStorage();
    private final List<Listener> listeners = new ArrayList<>();

    public void addListener(Listener e) {
        listeners.add(e);
    }

    public void removeListener(Listener e) {
        listeners.remove(e);
    }

    private static Path getPathToObject(String name) {
        return getPathToFolder().resolve(name + ".ser"); //$NON-NLS-1$
    }

    private static Path getPathToFolder() {
        return Paths.get(Platform.getStateLocation(Activator.getContext().getBundle()).toString(), "projects"); //$NON-NLS-1$
    }

    public void serialize(String name) {
        try {
            Path path = getPathToObject(name);
            Files.createDirectories(path.getParent());
            Utils.serialize(path, referencesStorage);
        } catch (IOException e) {
            Log.log(Log.LOG_DEBUG, "Error while serialize parser!", e); //$NON-NLS-1$
        }
    }

    public boolean deserialize(String name) {
        Path path = getPathToObject(name);
        if (Files.notExists(path)) {
            return false;
        }
        try (var inputStream = Files.newInputStream(path)) {
            deserialize(inputStream);
            notifyListeners();
            return true;
        } catch (ClassNotFoundException | IOException | ClassCastException e) {
            Log.log(Log.LOG_DEBUG, "Error while deserialize parser!", e); //$NON-NLS-1$
            return false;
        }
    }

    protected void deserialize(InputStream stream) throws IOException, ClassNotFoundException {
        try (ObjectInputStream oin = new ObjectInputStream(stream)) {
            oin.setObjectInputFilter(DESERIALIZATION_FILTER);
            ProjectReferencesStorage tmpStorage = (ProjectReferencesStorage) oin.readObject();
            referencesStorage.clear();
            referencesStorage.putReferences(tmpStorage.getObjDefinitions(), tmpStorage.getObjReferences());
        }
    }

    public void getObjFromProjFile(IFile file, IProgressMonitor monitor)
            throws InterruptedException, IOException {
        ISettings settings = new UISettings(file.getProject(), null);
        PgUIDumpLoader loader = new PgUIDumpLoader(file, settings, monitor);
        loader.setMode(ParserListenerMode.REF);
        AbstractDatabase db = loader.loadFile(DatabaseLoader.createDb(settings));
        removeResFromRefs(file);
        referencesStorage.putReferences(MetaUtils.getObjDefinitions(db), db.getObjReferences());
        notifyListeners();
    }

    public void getObjFromProjFiles(Collection<IFile> files, IProgressMonitor monitor, DatabaseType dbType)
            throws InterruptedException, IOException, CoreException {
        AbstractDatabase db = UIProjectLoader.buildFiles(files, dbType, monitor);
        files.forEach(this::removeResFromRefs);
        // fill definitions, view columns will be filled in the analysis
        var definitions = MetaUtils.getObjDefinitions(db);
        List<Object> errors = new ArrayList<>();
        FullAnalyze.fullAnalyze(db,
                MetaUtils.createTreeFromDefs(getAllObjDefinitions(), dbType, db.getVersion()),
                errors);
        UIProjectLoader.markErrors(errors);
        referencesStorage.putReferences(definitions, db.getObjReferences());
        notifyListeners();
    }

    public void getFullDBFromPgDbProject(IProject proj, IProgressMonitor monitor)
            throws InterruptedException, IOException, CoreException {
        SubMonitor mon = SubMonitor.convert(monitor, ProjectUtils.countFiles(proj));
        UISettings settings = new UISettings(proj, null);
        DatabaseLoader loader = new UIProjectLoader(proj, settings, mon);
        AbstractDatabase db = loader.load();
        referencesStorage.clear();

        // fill definitions, view columns will be filled in the analysis
        var definitions = MetaUtils.getObjDefinitions(db);
        FullAnalyze.fullAnalyze(db,
                MetaUtils.createTreeFromDefs(getAllObjDefinitions(), settings.getDbType(), db.getVersion()),
                loader.getErrors());
        referencesStorage.putReferences(definitions, db.getObjReferences());
        notifyListeners();
    }

    public void removeResFromRefs(IResource res) {
        String path = res.getLocation().toOSString();
        referencesStorage.remove(path);
    }

    public void fillRefsFromInputStream(InputStream input, String fileName, IProgressMonitor monitor, IProject project)
            throws InterruptedException, IOException {
        PgDumpLoader loader = new PgDumpLoader(() -> input, fileName, new UISettings(project, null), monitor);
        loader.setMode(ParserListenerMode.REF);
        AbstractDatabase db = loader.load();
        referencesStorage.clear();
        referencesStorage.putReferences(MetaUtils.getObjDefinitions(db), db.getObjReferences());
        notifyListeners();
    }

    public Stream<MetaStatement> getDefinitionsForObj(PgObjLocation obj) {
        return getAllObjDefinitions().filter(st -> st.getObject().compare(obj));
    }

    public Set<PgObjLocation> getObjsForEditor(IEditorInput in) {
        String path = getPathFromInput(in);
        return path == null ? Collections.emptySet() : getObjsForPath(path);
    }

    public Set<PgObjLocation> getObjsForPath(String pathToFile) {
        return referencesStorage.getObjReferencesForPath(pathToFile);
    }

    public List<MetaStatement> getDefsForPath(String pathToFile) {
        return referencesStorage.getObjDefinitionsForPath(pathToFile);
    }

    public Stream<MetaStatement> getAllObjDefinitions() {
        return referencesStorage.getAllObjDefinitions();
    }

    public Stream<PgObjLocation> getAllObjReferences() {
        return referencesStorage.getAllObjReferences();
    }

    public void clear() {
        referencesStorage.clear();
    }

    public void notifyListeners() {
        for (Listener e : listeners) {
            e.handleEvent(new Event());
        }
    }

    @Override
    public void resourceChanged(IResourceChangeEvent event) {
        int type = event.getType();
        if ((IResourceChangeEvent.PRE_CLOSE == type || IResourceChangeEvent.PRE_DELETE == type)
                && PROJ_PARSERS.remove(event.getResource(), this)) {
            ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
        }
    }

    public static String getPathFromInput(IEditorInput in) {
        IResource res = ResourceUtil.getResource(in);
        if (res != null && ProjectUtils.isPgCodeKeeperProject(res.getProject())) {
            return res.getLocation().toOSString();
        }

        if (in.exists() && in instanceof IURIEditorInput uriInput) {
            return Paths.get(uriInput.getURI()).toString();
        }

        return null;
    }

    public static PgDbParser getParser(IResource res) {
        return getParserForBuilder(res.getProject(), null);
    }

    /**
     * @param buildType
     *            single element array; element may be altered to indicate actual required build type
     */
    public static PgDbParser getParserForBuilder(IProject proj, int[] buildType) {
        PgDbParser pnew = new PgDbParser();
        PgDbParser p = PROJ_PARSERS.putIfAbsent(proj, pnew);
        if (p == null) {
            p = pnew;
            // prepare newly created parser
            ResourcesPlugin.getWorkspace().addResourceChangeListener(p,
                    IResourceChangeEvent.PRE_CLOSE | IResourceChangeEvent.PRE_DELETE);

            if (buildType == null) {
                // not a builder call, start builder
                startBuildJob(proj);
            } else {
                // builder call, change build type to FULL for new parsers
                buildType[0] = IncrementalProjectBuilder.FULL_BUILD;
            }
        }
        return p;
    }

    private static void startBuildJob(IProject proj) {
        BuildAction build = new BuildAction(
                PlatformUI.getWorkbench().getActiveWorkbenchWindow(),
                IncrementalProjectBuilder.FULL_BUILD);
        build.selectionChanged(new StructuredSelection(proj));
        build.runInBackground(null);
    }

    static void removeProject(IResource res) {
        IProject proj = res.getProject();
        PROJ_PARSERS.remove(proj);
        clean(proj.getName());
    }

    public static void clean(String name) {
        try {
            Path path = getPathToObject(name);
            Files.deleteIfExists(path);
        } catch (IOException e) {
            Log.log(Log.LOG_DEBUG, "Error while clean parser!", e); //$NON-NLS-1$
        }
    }

    public static void cleanAll() {
        try {
            Path path = getPathToFolder();
            FileUtils.deleteRecursive(path);
        } catch (IOException e) {
            Log.log(Log.LOG_DEBUG, "Error while clean parser!", e); //$NON-NLS-1$
        }
    }

}
