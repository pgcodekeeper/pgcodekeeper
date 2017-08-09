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
        IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        IEditorInput input = part.getEditorInput();
        if (part instanceof RollOnEditor && input instanceof FileEditorInput
                && ((FileEditorInput) input).getURI().getPath().contains("SCHEMA")) {
            RollOnEditor editor = (RollOnEditor) part;
            DbInfo dbInfo = editor.getDbInfo();
            if (dbInfo == null){
                ExceptionNotifier.notifyDefault(Messages.sqlScriptDialog_script_select_storage, null);
            } else {
                //editor.doSave(null);
                new QuickUpdateJob(Messages.quickUpdate_process, editor, dbInfo).schedule();
            }
        }

        return null;
    }

    private class QuickUpdateJob extends Job {
        private JdbcConnector connector;
        private PgDiffArguments args;
        private final RollOnEditor editor;
        private final DbInfo dbInfo;
        private final FileEditorInput input;
        private String primarySqlText;

        public QuickUpdateJob(String name, RollOnEditor editor, DbInfo dbInfo) {
            super(name);
            this.editor = editor;
            this.dbInfo = dbInfo;
            input = (FileEditorInput) editor.getEditorInput();
        }

        @Override
        protected IStatus run(IProgressMonitor monitor) {
            try {
                connector = new JdbcConnector(
                        dbInfo.getDbHost(), dbInfo.getDbPort(), dbInfo.getDbUser(), dbInfo.getDbPass(),
                        dbInfo.getDbName(), ApgdiffConsts.UTF_8, ApgdiffConsts.UTC);

                args = new PgDiffArguments();
                args.setLicense(new License(Activator.getDefault().getPreferenceStore().getString(PREF.LICENSE_PATH)));
                args.setInCharsetName(ApgdiffConsts.UTF_8);
                args.setCheckFunctionBodies(false);

                Log.log(Log.LOG_DEBUG, "QuickUpdate starting"); //$NON-NLS-1$
                rollChanges();
            } catch (InterruptedException e) {
                return Status.CANCEL_STATUS;
            } catch (CoreException | IOException | LicenseException e) {
                ExceptionNotifier.notifyDefault(Messages.quickUpdate_error_btn, e);
                return new Status(Status.ERROR, PLUGIN_ID.THIS,
                        Messages.quickUpdate_error_btn, e);
            }

            return Status.OK_STATUS;
        }

        private void rollChanges()
                throws IOException, InterruptedException, LicenseException, CoreException {

            primarySqlText = editor.getSrcViewer().getDocument().get();
            String path = input.getURI().getPath();

            PgDatabase dbProjectFragment = getDbProjectFragment(args, path, primarySqlText);

            PgDatabase dbProjectFull = getDbProjectFull();
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
            } else {
                String result = new JdbcRunner(connector).runScript(diffInput.toString());

                if(!JDBC_CONSTS.JDBC_SUCCESS.equals(result)) {
                    ExceptionNotifier.notifyDefault(result, null);
                } else {
                    String finalSqlText = editor.getSrcViewer().getDocument().get();
                    dbProjectFragment = getDbProjectFragment(args, path, finalSqlText);

                    dbProjectFull = getDbProjectFull();
                    dbRemoteFull = new JdbcLoader(connector, args).getDbFromJdbc();
                    TreeElement treeFullPost = DiffTree.create(dbRemoteFull, dbProjectFull, null);

                    List<TreeElement> checked = setCheckedFromFragment(treeFullPost,
                            PgDatabase.listPgObjects(dbProjectFragment), dbRemoteFull, dbProjectFull);

                    if (primarySqlText.equals(finalSqlText)) {
                        PgDbProject proj = new PgDbProject(input.getFile().getProject());
                        new ProjectUpdater(dbRemoteFull, dbProjectFull, checked, proj).updatePartial();
                        ResourceUtil.getResource(editor.getEditorInput()).refreshLocal(IResource.DEPTH_ZERO, null);
                    }
                }
            }
        }

        private PgDatabase getDbProjectFragment(PgDiffArguments args, String path, String sqlText)
                throws IOException, InterruptedException, LicenseException {
            PgDatabase dbDump = null;
            String schemaName = path.substring(path.indexOf("/SCHEMA/") + 8, path.length())
                    .substring(0, path.indexOf("/"));
            try(InputStream inputStream = new ByteArrayInputStream(sqlText.getBytes(StandardCharsets.UTF_8));
                    PgDumpLoader loader = new PgDumpLoader(inputStream, path, args)) {
                if("PUBLIC".equalsIgnoreCase(schemaName)) { //$NON-NLS-1$
                    dbDump = loader.load();
                } else {
                    dbDump = loader.load(schemaName);
                }
            }
            return dbDump;
        }

        private PgDatabase getDbProjectFull()
                throws IOException, InterruptedException, LicenseException, CoreException {
            PgDbProject proj = new PgDbProject(input.getFile().getProject());
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