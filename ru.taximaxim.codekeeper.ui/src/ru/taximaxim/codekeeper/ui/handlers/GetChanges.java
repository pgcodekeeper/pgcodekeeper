package ru.taximaxim.codekeeper.ui.handlers;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.ui.UIConsts.COMMAND;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class GetChanges extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        IWorkbenchPart part = HandlerUtil.getActiveEditor(event);

        if (part instanceof ProjectEditorDiffer){
            ProjectEditorDiffer differ = (ProjectEditorDiffer) part;
            String filePath = event.getParameter(COMMAND.PARAM_FILE_PATH);
            String coords = event.getParameter(COMMAND.PARAM_DB_COORDS);

            Object remote;
            if (filePath != null) {
                remote = new File(filePath);
            } else if (coords != null) {
                remote = new DbInfo(coords);
            } else {
                remote = differ.getLastDb();
            }

            if (remote != null) {
                differ.getChanges(remote);
            } else {
                MessageBox mb = new MessageBox(HandlerUtil.getActiveShell(event), SWT.ICON_INFORMATION);
                mb.setText(Messages.GetChanges_select_source);
                mb.setMessage(Messages.GetChanges_select_source_msg);
                mb.open();
            }
        }
        return null;
    }

    @Override
    public boolean isEnabled() {
        return !((ProjectEditorDiffer)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                .getActiveEditor()).isGetChangesJobInProcessing();
    }
}