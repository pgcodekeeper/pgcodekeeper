 
package ru.taximaxim.codekeeper.ui.handlers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.pgdbproject.DiffWizard;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class Diff {

	@Execute
	public void execute(
	        PgDbProject proj,
            @Named(IServiceConstants.ACTIVE_SHELL)
            Shell shell,
            @Named(UIConsts.PREF_STORE)
            IPreferenceStore prefStore) throws IOException, InvocationTargetException {
	    try {
	        // FIXME
	        ProjSyncSrc.sync(proj, shell, prefStore);
	        
	        WizardDialog dialog = new WizardDialog(
	                shell, new DiffWizard(proj, prefStore));
	        dialog.open();
	    } catch(CancellationException ex) {
	        MessageBox mb = new MessageBox(shell, SWT.ICON_CANCEL);
            mb.setText("Diff operation");
            mb.setMessage("Diff operation cancelled.");
            mb.open();
	    }
	}
	
	@CanExecute
    public boolean canExecute(PgDbProject proj) {
	    return proj != null;
	}
}