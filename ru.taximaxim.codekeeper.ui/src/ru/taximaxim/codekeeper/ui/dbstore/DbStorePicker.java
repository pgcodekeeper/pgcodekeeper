package ru.taximaxim.codekeeper.ui.dbstore;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
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
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.dialogs.PreferencesUtil;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DbStorePicker extends Composite {

    private final boolean allowShellResize;

    private final IPreferenceStore prefStore;
    private Map<String, DbInfo> store;
    private ComboViewer cmbVwrDbNames;
    private Combo cmbDbNames;
    private LocalResourceManager lrm;
    private boolean isLoad;
    
    private List<Path> dumpFileHistory;
    private List<IProject> pgCodeKeeperProjectlist;

    private DbStoreChangeListener dbStoreChangeListener = new DbStoreChangeListener();
    
    /**
     * @param parent
     * @param style
     * @param allowShellResize
     * @param prefStor
     * @param isLoad if true then through the combobox there is a choice file_dump
     */
    public DbStorePicker(Composite parent, int style, boolean allowShellResize,
            IPreferenceStore prefStor, boolean isLoad){
        this(parent, style, allowShellResize, prefStor, isLoad, "");
    }
    
    /**
     * @param parent
     * @param style
     * @param allowShellResize
     * @param prefStor
     * @param isLoad if true then through the combobox there is a choice file_dump
     * @param label
     */
    public DbStorePicker(Composite parent, int style, boolean allowShellResize,
            IPreferenceStore prefStor, boolean isLoad, String label) {
        super(parent, style);
        this.isLoad = isLoad;
        dumpFileHistory = new LinkedList<>();
        
        setLayout(new GridLayout(2, false));

        this.allowShellResize = allowShellResize;
        this.lrm = new LocalResourceManager(JFaceResources.getResources(), this);
        this.prefStore = prefStor;
        
        dumpFileHistory.addAll(DbInfo.getDumpFileHistory(this.prefStore.getString(PREF.DB_STORE_HISTORY)));
        
        pgCodeKeeperProjectlist = new LinkedList<>();
        if (isLoad){
            for (IProject proj : ResourcesPlugin.getWorkspace().getRoot().getProjects()){
                try {
                    if (proj.isOpen() && proj.hasNature(NATURE.ID)){
                        pgCodeKeeperProjectlist.add(proj);
                    }
                } catch (CoreException e1) {
                    Log.log(Log.LOG_ERROR, e1.getLocalizedMessage());
                }
            }
        }

        prefStore.addPropertyChangeListener(dbStoreChangeListener);

        Composite container = new Composite(this, SWT.NONE);
        GridLayout gridLayout = new GridLayout(2, false);
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        container.setLayout(gridLayout);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        cmbVwrDbNames = new ComboViewer(container, SWT.READ_ONLY | SWT.DROP_DOWN);
        cmbDbNames = cmbVwrDbNames.getCombo();
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = 100;
        cmbDbNames.setLayoutData(gd);
        cmbDbNames.addDisposeListener(new DisposeListener() {

            @Override
            public void widgetDisposed(DisposeEvent e) {
                prefStore.removePropertyChangeListener(dbStoreChangeListener);
            }
        });
        
        cmbVwrDbNames.setContentProvider(ArrayContentProvider.getInstance());
        cmbVwrDbNames.setLabelProvider(new DbStoreLabelProvider());
        
        cmbVwrDbNames.addSelectionChangedListener(new ISelectionChangedListener() {
            
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                Object selected = cmbVwrDbNames.getStructuredSelection().getFirstElement();
                if (selected instanceof String){
                    String path =  Messages.load_from_file.equals((String)selected) ? 
                            new FileDialog(getShell()).open() :
                                new DirectoryDialog(getShell()).open();
                    if (path != null){
                        if (dumpFileHistory.size() == 3) {
                            dumpFileHistory.remove(0);
                        }
                        dumpFileHistory.add(new Path(path));
                        prefStore.setValue(PREF.DB_STORE_HISTORY, DbInfo.dump2String(dumpFileHistory));
                        cmbDbNames.select(cmbDbNames.indexOf(new File(path).getName()));
                    } else {
                        cmbDbNames.select(cmbDbNames.indexOf(""));
                    }
                }
                try {
                    ((IPersistentPreferenceStore) prefStore).save();
                } catch (IOException e) {
                    Log.log(Log.LOG_WARNING, e.getLocalizedMessage());
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
        LinkedList<Object> list = new LinkedList<Object>(); 
        list.addAll(store.values());
        if (isLoad){
            list.add("");
            list.add(Messages.load_from_file);
            list.addAll(DbInfo.getDumpFileHistory(this.prefStore.getString(PREF.DB_STORE_HISTORY)));
            list.add("");
            list.add(Messages.load_from_directory);
            if (pgCodeKeeperProjectlist != null)
            list.addAll(pgCodeKeeperProjectlist);
        }
        cmbVwrDbNames.setInput(list);
    }

    public DbInfo getDbInfo() {
        Object obj = cmbVwrDbNames.getStructuredSelection().getFirstElement();
        if (obj instanceof DbInfo){
            return (DbInfo) obj;
        } else {
            return null;
        }
    }
    
    public int getSelectionIndex(){
        return cmbDbNames.getSelectionIndex();
    }
    
    public void select(int index){
        cmbDbNames.select(index);
    }
    
    //TODO добавить селект в который будет передаваться объект и определяться айтем
    public void select(String name){
        cmbDbNames.select(cmbDbNames.indexOf(name));
    }

    public String getSelectedName (){
        return (String)cmbVwrDbNames.getStructuredSelection().getFirstElement();
    }
    
    public String getPathOfFile(){
        Object path = cmbVwrDbNames.getStructuredSelection().getFirstElement();
        if (path instanceof Path && new File(((Path)path).toOSString()).isFile()){
            return ((Path)path).toOSString();
        } else return null;
    }
    
    public String getPathOfProject(){
        Object path = cmbVwrDbNames.getStructuredSelection().getFirstElement();
        if (path instanceof IProject){
            return ((IProject)path).getLocation().toOSString();
        } else if (path instanceof Path && new File(((Path)path).toOSString()).isDirectory()){
            return ((Path)path).toOSString();
        } else return null;
    }
    
    public String getInfo(){
        Object obj = cmbVwrDbNames.getStructuredSelection().getFirstElement();
        if (obj instanceof IProject){
            return ((IProject)obj).getLocation().toOSString();
        } else if (obj instanceof Path){
            return ((Path)obj).toOSString();
        } else if (obj instanceof DbInfo){
            DbInfo dbInfo = (DbInfo) obj;
            StringBuffer sb = new StringBuffer();
            sb.append(dbInfo.getDbhost())
                .append(":")
                .append(dbInfo.getDbport())
                .append(":")
                .append(dbInfo.getDbname());
            return sb.toString();
        } else {
            return "";
        }
    }

    public void clearSelection(){
        cmbVwrDbNames.setSelection(null);
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
    
    //TODO доделать!!!!
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DbStorePicker)){
            return false;
        }
        return true;
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
            if (element instanceof IProject){
                return ((IProject)element).getName();
            }
            return super.getText(element);
        }
    }
}
