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

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.DatabaseLoader;
import cz.startnet.utils.pgdiff.loader.FullAnalyze;
import cz.startnet.utils.pgdiff.loader.ParserListenerMode;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.meta.MetaStatement;
import cz.startnet.utils.pgdiff.schema.meta.MetaUtils;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class PgDbParser implements IResourceChangeListener, Serializable {

    private static final long serialVersionUID = 3718930301527312285L;

    private static final ConcurrentMap<IProject, PgDbParser> PROJ_PARSERS = new ConcurrentHashMap<>();

    private final ConcurrentMap<String, List<MetaStatement>> objDefinitions = new ConcurrentHashMap<>();
    private final ConcurrentMap<String, List<PgObjLocation>> objReferences = new ConcurrentHashMap<>();
    private final transient List<Listener> listeners = new ArrayList<>();

    public void addListener(Listener e) {
        listeners.add(e);
    }

    public void removeListener(Listener e) {
        listeners.remove(e);
    }

    public static PgDbParser getParser(IProject proj) {
        return getParserForBuilder(proj, null);
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
        return Paths.get(Platform.getStateLocation(Activator.getContext().getBundle())
                .append("projects").append(name + ".ser").toString()); //$NON-NLS-1$ //$NON-NLS-2$
    }

    public void serialize(String name) {
        try {
            Path path = getPathToObject(name);
            Files.createDirectories(path.getParent());
            ApgdiffUtils.serialize(path, this);
        } catch (IOException e) {
            Log.log(Log.LOG_DEBUG, "Error while serialize parser!", e); //$NON-NLS-1$
        }
    }

    public boolean deserialize(String name) {
        try {
            Path path = getPathToObject(name);
            if (Files.exists(path)) {
                try (ObjectInputStream oin = new ObjectInputStream(Files.newInputStream(path))) {
                    PgDbParser parser = (PgDbParser) oin.readObject();
                    objReferences.clear();
                    objReferences.putAll(parser.objReferences);
                    objDefinitions.clear();
                    objDefinitions.putAll(parser.objDefinitions);
                    notifyListeners();
                    return true;
                }
            }
        } catch (ClassNotFoundException | IOException | ClassCastException e) {
            Log.log(Log.LOG_DEBUG, "Error while deserialize parser!", e); //$NON-NLS-1$
        }
        return false;
    }

    public static void clean(String name) {
        try {
            Path path = getPathToObject(name);
            Files.deleteIfExists(path);
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

    public void getObjFromProjFile(IFile file, IProgressMonitor monitor, boolean isMsSql)
            throws InterruptedException, IOException, CoreException {
        PgDiffArguments args = new PgDiffArguments();
        args.setMsSql(isMsSql);
        args.setInCharsetName(file.getCharset());
        PgUIDumpLoader loader = new PgUIDumpLoader(file, args, monitor);
        loader.setMode(ParserListenerMode.REF);
        PgDatabase db = loader.loadFile(new PgDatabase(args));
        removeResFromRefs(file);
        objDefinitions.putAll(MetaUtils.getObjDefinitions(db));
        objReferences.putAll(db.getObjReferences());
        notifyListeners();
    }

    public void getObjFromProjFiles(Collection<IFile> files, IProgressMonitor monitor, boolean isMsSql)
            throws InterruptedException, IOException, CoreException {
        PgDatabase db = UIProjectLoader.buildFiles(files, isMsSql, monitor);
        files.forEach(this::removeResFromRefs);
        objDefinitions.putAll(MetaUtils.getObjDefinitions(db));
        List<Object> errors = new ArrayList<>();
        FullAnalyze.fullAnalyze(db, MetaUtils.createTreeFromDefs(
                getAllObjDefinitions(), !isMsSql, db.getPostgresVersion()), errors);
        UIProjectLoader.markErrors(errors);
        objReferences.putAll(db.getObjReferences());
        notifyListeners();
    }

    public void getFullDBFromPgDbProject(IProject proj, IProgressMonitor monitor)
            throws InterruptedException, IOException, CoreException {
        SubMonitor mon = SubMonitor.convert(monitor, UIProjectLoader.countFiles(proj));
        PgDiffArguments args = new PgDiffArguments();
        args.setInCharsetName(proj.getDefaultCharset(true));
        args.setMsSql(OpenProjectUtils.checkMsSql(proj));
        DatabaseLoader loader = new UIProjectLoader(proj, args, mon);
        PgDatabase db = loader.loadAndAnalyze();
        objDefinitions.clear();
        objDefinitions.putAll(MetaUtils.getObjDefinitions(db));
        objReferences.clear();
        objReferences.putAll(db.getObjReferences());
        notifyListeners();
    }

    public void removeResFromRefs(IResource res) {
        String path = res.getLocation().toOSString();
        objReferences.remove(path);
        objDefinitions.remove(path);
    }

    public void fillRefsFromInputStream(InputStream input, String fileName,
            boolean isMsSql, IProgressMonitor monitor) throws InterruptedException, IOException {
        PgDiffArguments args = new PgDiffArguments();
        args.setMsSql(isMsSql);
        PgDumpLoader loader = new PgDumpLoader(() -> input, fileName, args, monitor);
        loader.setMode(ParserListenerMode.REF);
        PgDatabase db = loader.load();
        objDefinitions.clear();
        objDefinitions.putAll(MetaUtils.getObjDefinitions(db));
        objReferences.clear();
        objReferences.putAll(db.getObjReferences());
        notifyListeners();
    }

    public Stream<MetaStatement> getDefinitionsForObj(PgObjLocation obj) {
        return getAllObjDefinitions().filter(st -> st.getObject().compare(obj));
    }

    public List<PgObjLocation> getObjsForEditor(IEditorInput in) {
        String path = getPathFromInput(in);
        return path == null ? Collections.emptyList() : getObjsForPath(path);
    }

    public List<PgObjLocation> getObjsForPath(String pathToFile) {
        return objReferences.getOrDefault(pathToFile, Collections.emptyList());
    }

    public Stream<MetaStatement> getAllObjDefinitions() {
        return objDefinitions.values().stream().flatMap(List<MetaStatement>::stream);
    }

    public Stream<PgObjLocation> getAllObjReferences() {
        return objReferences.values().stream().flatMap(List<PgObjLocation>::stream);
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
        switch (event.getType()) {
        case IResourceChangeEvent.PRE_CLOSE:
        case IResourceChangeEvent.PRE_DELETE:
            if (PROJ_PARSERS.remove(event.getResource(), this)) {
                ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
            }
            break;
        default:
            break;
        }
    }

    public static IStatus getLoadingErroStatus(Exception ex) {
        return new Status(IStatus.ERROR, PLUGIN_ID.THIS, Messages.PgDbParser_error_loading_db, ex);
    }

    public static String getPathFromInput(IEditorInput in) {
        IResource res = ResourceUtil.getResource(in);
        if (res != null) {
            try {
                if (res.getProject().hasNature(NATURE.ID)) {
                    return res.getLocation().toOSString();
                }
            } catch (CoreException ex) {
                Log.log(Log.LOG_WARNING, "Nature error", ex); //$NON-NLS-1$
            }
        }
        if (in.exists() && in instanceof IURIEditorInput) {
            return Paths.get(((IURIEditorInput) in).getURI()).toString();
        } else {
            return null;
        }
    }
}
