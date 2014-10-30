package ru.taximaxim.codekeeper.ui.prefs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorStatementTypes;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorSyntaxModel;

public class SQLEditorSytaxColoring extends FieldEditorPreferencePage implements
        IWorkbenchPreferencePage {

    private ListViewer listIgnoredObjs;
    private ColorFieldEditor colorFieldEditor;
    private BooleanFieldEditor boldField;
    private BooleanFieldEditor italicField;
    private BooleanFieldEditor strikethroughField;
    private BooleanFieldEditor underlineField;
    private IPreferenceStore store;
    private SQLEditorSyntaxModel sel;
    private List<SQLEditorSyntaxModel> input = new ArrayList<>();
    private Group group;

    public SQLEditorSytaxColoring() {
        super(GRID);
    }

    @Override
    public void init(IWorkbench workbench) {
        store = Activator.getDefault().getPreferenceStore();
        setPreferenceStore(store);
    }

    @Override
    protected Control createContents(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        GridLayout gridLayout = new GridLayout(2, false);
        gridLayout.marginHeight = 0;
        gridLayout.marginWidth = 0;
        composite.setLayout(gridLayout);
        composite.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        listIgnoredObjs = new ListViewer(composite);
        listIgnoredObjs.getList().setLayoutData(new GridData(GridData.FILL_BOTH));

        listIgnoredObjs.setContentProvider(new ArrayContentProvider());
        listIgnoredObjs.setLabelProvider(new LabelProvider());
        listIgnoredObjs.setSorter(new ViewerSorter());
        listIgnoredObjs.addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                sel = (SQLEditorSyntaxModel) ((StructuredSelection) event
                                .getSelection()).getFirstElement();
                if (sel == null) {
                    return;
                }
                colorFieldEditor.getColorSelector().setColorValue(sel.getColor());
                ((Button)boldField.getDescriptionControl(group)).setSelection(sel.isBold());
                ((Button)italicField.getDescriptionControl(group)).setSelection(sel.isItalic());
                ((Button)strikethroughField.getDescriptionControl(group)).setSelection(sel.isStrikethrough());
                ((Button)underlineField.getDescriptionControl(group)).setSelection(sel.isUnderline());
            }
            
        });
        
        group = new Group(composite, SWT.NONE);
        group.setLayoutData(new GridData(GridData.FILL_BOTH));
        group.setText("Font and color preference");
        SQLEditorStatementTypes first = SQLEditorStatementTypes.CONSTANTS;
        colorFieldEditor = new ColorFieldEditor(first.getPrefName() + ".Color", "Color:", group);
        colorFieldEditor.setPreferenceStore(store);
        colorFieldEditor.getColorSelector().addListener(new IPropertyChangeListener() {
            
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                sel.setColor((RGB)event.getNewValue());
            }
        });
        addField(colorFieldEditor);
        
        boldField = new BooleanFieldEditor(first.getPrefName() + ".Bold", "Bold:", group);
        ((Button)boldField.getDescriptionControl(group)).addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                sel.setBold(((Button)e.widget).getSelection());
            }
        });
        addField(boldField);
        
        italicField = new BooleanFieldEditor(first.getPrefName() + ".Italic", "Italic", group);
        ((Button)italicField.getDescriptionControl(group)).addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                sel.setItalic(((Button)e.widget).getSelection());
            }
        });
        addField(italicField);
        strikethroughField = new BooleanFieldEditor(first.getPrefName() + ".strikethrough", "Strikethrough", group);
        ((Button)strikethroughField.getDescriptionControl(group)).addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                sel.setStrikethrough(((Button)e.widget).getSelection());
            }
        });
        addField(strikethroughField);
        underlineField = new BooleanFieldEditor(first.getPrefName() + ".underline", "Underline", group);
        ((Button)underlineField.getDescriptionControl(group)).addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                sel.setUnderline(((Button)e.widget).getSelection());
            }
        });
        addField(underlineField);
        
        for (SQLEditorStatementTypes type : SQLEditorStatementTypes.values()) {
            input.add(new SQLEditorSyntaxModel(type, store).load());
        }
        listIgnoredObjs.setInput(input);
        listIgnoredObjs.setSelection(new StructuredSelection(first));
        
        return composite;
    }

    @Override
    protected void createFieldEditors() {
    }
    
    @Override
    public boolean performOk() {
        for (SQLEditorSyntaxModel element : input) {
            element.store();
        }
        return true;
    }
}
