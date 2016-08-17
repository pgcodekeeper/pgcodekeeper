package ru.taximaxim.codekeeper.ui.dbstore;

import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.dialogs.PreferencesUtil;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;

public class DbStorePicker extends Group {

    private final boolean allowShellResize;

    private final IPreferenceStore prefStore;
    private Map<String, DbInfo> store;
    private Combo cmbDbNames;
    private LocalResourceManager lrm;
    private DbInfo dbinfo;

    private DbStoreChangeListener dbStoreChangeListener = new DbStoreChangeListener();

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

        cmbDbNames = new Combo(container, SWT.READ_ONLY | SWT.DROP_DOWN);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = 100;
        cmbDbNames.setLayoutData(gd);
        cmbDbNames.addDisposeListener(new DisposeListener() {

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
                PreferenceDialog pref = PreferencesUtil.createPreferenceDialogOn(getShell(),
                        "ru.taximaxim.codekeeper.ui.dbstore", null, null);
                if (pref != null){
                    pref.open();
                }
                loadStore();
            }
        });
    }

    private void loadStore() {
        store = DbInfo.preferenceToStore(prefStore.getString(PREF.DB_STORE));

        String selectedItem = null;
        if (cmbDbNames.getSelectionIndex() > 0) {
            selectedItem = cmbDbNames.getText();
        }
        cmbDbNames.setItems(store.keySet().toArray(new String[store.size()]));
        if(cmbDbNames.getItemCount() > 0) {
            cmbDbNames.select(selectedItem == null ? -1 : cmbDbNames.indexOf(selectedItem));
            cmbDbNames.notifyListeners(SWT.Selection, new Event());
        }
    }

    public DbInfo getDbInfo() {
        String selectedName = cmbDbNames.getText();

        if(!selectedName.isEmpty()) {
            dbinfo = store.get(selectedName);
        }
        return dbinfo;
    }

    public String getSelectedName (){
        return cmbDbNames.getText();
    }

    public void clearSelection(){
        cmbDbNames.deselectAll();
    }

    public void addListenerToCombo(SelectionListener listener) {
        cmbDbNames.addSelectionListener(listener);
    }

    public void removeListenerToCombo(SelectionListener listener) {
        cmbDbNames.removeSelectionListener(listener);
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
