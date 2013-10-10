 
package ru.taximaxim.codekeeper.ui.handlers;

import java.io.IOException;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.pgdbproject.NewProjWizard;

public class NewProj {
	@Execute
	public void execute(
			@Named(IServiceConstants.ACTIVE_SHELL)
			Shell shell) throws IOException {
		NewProjWizard newProj = new NewProjWizard();
		WizardDialog dialog = new WizardDialog(shell, newProj);
		dialog.create();
		if(dialog.open() == Dialog.OK) {
			// TODO invoke load _project
		}
	}
}