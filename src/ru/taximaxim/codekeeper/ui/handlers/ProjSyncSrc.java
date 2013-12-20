 
package ru.taximaxim.codekeeper.ui.handlers;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;

import javax.inject.Named;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.externalcalls.SvnExec;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class ProjSyncSrc {
	
	@Execute
	public void execute(
	        PgDbProject proj,
			@Named(IServiceConstants.ACTIVE_SHELL)
			Shell shell,
			@Named(UIConsts.PREF_STORE)
			IPreferenceStore prefStore) throws IOException, InvocationTargetException {
	    sync(proj, shell, prefStore);
	}
	
	/**
	 * @return false if sync was stopped due to svn conflicts 
	 * @throws IOException
	 */
	public static boolean sync(final PgDbProject proj, Shell shell,
            final IPreferenceStore mainPrefs) throws IOException, InvocationTargetException {
	    final boolean[] conflicted = { false };
	    IRunnableWithProgress syncRunnable = new IRunnableWithProgress() {
            @Override
            public void run(IProgressMonitor monitor) throws InvocationTargetException,
                    InterruptedException {
                SubMonitor pm = SubMonitor.convert(monitor, "Syncing SVN cache", 10);
                
                SvnExec svn = new SvnExec(mainPrefs.getString(UIConsts.PREF_SVN_EXE_PATH),
                        proj);
                File svnDir = proj.getProjectSchemaDir();
                
                try {
                    pm.newChild(2).subTask("Checking conflicts...");
                    conflicted[0] = svn.hasConflicts(svnDir);
                    
                    if(!conflicted[0]) {
                        pm.newChild(8).subTask("Updating SVN cache...");
                        conflicted[0] = !svn.svnUpdate(svnDir);
                    }
                } catch(IOException ex) {
                    throw new InvocationTargetException(ex);
                }
            }
        };
	    
	    ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
	    try {
	        dialog.run(true, false, syncRunnable);
	    } catch(InterruptedException ex) {
	        throw new IllegalStateException("Uncancellable thread interrupted!", ex);
	    }
	    
	    if(conflicted[0]) {
	        MessageBox mb = new MessageBox(shell, SWT.ICON_ERROR);
	        mb.setText("Sync error!");
	        mb.setMessage("Cannot sync SVN cache due to conflicts!");
	        mb.open();
	    }
	    
	    return !conflicted[0];
	}
	
	/**
	 * @throws CancellationException if the calling operation was cancelled
	 * @return true if user proceeded to sync,
	 *         false if user decided not to sync
	 */
	/*
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
		TODO broken

		dialog = new ProgressMonitorDialog(shell);
		ProjectCreator reload = 
				new ProjectCreator(mainPrefStore, proj, syncDump);
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
	*/
	
	@CanExecute
	public boolean canExecute(PgDbProject proj) {
		return proj != null;
	}
}