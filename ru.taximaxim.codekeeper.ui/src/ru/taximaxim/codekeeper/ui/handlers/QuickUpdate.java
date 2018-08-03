package ru.taximaxim.codekeeper.ui.handlers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.ResourceUtil;

import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcRunner;
import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.differ.ClassicTreeDiffer;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.differ.TreeDiffer;
import ru.taximaxim.codekeeper.ui.fileutils.ProjectUpdater;
import ru.taximaxim.codekeeper.ui.job.SingletonEditorJob;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgUIDumpLoader;
import ru.taximaxim.codekeeper.ui.propertytests.QuickUpdateJobTester;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class QuickUpdate extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        SQLEditor editor = (SQLEditor) HandlerUtil.getActiveEditor(event);
        DbInfo dbInfo = editor.getCurrentDb();
        if (dbInfo == null){
            ExceptionNotifier.notifyDefault(Messages.sqlScriptDialog_script_select_storage, null);
            return null;
        }

        if (dbInfo.isReadOnly()) {
            MessageBox mb = new MessageBox(HandlerUtil.getActiveShell(event), SWT.ICON_INFORMATION);
            mb.setText(Messages.UpdateDdl_read_only_db_title);
            mb.setMessage(Messages.UpdateDdl_read_only_db_message);
            mb.open();
            return null;
        }

        String text = editor.getEditorText();
        if (text.trim().isEmpty()) {
            ExceptionNotifier.notifyDefault(Messages.QuickUpdate_empty_script, null);
            return null;
        }

        IFile file = ResourceUtil.getFile(editor.getEditorInput());
        editor.doSave(new NullProgressMonitor());
        byte[] textSnapshot;
        try {
            textSnapshot = text.getBytes(file.getCharset());
        } catch (UnsupportedEncodingException | CoreException e) {
            ExceptionNotifier.notifyDefault(Messages.QuickUpdate_error_charset, e);
            return null;
        }

        QuickUpdateJob quickUpdateJob = new QuickUpdateJob(file, dbInfo, textSnapshot, editor);
        quickUpdateJob.setUser(true);
        quickUpdateJob.schedule();
        editor.saveLastDb(dbInfo);

        return null;
    }

    @Override
    public boolean isEnabled() {
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        return editor instanceof SQLEditor && PgUIDumpLoader.isInProject(editor.getEditorInput());
    }
}

class QuickUpdateJob extends SingletonEditorJob {

    private static final int STEPS = 7;

    private final IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
    private final IFile file;
    private final PgDbProject proj;
    private final DbInfo dbinfo;
    private final byte[] textSnapshot;
    private SubMonitor monitor;

    public QuickUpdateJob(IFile file, DbInfo dbInfo, byte[] textSnapshot, SQLEditor editor) {
        super(Messages.QuickUpdate_quick_update, editor, QuickUpdateJobTester.EVAL_PROP);
        this.file = file;
        this.proj = new PgDbProject(file.getProject());
        this.dbinfo = dbInfo;
        this.textSnapshot = textSnapshot;
    }

    @Override
    protected IStatus run(IProgressMonitor monitor) {
        try {
            Log.log(Log.LOG_INFO, "QuickUpdate starting"); //$NON-NLS-1$
            this.monitor = SubMonitor.convert(monitor, STEPS);

            doRun();
        } catch (InterruptedException e) {
            return Status.CANCEL_STATUS;
        } catch (IOException | CoreException | PgCodekeeperUIException | InvocationTargetException e) {
            return new Status(Status.ERROR, PLUGIN_ID.THIS, Messages.QuickUpdate_error, e);
        } finally {
            monitor.done();
        }
        return Status.OK_STATUS;
    }

