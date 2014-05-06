 
package ru.taximaxim.codekeeper.ui;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.ui.bindings.EBindingService;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.jface.bindings.Binding;
import org.eclipse.jface.bindings.BindingManager;
import org.eclipse.jface.bindings.TriggerSequence;

public class AddonBindingConflict {
    
    @Inject
    EBindingService bindings;
    
    @Inject
    BindingManager bindingManager;
    
    @Inject
    @Optional
    private void startup(
            @EventTopic(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE)
            MApplication app) {
        // FIXME this hack allows reuse of 3.x keybinds in E4 App Model
        // this works only because BindingManager doesn't contain bindings defined in App Model
        // fragile code, relies on internal eclipse implementation
        Set<Binding> conflicts = new HashSet<>(bindings.getAllConflicts());
        for (Binding b : bindingManager.getBindings()) {
            if (conflicts.contains(b)) {
                StringBuilder msg = new StringBuilder(1000);
                msg.append("Trying to deactivate conflicting binding '");
                
                TriggerSequence seq = b.getTriggerSequence();
                if (seq != null) {
                    msg.append(seq.format());
                }
                msg.append("' with command id '");
                
                ParameterizedCommand cmd = b.getParameterizedCommand();
                if (cmd != null) {
                    msg.append(cmd.getId());
                }
                msg.append("'");
                
                Log.log(Log.LOG_WARNING, msg.toString());
                
                bindings.deactivateBinding(b);
            }
        }
    }
}