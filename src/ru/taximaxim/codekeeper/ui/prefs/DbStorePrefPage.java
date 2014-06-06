package ru.taximaxim.codekeeper.ui.prefs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.dbstore.DbStoreEditorDialog;

public class DbStorePrefPage extends FieldEditorPreferencePage
        implements IWorkbenchPreferencePage {
    
    private String preference;

    public DbStorePrefPage() {
        super(GRID);
    }
    
    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(UIScopedPreferenceStore.get());
    }
    
    @Override
    protected void createFieldEditors() {
        // this is our "hidden field editor"
        preference = getPreferenceStore().getString(UIConsts.PREF_DB_STORE);
    }
    
    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
        getDefaultsButton().setText("Clear DB Store");
    }
    
    @Override
    protected Control createContents(Composite parent) {
        Button btnDbStore = new Button(parent, SWT.PUSH);
        btnDbStore.setText("Edit Db Store...");
        btnDbStore.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                DbStoreEditorDialog dialog = new DbStoreEditorDialog(
                        getShell(), preference);
                
                if(dialog.open() == Dialog.OK) {
                    preference = dialog.getPreferenceString();
                    
                    if(preference.trim().isEmpty()) {
                        performDefaults();
                    }
                }
            }
        });
        
        return super.createContents(parent);
    }
    
    @Override
    protected void performDefaults() {
        preference = getPreferenceStore().getDefaultString(UIConsts.PREF_DB_STORE);
    }
    
    @Override
    public boolean performOk() {
        if(getPreferenceStore() != null) {
            getPreferenceStore().setValue(UIConsts.PREF_DB_STORE, preference);
        }
        return true;
    }
}