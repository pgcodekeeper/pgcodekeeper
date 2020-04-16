package ru.taximaxim.codekeeper.ui.prefs;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
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
    protected void createFieldEditors() {

        addField(new BooleanFieldEditor(PREF.FORCE_SHOW_CONSOLE,
                Messages.generalPrefPage_show_console_when_program_write_to_console, getFieldEditorParent()));

        addField(new BooleanFieldEditor(PREF.NO_PRIVILEGES,
                Messages.dbUpdatePrefPage_ignore_privileges,
                getFieldEditorParent()));

        BooleanFieldEditor bodyDeps = new BooleanFieldEditor(PREF.ENABLE_BODY_DEPENDENCIES,
                Messages.GeneralPrefPage_enable_body_dependencies,
                getFieldEditorParent());
        addField(bodyDeps);
        bodyDeps.getDescriptionControl(getFieldEditorParent()).setToolTipText(
                Messages.GeneralPrefPage_body_depcy_tooltip);

        addField(new BooleanFieldEditor(PREF.SIMPLIFY_VIEW,
                Messages.GeneralPrefPage_simplify_view,
                getFieldEditorParent()));

        addField(new BooleanFieldEditor(PREF.REUSE_OPEN_COMPARE_EDITOR,
                Messages.GeneralPrefPage_reuse_open_compare_editor,
                getFieldEditorParent()));

        addField(new BooleanFieldEditor(PREF.IGNORE_CONCURRENT_MODIFICATION,
                Messages.GeneralPrefPage_ignore_concurrent_modification,
                getFieldEditorParent()));

        addField(new BooleanFieldEditor(PREF.HEAP_SIZE_WARNING,
                Messages.GeneralPrefPage_alert_if_heap_size_less_than_necessary,
                getFieldEditorParent()));

        addField(new IntegerFieldEditor(PREF.PARSER_CACHE_CLEANING_INTERVAL,
                Messages.GeneralPrefPage_time_to_clean_parser_cache,
                getFieldEditorParent(), 3));

        Button button = new Button(getFieldEditorParent(), SWT.PUSH);
        button.setText(Messages.GeneralPrefPage_clean_parser_cache);
        button.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                AntlrParser.cleanCacheOfBothParsers();
                System.gc();
            }
        });
    }
}
