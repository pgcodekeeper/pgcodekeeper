package ru.taximaxim.codekeeper.ui.handlers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.ResourceUtil;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcRunner;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.JDBC_CONSTS;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.differ.TreeDiffer;
import ru.taximaxim.codekeeper.ui.fileutils.ProjectUpdater;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgUIDumpLoader;
import ru.taximaxim.codekeeper.ui.sqledit.RollOnEditor;

public class QuickUpdate extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        RollOnEditor editor = (RollOnEditor) HandlerUtil.getActiveEditor(event);
        // TODO replace with pulldown menu+param
        DbInfo dbInfo = editor.getDbInfo();
        if (dbInfo == null){
            ExceptionNotifier.notifyDefault(Messages.sqlScriptDialog_script_select_storage, null);
            return null;
        }

        IFile file = ResourceUtil.getFile(editor.getEditorInput());
        editor.doSave(new NullProgressMonitor());
        byte[] textSnapshot;
        try {
            textSnapshot = editor.getEditorText().getBytes(file.getCharset());
        } catch (UnsupportedEncodingException | CoreException e) {
            ExceptionNotifier.notifyDefault("Error getting file charset!", e);
            return null;
        }
        new QuickUpdateJob(file, dbInfo, textSnapshot).schedule();
        return null;
    }

    @Override
    public boolean isEnabled() {
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        IEditorInput input = editor.getEditorInput();
        return editor instanceof RollOnEditor && input instanceof IFileEditorInput
                && ResourceUtil.getFile(input).getLocation().toOSString().contains("SCHEMA");
        // TODO replace last condition with PgUiDumpLoader's project file check
    }
}

class QuickUpdateJob extends Job {

    private static final int STEPS = 7;

    private final IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
    private final IFile file;
    private final PgDbProject proj;
    private final DbInfo dbinfo;
    private final byte[] textSnapshot;
    private SubMonitor monitor;

    public QuickUpdateJob(IFile file, DbInfo dbInfo, byte[] textSnapshot) {
        super(Messages.quickUpdate_process);
        this.file = file;
        this.proj = new PgDbProject(file.getProject());
        this.dbinfo = dbInfo;
        this.textSnapshot = textSnapshot;
    }

    @Override
    protected IStatus run(IProgressMonitor monitor) {
        try {
            Log.log(Log.LOG_INFO, "QuickUpdate starting"); //$NON-NLS-1$
            this.monitor = SubMonitor.convert(monitor, "Quick Update", STEPS);

            doRun();
        } catch (InterruptedException e) {
            return Status.CANCEL_STATUS;
        } catch (IOException | LicenseException | CoreException | PgCodekeeperUIException | InvocationTargetException e) {
            ExceptionNotifier.notifyDefault(Messages.quickUpdate_error_btn, e);
            return new Status(Status.ERROR, PLUGIN_ID.THIS, Messages.quickUpdate_error_btn, e);
        } finally {
            monitor.done();
        }
        return Status.OK_STATUS;
    }

