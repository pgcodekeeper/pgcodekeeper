/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.handlers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
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
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.progress.IProgressConstants2;
import org.pgcodekeeper.core.Consts;
import org.pgcodekeeper.core.DangerStatement;
import org.pgcodekeeper.core.DatabaseType;
import org.pgcodekeeper.core.loader.AbstractJdbcConnector;
import org.pgcodekeeper.core.loader.JdbcRunner;
import org.pgcodekeeper.core.model.difftree.DbObjType;
import org.pgcodekeeper.core.model.difftree.TreeElement;
import org.pgcodekeeper.core.parsers.antlr.base.ScriptParser;
import org.pgcodekeeper.core.schema.AbstractDatabase;
import org.pgcodekeeper.core.schema.AbstractFunction;
import org.pgcodekeeper.core.schema.PgStatement;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfoJdbcConnector;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.differ.TreeDiffer;
import ru.taximaxim.codekeeper.ui.job.SingletonEditorJob;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.UIProjectLoader;
import ru.taximaxim.codekeeper.ui.properties.UISettings;
import ru.taximaxim.codekeeper.ui.propertytests.QuickUpdateJobTester;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;
import ru.taximaxim.codekeeper.ui.utils.ProjectUtils;
import ru.taximaxim.codekeeper.ui.utils.UIMonitor;
import ru.taximaxim.codekeeper.ui.utils.UIProjectUpdater;

public final class QuickUpdate extends AbstractHandler {

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
        quickUpdateJob.setProperty(IProgressConstants2.SHOW_IN_TASKBAR_ICON_PROPERTY, Boolean.TRUE);
        quickUpdateJob.setUser(true);
        quickUpdateJob.schedule();
        editor.saveLastDb(dbInfo);

        return null;
    }

    @Override
    public boolean isEnabled() {
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        return editor instanceof SQLEditor && ProjectUtils.isInProject(editor.getEditorInput());
    }
}

class QuickUpdateJob extends SingletonEditorJob {

    private static final int STEPS = 7;

    private final IFile file;
    private final PgDbProject proj;
    private final DbInfo dbInfo;
    private final byte[] textSnapshot;
    private SubMonitor monitor;

    public QuickUpdateJob(IFile file, DbInfo dbInfo, byte[] textSnapshot, SQLEditor editor) {
        super(Messages.QuickUpdate_quick_update, editor, QuickUpdateJobTester.EVAL_PROP);
        this.file = file;
        this.proj = new PgDbProject(file.getProject());
        this.dbInfo = dbInfo;
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
            return new Status(IStatus.ERROR, PLUGIN_ID.THIS, Messages.QuickUpdate_error, e);
        } finally {
            monitor.done();
        }
        return Status.OK_STATUS;
    }

    private void doRun() throws IOException, InterruptedException,
    CoreException, PgCodekeeperUIException, InvocationTargetException {
        DatabaseType dbType = ProjectUtils.getDatabaseType(proj.getProject());

        if (dbInfo.getDbType() != dbType) {
            throw new PgCodekeeperUIException(Messages.QuickUpdate_different_types);
        }

        boolean isSchemaFile = ProjectUtils.isSchemaFile(file.getProjectRelativePath(), dbType);
        IEclipsePreferences projPrefs = proj.getPrefs();
        String timezone = projPrefs.get(PROJ_PREF.TIMEZONE, Consts.UTC);

        AbstractDatabase dbProjectFragment = UIProjectLoader
                .buildFiles(Arrays.asList(file), dbType, monitor.newChild(1));
        Collection<PgStatement> listPgObjectsFragment = dbProjectFragment.getDescendants().toList();

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

        var settings = new UISettings(null, null);
        DbSource dbRemote = DbSource.fromDbInfo(dbInfo, proj.getProjectCharset(), timezone, proj.getProject());
        DbSource dbProject = DbSource.fromProject(proj);

        TreeDiffer treediffer = new TreeDiffer(settings, dbRemote, dbProject);
        treediffer.run(monitor.newChild(1));
        TreeElement treeFull = treediffer.getDiffTree();
        Collection<TreeElement> checked = setCheckedFromFragment(treeFull,
                listPgObjectsFragment, dbRemote.getDbObject(), dbProject.getDbObject());

        if (checked.isEmpty()) {
            Log.log(Log.LOG_INFO, "No object changes found when comparing to DB"); //$NON-NLS-1$
            return;
        }

        Differ differ = new Differ(dbRemote.getDbObject(), dbProject.getDbObject(), treeFull, timezone, proj.getProject());
        differ.run(monitor.newChild(1));

        checkFileModified();

        monitor.newChild(1).subTask(Messages.QuickUpdate_updating_db);

        AbstractJdbcConnector connector = new DbInfoJdbcConnector(dbInfo);

        try {
            ScriptParser parser = new ScriptParser(file.getName(), differ.getDiffDirect(),
                    new UISettings(proj.getProject(), null));
            String error = parser.getErrorMessage();
            if (error != null) {
                throw new PgCodekeeperUIException(error);
            }

            if (parser.isDangerDdl(EnumSet.noneOf(DangerStatement.class))) {
                throw new PgCodekeeperUIException(Messages.QuickUpdate_danger);
            }

            new JdbcRunner(new UIMonitor(monitor)).runBatches(connector, parser.batch(), null);
        } catch (SQLException e) {
            throw new PgCodekeeperUIException(Messages.QuickUpdate_migration_failed + e.getLocalizedMessage());
        }

        checkFileModified();

        TreeDiffer treedifferAfter = new TreeDiffer(settings, DbSource.fromDbObject(dbProject), dbRemote);
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
        var updater = new UIProjectUpdater(dbRemote.getDbObject(),
                dbProject.getDbObject(), checkedAfter,
                proj, false);
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
            Collection<PgStatement> listPgObjectsFragment, AbstractDatabase left, AbstractDatabase right) {
        // mark schemas only when there are no schema-nested objects
        boolean markSchemas = listPgObjectsFragment.stream()
                .map(PgStatement::getStatementType)
                .allMatch(ty -> ty == DbObjType.SCHEMA
                || ty == DbObjType.EXTENSION
                || ty == DbObjType.CAST
                || ty == DbObjType.EVENT_TRIGGER);

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
            case TABLE, VIEW:
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
            AbstractDatabase left, AbstractDatabase right) {
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
