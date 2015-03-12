package ru.taximaxim.codekeeper.ui.dbstore;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;

public class DbStoreEditorDialog extends TrayDialog {

    private final Map<String, DbInfo> store;
    
    private final IPreferenceStore prefStore;

    private PrefListEditor listEdit;
    private Button btnSave;
    private DbPicker grpDbData;
    
    private LocalResourceManager lrm;
    
    private ModifyListener dbModified = new ModifyListener() {
        @Override
        public void modifyText(ModifyEvent e) {
            btnSave.setEnabled(listEdit.getSelected() != null);
        }
    };

    public String getPreferenceString() {
        return DbInfo.storeToPreference(store, listEdit.getList());
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
                
                // select an element and trigger modify event
                listEdit.select(0);
            }
        });
    }
    
    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);
        
        this.lrm = new LocalResourceManager(JFaceResources.getResources(), area);
        
        Composite container = new Composite(area, SWT.NONE);
        GridLayout gridLayout = new GridLayout(2, false);
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        container.setLayout(gridLayout);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        listEdit = new PrefListEditor(container, false);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = 150;
        listEdit.setLayoutData(gd);
        listEdit.getListViewer().addSelectionChangedListener(new ISelectionChangedListener() {
            
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                ISelection s = event.getSelection();
                if (s.isEmpty() || !(s instanceof IStructuredSelection)) {
                    listEdit.getDelDtn().setEnabled(false);
                    return;
                }
                
                DbInfo db = store.get(((IStructuredSelection) s).getFirstElement());
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
                listEdit.getDelDtn().setEnabled(true);
            }
        });
        listEdit.setInputList(new LinkedList<>(store.keySet()));
        
        listEdit.getAddBtn().addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                if(!listEdit.getNewEntry().isEmpty()) {
                    addEntry(listEdit.getNewEntry().trim());
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
        
        grpDbData = new DbPicker(container, SWT.NONE, null);
        gd = new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1);
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
            mb.setMessage(MessageFormat.format(
                    Messages.dbStoreEditorDialog_not_valid_port_number,
                    grpDbData.getTxtDbPort().getText()));
            mb.open();
            return;
        }
        
        DbInfo db = store.get(listEdit.getSelected());
        
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
            mb.setMessage(MessageFormat
                    .format(Messages.dbStoreEditorDialog_entry_with_this_name_already_exists,
                            name));
            mb.open();
            return;
        }
        
        store.put(name, DbInfo.getEmptyNamed(name));
        listEdit.select(name);
    }
}
