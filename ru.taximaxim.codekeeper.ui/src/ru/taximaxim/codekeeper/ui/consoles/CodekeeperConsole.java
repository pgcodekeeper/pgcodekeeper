/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.IOConsoleOutputStream;
import org.pgcodekeeper.core.utils.FileUtils;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.ProjectIcon;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UiSync;

class CodekeeperConsole extends IOConsole implements IPropertyChangeListener {

    private static final String NAME = "pgCodeKeeper"; //$NON-NLS-1$
    private static final String TERMINATED = "<terminated>"; //$NON-NLS-1$
    private static final int MAX_OLD_INSTANCES = 10;

    private final Color colorWarn;
    private final Color colorErr;

    private final IOConsoleOutputStream baseOuter;
    private final IOConsoleOutputStream warningOuter;
    private final IOConsoleOutputStream errorOuter;
    private final IProgressMonitor monitor;
    private final List<IPropertyChangeListener> listeners = new ArrayList<>();

    private volatile boolean isTerminated;

    public static CodekeeperConsole createInstance(IProgressMonitor monitor, String dbName) {
        IConsoleManager manager = ConsolePlugin.getDefault().getConsoleManager();
        IConsole[] consoles = manager.getConsoles();
        int c = 0;
        List<IConsole> toRemove = new ArrayList<>();
        for (int i = consoles.length - 1; i >= 0; --i) {
            var console = consoles[i];
            if (console instanceof CodekeeperConsole cc && cc.isTerminated() && c++ > MAX_OLD_INSTANCES) {
                toRemove.add(cc);
            }
        }
        if (!toRemove.isEmpty()) {
            manager.removeConsoles(toRemove.toArray(new IConsole[toRemove.size()]));
        }

        return new CodekeeperConsole(monitor, dbName);
    }

    private CodekeeperConsole(IProgressMonitor monitor, String dbName) {
        /*
         * '\t' is needed to prevent method LegacyActionTools.extractAcceleratorText(String) from truncating the
         * database name.
         */
        super(FileUtils.getFileDate() + ' ' + CodekeeperConsole.NAME + " - " + dbName + '\t', //$NON-NLS-1$
                Activator.getRegisteredDescriptor(ProjectIcon.APP_SMALL));
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
        Color tmpColorWarn = null;
        Color tmpColorErr = null;
        // guard against resource leaks
        try {
            tmpColorWarn = new Color(display, 255, 127, 0);
            warningOuter.setColor(tmpColorWarn);
            tmpColorErr = new Color(display, 255, 0, 0);
            errorOuter.setColor(tmpColorErr);
        } catch (Exception ex) {
            if (tmpColorWarn != null) {
                warningOuter.setColor(null);
                tmpColorWarn.dispose();
            }
            if (tmpColorErr != null) {
                errorOuter.setColor(null);
                tmpColorErr.dispose();
            }
            throw ex;
        }
        this.colorWarn = tmpColorWarn;
        this.colorErr = tmpColorErr;
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