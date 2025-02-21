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
package ru.taximaxim.codekeeper.ui.sqledit;

import java.io.IOException;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.text.templates.ContextTypeRegistry;
import org.eclipse.ui.editors.text.templates.ContributionContextTypeRegistry;
import org.eclipse.ui.editors.text.templates.ContributionTemplateStore;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;

public class SQLEditorTemplateManager {

    public static final String TEMPLATE_ID_PROTECTION_MARKER = ".protected"; //$NON-NLS-1$
    private static final String CUSTOM_TEMPLATES_KEY = UIConsts.PLUGIN_ID.THIS
            + ".customtemplates"; //$NON-NLS-1$

    private static SQLEditorTemplateManager instance;
    private TemplateStore fStore;
    private ContributionContextTypeRegistry fRegistry;

    private SQLEditorTemplateManager() {
    }

    public static SQLEditorTemplateManager getInstance() {
        if (instance == null) {
            instance = new SQLEditorTemplateManager();
        }
        return instance;
    }

    public TemplateStore getTemplateStore() {

        if (fStore == null) {
            fStore = new ContributionTemplateStore(getContributionContextTypeRegistry(),
                    Activator.getDefault().getPreferenceStore(),
                    CUSTOM_TEMPLATES_KEY);
            try {
                fStore.load();
            } catch (IOException e) {
                Log.log(Log.LOG_ERROR, "Cannot load templates", e); //$NON-NLS-1$
            }
        }
        return fStore;
    }

    public ContextTypeRegistry getContextTypeRegistry() {
        // weird API deprecation workaround
        return getContributionContextTypeRegistry();
    }

    public ContributionContextTypeRegistry getContributionContextTypeRegistry() {
        if (fRegistry == null) {
            fRegistry = new ContributionContextTypeRegistry();
        }
        fRegistry.addContextType(SQLEditorTemplateContextType.CONTEXT_TYPE_PG);
        fRegistry.addContextType(SQLEditorTemplateContextType.CONTEXT_TYPE_MS);
        fRegistry.addContextType(SQLEditorTemplateContextType.CONTEXT_TYPE_CH);
        fRegistry.addContextType(SQLEditorTemplateContextType.CONTEXT_TYPE_COMMON);
        return fRegistry;
    }

    public IPreferenceStore getPreferenceStore() {
        return Activator.getDefault().getPreferenceStore();
    }
}
