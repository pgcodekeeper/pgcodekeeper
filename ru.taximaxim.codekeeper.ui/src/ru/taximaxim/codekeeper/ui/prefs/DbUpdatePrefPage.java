package ru.taximaxim.codekeeper.ui.prefs;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF_PAGE;
import ru.taximaxim.codekeeper.ui.UIConsts.XML_TAGS;
import ru.taximaxim.codekeeper.ui.XmlHistory;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class DbUpdatePrefPage extends FieldEditorPreferencePage implements
IWorkbenchPreferencePage {

    private StringPrefListEditor listEditor;
    private final XmlHistory history;

    private Button booleanFieldEditorCheckBox;
    private Text txtCommand;

    public DbUpdatePrefPage() {
        super(GRID);
        this.history = new XmlHistory.Builder(XML_TAGS.DDL_UPDATE_COMMANDS_MAX_STORED,
                FILE.DDL_UPDATE_COMMANDS_HIST_FILENAME,
                XML_TAGS.DDL_UPDATE_COMMANDS_HIST_ROOT,
                XML_TAGS.DDL_UPDATE_COMMANDS_HIST_ELEMENT).build();
    }

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected void createFieldEditors() {

        addField( new ComboFieldEditor(DB_UPDATE_PREF.CREATE_SCRIPT_IN_PROJECT,
                Messages.dbUpdatePrefPage_create_script_project_directory, new String[][] {
            {Messages.dbUpdatePrefPage_status_alway_create, MessageDialogWithToggle.ALWAYS},
            {Messages.dbUpdatePrefPage_status_never_create, MessageDialogWithToggle.NEVER},
            {Messages.dbUpdatePrefPage_status_ask_create, MessageDialogWithToggle.PROMPT}},
                getFieldEditorParent()));

        addField( new ComboFieldEditor(DB_UPDATE_PREF.DELETE_SCRIPT_AFTER_CLOSE,
                Messages.dbUpdatePrefPage_script_deleting_status, new String[][] {
            {Messages.dbUpdatePrefPage_status_always_delete, MessageDialogWithToggle.ALWAYS},
            {Messages.dbUpdatePrefPage_status_never_delete, MessageDialogWithToggle.NEVER},
            {Messages.dbUpdatePrefPage_status_ask_delete, MessageDialogWithToggle.PROMPT}},
                getFieldEditorParent()));

        Map<String, String> pref = new HashMap<>();
        pref.put(DB_UPDATE_PREF.DROP_TABLE_STATEMENT, Messages.dBUpdatePrefPage_drop_table);
        pref.put(DB_UPDATE_PREF.ALTER_COLUMN_STATEMENT, Messages.dBUpdatePrefPage_alter_column_statement);
        pref.put(DB_UPDATE_PREF.DROP_COLUMN_STATEMENT, Messages.dBUpdatePrefPage_drop_column_statement);
        pref.put(DB_UPDATE_PREF.RESTART_WITH_STATEMENT, Messages.DbUpdatePrefPage_alter_seq_restart_statement);
        GroupFieldsEditor gfe = new GroupFieldsEditor(pref,
                Messages.dBUpdatePrefPage_set_warning_when_next_statements_present,
                getFieldEditorParent());
        addField(gfe);

        BooleanFieldEditor showScriptOutputSeparately = new BooleanFieldEditor(
                DB_UPDATE_PREF.SHOW_SCRIPT_OUTPUT_SEPARATELY,
                Messages.dbUpdatePrefPage_show_script_output_in_separate_window, getFieldEditorParent());
        addField(showScriptOutputSeparately);

        BooleanFieldEditor transaction = new BooleanFieldEditor(
                DB_UPDATE_PREF.SCRIPT_IN_TRANSACTION,
                Messages.dbUpdatePrefPage_script_add_transaction,
                getFieldEditorParent());
        addField(transaction);

        BooleanFieldEditor functionBodies = new BooleanFieldEditor(
                DB_UPDATE_PREF.CHECK_FUNCTION_BODIES,
                Messages.dbUpdatePrefPage_check_function_bodies,
                getFieldEditorParent());
        addField(functionBodies);

        BooleanFieldEditor usingOnOff = new BooleanFieldEditor(DB_UPDATE_PREF.USING_ON_OFF,
                Messages.dbUpdatePrefPage_switch_on_off_using, getFieldEditorParent());
        addField(usingOnOff);

        BooleanFieldEditor commandLineDdlUpdate = new BooleanFieldEditor(DB_UPDATE_PREF.COMMAND_LINE_DDL_UPDATE,
                Messages.dbUpdatePrefPage_use_command_for_ddl_update, getFieldEditorParent());
        addField(commandLineDdlUpdate);

        try {
            booleanFieldEditorCheckBox = getBooleanFieldEditorCheckBox(commandLineDdlUpdate);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            Log.log(Log.LOG_INFO, "An exception when getting the checkbox object from the preferences."); //$NON-NLS-1$
        }
    }

    private Button getBooleanFieldEditorCheckBox(BooleanFieldEditor booleanFieldEditor)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field f = booleanFieldEditor.getClass().getDeclaredField("checkBox");
        f.setAccessible(true);
        return (Button) f.get(booleanFieldEditor);
    }

    @Override
    protected Control createContents(Composite parent) {
        super.createContents(parent);

        createDialogArea(parent);

        Group grpCommandsEdit = new Group(parent, SWT.NONE);
        GridLayout gridLayout = new GridLayout();
        gridLayout.marginHeight = 0;
        gridLayout.marginWidth = 0;
        grpCommandsEdit.setLayout(gridLayout);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        gd.verticalIndent = 20;
        grpCommandsEdit.setLayoutData(gd);
        grpCommandsEdit.setText(Messages.dbUpdatePrefPage_add_and_delete_ddl_update_commands);

        listEditor = new StringPrefListEditor(grpCommandsEdit, false, false, PREF_PAGE.WIDTH_HINT_PX);
        updateList();

        return parent;
    }

    @Override
    protected void performDefaults() {
        super.performDefaults();
        updateList();
    }

    @Override
    public boolean performOk() {
        try {
            history.setHistory(listEditor.getList());
        } catch (IOException e) {
            ExceptionNotifier.notifyDefault(Messages.dbUpdatePrefPage_error_saving_commands_list, e);
        }

        return super.performOk();
    }

    private void updateList() {
        LinkedList<String> list = null;
        try {
            list = history.getHistory();
        } catch (IOException e) {
            ExceptionNotifier.notifyDefault(Messages.dbUpdatePrefPage_error_getting_commands_list, e);
        }
        if (list == null) {
            list = new LinkedList<>();
        }
        if (list.isEmpty()) {
            list.add(UIConsts.DDL_DEFAULT_CMD);
        }
        listEditor.setInputList(list);
    }

    protected Control createDialogArea(final Composite parent) {
        IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();

        Combo cmbScript;

        DbInfo lastDB;

        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        if(editor instanceof SQLEditor) {
            lastDB = ((SQLEditor)editor).getLastDb();
        } else if(editor instanceof ProjectEditorDiffer) {
            lastDB = (DbInfo)((ProjectEditorDiffer)editor).getLastDb();
        } else {
            lastDB = null;
        }

        GridLayout lay = new GridLayout();
        parent.setLayout(lay);

        final Composite notJdbc = new Composite(parent, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        notJdbc.setLayoutData(gd);

        GridLayout gl = new GridLayout();
        gl.marginHeight = gl.marginWidth = 0;
        notJdbc.setLayout(gl);

        Label l = new Label(notJdbc, SWT.NONE);
        l.setText(Messages.dbUpdatePrefPage_Enter_cmd_to_update_ddl_with_sql_script
                + SQLEditor.SCRIPT_PLACEHOLDER + ' '
                + SQLEditor.DB_NAME_PLACEHOLDER + ' '
                + SQLEditor.DB_HOST_PLACEHOLDER + ' ' + SQLEditor.DB_PORT_PLACEHOLDER + ' '
                + SQLEditor.DB_USER_PLACEHOLDER + ' ' + SQLEditor.DB_PASS_PLACEHOLDER + ')' + ':');
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        l.setLayoutData(gd);

        cmbScript = new Combo(notJdbc, SWT.DROP_DOWN);
        cmbScript.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        cmbScript.setToolTipText(
                SQLEditor.DB_NAME_PLACEHOLDER + '=' + SQLEditor.getReplacedString(SQLEditor.DB_NAME_PLACEHOLDER, lastDB) + UIConsts._NL +
                SQLEditor.DB_HOST_PLACEHOLDER + '=' + SQLEditor.getReplacedString(SQLEditor.DB_HOST_PLACEHOLDER, lastDB) + UIConsts._NL +
                SQLEditor.DB_PORT_PLACEHOLDER + '=' + SQLEditor.getReplacedString(SQLEditor.DB_PORT_PLACEHOLDER, lastDB) + UIConsts._NL +
                SQLEditor.DB_USER_PLACEHOLDER + '=' + SQLEditor.getReplacedString(SQLEditor.DB_NAME_PLACEHOLDER, lastDB) + UIConsts._NL +
                SQLEditor.DB_PASS_PLACEHOLDER + '=' + SQLEditor.getReplacedString(SQLEditor.DB_USER_PLACEHOLDER, lastDB));

        List<String> prev = null;
        try {
            prev = history.getHistory();
        } catch (IOException e1) {
            ExceptionNotifier.notifyDefault(Messages.dbUpdatePrefPage_error_loading_command_history, e1);
        }
        if (prev == null) {
            prev = new ArrayList<>();
        }
        if (prev.isEmpty()) {
            prev.add(UIConsts.DDL_DEFAULT_CMD);
        }
        for (String el : prev) {
            cmbScript.add(el);
        }
        cmbScript.select(0);

        cmbScript.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                txtCommand.setText(SQLEditor.getReplacedString(cmbScript.getText(), lastDB));
            }
        });

        l = new Label(notJdbc, SWT.NONE);
        l.setText(Messages.dbUpdatePrefPage_command_to_execute + SQLEditor.SCRIPT_PLACEHOLDER
                + Messages.dbUpdatePrefPage_will_be_replaced);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        l.setLayoutData(gd);

        txtCommand = new Text(notJdbc, SWT.BORDER | SWT.READ_ONLY);
        txtCommand.setText(SQLEditor.getReplacedString(cmbScript.getText(), lastDB));
        txtCommand.setBackground(parent.getShell().getDisplay()
                .getSystemColor(SWT.COLOR_LIST_BACKGROUND));
        txtCommand.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        mainPrefs.addPropertyChangeListener(new IPropertyChangeListener(){
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                if(!notJdbc.isDisposed()
                        && DB_UPDATE_PREF.COMMAND_LINE_DDL_UPDATE.equals(event.getProperty())) {
                    boolean isCmd = mainPrefs.getBoolean(DB_UPDATE_PREF.COMMAND_LINE_DDL_UPDATE);
                    notJdbc.setVisible(isCmd);
                    ((GridData)notJdbc.getLayoutData()).exclude = !isCmd;

                    mainPrefs.setValue(DB_UPDATE_PREF.MIGRATION_COMMAND_SCRIPT, cmbScript.getText());

                    parent.layout();
                }
            }
        });
        mainPrefs.firePropertyChangeEvent(DB_UPDATE_PREF.COMMAND_LINE_DDL_UPDATE,
                mainPrefs.getBoolean(DB_UPDATE_PREF.COMMAND_LINE_DDL_UPDATE),
                mainPrefs.getBoolean(DB_UPDATE_PREF.COMMAND_LINE_DDL_UPDATE));

        if(booleanFieldEditorCheckBox != null) {
            booleanFieldEditorCheckBox.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    boolean isCmd = booleanFieldEditorCheckBox.getSelection();
                    notJdbc.setVisible(isCmd);
                    ((GridData)notJdbc.getLayoutData()).exclude = !isCmd;

                    parent.layout();
                }
            });
        }

        return parent;
    }
}