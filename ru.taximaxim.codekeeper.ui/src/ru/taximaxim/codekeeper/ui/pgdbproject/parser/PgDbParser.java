package ru.taximaxim.codekeeper.ui.pgdbproject.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
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
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.parsers.antlr.FunctionBodyContainer;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class PgDbParser implements IResourceChangeListener {

    private static final ConcurrentMap<IProject, PgDbParser> PROJ_PARSERS = new ConcurrentHashMap<>();

    private final ConcurrentMap<String, List<PgObjLocation>> objDefinitions = new ConcurrentHashMap<>();
    private final ConcurrentMap<String, List<PgObjLocation>> objReferences = new ConcurrentHashMap<>();
    private final List<Listener> listeners = new ArrayList<>();

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

    private static void startBuildJob(IProject proj) {
        BuildAction build = new BuildAction(
                PlatformUI.getWorkbench().getActiveWorkbenchWindow(),
                IncrementalProjectBuilder.FULL_BUILD);
        build.selectionChanged(new StructuredSelection(proj));
        build.runInBackground(null);
    }

    public void getObjFromProjFile(IFile file, IProgressMonitor monitor)
            throws InterruptedException, IOException, CoreException {
        PgDiffArguments args = new PgDiffArguments();
        args.setInCharsetName(file.getCharset());
        try (PgUIDumpLoader loader = new PgUIDumpLoader(file, args, monitor)) {
            loader.setLoadSchema(false);
            loader.setLoadReferences(true);
            PgDatabase db = loader.loadFile(new PgDatabase());
            objDefinitions.putAll(db.getObjDefinitions());
            objReferences.putAll(db.getObjReferences());
            fillFunctionBodies(loader.getFuncBodyReferences());
        }
        notifyListeners();
    }

    public void getObjFromProjFiles(Collection<IFile> files, IProgressMonitor monitor)
            throws InterruptedException, IOException, CoreException {
        List<FunctionBodyContainer> funcBodies = new ArrayList<>();
        PgDatabase db = PgUIDumpLoader.buildFiles(files, monitor, funcBodies);
        objDefinitions.putAll(db.getObjDefinitions());
        objReferences.putAll(db.getObjReferences());
        fillFunctionBodies(funcBodies);
        notifyListeners();
    }

    private void fillFunctionBodies(List<FunctionBodyContainer> funcBodies) {
        for (FunctionBodyContainer funcBody : funcBodies) {
            String body = funcBody.getBody();
            Set<PgObjLocation> newRefs = new LinkedHashSet<>();
            getAllObjDefinitions().forEach(def -> {
                int index = body.indexOf(def.getObjName());
                while (index >= 0) {
                    int next = index + def.getObjLength();
                    // check word boundaries, whole words only
                    if ((index == 0 || !PgDiffUtils.isValidIdChar(body.charAt(index - 1))) &&
                            (next >= body.length() || !PgDiffUtils.isValidIdChar(body.charAt(next)))) {
                        PgObjLocation loc = new PgObjLocation(def.getObject().schema,
                                def.getObjName(), null, funcBody.getOffset() + index,
                                funcBody.getPath(), funcBody.getLineNumber());
                        loc.setObjType(def.getObjType());
                        loc.setAction(StatementActions.NONE);
                        newRefs.add(loc);
                    }
                    index = body.indexOf(def.getObjName(), index + 1);
                }
            });
            if (!newRefs.isEmpty()) {
                List<PgObjLocation> refs = objReferences.get(funcBody.getPath());
                if (refs != null) {
                    newRefs.addAll(refs);
                }
                objReferences.put(funcBody.getPath(), new ArrayList<>(newRefs));
            }
        }
    }

    public void getFullDBFromPgDbProject(IProject proj, IProgressMonitor monitor)
            throws InterruptedException, IOException, CoreException {
        SubMonitor mon = SubMonitor.convert(monitor, PgUIDumpLoader.countFiles(proj));
        List<FunctionBodyContainer> funcBodies = new ArrayList<>();
        PgDiffArguments args = new PgDiffArguments();
        args.setInCharsetName(proj.getDefaultCharset(true));
        PgDatabase db = PgUIDumpLoader.loadDatabaseSchemaFromIProject(
                proj, args, mon, funcBodies, null);
        objDefinitions.clear();
        objDefinitions.putAll(db.getObjDefinitions());
        objReferences.clear();
        objReferences.putAll(db.getObjReferences());
        fillFunctionBodies(funcBodies);
        notifyListeners();
    }

    public void removePathFromRefs(String path) {
        objReferences.remove(path);
        objDefinitions.remove(path);
    }

    public void fillRefsFromInputStream(InputStream input, String fileName,
            IProgressMonitor monitor) throws InterruptedException, IOException {
        PgDiffArguments args = new PgDiffArguments();
        try (PgDumpLoader loader = new PgDumpLoader(input, fileName, args, monitor)) {
            loader.setLoadSchema(false);
            loader.setLoadReferences(true);
            PgDatabase db = loader.load();
            objDefinitions.putAll(db.getObjDefinitions());
            objReferences.putAll(db.getObjReferences());
            fillFunctionBodies(loader.getFuncBodyReferences());
        }
        notifyListeners();
    }

    public Stream<PgObjLocation> getDefinitionsForObj(PgObjLocation obj) {
        return getAllObjDefinitions()
                .filter(o -> o.getObject().equals(obj.getObject())
                        && o.getObjType().equals(obj.getObjType()));
    }

    public List<PgObjLocation> getObjsForEditor(IEditorInput in) {
        String path = getPathFromInput(in);
        return path == null ? Collections.emptyList() : getObjsForPath(path);
    }

    public List<PgObjLocation> getObjsForPath(String pathToFile) {
        List<PgObjLocation> refs = objReferences.get(pathToFile);
        return refs == null ? Collections.emptyList() : Collections.unmodifiableList(refs);
    }

    public Stream<PgObjLocation> getAllObjDefinitions() {
        return getAll(objDefinitions);
    }

    public Stream<PgObjLocation> getAllObjReferences() {
        return getAll(objReferences);
    }

    public Map<String, List<PgObjLocation>> getObjDefinitions() {
        return objDefinitions;
    }

    public Map<String, List<PgObjLocation>> getObjReferences() {
        return objReferences;
    }

    public static Stream<PgObjLocation> getAll(Map<String, List<PgObjLocation>> refs) {
        return refs.values().stream()
                .flatMap(List<PgObjLocation>::stream);
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
        if (in instanceof IURIEditorInput) {
            return ((IURIEditorInput) in).getURI().toString();
        } else {
            return null;
        }
    }
}
