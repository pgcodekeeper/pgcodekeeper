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
package ru.taximaxim.codekeeper.ui.prefs;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public final class TempBooleanFieldEditor extends BooleanFieldEditor {

    private final Composite parent;

    public TempBooleanFieldEditor(String name, String label, Composite parent, boolean defaultValue) {
        super(name, label, parent);
        this.parent = parent;
        setSelection(defaultValue);
    }

    public TempBooleanFieldEditor(String name, String label, Composite parent, Predicate<String> getter) {
        this(name, label, parent, getter.test(name));
    }

    public TempBooleanFieldEditor(String name, String label, Composite parent, BiPredicate<String, Boolean> getter,
            boolean getterArg) {
        this(name, label, parent, getter.test(name, getterArg));
    }

    public TempBooleanFieldEditor(String name, String label, Composite parent, BiPredicate<String, Boolean> getter) {
        this(name, label, parent, getter, false);
    }

    public void setSelection(boolean selection) {
        getButton().setSelection(selection);
    }

    public void setToolTipText(String toolTip) {
        getButton().setToolTipText(toolTip);
    }

    public void setEnabled(boolean enabled) {
        getButton().setEnabled(enabled);
    }

    public void setVisible(boolean visible) {
        getButton().setVisible(visible);
    }

    private Button getButton() {
        return getChangeControl(parent);
    }
}