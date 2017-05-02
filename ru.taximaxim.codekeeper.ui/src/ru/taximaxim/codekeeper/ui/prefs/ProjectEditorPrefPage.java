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
    private BooleanFieldEditor dbUpdateIsBackLight;
    private ColorFieldEditor prjDbBackLightColor;

    public ProjectEditorPrefPage() {
        super(GRID);
    }

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected void createFieldEditors() {
        prjUpdateIsBackLight =
                new BooleanFieldEditor(PG_EDIT_PREF.PRJ_UPDATE_EDITOR_IS_BACKLIGHT,
                        Messages.pgProjectEditor_is_prj_update_backlight, getFieldEditorParent());
        addField(prjUpdateIsBackLight);

        prjUpdateBackLightColor = new ColorFieldEditor(PG_EDIT_PREF.PRJ_UPDATE_EDITOR_BACKLIGHT,
                Messages.ProjectEditorPrefPage_project_color, getFieldEditorParent());
        addField(prjUpdateBackLightColor);

        dbUpdateIsBackLight =
                new BooleanFieldEditor(PG_EDIT_PREF.DB_UPDATE_EDITOR_IS_BACKLIGHT,
                        Messages.pgProjectEditor_is_db_update_backlight, getFieldEditorParent());
        addField(dbUpdateIsBackLight);

        prjDbBackLightColor = new ColorFieldEditor(PG_EDIT_PREF.DB_UPDATE_EDITOR_BACKLIGHT,
                Messages.ProjectEditorPrefPage_database_color, getFieldEditorParent());
        addField(prjDbBackLightColor);

        addField( new ComboFieldEditor(PG_EDIT_PREF.DELETE_SCRIPT_AFTER_CLOSE,
                Messages.ProjectEditorPrefPage_script_deleting_status, new String[][] {
            {Messages.ProjectEditorPrefPage_status_always_delete, MessageDialogWithToggle.ALWAYS},
            {Messages.ProjectEditorPrefPage_status_never_delete, MessageDialogWithToggle.NEVER},
            {Messages.ProjectEditorPrefPage_status_ask_delete, MessageDialogWithToggle.PROMPT}},
                getFieldEditorParent()));

        addField( new ComboFieldEditor(PG_EDIT_PREF.PERSPECTIVE_CHANGING_STATUS,
                Messages.generalPrefPage_perspective_changing_status, new String[][] {
            {Messages.prespective_change_status_always, MessageDialogWithToggle.ALWAYS},
            {Messages.prespective_change_status_never, MessageDialogWithToggle.NEVER},
            {Messages.prespective_change_status_ask, MessageDialogWithToggle.PROMPT}},
                getFieldEditorParent()));
    }
}
