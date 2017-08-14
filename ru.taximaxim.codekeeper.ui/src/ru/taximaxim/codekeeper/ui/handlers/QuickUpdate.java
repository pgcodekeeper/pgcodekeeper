package ru.taximaxim.codekeeper.ui.handlers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.part.FileEditorInput;

import cz.startnet.utils.pgdiff.PgDiff;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffScript;
import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcLoader;
import cz.startnet.utils.pgdiff.loader.JdbcRunner;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.JDBC_CONSTS;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.licensing.License;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.differ.DiffTableViewer;
import ru.taximaxim.codekeeper.ui.fileutils.ProjectUpdater;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.sqledit.RollOnEditor;

public class QuickUpdate extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

        if(!((editor instanceof RollOnEditor)
                && (editor.getEditorInput() instanceof FileEditorInput)
                && ((FileEditorInput)editor.getEditorInput()).getURI().getPath().contains("SCHEMA"))){
            return null;
        }

        editor.doSave(new NullProgressMonitor());

        DbInfo dbInfo = ((RollOnEditor)editor).getDbInfo();
        if (dbInfo == null){
            ExceptionNotifier.notifyDefault(Messages.sqlScriptDialog_script_select_storage, null);
            return null;
        }

        new QuickUpdateJob(Messages.quickUpdate_process, editor, dbInfo).schedule();
        return null;
    }

    private class QuickUpdateJob extends Job {
        private JdbcConnector connector;
        private PgDiffArguments args;
        private final IEditorPart editor;
        private final DbInfo dbInfo;
        private String primarySqlText;
        private PgDbProject pgDbProject;
        private IProject project;
        private String schemaNameProjectFragment;

        public QuickUpdateJob(String name, IEditorPart editor, DbInfo dbInfo) {
            super(name);
            this.editor = editor;
            this.dbInfo = dbInfo;
        }

        @Override
        protected IStatus run(IProgressMonitor monitor) {
            try {
                connector = new JdbcConnector(
                        dbInfo.getDbHost(), dbInfo.getDbPort(), dbInfo.getDbUser(), dbInfo.getDbPass(), dbInfo.getDbName(),
                        ApgdiffConsts.UTF_8, ApgdiffConsts.UTC);

                args = new PgDiffArguments();
                args.setLicense(new License(Activator.getDefault().getPreferenceStore().getString(PREF.LICENSE_PATH)));
                args.setInCharsetName(ApgdiffConsts.UTF_8);
                args.setCheckFunctionBodies(false);

                Log.log(Log.LOG_DEBUG, "QuickUpdate starting"); //$NON-NLS-1$

                pgDbProject = new PgDbProject(((IFileEditorInput)editor.getEditorInput()).getFile().getProject());

                if(rollChangesOnDB()){
                    rollChangesOnProject();
                }
            } catch (InterruptedException e) {
                return Status.CANCEL_STATUS;
            } catch (IOException | LicenseException | CoreException e) {
                ExceptionNotifier.notifyDefault(Messages.quickUpdate_error_btn, e);
                return new Status(Status.ERROR, PLUGIN_ID.THIS,
                        Messages.quickUpdate_error_btn, e);
            }
            return Status.OK_STATUS;
        }

        private boolean rollChangesOnDB()
                throws IOException, InterruptedException, LicenseException, CoreException {
            primarySqlText = ((RollOnEditor)editor).getEditorSourceViewer().getDocument().get();

            if(primarySqlText.isEmpty()){
                showWarningMessage(Messages.sqlScriptDialog_script_is_empty);
                return false;
            }

            PgDatabase dbProjectFragment = getDbProjectFragment(args,
                    ((FileEditorInput)editor.getEditorInput()).getURI().getPath(),
                    primarySqlText);

            PgDatabase dbProjectFull = DbSource.fromProject(pgDbProject).get(SubMonitor.convert(null, "", 1));

            Map<String, PgStatement> listPgObjectsFragment = PgDatabase.listPgObjects(dbProjectFragment);

            for(Entry<String, PgStatement> entry : listPgObjectsFragment.entrySet()){
                PgStatement parent = entry.getValue().getParent();
                if(parent != null
                        && parent.getStatementType() == DbObjType.SCHEMA
                        && !parent.getName().equals(schemaNameProjectFragment)){
                    showWarningMessage(Messages.sqlScriptDialog_script_contains_statements_that_may_modify_data_use_basic);
                    return false;
                }
            }

            PgDatabase dbRemoteFull = new JdbcLoader(connector, args).getDbFromJdbc();
            TreeElement treeFull = DiffTree.create(dbRemoteFull, dbProjectFull, null);

            List<TreeElement> checked = setCheckedFromFragment(treeFull, listPgObjectsFragment);

            if( (checked.size() == 1
                    && checked.get(0).getType() == DbObjType.SCHEMA
                    && checked.get(0).getSide() == DiffSide.BOTH)
                    || checked.size() == 0 ){
                showWarningMessage(Messages.sqlScriptDialog_script_have_no_changes);
                return false;
            }

            ByteArrayOutputStream diffInput = new ByteArrayOutputStream();
            PrintWriter writer = new UnixPrintWriter(diffInput, true);
            PgDiffScript script = PgDiff.diffDatabaseSchemasAdditionalDepcies(writer, args, treeFull,
                    dbRemoteFull, dbProjectFull, null, null);
            writer.flush();

            if (script.isDangerDdl(false, false, false, false)) {
                showWarningMessage(Messages.sqlScriptDialog_script_contains_statements_that_may_modify_data_use_basic);
                return false;
            }

            String result = new JdbcRunner(connector).runScript(diffInput.toString());

            if(!JDBC_CONSTS.JDBC_SUCCESS.equals(result)){
                ExceptionNotifier.notifyDefault(result, null);
                return false;
            }
            return true;
        }

        private void rollChangesOnProject()
                throws IOException, InterruptedException, LicenseException, CoreException {
            PgDatabase dbProjectFragment = getDbProjectFragment(args,
                    ((FileEditorInput)editor.getEditorInput()).getURI().getPath(),
                    ((RollOnEditor)editor).getEditorSourceViewer().getDocument().get());

            PgDatabase dbProjectFull = DbSource.fromProject(pgDbProject).get(SubMonitor.convert(null, "", 1));
            PgDatabase dbRemoteFull = new JdbcLoader(connector, args).getDbFromJdbc();
            TreeElement treeFull = DiffTree.create(dbRemoteFull, dbProjectFull, null);

            List<TreeElement> checked = setCheckedFromFragment(treeFull, PgDatabase.listPgObjects(dbProjectFragment));

            project = pgDbProject.getProject();
            String finalSqlText = ((RollOnEditor)editor).getEditorSourceViewer().getDocument().get();
            if(primarySqlText.equals(finalSqlText)){
                PgDbProject proj = new PgDbProject(((IFileEditorInput)editor.getEditorInput()).getFile().getProject());
                new ProjectUpdater(dbRemoteFull, dbProjectFull, checked, proj).updatePartial();
                project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
                ResourceUtil.getResource(editor.getEditorInput()).refreshLocal(IResource.DEPTH_ZERO, null);
            } else {
                project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            }
        }

        private PgDatabase getDbProjectFragment(PgDiffArguments args, String pathFileInEditor, String sqlText)
                throws IOException, InterruptedException, LicenseException {
            PgDatabase dbDump = null;

            schemaNameProjectFragment = pathFileInEditor.substring(pathFileInEditor.indexOf("/SCHEMA/"), pathFileInEditor.length())
                    .replace("/SCHEMA/", "");
            if(schemaNameProjectFragment.contains("/")){
                schemaNameProjectFragment = schemaNameProjectFragment.substring(0, schemaNameProjectFragment.indexOf("/"));
            } else {
                schemaNameProjectFragment = schemaNameProjectFragment.substring(0, schemaNameProjectFragment.indexOf(".sql"));
            }

            try(InputStream inputStream = new ByteArrayInputStream(sqlText.getBytes(StandardCharsets.UTF_8));
                    PgDumpLoader loader = new PgDumpLoader(inputStream, pathFileInEditor, args)) {
                if("PUBLIC".equalsIgnoreCase(schemaNameProjectFragment)){
                    dbDump = loader.load();
                } else {
                    dbDump = loader.load(schemaNameProjectFragment);
                }
            }
            return dbDump;
        }

        /**
         * элементы в объекте TreeElement treeFull, совпадающие с
         * переданными в Map<String, PgStatement> listPgObjectsFragment
         * помечаются как выбранные.
         *
         * @return возвращает коллекцию содержащую TreeElement'ы, которые
         * были помеченны как выбранные.
         */
        private List<TreeElement> setCheckedFromFragment(TreeElement treeFull, Map<String, PgStatement> listPgObjectsFragment) {
            List<TreeElement> checked = new ArrayList<>();

            for(Entry<String, PgStatement> entry : listPgObjectsFragment.entrySet()){
                TreeElement treeElement = treeFull.findElement(entry.getValue());
                if(treeElement != null){
                    if (DiffTableViewer.isContainer(treeElement)) {
                        treeElement.getChildren().forEach(e -> {
                            e.setSelected(true);
                            checked.add(e);
                        });
                    }
                    treeElement.setSelected(true);
                    checked.add(treeElement);
                }
            }

            return checked;
        }

        private void showWarningMessage(String message){
            UiSync.exec(PlatformUI.getWorkbench().getDisplay(), new Runnable() {
                @Override
                public void run() {
                    MessageBox mb = new MessageBox(editor.getSite().getShell(), SWT.ICON_WARNING | SWT.OK);
                    mb.setText(Messages.sqlScriptDialog_warning);
                    mb.setMessage(message);
                    mb.open();
                }
            });
        }
    }
}