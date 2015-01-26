package ru.taximaxim.codekeeper.ui.handlers;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.fileutils.ProjectUpdater;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import cz.startnet.utils.pgdiff.loader.ParserClass;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class NormalizeProject extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        final Shell shell = HandlerUtil.getActiveShell(event);
        final PgDbProject proj = OpenProjectUtils.getProject(event);
        
        if (!OpenProjectUtils.checkVersionAndWarn(proj.getProject(), shell, false)) {
            return null;
        }
        
        MessageBox mbSure = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
        mbSure.setText(Messages.NormalizeProject_normalize_project);
        mbSure.setMessage(Messages.NormalizeProject_are_you_sure);
        if (mbSure.open() != SWT.YES) {
            return null;
        }
        
        Log.log(Log.LOG_INFO, "Normalizing project " + proj.getProjectName()); //$NON-NLS-1$
        Job job = new Job(Messages.NormalizeProject_normalizing_project) {
            
            @Override
            protected IStatus run(IProgressMonitor monitor) {
                SubMonitor mon = SubMonitor.convert(monitor, Messages.NormalizeProject_normalizing_project, 2);
                try {
                    PgDatabase db = DbSource.fromProject(Activator.getDefault()
                            .getPreferenceStore().getBoolean(PREF.USE_ANTLR) ? 
                                    ParserClass.ANTLR : ParserClass.LEGACY, proj)
                                    .get(mon.newChild(1));
                    
                    mon.newChild(1).subTask(Messages.NormalizeProject_exporting_project);
                    new ProjectUpdater(db, null, null, proj).updateFull();
                } catch (IOException ex) {
                    return new Status(IStatus.ERROR, PLUGIN_ID.THIS,
                            Messages.NormalizeProject_error_while_updating_project, ex);
                }
                return Status.OK_STATUS;
            }
        };
        job.addJobChangeListener(new JobChangeAdapter() {
            
            @Override
            public void done(IJobChangeEvent event) {
                if (event.getResult().isOK()) {
                    Display.getDefault().asyncExec(new RunRefreshAfterNorm(proj, shell));
                }
            }
        });
        job.setUser(true);
        job.schedule();
        return null;
    }

    private static class RunRefreshAfterNorm implements Runnable {

        private final PgDbProject proj;
        private final Shell shell;

        RunRefreshAfterNorm(PgDbProject proj, Shell shell) {
            this.proj = proj;
            this.shell = shell;
        }

        @Override
        public void run() {
            try {
                proj.getProject().refreshLocal(
                        IResource.DEPTH_INFINITE, null);
            } catch (CoreException ex) {
                ExceptionNotifier.notifyDefault(
                        Messages.ProjectEditorDiffer_error_refreshing_project, ex);
            }
            
            if (shell.isDisposed()) {
                return;
            }
            MessageBox mb = new MessageBox(shell, SWT.ICON_INFORMATION);
            mb.setMessage(Messages.NormalizeProject_project_normalized_success);
            mb.setText(Messages.NormalizeProject_project_normalized);
            mb.open();
        }
    }
}
