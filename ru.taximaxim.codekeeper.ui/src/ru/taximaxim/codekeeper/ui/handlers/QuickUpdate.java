
package ru.taximaxim.codekeeper.ui.handlers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import cz.startnet.utils.pgdiff.PgDiff;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcLoader;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.licensing.License;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeFlattener;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
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

        /////////////////////////////////////////////////////////////

        try {
            JdbcConnector connector = new JdbcConnector(
                    dbInfo.getDbHost(), dbInfo.getDbPort(), dbInfo.getDbUser(), dbInfo.getDbPass(), dbInfo.getDbName(),
                    ApgdiffConsts.UTF_8, ApgdiffConsts.UTC);

            PgDiffArguments args = new PgDiffArguments();
            args.setLicense(new License(Activator.getDefault().getPreferenceStore().getString(PREF.LICENSE_PATH)));
            args.setInCharsetName(ApgdiffConsts.UTF_8);
            args.setCheckFunctionBodies(false);

            /////////////////////////////////////////////////////////////
            Log.log(Log.LOG_DEBUG, "QuickUpdate starting"); //$NON-NLS-1$

            System.err.println(">>> fei.getURI().getPath(): "
                    + ((FileEditorInput)editor.getEditorInput()).getURI().getPath());
            /////////////////////////////////////////////////////////////

            // 1) Получить список объектов с которыми работаем
            // 2) Распарсить его
            PgDatabase dumpFragmentProject = getDbDump(args,
                    ((FileEditorInput)editor.getEditorInput()).getURI(),
                    rollOnEditor.getSourceViewerForQuickUpdate().getDocument().get());


            // 3) Распарсить весь проект
            PgDbProject proj = new PgDbProject( ((IFileEditorInput)editor.getEditorInput()).getFile().getProject() );
            DbSource dbSource = DbSource.fromProject(proj);
            PgDatabase dumpFullProject = dbSource.get(SubMonitor.convert(null, "", 1));


            // 4) Сравнить проект с БД
            JdbcLoader loader = new JdbcLoader(connector, args);
            PgDatabase dumpFullDb = loader.getDbFromJdbc();
            ByteArrayOutputStream diffInput = new ByteArrayOutputStream();
            PrintWriter writer = new UnixPrintWriter(diffInput, true);
            TreeElement treeFull = DiffTree.create(dumpFullDb, dumpFullProject, null);


            // 5) Сгенерить скрипт по объектам (из "1)")
            TreeElement treeFragment = DiffTree.create(new PgDatabase(), dumpFragmentProject, null);
            setCheckedFromFragment(treeFull, PgDatabase.listPgObjects(dumpFragmentProject),
                    dumpFullDb, dumpFullProject);


            //6) Накатить его на БД
            PgDiff.diffDatabaseSchemasAdditionalDepcies(writer, args,
                    treeFull, dumpFullDb, dumpFullProject, null, null);
            writer.flush();
            //            String result = new JdbcRunner(connector).runScript(diffInput.toString());

            System.err.println(">>>>> result:\n"
                    //                    + result
                    //                    + "\n"
                    + diffInput.toString());


            // 7) Сравнить с БД еще раз
            loader = new JdbcLoader(connector, args);
            dumpFullDb = loader.getDbFromJdbc();
            diffInput = new ByteArrayOutputStream();
            writer = new UnixPrintWriter(diffInput, true);
            treeFull = DiffTree.create(dumpFullDb, dumpFullProject, null);



            // 8) Тот же набор объектов (из "1)") накатывает в проект


        } catch (IOException | InterruptedException | LicenseException | CoreException exception) {
            Log.log(Log.LOG_DEBUG, "QuickUpdate button is broken"); //$NON-NLS-1$
            exception.printStackTrace();
        }

        return null;
    }

    private PgDatabase getDbDump(PgDiffArguments args, URI fileInEditorURI, String sqlText){
        PgDatabase dbDump = null;
        String schemaName = getSchemaName(fileInEditorURI.getPath());
        InputStream inputStream = new ByteArrayInputStream(sqlText.getBytes(StandardCharsets.UTF_8));
        PgDumpLoader loader = new PgDumpLoader(inputStream, fileInEditorURI.getPath(), args);
        try{
            if("PUBLIC".equals(schemaName)){
                dbDump = loader.load();
            } else {
                dbDump = loader.load(getSchemaName(fileInEditorURI.getPath()));
            }
        } catch (IOException | InterruptedException | LicenseException e) {
            e.printStackTrace();
        }
        return dbDump;
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

    private String getSchemaName(String path){
        path = path.substring(path.indexOf("/SCHEMA/"), path.length());
        path = path.replace("/SCHEMA/", "");
        return path.substring(0, path.indexOf("/"));
    }

    /**
     * отмечает все элементы переданные в Map<String, PgStatement> listPgObjectsFragment
     */
    private void setCheckedFromFragment(TreeElement treeFull, Map<String, PgStatement> listPgObjectsFragment,
            PgDatabase dumpFullDb, PgDatabase dumpFullProject) {
        TreeFlattener treeFlattener = new TreeFlattener();
        List<TreeElement> filtered = treeFlattener.getNewDeleteEdit(treeFlattener.flatten(treeFull),
                dumpFullProject, dumpFullDb);
        for(Entry<String, PgStatement> entry : listPgObjectsFragment.entrySet()){
            TreeElement treeElement = treeFull.findElement(entry.getValue());
            if(treeElement != null && filtered.contains(treeElement)){
                treeElement.setSelected(true);
            }
        }
    }
}