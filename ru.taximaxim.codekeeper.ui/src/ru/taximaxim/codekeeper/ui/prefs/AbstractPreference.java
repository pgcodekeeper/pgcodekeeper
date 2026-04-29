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

import java.util.Set;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.ui.DatabaseType;

public abstract class AbstractPreference<T> {

    protected final String preferenceName;
    protected final String label;
    protected final String toolTipText;
    protected final PreferenceCategory category;
    protected final T initialValue;
    protected final boolean isNeedReset;
    protected final Set<DatabaseType> valiDbTypes;
    protected final Set<PreferenceScope> scopes;

    protected AbstractPreference(String preferenceName, PreferenceCategory category, String label, String toolTipText,
            T initialValue, boolean isNeedReset, Set<DatabaseType> validDbTypes, Set<PreferenceScope> scopes) {
        this.preferenceName = preferenceName;
        this.category = category;
        this.label = label;
        this.toolTipText = toolTipText;
        this.initialValue = initialValue;
        this.isNeedReset = isNeedReset;
        this.valiDbTypes = validDbTypes;
        this.scopes = scopes;
    }

    public String getPreferenceName() {
        return preferenceName;
    }

    public String getLabel() {
        return label;
    }

    public PreferenceCategory getCategory() {
        return category;
    }

    public boolean isNeedReset() {
        return isNeedReset;
    }

    public T getInitialValue() {
        return initialValue;
    }

    public boolean inScope(PreferenceScope scope) {
        return scopes.contains(scope);
    }

    public boolean isNeedForThisDbType(DatabaseType dbType, PreferenceScope scope) {
        if (PreferenceScope.GLOBAL == scope || null == dbType || valiDbTypes.isEmpty()) {
            return true;
        }
        return valiDbTypes.contains(dbType);
    }

    protected abstract void initialize(IPreferenceStore store);

    protected abstract FieldEditor create(Composite parent, PreferenceScope scope);
}
