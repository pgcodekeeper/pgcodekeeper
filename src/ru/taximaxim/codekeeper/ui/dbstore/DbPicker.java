package ru.taximaxim.codekeeper.ui.dbstore;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DbPicker extends Group {

    final private boolean allowShellResize;
    
    private Label lblFieldName;
    private CLabel lblWarnDbPass;
    
    private LocalResourceManager lrm;
    private DbStorePicker dbStorePicker;
    
    public Label lblName;
    public Text txtDbName, txtDbUser, txtDbPass, txtDbHost, txtDbPort;
    
    /**
     * Constructs a control that is allowed to modify its shell size.
     */
    public DbPicker(Composite parent, int style, final IPreferenceStore prefStore) {
        this(parent, style, prefStore, true);
    }
    
    public DbPicker(Composite parent, int style, final IPreferenceStore prefStore,
            boolean allowShellResize) {
        super(parent, style);
        setLayout(new GridLayout(4, false));
        
        this.allowShellResize = allowShellResize;
        this.lrm = new LocalResourceManager(JFaceResources.getResources(), this);
        
        lblFieldName = new Label(this, SWT.NONE);
        lblFieldName.setText(Messages.entry_name);
        GridData gd = new GridData();
        gd.exclude = true;
        lblFieldName.setLayoutData(gd);
        lblFieldName.setVisible(false);
        
        lblName = new Label(this, SWT.BORDER);
        gd = new GridData(SWT.FILL, SWT.DEFAULT, true, false, 3, 1);
        gd.exclude = true;
        lblName.setLayoutData(gd);
        lblName.setVisible(false);
        
        if (prefStore != null) {
            dbStorePicker = new DbStorePicker(this, SWT.NONE, false, prefStore);
            dbStorePicker.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
                    false, 4, 1));
            final SelectionAdapter sa = new SelectionAdapter() {
                
                @Override
                public void widgetSelected(SelectionEvent e) {
                    fillDbFieldsFromDbInfo();
                }
            };
            dbStorePicker.addListenerToCombo(sa);
            dbStorePicker.addDisposeListener(new DisposeListener() {
                
                @Override
                public void widgetDisposed(DisposeEvent e) {
                    dbStorePicker.removeListenerToCombo(sa);
                }
            });
        }

        new Label(this, SWT.NONE).setText(Messages.dB_name);
        
        txtDbName = new Text(this, SWT.BORDER);
        txtDbName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
        
        new Label(this, SWT.NONE).setText(Messages.dB_user);
        
        txtDbUser = new Text(this, SWT.BORDER);
        txtDbUser.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
        
        new Label(this, SWT.NONE).setText(Messages.dB_password);
        
        txtDbPass = new Text(this, SWT.BORDER | SWT.PASSWORD);
        txtDbPass.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
        txtDbPass.addModifyListener(new ModifyListener() {
            
            @Override
            public void modifyText(ModifyEvent e) {
                GridData gd = (GridData) lblWarnDbPass.getLayoutData();
                
                if((txtDbPass.getText().isEmpty() && !gd.exclude)
                        || (!txtDbPass.getText().isEmpty() && gd.exclude)) {
                    lblWarnDbPass.setVisible(!lblWarnDbPass.getVisible());
                    gd.exclude = !gd.exclude;
                    
                    layout();
                }
            }
        });
        
        lblWarnDbPass = new CLabel(this, SWT.NONE);
        lblWarnDbPass.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(
                        FILE.ICONWARNING))));
        lblWarnDbPass.setText(Messages.warning
                + Messages.providing_password_here_is_insecure + "\n" //$NON-NLS-1$
                + Messages.consider_using_pgpass_file_instead);
        gd = new GridData(SWT.FILL, SWT.FILL, false, false, 4, 1);
        gd.exclude = true;
        lblWarnDbPass.setLayoutData(gd);
        lblWarnDbPass.setVisible(false);
        
        new Label(this, SWT.NONE).setText(Messages.dB_host);
        
        txtDbHost = new Text(this, SWT.BORDER);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = 80;
        txtDbHost.setLayoutData(gd);
        
        new Label(this, SWT.NONE).setText(Messages.dbPicker_port);
        
        txtDbPort = new Text(this, SWT.BORDER);
        gd = new GridData(60, SWT.DEFAULT);
        txtDbPort.setLayoutData(gd);
        if (dbStorePicker != null) {
            fillDbFieldsFromDbInfo();
        }
    }
    

    private void fillDbFieldsFromDbInfo() {
        DbInfo dbInfo = dbStorePicker.getDbInfo();
        if (dbInfo != null) {
            txtDbName.setText(dbInfo.dbname);
            txtDbUser.setText(dbInfo.dbuser);
            txtDbPass.setText(dbInfo.dbpass);
            txtDbHost.setText(dbInfo.dbhost);
            txtDbPort.setText(String.valueOf(dbInfo.dbport));
        }
    }
    
    /**
     * Remove storePicker button and show Entry Name field.
     */
    public void setStoreEditMode() {
        ((GridData) lblFieldName.getLayoutData()).exclude = false;
        lblFieldName.setVisible(true);
        
        ((GridData) lblName.getLayoutData()).exclude = false;
        lblName.setVisible(true);
        
        if (dbStorePicker != null) {
            ((GridData) dbStorePicker.getLayoutData()).exclude = true;
            dbStorePicker.setVisible(false);
        }
        
        txtDbName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
        
        layout();
    }
    
    @Override
    public void layout() {
        if(allowShellResize) {
            getShell().pack();
            layout(false);
        } else {
            getShell().layout(true, true);
        }
    }
        
    @Override
    protected void checkSubclass() {
        // allow subclassing, we just use Group as a Composite
        // ~should~ be fine
    }
}
