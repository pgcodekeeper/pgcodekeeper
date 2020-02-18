package ru.taximaxim.codekeeper.ui.prefs;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.SQL_EDITOR_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class SQLEditorMainPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    private Button btnMatchBrackets;
    private Button btnMatchCaret;
    private Button btnEnclosing;

    public SQLEditorMainPage() {
        super(GRID);
    }

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected void createFieldEditors() {
        IPreferenceStore store = getPreferenceStore();
        Composite area = getFieldEditorParent();

        addField(new IntegerFieldEditor(SQL_EDITOR_PREF.NUMBER_OF_LINES_LIMIT,
                Messages.SQLEditorMainPage_disable_parser, area, 7));

        addField(new BooleanFieldEditor(SQL_EDITOR_PREF.MATCHING_BRACKETS,
                Messages.SQLEditorMainPage_bracket_highlighting, area));

        Composite radioComposite = new Composite(area, SWT.NONE);
        GridData data = new GridData();
        data.horizontalSpan = 2;
        data.horizontalIndent = 20;
        radioComposite.setLayoutData(data);

        GridLayout radioLayout = new GridLayout();
        radioLayout.marginWidth = 0;
        radioLayout.marginHeight = 0;
        radioComposite.setLayout(radioLayout);

        btnMatchBrackets = new Button(radioComposite, SWT.RADIO);
        btnMatchBrackets.setText(Messages.SQLEditorMainPage_matching_bracket);

        btnMatchCaret = new Button(radioComposite, SWT.RADIO);
        btnMatchCaret.setText(Messages.SQLEditorMainPage_matching_bracket_and_caret_location);

        btnEnclosing = new Button(radioComposite, SWT.RADIO);
        btnEnclosing.setText(Messages.SQLEditorMainPage_enclosing_brackets);

        if (store.getBoolean(SQL_EDITOR_PREF.ENCLOSING_BRACKETS)) {
            btnEnclosing.setSelection(true);
        } else if (store.getBoolean(SQL_EDITOR_PREF.HIGHLIGHT_BRACKET_AT_CARET_LOCATION)) {
            btnMatchCaret.setSelection(true);
        } else {
            btnMatchBrackets.setSelection(true);
        }

        addField(new ColorFieldEditor(SQL_EDITOR_PREF.MATCHING_BRACKETS_COLOR,
                Messages.SQLEditorMainPage_matching_bracket_highlighting_color, area));

        setEnableButtons(store.getBoolean(SQL_EDITOR_PREF.MATCHING_BRACKETS));
    }

    private void setEnableButtons(boolean state) {
        btnMatchBrackets.setEnabled(state);
        btnMatchCaret.setEnabled(state);
        btnEnclosing.setEnabled(state);
    }

    @Override
    public boolean performOk() {
        if (!super.performOk()) {
            return false;
        }

        IPreferenceStore store = getPreferenceStore();
        store.setValue(SQL_EDITOR_PREF.ENCLOSING_BRACKETS, btnEnclosing.getSelection());
        store.setValue(SQL_EDITOR_PREF.HIGHLIGHT_BRACKET_AT_CARET_LOCATION, !btnMatchBrackets.getSelection());
        return true;
    }

    @Override
    protected void performDefaults() {
        super.performDefaults();
        btnMatchBrackets.setSelection(false);
        btnMatchCaret.setSelection(false);
        btnEnclosing.setSelection(true);
        setEnableButtons(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        FieldEditor source = (FieldEditor) event.getSource();
        if (source.getPreferenceName() == SQL_EDITOR_PREF.MATCHING_BRACKETS) {
            setEnableButtons((boolean) event.getNewValue());
        }

        super.propertyChange(event);
    }
}
