package ru.taximaxim.codekeeper.ui.pgdbproject.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.parsers.antlr.FunctionBodyContainer;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.LicensePrefs;

public class PgDbParser implements IResourceChangeListener {

    private static final ConcurrentMap<IProject, PgDbParser> PROJ_PARSERS = new ConcurrentHashMap<>();

    private final ConcurrentMap<String, List<PgObjLocation>> objDefinitions = new ConcurrentHashMap<>();
    private final ConcurrentMap<String, List<PgObjLocation>> objReferences = new ConcurrentHashMap<>();
    private final IProject proj;
    private final List<Listener> listeners = new ArrayList<>();

    private PgDbParser(IProject proj) {
        this.proj = proj;
        if (proj != null) {
            ResourcesPlugin.getWorkspace().addResourceChangeListener(this,
                    IResourceChangeEvent.PRE_CLOSE | IResourceChangeEvent.PRE_DELETE);
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
        parser.getFullDBFromPgDbProjectJob(proj);
        PROJ_PARSERS.put(proj, parser);
        return parser;
    }

    /**
     * @return existing parser or null if parser was fully created by this call
     * @throws InterruptedException
     * @throws IOException
     */
    public static PgDbParser getParserForBuilder(IProject proj, IProgressMonitor builderMonitor)
            throws InterruptedException, IOException, LicenseException, CoreException {
        PgDbParser parser = PROJ_PARSERS.get(proj);
        if (parser != null) {
            return parser;
        }

        parser = new PgDbParser(proj);
        parser.getFullDBFromPgDbProject(proj, builderMonitor);
        PROJ_PARSERS.put(proj, parser);
        // signify newly loaded parser
        return null;
    }

    public static PgDbParser getRollOnParser(InputStream input,
            String scriptFileEncoding, IProgressMonitor monitor)
                    throws InterruptedException, IOException, LicenseException {
        PgDbParser rollOnParser = new PgDbParser();
        rollOnParser.fillRefsFromInputStream(input, monitor, scriptFileEncoding);
        return rollOnParser;
    }

    public void getObjFromProject(IProgressMonitor monitor)
            throws InterruptedException, IOException, LicenseException, CoreException {
        getFullDBFromPgDbProject(proj, monitor);
    }

    public void getObjFromProjFile(IFile iFile, IProgressMonitor monitor)
            throws InterruptedException, IOException, LicenseException, CoreException {
        String charset = ApgdiffConsts.UTF_8;
        try {
            charset = proj.getDefaultCharset(true);
        } catch (CoreException e) {
            Log.log(e);
        }
        PgDiffArguments args = new PgDiffArguments();
        LicensePrefs.setLicense(args);
        args.setInCharsetName(charset);
        try (PgUIDumpLoader loader = new PgUIDumpLoader(iFile, args, monitor)) {
            PgDatabase db = loader.loadFile(true, new PgDatabase());
            objDefinitions.putAll(db.getObjDefinitions());
            objReferences.putAll(db.getObjReferences());
            fillFunctionBodies(objDefinitions, objReferences, loader.getFuncBodyReferences());
        }
    }

    public void updateRefsFromInputStream(InputStream stream, String filename) throws InterruptedException, IOException, LicenseException {
        PgDiffArguments args = new PgDiffArguments();
        LicensePrefs.setLicense(args);
        args.setInCharsetName(ApgdiffConsts.UTF_8);
        PgDatabase db;
        try (PgDumpLoader loader = new PgDumpLoader(stream, filename, args, null, 2)) {
            db = loader.load(true);
        }
        objReferences.putAll(db.getObjReferences());
    }

    private static void fillFunctionBodies(Map<String, List<PgObjLocation>> objDefinitions2,
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

    private void getFullDBFromPgDbProjectJob(final IProject pgProject) {
        try {
            pgProject.build(0, new NullProgressMonitor());
        } catch (CoreException e) {
            Log.log(e);
        }
    }

    private void getFullDBFromPgDbProject(IProject pgProject, IProgressMonitor monitor)
            throws InterruptedException, IOException, LicenseException, CoreException {
        List<FunctionBodyContainer> funcBodies = new ArrayList<>();
        String charset = ApgdiffConsts.UTF_8;
        try {
            charset = proj.getDefaultCharset(true);
        } catch (CoreException e) {
            Log.log(e);
        }
        PgDiffArguments args = new PgDiffArguments();
        LicensePrefs.setLicense(args);
        args.setInCharsetName(charset);
        PgDatabase db = PgUIDumpLoader.loadDatabaseSchemaFromIProject(
                pgProject.getProject(), args, monitor, funcBodies);
        objDefinitions.clear();
        objDefinitions.putAll(db.getObjDefinitions());
        objReferences.clear();
        objReferences.putAll(db.getObjReferences());
        fillFunctionBodies(objDefinitions, objReferences, funcBodies);
        notifyListeners();
    }

    public void removePathFromRefs(String path) {
        String p = path.toString();
        objReferences.remove(p);
        objDefinitions.remove(p);
    }

    private void fillRefsFromInputStream(InputStream input,
            IProgressMonitor monitor, String scriptFileEncoding)
                    throws InterruptedException, IOException, LicenseException {
        PgDiffArguments args = new PgDiffArguments();
        LicensePrefs.setLicense(args);
        args.setInCharsetName(scriptFileEncoding);
        PgDatabase db;
        try (PgDumpLoader loader = new PgDumpLoader(input, "bytestream:/", args, monitor, 2)) { //$NON-NLS-1$
            db = loader.load(true);
        }
        objDefinitions.clear();
        objDefinitions.putAll(db.getObjDefinitions());
        objReferences.clear();
        objReferences.putAll(db.getObjReferences());
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

    public List<PgObjLocation> getObjsForPath(String pathToFile) {
        List<PgObjLocation> locations = new ArrayList<>();
        List<PgObjLocation> refs = objReferences.get(pathToFile);
        if (refs == null) {
            return locations;
        }
        for (PgObjLocation loc : refs) {
            if (loc.getFilePath().equals(pathToFile.toString())
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
        for (List<PgObjLocation> list : refs.values()) {
            results.addAll(list);
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
            if (PROJ_PARSERS.containsKey(event.getResource())) {
                PROJ_PARSERS.remove(event.getResource());
                ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
            }
            break;
        default : break;
        }
    }

    public static IStatus getLoadingErroStatus(Exception ex) {
        return new Status(IStatus.ERROR, PLUGIN_ID.THIS, Messages.PgDbParser_error_loading_db, ex);
    }
}
