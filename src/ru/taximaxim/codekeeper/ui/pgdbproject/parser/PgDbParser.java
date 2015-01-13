package ru.taximaxim.codekeeper.ui.pgdbproject.parser;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import cz.startnet.utils.pgdiff.loader.ParserClass;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;

public class PgDbParser extends IncrementalProjectBuilder{

    private static final ConcurrentMap<IProject, PgDbParser> PROJ_PARSERS = new ConcurrentHashMap<>();
    private final CopyOnWriteArrayList<PgObjLocation> objDefinitions;
    private final CopyOnWriteArrayList<PgObjLocation> objReferences;
    private IProject proj;
    
    public PgDbParser() {
        objDefinitions = new CopyOnWriteArrayList<>();
        objReferences = new CopyOnWriteArrayList<>();
    }

    private PgDbParser(IProject proj) {
        this.proj = proj;
        objDefinitions = new CopyOnWriteArrayList<>();
        objReferences = new CopyOnWriteArrayList<>();
    }
    
    public static PgDbParser getParser(IProject proj) {
        PgDbParser parser = PROJ_PARSERS.get(proj);
        if (parser != null) {
            return parser;
        }
        parser = new PgDbParser(proj);
        PROJ_PARSERS.put(proj, parser);
        return parser;
    }

    public void getObjFromProject() {
        getFullDBFromDirectory(proj.getLocationURI());
    }
    
    public void getObjFromProjFile(URI fileURI) {
        getPartialDBFromDirectory(proj.getLocationURI(), fileURI);
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
    
    private void getFullDBFromDirectory(final URI locationURI) {
        ProjectScope ps = new ProjectScope(proj);
        IEclipsePreferences prefs = ps.getNode(UIConsts.PLUGIN_ID.THIS);
        PgDatabase db = PgDumpLoader.loadDatabaseSchemaFromDirTree(
                Paths.get(locationURI).toAbsolutePath().toString(),
                prefs.get(UIConsts.PROJ_PREF.ENCODING, UIConsts.UTF_8), 
                false, false, ParserClass.ANTLR);
        objDefinitions.clear();
        objReferences.clear();
        objDefinitions.addAll(db.getObjDefinitions());
        objReferences.addAll(db.getObjReferences());
    }

    private void getPartialDBFromDirectory(final URI projURI, final URI fileURI) {
        Job job = new Job("getDatabaseReferences") {

            @Override
            protected IStatus run(IProgressMonitor monitor) {
                ProjectScope ps = new ProjectScope(proj);
                IEclipsePreferences prefs = ps.getNode(UIConsts.PLUGIN_ID.THIS);
                String projPath = Paths.get(projURI).toAbsolutePath().toString();
                String filePath = Paths.get(fileURI).toAbsolutePath().toString();
                PgDatabase db = PgDumpLoader.loadSchemasAndFile(projPath, filePath, 
                        prefs.get(UIConsts.PROJ_PREF.ENCODING, UIConsts.UTF_8),
                        false, false, ParserClass.ANTLR);
                fillRefs(objReferences, db.getObjReferences());
                fillRefs(objDefinitions, db.getObjDefinitions());
                return Status.OK_STATUS;
            }
        };
        job.setSystem(true);
        job.schedule();
    }

    protected void fillRefs(CopyOnWriteArrayList<PgObjLocation> oldRefs,
            Collection<PgObjLocation> newRefs) {
        CopyOnWriteArrayList<PgObjLocation> remove = new CopyOnWriteArrayList<>(); 
        for (PgObjLocation ref : newRefs) {
            for (PgObjLocation oldRef : oldRefs) {
                if (oldRef.getFilePath().equals(ref.getFilePath())) {
                    remove.add(oldRef);
                }
            }
        }
        oldRefs.removeAll(remove);
        oldRefs.addAll(newRefs);
    }

    @Override
    protected IProject[] build(int kind, Map<String, String> args,
            IProgressMonitor monitor) throws CoreException {
        this.proj = getProject();
        if (!proj.hasNature(NATURE.ID)) {
            return null;    
        }
        switch (kind) {
        case IncrementalProjectBuilder.AUTO_BUILD:
        case IncrementalProjectBuilder.CLEAN_BUILD:
        case IncrementalProjectBuilder.FULL_BUILD:
        case IncrementalProjectBuilder.INCREMENTAL_BUILD:
            PgDbParser.getParser(proj).getObjFromProject();
            break;
        }
        List<IProject> list = new ArrayList<>();
        list.add(proj);
        return list.toArray(new IProject[list.size()]);
    }
}
