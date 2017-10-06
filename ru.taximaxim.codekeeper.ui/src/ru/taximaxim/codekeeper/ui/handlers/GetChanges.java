package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.FileStoreEditorInput;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorInput;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class GetChanges extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        IWorkbenchPart part = HandlerUtil.getActiveEditor(event);

        if (part instanceof ProjectEditorDiffer){
            ProjectEditorDiffer differ = (ProjectEditorDiffer) part;
            Object remote = differ.getCurrentDb();

            if (remote != null) {
                differ.getChanges(remote);
            } else {
                MessageBox mb = new MessageBox(HandlerUtil.getActiveShell(event), SWT.ICON_INFORMATION);
                mb.setText(Messages.GetChanges_select_source);
                mb.setMessage(Messages.GetChanges_select_source_msg);
                mb.open();
            }
        } else if (part instanceof SQLEditor) {
            SQLEditor sqlEditor = (SQLEditor) part;
            IEditorInput editorInput = sqlEditor.getEditorSite().getPage().getActiveEditor().getEditorInput();

            if(editorInput instanceof IFileEditorInput) {
                try {
                    ProjectEditorInput projectEditorInput = new ProjectEditorInput(((IFileEditorInput)editorInput)
                            .getFile().getProject().getName());

                    IEditorPart editor = sqlEditor.getSite().getPage().openEditor(projectEditorInput, UIConsts.EDITOR.PROJECT);

                    ((ProjectEditorDiffer)editor).getChanges(sqlEditor.getCurrentDb());
                } catch (PartInitException e) {
                    ExceptionNotifier.notifyDefault(e.getLocalizedMessage(), e);
                }
            }
        }
        return null;
    }

    @Override
    public boolean isEnabled() {
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        IEditorInput input = editor.getEditorInput();

        boolean isTemporaryMigrationFile = input instanceof FileStoreEditorInput
                && ((FileStoreEditorInput)input).getURI().getPath().contains(System.getProperty("java.io.tmpdir"))
                && ((FileStoreEditorInput)input).getURI().getPath().contains("migration for");

        return !(editor instanceof SQLEditor && isTemporaryMigrationFile);
    }
}