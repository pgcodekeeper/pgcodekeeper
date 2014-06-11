 
package ru.taximaxim.codekeeper.ui.handlers;

import java.io.File;
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.atomic.AtomicReference;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobManager;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.egit.ui.JobFamilies;
import org.eclipse.egit.ui.internal.branch.BranchOperationUI;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.statushandlers.StatusManager;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

@SuppressWarnings("restriction")
public class SwitchBranch {
    
    @Inject
    IEventBroker events;
    
    @Inject
    IJobManager jobs;
    
    @Inject
    UISynchronize sync;
    
	@Execute
	public void execute(final PgDbProject proj,
	        @Named(IServiceConstants.ACTIVE_SHELL)
	        final Shell shell) {
	    final AtomicReference<Git> git = new AtomicReference<>();
        try {
            git.set(Git.open(
                    new File(proj.getString(UIConsts.PROJ_PREF_REPO_ROOT_PATH))));
    	    final Ref headOld = git.get().getRepository().getRef(Constants.HEAD);
    	    BranchOperationUI.checkout(git.get().getRepository()).start();
    	    
    	    Thread t = new Thread(new Runnable() {
                
                @Override
                public void run() {
                    try {
                        jobs.join(JobFamilies.CHECKOUT, null);
                        
                        if (!headOld.getObjectId().equals(git.get().getRepository()
                                .getRef(Constants.HEAD).getObjectId())) {
                            sync.asyncExec(new Runnable() {
                                
                                @Override
                                public void run() {
                                    events.send(UIConsts.EVENT_REOPEN_PROJECT, proj);
                                }
                            });
                        }
                    } catch (IOException | InterruptedException ex) {
                        Status status = new Status(IStatus.ERROR, UIConsts.PLUGIN_ID, 
                                "Exception thrown during running checkout job", ex);
                        StatusManager.getManager().handle(status, StatusManager.BLOCK);
                    } finally {
                        git.get().close();
                    }
                }
            });
            t.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
                
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    Status status = new Status(IStatus.ERROR, UIConsts.PLUGIN_ID, 
                            "Exception during switching branch", e);
                    StatusManager.getManager().handle(status, StatusManager.BLOCK);
                }
            });
            t.start();
        } catch (IOException e) {
            if (git != null) {
                git.get().close();
            }
            
            Status status = new Status(IStatus.ERROR, UIConsts.PLUGIN_ID, 
                    "Wrong repository or ref name", e);
            StatusManager.getManager().handle(status, StatusManager.BLOCK);
        }
    }

    @CanExecute
    public boolean canExecute(PgDbProject proj) {
        return proj != null;
    }
}