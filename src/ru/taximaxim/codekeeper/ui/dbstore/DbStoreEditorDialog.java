package ru.taximaxim.codekeeper.ui.dbstore;

import java.io.IOException;
import java.util.Map;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;

public class DbStoreEditorDialog extends TrayDialog {

    private final Map<String, DbCoords> store;
    
    private final IPreferenceStore prefStore;
    
    private Combo cmbDbNames;
    private Button btnSave, btnDel;
    private Label lblName;
    private Text txtDbName, txtDbUser, txtDbPass, txtDbHost, txtDbPort;
    
    private ModifyListener dbModified = new ModifyListener() {
        @Override
        public void modifyText(ModifyEvent e) {
            btnSave.setEnabled(!cmbDbNames.getText().isEmpty());
        }
    };
    
    public String getPreferenceString() {
        return DbCoords.storeToPreference(store);
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
        
        this.store = DbCoords.preferenceToStore(preference);
        this.prefStore = prefStore;
    }
    
    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("DB Store editor");
    }
    
    @Override
    protected Control createDialogArea(Composite parent) {
        parent = (Composite) super.createDialogArea(parent);
        
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
                DbCoords db = store.get(cmbDbNames.getText());
                if(db == null) {
                    db = DbCoords.getEmpty("");
                }
                lblName.setText(db.name);
                txtDbName.setText(db.dbname);
                txtDbUser.setText(db.dbuser);
                txtDbPass.setText(db.dbpass);
                txtDbHost.setText(db.dbhost);
                txtDbPort.setText(String.valueOf(db.dbport));
                
                btnSave.setEnabled(false);
                btnDel.setEnabled(!cmbDbNames.getText().isEmpty());
            }
        });
        
        Button btnAdd = new Button(container, SWT.PUSH);
        btnAdd.setImage(ImageDescriptor.createFromURL(Activator.getContext().
                getBundle().getResource(UIConsts.FILENAME_ICONADD)).createImage());
        // TODO createImage, createResource, dispose, static loading ... ?
        // local resource manager jface ?
        btnAdd.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                InputDialog dialog = new InputDialog(
                        getShell(), "New entry...", "Entry Name:", null, null);
                
                if(dialog.open() == Dialog.OK) {
                    String newName = dialog.getValue().trim();
                    
                    if(newName.isEmpty()) {
                        MessageBox mb = new MessageBox(getShell(), SWT.ICON_ERROR);
                        mb.setText("Cannot add entry!");
                        mb.setMessage("Name cannot be empty or whitespace!");
                        mb.open();
                        return;
                    }
                    
                    if(store.containsKey(newName)) {
                        MessageBox mb = new MessageBox(getShell(), SWT.ICON_ERROR);
                        mb.setText("Cannot add entry!");
                        mb.setMessage("An entry with this name alredy exists:\n"
                                + newName);
                        mb.open();
                        return;
                    }
                    
                    store.put(newName, DbCoords.getEmpty(newName));
                    cmbDbNames.add(newName);
                    cmbDbNames.select(cmbDbNames.indexOf(newName));
                }
            }
        });
        
        btnSave = new Button(container, SWT.PUSH);
        btnSave.setImage(ImageDescriptor.createFromURL(Activator.getContext().
                getBundle().getResource(UIConsts.FILENAME_ICONSAVE)).createImage());
        btnSave.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                
                int dbport;
                try {
                    if(txtDbPort.getText().isEmpty()) {
                        dbport = 0;
                    } else {
                        dbport = Integer.parseInt(txtDbPort.getText());
                    }
                } catch (NumberFormatException ex) {
                    MessageBox mb = new MessageBox(getShell(), SWT.ICON_ERROR);
                    mb.setText("Cannot save entry!");
                    mb.setMessage("Not valid port number: " + txtDbPort.getText());
                    mb.open();
                    return;
                }
                
                DbCoords db = store.get(cmbDbNames.getText());
                
                db.dbname = txtDbName.getText();
                db.dbuser = txtDbUser.getText();
                db.dbpass = txtDbPass.getText();
                db.dbhost = txtDbHost.getText();
                db.dbport = dbport;
                
                btnSave.setEnabled(false);
            }
        });
        btnSave.setEnabled(false);
        
        btnDel = new Button(container, SWT.PUSH);
        btnDel.setImage(ImageDescriptor.createFromURL(Activator.getContext().
                getBundle().getResource(UIConsts.FILENAME_ICONDEL)).createImage());
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
        
        Group grpDbData = new Group(container, SWT.NONE);
        grpDbData.setLayout(new GridLayout(4, false));
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1);
        gd.widthHint = 480;
        grpDbData.setLayoutData(gd);
        grpDbData.setText("DB Coordinates");
        
        new Label(grpDbData, SWT.NONE).setText("Entry Name:");
        lblName = new Label(grpDbData, SWT.BORDER);
        lblName.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 3, 1));
        
        new Label(grpDbData, SWT.NONE).setText("DB Name:");
        txtDbName = new Text(grpDbData, SWT.BORDER);
        txtDbName.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 3, 1));
        txtDbName.addModifyListener(dbModified);

        new Label(grpDbData, SWT.NONE).setText("DB User:");
        txtDbUser = new Text(grpDbData, SWT.BORDER);
        txtDbUser.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 3, 1));
        txtDbUser.addModifyListener(dbModified);

        new Label(grpDbData, SWT.NONE).setText("DB Pass:");
        txtDbPass = new Text(grpDbData, SWT.BORDER);
        txtDbPass.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 3, 1));
        txtDbPass.addModifyListener(dbModified);

        new Label(grpDbData, SWT.NONE).setText("DB Host:");
        txtDbHost = new Text(grpDbData, SWT.BORDER);
        txtDbHost.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtDbHost.addModifyListener(dbModified);

        new Label(grpDbData, SWT.NONE).setText("Port:");
        txtDbPort = new Text(grpDbData, SWT.BORDER);
        gd = new GridData();
        gd.widthHint = 60;
        txtDbPort.setLayoutData(gd);
        txtDbPort.addModifyListener(dbModified);
        
        if(cmbDbNames.getItemCount() > 0) {
            cmbDbNames.select(0); // select an element and trigger modify event
        }
        
        return parent;
    }
    
    @Override
    protected void okPressed() {
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
                            "Unexpected error while saving preferences!", ex);
                }
            }
        }
        
        super.okPressed();
    }
}
