package ru.taximaxim.codekeeper.ui;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

import ru.taximaxim.codekeeper.ui.externalcalls.JGitExec;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class AddonWindowLabel {
    
    @Inject
    IEventBroker eventBroker;
    
    @Inject
    EModelService service;
    
    @Inject
    MApplication app;
    
    @Inject
    private void updateLabel(
            PgDbProject proj,
            @Optional @Named("__DUMMY__") @EventTopic(UIConsts.EVENT_REOPEN_PROJECT)
            PgDbProject proj2) throws IOException {
        String windowLabel = "pgCodeKeeper";
        
        if (proj != null) {
            String p = proj.getRepoRoot().toString();
            windowLabel += "  \u2014  " + proj.getProjectWorkingDir() + " [branch: " + 
                    new JGitExec().getCurrentBranch(p) + "]";
        }

        MWindow window = (MWindow) service.find(UIConsts.WINDOW_MAIN_ID, app);
        if (window != null) {
            window.setLabel(windowLabel);
        }
    }
}