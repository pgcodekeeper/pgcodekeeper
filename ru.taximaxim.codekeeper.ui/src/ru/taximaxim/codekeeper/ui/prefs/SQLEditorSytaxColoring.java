package ru.taximaxim.codekeeper.ui.prefs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerComparator;
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
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorStatementTypes;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorSyntaxModel;

public class SQLEditorSytaxColoring extends FieldEditorPreferencePage implements
IWorkbenchPreferencePage {

    private ColorFieldEditor colorFieldEditor;
    private BooleanFieldEditor boldField;
    private BooleanFieldEditor italicField;
    private BooleanFieldEditor strikethroughField;
    private BooleanFieldEditor underlineField;
    private IPreferenceStore store;
    private SQLEditorSyntaxModel sel;
    private final List<SQLEditorSyntaxModel> input = new ArrayList<>();
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

        ListViewer listIgnoredObjs = new ListViewer(composite);
        listIgnoredObjs.getList().setLayoutData(new GridData(GridData.FILL_BOTH));

        listIgnoredObjs.setContentProvider(ArrayContentProvider.getInstance());
        listIgnoredObjs.setLabelProvider(new LabelProvider());
        listIgnoredObjs.setComparator(new ViewerComparator());
        listIgnoredObjs.addSelectionChangedListener(e -> {
            sel = (SQLEditorSyntaxModel) ((StructuredSelection) e
                    .getSelection()).getFirstElement();
            if (sel != null) {
                colorFieldEditor.getColorSelector().setColorValue(sel.getColor());
                ((Button)boldField.getDescriptionControl(group)).setSelection(sel.isBold());
                ((Button)italicField.getDescriptionControl(group)).setSelection(sel.isItalic());
                ((Button)strikethroughField.getDescriptionControl(group)).setSelection(sel.isStrikethrough());
                ((Button)underlineField.getDescriptionControl(group)).setSelection(sel.isUnderline());
            }
        });

        group = new Group(composite, SWT.NONE);
        group.setLayoutData(new GridData(GridData.FILL_BOTH));
        group.setText(Messages.SQLEditorSytaxColoring_font_and_color_prefs);
        SQLEditorStatementTypes current = SQLEditorStatementTypes.FUNCTIONS;
        colorFieldEditor = new ColorFieldEditor(current.getPrefName() +
                SQLEditorSyntaxModel.PREF_COLOR, Messages.SQLEditorSytaxColoring_color, group);
        colorFieldEditor.setPreferenceStore(store);
        colorFieldEditor.getColorSelector().addListener(e -> sel.setColor((RGB)e.getNewValue()));
        addField(colorFieldEditor);

        boldField = new BooleanFieldEditor(current.getPrefName() +
                SQLEditorSyntaxModel.PREF_BOLD, Messages.SQLEditorSytaxColoring_bold, group);
        ((Button)boldField.getDescriptionControl(group)).addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                sel.setBold(((Button)e.widget).getSelection());
            }
        });
        addField(boldField);

        italicField = new BooleanFieldEditor(current.getPrefName() +
                SQLEditorSyntaxModel.PREF_ITALIC, Messages.SQLEditorSytaxColoring_italic, group);
        ((Button)italicField.getDescriptionControl(group)).addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                sel.setItalic(((Button)e.widget).getSelection());
            }
        });
        addField(italicField);
        strikethroughField = new BooleanFieldEditor(current.getPrefName() +
                SQLEditorSyntaxModel.PREF_ITALIC, Messages.SQLEditorSytaxColoring_strikethrough, group);
        ((Button)strikethroughField.getDescriptionControl(group)).addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                sel.setStrikethrough(((Button)e.widget).getSelection());
            }
        });
        addField(strikethroughField);
        underlineField = new BooleanFieldEditor(current.getPrefName() +
                SQLEditorSyntaxModel.PREF_UNDERLINE, Messages.SQLEditorSytaxColoring_underline, group);
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
        listIgnoredObjs.setSelection(new StructuredSelection(current));

        return composite;
    }

    @Override
    protected void createFieldEditors() {
        // no imp
    }

    @Override
    protected void performDefaults() {
        for (SQLEditorSyntaxModel element : input) {
            element.loadDefault();
        }
    }

    @Override
    public boolean performOk() {
        for (SQLEditorSyntaxModel element : input) {
            element.store();
        }
        return true;
    }
}
