package ru.taximaxim.codekeeper.ui.consoles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.IOConsoleOutputStream;

import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UiSync;

class CodekeeperConsole extends IOConsole implements IPropertyChangeListener {

    private static final String NAME = "pgCodeKeeper"; //$NON-NLS-1$
    private static final String TERMINATED = "<terminated>"; //$NON-NLS-1$

    private final Color colorWarn;
    private final Color colorErr;

    private final IOConsoleOutputStream baseOuter;
    private final IOConsoleOutputStream warningOuter;
    private final IOConsoleOutputStream errorOuter;
    private final IProgressMonitor monitor;
    private final List<IPropertyChangeListener> listeners = new ArrayList<>();

    private volatile boolean isTerminated;

    public CodekeeperConsole(IProgressMonitor monitor) {
        super(FileUtils.getFileDate() + ' ' + CodekeeperConsole.NAME, null);
        this.monitor = monitor;
        baseOuter = this.newOutputStream();
        baseOuter.setActivateOnWrite(Activator.getDefault()
                .getPreferenceStore().getBoolean(PREF.FORCE_SHOW_CONSOLE));

        warningOuter = this.newOutputStream();
        warningOuter.setActivateOnWrite(Activator.getDefault()
                .getPreferenceStore().getBoolean(PREF.FORCE_SHOW_CONSOLE));

        errorOuter = this.newOutputStream();
        errorOuter.setActivateOnWrite(Activator.getDefault()
                .getPreferenceStore().getBoolean(PREF.FORCE_SHOW_CONSOLE));

        Activator.getDefault().getPreferenceStore().addPropertyChangeListener(this);

        Display display = PlatformUI.getWorkbench().getDisplay();
        Color colorWarn = null;
        Color colorErr = null;
        // guard against resource leaks
        try {
            colorWarn = new Color(display, 255, 127, 0);
            warningOuter.setColor(colorWarn);
            colorErr = new Color(display, 255, 0, 0);
            errorOuter.setColor(colorErr);
        } catch (Exception ex) {
            if (colorWarn != null) {
                warningOuter.setColor(null);
                colorWarn.dispose();
            }
            if (colorErr != null) {
                errorOuter.setColor(null);
                colorErr.dispose();
            }
            throw ex;
        }
        this.colorWarn = colorWarn;
        this.colorErr = colorErr;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getNewValue() != null
                && PREF.FORCE_SHOW_CONSOLE.equals(event.getProperty())
                && !Objects.equals(event.getOldValue(), event.getNewValue())) {
            boolean val = (boolean) event.getNewValue();
            baseOuter.setActivateOnWrite(val);
            warningOuter.setActivateOnWrite(val);
            errorOuter.setActivateOnWrite(val);
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
        if (colorWarn != null) {
            colorWarn.dispose();
        }
        if (colorErr != null) {
            colorErr.dispose();
        }
        super.dispose();
    }

    void write(String msg) {
        writeMsg(msg, baseOuter);
    }

    void writeWarning(String msg) {
        writeMsg(msg, warningOuter);
    }

    void writeError(String msg) {
        writeMsg(msg, errorOuter);
    }

    private void writeMsg(String msg, IOConsoleOutputStream outer) {
        try {
            outer.write(msg);
            outer.write(UIConsts._NL);
        } catch (IOException e) {
            Log.log(e);
        }
    }

    void terminate() {
        isTerminated = true;
        UiSync.exec(PlatformUI.getWorkbench().getDisplay(),
                () -> setName(TERMINATED + ' ' + getName()));
        notifyListeners();
    }

    void cancel() {
        monitor.setCanceled(true);
    }

    boolean isTerminated() {
        return isTerminated;
    }

    void addListener(IPropertyChangeListener listener) {
        listeners.add(listener);
    }

    void deleteListener(IPropertyChangeListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        listeners.forEach(e -> e.propertyChange(null));
    }
}