package ru.taximaxim.codekeeper.ui.addons;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.workbench.UIEvents.UILifeCycle;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

public class AddonWindowMax {

    @PostConstruct
    private void attachOneTimeListener(
            final IEventBroker events,
            final UISynchronize sync) {
        events.subscribe(UILifeCycle.APP_STARTUP_COMPLETE, new EventHandler() {
            
            @Override
            public void handleEvent(Event event) {
                events.unsubscribe(this);
                
                sync.asyncExec(new Runnable() {
                    
                    @Override
                    public void run() {
                        PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                                .getShell().setMaximized(true);
                    }
                });
            }
        });
    }
}
