package ru.taximaxim.codekeeper.ui.prefs;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class GeneralPrefPage extends FieldEditorPreferencePage
implements IWorkbenchPreferencePage  {

    public GeneralPrefPage() {
        super(GRID);
    }

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
    }

    @Override
    protected void createFieldEditors() {
        addField(new BooleanFieldEditor(PREF.PGDUMP_SWITCH,
                Messages.generalPrefPage_pg_dump_switch, getFieldEditorParent()));

        addField(new FileFieldEditor(PREF.PGDUMP_EXE_PATH,
                Messages.generalPrefPage_pg_dump_executable, getFieldEditorParent()){

            @Override
            protected boolean checkState() {
                return true;
            }
        });

        addField(new StringFieldEditor(PREF.PGDUMP_CUSTOM_PARAMS,
                Messages.generalPrefPage_pg_dump_custom_parameters, getFieldEditorParent()));

        addField(new BooleanFieldEditor(PREF.FORCE_SHOW_CONSOLE,
                Messages.generalPrefPage_show_console_when_program_write_to_console, getFieldEditorParent()));

        addField(new BooleanFieldEditor(PREF.NO_PRIVILEGES,
                Messages.dbUpdatePrefPage_ignore_privileges,
                getFieldEditorParent()));

    }
}