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
package ru.taximaxim.codekeeper.ui.prefs;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * Предназначен для управления группой булевских настроек с управляющим чекбоксом
 */
class GroupFieldsEditor extends FieldEditor {

    private final Map<String, String> prefNames = new HashMap<>();
    private final Map<String, Button> buttons = new HashMap<>();
    private final String groupName;

    private Button btnManage;

    public GroupFieldsEditor(Map<String, String> prefWithLables,
            String groupName, Composite parent) {
        for (Entry<String, String> entry : prefWithLables.entrySet()) {
            prefNames.put(entry.getKey(), entry.getValue());
        }
        this.groupName = groupName;
        createControl(parent);
    }

    @Override
    protected void adjustForNumColumns(int numColumns) {
        ((GridData) btnManage.getLayoutData()).horizontalSpan = numColumns;
    }

    @Override
    protected void doFillIntoGrid(Composite parent, int numColumns) {
        btnManage = new Button(parent, SWT.CHECK | SWT.LEFT);
        btnManage.setText(groupName);
        GridData gd = new GridData();
        gd.horizontalSpan = numColumns;
        btnManage.setLayoutData(gd);
        btnManage.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                boolean state = ((Button)e.widget).getSelection();
                for (Button button : buttons.values()) {
                    button.setSelection(state);
                }
            }
        });
        for (Entry<String, String> entry : prefNames.entrySet()) {
            Button btn = new Button(parent, SWT.CHECK | SWT.LEFT);
            btn.setText(entry.getValue());
            gd = new GridData();
            gd.horizontalIndent = 10;
            gd.horizontalSpan = numColumns;
            btn.setLayoutData(gd);
            btn.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    setManageButtonSelection();
                }
            });
            buttons.put(entry.getKey(), btn);
        }
    }

    @Override
    protected void doLoad() {
        for (Entry<String, Button> entry : buttons.entrySet()) {
            boolean selection = getPreferenceStore().getBoolean(entry.getKey());
            entry.getValue().setSelection(selection);
            setManageButtonSelection();
        }
    }

    @Override
    protected void doLoadDefault() {
        for (Entry<String, Button> entry : buttons.entrySet()) {
            boolean selection = getPreferenceStore().getDefaultBoolean(entry.getKey());
            entry.getValue().setSelection(selection);
            setManageButtonSelection();
        }
    }
    /**
     * Устанавливает статус управляющего чекбокса в зависимости от выбора элементов
     */
    private void setManageButtonSelection() {
        boolean existChecked = false;
        boolean allChecked = buttons.size() > 0;

        for (Entry<String, Button> entry : buttons.entrySet()) {
            if (entry.getValue().getSelection()){
                existChecked = true;
            } else {
                allChecked = false;
            }
        }

        btnManage.setSelection(existChecked);
        btnManage.setGrayed(!allChecked && existChecked);
    }

    @Override
    protected void doStore() {
        for (Entry<String, Button> entry : buttons.entrySet()) {
            getPreferenceStore().setValue(entry.getKey(), entry.getValue().getSelection());
        }
    }

    @Override
    public int getNumberOfControls() {
        return prefNames.size() + 1;
    }
}
