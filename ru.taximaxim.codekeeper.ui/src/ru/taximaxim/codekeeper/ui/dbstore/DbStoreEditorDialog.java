package ru.taximaxim.codekeeper.ui.dbstore;

import java.text.MessageFormat;

import org.eclipse.jface.dialogs.TrayDialog;
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

    private final DbInfo dbInitial;
    private DbInfo dbInfo;
    private DbPicker grpDbData;

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
        GridLayout gridLayout = new GridLayout();
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        container.setLayout(gridLayout);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        grpDbData = new DbPicker(container, SWT.NONE, null);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        gd.widthHint = 480;
        grpDbData.setLayoutData(gd);
        grpDbData.setText(Messages.dbStoreEditorDialog_db_info);

        if (dbInitial != null){
            grpDbData.getTxtName().setText(this.dbInitial.name);
            grpDbData.getTxtDbName().setText(this.dbInitial.dbname);
            grpDbData.getTxtDbUser().setText(this.dbInitial.dbuser);
            grpDbData.getTxtDbPass().setText(this.dbInitial.dbpass);
            grpDbData.getTxtDbHost().setText(this.dbInitial.dbhost);
            grpDbData.getTxtDbPort().setText("" + this.dbInitial.dbport); //$NON-NLS-1$
        }

        return area;
    }

    @Override
    protected void okPressed() {
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

        dbInfo = new DbInfo(grpDbData.getTxtName().getText(), grpDbData.getTxtDbName().getText(),
                grpDbData.getTxtDbUser().getText(), grpDbData.getTxtDbPass().getText(),
                grpDbData.getTxtDbHost().getText(), dbport);
        super.okPressed();
    }
}
