package ru.taximaxim.codekeeper.ui.dbstore;

import java.text.MessageFormat;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DbStoreEditorDialog extends TrayDialog {

    private DbInfo dbInfo;

    private DbPicker grpDbData;

    public String getPreferenceString() {
        return null;
    }

    public DbInfo getDbInfo(){
        return dbInfo;
    }

    /**
     * When created with this constructor the dialog leaves
     * {@link IPreferenceStore} operations to the caller.
     *
     * @param shell
     * @param preference
     */
    public DbStoreEditorDialog(Shell shell, DbInfo store) {
        super(shell);
        this.dbInfo = store;
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
            }
        });
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);

        Composite container = new Composite(area, SWT.NONE);
        GridLayout gridLayout = new GridLayout(2, false);
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        container.setLayout(gridLayout);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = 150;

        grpDbData = new DbPicker(container, SWT.NONE, null);
        gd = new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1);
        gd.widthHint = 480;
        grpDbData.setLayoutData(gd);
        grpDbData.setText(Messages.dbStoreEditorDialog_db_info);

        init();
        return area;
    }

    private void init(){
        if (dbInfo != null){
            grpDbData.getTxtName().setText(this.dbInfo.name);
            grpDbData.getTxtDbName().setText(this.dbInfo.dbname);
            grpDbData.getTxtDbUser().setText(this.dbInfo.dbuser);
            grpDbData.getTxtDbPass().setText(this.dbInfo.dbpass);
            grpDbData.getTxtDbHost().setText(this.dbInfo.dbhost);
            grpDbData.getTxtDbPort().setText(new Integer(this.dbInfo.dbport).toString());
        }
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

        if (dbInfo == null){
            dbInfo = new DbInfo(grpDbData.getTxtName().getText(),
                    grpDbData.getTxtDbName().getText(),
                    grpDbData.getTxtDbUser().getText(),
                    grpDbData.getTxtDbPass().getText(),
                    grpDbData.getTxtDbHost().getText(),
                    dbport);
        } else {
            dbInfo.name = grpDbData.getTxtName().getText();
            dbInfo.dbname = grpDbData.getTxtDbName().getText();
            dbInfo.dbuser = grpDbData.getTxtDbUser().getText();
            dbInfo.dbpass = grpDbData.getTxtDbPass().getText();
            dbInfo.dbhost = grpDbData.getTxtDbHost().getText();
            dbInfo.dbport = dbport;
        }
    }

    @Override
    protected void okPressed() {
        saveEntry();
        super.okPressed();
    }
}
