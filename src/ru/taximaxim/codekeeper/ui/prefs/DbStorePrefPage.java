package ru.taximaxim.codekeeper.ui.prefs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbStoreEditorDialog;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DbStorePrefPage extends FieldEditorPreferencePage
        implements IWorkbenchPreferencePage {
    
    private String preference;

    public DbStorePrefPage() {
        super(GRID);
    }
    
    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }
    
    @Override
    protected void createFieldEditors() {
        // this is our "hidden field editor"
        preference = getPreferenceStore().getString(PREF.DB_STORE);
    }
    
    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
        
        Button btnDef = getDefaultsButton();
        btnDef.setText(Messages.dbStorePrefPage_clear_db_store);
        ((GridData) btnDef.getLayoutData()).widthHint = 
                btnDef.computeSize(SWT.DEFAULT, SWT.DEFAULT).x;
        btnDef.getParent().layout();
    }
    
    @Override
    protected Control createContents(Composite parent) {
        Button btnDbStore = new Button(parent, SWT.PUSH);
        btnDbStore.setText(Messages.dbStorePrefPage_edit_db_store);
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
        preference = getPreferenceStore().getDefaultString(PREF.DB_STORE);
    }
    
    @Override
    public boolean performOk() {
        if(getPreferenceStore() != null) {
            getPreferenceStore().setValue(PREF.DB_STORE, preference);
        }
        return true;
    }
}