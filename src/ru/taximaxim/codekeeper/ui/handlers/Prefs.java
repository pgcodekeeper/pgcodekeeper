 
package ru.taximaxim.codekeeper.ui.handlers;

import javax.inject.Named;

import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.dbstore.DbStoreEditorDialog;
import ru.taximaxim.codekeeper.ui.prefs.ExecutableFileFieldEditor;
import ru.taximaxim.codekeeper.ui.prefs.FakePrefPageExtension;
import ru.taximaxim.codekeeper.ui.prefs.PrefDialogFactory;

public class Prefs {
	
	@Execute
	private void execute(
			@Named(UIConsts.PREF_STORE)
			IPreferenceStore prefStore,
			@Named(IServiceConstants.ACTIVE_SHELL)
			Shell shell) {
		FakePrefPageExtension[] pages = {
				
				new FakePrefPageExtension("page.0.general", "General",
				        new GeneralPrefPage(), null),
						
				new FakePrefPageExtension("page.1.dbstore", "DB Store",
				        new DbStorePrefPage(), "page.0.general")
		};
		
		PrefDialogFactory.show(shell, prefStore, pages);
	}
}

class GeneralPrefPage extends FieldEditorPreferencePage {

	public GeneralPrefPage() {
		super(GRID);
	}
	
	@Override
	protected void createFieldEditors() {
		addField(new ExecutableFileFieldEditor(UIConsts.PREF_REPO_EXE_PATH,
				"svn executable", getFieldEditorParent()));
		addField(new ExecutableFileFieldEditor(UIConsts.PREF_PGDUMP_EXE_PATH,
				"pg_dump executable", getFieldEditorParent()));
	}
}

class DbStorePrefPage extends FieldEditorPreferencePage {
    
    private String preference;

	public DbStorePrefPage() {
		super(GRID);
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
