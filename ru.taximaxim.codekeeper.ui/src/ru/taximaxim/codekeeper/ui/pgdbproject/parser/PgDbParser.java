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
import java.io.ObjectInputStream;
import java.io.Serializable;
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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
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
import ru.taximaxim.codekeeper.core.fileutils.FileUtils;
import ru.taximaxim.codekeeper.core.loader.DatabaseLoader;
import ru.taximaxim.codekeeper.core.loader.FullAnalyze;
import ru.taximaxim.codekeeper.core.loader.ParserListenerMode;
import ru.taximaxim.codekeeper.core.loader.PgDumpLoader;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.meta.MetaStatement;
import ru.taximaxim.codekeeper.core.schema.meta.MetaUtils;
import ru.taximaxim.codekeeper.core.settings.ISettings;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.properties.UISettings;

public class PgDbParser implements IResourceChangeListener, Serializable {

    private static final long serialVersionUID = -234872770125300447L;

    private static final ConcurrentMap<IProject, PgDbParser> PROJ_PARSERS = new ConcurrentHashMap<>();

    private final ConcurrentMap<String, List<MetaStatement>> objDefinitions = new ConcurrentHashMap<>();
    private final ConcurrentMap<String, Set<PgObjLocation>> objReferences = new ConcurrentHashMap<>();
    private final transient List<Listener> listeners = new ArrayList<>();

    public void addListener(Listener e) {
        listeners.add(e);
    }

    public void removeListener(Listener e) {
        listeners.remove(e);
    }

    public static PgDbParser getParser(IResource res) {
        return getParserForBuilder(res.getProject(), null);
    }

    public static void removeProject(IResource res) {
        IProject proj = res.getProject();
        PROJ_PARSERS.remove(proj);
        clean(proj.getName());
    }

    /**
     * @param buildType single element array; element may be altered to indicate
     *                  actual required build type
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
            Utils.serialize(path, this);
        } catch (IOException e) {
            Log.log(Log.LOG_DEBUG, "Error while serialize parser!", e); //$NON-NLS-1$
        }
    }

    public boolean deserialize(String name) {
        Path path = getPathToObject(name);
        if (Files.notExists(path)) {
            return false;
        }

        try (ObjectInputStream oin = new ObjectInputStream(Files.newInputStream(path))) {
            PgDbParser parser = (PgDbParser) oin.readObject();
            objReferences.clear();
            objReferences.putAll(parser.objReferences);
            objDefinitions.clear();
            objDefinitions.putAll(parser.objDefinitions);
            notifyListeners();
            return true;
        } catch (ClassNotFoundException | IOException | ClassCastException e) {
            Log.log(Log.LOG_DEBUG, "Error while deserialize parser!", e); //$NON-NLS-1$
            return false;
        }
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

    private static void startBuildJob(IProject proj) {
        BuildAction build = new BuildAction(
                PlatformUI.getWorkbench().getActiveWorkbenchWindow(),
                IncrementalProjectBuilder.FULL_BUILD);
        build.selectionChanged(new StructuredSelection(proj));
        build.runInBackground(null);
    }

    public void getObjFromProjFile(IFile file, IProgressMonitor monitor, DatabaseType dbType)
            throws InterruptedException, IOException, CoreException {
        ISettings settings = new UISettings(file.getProject(), null);
        PgUIDumpLoader loader = new PgUIDumpLoader(file, settings, monitor);
        loader.setMode(ParserListenerMode.REF);
        AbstractDatabase db = loader.loadFile(DatabaseLoader.createDb(settings));
        removeResFromRefs(file);
        objDefinitions.putAll(MetaUtils.getObjDefinitions(db));
        objReferences.putAll(db.getObjReferences());
        notifyListeners();
    }

    public void getObjFromProjFiles(Collection<IFile> files, IProgressMonitor monitor, DatabaseType dbType)
            throws InterruptedException, IOException, CoreException {
        AbstractDatabase db = UIProjectLoader.buildFiles(files, dbType, monitor);
        files.forEach(this::removeResFromRefs);
        // fill definitions, view columns will be filled in the analysis
        objDefinitions.putAll(MetaUtils.getObjDefinitions(db));
        List<Object> errors = new ArrayList<>();
        FullAnalyze.fullAnalyze(db,
                MetaUtils.createTreeFromDefs(getAllObjDefinitions(), dbType, db.getVersion()),
                errors);
        UIProjectLoader.markErrors(errors);
        objReferences.putAll(db.getObjReferences());
        notifyListeners();
    }

    public void getFullDBFromPgDbProject(IProject proj, IProgressMonitor monitor)
            throws InterruptedException, IOException, CoreException {
        SubMonitor mon = SubMonitor.convert(monitor, UIProjectLoader.countFiles(proj));
        ISettings settings = new UISettings(proj, null);
        DatabaseLoader loader = new UIProjectLoader(proj, settings, mon);
        AbstractDatabase db = loader.load();
        clear();

        // fill definitions, view columns will be filled in the analysis
        objDefinitions.putAll(MetaUtils.getObjDefinitions(db));
        FullAnalyze.fullAnalyze(db,
                MetaUtils.createTreeFromDefs(getAllObjDefinitions(), settings.getDbType(), db.getVersion()),
                loader.getErrors());
        objReferences.putAll(db.getObjReferences());
        notifyListeners();
    }

    public void removeResFromRefs(IResource res) {
        String path = res.getLocation().toOSString();
        objReferences.remove(path);
        objDefinitions.remove(path);
    }

    public void fillRefsFromInputStream(InputStream input, String fileName, IProgressMonitor monitor, IProject project)
            throws InterruptedException, IOException {
        PgDumpLoader loader = new PgDumpLoader(() -> input, fileName, new UISettings(project, null), monitor);
        loader.setMode(ParserListenerMode.REF);
        AbstractDatabase db = loader.load();
        objDefinitions.clear();
        objDefinitions.putAll(MetaUtils.getObjDefinitions(db));
        objReferences.clear();
        objReferences.putAll(db.getObjReferences());
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
        return objReferences.getOrDefault(pathToFile, Collections.emptySet());
    }

    public List<MetaStatement> getDefsForPath(String pathToFile) {
        return objDefinitions.getOrDefault(pathToFile, Collections.emptyList());
    }

    public Stream<MetaStatement> getAllObjDefinitions() {
        return objDefinitions.values().stream().flatMap(List<MetaStatement>::stream);
    }

    public Stream<PgObjLocation> getAllObjReferences() {
        return objReferences.values().stream().flatMap(Set<PgObjLocation>::stream);
    }

    public void clear() {
        objDefinitions.clear();
        objReferences.clear();
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

    public static IStatus getLoadingErroStatus(Exception ex) {
        return new Status(IStatus.ERROR, PLUGIN_ID.THIS, Messages.PgDbParser_error_loading_db, ex);
    }

    public static String getPathFromInput(IEditorInput in) {
        IResource res = ResourceUtil.getResource(in);
        if (res != null && OpenProjectUtils.isPgCodeKeeperProject(res.getProject())) {
            return res.getLocation().toOSString();
        }

        if (in.exists() && in instanceof IURIEditorInput uriInput) {
            return Paths.get(uriInput.getURI()).toString();
        }

        return null;
    }
}
