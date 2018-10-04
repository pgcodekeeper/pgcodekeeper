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
    private CLabel lblWarnDbPass;
    private Button btnReadOnly;
    private Button btnGenerateName;
    private Button btnMsSql;
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
                }

                txtDbHost.setText(dbHost);
                txtDbPort.setText(dbPort);
                txtDbName.setText(dbName);
                txtDbUser.setText(dbUser);
                txtDbPass.setText(dbPass);
                txtName.setText(entryName);
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
                    Program.launch("https://pgcodekeeper.readthedocs.io/ru/latest/windowsauth.html"); //$NON-NLS-1$
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

        Link linkHint = new Link(tabAreaProperties, SWT.NONE);
        String link = "https://jdbc.postgresql.org/documentation/head/connect.html"; //$NON-NLS-1$
        linkHint.setText("<a>" + link + "</a>"); //$NON-NLS-1$ //$NON-NLS-2$
        linkHint.addSelectionListener(new SelectionAdapter()  {

            @Override
            public void widgetSelected(SelectionEvent e) {
                Program.launch(link);
            }
        });

        propertyListEditor = new DbPropertyListEditor(tabAreaProperties);

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
                                btnReadOnly.getSelection(), isWinAuth());
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
                btnGenerateName.getSelection(), ignoreListEditor.getList(),
                propertyListEditor.getList().stream()
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue)),
                btnMsSql.getSelection(), isWinAuth());
        super.okPressed();
    }

    @Override
    protected boolean isResizable() {
        return true;
    }
}