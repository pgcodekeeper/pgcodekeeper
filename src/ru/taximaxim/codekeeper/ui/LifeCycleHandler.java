package ru.taximaxim.codekeeper.ui;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class LifeCycleHandler {

    @PostContextCreate
    private void postContextCreate(IEclipseContext ctx, IEventBroker ev) {
        ctx.declareModifiable(PgDbProject.class);
        /*
        ev.subscribe(UIEvents.ALL_SUB_TOPICS, new EventHandler() {
    
    @Override
    public void handleEvent(Event event) {
    System.out.print(event.getTopic() + "\t\\\t");
    if (event.containsProperty("ChangedElement")) {
    Object o = event.getProperty("ChangedElement");
    System.out.print(o.getClass().getName());
    
    if (o instanceof MApplicationElement) {
    MApplicationElement appEl = (MApplicationElement) o;
    System.out.print("\t" + appEl.getElementId());
    }
    }
    System.out.println();
    }
    });*/
    }
}
