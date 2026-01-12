/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.prefs;

import java.util.Objects;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Widget;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.ProjectIcon;
import ru.taximaxim.codekeeper.ui.UiSync;

public class PrefChangeAction extends Action implements IPropertyChangeListener {

    private final String prefName;
    private final IPreferenceStore preferences;
    private final Widget widget;

    public PrefChangeAction(String name, String prefName, IPreferenceStore preferences,
            Widget widget, ProjectIcon icon) {
        super(name);
        this.prefName = prefName;
        this.preferences = preferences;
        this.widget = widget;

        setImageDescriptor(Activator.getRegisteredDescriptor(icon));
        setChecked(preferences.getBoolean(prefName));
        preferences.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(final PropertyChangeEvent event) {
        if (event.getNewValue() != null && prefName.equals(event.getProperty())
                && !Objects.equals(event.getOldValue(), event.getNewValue())) {
            UiSync.exec(widget, (Runnable) () -> {
                if (!widget.isDisposed()) {
                    setChecked((boolean) event.getNewValue());
                    refresh();
                }
            });
        }
    }

    public void refresh() {
        // subclasses will override if needed
    }

    @Override
    public void run() {
        preferences.setValue(prefName, isChecked());
    }

    public void dispose() {
        preferences.removePropertyChangeListener(this);
    }
}