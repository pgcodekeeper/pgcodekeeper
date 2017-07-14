
package ru.taximaxim.codekeeper.ui.handlers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.charset.StandardCharsets;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import cz.startnet.utils.pgdiff.PgDiff;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcLoader;
import cz.startnet.utils.pgdiff.loader.JdbcRunner;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.licensing.License;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
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

        JdbcConnector connector = new JdbcConnector(
                dbInfo.getDbHost(), dbInfo.getDbPort(), dbInfo.getDbUser(), dbInfo.getDbPass(), dbInfo.getDbName(),
                ApgdiffConsts.UTF_8, ApgdiffConsts.UTC);

        PgDiffArguments args = new PgDiffArguments();
        try {
            args.setLicense(new License(Activator.getDefault().getPreferenceStore().getString(PREF.LICENSE_PATH)));
        } catch (IOException | LicenseException e) {
            e.printStackTrace();
        }
        args.setInCharsetName(ApgdiffConsts.UTF_8);
        args.setCheckFunctionBodies(false);

        /////////////////////////////////////////////////////////////
        Log.log(Log.LOG_DEBUG, "QuickUpdate starting"); //$NON-NLS-1$

        System.err.println(">>> fei.getURI().getPath(): "
                + ((FileEditorInput)editor.getEditorInput()).getURI().getPath());
        /////////////////////////////////////////////////////////////


        PgDatabase dbDumpOld = null;
        try {
            JdbcLoader loader = new JdbcLoader(connector, args);
            dbDumpOld = loader.getDbFromJdbc();
        } catch (IOException | InterruptedException | LicenseException e) {
            e.printStackTrace();
        }

        //                PgDatabase dbDumpOld = getDbDump(args,
        //                        rollOnEditor.getSqlFileInitialURI(),
        //                        rollOnEditor.getSqlTextInitial());

        PgDatabase dbDumpNew = getDbDump(args,
                ((FileEditorInput)editor.getEditorInput()).getURI(),
                rollOnEditor.getSourceViewerForQuickUpdate().getDocument().get());

        final ByteArrayOutputStream diffInput = new ByteArrayOutputStream();
        final PrintWriter writer = new UnixPrintWriter(diffInput, true);
        try {
            TreeElement tree = DiffTree.create(dbDumpOld, dbDumpNew, null);
            tree.setCheckedCustom(dbDumpNew);

            // PgDiff.diffDatabaseSchemas(writer, args, dbDumpOld, dbDumpNew, null);
            PgDiff.diffDatabaseSchemasAdditionalDepcies(writer, args,
                    tree, dbDumpOld, dbDumpNew, null, null);
            writer.flush();

            String result = new JdbcRunner(connector).runScript(diffInput.toString());

            System.err.println(">>>>> result:\n"
                    + result
                    + "\n"
                    + diffInput.toString());
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
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

    private static String getSchemaName(String path){
        path = path.substring(path.indexOf("/SCHEMA/"), path.length());
        path = path.replace("/SCHEMA/", "");
        return path.substring(0, path.indexOf("/"));
    }
}