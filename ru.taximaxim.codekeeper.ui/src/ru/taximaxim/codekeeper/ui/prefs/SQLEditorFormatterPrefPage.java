package ru.taximaxim.codekeeper.ui.prefs;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FORMATTER_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class SQLEditorFormatterPrefPage extends FieldEditorPreferencePage
implements IWorkbenchPreferencePage {

    private IntegerFieldEditor replaceCount;

    public SQLEditorFormatterPrefPage() {
        super(GRID);
    }

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected void createFieldEditors() {
        addField(new IntegerFieldEditor(FORMATTER_PREF.INDENT_SIZE,
                Messages.SQLEditorFormatterPrefPage_indent_size,
                getFieldEditorParent(), 2));

        addField(new BooleanFieldEditor(FORMATTER_PREF.REMOVE_TRAILING_WHITESPACE,
                Messages.SQLEditorFormatterPrefPage_remove_trailing_whitespace,
                getFieldEditorParent()));

        addField(new BooleanFieldEditor(FORMATTER_PREF.ADD_WHITESPACE_BEFORE_OP,
                Messages.SQLEditorFormatterPrefPage_add_whitespace_before_operators,
                getFieldEditorParent()));

        addField(new BooleanFieldEditor(FORMATTER_PREF.ADD_WHITESPACE_AFTER_OP,
                Messages.SQLEditorFormatterPrefPage_add_whitespace_after_operators,
                getFieldEditorParent()));

        addField(new BooleanFieldEditor(FORMATTER_PREF.REPLACE_TAB,
                Messages.SQLEditorFormatterPrefPage_replace_tab_with_whitespaces,
                getFieldEditorParent()));

        replaceCount = new IntegerFieldEditor(FORMATTER_PREF.WHITESPACE_COUNT,
                Messages.SQLEditorFormatterPrefPage_whitespace_count,
                getFieldEditorParent(), 2);

        replaceCount.setEnabled(
                getPreferenceStore().getBoolean(FORMATTER_PREF.REPLACE_TAB),
                getFieldEditorParent());

        addField(replaceCount);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        FieldEditor source = (FieldEditor) event.getSource();
        if (source.getPreferenceName() == FORMATTER_PREF.REPLACE_TAB) {
            replaceCount.setEnabled(((boolean) event.getNewValue()), getFieldEditorParent());
        }

        super.propertyChange(event);
    }
}
