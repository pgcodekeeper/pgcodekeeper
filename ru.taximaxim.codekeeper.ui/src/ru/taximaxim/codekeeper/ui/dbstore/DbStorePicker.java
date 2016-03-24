package ru.taximaxim.codekeeper.ui.dbstore;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Path;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
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
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.dialogs.PreferencesUtil;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;

public class DbStorePicker extends Group {

    private final boolean allowShellResize;

    private final IPreferenceStore prefStore;
    private Map<String, DbInfo> store;
    private ComboViewer cmbDbNames2;
    private Combo cmbDbNames;
    private LocalResourceManager lrm;
    private boolean isLoad;
    
    private List<Path> dumpFileHistory;

    private DbStoreChangeListener dbStoreChangeListener = new DbStoreChangeListener();
    
    public DbStorePicker(Composite parent, int style, boolean allowShellResize,
            IPreferenceStore prefStor, boolean isLoad) {
        super(parent, style);
        
        this.isLoad = isLoad;
        dumpFileHistory = new LinkedList<>();
        
        setLayout(new GridLayout(2, false));

        this.allowShellResize = allowShellResize;
        this.lrm = new LocalResourceManager(JFaceResources.getResources(), this);
        this.prefStore = prefStor;
        
        dumpFileHistory.addAll(DbInfo.getDumpFileHistory(this.prefStore.getString(PREF.DB_STORE_HISTORY)));

        prefStore.addPropertyChangeListener(dbStoreChangeListener);

        Composite container = new Composite(this, SWT.NONE);
        GridLayout gridLayout = new GridLayout(2, false);
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        container.setLayout(gridLayout);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        cmbDbNames2 = new ComboViewer(container, SWT.READ_ONLY | SWT.DROP_DOWN);
        cmbDbNames = cmbDbNames2.getCombo();
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = 100;
        cmbDbNames.setLayoutData(gd);
        cmbDbNames.addDisposeListener(new DisposeListener() {

            @Override
            public void widgetDisposed(DisposeEvent e) {
                prefStore.removePropertyChangeListener(dbStoreChangeListener);
            }
        });
        
        cmbDbNames2.setContentProvider(ArrayContentProvider.getInstance());
        cmbDbNames2.setLabelProvider(new DbStoreLabelProvider());
        
        cmbDbNames2.addSelectionChangedListener(new ISelectionChangedListener() {
            
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                Object selected = cmbDbNames2.getStructuredSelection().getFirstElement();
                if ((selected instanceof String) && "Загрузить из файла...".equals((String)selected)){
                    FileDialog fDialog = new FileDialog(getShell());
                    String pathToDump = fDialog.open();
                    if (pathToDump != null){
                        if (dumpFileHistory.size() == 3) {
                            dumpFileHistory.remove(0);
                        }
                        dumpFileHistory.add(new Path(pathToDump));
                        prefStore.setValue(PREF.DB_STORE_HISTORY, DbInfo.dump2String(dumpFileHistory));
                    }
                    cmbDbNames.select(cmbDbNames.getItemCount()-1);
                }
            }
        }); 
        loadStore();

        Button btnEditStore = new Button(container, SWT.PUSH);
        btnEditStore.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(
                        FILE.ICONEDIT))));
        btnEditStore.addSelectionListener(new SelectionAdapter() {
            @SuppressWarnings("static-access")
            @Override
            public void widgetSelected(SelectionEvent e) {
                PreferenceDialog prefDialog = PreferencesUtil.createPreferenceDialogOn(getShell(),
                        UIConsts.PREF.DB_STORE_PREF_PAGE, null, null);
                if (prefDialog != null && prefDialog.open() == prefDialog.OK){
                    loadStore();
                } 
            }
        });
    }

    private void loadStore() {
        store = DbInfo.preferenceToStore(prefStore.getString(PREF.DB_STORE));
        LinkedList<Object> list = new LinkedList<>(store.values());
        if (isLoad){
            list.add("");
            list.add("Загрузить из файла...");
            list.addAll(dumpFileHistory);
        }
        cmbDbNames2.setInput(list);
    }

    public DbInfo getDbInfo() {
        Object obj = cmbDbNames2.getStructuredSelection().getFirstElement();
        if (obj instanceof DbInfo){
            return (DbInfo) obj;
        } else {
            return null;
        }
    }

    public String getSelectedName (){
        return (String)cmbDbNames2.getStructuredSelection().getFirstElement();
    }
    
    public String getPathOfFile(){
        Object path = cmbDbNames2.getStructuredSelection().getFirstElement();
        if (path instanceof Path){
            return ((Path)path).toOSString();
        } else return null;
    }

    public void clearSelection(){
        cmbDbNames2.setSelection(null);
    }

    public void addListenerToCombo(SelectionListener listener) {
        cmbDbNames.addSelectionListener(listener);
    }
    
    public void addListenerToCombo(int eventType, Listener listener){
        cmbDbNames.addListener(eventType, listener);
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
            if ((event.getProperty().equals(PREF.DB_STORE) || event.getProperty().equals(PREF.DB_STORE_HISTORY))
                    && !event.getNewValue().equals(event.getOldValue())) {
                loadStore();
            }
        }
    }
    
    private class DbStoreLabelProvider extends LabelProvider{
        @Override
        public String getText(Object element) {
            if (element instanceof DbInfo){
                return ((DbInfo)element).getName();
            }
            
            if (element instanceof Path){
                return ((Path)element).lastSegment();
            }
            return super.getText(element);
        }
    }
}
