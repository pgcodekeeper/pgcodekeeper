package ru.taximaxim.codekeeper.ui.dbstore;

import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.dialogs.PreferencesUtil;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF_PAGE;

public class DbStorePicker extends Group {

    private final boolean allowShellResize;

    private final IPreferenceStore prefStore;
    private List<DbInfo> store;
    private final ComboViewer cmbDbNames;
    private final LocalResourceManager lrm;

    private final DbStoreChangeListener dbStoreChangeListener = new DbStoreChangeListener();

    public DbStorePicker(Composite parent, int style, boolean allowShellResize,
            IPreferenceStore prefStor) {
        super(parent, style);
        setLayout(new GridLayout(2, false));

        this.allowShellResize = allowShellResize;
        this.lrm = new LocalResourceManager(JFaceResources.getResources(), this);
        this.prefStore = prefStor;

        prefStore.addPropertyChangeListener(dbStoreChangeListener);

        Composite container = new Composite(this, SWT.NONE);
        GridLayout gridLayout = new GridLayout(2, false);
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        container.setLayout(gridLayout);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        cmbDbNames = new ComboViewer(container, SWT.READ_ONLY | SWT.DROP_DOWN);
        cmbDbNames.setContentProvider(ArrayContentProvider.getInstance());
        cmbDbNames.setLabelProvider(new LabelProvider() {

            @Override
            public String getText(Object element) {
                return ((DbInfo) element).getName();
            }
        });
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = 100;
        cmbDbNames.getControl().setLayoutData(gd);
        cmbDbNames.getControl().addDisposeListener(new DisposeListener() {

            @Override
            public void widgetDisposed(DisposeEvent e) {
                prefStore.removePropertyChangeListener(dbStoreChangeListener);
            }
        });
        loadStore();

        Button btnEditStore = new Button(container, SWT.PUSH);
        btnEditStore.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(
                        FILE.ICONEDIT))));
        btnEditStore.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                PreferencesUtil.createPreferenceDialogOn(
                        getShell(), PREF_PAGE.DB_STORE, null, null).open();
                loadStore();
            }
        });
    }

    private void loadStore() {
        Object selectedItem = ((IStructuredSelection) cmbDbNames.getSelection()).getFirstElement();

        store = DbInfo.preferenceToStore(prefStore.getString(PREF.DB_STORE));
        cmbDbNames.setInput(store);
        if (selectedItem != null && store.contains(selectedItem)) {
            cmbDbNames.setSelection(new StructuredSelection(selectedItem));
        }
    }

    public DbInfo getDbInfo() {
        return (DbInfo) ((IStructuredSelection) cmbDbNames.getSelection()).getFirstElement();
    }

    public String getSelectedName() {
        Object selected = ((IStructuredSelection) cmbDbNames.getSelection()).getFirstElement();
        return selected == null ? null : ((DbInfo) selected).getName();
    }

    public void clearSelection(){
        cmbDbNames.setSelection(StructuredSelection.EMPTY);
    }

    public void addListenerToCombo(ISelectionChangedListener listener) {
        cmbDbNames.addSelectionChangedListener(listener);
    }

    @Override
    public void layout() {
        if(allowShellResize) {
            getShell().pack();
            layout(false);
        } else {
            getShell().layout(true, true);
        }
    }

    @Override
    protected void checkSubclass() {
        // allow subclassing, we just use Group as a Composite
        // ~should~ be fine
    }

    private class DbStoreChangeListener implements IPropertyChangeListener {

        @Override
        public void propertyChange(PropertyChangeEvent event) {
            if (event.getProperty().equals(PREF.DB_STORE)
                    && !event.getNewValue().equals(event.getOldValue())) {
                loadStore();
            }
        }
    }
}
