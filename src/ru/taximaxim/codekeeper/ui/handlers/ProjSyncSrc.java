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
import ru.taximaxim.codekeeper.ui.externalcalls.GitExec;
import ru.taximaxim.codekeeper.ui.externalcalls.IRepoWorker;
import ru.taximaxim.codekeeper.ui.externalcalls.SvnExec;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject.RepoType;

public class ProjSyncSrc {

    @Execute
    private void execute(PgDbProject proj, @Named(IServiceConstants.ACTIVE_SHELL) Shell shell, @Named(UIConsts.PREF_STORE) IPreferenceStore prefStore) throws IOException, InvocationTargetException {
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
    public static boolean sync(final PgDbProject proj, Shell shell, final IPreferenceStore mainPrefs) throws IOException, InvocationTargetException {
        final boolean[] conflicted = { false };
        IRunnableWithProgress syncRunnable = new IRunnableWithProgress() {
            @Override
            public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                SubMonitor pm = SubMonitor.convert(monitor, "Syncing repository cache", 10);
                IRepoWorker repo;
                switch (RepoType.valueOf(proj.getString(UIConsts.PROJ_PREF_REPO_TYPE))) {
                case SVN:
                    repo = new SvnExec(mainPrefs.getString(UIConsts.PREF_SVN_EXE_PATH), proj);
                    break;
                case GIT:
                    repo = new GitExec(mainPrefs.getString(UIConsts.PREF_GIT_EXE_PATH), proj);
                    break;
                default:
                    throw new IllegalStateException("Not a SVN/GIT enabled project");
                }

                File repoDir = proj.getProjectSchemaDir();

                try {
                    pm.newChild(2).subTask("Checking conflicts...");
                    conflicted[0] = repo.hasConflicts(repoDir);

                    if (!conflicted[0]) {
                        pm.newChild(8).subTask("Updating cache...");
                        conflicted[0] = !repo.repoUpdate(repoDir);
                    }
                } catch (IOException ex) {
                    throw new InvocationTargetException(ex);
                }
                monitor.done();
            }
        };

        try {
            new ProgressMonitorDialog(shell).run(true, false, syncRunnable);
        } catch (InterruptedException ex) {
            throw new IllegalStateException("Uncancellable thread interrupted!", ex);
        }

        if (conflicted[0]) {
            MessageBox mb = new MessageBox(shell, SWT.ICON_ERROR);
            mb.setText("Sync error!");
            mb.setMessage("Repository cache has conflicts!" + " Resolve them manually and reload project before continuing.");
            mb.open();
        }

        return !conflicted[0];
    }
}