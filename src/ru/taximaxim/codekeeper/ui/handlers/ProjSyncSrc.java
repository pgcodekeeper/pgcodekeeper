 
package ru.taximaxim.codekeeper.ui.handlers;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.parts.ProjectPartDescriptor;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.pgdbproject.ProjectLoaderParser;
import ru.taximaxim.codekeeper.ui.pgdbproject.ProjectSyncChecker;

public class ProjSyncSrc {
	
	@Inject
	@Named(IServiceConstants.ACTIVE_PART)
	MPart part;
	
	@Execute
	public void execute(
			@Named(IServiceConstants.ACTIVE_SHELL)
			Shell shell,
			@Named(UIConsts.PREF_STORE)
			IPreferenceStore prefStore) throws InvocationTargetException {
	    boolean cancelled;
		try {
		    cancelled = !sync((ProjectPartDescriptor) part.getObject(), shell,
		            prefStore);
		} catch(CancellationException ex) {
		    cancelled = true;
		}
		
	    if(cancelled) {
            MessageBox mb = new MessageBox(shell, SWT.ICON_CANCEL);
            mb.setText("Sync operation");
            mb.setMessage("Sync operation cancelled.");
            mb.open();
	    }
	}
	
	/**
	 * @throws CancellationException if the calling operation was cancelled
	 * @return true if user proceeded to sync,
	 *         false if user decided not to sync
	 */
	public static boolean sync(ProjectPartDescriptor partImpl, Shell shell,
		IPreferenceStore mainPrefStore) throws InvocationTargetException {
	    PgDbProject proj = partImpl.getProject();
	    
		String syncDump = null;
		if(UIConsts.PROJ_SOURCE_TYPE_DUMP.equals(
				proj.getString(UIConsts.PROJ_PREF_SOURCE))) {
			FileDialog dialogDump = new FileDialog(shell);
			dialogDump.setText("Synchronizing:"
					+ " Dump file is chosen as project source."
					+ " Select a file to sync with.");
			
			syncDump = dialogDump.open();
			if(syncDump == null) {
				throw new CancellationException();
			}
		}

		ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
		ProjectSyncChecker projChecker = new ProjectSyncChecker(mainPrefStore,
				proj, syncDump);
		try {
			dialog.run(true, false, projChecker);
		} catch(InterruptedException ex) {
			// assume run() was called as non cancelable
			throw new IllegalStateException(
					"Project creator thread cancelled. Shouldn't happen!", ex);
		}
		
		String diff = projChecker.getDiff();
		if(diff.isEmpty()) {
			return true;
		}
		
		int syncDecision = new TextDialog(shell, "Sync differences?",
		        "Found differences in the project."
				+ " Want to sync it with source?\n\n"
				+ "Diff from the project to its schema source:", diff)
		.open();
		
		switch(syncDecision) {
		    case IDialogConstants.YES_ID: break;
		    case IDialogConstants.NO_ID:  return false;
		    
		    case IDialogConstants.CANCEL_ID:
		    case SWT.DEFAULT:
		        throw new CancellationException();
		        
		    default:
		        throw new IllegalStateException(
		                "Unexpected value from sync dialog: " + syncDecision);
		}
		
		dialog = new ProgressMonitorDialog(shell);
		ProjectLoaderParser reload = 
				new ProjectLoaderParser(mainPrefStore, proj, syncDump);
		try {
			dialog.run(true, false, reload);
		} catch(InterruptedException ex) {
			// assume run() was called as non cancelable
			throw new IllegalStateException(
					"Project reload thread cancelled. Shouldn't happen!", ex);
		}
		
		partImpl.reload();
		return true;
	}
	
	@CanExecute
	public boolean canExecute() {
		return part.getElementId().equals(UIConsts.PROJ_PART_DESCR_ID);
	}
}

class TextDialog extends MessageDialog {
	
	final private String text;
	
	public TextDialog(Shell parentShell, String title, String message, String text) {
	    super(parentShell, title, null, message, QUESTION_WITH_CANCEL, null, 2);
		
		this.text = text;
	}
	
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
	    createButton(parent, IDialogConstants.YES_ID,
	            IDialogConstants.YES_LABEL, true);
	    createButton(parent, IDialogConstants.NO_ID,
	            IDialogConstants.NO_LABEL, false);
	    createButton(parent, IDialogConstants.CANCEL_ID,
	            IDialogConstants.CANCEL_LABEL, false);
	}
	
	@Override
	protected Control createCustomArea(Composite parent) {
	    Text txt = new Text(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
                | SWT.READ_ONLY | SWT.MULTI);
        
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        gd.widthHint = 600;
        gd.heightHint = 400;
        txt.setLayoutData(gd);
        
        txt.setFont(new Font(parent.getShell().getDisplay(), new FontData[] {
            new FontData("Monospace", 10, SWT.NORMAL),
            new FontData("Courier New", 10, SWT.NORMAL),
            new FontData("Courier", 10, SWT.NORMAL)
        }));
        txt.setText(text);
        
        return txt;
	}
	
	@Override
	public int open() {
	    
	    return super.open();
	}
}