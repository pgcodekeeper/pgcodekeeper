package ru.taximaxim.codekeeper.ui.pgdbproject.parser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.parsers.antlr.FunctionBodyContainer;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;

public class PgDbParser implements IResourceChangeListener {

    private static final ConcurrentMap<IProject, PgDbParser> PROJ_PARSERS = new ConcurrentHashMap<>();

    private volatile ConcurrentMap<String, List<PgObjLocation>> objDefinitions = new ConcurrentHashMap<>();
    private volatile ConcurrentMap<String, List<PgObjLocation>> objReferences = new ConcurrentHashMap<>();
    private final IProject proj;
    private final List<Listener> listeners = new ArrayList<>();

    private PgDbParser(IProject proj) {
        this.proj = proj;
        if (proj != null) {
            ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
        }
    }

    private PgDbParser() {
        this(null);
    }

    public void addListener(Listener e) {
        listeners.add(e);
    }

    public void removeListener(Listener e) {
        listeners.remove(e);
    }

    public static PgDbParser getParser(IProject proj) {
        PgDbParser parser = PROJ_PARSERS.get(proj);
        if (parser != null) {
            return parser;
        }
        parser = new PgDbParser(proj);
        parser.getFullDBFromDirectoryJob(proj.getLocationURI());
        PROJ_PARSERS.put(proj, parser);
        return parser;
    }

    /**
     * @return existing parser or null if parser was fully created by this call
     * @throws InterruptedException
     * @throws IOException
     */
    public static PgDbParser getParserForBuilder(IProject proj, IProgressMonitor builderMonitor)
            throws InterruptedException, IOException {
        PgDbParser parser = PROJ_PARSERS.get(proj);
        if (parser != null) {
            return parser;
        }

        parser = new PgDbParser(proj);
        parser.getFullDBFromDirectory(proj.getLocationURI(), builderMonitor);
        PROJ_PARSERS.put(proj, parser);
        // signify newly loaded parser
        return null;
    }

    public static PgDbParser getRollOnParser(InputStream input,
            String scriptFileEncoding, IProgressMonitor monitor,
            List<FunctionBodyContainer> funcBodies) throws InterruptedException, IOException {
        PgDbParser rollOnParser = new PgDbParser();
        rollOnParser.fillRefsFromInputStream(input, monitor, scriptFileEncoding, funcBodies);
        return rollOnParser;
    }

    public void getObjFromProject(IProgressMonitor monitor)
            throws InterruptedException, IOException {
        getFullDBFromDirectory(proj.getLocationURI(), monitor);
    }

    public void getObjFromProjFile(URI fileURI, IProgressMonitor monitor)
            throws InterruptedException, IOException {
        String charset = ApgdiffConsts.UTF_8;
        try {
            charset = proj.getDefaultCharset(true);
        } catch (CoreException e) {
            Log.log(e);
        }
        PgDiffArguments args = new PgDiffArguments();
        args.setInCharsetName(charset);
        try (PgDumpLoader loader = new PgDumpLoader(new File(fileURI), args, monitor)) {
            PgDatabase db = loader.load(true);
            for (String key : db.getObjDefinitions().keySet()) {
                objDefinitions.put(key, db.getObjDefinitions().get(key));
            }
            for (String key : db.getObjReferences().keySet()) {
                objReferences.put(key, db.getObjReferences().get(key));
            }
            fillFunctionBodies(objDefinitions, objReferences, loader.getFuncBodyReferences());
        }
    }

    public static void fillFunctionBodies(Map<String, List<PgObjLocation>> objDefinitions2,
            Map<String, List<PgObjLocation>> objReferences2,
            List<FunctionBodyContainer> funcBodies) {
        for (FunctionBodyContainer funcBody : funcBodies) {
            String body = funcBody.getBody();
            for (PgObjLocation def : getAll(objDefinitions2)) {
                int index = body.indexOf(def.getObjName());
                while (index > 0) {
                    PgObjLocation loc = new PgObjLocation(def.getObject().schema,
                            def.getObjName(), null, funcBody.getOffset() + index,
                            funcBody.getPath(), funcBody.getLineNumber());
                    loc.setObjType(def.getObjType());
                    loc.setAction(StatementActions.NONE);
                    Set<PgObjLocation> newRefs = new HashSet<>();
                    newRefs.add(loc);
                    List<PgObjLocation> refs = objReferences2.get(funcBody.getPath());
                    if (refs != null) {
                        newRefs.addAll(refs);
                    }
                    objReferences2.put(funcBody.getPath(), new ArrayList<>(newRefs));
                    index = body.indexOf(def.getObjName(), index + 1);
                }
            }
        }
    }
    /**
     * This method used instead serialize objects
     * Need to remember references
     * @param locationURI project location
     */
    private void getFullDBFromDirectoryJob(final URI locationURI) {
        Job job = new Job("getDatabaseReferences") { //$NON-NLS-1$

            @Override
            protected IStatus run(IProgressMonitor monitor) {
                try {
                    getFullDBFromDirectory(locationURI, monitor);
                } catch (InterruptedException e) {
                    return Status.CANCEL_STATUS;
                } catch (IOException ex) {
                    return getLoadingErroStatus(ex);
                }
                return Status.OK_STATUS;
            }

        };
        job.setSystem(true);
        job.schedule();
    }

