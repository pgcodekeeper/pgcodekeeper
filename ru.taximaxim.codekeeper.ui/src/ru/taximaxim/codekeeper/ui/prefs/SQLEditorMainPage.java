package ru.taximaxim.codekeeper.ui.prefs;

import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.SQL_EDITOR_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class SQLEditorMainPage extends PreferencePage implements IWorkbenchPreferencePage {

    private Button btnHighlight;
    private Button btnMatchBrackets;
    private Button btnMatchCaret;
    private Button btnEnclosing;
    private Composite radioComposite;
    private ColorSelector color;

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected Control createContents(Composite parent) {
        IPreferenceStore store = getPreferenceStore();
        boolean state = store.getBoolean(SQL_EDITOR_PREF.MATCHING_BRACKETS);

        Composite area = new Composite(parent, SWT.NONE);
        area.setLayout(new GridLayout(2, false));
        area.setLayoutData(new GridData(GridData.FILL_BOTH));

        btnHighlight = new Button(area, SWT.CHECK);
        btnHighlight.setText(Messages.SQLEditorMainPage_bracket_highlighting);
        btnHighlight.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
        btnHighlight.setSelection(state);
        btnHighlight.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                setEnableButtons(btnHighlight.getSelection());
            }
        });

        radioComposite = new Composite(area, SWT.NONE);
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

        new Label(area, SWT.NONE).setText(Messages.SQLEditorMainPage_matching_bracket_highlighting_color);
        color = new ColorSelector(area);
        color.setColorValue(StringConverter.asRGB(store.getString(SQL_EDITOR_PREF.MATCHING_BRACKETS_COLOR)));

        setEnableButtons(state);

        return area;
    }

    private void setEnableButtons(boolean state) {
        for (Control child : radioComposite.getChildren()) {
            child.setEnabled(state);
        }
    }

    @Override
    public boolean performOk() {
        IPreferenceStore store = getPreferenceStore();
        store.setValue(SQL_EDITOR_PREF.MATCHING_BRACKETS, btnHighlight.getSelection());
        store.setValue(SQL_EDITOR_PREF.ENCLOSING_BRACKETS, btnEnclosing.getSelection());
        store.setValue(SQL_EDITOR_PREF.HIGHLIGHT_BRACKET_AT_CARET_LOCATION, !btnMatchBrackets.getSelection());
        store.setValue(SQL_EDITOR_PREF.MATCHING_BRACKETS_COLOR, StringConverter.asString(color.getColorValue()));
        return true;
    }

    @Override
    protected void performDefaults() {
        IPreferenceStore store = getPreferenceStore();
        btnHighlight.setSelection(true);
        btnMatchBrackets.setSelection(false);
        btnMatchCaret.setSelection(false);
        btnEnclosing.setSelection(true);
        setEnableButtons(true);
        color.setColorValue(StringConverter.asRGB(store.getDefaultString(SQL_EDITOR_PREF.MATCHING_BRACKETS_COLOR)));
    }
}
