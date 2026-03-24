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
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.BuildAction;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.pgcodekeeper.core.database.api.loader.IDumpLoader;
import org.pgcodekeeper.core.database.api.loader.ILoader;
import org.pgcodekeeper.core.database.api.parser.ParserListenerMode;
import org.pgcodekeeper.core.database.api.schema.IDatabase;
import org.pgcodekeeper.core.database.api.schema.ObjectLocation;
import org.pgcodekeeper.core.database.base.parser.AntlrError;
import org.pgcodekeeper.core.database.base.parser.ErrorTypes;
import org.pgcodekeeper.core.database.base.parser.FullAnalyze;
import org.pgcodekeeper.core.database.base.schema.meta.MetaStatement;
import org.pgcodekeeper.core.database.base.schema.meta.MetaUtils;
import org.pgcodekeeper.core.settings.DiffSettings;
import org.pgcodekeeper.core.settings.ISettings;
import org.pgcodekeeper.core.utils.FileUtils;
import org.pgcodekeeper.core.utils.Utils;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.DatabaseType;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.MARKER;
import ru.taximaxim.codekeeper.ui.properties.UISettings;
import ru.taximaxim.codekeeper.ui.utils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.utils.ProjectUtils;
import ru.taximaxim.codekeeper.ui.utils.UIMonitor;

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
        org.codekeeper.core.ContextLocation;\
        org.codekeeper.core.DangerStatement;\
        org.codekeeper.core.model.graph.DbObjType;\
        org.codekeeper.core.database.api.schema.ArgMode;\
        org.codekeeper.core.schema.database.base.Argument;\
        org.codekeeper.core.database.api.schema.ObjectReference;\
        org.codekeeper.core.database.api.schema.ICast$CastContext;\
        org.codekeeper.core.database.base.schema.meta.MetaCast;\
        org.codekeeper.core.database.base.schema.meta.MetaCompositeType;\
        org.codekeeper.core.database.base.schema.meta.MetaConstraint;\
        org.codekeeper.core.database.base.schema.meta.MetaContainer;\
        org.codekeeper.core.database.base.schema.meta.MetaFunction;\
        org.codekeeper.core.database.base.schema.meta.MetaOperator;\
        org.codekeeper.core.database.base.schema.meta.MetaRelation;\
        org.codekeeper.core.database.base.schema.meta.MetaStatement;\
        org.codekeeper.core.database.api.schema.ObjectLocation$LocationType;\
        org.codekeeper.core.database.api.schema.ObjectLocation;\
        org.codekeeper.core.database.api.schema.ObjectLocation.LocationType;\
        org.codekeeper.core.utils.ModPair;\
        org.codekeeper.core.utils.Pair;\
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
        var provider = ProjectUtils.getDatabaseType(file.getProject()).getDatabaseProvider();
        IDumpLoader loader = provider.getDumpLoader(file.getLocation().toFile().toPath(),
                new DiffSettings(settings, new UIMonitor(monitor)));
        loader.setMode(ParserListenerMode.REF);
        IDatabase db = loader.load();
        clearMarkers(List.of(file));
        markErrors(loader.getErrors());
        removeResFromRefs(file);
        referencesStorage.putReferences(MetaUtils.getObjDefinitions(db), db.getObjReferences());
        notifyListeners();
    }

    public void getObjFromProjFiles(Collection<IFile> files, IProgressMonitor monitor, DatabaseType dbType)
            throws InterruptedException, IOException {
        if (files.isEmpty()) {
            return;
        }
        IProject proj = files.iterator().next().getProject();
        var loader = dbType.getDatabaseProvider().getProjectLoader(ProjectUtils.getPath(proj),
                new DiffSettings(new UISettings(proj, null), new UIMonitor(monitor)));
        IDatabase db = loader.load();
        files.forEach(this::removeResFromRefs);
        // fill definitions, view columns will be filled in the analysis
        var definitions = MetaUtils.getObjDefinitions(db);
        FullAnalyze.fullAnalyze(db, loader.getErrors());
        clearMarkers(files);
        markErrors(loader.getErrors());
        referencesStorage.putReferences(definitions, db.getObjReferences());
        notifyListeners();
    }

    public void getFullDBFromPgDbProject(IProject proj, IProgressMonitor monitor)
            throws InterruptedException, IOException {
        UISettings settings = new UISettings(proj, null);
        var provider = ProjectUtils.getDatabaseType(proj).getDatabaseProvider();
        ILoader loader = provider.getProjectLoader(ProjectUtils.getPath(proj),
                new DiffSettings(settings, new UIMonitor(monitor)));
        IDatabase db = loader.load();
        referencesStorage.clear();
        // fill definitions, view columns will be filled in the analysis
        var definitions = MetaUtils.getObjDefinitions(db);
        FullAnalyze.fullAnalyze(db, loader.getErrors());
        clearMarkers(proj);
        markErrors(loader.getErrors());
        referencesStorage.putReferences(definitions, db.getObjReferences());
        notifyListeners();
    }

    private static void clearMarkers(Collection<IFile> files) {
        for (IFile file : files) {
            try {
                file.deleteMarkers(MARKER.ERROR, false, IResource.DEPTH_ZERO);
            } catch (CoreException ex) {
                Log.log(ex);
            }
        }
    }

    private static void clearMarkers(IProject proj) {
        try {
            proj.deleteMarkers(MARKER.ERROR, false, IResource.DEPTH_INFINITE);
        } catch (CoreException ex) {
            Log.log(ex);
        }
    }

    private static void markErrors(List<Object> errors) {
        for (Object error : errors) {
            if (error instanceof AntlrError antlrError) {
                IFile file = FileUtilsUi.getFileForLocation(antlrError);
                if (file != null) {
                    addMarker(file, antlrError);
                }
            }
        }
    }

    private static void addMarker(IFile file, AntlrError antlrError) {
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

    public void removeResFromRefs(IResource res) {
        String path = res.getLocation().toOSString();
        referencesStorage.remove(path);
    }

    public void fillRefsFromInputStream(InputStream input, String fileName, IProgressMonitor monitor, IProject project)
            throws InterruptedException, IOException {
        var provider = ProjectUtils.getDatabaseType(project).getDatabaseProvider();
        var loader = provider.getDumpLoader(() -> input,
                fileName, new DiffSettings(new UISettings(project, null), new UIMonitor(monitor)));
        loader.setMode(ParserListenerMode.REF);
        IDatabase db = loader.load();
        referencesStorage.clear();
        referencesStorage.putReferences(MetaUtils.getObjDefinitions(db), db.getObjReferences());
        notifyListeners();
    }

    public Stream<MetaStatement> getDefinitionsForObj(ObjectLocation obj) {
        return getAllObjDefinitions().filter(st -> st.getObject().compare(obj));
    }

    public Set<ObjectLocation> getObjsForEditor(IEditorInput in) {
        String path = getPathFromInput(in);
        return path == null ? Collections.emptySet() : getObjsForPath(path);
    }

    public Set<ObjectLocation> getObjsForPath(String pathToFile) {
        return referencesStorage.getObjReferencesForPath(pathToFile);
    }

    public List<MetaStatement> getDefsForPath(String pathToFile) {
        return referencesStorage.getObjDefinitionsForPath(pathToFile);
    }

    public Stream<MetaStatement> getAllObjDefinitions() {
        return referencesStorage.getAllObjDefinitions();
    }

    public Stream<ObjectLocation> getAllObjReferences() {
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