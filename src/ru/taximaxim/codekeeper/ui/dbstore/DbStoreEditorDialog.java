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
import ru.taximaxim.codekeeper.ui.UIConsts;
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
        this(shell, prefStore.getString(UIConsts.PREF_DB_STORE), prefStore);
    }
    
    private DbStoreEditorDialog(Shell shell, String preference,
            IPreferenceStore prefStore) {
        super(shell);
        
        this.store = DbInfo.preferenceToStore(preference);
        this.prefStore = prefStore;
    }
    
    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(Messages.DbStoreEditorDialog_db_store_editor);
        
        newShell.addShellListener(new ShellAdapter() {
            @Override
            public void shellActivated(ShellEvent e) {

                // do pack-calling methods after open has returned
                // otherwise shell is opened at (0,0) coordinates

                grpDbData.setStoreEditMode();
                
                if(cmbDbNames.getItemCount() > 0) {
                    cmbDbNames.select(0); // select an element and trigger modify event
                }
                
                // one-time listener, remove after first execution
                ((Shell) e.getSource()).removeShellListener(this);
            }
        });
    }
    
    @Override
    protected Control createDialogArea(Composite parent) {
        parent = (Composite) super.createDialogArea(parent);
        
        this.lrm = new LocalResourceManager(JFaceResources.getResources(), parent);
        
        Composite container = new Composite(parent, SWT.NONE);
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
                grpDbData.lblName.setText(db.name);
                grpDbData.txtDbName.setText(db.dbname);
                grpDbData.txtDbUser.setText(db.dbuser);
                grpDbData.txtDbPass.setText(db.dbpass);
                grpDbData.txtDbHost.setText(db.dbhost);
                grpDbData.txtDbPort.setText(String.valueOf(db.dbport));
                
                btnSave.setEnabled(false);
                btnDel.setEnabled(!cmbDbNames.getText().isEmpty());
            }
        });
        
        Button btnAdd = new Button(container, SWT.PUSH);
        btnAdd.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(
                        UIConsts.FILENAME_ICONADD))));
        btnAdd.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                InputDialog dialog = new InputDialog(
                        getShell(), Messages.DbStoreEditorDialog_new_entry, 
                        Messages.DbStoreEditorDialog_entry_name, null, null);
                
                if(dialog.open() == Dialog.OK) {
                    String newName = dialog.getValue().trim();
                    
                    if(newName.isEmpty()) {
                        MessageBox mb = new MessageBox(getShell(), SWT.ICON_ERROR);
                        mb.setText(Messages.DbStoreEditorDialog_cannot_add_entry);
                        mb.setMessage(Messages.DbStoreEditorDialog_name_cannot_be_empty_or_whitespace);
                        mb.open();
                        return;
                    }
                    
                    if(store.containsKey(newName)) {
                        MessageBox mb = new MessageBox(getShell(), SWT.ICON_ERROR);
                        mb.setText(Messages.DbStoreEditorDialog_cannot_add_entry);
                        mb.setMessage(Messages.DbStoreEditorDialog_entry_with_this_name_already_exists
                                + newName);
                        mb.open();
                        return;
                    }
                    
                    store.put(newName, DbInfo.getEmpty(newName));
                    cmbDbNames.add(newName);
                    cmbDbNames.select(cmbDbNames.indexOf(newName));
                }
            }
        });
        
        btnSave = new Button(container, SWT.PUSH);
        btnSave.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(
                        UIConsts.FILENAME_ICONSAVE))));
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
                        UIConsts.FILENAME_ICONDEL))));
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
        grpDbData.setText(Messages.DbStoreEditorDialog_db_info);
        
        grpDbData.txtDbName.addModifyListener(dbModified);
        grpDbData.txtDbUser.addModifyListener(dbModified);
        grpDbData.txtDbPass.addModifyListener(dbModified);
        grpDbData.txtDbHost.addModifyListener(dbModified);
        grpDbData.txtDbPort.addModifyListener(dbModified);
        
        return parent;
    }
    
    private void saveEntry() {
        int dbport;
        try {
            if(grpDbData.txtDbPort.getText().isEmpty()) {
                dbport = 0;
            } else {
                dbport = Integer.parseInt(grpDbData.txtDbPort.getText());
            }
        } catch (NumberFormatException ex) {
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_ERROR);
            mb.setText(Messages.DbStoreEditorDialog_cannot_save_entry);
            mb.setMessage(Messages.DbStoreEditorDialog_not_valid_port_number + 
                    grpDbData.txtDbPort.getText());
            mb.open();
            return;
        }
        
        DbInfo db = store.get(cmbDbNames.getText());
        
        db.dbname = grpDbData.txtDbName.getText();
        db.dbuser = grpDbData.txtDbUser.getText();
        db.dbpass = grpDbData.txtDbPass.getText();
        db.dbhost = grpDbData.txtDbHost.getText();
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
                prefStore.setToDefault(UIConsts.PREF_DB_STORE);
            } else {
                prefStore.setValue(UIConsts.PREF_DB_STORE, preference);
            }
            
            if(prefStore.needsSaving() && prefStore instanceof IPersistentPreferenceStore) {
                try {
                    ((IPersistentPreferenceStore) prefStore).save();
                } catch (IOException ex) {
                    throw new IllegalStateException(
                            Messages.DbStoreEditorDialog_unexpected_error_while_saving_preferences, ex);
                }
            }
        }
        
        super.okPressed();
    }
}