    private void doRun() throws IOException, InterruptedException,
    CoreException, PgCodekeeperUIException, InvocationTargetException {
        boolean isSchemaFile = PgUIDumpLoader.isSchemaFile(file.getProjectRelativePath());
        String timezone = proj.getPrefs().get(PROJ_PREF.TIMEZONE, ApgdiffConsts.UTC);

        PgDatabase dbProjectFragment =
                PgUIDumpLoader.buildFiles(Arrays.asList(file), monitor.newChild(1), null);
        Collection<PgStatement> listPgObjectsFragment = dbProjectFragment.getDescendants().collect(Collectors.toList());

        long schemaCount = dbProjectFragment.getSchemas().size();
        if (schemaCount > 1) {
            // more than 1 schema, shoudln't happen
            throw new PgCodekeeperUIException(Messages.QuickUpdate_multiple_schemas);
        } else if (listPgObjectsFragment.isEmpty() ||
                (schemaCount == listPgObjectsFragment.size() && !isSchemaFile)) {
            // no objects (schemaCount == 0), or
            // only schema loaded but not a schema file: probably a search_path-only file
            throw new PgCodekeeperUIException(Messages.QuickUpdate_empty_script);
        }

        checkFileModified();

        DbSource dbRemote = DbSource.fromDbInfo(dbinfo, prefs,
                proj.getPrefs().getBoolean(PROJ_PREF.FORCE_UNIX_NEWLINES, true),
                proj.getProjectCharset(), timezone);
        DbSource dbProject = DbSource.fromProject(proj);

        TreeDiffer treediffer = new ClassicTreeDiffer(dbRemote, dbProject, false);
        treediffer.run(monitor.newChild(1));
        TreeElement treeFull = treediffer.getDiffTree();
        Collection<TreeElement> checked = setCheckedFromFragment(treeFull,
                listPgObjectsFragment, dbRemote.getDbObject(), dbProject.getDbObject());

        if (checked.isEmpty()) {
            Log.log(Log.LOG_INFO, "No object changes found when comparing to DB"); //$NON-NLS-1$
            return;
        }

        Differ differ = new Differ(dbRemote.getDbObject(), dbProject.getDbObject(),
                treeFull, false, timezone);
        differ.run(monitor.newChild(1));

        if (differ.getScript().isDangerDdl(false, false, false, false)) {
            throw new PgCodekeeperUIException(Messages.QuickUpdate_danger);
        }

        checkFileModified();

        monitor.newChild(1).subTask(Messages.QuickUpdate_updating_db);

        JdbcConnector connector = new JdbcConnector(dbinfo.getDbHost(), dbinfo.getDbPort(),
                dbinfo.getDbUser(), dbinfo.getDbPass(), dbinfo.getDbName(),
                dbinfo.getProperties(), dbinfo.isReadOnly(), ApgdiffConsts.UTF_8);

        try {
            new JdbcRunner(monitor).run(connector, differ.getDiffDirect());
        } catch (SQLException e) {
            throw new PgCodekeeperUIException(Messages.QuickUpdate_migration_failed + e.getLocalizedMessage());
        }

        checkFileModified();

        TreeDiffer treedifferAfter = new ClassicTreeDiffer(DbSource.fromDbObject(dbProject), dbRemote, false);
        treedifferAfter.run(monitor.newChild(1));
        TreeElement treeAfter = treedifferAfter.getDiffTree();

        Collection<TreeElement> checkedAfter = setCheckedFromFragment(treeAfter,
                listPgObjectsFragment, dbProject.getDbObject(), dbRemote.getDbObject());
        if (checkedAfter.isEmpty()) {
            // success, no export needed, Postgres didn't make any alterations
            return;
        }


        checkFileModified();

        monitor.newChild(1).subTask(Messages.QuickUpdate_updating_project);
        ProjectUpdater updater = new ProjectUpdater(
                dbRemote.getDbObject(), dbProject.getDbObject(), checkedAfter, proj);
        updater.updatePartial();

        file.refreshLocal(IResource.DEPTH_INFINITE, monitor.newChild(1));
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
            Collection<PgStatement> listPgObjectsFragment, PgDatabase left, PgDatabase right) {
        // mark schemas only when there are no schema-nested objects
        boolean markSchemas = listPgObjectsFragment.stream()
                .map(PgStatement::getStatementType)
                .allMatch(ty -> ty == DbObjType.SCHEMA || ty == DbObjType.EXTENSION);

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
                markFunctions((AbstractFunction) st, el, checked, left, right);
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

    private void markFunctions(AbstractFunction func, TreeElement elFunc, Set<TreeElement> checked,
            PgDatabase left, PgDatabase right) {
        // check every "adjacent" element for overload changes
        elFunc.getParent().getChildren().stream()
        .filter(el -> el.getType() == DbObjType.FUNCTION)
        .filter(el -> func.getBareName().equals(el.getPgStatementSide(left, right).getBareName()))
        .forEach(overload -> {
            overload.setSelected(true);
            checked.add(overload);
        });
    }

    /**
     * Use before major job steps to avoid time waste.
     * @throws PgCodekeeperUIException when file on disk differs from {@link #textSnapshot}
     */
    private void checkFileModified() throws IOException, PgCodekeeperUIException {
        if (!Arrays.equals(textSnapshot, Files.readAllBytes(Paths.get(file.getLocationURI())))) {
            throw new PgCodekeeperUIException(Messages.QuickUpdate_file_modified);
        }
    }
}