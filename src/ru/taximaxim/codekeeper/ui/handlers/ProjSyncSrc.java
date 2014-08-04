package ru.taximaxim.codekeeper.ui.handlers;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.EVENT;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.externalcalls.IRepoWorker;
import ru.taximaxim.codekeeper.ui.externalcalls.JGitExec;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class ProjSyncSrc {
    
    @Inject
    private static IEventBroker events;
    
    @Execute
    private void execute(
            PgDbProject proj,
            @Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
            @Named(UIConsts.PREF_STORE) IPreferenceStore prefStore) {
        sync(proj, shell, prefStore);
    }

    @CanExecute
    private boolean canExecute(PgDbProject proj) {
        return proj != null;
    }

    /**
     * @return false if sync fails due to version control conflicts
     */
    public static boolean sync(
            final PgDbProject proj,
            Shell shell,
            final IPreferenceStore mainPrefs) {
        Log.log(Log.LOG_INFO, "Syncing project " + proj.getProjectFile() + //$NON-NLS-1$
                " with repo url " + proj.getString(PROJ_PREF.REPO_URL)); //$NON-NLS-1$
        
        final AtomicBoolean conflicted = new AtomicBoolean(true);
        IRunnableWithProgress syncRunnable = new IRunnableWithProgress() {
            
            @Override
            public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                SubMonitor pm = SubMonitor.convert(monitor, Messages.projSyncSrc_syncing_repository_cache, 10);
                IRepoWorker repo = new JGitExec(proj, 
                        mainPrefs.getString(PREF.GIT_KEY_PRIVATE_FILE));

                File repoDir = proj.getProjectWorkingDir();

                try {
                    pm.newChild(2).subTask(Messages.projSyncSrc_checking_conflicts);
                    conflicted.set(repo.hasConflicts(repoDir));

                    if (!conflicted.get()) {
                        pm.newChild(8).subTask(Messages.projSyncSrc_updating_cache);
                        conflicted.set(!repo.repoUpdate(repoDir));
                    }
                } catch (IOException ex) {
                    throw new InvocationTargetException(ex, Messages.projSyncSrc_error_while_checking);
                }
                pm.done();
            }
        };

        try {
            new ProgressMonitorDialog(shell).run(true, false, syncRunnable);
        } catch (InterruptedException ex) {
            throw new IllegalStateException(
                    Messages.projSyncSrc_repository_sync_uncancellable_thread_interrupted, ex);
        } catch (InvocationTargetException ex) {
            throw new IllegalStateException(
                    Messages.projSyncSrc_couldnt_synchronize_repository_with_remote, ex);
        }

        if (conflicted.get()) {
            MessageBox mb = new MessageBox(shell, SWT.ICON_ERROR);
            mb.setText(Messages.projSyncSrc_sync_error);
            mb.setMessage(Messages.projSyncSrc_repository_cache_has_conflict_resolve_them_manually);
            mb.open();
        }else{
            events.send(EVENT.REOPEN_PROJECT, proj);
        }

        return !conflicted.get();
    }
}