    private void doRun() throws IOException, InterruptedException,
    LicenseException, CoreException, PgCodekeeperUIException, InvocationTargetException {
        boolean isSchemaFile = PgUIDumpLoader.isSchemaFile(file.getProjectRelativePath());
        String timezone = proj.getPrefs().get(PROJ_PREF.TIMEZONE, ApgdiffConsts.UTC);

        PgDatabase dbProjectFragment = getDbProjectFragment();
        Collection<PgStatement> listPgObjectsFragment = PgDatabase.listPgObjects(dbProjectFragment).values();

        long schemaCount = listPgObjectsFragment.stream()
                .filter(st -> st.getStatementType() == DbObjType.SCHEMA).count();
        if (schemaCount > 1) {
            // more than 1 schema, shoudln't happen
            throw new PgCodekeeperUIException("More than 1 schema loaded, invalid behaviour!");
        } else if (schemaCount == listPgObjectsFragment.size() && !isSchemaFile) {
            // no objects (schemaCount == 0), or
            // only schema loaded but not a schema file: probably a search_path-only file
            // TODO msg
            throw new PgCodekeeperUIException(Messages.sqlScriptDialog_script_is_empty);
        }

        checkFileModified();

        DbSource dbRemote = DbSource.fromDbInfo(dbinfo, prefs,
                proj.getPrefs().getBoolean(PROJ_PREF.FORCE_UNIX_NEWLINES, true),
                proj.getProjectCharset(), timezone);
        DbSource dbProject = DbSource.fromProject(proj);

        TreeDiffer treediffer = new TreeDiffer(dbRemote, dbProject, false);
        // TODO this resets task name
        // maybe SUPPRESS_BEGINTASK ?
        treediffer.run(monitor.newChild(1));
        TreeElement treeFull = treediffer.getDiffTree();
        Collection<TreeElement> checked = setCheckedFromFragment(treeFull, listPgObjectsFragment);

        if (checked.isEmpty()) {
            // no diff
            throw new PgCodekeeperUIException(Messages.sqlScriptDialog_script_have_no_changes);
        }

        Differ differ = new Differ(dbRemote.getDbObject(), dbProject.getDbObject(),
                treeFull, false, timezone);
        // TODO this resets task name
        // maybe SUPPRESS_BEGINTASK ?
        differ.run(monitor.newChild(1));

        if (differ.getScript().isDangerDdl(false, false, false, false)) {
            throw new PgCodekeeperUIException(Messages.sqlScriptDialog_script_contains_statements_that_may_modify_data_use_basic);
        }

        checkFileModified();

        monitor.newChild(1).subTask("Updating DB");
        JdbcRunner runner = new JdbcRunner(new JdbcConnector(
                dbinfo.getDbHost(), dbinfo.getDbPort(),
                dbinfo.getDbUser(), dbinfo.getDbPass(), dbinfo.getDbName(),
                ApgdiffConsts.UTF_8, ApgdiffConsts.UTC));
        String result = runner.runScript(differ.getDiffDirect());

        if(!JDBC_CONSTS.JDBC_SUCCESS.equals(result)) {
            throw new PgCodekeeperUIException("Failed to migrate objects to DB: " + result);
        }

        checkFileModified();

        TreeDiffer treedifferAfter = new TreeDiffer(dbRemote, DbSource.fromDbObject(dbProject), false);
        // TODO this resets task name
        // maybe SUPPRESS_BEGINTASK ?
        treedifferAfter.run(monitor.newChild(1));
        TreeElement treeAfter = treedifferAfter.getDiffTree();

        Collection<TreeElement> checkedAfter = setCheckedFromFragment(
                treeAfter, listPgObjectsFragment);
        if (checkedAfter.isEmpty()) {
            // success, no export needed, Postgres didn't make any alterations
            return;
        }

        monitor.newChild(1).subTask("Updating Project");
        ProjectUpdater updater = new ProjectUpdater(
                dbRemote.getDbObject(), dbProject.getDbObject(), checkedAfter, proj);
        checkFileModified();
        updater.updatePartial();

        file.refreshLocal(IResource.DEPTH_INFINITE, monitor.newChild(1));
    }

    private PgDatabase getDbProjectFragment()
            throws IOException, InterruptedException, LicenseException, CoreException {
        try(PgUIDumpLoader loader = new PgUIDumpLoader(file, new PgDiffArguments(), monitor.newChild(1))) {
            // TODO schema-aware loading
            return loader.load();
        }
    }

    /**
     * элементы в объекте TreeElement treeFull, совпадающие с
     * переданными в Map<String, PgStatement> listPgObjectsFragment
     * помечаются как выбранные.
     *
     * @return возвращает коллекцию содержащую TreeElement'ы, которые
     * были помечены как выбранные.
     */
    private Collection<TreeElement> setCheckedFromFragment(TreeElement treeFull,
            Collection<PgStatement> listPgObjectsFragment) {
        // mark schemas only when there are no schema-nested objects
        boolean markSchemas = ! listPgObjectsFragment.stream().anyMatch(
                st -> st.getStatementType() != DbObjType.SCHEMA && st.getStatementType() != DbObjType.EXTENSION);

        Set<TreeElement> checked = new HashSet<>();
        for (PgStatement st : listPgObjectsFragment){
            TreeElement el = treeFull.findElement(st);
            if(el == null){
                continue;
            }
            // mark all objects sharing same files:
            // children of tables, views, overloads of functions
            switch (el.getType()) {
            case FUNCTION:
                markFunctions((PgFunction) st, treeFull, checked);
                break;
            case TABLE:
            case VIEW:
                el.getChildren().forEach(child -> {
                    child.setSelected(true);
                    checked.add(child);
                });
                break;
            default:
                break;
            }

            if (el.getType() != DbObjType.SCHEMA || markSchemas) {
                el.setSelected(true);
                checked.add(el);
            }
        }

        return checked;
    }

    private void markFunctions(PgFunction func, TreeElement treeFull, Set<TreeElement> checked) {
        for (PgFunction f : func.getContainingSchema().getFunctions()) {
            if (f.getBareName().equals(func.getBareName())) {
                TreeElement overload = treeFull.findElement(f);
                if (overload != null) {
                    overload.setSelected(true);
                    checked.add(overload);
                }
            }
        }
    }

    /**
     * Use before major job steps to avoid time waste.
     * @throws PgCodekeeperUIException when file on disk differs from {@link #textSnapshot}
     */
    private void checkFileModified() throws IOException, PgCodekeeperUIException {
        if (!Arrays.equals(textSnapshot, Files.readAllBytes(Paths.get(file.getLocationURI())))) {
            throw new PgCodekeeperUIException("File was changed during the operation. Aborting.");
        }
    }
}
