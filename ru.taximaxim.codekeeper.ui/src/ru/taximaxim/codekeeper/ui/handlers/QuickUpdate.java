package ru.taximaxim.codekeeper.ui.handlers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
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
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeFlattener;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.fileutils.ProjectUpdater;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.sqledit.RollOnEditor;

public class QuickUpdate extends AbstractHandler {
    @Override
    public Object execute(ExecutionEvent event) {
        IWorkbench wb = PlatformUI.getWorkbench();
        IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
        IWorkbenchPage page = win.getActivePage();
        IEditorPart editor = page.getActiveEditor();

        if(!isCorrectEditor(editor)){
            return null;
        }

        RollOnEditor rollOnEditor = (RollOnEditor)editor;
        DbInfo dbInfo = rollOnEditor.getStorePicker().getDbInfo();
        if (dbInfo == null){
            ExceptionNotifier.notifyDefault(Messages.sqlScriptDialog_script_select_storage, null);
            return null;
        }

        new QuickUpdateJob(Messages.quickUpdate_process, editor, dbInfo).schedule();
        return null;
    }

    private boolean isCorrectEditor(IEditorPart editor){
        if(!(editor instanceof RollOnEditor)){
            return false;
        }

        IEditorInput input = editor.getEditorInput();
        if(!(input instanceof FileEditorInput)){
            return false;
        }

        FileEditorInput fei = (FileEditorInput) input;
        if(!fei.getURI().getPath().contains("SCHEMA")){
            return false;
        }
        return true;
    }

    private class QuickUpdateJob extends Job {
        private JdbcConnector connector;
        private PgDiffArguments args;
        private final IEditorPart editor;
        private final DbInfo dbInfo;
        private String primarySqlText;

        public QuickUpdateJob(String name, IEditorPart editor, DbInfo dbInfo) {
            super(name);
            this.editor = editor;
            this.dbInfo = dbInfo;
        }

        @Override
        protected IStatus run(IProgressMonitor monitor) {
            try {
                executeQuickUpdate();
            } catch (IOException | LicenseException e) {
                ExceptionNotifier.notifyDefault(Messages.quickUpdate_error_btn, e);
                return new Status(Status.ERROR, PLUGIN_ID.THIS,
                        Messages.quickUpdate_error_btn, e);
            } catch (InterruptedException e) {
                return Status.CANCEL_STATUS;
            } catch (CoreException e) {
                ExceptionNotifier.notifyDefault(Messages.quickUpdate_error_btn, e);
                return new Status(Status.ERROR, PLUGIN_ID.THIS,
                        Messages.quickUpdate_error_btn, e);
            }

            return Status.OK_STATUS;
        }

        private void executeQuickUpdate() throws IOException, LicenseException, InterruptedException, CoreException {
            connector = new JdbcConnector(
                    dbInfo.getDbHost(), dbInfo.getDbPort(), dbInfo.getDbUser(), dbInfo.getDbPass(), dbInfo.getDbName(),
                    ApgdiffConsts.UTF_8, ApgdiffConsts.UTC);

            args = new PgDiffArguments();
            args.setLicense(new License(Activator.getDefault().getPreferenceStore().getString(PREF.LICENSE_PATH)));
            args.setInCharsetName(ApgdiffConsts.UTF_8);
            args.setCheckFunctionBodies(false);

            Log.log(Log.LOG_DEBUG, "QuickUpdate starting"); //$NON-NLS-1$

            if(rollChangesOnDB()){
                rollChangesOnProject();
            }
        }

