/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.prefs;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.EclipseIniWriter;
import ru.taximaxim.codekeeper.ui.IntegerVerifyListener;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public final class GeneralPrefPage extends FieldEditorPreferencePage
        implements IWorkbenchPreferencePage {

    private Text threadsTxt;

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

        addField(new BooleanFieldEditor(PREF.REUSE_OPEN_COMPARE_EDITOR,
                Messages.GeneralPrefPage_reuse_open_compare_editor,
                getFieldEditorParent()));

        new Label(getFieldEditorParent(), SWT.SEPARATOR | SWT.HORIZONTAL)
            .setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2, 1));

        addField(new BooleanFieldEditor(PREF.IGNORE_COLUMN_ORDER,
                Messages.GeneralPrefPage_ignore_column_order,
                getFieldEditorParent()));

        BooleanFieldEditor bodyDeps = new BooleanFieldEditor(PREF.ENABLE_BODY_DEPENDENCIES,
                Messages.GeneralPrefPage_enable_body_dependencies,
                getFieldEditorParent());
        addField(bodyDeps);
        bodyDeps.getDescriptionControl(getFieldEditorParent()).setToolTipText(
                Messages.GeneralPrefPage_body_depcy_tooltip);

        new Label(getFieldEditorParent(), SWT.SEPARATOR | SWT.HORIZONTAL)
            .setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2, 1));

        addField(new BooleanFieldEditor(PREF.NO_PRIVILEGES,
                Messages.dbUpdatePrefPage_ignore_privileges,
                getFieldEditorParent()));

        addField(new BooleanFieldEditor(PREF.SIMPLIFY_VIEW,
                Messages.GeneralPrefPage_simplify_view,
                getFieldEditorParent()));

        addField(new BooleanFieldEditor(PREF.IGNORE_CONCURRENT_MODIFICATION,
                Messages.GeneralPrefPage_ignore_concurrent_modification,
                getFieldEditorParent()));

        addField(new BooleanFieldEditor(PREF.FORMAT_OBJECT_CODE_AUTOMATICALLY,
                Messages.GeneralPrefPage_format_object_code_automatically,
                getFieldEditorParent()));

        new Label(getFieldEditorParent(), SWT.SEPARATOR | SWT.HORIZONTAL)
            .setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2, 1));

        new Label(getFieldEditorParent(), SWT.NONE)
            .setText(Messages.GeneralPrefPage_number_of_loading_threads);

        threadsTxt = new Text(getFieldEditorParent(), SWT.BORDER);
        threadsTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        threadsTxt.setText(Integer.toString(AntlrParser.getPoolSize()));
        threadsTxt.addVerifyListener(new IntegerVerifyListener());

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
                AntlrParser.cleanCacheOfAllParsers();
                System.gc();
                PgDbParser.cleanAll();
            }
        });
    }

    @Override
    public boolean performOk() {
        String newThreadVal = threadsTxt.getText();

        if (AntlrParser.getPoolSize() != Integer.parseInt(newThreadVal)) {
            var fullPropertyName = "-D" + Consts.POOL_SIZE + '='; //$NON-NLS-1$
            EclipseIniWriter.write(getShell(), fullPropertyName, newThreadVal,
                    Messages.GeneralPrefPage_number_of_thread);
        }

        return super.performOk();
    }
}
