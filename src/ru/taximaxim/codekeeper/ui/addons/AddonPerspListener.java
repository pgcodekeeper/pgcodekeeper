 
package ru.taximaxim.codekeeper.ui.addons;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PerspectiveAdapter;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.UIConsts.EVENT;
import ru.taximaxim.codekeeper.ui.UIConsts.PERSP;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class AddonPerspListener {

    @Inject
    private IEventBroker events;
    @Inject
    private PgDbProject proj;
    
    @Inject
    @Optional
    private void resetMainOnActivation(
            @EventTopic(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE)
            MApplication app,
            final IEclipseContext ctx, UISynchronize sync) {
        sync.syncExec(new Runnable() {
            
            @Override
            public void run() {
                PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                        .addPerspectiveListener(new PerspectiveAdapter() {

                            @Override
                            public void perspectiveActivated(IWorkbenchPage page,
                                    IPerspectiveDescriptor perspective) {
                                if (perspective.getId().equals(PERSP.MAIN)) {
                                    events.send(EVENT.REOPEN_PROJECT, proj);
                                }
                            }
                        });
            }
        });
    }
}