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

import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.PG_EDIT_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ProjectEditorPrefPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    public ProjectEditorPrefPage() {
        super(GRID);
    }

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected void createFieldEditors() {
        addField(new ComboFieldEditor(PG_EDIT_PREF.PERSPECTIVE_CHANGING_STATUS,
                Messages.generalPrefPage_perspective_changing_status, new String[][] {
            {Messages.prespective_change_status_always, MessageDialogWithToggle.ALWAYS},
            {Messages.prespective_change_status_never, MessageDialogWithToggle.NEVER},
            {Messages.prespective_change_status_ask, MessageDialogWithToggle.PROMPT}},
                getFieldEditorParent()));

        addField(new ComboFieldEditor(PG_EDIT_PREF.EDITOR_UPDATE_ACTION,
                Messages.ProjectEditorPrefPage_action_type, new String[][] {
            {Messages.ProjectEditorPrefPage_action_update, PG_EDIT_PREF.UPDATE},
            {Messages.ProjectEditorPrefPage_action_reset, PG_EDIT_PREF.RESET},
            {Messages.ProjectEditorPrefPage_action_no_action, PG_EDIT_PREF.NO_ACTION}},
                getFieldEditorParent()));

        addField(new BooleanFieldEditor(PG_EDIT_PREF.SHOW_GIT_USER,
                Messages.ProjectEditorPrefPage_show_git_user,
                getFieldEditorParent()));

        addField(new BooleanFieldEditor(PG_EDIT_PREF.SHOW_DIFF_ERRORS,
                Messages.GeneralPrefPage_show_diff_errors,
                getFieldEditorParent()));

        addField(new BooleanFieldEditor(PG_EDIT_PREF.SHOW_FULL_CODE,
                Messages.GeneralPrefPage_show_full_code,
                getFieldEditorParent()));
    }
}
