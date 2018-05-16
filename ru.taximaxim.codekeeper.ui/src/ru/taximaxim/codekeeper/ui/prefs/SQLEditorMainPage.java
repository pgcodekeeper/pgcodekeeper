package ru.taximaxim.codekeeper.ui.prefs;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.SQL_EDITOR_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class SQLEditorMainPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected void createFieldEditors() {
        addField(new BooleanFieldEditor(SQL_EDITOR_PREF.MATCHING_BRACKETS,
                Messages.SQLEditorMainPage_bracket_highlighting, getFieldEditorParent()));

        addField(new ColorFieldEditor(SQL_EDITOR_PREF.MATCHING_BRACKETS_COLOR,
                Messages.SQLEditorMainPage_matching_bracket_highlighting_color, getFieldEditorParent()));

        addField(new BooleanFieldEditor(SQL_EDITOR_PREF.HIGHLIGHT_BRACKET_AT_CARET_LOCATION,
                Messages.SQLEditorMainPage_highlight_bracket_at_caret_location, getFieldEditorParent()));

        addField(new BooleanFieldEditor(SQL_EDITOR_PREF.ENCLOSING_BRACKETS,
                Messages.SQLEditorMainPage_enclosing_brackets, getFieldEditorParent()));
    }
}
