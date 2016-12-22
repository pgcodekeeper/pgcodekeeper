package ru.taximaxim.codekeeper.ui.dbstore;

import java.text.MessageFormat;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DbStoreEditorDialog extends TrayDialog {

    private final DbInfo dbInitial;
    private DbInfo dbInfo;
    private Group grpDbData;

    private Text txtName, txtDbName, txtDbUser, txtDbPass, txtDbHost, txtDbPort;
    private CLabel lblWarnDbPass;

    public DbInfo getDbInfo(){
        return dbInfo;
    }

    public DbStoreEditorDialog(Shell shell, DbInfo dbInitial) {
        super(shell);
        this.dbInitial = dbInitial;
    }

    @Override
    protected void configureShell(final Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(Messages.dbStoreEditorDialog_db_store_editor);
        newShell.addShellListener(new ShellAdapter() {

            @Override
            public void shellActivated(ShellEvent e) {
                // one time listener
                newShell.removeShellListener(this);

                if (dbInitial != null){
                    txtName.setText(dbInitial.getName());
                    txtDbName.setText(dbInitial.getDbName());
                    txtDbUser.setText(dbInitial.getDbUser());
                    txtDbPass.setText(dbInitial.getDbPass());
                    txtDbHost.setText(dbInitial.getDbHost());
                    txtDbPort.setText("" + dbInitial.getDbPort()); //$NON-NLS-1$
                }
            }
        });
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);

        grpDbData = new Group(area, SWT.NONE);
        grpDbData.setText(Messages.dbStoreEditorDialog_db_info);
        grpDbData.setLayout(new GridLayout(2, false));
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        gd.widthHint = 480;
        grpDbData.setLayoutData(gd);

        new Label(grpDbData, SWT.NONE).setText(Messages.entry_name);

        txtName = new Text(grpDbData, SWT.BORDER);
        txtName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(grpDbData, SWT.NONE).setText(Messages.dB_name);

        txtDbName = new Text(grpDbData, SWT.BORDER);
        txtDbName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(grpDbData, SWT.NONE).setText(Messages.dB_user);

        txtDbUser = new Text(grpDbData, SWT.BORDER);
        txtDbUser.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(grpDbData, SWT.NONE).setText(Messages.dB_password);

        txtDbPass = new Text(grpDbData, SWT.BORDER | SWT.PASSWORD);
        txtDbPass.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtDbPass.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                GridData gd = (GridData) lblWarnDbPass.getLayoutData();

                if((txtDbPass.getText().isEmpty() && !gd.exclude)
                        || (!txtDbPass.getText().isEmpty() && gd.exclude)) {
                    lblWarnDbPass.setVisible(!lblWarnDbPass.getVisible());
                    gd.exclude = !gd.exclude;

                    getShell().pack();
                }
            }
        });

        lblWarnDbPass = new CLabel(grpDbData, SWT.NONE);
        lblWarnDbPass.setImage(Activator.getEclipseImage(ISharedImages.IMG_OBJS_WARN_TSK));
        lblWarnDbPass.setText(Messages.warning_providing_password_here_is_insecure_use_pgpass_instead);
        gd = new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1);
        gd.exclude = true;
        lblWarnDbPass.setLayoutData(gd);
        lblWarnDbPass.setVisible(false);

        new Label(grpDbData, SWT.NONE).setText(Messages.dB_host);

        txtDbHost = new Text(grpDbData, SWT.BORDER);
        txtDbHost.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(grpDbData, SWT.NONE).setText(Messages.dbPicker_port);

        txtDbPort = new Text(grpDbData, SWT.BORDER);
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

        return area;
    }

    @Override
    protected void okPressed() {
        int dbport;
        String port = txtDbPort.getText();
        if(txtDbPort.getText().isEmpty()) {
            dbport = 0;
        } else {
            try {
                dbport = Integer.parseInt(port);
            } catch (NumberFormatException ex) {
                MessageBox mb = new MessageBox(getShell(), SWT.ICON_ERROR);
                mb.setText(Messages.dbStoreEditorDialog_cannot_save_entry);
                mb.setMessage(MessageFormat.format(
                        Messages.dbStoreEditorDialog_not_valid_port_number,
                        port));
                mb.open();
                return;
            }
        }

        dbInfo = new DbInfo(txtName.getText(), txtDbName.getText(),
                txtDbUser.getText(), txtDbPass.getText(),
                txtDbHost.getText(), dbport);
        super.okPressed();
    }
}
