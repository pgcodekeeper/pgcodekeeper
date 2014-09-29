package ru.taximaxim.codekeeper.ui.addons;

import java.io.IOException;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.UIConsts.EVENT;
import ru.taximaxim.codekeeper.ui.externalcalls.JGitExec;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class AddonWindowLabel {
    
    @Inject
    private UISynchronize sync;
    
    @Inject
    private void updateLabel(
            PgDbProject proj,
            @Optional @EventTopic(EVENT.REOPEN_PROJECT)
            PgDbProject proj2) throws IOException {
        if (!PlatformUI.isWorkbenchRunning()) {
            return;
        }
        
        String windowLabel = "pgCodeKeeper"; //$NON-NLS-1$
        if (proj != null) {
            windowLabel += "  \u2014  " + proj.getPathToProject() +  //$NON-NLS-1$
                    " [branch: " + new JGitExec().getCurrentBranch(proj.getPathToProject().toFile()) + "]"; //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        final MWindow window = (MWindow) PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getService(MWindow.class);
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
