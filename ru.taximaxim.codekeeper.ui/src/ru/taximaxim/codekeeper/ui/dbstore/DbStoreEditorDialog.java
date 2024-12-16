/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.dbstore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.CMD_VARS;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.properties.IgnoreListProperties.IgnoreListEditor;
import ru.taximaxim.codekeeper.ui.xmlstore.ConnectioTypeXMLStore;

public final class DbStoreEditorDialog extends TrayDialog {

    private final String action;

    private static final String DEFAULT_HOST = "127.0.0.1"; //$NON-NLS-1$
    private static final String WARNING_IMAGE = "\u2757"; //$NON-NLS-1$

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
    private Button btnReadOnly;
    private Button btnGenerateName;
    private ComboViewer cmbDbType;
    private Button btnMsCert;
    private Button btnUseDump;
    private Button btnWinAuth;
    private ComboViewer cmbGroups;
    private ComboViewer cmbConTypes;
    private final Set<String> dbGroups;

    private IgnoreListEditor ignoreListEditor;
    private DbPropertyListEditor propertyListEditor;

    public DbInfo getDbInfo(){
        return dbInfo;
    }

    private boolean isWinAuth() {
        return btnWinAuth != null && btnWinAuth.getSelection();
    }

    public DbStoreEditorDialog(Shell shell, DbInfo dbInitial, String action,
            Set<String> dbGroups) {
        super(shell);
        this.dbInitial = dbInitial;
        this.action = action;
        this.dbGroups = dbGroups;
    }

