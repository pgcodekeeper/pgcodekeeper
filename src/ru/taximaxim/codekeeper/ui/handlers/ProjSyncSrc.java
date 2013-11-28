 
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
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.TextDialog;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.parts.ProjectPartDescriptor;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.pgdbproject.ProjectLoaderParser;

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
        DbSource db2 = null;
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
            
            db2 = DbSource.fromFile(syncDump,
                    proj.getString(UIConsts.PROJ_PREF_ENCODING));
        } else {
            db2 = DbSource.fromDb(mainPrefStore.getString(
                    UIConsts.PREF_PGDUMP_EXE_PATH), proj);
        }
        
        DbSource db1 = DbSource.fromProject(proj);
        
        ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
        Differ differ = new Differ(db1, db2);
        
        try {
            dialog.run(true, false, differ);
        } catch(InterruptedException ex) {
            // assume run() was called as non cancelable
            throw new IllegalStateException(
                    "Diff thread cancelled. Shouldn't happen!", ex);
        }
        
        String diff = differ.getDiffDirect();
        if(diff.isEmpty()) {
            return true;
        }
        
		int syncDecision = new TextDialog(shell, TextDialog.QUESTION_WITH_CANCEL,
		        "Sync differences?",
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