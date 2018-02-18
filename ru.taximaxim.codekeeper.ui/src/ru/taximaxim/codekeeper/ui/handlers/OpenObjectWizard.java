package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.ui.pgdbproject.NewObjectWizard;

public class OpenObjectWizard extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IStructuredSelection selection = HandlerUtil.getCurrentStructuredSelection(event);

        if (selection == StructuredSelection.EMPTY) {
            IEditorInput input = HandlerUtil.getActiveEditorInput(event);
            if (input instanceof IFileEditorInput) {
                selection = new StructuredSelection(((IFileEditorInput)input).getFile());
            }
        }

        NewObjectWizard wizard = new NewObjectWizard();
        wizard.init(null, selection);
        WizardDialog dialog = new WizardDialog(HandlerUtil.getActiveShell(event), wizard);
        dialog.open();
        return null;
    }
}
