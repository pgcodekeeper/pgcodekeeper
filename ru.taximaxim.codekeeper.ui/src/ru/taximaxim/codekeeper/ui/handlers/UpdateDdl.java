package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.FileStoreEditorInput;

import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.sqledit.RollOnEditor;

public class UpdateDdl extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        IWorkbenchPart part = HandlerUtil.getActiveEditor(event);

        if (part instanceof RollOnEditor){
            RollOnEditor rollOnEditor = (RollOnEditor) part;

            if (rollOnEditor.getLastDb() != null) {
                rollOnEditor.updateDdl();
            } else {
                MessageBox mb = new MessageBox(HandlerUtil.getActiveShell(event), SWT.ICON_INFORMATION);
                mb.setText(Messages.UpdateDdl_select_source);
                mb.setMessage(Messages.UpdateDdl_select_source_msg);
                mb.open();
            }
        }
        return null;
    }

    @Override
    public boolean isEnabled() {
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        IEditorInput input = editor.getEditorInput();

        boolean isMigrationFile = input instanceof IFileEditorInput
                && ((IFileEditorInput) input).getFile().getFullPath().toOSString().contains("MIGRATION");

        boolean isTemporaryMigrationFile = input instanceof FileStoreEditorInput
                && ((FileStoreEditorInput)input).getURI().getPath().contains(System.getProperty("java.io.tmpdir"))
                && ((FileStoreEditorInput)input).getURI().getPath().contains("migration for default");

        return editor instanceof RollOnEditor && (isMigrationFile || isTemporaryMigrationFile);
    }
}