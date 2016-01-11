package ru.taximaxim.codekeeper.ui.prefs;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
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

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected void createFieldEditors() {
        // TODO Auto-generated method stub
        prjUpdateIsBackLight =
                new BooleanFieldEditor(PG_EDIT_PREF.PRJ_UPDATE_EDITOR_IS_BACKLIGHT,
                        Messages.pgProjectEditor_is_prj_update_backlight, getFieldEditorParent());
        addField(prjUpdateIsBackLight);

        prjUpdateBackLightColor = new ColorFieldEditor(PG_EDIT_PREF.PRJ_UPDATE_EDITOR_BACKLIGHT,
                "", getFieldEditorParent());
        addField(prjUpdateBackLightColor);

        dbUpdateIsBackLight =
                new BooleanFieldEditor(PG_EDIT_PREF.DB_UPDATE_EDITOR_IS_BACKLIGHT,
                        Messages.pgProjectEditor_is_db_update_backlight, getFieldEditorParent());
        addField(dbUpdateIsBackLight);

        prjDbBackLightColor = new ColorFieldEditor(PG_EDIT_PREF.DB_UPDATE_EDITOR_BACKLIGHT, "", getFieldEditorParent());
        addField(prjDbBackLightColor);
    }

    @Override
    protected Control createContents(Composite parent) {
        // TODO Auto-generated method stub
        return super.createContents(parent);
    }

    @Override
    protected void performApply() {
        super.performApply();

    }
}
