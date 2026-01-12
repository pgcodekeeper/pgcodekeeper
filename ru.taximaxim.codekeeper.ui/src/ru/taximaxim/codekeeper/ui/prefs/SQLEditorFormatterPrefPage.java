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

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FORMATTER_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class SQLEditorFormatterPrefPage extends FieldEditorPreferencePage
implements IWorkbenchPreferencePage {

    private IntegerFieldEditor indentSize;

    public SQLEditorFormatterPrefPage() {
        super(GRID);
    }

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected void createFieldEditors() {
        IPreferenceStore store = getPreferenceStore();

        addField(new ComboFieldEditor(FORMATTER_PREF.INDENT_TYPE,
                Messages.SQLEditorFormatterPrefPage_indent_type, new String[][] {
            {Messages.SQLEditorFormatterPrefPage_whitespace, FORMATTER_PREF.WHITESPACE},
            {Messages.SQLEditorFormatterPrefPage_tab, FORMATTER_PREF.TAB},
            {Messages.SQLEditorFormatterPrefPage_disable, FORMATTER_PREF.DISABLE}},
                getFieldEditorParent()));

        indentSize = new IntegerFieldEditor(FORMATTER_PREF.INDENT_SIZE,
                Messages.SQLEditorFormatterPrefPage_indent_size,
                getFieldEditorParent(), 2);

        indentSize.setEnabled(
                !store.getString(FORMATTER_PREF.INDENT_TYPE).equals(FORMATTER_PREF.DISABLE),
                getFieldEditorParent());

        addField(indentSize);

        addField(new BooleanFieldEditor(FORMATTER_PREF.REMOVE_TRAILING_WHITESPACE,
                Messages.SQLEditorFormatterPrefPage_remove_trailing_whitespace,
                getFieldEditorParent()));

        addField(new BooleanFieldEditor(FORMATTER_PREF.ADD_WHITESPACE_BEFORE_OP,
                Messages.SQLEditorFormatterPrefPage_add_whitespace_before_operators,
                getFieldEditorParent()));

        addField(new BooleanFieldEditor(FORMATTER_PREF.ADD_WHITESPACE_AFTER_OP,
                Messages.SQLEditorFormatterPrefPage_add_whitespace_after_operators,
                getFieldEditorParent()));
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        FieldEditor source = (FieldEditor) event.getSource();
        if (FORMATTER_PREF.INDENT_TYPE.equals(source.getPreferenceName())) {
            indentSize.setEnabled(!event.getNewValue().equals(FORMATTER_PREF.DISABLE), getFieldEditorParent());
        }

        super.propertyChange(event);
    }
}
