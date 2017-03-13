package ru.taximaxim.codekeeper.ui.intro.actions;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.pgdbproject.NewProjWizard;

public class NewProjWizardAction {
    public NewProjWizardAction(){
        IWorkbench workbench = PlatformUI.getWorkbench();
        IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
        ISelection selection = window.getSelectionService().getSelection();

        NewProjWizard wizard = new NewProjWizard();
        wizard.init(workbench, selection instanceof IStructuredSelection ?
                (IStructuredSelection) selection : null);
        new WizardDialog(window.getShell(), wizard).open();
    }
}