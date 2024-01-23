/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.text.templates.TemplateStoreCore;
import org.eclipse.ui.texteditor.templates.TemplatePreferencePage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorTemplateManager;

public class SQLEditorTemplatePrefPage extends TemplatePreferencePage {

    public SQLEditorTemplatePrefPage() {
        try {
            setPreferenceStore(Activator.getDefault().getPreferenceStore());
            setTemplateStore(SQLEditorTemplateManager.getInstance()
                    .getTemplateStore());
            setContextTypeRegistry(SQLEditorTemplateManager.getInstance()
                    .getContributionContextTypeRegistry());
        } catch (Exception ex) {
            Log.log(Log.LOG_ERROR, "Cannot get sql templates", ex); //$NON-NLS-1$
        }
    }

    @Override
    protected boolean isShowFormatterSetting() {
        return false;
    }

    @Override
    protected Control createContents(Composite ancestor) {
        Control control = super.createContents(ancestor);
        getTableViewer().setContentProvider(new OnlyUserTemplatesContentProvider());
        return control;
    }

    private static class OnlyUserTemplatesContentProvider implements IStructuredContentProvider {

        private TemplateStoreCore fStore;

        @Override
        public Object[] getElements(Object input) {
            return fStore.getTemplateData(false);
        }

        @Override
        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            fStore = (TemplateStoreCore) newInput;
        }

        @Override
        public void dispose() {
            fStore = null;
        }
    }
}
