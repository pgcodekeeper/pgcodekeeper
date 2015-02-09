package ru.taximaxim.codekeeper.ui.consoles;

import java.io.IOException;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.IOConsoleOutputStream;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;

class CodekeeperConsole extends IOConsole implements IPropertyChangeListener {

    public static final String NAME = "pgCodeKeeper"; //$NON-NLS-1$
    
    private IOConsoleOutputStream outer;
    
    public CodekeeperConsole() {
        this(NAME, null);
    }
    
    private CodekeeperConsole(String name, ImageDescriptor imageDescriptor) {
        super(name, imageDescriptor);
        Activator.getDefault().getPreferenceStore().addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getProperty().equals(PREF.FORCE_SHOW_CONSOLE)
                && !event.getOldValue().equals(event.getNewValue())) {
            if (outer != null) {
                outer.setActivateOnWrite((Boolean) event.getNewValue());
            }
        }
    }

    @Override
    protected void dispose() {
        Activator activator = Activator.getDefault();
        if (activator != null) {
            activator.getPreferenceStore().removePropertyChangeListener(this);
        }
        super.dispose();
    }
    
    void write(String msg) {
        try {
            if (outer == null) {
                outer = this.newOutputStream();
                outer.setActivateOnWrite(Activator.getDefault()
                        .getPreferenceStore().getBoolean(PREF.FORCE_SHOW_CONSOLE));
            }
            outer.write(msg + UIConsts._NL);
        } catch (IOException e) {
            ConsolePlugin.log(e);
        }
    };
}
