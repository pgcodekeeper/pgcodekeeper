package ru.taximaxim.codekeeper.ui.prefs;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

import javax.xml.transform.TransformerException;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.xml.sax.SAXException;

import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.XmlStringList;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class IgnoredObjectsPrefPage extends FieldEditorPreferencePage
        implements IWorkbenchPreferencePage {

    public final static String IGNORED_OBJS_TAG = "ignored_objects"; //$NON-NLS-1$
    public final static String IGNORED_OBJS_ELEMENT = "obj"; //$NON-NLS-1$
    
    private String preference;
    private ListViewer listIgnoredObjs;
    private Text txtNewValue;
    private List<String> ignoredObjects = new LinkedList<>();
    
    public IgnoredObjectsPrefPage() {
        super(GRID);
    }
    
    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(UIScopedPreferenceStore.get());
    }
    
    private void updateList() {
        preference = getPreferenceStore().getString(PREF.IGNORE_OBJECTS);

        if (!preference.isEmpty()) {
            XmlStringList xml = new XmlStringList(IGNORED_OBJS_TAG, IGNORED_OBJS_ELEMENT);
            try {
                ignoredObjects = xml.deserializeList(new StringReader(preference));
            } catch (IOException | SAXException ex) {
                throw new IllegalStateException(ex);
            }
        } else {
            ignoredObjects.clear();
        }

        listIgnoredObjs.setInput(ignoredObjects);
        listIgnoredObjs.refresh();
    }

    @Override
    protected void createFieldEditors() {
        updateList();
    }

    @Override
    protected Control createContents(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        GridLayout gridLayout = new GridLayout(2, false);
        gridLayout.marginHeight = 0;
        gridLayout.marginWidth = 0;
        composite.setLayout(gridLayout);
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        
        Label l = new Label(composite, SWT.NONE);
        l.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2, 1));
        l.setText(Messages.IgnoredObjectsPrefPage_these_objects_are_ignored_info);
        
        txtNewValue = new Text(composite, SWT.BORDER);
        txtNewValue.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        Button btnAdd = new Button(composite, SWT.PUSH);
        btnAdd.setText(Messages.ignoreObjectsPrefPage_add_ignore);
        btnAdd.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                String newValue = txtNewValue.getText().trim();
                if (!newValue.isEmpty() && !ignoredObjects.contains(newValue)) {
                    ignoredObjects.add(newValue);
                    txtNewValue.setText(""); //$NON-NLS-1$
                    listIgnoredObjs.refresh();
                }
            }
        });
        
        listIgnoredObjs = new ListViewer(composite);
        listIgnoredObjs.getList().setLayoutData(
                new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

        listIgnoredObjs.setContentProvider(new ArrayContentProvider());
        listIgnoredObjs.setLabelProvider(new LabelProvider());
        listIgnoredObjs.setSorter(new ViewerSorter());

        Button btnRemove = new Button(composite, SWT.PUSH);
        btnRemove.setLayoutData(new GridData(SWT.DEFAULT, SWT.DEFAULT, false, false, 2, 1));
        btnRemove.setText(Messages.ignoreObjectsPrefPage_delete_ignore);
        btnRemove.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                IStructuredSelection selection = (IStructuredSelection) listIgnoredObjs
                        .getSelection();
                String ignoreObj = (String) selection.getFirstElement();
                if (ignoreObj == null) {
                    return;
                }

                ignoredObjects.remove(ignoreObj);
                listIgnoredObjs.refresh();
            }
        });
        
        createFieldEditors();
        
        return composite;
    }

    @Override
    protected void performDefaults() {
        super.performDefaults();
        updateList();
    }

    @Override
    public boolean performOk() {
        if (getPreferenceStore() != null) {
            StringWriter sw = new StringWriter();
            XmlStringList xml = new XmlStringList(IGNORED_OBJS_TAG, IGNORED_OBJS_ELEMENT);
            try {
                xml.serializeList(ignoredObjects, true, sw);
            } catch (TransformerException ex) {
                throw new IllegalStateException(ex);
            }
            preference = sw.toString();
            getPreferenceStore().setValue(
                    PREF.IGNORE_OBJECTS, preference);
        }
        return true;
    }
}