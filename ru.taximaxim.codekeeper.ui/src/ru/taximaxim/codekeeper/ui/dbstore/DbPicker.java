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
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
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

    private final boolean allowShellResize;

    private Label lblFieldName;
    private CLabel lblWarnDbPass;

    private LocalResourceManager lrm;
    private DbStorePicker dbStorePicker;

    private final Text lblName;
    private final Text txtDbName, txtDbUser, txtDbPass, txtDbHost, txtDbPort;

    private final ModifyListener ml;

    public Text getTxtName() {
        return lblName;
    }

    public Text getTxtDbName() {
        return txtDbName;
    }

    public Text getTxtDbUser() {
        return txtDbUser;
    }

    public Text getTxtDbPass() {
        return txtDbPass;
    }

    public Text getTxtDbHost() {
        return txtDbHost;
    }

    public Text getTxtDbPort() {
        return txtDbPort;
    }

    /**
     * Constructs a control that is allowed to modify its shell size.
     */
    public DbPicker(Composite parent, int style, final IPreferenceStore prefStore) {
        this(parent, style, prefStore, true);
    }

    public DbPicker(Composite parent, int style, final IPreferenceStore prefStore,
            boolean allowShellResize) {
        super(parent, style);
        setLayout(new GridLayout(2, false));

        this.allowShellResize = allowShellResize;
        this.lrm = new LocalResourceManager(JFaceResources.getResources(), this);

        lblFieldName = new Label(this, SWT.NONE);
        lblFieldName.setText(Messages.entry_name);
        GridData gd = new GridData();
        gd.exclude = true;
        lblFieldName.setLayoutData(gd);
        lblFieldName.setVisible(false);

        lblName = new Text(this, SWT.BORDER);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.exclude = true;
        lblName.setLayoutData(gd);
        lblName.setVisible(false);

        if (prefStore != null) {
            dbStorePicker = new DbStorePicker(this, SWT.NONE, false, prefStore);
            dbStorePicker.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
                    false, 2, 1));
            final SelectionAdapter sa = new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    fillDbFieldsFromDbInfo();
                    notifyListeners(SWT.Modify, null);
                    layout();
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
        ml = new ModifyListener(){

            @Override
            public void modifyText(ModifyEvent e) {
                DbInfo dbInfo = dbStorePicker.getDbInfo();
                if (dbInfo != null && (!txtDbName.getText().equals(dbInfo.dbname) ||
                        !txtDbUser.getText().equals(dbInfo.dbuser) ||
                        !txtDbPass.getText().equals(dbInfo.dbpass) ||
                        !txtDbHost.getText().equals(dbInfo.dbhost) ||
                        !txtDbPort.getText().equals(String.valueOf(dbInfo.dbport)))) {

                    dbStorePicker.clearSelection();
                }
                notifyListeners(SWT.Modify, null);
                layout();
            }
        };

        new Label(this, SWT.NONE).setText(Messages.dB_name);

        txtDbName = new Text(this, SWT.BORDER);
        txtDbName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(this, SWT.NONE).setText(Messages.dB_user);

        txtDbUser = new Text(this, SWT.BORDER);
        txtDbUser.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(this, SWT.NONE).setText(Messages.dB_password);

        txtDbPass = new Text(this, SWT.BORDER | SWT.PASSWORD);
        txtDbPass.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
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
                Activator.getContext().getBundle().getResource(FILE.ICONWARNING))));
        lblWarnDbPass.setText(
                Messages.warning_providing_password_here_is_insecure_use_pgpass_instead);
        gd = new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1);
        gd.exclude = true;
        lblWarnDbPass.setLayoutData(gd);
        lblWarnDbPass.setVisible(false);

        new Label(this, SWT.NONE).setText(Messages.dB_host);

        txtDbHost = new Text(this, SWT.BORDER);
        txtDbHost.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(this, SWT.NONE).setText(Messages.dbPicker_port);

        txtDbPort = new Text(this, SWT.BORDER);
        gd = new GridData(60, SWT.DEFAULT);
        txtDbPort.setLayoutData(gd);
        txtDbPort.addVerifyListener(new VerifyListener() {

            @Override
            public void verifyText(VerifyEvent e) {
                try{
                    if (!e.text.isEmpty() && Integer.valueOf(e.text) < 0){
                        e.doit = false;
                    }
                }catch(NumberFormatException ex){
                    e.doit = false;
                }
            }
        });

        if (dbStorePicker != null) {
            txtDbName.addModifyListener(ml);
            txtDbUser.addModifyListener(ml);
            txtDbPass.addModifyListener(ml);
            txtDbHost.addModifyListener(ml);
            txtDbPort.addModifyListener(ml);
            fillDbFieldsFromDbInfo();
        }
    }

    public String getSelectedDbPresetName(){
        return dbStorePicker.getSelectedName();
    }

    private void fillDbFieldsFromDbInfo() {
        DbInfo dbInfo = dbStorePicker.getDbInfo();
        if (dbInfo != null) {
            txtDbName.removeModifyListener(ml);
            txtDbUser.removeModifyListener(ml);
            txtDbPass.removeModifyListener(ml);
            txtDbHost.removeModifyListener(ml);
            txtDbPort.removeModifyListener(ml);

            txtDbName.setText(dbInfo.dbname);
            txtDbUser.setText(dbInfo.dbuser);
            txtDbPass.setText(dbInfo.dbpass);
            txtDbHost.setText(dbInfo.dbhost);
            txtDbPort.setText(String.valueOf(dbInfo.dbport));

            txtDbName.addModifyListener(ml);
            txtDbUser.addModifyListener(ml);
            txtDbPass.addModifyListener(ml);
            txtDbHost.addModifyListener(ml);
            txtDbPort.addModifyListener(ml);
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

        txtDbName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

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
