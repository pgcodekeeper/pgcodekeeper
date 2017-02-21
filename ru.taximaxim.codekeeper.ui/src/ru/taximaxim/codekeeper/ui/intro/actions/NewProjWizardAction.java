package ru.taximaxim.codekeeper.ui.intro.actions;

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.pgdbproject.NewProjWizard;

public class NewProjWizardAction {
    public NewProjWizardAction(){
        IWorkbench workbench = PlatformUI.getWorkbench();
        NewProjWizard wizard = new NewProjWizard();
        wizard.init(workbench, null);
        new WizardDialog(workbench.getActiveWorkbenchWindow().getShell(), wizard).open();
    }
}