package ru.taximaxim.codekeeper.ui.prefs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.XML_TAGS;
import ru.taximaxim.codekeeper.ui.XmlHistory;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DbUpdatePrefPage extends FieldEditorPreferencePage implements
        IWorkbenchPreferencePage {

    private PrefListEditor listEditor;
    private final XmlHistory history;
    
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
        BooleanFieldEditor usePsqlDepcy = new BooleanFieldEditor(
                DB_UPDATE_PREF.USE_PSQL_DEPCY,
                Messages.generalPrefPage_use_psql_depcy_on_generating_script,
                getFieldEditorParent());
        addField(usePsqlDepcy);

        Map<String, String> pref = new HashMap<>();
        pref.put(DB_UPDATE_PREF.DROP_TABLE_STATEMENT, Messages.dBUpdatePrefPage_drop_table);
        pref.put(DB_UPDATE_PREF.ALTER_COLUMN_STATEMENT, Messages.dBUpdatePrefPage_alter_column_statement);
        pref.put(DB_UPDATE_PREF.DROP_COLUMN_STATEMENT, Messages.dBUpdatePrefPage_drop_column_statement);
        GroupFieldsEditor gfe = new GroupFieldsEditor(pref,
                Messages.dBUpdatePrefPage_set_warning_when_next_statements_present,
                getFieldEditorParent());
        addField(gfe);
        
        BooleanFieldEditor showScriptOutputSeparately = new BooleanFieldEditor(
                DB_UPDATE_PREF.SHOW_SCRIPT_OUTPUT_SEPARATELY,
                Messages.dbUpdatePrefPage_show_script_output_in_separate_window, getFieldEditorParent());
        addField(showScriptOutputSeparately);
    }
    
    @Override
    protected Control createContents(Composite parent) {
        super.createContents(parent);
        
        Group grpCommandsEdit = new Group(parent, SWT.NONE);
        GridLayout gridLayout = new GridLayout();
        gridLayout.marginHeight = 0;
        gridLayout.marginWidth = 0;
        grpCommandsEdit.setLayout(gridLayout);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        gd.verticalIndent = 20;
        grpCommandsEdit.setLayoutData(gd);
        grpCommandsEdit.setText(Messages.dbUpdatePrefPage_add_and_delete_ddl_update_commands);
        
        listEditor = new PrefListEditor(grpCommandsEdit, false);
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
        List<String> list = new ArrayList<>();
        try {
            list = history.getHistory();
        } catch (IOException e) {
            ExceptionNotifier.notifyDefault(Messages.dbUpdatePrefPage_error_getting_commands_list, e);
        }
        
        listEditor.setInputList(list);
    }
}