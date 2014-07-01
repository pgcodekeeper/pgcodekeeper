package ru.taximaxim.codekeeper.ui.prefs;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.UIConsts;

public class GeneralPrefPage extends FieldEditorPreferencePage
        implements IWorkbenchPreferencePage  {

    public GeneralPrefPage() {
        super(GRID);
    }
    
    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(UIScopedPreferenceStore.get());   
    }
    
    @Override
    protected void createFieldEditors() {
        addField(
                new FileFieldEditor(UIConsts.PREF_PGDUMP_EXE_PATH, Messages.GeneralPrefPage_pg_dump_executable, getFieldEditorParent()){
                    @Override
                    protected boolean checkState() {
                        return true;
                    }
                });
        
        addField(new StringFieldEditor(UIConsts.PREF_PGDUMP_CUSTOM_PARAMS,
                Messages.GeneralPrefPage_pg_dump_custom_parameters, getFieldEditorParent()));
        
        BooleanFieldEditor openLast = new BooleanFieldEditor(
                UIConsts.PREF_OPEN_LAST_ON_START, Messages.GeneralPrefPage_open_last_project_on_startup,
                FileFieldEditor.VALIDATE_ON_KEY_STROKE, getFieldEditorParent());
        addField(openLast);
        openLast.setEnabled(false, getFieldEditorParent());
    }
}