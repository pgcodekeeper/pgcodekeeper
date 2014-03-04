 
package ru.taximaxim.codekeeper.ui.handlers;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

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
	private void execute(
	        PgDbProject proj,
			@Named(IServiceConstants.ACTIVE_SHELL)
			Shell shell,
			@Named(UIConsts.PREF_STORE)
			IPreferenceStore prefStore) throws IOException, InvocationTargetException {
	    sync(proj, shell, prefStore);
	}
	
	@CanExecute
	private boolean canExecute(PgDbProject proj) {
		return proj != null;
	}
	
	/**
     * @return false if sync failed due to svn conflicts 
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
                        conflicted[0] = !svn.repoUpdate(svnDir);
                    }
                } catch(IOException ex) {
                    throw new InvocationTargetException(ex);
                }
                monitor.done();
            }
        };
        
        try {
            new ProgressMonitorDialog(shell).run(true, false, syncRunnable);
        } catch(InterruptedException ex) {
            throw new IllegalStateException("Uncancellable thread interrupted!", ex);
        }
        
        if(conflicted[0]) {
            MessageBox mb = new MessageBox(shell, SWT.ICON_ERROR);
            mb.setText("Sync error!");
            mb.setMessage("SVN cache has conflicts!"
                    + " Resolve them manually and reload project before continuing.");
            mb.open();
        }
        
        return !conflicted[0];
    }
}