package ru.taximaxim.codekeeper.ui.dbstore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.MessageFormat;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;

import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;

public class DbStoreEditorDialog extends TrayDialog {

    private final DbInfo dbInitial;
    private DbInfo dbInfo;

    private Text txtName;
    private Text txtDbName;
    private Text txtDbUser;
    private Text txtDbPass;
    private Text txtDbHost;
    private Text txtDbPort;
    private CLabel lblWarnDbPass;
    private Button btnReadOnly;

    private DbIgnoreListEditor listEditor;

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

                if (dbInitial != null) {
                    txtName.setText(dbInitial.getName());
                    txtDbName.setText(dbInitial.getDbName());
                    txtDbUser.setText(dbInitial.getDbUser());
                    txtDbPass.setText(dbInitial.getDbPass());
                    txtDbHost.setText(dbInitial.getDbHost());
                    txtDbPort.setText("" + dbInitial.getDbPort()); //$NON-NLS-1$
                    btnReadOnly.setSelection(dbInitial.isReadOnly());
                    listEditor.setInputList(dbInitial.getIgnoreFiles());
                } else {
                    txtDbPass.setText("");//$NON-NLS-1$
                }
            }
        });
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);
        area.setLayout(new GridLayout(2, true));
        area.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        final Group grpDbData = new Group(area, SWT.NONE);
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
        txtDbPass.addModifyListener(e -> {
            GridData data = (GridData) lblWarnDbPass.getLayoutData();

            if (txtDbPass.getText().isEmpty() != data.exclude) {
                lblWarnDbPass.setVisible(data.exclude);
                data.exclude = !data.exclude;

                // ensures correct pack during shell activation
                UiSync.exec(getShell(), () -> getShell().pack());
            }
        });

        lblWarnDbPass = new CLabel(grpDbData, SWT.NONE);
        lblWarnDbPass.setImage(Activator.getEclipseImage(ISharedImages.IMG_OBJS_WARN_TSK));
        lblWarnDbPass.setText(Messages.warning_providing_password_here_is_insecure_use_pgpass_instead);
        lblWarnDbPass.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));

        new Label(grpDbData, SWT.NONE).setText(Messages.dB_host);

        txtDbHost = new Text(grpDbData, SWT.BORDER);
        txtDbHost.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(grpDbData, SWT.NONE).setText(Messages.dbPicker_port);

        txtDbPort = new Text(grpDbData, SWT.BORDER);
        gd = new GridData(60, SWT.DEFAULT);
        txtDbPort.setLayoutData(gd);
        txtDbPort.addVerifyListener(e -> {

            try {
                if (!e.text.isEmpty() && Integer.valueOf(e.text) < 0) {
                    e.doit = false;
                }
            } catch(NumberFormatException ex) {
                e.doit = false;
            }
        });

        new Label(grpDbData, SWT.NONE).setText(Messages.DbStoreEditorDialog_read_only);

        btnReadOnly = new Button(grpDbData, SWT.CHECK);
        btnReadOnly.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        btnReadOnly.setText(Messages.DbStoreEditorDialog_read_only_description);

        final Group grpDbIgnoreList = new Group(area, SWT.NONE);
        grpDbIgnoreList.setText(Messages.DbStoreEditorDialog_ignore_file_list);
        grpDbIgnoreList.setLayout(new GridLayout(2, false));
        grpDbIgnoreList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        listEditor = new DbIgnoreListEditor(grpDbIgnoreList);

        return area;
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        Button btnTestConnection = createButton(parent, IDialogConstants.CLIENT_ID, Messages.DbStoreEditorDialog_test_connection, true);
        btnTestConnection.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                int style;
                String message;
                String port = txtDbPort.getText();

                try {
                    int dbport = port.isEmpty() ? 0 : Integer.parseInt(port);

                    try (Connection connection = new JdbcConnector(txtDbHost.getText(), dbport,
                            txtDbUser.getText(), txtDbPass.getText(),
                            txtDbName.getText(), ApgdiffConsts.UTC).getConnection()) {
                        style = SWT.OK;
                        message = Messages.DbStoreEditorDialog_successfull_connection;
                    }
                } catch (NumberFormatException ex) {
                    message = MessageFormat.format(
                            Messages.dbStoreEditorDialog_not_valid_port_number,
                            port);
                    style = SWT.ICON_ERROR;
                } catch (SQLException | IOException ex) {
                    message = Messages.DbStoreEditorDialog_failed_connection_reason + ex.getLocalizedMessage();
                    style = SWT.ICON_ERROR;
                }

                MessageBox mb = new MessageBox(getShell(), style);
                mb.setText(style == SWT.ERROR ? Messages.DbStoreEditorDialog_failed_connection : Messages.DbStoreEditorDialog_success);
                mb.setMessage(message);
                mb.open();
            }
        });

        super.createButtonsForButtonBar(parent);
    }

    @Override
    protected void okPressed() {
        int dbport;
        String port = txtDbPort.getText();
        if (txtDbPort.getText().isEmpty()) {
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
                txtDbHost.getText(), dbport, btnReadOnly.getSelection(),
                listEditor.getList());
        super.okPressed();
    }
}

class DbIgnoreListEditor extends PrefListEditor<String, ListViewer> {

    public DbIgnoreListEditor(Composite parent) {
        super(parent);
    }

    @Override
    protected String getNewObject(String oldObject) {
        FileDialog dialog = new FileDialog(getShell());
        dialog.setText(Messages.DbStoreEditorDialog_select_ignore_file);
        dialog.setFilterExtensions(new String[] {"*.pgcodekeeperignore", "*"}); //$NON-NLS-1$ //$NON-NLS-2$
        dialog.setFilterNames(new String[] {
                Messages.DbStoreEditorDialog_pgcodekeeperignore_files_filter,
                Messages.DiffPresentationPane_any_file_filter});
        dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());
        return dialog.open();
    }

    @Override
    protected String errorAlreadyExists(String obj) {
        return MessageFormat.format(Messages.DbStorePrefPage_already_present, obj);
    }

    @Override
    protected ListViewer createViewer(Composite parent) {
        ListViewer viewerObjs = new ListViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        GridData gd =  new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2);
        viewerObjs.getControl().setLayoutData(gd);
        viewerObjs.setContentProvider(ArrayContentProvider.getInstance());
        return viewerObjs;
    }
}