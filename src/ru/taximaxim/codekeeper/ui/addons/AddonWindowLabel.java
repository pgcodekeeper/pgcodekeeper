package ru.taximaxim.codekeeper.ui.addons;

import java.io.IOException;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

import ru.taximaxim.codekeeper.ui.UIConsts.EVENT;
import ru.taximaxim.codekeeper.ui.externalcalls.JGitExec;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class AddonWindowLabel {
    
    @Inject
    UISynchronize sync;
    
    @Inject
    private EModelService service;
    
    @Inject
    private MApplication app;
    
    @Inject
    private void updateLabel(
            PgDbProject proj,
            @Optional @EventTopic(EVENT.REOPEN_PROJECT)
            PgDbProject proj2) throws IOException {
        String windowLabel = "pgCodeKeeper"; //$NON-NLS-1$
        
        if (proj != null) {
            windowLabel += "  \u2014  " + proj.getProjectWorkingDir() +  //$NON-NLS-1$
                    " [branch: " + new JGitExec().getCurrentBranch(proj.getRepoRoot()) + "]"; //$NON-NLS-1$ //$NON-NLS-2$
        }
// FIXME window title
        final MWindow window = null;//(MWindow) service.find(WINDOW.MAIN, app);
        final String newLabel = windowLabel;
        if (window != null) {
            sync.asyncExec(new Runnable() {
                
                @Override
                public void run() {
                    window.setLabel(newLabel);
                }
            });
        }
    }
}