    @Override
    protected void configureShell(final Shell newShell) {
        super.configureShell(newShell);
        String dialogName = (dbInitial != null) ? action + ": " + dbInitial.getName() : action; //$NON-NLS-1$
        newShell.setText(dialogName);
        newShell.addShellListener(new ShellAdapter() {

            @Override
            public void shellActivated(ShellEvent e) {
                // one time listener
                newShell.removeShellListener(this);

                boolean generateEntryName = true;
                DatabaseType dbType = DatabaseType.PG;
                String dbHost = DEFAULT_HOST;
                String dbPort = dbType.getDefaultPort();
                String dbName = ""; //$NON-NLS-1$
                String dbUser = ""; //$NON-NLS-1$
                String dbPass = ""; //$NON-NLS-1$
                String dbGroup = ""; //$NON-NLS-1$
                String dbConType = ""; //$NON-NLS-1$
                String entryName = ""; //$NON-NLS-1$
                String domain = ""; //$NON-NLS-1$
                List<String> ignoreList = null;
                List<Entry<String, String>> properties = null;

                if (dbInitial != null) {
                    dbHost = dbInitial.getDbHost();
                    dbPort = Integer.toString(dbInitial.getDbPort());
                    dbName = dbInitial.getDbName();
                    dbUser = dbInitial.getDbUser();
                    dbPass = dbInitial.getDbPass();
                    dbGroup = dbInitial.getDbGroup();
                    dbConType = dbInitial.getConType();
                    generateEntryName = dbInitial.isGeneratedName();
                    entryName = dbInitial.getName();
                    domain = dbInitial.getDomain();
                    dbType = dbInitial.getDbType();
                    ignoreList = dbInitial.getIgnoreFiles();

                    properties = dbInitial.getProperties().entrySet().stream()
                            .map(SimpleEntry::new)
                            .collect(Collectors.toCollection(ArrayList::new));

                    btnReadOnly.setSelection(dbInitial.isReadOnly());
                    if (btnWinAuth != null) {
                        btnWinAuth.setSelection(dbInitial.isWinAuth());
                    }

                    btnUseDump.setSelection(dbInitial.isPgDumpSwitch());
                    txtDumpFile.setText(dbInitial.getPgdumpExePath());
                    txtDumpParameters.setText(dbInitial.getPgdumpCustomParams());
                    if (dbType == DatabaseType.MS) {
                        String msTrustCert = dbInitial.getProperties().get(Consts.TRUST_CERT);
                        btnMsCert.setSelection(msTrustCert == null || Boolean.parseBoolean(msTrustCert));
                    }
                    cmbDbType.setSelection(new StructuredSelection(dbType));
                }

                txtDbHost.setText(dbHost);
                txtDbPort.setText(dbPort);
                txtDbName.setText(dbName);
                txtDbUser.setText(dbUser);
                txtDbPass.setText(dbPass);
                if (dbGroup != null) {
                    cmbGroups.setSelection(new StructuredSelection(dbGroup));
                }
                if (dbConType != null) {
                    cmbConTypes.setSelection(new StructuredSelection(dbConType));
                }
                txtName.setText(entryName);
                txtDomain.setText(domain != null ? domain : ""); //$NON-NLS-1$
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

        String defPort = getSelectedDbType().getDefaultPort();
        String dbPort = txtDbPort.getText();
        if (!dbPort.isEmpty() && !"0".equals(dbPort) && !defPort.equals(dbPort)) { //$NON-NLS-1$
            entryNameSb.append(':').append(dbPort);
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

        new Label(tabAreaDb, SWT.NONE);

        Label lblPgpassSupport = new Label(tabAreaDb, SWT.NONE);
        lblPgpassSupport.setText(Messages.pgpass_passwords_supported);
        lblPgpassSupport.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 3, 1));

        int verticalIndent = 10;

        Label lblReadOnly = new Label(tabAreaDb, SWT.NONE);
        lblReadOnly.setText(Messages.DbStoreEditorDialog_read_only);
        gd = new GridData();
        gd.verticalIndent = verticalIndent;
        lblReadOnly.setLayoutData(gd);

        btnReadOnly = new Button(tabAreaDb, SWT.CHECK);
        gd = new GridData(SWT.FILL, SWT.DEFAULT, false, false, 3, 1);
        gd.verticalIndent = verticalIndent;
        btnReadOnly.setLayoutData(gd);
        btnReadOnly.setText(Messages.DbStoreEditorDialog_read_only_description);

        new Label(tabAreaDb, SWT.NONE).setText(Messages.database_type);

        cmbDbType = new ComboViewer(tabAreaDb, SWT.READ_ONLY);
        cmbDbType.getCombo().setLayoutData(new GridData(SWT.DEFAULT, SWT.DEFAULT, false, false, 3, 1));
        cmbDbType.setContentProvider(ArrayContentProvider.getInstance());
        cmbDbType.setLabelProvider(UIConsts.DATABASE_TYPE_PROVIDER);
        cmbDbType.setInput(DatabaseType.values());
        cmbDbType.getCombo().select(0);

        cmbDbType.addSelectionChangedListener(e -> {
            boolean ms = DatabaseType.MS == getSelectedDbType();
            boolean win = ms && isWinAuth();
            if (btnWinAuth != null) {
                btnWinAuth.setEnabled(ms);
            }
            txtDbUser.setEnabled(!win);
            txtDbPass.setEnabled(!win);
            txtDomain.setEnabled(ms && !isWinAuth());
            btnMsCert.setEnabled(ms);
        });
        new Label(tabAreaDb, SWT.NONE).setText(Messages.DbStoreEditorDialog_ms_cert);

        btnMsCert = new Button(tabAreaDb, SWT.CHECK);
        btnMsCert.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, false, false, 3, 1));
        btnMsCert.setText(Messages.DbStoreEditorDialog_trust_mssql);
        btnMsCert.setEnabled(false);
        btnMsCert.setSelection(true);

        new Label(tabAreaDb, SWT.NONE).setText(Messages.domain);

        txtDomain = new Text(tabAreaDb, SWT.BORDER);
        txtDomain.setEnabled(false);
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
            btnWinAuth.setEnabled(false);

            Link l = new Link(cWinAuth, SWT.NONE);
            l.setText(Messages.DbStoreEditorDialog_learn_more);
            l.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    Program.launch("https://pgcodekeeper.readthedocs.io/ru/latest/windowsauth.html#id2"); //$NON-NLS-1$
                }
            });
        }

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

        Label lblDB = new Label(tabAreaDb, SWT.NONE);
        lblDB.setText(Messages.DbStoreEditorDialog_choice_db_group);

        cmbGroups = new ComboViewer(tabAreaDb, SWT.DROP_DOWN);
        cmbGroups.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, false, false, 3, 1));
        cmbGroups.setContentProvider(ArrayContentProvider.getInstance());
        dbGroups.removeIf(String::isEmpty);
        cmbGroups.setInput(dbGroups);

        Label lblType = new Label(tabAreaDb, SWT.NONE);
        lblType.setText(Messages.DbStoreEditorDialog_connection_type);

        cmbConTypes = new ComboViewer(tabAreaDb, SWT.DROP_DOWN | SWT.READ_ONLY);
        cmbConTypes.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, false, false, 3, 1));
        cmbConTypes.setContentProvider(ArrayContentProvider.getInstance());

        Label warning = new Label(tabAreaDb, SWT.CENTER);
        warning.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, false, false, 3, 1));
        warning.setText(WARNING_IMAGE + Messages.DbStoreEditorDialog_warning_message);
        warning.setVisible(false);

        Set<String> conTypes = new LinkedHashSet<>();
        conTypes.add(""); //$NON-NLS-1$
        ConnectioTypeXMLStore.readStoreFromXml().forEach(e -> conTypes.add(e.getName()));
        if (dbInitial != null) {
            String brokenType = dbInitial.getConType();
            if (brokenType != null && conTypes.add(brokenType)) {
                cmbConTypes.addSelectionChangedListener(e -> {
                    var sel = (IStructuredSelection) e.getSelection();
                    var selConTypeName = (String) sel.getFirstElement();
                    warning.setVisible(brokenType.equals(selConTypeName));
                });
            }
        }
        cmbConTypes.setInput(conTypes);

        //// Creating tab item "Ignored objects files" and fill it by components.

        ignoreListEditor = new IgnoreListEditor(createTabItemWithComposite(tabFolder,
                Messages.DbStoreEditorDialog_ignore_file_list, new GridLayout()));
        ignoreListEditor.setLayoutData(new GridData(GridData.FILL_BOTH));

        //// Creating tab item "Connection properties" and fill it by components.

        Composite tabAreaProperties = createTabItemWithComposite(tabFolder,
                Messages.DbStoreEditorDialog_connection_properties, new GridLayout());

        new Label(tabAreaProperties, SWT.NONE).setText(Messages.DbPropertyListEditor_properties_hint);

        addLink(tabAreaProperties, Messages.DbPropertyListEditor_pg_link_hint,
                "https://jdbc.postgresql.org/documentation/head/connect.html"); //$NON-NLS-1$

        addLink(tabAreaProperties, Messages.DbPropertyListEditor_ms_link_hint,
                "https://docs.microsoft.com/sql/connect/jdbc/setting-the-connection-properties"); //$NON-NLS-1$

        addLink(tabAreaProperties, Messages.DbPropertyListEditor_ch_link_hint,
                "https://clickhouse.com/docs/en/integrations/java#jdbc-driver"); //$NON-NLS-1$

        propertyListEditor = new DbPropertyListEditor(tabAreaProperties);
        propertyListEditor.setLayoutData(new GridData(GridData.FILL_BOTH));

        Composite tabPGDupmConfigProperties = createTabItemWithComposite(tabFolder,
                Messages.DbStoreEditorDialog_dump_properties, new GridLayout(3, false));

        btnUseDump = new Button(tabPGDupmConfigProperties, SWT.CHECK);
        btnUseDump.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, false, false, 3, 1));
        btnUseDump.setText(Messages.DbStoreEditorDialog_dump_switch);

        new Label(tabPGDupmConfigProperties, SWT.NONE).setText(Messages.DbStoreEditorDialog_dump_executable);

        txtDumpFile = new Text(tabPGDupmConfigProperties, SWT.BORDER);
        txtDumpFile.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtDumpFile.addModifyListener(modifyListener);

        Button btnDumpChoose = new Button(tabPGDupmConfigProperties, SWT.PUSH);
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
        Button btnTestConnection = createButton(parent, IDialogConstants.CLIENT_ID,
                Messages.DbStoreEditorDialog_test_connection, true);
        btnTestConnection.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                runTest();
            }
        });

        super.createButtonsForButtonBar(parent);
    }

    private void runTest() {
        DbInfo testDbInfo = generateDbInfo();
        getButton(IDialogConstants.CLIENT_ID).setEnabled(false);

        String title = "Connection test for: " + testDbInfo.getName(); //$NON-NLS-1$
        Job job = new Job(title) {

            @Override
            protected IStatus run(IProgressMonitor monitor) {
                var connector = new DbInfoJdbcConnector(testDbInfo, 10);
                try (Connection connection = connector.getConnection()) {
                    return Status.OK_STATUS;
                } catch (NumberFormatException ex) {
                    return new Status(IStatus.ERROR, PLUGIN_ID.THIS,
                            Messages.dbStoreEditorDialog_not_valid_port_number + txtDbPort.getText(), ex);
                } catch (SQLException | IOException ex) {
                    return new Status(IStatus.ERROR, PLUGIN_ID.THIS,
                            Messages.DbStoreEditorDialog_failed_connection_reason, ex);
                }
            }
        };

        job.addJobChangeListener(new JobChangeAdapter() {

            @Override
            public void done(IJobChangeEvent event) {
                UiSync.exec(getShell(), () -> {
                    if (event.getResult().isOK()) {
                        MessageDialog.open(MessageDialog.INFORMATION, getShell(), title,
                                Messages.DbStoreEditorDialog_successfull_connection, SWT.NONE);
                    }
                    getButton(IDialogConstants.CLIENT_ID).setEnabled(true);
                });
            }
        });

        job.setUser(true);
        job.schedule();
    }

    @Override
    protected void okPressed() {
        String port = txtDbPort.getText();
        if (!port.isEmpty()) {
            try {
                Integer.parseInt(port);
            } catch (NumberFormatException ex) {
                MessageBox mb = new MessageBox(getShell(), SWT.ICON_ERROR);
                mb.setText(Messages.dbStoreEditorDialog_cannot_save_entry);
                mb.setMessage(MessageFormat.format(Messages.dbStoreEditorDialog_not_valid_port_number, port));
                mb.open();
                return;
            }
        }

        if (txtName.getText().isEmpty()) {
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_WARNING);
            mb.setText(Messages.dbStoreEditorDialog_cannot_save_entry);
            mb.setMessage(Messages.dbStoreEditorDialog_empty_name);
            mb.open();
        } else {
            dbInfo = generateDbInfo();
            super.okPressed();
        }
    }

    private DbInfo generateDbInfo() {
        String port = txtDbPort.getText();
        int dbport = port.isEmpty() ? 0 : Integer.parseInt(port);

        DatabaseType dbType = getSelectedDbType();

        Map<String, String> properties = propertyListEditor.getList().stream()
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
        if (dbType == DatabaseType.MS) {
            properties.put(Consts.TRUST_CERT, String.valueOf(btnMsCert.getSelection()));
        }

        String exePath;
        if (txtDumpFile.getText().isEmpty()) {
            exePath = DbInfo.DEFAULT_EXECUTE_PATH;
        } else {
            exePath = txtDumpFile.getText();
        }

        return new DbInfo(txtName.getText(), txtDbName.getText(), txtDbUser.getText(), txtDbPass.getText(),
                txtDbHost.getText(), dbport, btnReadOnly.getSelection(), btnGenerateName.getSelection(),
                ignoreListEditor.getList(), properties, dbType, isWinAuth(), txtDomain.getText(), exePath,
                txtDumpParameters.getText(), btnUseDump.getSelection(), cmbGroups.getCombo().getText(),
                cmbConTypes.getCombo().getText());
    }

    public DatabaseType getSelectedDbType() {
        return (DatabaseType) cmbDbType.getStructuredSelection().getFirstElement();
    }

    @Override
    protected boolean isResizable() {
        return true;
    }
}
