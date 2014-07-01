package ru.taximaxim.codekeeper.ui;

import java.util.Map;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.commands.MHandlerContainer;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

/**
 * Listens for contexts being created, waits for the one associated with
 * provided part and injects provided values into it.
 * 
 * This is to workaround the {@link MPart} creation process where as soon as the
 * MPart is activated its {@link IEclipseContext} is created and
 * the contribution POJO is injected immediately giving no chance
 * to inject custom values for the MPart to work with.
 * 
 * @author Alexander Levsha
 */
public class PartContextInjector implements EventHandler {

    final private MPart part;
    
    final private Map<Object, Object> values;
    
    final private IEventBroker events;
    
    public PartContextInjector(MPart part, Map<Object, Object> values,
            IEventBroker events) {
        if(values.isEmpty()) {
            throw new IllegalArgumentException(Messages.PartContextInjector_empty_values_map);
        }
        
        this.part = part;
        this.values = values;
        this.events = events;
    }

    @Override
    public void handleEvent(Event e) {
        Object origin = e.getProperty(UIEvents.EventTags.ELEMENT);
        Object ctxObj = e.getProperty(UIEvents.EventTags.NEW_VALUE);
        
        if((origin instanceof MHandlerContainer)
            && UIEvents.EventTypes.SET.equals(e.getProperty(UIEvents.EventTags.TYPE))
            && (ctxObj instanceof IEclipseContext)) {
                IEclipseContext ctx = (IEclipseContext) ctxObj;
                MPart part = ctx.get(MPart.class);
                
                if(this.part == part) {
                    try {
                        for(Map.Entry<Object, Object> entry : values.entrySet()) {
                            Object key = entry.getKey();
                            
                            if(key instanceof Class) {
                                contextSetGenericsWorkaround(
                                        (Class<?>) key, entry.getValue(), ctx);
                            } else if(key instanceof String) {
                                ctx.set((String) key, entry.getValue());
                            } else {
                                throw new IllegalArgumentException(
                                        Messages.PartContextInjector_only_class_and_string_are_allowed
                                        + Messages.PartContextInjector_as_key_in_ieclipsecontext);
                            }
                        }
                    } finally {
                        // we tried to inject the data, we shouldn't listen anymore
                        events.unsubscribe(this);
                    }
                }
            }
    }
    
    private <T> void contextSetGenericsWorkaround(Class<T> clazz, Object v,
            IEclipseContext ctx) {
        ctx.set(clazz, clazz.cast(v));
    }
}
