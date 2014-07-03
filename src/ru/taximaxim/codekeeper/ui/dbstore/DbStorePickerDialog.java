package ru.taximaxim.codekeeper.ui.dbstore;

import java.util.Map;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DbStorePickerDialog extends TrayDialog {
    
    private final IPreferenceStore prefStore;
    
    private Map<String, DbInfo> store;
    
    private Combo cmbDbNames;
    
    private LocalResourceManager lrm;
    
    private String name;
    private DbInfo dbinfo;
    
    public String getName() {
        return name;
    }
    
    public DbInfo getDbInfo() {
        return dbinfo;
    }

    public DbStorePickerDialog(Shell shell, IPreferenceStore prefStore) {
        super(shell);
        
        this.prefStore = prefStore;
    }
    
    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(Messages.dbStorePickerDialog_choose_db_from_store);
    }
    
    @Override
    protected Control createDialogArea(Composite parent) {
        parent = (Composite) super.createDialogArea(parent);
        
        this.lrm = new LocalResourceManager(JFaceResources.getResources(), parent);
        
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout gridLayout = new GridLayout(2, false);
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        container.setLayout(gridLayout);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        cmbDbNames = new Combo(container, SWT.READ_ONLY | SWT.DROP_DOWN);
        cmbDbNames.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        loadStore();
        
        Button btnEditStore = new Button(container, SWT.PUSH);
        btnEditStore.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(
                        UIConsts.FILENAME_ICONEDIT))));
        btnEditStore.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                DbStoreEditorDialog dialog = new DbStoreEditorDialog(getShell(), prefStore);
                dialog.open();
                loadStore();
            }
        });
        
        return parent;
    }
    
    private void loadStore() {
        store = DbInfo.preferenceToStore(prefStore.getString(UIConsts.PREF_DB_STORE));
        
        cmbDbNames.setItems(store.keySet().toArray(new String[store.size()]));
        if(cmbDbNames.getItemCount() > 0) {
            cmbDbNames.select(0);
        }
    }
    
    @Override
    protected void okPressed() {
        String selectedName = cmbDbNames.getText();
        
        if(!selectedName.isEmpty()) {
            name = selectedName;
            dbinfo = store.get(selectedName);
        }
        
        super.okPressed();
    }
    
    public String openAndSetText(Text txtDbName, Text txtDbUser, Text txtDbPass,
            Text txtDbHost, Text txtDbPort) {
        if(open() == OK) {
            txtDbName.setText(dbinfo.dbname);
            txtDbUser.setText(dbinfo.dbuser);
            txtDbPass.setText(dbinfo.dbpass);
            txtDbHost.setText(dbinfo.dbhost);
            txtDbPort.setText(String.valueOf(dbinfo.dbport));
        }
        
        return name;
    }
}
