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

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorInput;

public class PrePostScriptPrefPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    private IWorkbenchPage page;
    private static final String POST_FILE_NAME = FILE.POST_SCRIPT;
    private static final String PRE_FILE_NAME = FILE.PRE_SCRIPT;

    public PrePostScriptPrefPage() {
        super(GRID);
    }

    @Override
    public void init(IWorkbench workbench) {
        page = workbench.getActiveWorkbenchWindow().getActivePage();
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected void createFieldEditors() {
        BooleanFieldEditor addPrePostScript = new BooleanFieldEditor(
                DB_UPDATE_PREF.ADD_PRE_POST_SCRIPT,
                Messages.DbUpdatePrefPage_add_pre_post_script,
                getFieldEditorParent());
        addField(addPrePostScript);
        addPrePostScript.getDescriptionControl(getFieldEditorParent())
        .setToolTipText(Messages.PrePostScriptPrefPage_pre_post_descr);

        Composite area = new Composite(getFieldEditorParent(), SWT.NONE);
        area.setLayout(new GridLayout(2, true));

        Button btnPreScript = new Button(area, SWT.PUSH);
        btnPreScript.setText(Messages.PrePostScriptPrefPage_pre);

        btnPreScript.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                openEditor(PRE_FILE_NAME);
            }
        });

        Button btnPostScript = new Button(area, SWT.PUSH);
        btnPostScript.setText(Messages.PrePostScriptPrefPage_post);
        btnPostScript.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                openEditor(POST_FILE_NAME);
            }
        });
    }

    private void openEditor(String filename) {
        try {
            Path path = getScriptPath(filename);
            try {
                // try to create file if not exists, otherwise editor will ask where to save it
                Files.createFile(path);
            } catch (FileAlreadyExistsException ex) {
                // no op
            }
            SQLEditorInput input = new SQLEditorInput(path, DatabaseType.PG, false);
            IDE.openEditor(page, input, EDITOR.SQL);
        } catch (PartInitException | IOException ex) {
            ExceptionNotifier.notifyDefault(ex.getLocalizedMessage(), ex);
        }
    }

    public static Path getScriptPath(String fileName) {
        return Paths.get(Platform.getStateLocation(Activator.getContext().getBundle())
                .append(fileName).toString());
    }
}
