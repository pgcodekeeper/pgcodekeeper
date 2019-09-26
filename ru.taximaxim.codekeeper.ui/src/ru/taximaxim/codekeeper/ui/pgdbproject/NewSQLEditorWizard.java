package ru.taximaxim.codekeeper.ui.pgdbproject;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import ru.taximaxim.codekeeper.ui.handlers.OpenSQLEditor;

public class NewSQLEditorWizard extends Wizard implements INewWizard {

    private IWorkbench workbench;

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.workbench = workbench;
    }

    @Override
    public boolean performFinish() {
        return OpenSQLEditor.openEditor(workbench.getActiveWorkbenchWindow().getActivePage());
    }
}