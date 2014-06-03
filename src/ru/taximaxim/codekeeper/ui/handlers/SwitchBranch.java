 
package ru.taximaxim.codekeeper.ui.handlers;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

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

import ru.taximaxim.codekeeper.ui.ExceptionNotifier;
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
	        @Named(IServiceConstants.ACTIVE_SHELL) final
	        Shell shell){
	    final Git[] git = new Git [1];
        try {
            git[0] = Git.open(
                    new File(proj.getString(UIConsts.PROJ_PREF_REPO_ROOT_PATH)));
    	    final Ref headOld = git[0].getRepository().getRef(Constants.HEAD);
    	    BranchOperationUI.checkout(git[0].getRepository()).start();
    	    
    	    new Thread(new Runnable() {
                
                @Override
                public void run() {
                    try {
                        jobs.join(JobFamilies.CHECKOUT, null);
                        
                        if (!headOld.getObjectId().equals(git[0].getRepository()
                                .getRef(Constants.HEAD).getObjectId())) {
                            sync.asyncExec(new Runnable() {
                                
                                @Override
                                public void run() {
                                    events.send(UIConsts.EVENT_REOPEN_PROJECT, proj);
                                }
                            });
                        }
                    } catch (IOException | InterruptedException ex) {
                        ExceptionNotifier.notify(new IllegalStateException("Exception "
                                + "thrown during running checkout job: " + ex.toString(), ex),
                                shell, true, true);
                    } finally {
                        git[0].close();
                    }
                }
            }).start();
        } catch (IOException e) {
            if (git[0] != null){
                git[0].close();
            }
            ExceptionNotifier.notify(new IllegalStateException(
                    "Wrong repository or ref name: " + e.toString(), e), shell, true, true);
            return;
        }
	}
	
	@CanExecute
	public boolean canExecute(PgDbProject proj) {
		return proj != null;
	}	
}