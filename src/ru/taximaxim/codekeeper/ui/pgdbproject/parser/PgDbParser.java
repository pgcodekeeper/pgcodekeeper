package ru.taximaxim.codekeeper.ui.pgdbproject.parser;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import ru.taximaxim.codekeeper.ui.UIConsts;
import cz.startnet.utils.pgdiff.loader.ParserClass;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;

public class PgDbParser {

    private static final ConcurrentMap<IProject, PgDbParser> PROJ_PARSERS = new ConcurrentHashMap<>();
    private final CopyOnWriteArrayList<PgObjLocation> objDefinitions;
    private final CopyOnWriteArrayList<PgObjLocation> objReferences;
    private final IProject proj;

    private PgDbParser(IProject proj) {
        this.proj = proj;
        objDefinitions = new CopyOnWriteArrayList<>();
        objReferences = new CopyOnWriteArrayList<>();
    }
    
    public static PgDbParser getParser(IProject proj) {
        if (PROJ_PARSERS.get(proj) != null) {
            return PROJ_PARSERS.get(proj); 
        }
        PgDbParser parser = new PgDbParser(proj);
        parser.getObjFromProject();
        PROJ_PARSERS.put(proj, parser);
        return parser;
    }

    public PgDbParser getObjFromProject() {
        getDBFromDirectory(proj.getLocationURI());
        return this;
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
    
    private void getDBFromDirectory(final URI locationURI) {
        Job job = new Job("getDatabaseReferences") {
            
            @Override
            protected IStatus run(IProgressMonitor monitor) {
                ProjectScope ps = new ProjectScope(proj);
                IEclipsePreferences prefs = ps.getNode(UIConsts.PLUGIN_ID.THIS);
                String dirPath = Paths.get(locationURI).toAbsolutePath().toString();
                PgDatabase db = PgDumpLoader.loadDatabaseSchemaFromDirTree(dirPath,
                        prefs.get(UIConsts.PROJ_PREF.ENCODING, UIConsts.UTF_8), 
                        false, false, ParserClass.ANTLR);
                objDefinitions.clear();
                objReferences.clear();
                objDefinitions.addAll(db.getObjDefinitions());
                objReferences.addAll(db.getObjReferences());
                return Status.OK_STATUS;
            }
        };
        job.setSystem(true);
        job.schedule();
    }
}
