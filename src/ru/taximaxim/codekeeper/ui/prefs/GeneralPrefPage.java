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
                new FileFieldEditor(UIConsts.PREF_PGDUMP_EXE_PATH, "pg_dump executable", getFieldEditorParent()){
                    @Override
                    protected boolean checkState() {
                        return true;
                    }
                });
        
        addField(new StringFieldEditor(UIConsts.PREF_PGDUMP_CUSTOM_PARAMS,
                "pg_dump custom parameters", getFieldEditorParent()));
        
        BooleanFieldEditor openLast = new BooleanFieldEditor(
                UIConsts.PREF_OPEN_LAST_ON_START, "Open last project on startup",
                FileFieldEditor.VALIDATE_ON_KEY_STROKE, getFieldEditorParent());
        addField(openLast);
        openLast.setEnabled(false, getFieldEditorParent());
    }
}