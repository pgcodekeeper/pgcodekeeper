package ru.taximaxim.codekeeper.ui.intro.actions;

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.pgdbproject.NewProjWizard;

public class NewProjWizardAction {
    public NewProjWizardAction(){
        new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), new NewProjWizard()).open();
    }
}