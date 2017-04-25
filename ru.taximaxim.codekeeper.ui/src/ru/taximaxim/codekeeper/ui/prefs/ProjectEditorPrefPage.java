package ru.taximaxim.codekeeper.ui.prefs;

import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.PG_EDIT_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ProjectEditorPrefPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage{

    private BooleanFieldEditor prjUpdateIsBackLight;
    private ColorFieldEditor prjUpdateBackLightColor;

    public ProjectEditorPrefPage() {
        super(GRID);
    }

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected void createFieldEditors() {

        addField( new ComboFieldEditor(PG_EDIT_PREF.PERSPECTIVE_CHANGING_STATUS,
                Messages.generalPrefPage_perspective_changing_status, new String[][] {
            {Messages.prespective_change_status_always,MessageDialogWithToggle.ALWAYS},
            {Messages.prespective_change_status_never,MessageDialogWithToggle.NEVER},
            {Messages.prespective_change_status_ask,MessageDialogWithToggle.PROMPT}},
                getFieldEditorParent()));
    }
}
