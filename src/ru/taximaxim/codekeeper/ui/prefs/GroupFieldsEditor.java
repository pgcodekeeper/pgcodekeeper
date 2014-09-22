package ru.taximaxim.codekeeper.ui.prefs;

import java.util.HashMap;
import java.util.Map;

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

    private Map<String, String> prefNames = new HashMap<>();
    private Map<String, Button> buttons = new HashMap<>();
    private String groupName;
    
    private Button btnManage;

    public GroupFieldsEditor(Map<String, String> prefWithLables, String groupName, Composite parent) {
        for (String name : prefWithLables.keySet()) {
            prefNames.put(name, prefWithLables.get(name));
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
                for (String key : buttons.keySet()) {
                    buttons.get(key).setSelection(state);
                }
            }
        });
        for (String name : prefNames.keySet()) {
            Button btn = new Button(parent, SWT.CHECK | SWT.LEFT);
            btn.setText(prefNames.get(name));
            gd = new GridData();
            gd.horizontalIndent = 5;
            gd.horizontalSpan = numColumns;
            btn.setLayoutData(gd);
            btn.addSelectionListener(new SelectionAdapter() {
                
                @Override
                public void widgetSelected(SelectionEvent e) {
                    setManageButtonSelection(((Button)e.widget).getSelection());
                }
            });
            buttons.put(name, btn);
        }
    }

    @Override
    protected void doLoad() {
        for (String name : buttons.keySet()) {
            boolean selection = getPreferenceStore().getBoolean(name);
            buttons.get(name).setSelection(selection);
            setManageButtonSelection(selection);
        }
    }

    @Override
    protected void doLoadDefault() {
        for (String name : buttons.keySet()) {
            boolean selection = getPreferenceStore().getDefaultBoolean(name);
            buttons.get(name).setSelection(selection);
            setManageButtonSelection(selection);
        }
    }
    /**
     * Устанавливает статус управляющего чекбокса в зависимости от выбора элементов
     */
    private void setManageButtonSelection(boolean state) {
        boolean existChecked = false;
        boolean allChecked = buttons.size() > 0;
        
        for (String name : buttons.keySet()) {
            if (buttons.get(name).getSelection()){
                existChecked |= true;
            } else {
                allChecked &= false;
            }
        }
        btnManage.setSelection(existChecked);
        if (allChecked) {
            btnManage.setGrayed(false);
        } else {
            btnManage.setGrayed(existChecked);
        }
    }

    @Override
    protected void doStore() {
        for (String name : buttons.keySet()) { 
            getPreferenceStore().setValue(name, buttons.get(name).getSelection());
        }
    }

    @Override
    public int getNumberOfControls() {
        return prefNames.size() + 1;
    }
}
