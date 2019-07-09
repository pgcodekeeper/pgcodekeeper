package ru.taximaxim.codekeeper.ui.dbstore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;

import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcMsConnector;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.CMD_VARS;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.properties.IgnoreListProperties.IgnoreListEditor;

public class DbStoreEditorDialog extends TrayDialog {

    private static final String DEFAULT_HOST = "127.0.0.1"; //$NON-NLS-1$
    private static final String DEFAULT_PORT = "5432"; //$NON-NLS-1$

    private final DbInfo dbInitial;
    private DbInfo dbInfo;

    private Text txtName;
    private Text txtDbName;
    private Text txtDbUser;
    private Text txtDbPass;
    private Text txtDbHost;
    private Text txtDbPort;
    private Text txtDumpFile;
    private Text txtDumpParameters;
    private Text txtDomain;
    private CLabel lblWarnDbPass;
    private Button btnDumpChoose;
    private Button btnReadOnly;
    private Button btnGenerateName;
    private Button btnMsSql;
    private Button btnUseDump;
    private Button btnWinAuth;

    private IgnoreListEditor ignoreListEditor;
    private DbPropertyListEditor propertyListEditor;

    private final SelectionListener msStateUpdater = new SelectionAdapter() {

        @Override
        public void widgetSelected(SelectionEvent e) {
            boolean ms = btnMsSql.getSelection();
            boolean win = ms && isWinAuth();
            if (btnWinAuth != null) {
                btnWinAuth.setEnabled(ms);
            }
            txtDbUser.setEnabled(!win);
            txtDbPass.setEnabled(!win);
            txtDomain.setEnabled(ms && !isWinAuth());
        }
    };

    public DbInfo getDbInfo(){
        return dbInfo;
    }