    private void getFullDBFromDirectory(URI locationURI, IProgressMonitor monitor)
            throws InterruptedException, IOException {
        List<FunctionBodyContainer> funcBodies = new ArrayList<>();
        String charset = ApgdiffConsts.UTF_8;
        try {
            charset = proj.getDefaultCharset(true);
        } catch (CoreException e) {
            Log.log(e);
        }
        PgDiffArguments args = new PgDiffArguments();
        args.setInCharsetName(charset);
        PgDatabase db = PgDumpLoader.loadDatabaseSchemaFromDirTree(
                Paths.get(locationURI).toAbsolutePath().toString(),
                args, monitor, 1, funcBodies);
        objDefinitions = new ConcurrentHashMap<String, List<PgObjLocation>>(db.getObjDefinitions());
        objReferences = new ConcurrentHashMap<String, List<PgObjLocation>>(db.getObjReferences());
        fillFunctionBodies(objDefinitions, objReferences, funcBodies);
        notifyListeners();
    }

    public void removePathFromRefs(Path path) {
        objReferences.remove(path);
        objDefinitions.remove(path);
    }

    private void fillRefsFromInputStream(InputStream input,
            IProgressMonitor monitor, String scriptFileEncoding,
            List<FunctionBodyContainer> funcBodies) throws InterruptedException, IOException {
        PgDiffArguments args = new PgDiffArguments();
        args.setInCharsetName(scriptFileEncoding);
        @SuppressWarnings("resource")
        PgDatabase db = new PgDumpLoader(input, "bytestream:/", args, monitor).load(true);
        objDefinitions = new ConcurrentHashMap<String, List<PgObjLocation>>(db.getObjDefinitions());
        objReferences = new ConcurrentHashMap<String, List<PgObjLocation>>(db.getObjReferences());
    }

    public PgObjLocation getDefinitionForObj(PgObjLocation obj) {
        for (PgObjLocation col : getAll(objDefinitions)) {
            if (col.getObject().equals(obj.getObject())
                    && col.getObjType().equals(obj.getObjType())) {
                return col;
            }
        }
        return null;
    }

    public List<PgObjLocation> getObjsForPath(Path pathToFile) {
        List<PgObjLocation> locations = new ArrayList<>();
        List<PgObjLocation> refs = objReferences.get(pathToFile);
        if (refs == null) {
            return locations;
        }
        for (PgObjLocation loc : refs) {
            if (loc.getFilePath().equals(pathToFile)
                    && hasDefinition(loc)) {
                locations.add(loc);
            }
        }
        return locations;
    }

    public List<PgObjLocation> getAllObjDefinitions() {
        return getAll(objDefinitions);
    }

    public List<PgObjLocation> getAllObjReferences() {
        return getAll(objReferences);
    }

    public Map<String, List<PgObjLocation>> getObjDefinitions() {
        return objDefinitions;
    }

    public Map<String, List<PgObjLocation>> getObjReferences() {
        return objReferences;
    }

    public static List<PgObjLocation> getAll(Map<String, List<PgObjLocation>> refs) {
        List<PgObjLocation> results = new ArrayList<>();
        for (String key : refs.keySet()) {
            results.addAll(refs.get(key));
        }
        return results;
    }

    private boolean hasDefinition(PgObjLocation obj) {
        for (PgObjLocation loc : getAll(objDefinitions)) {
            if (loc.getObject().table.equals(obj.getObject().table)
                    && loc.getObjType().equals(obj.getObjType())) {
                return true;
            }
        }
        return false;
    }

    public List<PgObjLocation> getObjDefinitionsByPath(Path path) {
        List<PgObjLocation> locations = new ArrayList<>();
        List<PgObjLocation> defs = objDefinitions.get(path);
        if (defs == null) {
            return locations;
        }
        for (PgObjLocation obj : defs) {
            if (obj.getFilePath().equals(path)) {
                locations.add(obj);
            }
        }
        return locations;
    }

    public void notifyListeners() {
        for (Listener e : listeners) {
            e.handleEvent(new Event());
        }
    }

    public List<Listener> getListeners() {
        return listeners;
    }

    @Override
    public void resourceChanged(IResourceChangeEvent event) {
        switch (event.getType()) {
        case IResourceChangeEvent.PRE_CLOSE:
        case IResourceChangeEvent.PRE_DELETE:
            if (event.getResource().equals(proj)) {
                PROJ_PARSERS.remove(event.getResource());
                ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
            }
            break;
        }
    }

    public static IStatus getLoadingErroStatus(IOException ex) {
        return new Status(IStatus.ERROR, PLUGIN_ID.THIS, "Error loading database", ex);
    }
}
