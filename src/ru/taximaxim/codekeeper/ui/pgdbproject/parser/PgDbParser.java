package ru.taximaxim.codekeeper.ui.pgdbproject.parser;

import java.io.InputStream;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
    private volatile List<PgObjLocation> objDefinitions;
    private volatile List<PgObjLocation> objReferences;
    private IProject proj;
    private List<Listener> listeners = new ArrayList<>();

    private PgDbParser(IProject proj) {
        objDefinitions = new ArrayList<>();
        objReferences = new ArrayList<>();
        this.proj = proj;
    }
    
    private PgDbParser() {
        this(null);
    }
    
    private void updateReferences(List<PgObjLocation> defs,
            List<PgObjLocation> refs) {
        objDefinitions = defs;
        objReferences = refs;
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
            String scriptFileEncoding, IProgressMonitor monitor, List<FunctionBodyContainer> funcBodyes) {
        PgDbParser rollOnParser = new PgDbParser();
        rollOnParser.fillRefsFromInputStream(input, monitor, scriptFileEncoding, funcBodyes);
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
        List<FunctionBodyContainer> funcBodyes = new ArrayList<>();
        PgDatabase db = PgDumpLoader.loadSchemasAndFile(filePath,
                prefs.get(UIConsts.PROJ_PREF.ENCODING, UIConsts.UTF_8), false,
                false, ParserClass.getParserAntlrReferences(null, 1, funcBodyes));
        updateReferences(fillRefs(objDefinitions, db.getObjDefinitions()),
                fillRefs(objReferences, db.getObjReferences()));
        fillFunctionBodies(objDefinitions, objReferences, funcBodyes);
    }

    public static void fillFunctionBodies(List<PgObjLocation> objDefinitions,
            List<PgObjLocation> objReferences,
            List<FunctionBodyContainer> funcBodyes) {
        for (FunctionBodyContainer funcBody : funcBodyes) {
            String body = funcBody.getBody();
            for (PgObjLocation def : objDefinitions) {
                int index = body.indexOf(def.getObjName());
                while (index > 0) {
                    PgObjLocation loc = new PgObjLocation(def.getObject().schema,
                            def.getObjName(), null, funcBody.getOffset() + index,
                            funcBody.getPath(), funcBody.getLineNumber());
                    loc.setObjType(def.getObjType());
                    loc.setAction(StatementActions.NONE);
                    objReferences.add(loc);
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
        List<FunctionBodyContainer> funcBodyes = new ArrayList<>();
        PgDatabase db = PgDumpLoader.loadDatabaseSchemaFromDirTree(
                Paths.get(locationURI).toAbsolutePath().toString(),
                prefs.get(UIConsts.PROJ_PREF.ENCODING, UIConsts.UTF_8), 
                false, false, ParserClass.getParserAntlrReferences(monitor, 1, funcBodyes));
        updateReferences(new ArrayList<>(db.getObjDefinitions()), db.getObjReferences());
        fillFunctionBodies(objDefinitions, objReferences, funcBodyes);
        notifyListeners();
    }

    protected List<PgObjLocation> fillRefs(Collection<PgObjLocation> oldRefs,
            Collection<PgObjLocation> newRefs) {
        Set<Path> paths = new HashSet<>();
        for (PgObjLocation newRef :newRefs) {
            paths.add(newRef.getFilePath());
        }
        List<PgObjLocation> newList = removePathFromRefs(oldRefs, paths);
        newList.addAll(newRefs);
        return newList;
    }

    private List<PgObjLocation> removePathFromRefs(Collection<PgObjLocation> newList, Set<Path> paths) {
        List<PgObjLocation> copy = new ArrayList<>(newList);
        Iterator<PgObjLocation> iter = copy.iterator();
        while (iter.hasNext()) {
            if (paths.contains(iter.next().getFilePath())) {
                iter.remove();
            }
        }
        return copy;
    }
    public void removePathFromRefs(Path path) {
        Set<Path> paths = new HashSet<>();
        paths.add(path);
        updateReferences(removePathFromRefs(objDefinitions, paths),
                removePathFromRefs(objReferences, paths));
    }
    
    private void fillRefsFromInputStream(InputStream input,
            IProgressMonitor monitor, String scriptFileEncoding, List<FunctionBodyContainer> funcBodyes) {
        PgDatabase db = PgDumpLoader.loadRefsFromInputStream(input, Paths.get(""),
                scriptFileEncoding, false, false,
                ParserClass.getParserAntlrReferences(monitor, 1, funcBodyes));
        updateReferences(new ArrayList<>(db.getObjDefinitions()), db.getObjReferences());
    }

    public PgObjLocation getDefinitionForObj(PgObjLocation obj) {
        for (PgObjLocation col : objDefinitions) {
            if (col.getObject().equals(obj.getObject())
                    && col.getObjType().equals(obj.getObjType())) {
                return col;
            }
        }
        return null;
    }
    
    public List<PgObjLocation> getObjsForPath(Path pathToFile) {
        List<PgObjLocation> locations = new ArrayList<>();
        for (PgObjLocation loc : objReferences) {
            if (loc.getFilePath().equals(pathToFile) 
                    && hasDefinition(loc)) {
                locations.add(loc);
            }
        }
        return locations;
    }
    
    public List<PgObjLocation> getObjDefinitions() {
        return Collections.unmodifiableList(objDefinitions);
    }
    
    public List<PgObjLocation> getObjReferences() {
        return Collections.unmodifiableList(objReferences);
    }
    
    private boolean hasDefinition(PgObjLocation obj) {
        for (PgObjLocation loc : objDefinitions) {
            if (loc.getObject().table.equals(obj.getObject().table)
                    && loc.getObjType().equals(obj.getObjType())) {
                return true;
            }
        }
        return false;
    }
    
    public List<PgObjLocation> getObjDefinitionsByPath(Path path) {
        List<PgObjLocation> locations = new ArrayList<>();
        for (PgObjLocation obj : objDefinitions) {
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