        private boolean rollChangesOnDB()
                throws IOException, InterruptedException, LicenseException, CoreException {
            primarySqlText = ((RollOnEditor)editor).getSourceViewerForQuickUpdate().getDocument().get();

            PgDatabase dbProjectFragment = getDbProjectFragment(args,
                    ((FileEditorInput)editor.getEditorInput()).getURI(),
                    primarySqlText);

            PgDatabase dbProjectFull = getDbProjectFull(editor);
            PgDatabase dbRemoteFull = new JdbcLoader(connector, args).getDbFromJdbc();
            TreeElement treeFull = DiffTree.create(dbRemoteFull, dbProjectFull, null);

            setCheckedFromFragment(treeFull, PgDatabase.listPgObjects(dbProjectFragment), dbRemoteFull, dbProjectFull);

            ByteArrayOutputStream diffInput = new ByteArrayOutputStream();
            PgDiffScript script = getScript(diffInput, treeFull, dbRemoteFull, dbProjectFull);

            if (script.isDangerDdl(false, false, false, false)) {
                UiSync.exec(PlatformUI.getWorkbench().getDisplay(), new Runnable() {
                    @Override
                    public void run() {
                        MessageBox mb = new MessageBox(editor.getSite().getShell(), SWT.ICON_WARNING | SWT.OK);
                        mb.setText(Messages.sqlScriptDialog_warning);
                        mb.setMessage(Messages.sqlScriptDialog_script_contains_statements_that_may_modify_data_use_basic);
                        mb.open();
                    }
                });
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
                    ((FileEditorInput)editor.getEditorInput()).getURI(),
                    ((RollOnEditor)editor).getSourceViewerForQuickUpdate().getDocument().get());

            PgDatabase dbProjectFull = getDbProjectFull(editor);
            PgDatabase dbRemoteFull = new JdbcLoader(connector, args).getDbFromJdbc();
            TreeElement treeFull = DiffTree.create(dbRemoteFull, dbProjectFull, null);

            List<TreeElement> checked = setCheckedFromFragment(treeFull,
                    PgDatabase.listPgObjects(dbProjectFragment), dbRemoteFull, dbProjectFull);

            String finalSqlText = ((RollOnEditor)editor).getSourceViewerForQuickUpdate().getDocument().get();
            if(primarySqlText.equals(finalSqlText)){
                PgDbProject proj = new PgDbProject(((IFileEditorInput)editor.getEditorInput()).getFile().getProject());
                new ProjectUpdater(dbRemoteFull, dbProjectFull, checked, proj).updatePartial();
                ResourceUtil.getResource(editor.getEditorInput()).refreshLocal(IResource.DEPTH_ZERO, null);
            }
        }

        private PgDatabase getDbProjectFragment(PgDiffArguments args, URI fileInEditorURI, String sqlText)
                throws IOException, InterruptedException, LicenseException {
            PgDatabase dbDump = null;
            String schemaName = getSchemaName(fileInEditorURI.getPath());
            try(InputStream inputStream = new ByteArrayInputStream(sqlText.getBytes(StandardCharsets.UTF_8));
                    PgDumpLoader loader = new PgDumpLoader(inputStream, fileInEditorURI.getPath(), args)) {
                if("PUBLIC".equalsIgnoreCase(schemaName)){
                    dbDump = loader.load();
                } else {
                    dbDump = loader.load(getSchemaName(fileInEditorURI.getPath()));
                }
            }
            return dbDump;
        }

        private PgDatabase getDbProjectFull(IEditorPart editor)
                throws IOException, InterruptedException, LicenseException, CoreException {
            PgDbProject proj = new PgDbProject( ((IFileEditorInput)editor.getEditorInput()).getFile().getProject() );
            DbSource dbSource = DbSource.fromProject(proj);
            return dbSource.get(SubMonitor.convert(null, "", 1));
        }

        private PgDiffScript getScript(ByteArrayOutputStream diffInput,
                TreeElement treeFullwithCheckedElements,
                PgDatabase dbRemoteFull, PgDatabase dbProjectFull){
            PrintWriter writer = new UnixPrintWriter(diffInput, true);
            PgDiffScript script = PgDiff.diffDatabaseSchemasAdditionalDepcies(writer, args,
                    treeFullwithCheckedElements, dbRemoteFull, dbProjectFull, null, null);
            writer.flush();
            return script;
        }

        private String getSchemaName(String path){
            path = path.substring(path.indexOf("/SCHEMA/"), path.length());
            path = path.replace("/SCHEMA/", "");
            return path.substring(0, path.indexOf("/"));
        }

        /**
         * элементы в объекте TreeElement treeFull, совпадающие с
         * переданными в Map<String, PgStatement> listPgObjectsFragment
         * помечаются как выбранные.
         *
         * @return возвращает коллекцию содержащую TreeElement'ы, которые
         * были помеченны как выбранные.
         */
        private List<TreeElement> setCheckedFromFragment(TreeElement treeFull, Map<String, PgStatement> listPgObjectsFragment,
                PgDatabase dumpFullDb, PgDatabase dumpFullProject) {
            List<TreeElement> checked = new ArrayList<>();

            TreeFlattener treeFlattener = new TreeFlattener();
            List<TreeElement> filtered = treeFlattener.getNewDeleteEdit(treeFlattener.flatten(treeFull),
                    dumpFullProject, dumpFullDb);

            for(Entry<String, PgStatement> entry : listPgObjectsFragment.entrySet()){
                TreeElement treeElement = treeFull.findElement(entry.getValue());
                if(treeElement != null && filtered.contains(treeElement)){
                    treeElement.setSelected(true);
                    checked.add(treeElement);
                }
            }

            return checked;
        }
    }
}