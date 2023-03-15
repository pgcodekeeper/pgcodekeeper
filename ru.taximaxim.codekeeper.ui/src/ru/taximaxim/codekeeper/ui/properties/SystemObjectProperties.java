/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.properties;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.dialogs.PropertyPage;
import org.osgi.service.prefs.BackingStoreException;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class SystemObjectProperties extends PropertyPage {

    private IEclipsePreferences prefs;

    /**
     * Delimiter for spacing parts of the storages
     */
    private static final String DELIM = "///t"; //$NON-NLS-1$

    private StoragePrefListEditor editor;

    @Override
    public void setElement(IAdaptable element) {
        super.setElement(element);
        prefs = new ProjectScope(element.getAdapter(IProject.class))
                .getNode(UIConsts.PLUGIN_ID.THIS);
    }

    @Override
    protected Control createContents(Composite parent) {
        editor = new StoragePrefListEditor(parent);

        String storage = prefs.get(PROJ_PREF.STORAGE_LIST, ""); //$NON-NLS-1$
        if (storage.isEmpty()) {
            editor.setInputList(new ArrayList<>());
        } else {
            editor.setInputList(new ArrayList<>(Arrays.asList(storage.split(DELIM))));
        }

        return editor;
    }

    @Override
    protected void performDefaults() {
        try {
            editor.setInputList(new ArrayList<>());
            fillPrefs();
        } catch (BackingStoreException e) {
            setErrorMessage(MessageFormat.format(
                    Messages.projectProperties_error_occurs_while_saving_properties,
                    e.getLocalizedMessage()));
            setValid(false);
        }
    }

    @Override
    public boolean performOk() {
        try {
            fillPrefs();
        } catch (BackingStoreException e) {
            setErrorMessage(MessageFormat.format(
                    Messages.projectProperties_error_occurs_while_saving_properties,
                    e.getLocalizedMessage()));
            setValid(false);
            return false;
        }
        return true;
    }

    private void fillPrefs() throws BackingStoreException {
        prefs.put(PROJ_PREF.STORAGE_LIST, String.join(DELIM, editor.getList()));
        prefs.flush();
        setValid(true);
        setErrorMessage(null);
    }
}