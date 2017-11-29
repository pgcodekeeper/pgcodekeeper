package ru.taximaxim.codekeeper.ui.handlers;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcSystemLoader;
import cz.startnet.utils.pgdiff.schema.system.PgSystemStorage;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;

public class GetSystemObjects extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        IWorkbenchPart part = HandlerUtil.getActiveEditor(event);
        if (part instanceof ProjectEditorDiffer){
            ProjectEditorDiffer differ = (ProjectEditorDiffer) part;
            Object db = differ.getCurrentDb();
            if (db != null && db instanceof DbInfo) {
                DbInfo info = ((DbInfo)db);
                FileDialog fd = new FileDialog(HandlerUtil.getActiveShell(event), SWT.SAVE);
                fd.setText("Save system objects");
                fd.setFileName(PgSystemStorage.FILE_NAME + info.getDbName() + ".ser");
                String select = fd.open();
                if (select != null) {
                    JdbcConnector jdbcConnector = new JdbcConnector(info.getDbHost(),
                            info.getDbPort(), info.getDbUser(), info.getDbPass(),
                            info.getDbName(), ApgdiffConsts.UTF_8);
                    try {
                        PgSystemStorage storage = new JdbcSystemLoader(jdbcConnector,
                                SubMonitor.convert(new NullProgressMonitor())).getStorageFromJdbc();

                        ApgdiffUtils.serialize(select, storage);
                    } catch (IOException | InterruptedException e) {
                        ExceptionNotifier.notifyDefault(e.getLocalizedMessage(), e);
                    }
                }
            }
        }

        return null;
    }

    @Override
    public boolean isEnabled() {
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        return editor instanceof ProjectEditorDiffer;
    }
}