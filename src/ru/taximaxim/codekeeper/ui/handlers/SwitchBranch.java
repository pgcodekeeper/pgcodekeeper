 
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
	        Shell shell) throws IOException {
		final Git git = Git.open(
		        new File(proj.getString(UIConsts.PROJ_PREF_REPO_ROOT_PATH)));

	    final Ref headOld;
		try {
		    headOld = git.getRepository().getRef(Constants.HEAD);
	        BranchOperationUI.checkout(git.getRepository()).start();
	    } catch (Exception ex) {
	        git.close();
	        throw ex;
	    }
	    
	    new Thread(new Runnable() {
            
            @Override
            public void run() {
                try {
                    jobs.join(JobFamilies.CHECKOUT, null);
                    
                    if (!headOld.getObjectId().equals(git.getRepository()
                            .getRef(Constants.HEAD).getObjectId())) {
                        sync.asyncExec(new Runnable() {
                            
                            @Override
                            public void run() {
                                events.send(UIConsts.EVENT_REOPEN_PROJECT, proj);
                            }
                        });
                    }
                } catch (IOException | InterruptedException ex) {
                    throw new IllegalStateException(ex);
                } finally {
                    git.close();
                }
            }
        }).start();
	}
	
	@CanExecute
	public boolean canExecute(PgDbProject proj) {
		return proj != null;
	}	
}