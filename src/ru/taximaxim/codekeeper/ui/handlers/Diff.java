 
package ru.taximaxim.codekeeper.ui.handlers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import cz.startnet.utils.pgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.ui.TextDialog;
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
	        
	        DiffWizard diff = new DiffWizard(proj, prefStore);
	        WizardDialog dialog = new WizardDialog(shell, diff);
	        dialog.create();
	        if(dialog.open() == Dialog.OK) {
	            String diffResult = diff.getDiffResult();
	            
	            String from = diff.isReverse()? diff.getDb2().getOrigin()
	                    : diff.getDb1().getOrigin();
	            String to = diff.isReverse()? diff.getDb1().getOrigin()
	                    : diff.getDb2().getOrigin();
	            
	            
	            TextDialog txtDialog = new TextDialog(shell, TextDialog.QUESTION,
	                    "Diff", "Diff operation:\n"
	                            + "From: " + from + "\n"
	                            + "To: " + to + "\n"
	                            + "\nSave result?", diffResult);
	            if(txtDialog.open() == Dialog.OK) {
	                FileDialog saveDialog = new FileDialog(shell, SWT.SAVE);
	                saveDialog.setOverwrite(true);
	                saveDialog.setFilterExtensions(new String[] { "*.sql", "*" });
	                saveDialog.setFilterPath(proj.getProjectDir());
	                
	                String saveTo = saveDialog.open();
	                if(saveTo != null) {
	                    try(final PrintWriter encodedWriter = new UnixPrintWriter(
	                            new OutputStreamWriter(
	                                new FileOutputStream(saveTo),
	                                proj.getString(UIConsts.PROJ_PREF_ENCODING)))) {
	                        encodedWriter.println(diffResult);
	                    }
	                }
	            }
	        }
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