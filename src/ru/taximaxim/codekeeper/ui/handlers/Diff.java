 
package ru.taximaxim.codekeeper.ui.handlers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.parts.ProjectPartDescriptor;
import ru.taximaxim.codekeeper.ui.pgdbproject.DiffWizard;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class Diff {
    
    @Inject
    @Named(IServiceConstants.ACTIVE_PART)
    MPart part;
    
	@Execute
	public void execute(
            @Named(IServiceConstants.ACTIVE_SHELL)
            Shell shell,
            @Named(UIConsts.PREF_STORE)
            IPreferenceStore prefStore)
                    throws InvocationTargetException, IOException {
	    try {
	        ProjectPartDescriptor partImpl = 
	                (ProjectPartDescriptor) part.getObject();
	        ProjSyncSrc.sync(partImpl, shell, prefStore);
	        
	        PgDbProject proj = partImpl.getProject();
	        
	        WizardDialog dialog = new WizardDialog(
	                shell, new DiffWizard(proj, prefStore));
	        dialog.create();
	        dialog.open();
	    } catch(CancellationException ex) {
	        MessageBox mb = new MessageBox(shell, SWT.ICON_CANCEL);
            mb.setText("Diff operation");
            mb.setMessage("Diff operation cancelled.");
            mb.open();
	    }
	}
	
	@CanExecute
    public boolean canExecute() {
	    return part.getElementId().equals(UIConsts.PROJ_PART_DESCR_ID);
	}
}