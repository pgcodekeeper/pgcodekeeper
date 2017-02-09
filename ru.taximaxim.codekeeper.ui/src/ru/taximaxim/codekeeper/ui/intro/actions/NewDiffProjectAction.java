package ru.taximaxim.codekeeper.ui.intro.actions;

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.pgdbproject.DiffWizard;

public class NewDiffProjectAction {
    public NewDiffProjectAction(){
        WizardDialog dialog = new WizardDialog(
                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                new DiffWizard(null, Activator.getDefault().getPreferenceStore()));
        dialog.open();
    }
}