    private boolean isWinAuth() {
        return btnWinAuth != null && btnWinAuth.getSelection();
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

                boolean generateEntryName = true;
                String dbHost = DEFAULT_HOST;
                String dbPort = DEFAULT_PORT;
                String dbName = ""; //$NON-NLS-1$
                String dbUser = ""; //$NON-NLS-1$
                String dbPass = ""; //$NON-NLS-1$
                String entryName = ""; //$NON-NLS-1$;
                String domain = ""; //$NON-NLS-1$;
                List<String> ignoreList = null;
                List<Entry<String, String>> properties = null;

                if (dbInitial != null) {
                    dbHost = dbInitial.getDbHost();
                    dbPort = Integer.toString(dbInitial.getDbPort());
                    dbName = dbInitial.getDbName();
                    dbUser = dbInitial.getDbUser();
                    dbPass = dbInitial.getDbPass();
                    generateEntryName = dbInitial.isGeneratedName();
                    entryName = dbInitial.getName();
                    domain = dbInitial.getDomain();
                    ignoreList = dbInitial.getIgnoreFiles();

                    properties = dbInitial.getProperties().entrySet().stream()
                            .map(SimpleEntry::new)
                            .collect(Collectors.toCollection(ArrayList::new));

                    btnReadOnly.setSelection(dbInitial.isReadOnly());
                    btnMsSql.setSelection(dbInitial.isMsSql());
                    if (btnWinAuth != null) {
                        btnWinAuth.setSelection(dbInitial.isWinAuth());
                    }
                    msStateUpdater.widgetSelected(null);

                    btnUseDump.setSelection(dbInitial.isPgDumpSwitch());
                    txtDumpFile.setText(dbInitial.getPgdumpExePath());
                    txtDumpParameters.setText(dbInitial.getPgdumpCustomParams());
                }

                txtDbHost.setText(dbHost);
                txtDbPort.setText(dbPort);
                txtDbName.setText(dbName);
                txtDbUser.setText(dbUser);
                txtDbPass.setText(dbPass);
                txtName.setText(entryName);
                txtDomain.setText(domain != null ? domain : ""); //$NON-NLS-1$;
                btnGenerateName.setSelection(generateEntryName);
                ignoreListEditor.setInputList(ignoreList != null ? ignoreList : new ArrayList<>());
                propertyListEditor.setInputList(properties != null ? properties : new ArrayList<>());

                autofillNameField();
                txtName.setEnabled(!generateEntryName);
            }
        });
    }

    private String generateEntryName() {
        StringBuilder entryNameSb = new StringBuilder();

        String dbUser = txtDbUser.getText();
        if (!dbUser.isEmpty()) {
            entryNameSb.append(dbUser).append('@');
        }

        String dbHost = txtDbHost.getText();
        entryNameSb.append(dbHost.isEmpty() ? DEFAULT_HOST : dbHost);

        String dbPort = txtDbPort.getText();
        String verifiedDbPort = dbPort.isEmpty() || "0".equals(dbPort) ? DEFAULT_PORT : dbPort; //$NON-NLS-1$
        if (!DEFAULT_PORT.equals(verifiedDbPort)) {
            entryNameSb.append(':').append(verifiedDbPort);
        }

        String dbName = txtDbName.getText();
        if (!dbName.isEmpty()) {
            entryNameSb.append('/').append(dbName);
        }

        return entryNameSb.toString();
    }

    private void autofillNameField() {
        if (btnGenerateName.getSelection()) {
            txtName.setText(generateEntryName());
        }
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);

        TabFolder tabFolder = new TabFolder(area, SWT.NONE);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        gd.minimumWidth = 700;
        tabFolder.setLayoutData(gd);

        //// Creating tab item "Db Info" and fill it by components.

        Composite tabAreaDb = createTabItemWithComposite(tabFolder, Messages.dbStoreEditorDialog_db_info,
                new GridLayout(4, false));

        ModifyListener modifyListener = e -> autofillNameField();

        new Label(tabAreaDb, SWT.NONE).setText(Messages.dB_host);

        txtDbHost = new Text(tabAreaDb, SWT.BORDER);
        txtDbHost.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtDbHost.addModifyListener(modifyListener);

        new Label(tabAreaDb, SWT.NONE).setText(Messages.dbPicker_port);

        txtDbPort = new Text(tabAreaDb, SWT.BORDER);
        txtDbPort.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, false, false));
        txtDbPort.addVerifyListener(e -> {
            try {
                if (!e.text.isEmpty() && Integer.valueOf(e.text) < 0) {
                    e.doit = false;
                }
            } catch(NumberFormatException ex) {
                e.doit = false;
            }
        });
        txtDbPort.addModifyListener(modifyListener);

        new Label(tabAreaDb, SWT.NONE).setText(Messages.dB_name);

        txtDbName = new Text(tabAreaDb, SWT.BORDER);
        txtDbName.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, false, false, 3, 1));
        txtDbName.addModifyListener(modifyListener);

        new Label(tabAreaDb, SWT.NONE).setText(Messages.dB_user);

        txtDbUser = new Text(tabAreaDb, SWT.BORDER);
        txtDbUser.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, false, false, 3, 1));
        txtDbUser.addModifyListener(modifyListener);

        new Label(tabAreaDb, SWT.NONE).setText(Messages.dB_password);

        txtDbPass = new Text(tabAreaDb, SWT.BORDER | SWT.PASSWORD);
        txtDbPass.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, false, false, 3, 1));
        txtDbPass.addModifyListener(e -> {
            GridData data = (GridData) lblWarnDbPass.getLayoutData();

            if (txtDbPass.getText().isEmpty() != data.exclude) {
                lblWarnDbPass.setVisible(data.exclude);
                data.exclude = !data.exclude;

                // ensures correct pack during shell activation
                UiSync.exec(getShell(), () -> getShell().pack());
            }
        });
        txtDbPass.addModifyListener(modifyListener);

        lblWarnDbPass = new CLabel(tabAreaDb, SWT.NONE);
        lblWarnDbPass.setImage(Activator.getEclipseImage(ISharedImages.IMG_OBJS_WARN_TSK));
        lblWarnDbPass.setText(Messages.warning_providing_password_here_is_insecure_use_pgpass_instead);
        lblWarnDbPass.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 4, 1));

        new Label(tabAreaDb, SWT.NONE).setText(Messages.DbStoreEditorDialog_read_only);

        btnReadOnly = new Button(tabAreaDb, SWT.CHECK);
        btnReadOnly.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, false, false, 3, 1));
        btnReadOnly.setText(Messages.DbStoreEditorDialog_read_only_description);

        new Label(tabAreaDb, SWT.NONE).setText(Messages.DbStoreEditorDialog_ms_sql_database);

        btnMsSql = new Button(tabAreaDb, SWT.CHECK);
        btnMsSql.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, false, false, 3, 1));
        btnMsSql.setText(Messages.DbStoreEditorDialog_connect_to_ms);
        btnMsSql.addSelectionListener(msStateUpdater);

        new Label(tabAreaDb, SWT.NONE).setText(Messages.domain);

        txtDomain = new Text(tabAreaDb, SWT.BORDER);
        txtDomain.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, false, false, 3, 1));

        if (Platform.OS_WIN32.equals(Platform.getOS())) {
            new Label(tabAreaDb, SWT.NONE).setText(Messages.DbStoreEditorDialog_win_auth);

            Composite cWinAuth = new Composite(tabAreaDb, SWT.NONE);
            GridLayout gl = new GridLayout(2, false);
            gl.marginWidth = 0;
            gl.marginHeight = 0;
            cWinAuth.setLayout(gl);
            cWinAuth.setLayoutData(new GridData(SWT.LEFT, SWT.DEFAULT, true, false, 3, 1));

            btnWinAuth = new Button(cWinAuth, SWT.CHECK);
            btnWinAuth.setText(Messages.DbStoreEditorDialog_use_win_auth);
            btnWinAuth.addSelectionListener(msStateUpdater);

            Link l = new Link(cWinAuth, SWT.NONE);
            l.setText(Messages.DbStoreEditorDialog_learn_more);
            l.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    Program.launch("https://pgcodekeeper.readthedocs.io/ru/latest/windowsauth.html#id2"); //$NON-NLS-1$
                }
            });
        }

        int verticalIndent = 15;

        Label lblEntryName = new Label(tabAreaDb, SWT.NONE);
        lblEntryName.setText(Messages.entry_name);
        gd = new GridData();
        gd.verticalIndent = verticalIndent;
        lblEntryName.setLayoutData(gd);

        txtName = new Text(tabAreaDb, SWT.BORDER);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = verticalIndent;
        txtName.setLayoutData(gd);

        btnGenerateName = new Button(tabAreaDb, SWT.CHECK);
        gd = new GridData();
        gd.horizontalSpan = 2;
        gd.verticalIndent = verticalIndent;
        btnGenerateName.setLayoutData(gd);
        btnGenerateName.setText(Messages.DbStoreEditorDialog_auto_generation);
        btnGenerateName.setToolTipText(Messages.DbStoreEditorDialog_auto_generation_description);
        btnGenerateName.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                autofillNameField();
                txtName.setEnabled(!btnGenerateName.getSelection());
            }
        });

        //// Creating tab item "Ignored objects files" and fill it by components.

        ignoreListEditor = new IgnoreListEditor(createTabItemWithComposite(tabFolder,
                Messages.DbStoreEditorDialog_ignore_file_list, new GridLayout()));

        //// Creating tab item "Connection properties" and fill it by components.

        Composite tabAreaProperties = createTabItemWithComposite(tabFolder,
                Messages.DbStoreEditorDialog_connection_properties, new GridLayout());

        new Label(tabAreaProperties, SWT.NONE).setText(Messages.DbPropertyListEditor_properties_hint);

        addLink(tabAreaProperties, Messages.DbPropertyListEditor_pg_link_hint,
                "https://jdbc.postgresql.org/documentation/head/connect.html"); //$NON-NLS-1$

        addLink(tabAreaProperties, Messages.DbPropertyListEditor_ms_link_hint,
                "https://docs.microsoft.com/sql/connect/jdbc/setting-the-connection-properties"); //$NON-NLS-1$

        propertyListEditor = new DbPropertyListEditor(tabAreaProperties);

        Composite tabPGDupmConfigProperties = createTabItemWithComposite(tabFolder,
                Messages.DbStoreEditorDialog_dump_properties, new GridLayout(3, false));

        btnUseDump = new Button(tabPGDupmConfigProperties, SWT.CHECK);
        btnUseDump.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, false, false, 3, 1));
        btnUseDump.setText(Messages.DbStoreEditorDialog_dump_switch);

        new Label(tabPGDupmConfigProperties, SWT.NONE).setText(Messages.DbStoreEditorDialog_dump_executable);

        txtDumpFile = new Text(tabPGDupmConfigProperties, SWT.BORDER);
        txtDumpFile.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtDumpFile.addModifyListener(modifyListener);

        btnDumpChoose = new Button(tabPGDupmConfigProperties, SWT.PUSH);
        btnDumpChoose.setText(Messages.DbStoreEditorDialog_dump_browse);
        btnDumpChoose.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent event) {
                FileDialog dialog = new FileDialog(getShell());
                dialog.setText(Messages.DbStoreEditorDialog_dump_file_dialog_header);
                dialog.setFilterExtensions(new String[] {"*"}); //$NON-NLS-1$
                dialog.setFilterNames(new String[] {Messages.DbStoreEditorDialog_dump_filter});
                dialog.setFileName(DbInfo.DEFAULT_EXECUTE_PATH);
                String path2Dump = dialog.open();
                if(path2Dump != null) {
                    txtDumpFile.setText(path2Dump);
                }
            }
        });

        new Label(tabPGDupmConfigProperties, SWT.NONE).setText(
                MessageFormat.format(Messages.DbStoreEditorDialog_dump_custom_parameters,
                        CMD_VARS.DB_NAME_PLACEHOLDER, CMD_VARS.DB_HOST_PLACEHOLDER,
                        CMD_VARS.DB_PORT_PLACEHOLDER, CMD_VARS.DB_USER_PLACEHOLDER,
                        CMD_VARS.DB_PASS_PLACEHOLDER));

        txtDumpParameters = new Text(tabPGDupmConfigProperties, SWT.BORDER);
        txtDumpParameters.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, false, false, 2, 1));
        txtDumpParameters.addModifyListener(modifyListener);

        return area;
    }

    /**
     * Creates a tab item with its own composite.
     *
     * @param tabFolder TabFolder object
     * @param tabText text for tab item
     * @param gl GridLayout for the composite
     * @return the composite belonging to the created tab item
     */
    private Composite createTabItemWithComposite(TabFolder tabFolder, String tabText,
            GridLayout gl) {
        Composite tabComposite = new Composite(tabFolder, SWT.NONE);
        tabComposite.setLayout(gl);
        tabComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
        tabItem.setText(tabText);
        tabItem.setControl(tabComposite);
        return tabComposite;
    }

    private void addLink(Composite parent, String hint, String link) {
        Link linkHint = new Link(parent, SWT.NONE);
        linkHint.setText("<a>" + link + "</a> " + hint); //$NON-NLS-1$ //$NON-NLS-2$
        linkHint.addSelectionListener(new SelectionAdapter()  {

            @Override
            public void widgetSelected(SelectionEvent e) {
                Program.launch(link);
            }
        });
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
                    JdbcConnector connector;
                    if (btnMsSql.getSelection()) {
                        connector = new JdbcMsConnector(txtDbHost.getText(), dbport,
                                txtDbUser.getText(), txtDbPass.getText(),
                                txtDbName.getText(), propertyListEditor.getList().stream()
                                .collect(Collectors.toMap(Entry::getKey, Entry::getValue)),
                                btnReadOnly.getSelection(), isWinAuth(), txtDomain.getText());
                    } else {
                        connector = new JdbcConnector(txtDbHost.getText(), dbport,
                                txtDbUser.getText(), txtDbPass.getText(),
                                txtDbName.getText(), propertyListEditor.getList().stream()
                                .collect(Collectors.toMap(Entry::getKey, Entry::getValue)),
                                btnReadOnly.getSelection(), ApgdiffConsts.UTC);
                    }

                    try (Connection connection = connector.getConnection()) {
                        style = SWT.OK;
                        message = Messages.DbStoreEditorDialog_successfull_connection;
                    }
                } catch (NumberFormatException ex) {
                    message = MessageFormat.format(
                            Messages.dbStoreEditorDialog_not_valid_port_number,
                            port);
                    style = SWT.ICON_ERROR;
                } catch (SQLException | IOException ex) {
                    Log.log(Log.LOG_INFO, "Connection test error", ex); //$NON-NLS-1$
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

        String exePath;
        if (txtDumpFile.getText().isEmpty()) {
            exePath = DbInfo.DEFAULT_EXECUTE_PATH;
        } else {
            exePath = txtDumpFile.getText();
        }

        if (txtName.getText().isEmpty()) {
            MessageBox mb = new MessageBox(getShell(),
                    SWT.ICON_WARNING);
            mb.setText(Messages.dbStoreEditorDialog_cannot_save_entry);
            mb.setMessage(Messages.dbStoreEditorDialog_empty_name);
            mb.open();
        } else {
            dbInfo = new DbInfo(txtName.getText(), txtDbName.getText(),
                    txtDbUser.getText(), txtDbPass.getText(),
                    txtDbHost.getText(), dbport, btnReadOnly.getSelection(),
                    btnGenerateName.getSelection(), ignoreListEditor.getList(),
                    propertyListEditor.getList().stream()
                    .collect(Collectors.toMap(Entry::getKey, Entry::getValue)),
                    btnMsSql.getSelection(), isWinAuth(), txtDomain.getText(),
                    exePath, txtDumpParameters.getText(), btnUseDump.getSelection());
            super.okPressed();
        }
    }

    @Override
    protected boolean isResizable() {
        return true;
    }
}