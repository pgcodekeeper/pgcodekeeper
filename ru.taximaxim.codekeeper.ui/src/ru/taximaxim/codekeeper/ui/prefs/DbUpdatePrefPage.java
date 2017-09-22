package ru.taximaxim.codekeeper.ui.prefs;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.XML_TAGS;
import ru.taximaxim.codekeeper.ui.XmlHistory;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class DbUpdatePrefPage extends FieldEditorPreferencePage implements
IWorkbenchPreferencePage {

    private final XmlHistory history;

    private Combo cmbScript;

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
    }

    @Override
    protected Control createContents(Composite parent) {
        Composite parentComposite = (Composite)super.createContents(parent);

        final Composite notJdbc = new Composite(parentComposite, SWT.NONE);
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

        cmbScript.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Combo combo = (Combo)e.getSource();
                String selected = combo.getText();
                combo.remove(combo.getSelectionIndex());
                combo.add(selected, 0);
                combo.select(0);
            }
        });

        LinkedList<String> list = null;
        try {
            list = history.getHistory();
        } catch (IOException e1) {
            ExceptionNotifier.notifyDefault(Messages.dbUpdatePrefPage_error_loading_command_history, e1);
        }
        if (list == null) {
            list = new LinkedList<>();
        }
        if (list.isEmpty()) {
            list.add(UIConsts.DDL_DEFAULT_CMD);
        }
        for (String el : list) {
            cmbScript.add(el);
        }
        cmbScript.select(0);

        return parentComposite;
    }

    @Override
    public boolean performOk() {
        try {
            String[] allItems = cmbScript.getItems();
            String currentSelectedText = cmbScript.getText();

            if(Arrays.stream(allItems).noneMatch(currentSelectedText::equals)) {
                cmbScript.add(currentSelectedText, 0);
            }

            history.setHistory(Arrays.asList(allItems));

            Activator.getDefault().getPreferenceStore().setValue(DB_UPDATE_PREF.MIGRATION_COMMAND_SCRIPT, currentSelectedText);

        } catch (IOException e) {
            ExceptionNotifier.notifyDefault(Messages.dbUpdatePrefPage_error_saving_commands_list, e);
        }

        return super.performOk();
    }
}