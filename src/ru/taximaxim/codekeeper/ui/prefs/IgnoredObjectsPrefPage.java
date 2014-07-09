package ru.taximaxim.codekeeper.ui.prefs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.XMLStringBuild;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * @author botov_av
 * Generate ignore objects preference page
 */
public class IgnoredObjectsPrefPage extends FieldEditorPreferencePage implements
        IWorkbenchPreferencePage {
    public IgnoredObjectsPrefPage() {
    }

    private String preference;
    private ListViewer listIgnoredObjs;
    private Text addingValue;
    private List<String> ignoredObjects = new ArrayList<String>();

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(UIScopedPreferenceStore.get());
    }

    @Override
    protected void createFieldEditors() {
        preference = getPreferenceStore().getString(
                UIConsts.PREF_IGNORE_OBJECTS);

        if (!preference.isEmpty()) {
            ignoredObjects = XMLStringBuild.getListFromXMLString(preference);
            listIgnoredObjs.refresh(false);
        }
    }

    @Override
    protected Control createContents(Composite parent) {

        Composite composite = new Composite(parent, SWT.NONE);
        GridLayout gridLayout = new GridLayout(2, false);
        gridLayout.marginHeight = 0;
        gridLayout.marginWidth = 0;
        composite.setLayout(gridLayout);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.grabExcessVerticalSpace = true;
        composite.setLayoutData(gd);
        
        addingValue = new Text(composite, SWT.BORDER);
        addingValue.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        Button btnAddIgnore = new Button(composite, SWT.PUSH);
        btnAddIgnore.setText(Messages.ignoreObjectsPrefPage_add_ignore);
        btnAddIgnore.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                String newValue = addingValue.getText().trim();
                if (!newValue.isEmpty()) {
                    if (!ignoredObjects.contains(newValue)) {
                        ignoredObjects.add(newValue);
                        addingValue.setText(""); //$NON-NLS-1$
                        listIgnoredObjs.refresh(false);
                    }
                }
            }
        });
        
        listIgnoredObjs = new ListViewer(composite);
        gd = new GridData(GridData.FILL_BOTH);
        gd.horizontalSpan = 2;
        listIgnoredObjs.getList().setLayoutData(gd);
        
        initIgnoreList();

        Button btnDelIgnore = new Button(composite, SWT.PUSH);
        btnDelIgnore.setText(Messages.ignoreObjectsPrefPage_delete_ignore);
        new Label(composite, SWT.NONE);
        btnDelIgnore.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                IStructuredSelection selection = (IStructuredSelection) listIgnoredObjs
                        .getSelection();
                String ignoreObj = (String) selection.getFirstElement();
                if (ignoreObj == null) {
                    return;
                }

                ignoredObjects.remove(ignoreObj);
                listIgnoredObjs.refresh(false);
            }
        });
        
        createFieldEditors();
        
        return composite;
    }

    @Override
    protected void performDefaults() {
        ignoredObjects.clear();
        listIgnoredObjs.refresh(false);
    }

    @Override
    public boolean performOk() {
        preference = XMLStringBuild.getXMLStringFromList(ignoredObjects);
        if (getPreferenceStore() != null) {
            getPreferenceStore().setValue(UIConsts.PREF_IGNORE_OBJECTS,
                    preference);
        }
        return true;
    }

    private void initIgnoreList() {
        listIgnoredObjs.setContentProvider(new IStructuredContentProvider() {
            public Object[] getElements(Object inputElement) {
                return ignoredObjects.toArray();
            }

            @Override
            public void dispose() {
                // do nothing
            }

            @Override
            public void inputChanged(Viewer viewer, Object oldInput,
                    Object newInput) {
                // do nothing
            }
        });

        listIgnoredObjs.setLabelProvider(new ILabelProvider() {

            @Override
            public void addListener(ILabelProviderListener listener) {
                // do nothing
            }

            @Override
            public void dispose() {
                // do nothing
            }

            @Override
            public boolean isLabelProperty(Object element, String property) {
                return false;
            }

            @Override
            public void removeListener(ILabelProviderListener listener) {
                // do nothing
            }

            @Override
            public Image getImage(Object element) {
                return null;
            }

            @Override
            public String getText(Object element) {
                return (String) element;
            }
        });

        listIgnoredObjs.setSorter(new ViewerSorter() {
            public int compare(Viewer viewer, Object e1, Object e2) {
                return ((String) e1).compareTo((String) e2);
            }

        });

        listIgnoredObjs.setInput(ignoredObjects);
    }
}