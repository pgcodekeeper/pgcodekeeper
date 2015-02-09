package ru.taximaxim.codekeeper.ui.pgdbproject.parser;

import java.io.InputStream;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import ru.taximaxim.codekeeper.ui.UIConsts;
import cz.startnet.utils.pgdiff.loader.ParserClass;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.parsers.antlr.FunctionBodyContainer;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.StatementActions;

public class PgDbParser {

    private static final ConcurrentMap<IProject, PgDbParser> PROJ_PARSERS = new ConcurrentHashMap<>();
    private volatile ConcurrentMap<Path, List<PgObjLocation>> objDefinitions = new ConcurrentHashMap<>();
    private volatile ConcurrentMap<Path, List<PgObjLocation>> objReferences = new ConcurrentHashMap<>();
    private IProject proj;
    private List<Listener> listeners = new ArrayList<>();

    private PgDbParser(IProject proj) {
        this.proj = proj;
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
    
    public static PgDbParser getRollOnParser(InputStream input,
            String scriptFileEncoding, IProgressMonitor monitor, List<FunctionBodyContainer> funcBodies) {
        PgDbParser rollOnParser = new PgDbParser();
        rollOnParser.fillRefsFromInputStream(input, monitor, scriptFileEncoding, funcBodies);
        return rollOnParser;
    }

    public void getObjFromProject(IProgressMonitor monitor) {
        getFullDBFromDirectory(proj.getLocationURI(), monitor);
    }
    
    public void getObjFromProjFile(URI fileURI) {
        ProjectScope ps = new ProjectScope(proj);
        IEclipsePreferences prefs = ps.getNode(UIConsts.PLUGIN_ID.THIS);
        Path path = Paths.get(fileURI);
        String filePath = path.toAbsolutePath().toString();
        List<FunctionBodyContainer> funcBodies = new ArrayList<>();
        PgDatabase db = PgDumpLoader.loadSchemasAndFile(filePath,
                prefs.get(UIConsts.PROJ_PREF.ENCODING, UIConsts.UTF_8), false,
                false, ParserClass.getParserAntlrReferences(null, 1, funcBodies));
        for (Path key : db.getObjDefinitions().keySet()) {
            objDefinitions.put(key, db.getObjDefinitions().get(key));
        }
        for (Path key : db.getObjReferences().keySet()) {
            objReferences.put(key, db.getObjReferences().get(key));
        }
        fillFunctionBodies(objDefinitions, objReferences, funcBodies);
    }

    public static void fillFunctionBodies(Map<Path, List<PgObjLocation>> objDefinitions2,
            Map<Path, List<PgObjLocation>> objReferences2,
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
                    List<PgObjLocation> refs = objReferences2.get(funcBody.getPath());
                    if (refs == null) {
                        refs = new ArrayList<>();
                        objReferences2.put(funcBody.getPath(), refs);
                    }
                    refs.add(loc);
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
        Job job = new Job("getDatabaseReferences") {

            @Override
            protected IStatus run(IProgressMonitor monitor) {
                getFullDBFromDirectory(locationURI, monitor);
                return Status.OK_STATUS;
            }
            
        };
        job.setSystem(true);
        job.schedule();
    }
    
    private void getFullDBFromDirectory(URI locationURI, IProgressMonitor monitor) {
        ProjectScope ps = new ProjectScope(proj);
        IEclipsePreferences prefs = ps.getNode(UIConsts.PLUGIN_ID.THIS);
        List<FunctionBodyContainer> funcBodies = new ArrayList<>();
        PgDatabase db = PgDumpLoader.loadDatabaseSchemaFromDirTree(
                Paths.get(locationURI).toAbsolutePath().toString(),
                prefs.get(UIConsts.PROJ_PREF.ENCODING, UIConsts.UTF_8), 
                false, false, ParserClass.getParserAntlrReferences(monitor, 1, funcBodies));
        objDefinitions = new ConcurrentHashMap<Path, List<PgObjLocation>>(db.getObjDefinitions());
        objReferences = new ConcurrentHashMap<Path, List<PgObjLocation>>(db.getObjReferences());
        fillFunctionBodies(objDefinitions, objReferences, funcBodies);
        notifyListeners();
    }

    public void removePathFromRefs(Path path) {
        objDefinitions.remove(path);
        objReferences.remove(path);
    }
    
    private void fillRefsFromInputStream(InputStream input,
            IProgressMonitor monitor, String scriptFileEncoding, List<FunctionBodyContainer> funcBodies) {
        PgDatabase db = PgDumpLoader.loadRefsFromInputStream(input, Paths.get(""),
                scriptFileEncoding, false, false,
                ParserClass.getParserAntlrReferences(monitor, 1, funcBodies));
        objDefinitions = new ConcurrentHashMap<Path, List<PgObjLocation>>(db.getObjDefinitions());
        objReferences = new ConcurrentHashMap<Path, List<PgObjLocation>>(db.getObjReferences());
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
    
    public ConcurrentMap<Path, List<PgObjLocation>> getObjDefinitions() {
        return objDefinitions;
    }
    
    public ConcurrentMap<Path, List<PgObjLocation>> getObjReferences() {
        return objReferences;
    }
    
    public static List<PgObjLocation> getAll(Map<Path, List<PgObjLocation>> refs) {
        List<PgObjLocation> results = new ArrayList<>();
        for (Path key : refs.keySet()) {
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
}
