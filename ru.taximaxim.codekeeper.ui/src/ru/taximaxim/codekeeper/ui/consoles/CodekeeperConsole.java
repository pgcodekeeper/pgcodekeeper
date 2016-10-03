package ru.taximaxim.codekeeper.ui.consoles;

import java.io.IOException;
import java.util.Objects;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.IOConsoleOutputStream;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
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
        if (outer != null && event.getNewValue() != null
                && PREF.FORCE_SHOW_CONSOLE.equals(event.getProperty())
                && !Objects.equals(event.getOldValue(), event.getNewValue())) {
            outer.setActivateOnWrite((boolean) event.getNewValue());
        }
    }

    @Override
    protected void dispose() {
        Activator activator = Activator.getDefault();
        if (activator != null) {
            IPreferenceStore prefs = activator.getPreferenceStore();
            if (prefs != null) {
                prefs.removePropertyChangeListener(this);
            }
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
            Log.log(e);
        }
    };
}
