package ru.taximaxim.codekeeper.ui.dbstore;

import java.io.IOException;
import java.util.Map;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DbStoreEditorDialog extends TrayDialog {

    private final Map<String, DbInfo> store;
    
    private final IPreferenceStore prefStore;
    
    private Combo cmbDbNames;
    private Button btnSave, btnDel;
    private DbPicker grpDbData;
    
    private LocalResourceManager lrm;
    
    private ModifyListener dbModified = new ModifyListener() {
        @Override
        public void modifyText(ModifyEvent e) {
            btnSave.setEnabled(!cmbDbNames.getText().isEmpty());
        }
    };
    
    public String getPreferenceString() {
        return DbInfo.storeToPreference(store);
    }
    
    /**
     * When created with this constructor the dialog leaves
     * {@link IPreferenceStore} operations to the caller.
     * 
     * @param shell
     * @param preference
     */
    public DbStoreEditorDialog(Shell shell, String preference) {
        this(shell, preference, null);
    }
    
    /**
     * When created with this constructor the dialog saves
     * the {@link IPreferenceStore} when Ok is pressed.
     * 
     * @param shell
     * @param prefStore
     */
    public DbStoreEditorDialog(Shell shell, IPreferenceStore prefStore) {
        this(shell, prefStore.getString(PREF.DB_STORE), prefStore);
    }
    
    private DbStoreEditorDialog(Shell shell, String preference,
            IPreferenceStore prefStore) {
        super(shell);
        
        this.store = DbInfo.preferenceToStore(preference);
        this.prefStore = prefStore;
    }
    
    @Override
    protected void configureShell(final Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(Messages.dbStoreEditorDialog_db_store_editor);
        
        newShell.addShellListener(new ShellAdapter() {
            
            @Override
            public void shellActivated(ShellEvent e) {

                // do pack-calling methods after open has returned
                // otherwise shell is opened at (0,0) coordinates

                // one-time listener, remove after first execution
                newShell.removeShellListener(this);
                
                grpDbData.setStoreEditMode();
                
                if(cmbDbNames.getItemCount() > 0) {
                    // select an element and trigger modify event
                    cmbDbNames.select(0);
                }
            }
        });
    }
    
    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);
        
        this.lrm = new LocalResourceManager(JFaceResources.getResources(), area);
        
        Composite container = new Composite(area, SWT.NONE);
        GridLayout gridLayout = new GridLayout(4, false);
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        container.setLayout(gridLayout);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        cmbDbNames = new Combo(container, SWT.READ_ONLY | SWT.DROP_DOWN);
        cmbDbNames.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        cmbDbNames.setItems(store.keySet().toArray(new String[store.size()]));
        cmbDbNames.addModifyListener(new ModifyListener() {
            
            @Override
            public void modifyText(ModifyEvent e) {
                DbInfo db = store.get(cmbDbNames.getText());
                if(db == null) {
                    db = DbInfo.getEmpty(""); //$NON-NLS-1$
                }
                grpDbData.getLblName().setText(db.name);
                grpDbData.getTxtDbName().setText(db.dbname);
                grpDbData.getTxtDbName().selectAll();
                grpDbData.getTxtDbName().setFocus();
                grpDbData.getTxtDbUser().setText(db.dbuser);
                grpDbData.getTxtDbPass().setText(db.dbpass);
                grpDbData.getTxtDbHost().setText(db.dbhost);
                grpDbData.getTxtDbPort().setText(String.valueOf(db.dbport));
                
                btnSave.setEnabled(false);
                btnDel.setEnabled(!cmbDbNames.getText().isEmpty());
            }
        });
        
        Button btnAdd = new Button(container, SWT.PUSH);
        btnAdd.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(FILE.ICONADD))));
        btnAdd.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                InputDialog dialog = new InputDialog(
                        getShell(), Messages.dbStoreEditorDialog_new_entry, 
                        Messages.entry_name, null, null);
                if(dialog.open() == Dialog.OK) {
                    addEntry(dialog.getValue().trim());
                }
            }
        });
        
        btnSave = new Button(container, SWT.PUSH);
        btnSave.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(
                        FILE.ICONSAVE))));
        btnSave.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                saveEntry();
            }
        });
        btnSave.setEnabled(false);
        
        btnDel = new Button(container, SWT.PUSH);
        btnDel.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(
                        FILE.ICONDEL))));
        btnDel.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                String del = cmbDbNames.getText();
                
                int indexDel = cmbDbNames.getSelectionIndex();
                if(indexDel < 0) {
                    btnDel.setEnabled(false);
                    return;
                }
                
                cmbDbNames.remove(indexDel);
                while(cmbDbNames.getItemCount() <= indexDel) {
                    indexDel--;
                }
                cmbDbNames.select(indexDel);
                
                store.remove(del);
            }
        });
        btnDel.setEnabled(false);
        
        grpDbData = new DbPicker(container, SWT.NONE, null);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1);
        gd.widthHint = 480;
        grpDbData.setLayoutData(gd);
        grpDbData.setText(Messages.dbStoreEditorDialog_db_info);
        
        grpDbData.getTxtDbName().addModifyListener(dbModified);
        grpDbData.getTxtDbUser().addModifyListener(dbModified);
        grpDbData.getTxtDbPass().addModifyListener(dbModified);
        grpDbData.getTxtDbHost().addModifyListener(dbModified);
        grpDbData.getTxtDbPort().addModifyListener(dbModified);
        
        return area;
    }
    
    private void saveEntry() {
        int dbport;
        try {
            if(grpDbData.getTxtDbPort().getText().isEmpty()) {
                dbport = 0;
            } else {
                dbport = Integer.parseInt(grpDbData.getTxtDbPort().getText());
            }
        } catch (NumberFormatException ex) {
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_ERROR);
            mb.setText(Messages.dbStoreEditorDialog_cannot_save_entry);
            mb.setMessage(Messages.dbStoreEditorDialog_not_valid_port_number + 
                    grpDbData.getTxtDbPort().getText());
            mb.open();
            return;
        }
        
        DbInfo db = store.get(cmbDbNames.getText());
        
        db.dbname = grpDbData.getTxtDbName().getText();
        db.dbuser = grpDbData.getTxtDbUser().getText();
        db.dbpass = grpDbData.getTxtDbPass().getText();
        db.dbhost = grpDbData.getTxtDbHost().getText();
        db.dbport = dbport;
        
        btnSave.setEnabled(false);
    }
    
    @Override
    protected void okPressed() {
        if(btnSave.getEnabled()) {
            saveEntry();
        }
        
        if(prefStore != null) {
            String preference = getPreferenceString();
            
            if(store.isEmpty() || preference.trim().isEmpty()) {
                prefStore.setToDefault(PREF.DB_STORE);
            } else {
                prefStore.setValue(PREF.DB_STORE, preference);
            }
            
            if(prefStore.needsSaving() && prefStore instanceof IPersistentPreferenceStore) {
                try {
                    ((IPersistentPreferenceStore) prefStore).save();
                } catch (IOException ex) {
                    ExceptionNotifier.notifyDefault(Messages.unexpected_error_while_saving_preferences, ex);
                    return;
                }
            }
        }
        
        super.okPressed();
    }

    private void addEntry(String name) {
        if(name.isEmpty()) {
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_ERROR);
            mb.setText(Messages.dbStoreEditorDialog_cannot_add_entry);
            mb.setMessage(Messages.dbStoreEditorDialog_name_cannot_be_empty_or_whitespace);
            mb.open();
            return;
        }
        
        if(store.containsKey(name)) {
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_ERROR);
            mb.setText(Messages.dbStoreEditorDialog_cannot_add_entry);
            mb.setMessage(Messages.dbStoreEditorDialog_entry_with_this_name_already_exists
                    + name);
            mb.open();
            return;
        }
        
        store.put(name, DbInfo.getEmptyNamed(name));
        cmbDbNames.add(name);
        cmbDbNames.select(cmbDbNames.indexOf(name));
    }
}
