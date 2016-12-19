package ru.taximaxim.codekeeper.ui.dbstore;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
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
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.dialogs.PreferencesUtil;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF_PAGE;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DbStorePicker extends Composite {

    private final static LoadFileElement LOAD_FILE = new LoadFileElement(false);
    private final static LoadFileElement LOAD_DIR = new LoadFileElement(true);
    private final static int MAX_FILES_HISTORY = 10;

    private static boolean inSync;
    private final Set<DbStorePicker> syncedPickers = Collections.newSetFromMap(
            new WeakHashMap<DbStorePicker, Boolean>());

    private final boolean useFileSources;
    private final boolean useDirSources;
    private final IPreferenceStore prefStore;
    private final List<File> projects = new ArrayList<>();

    private final LocalResourceManager lrm;
    private final ComboViewer cmbDbNames;

    public DbStorePicker(Composite parent, int style, final IPreferenceStore prefStore,
            boolean useFileSources, boolean useDirSources) {
        super(parent, style);
        this.useFileSources = useFileSources;
        this.useDirSources = useDirSources;
        this.lrm = new LocalResourceManager(JFaceResources.getResources(), this);
        this.prefStore = prefStore;

        GridLayout gl = new GridLayout(3, false);
        gl.marginWidth = gl.marginHeight = 0;
        setLayout(gl);

        new Label(this, SWT.NONE).setText(useFileSources || useDirSources ?
                Messages.DbStorePicker_db_schema_source : Messages.DbStorePicker_db_connection);

        cmbDbNames = new ComboViewer(this, SWT.READ_ONLY | SWT.DROP_DOWN);
        cmbDbNames.setContentProvider(ArrayContentProvider.getInstance());
        cmbDbNames.setLabelProvider(new DbStoreLabelProvider());
        cmbDbNames.addSelectionChangedListener(new DbStoreSelectionListener());
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = new PixelConverter(cmbDbNames.getControl()).convertWidthInCharsToPixels(26);
        cmbDbNames.getControl().setLayoutData(gd);

        Button btnEditStore = new Button(this, SWT.PUSH);
        btnEditStore.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(FILE.ICONEDIT))));
        btnEditStore.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                PreferenceDialog prefDialog = PreferencesUtil.createPreferenceDialogOn(
                        getShell(), PREF_PAGE.DB_STORE, null, null);
                if (prefDialog.open() == PreferenceDialog.OK) {
                    loadStore();
                }
            }
        });

        final DbStoreChangeListener dbStoreChangeListener = new DbStoreChangeListener();
        prefStore.addPropertyChangeListener(dbStoreChangeListener);
        cmbDbNames.getControl().addDisposeListener(new DisposeListener() {

            @Override
            public void widgetDisposed(DisposeEvent e) {
                prefStore.removePropertyChangeListener(dbStoreChangeListener);
            }
        });

        if (useDirSources) {
            // load projects in ctor for now, Workspace listener and dynamic list may be added later
            IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
            for (int i = 0; i < MAX_FILES_HISTORY && i < projects.length; ++i) {
                try {
                    if (projects[i].isOpen() && projects[i].hasNature(NATURE.ID)) {
                        this.projects.add(projects[i].getLocation().toFile());
                    }
                } catch (CoreException ex) {
                    Log.log(ex);
                }
            }
        }
        loadStore();
    }

    private void loadStore() {
        loadStore(null);
    }

    private void loadStore(ISelection newSelection) {
        ISelection selection = newSelection == null ? cmbDbNames.getSelection() : newSelection;

        List<DbInfo> store = DbInfo.preferenceToStore(prefStore.getString(PREF.DB_STORE));
        Collection<File> files;
        if (useFileSources || useDirSources) {
            files = stringToDumpFileHistory(prefStore.getString(PREF.DB_STORE_FILES));
        } else {
            files = Collections.emptyList();
        }

        List<Object> input = new ArrayList<>(store.size() + files.size() + projects.size() + 4);
        input.addAll(store);
        if (useFileSources) {
            input.add(""); //$NON-NLS-1$
            input.add(LOAD_FILE);
            for (File f : files) {
                if (f.isFile()) {
                    input.add(f);
                }
            }
        }
        if (useDirSources) {
            input.add(""); //$NON-NLS-1$
            input.add(LOAD_DIR);
            for (File f : files) {
                if (f.isDirectory()) {
                    input.add(f);
                }
            }
            input.addAll(projects);
        }
        cmbDbNames.setInput(input);
        cmbDbNames.setSelection(selection);
    }

    public DbInfo getDbInfo() {
        Object selected = ((IStructuredSelection) cmbDbNames.getSelection()).getFirstElement();
        return selected instanceof DbInfo ? (DbInfo) selected : null;
    }

    public File getPathOfFile() {
        return getPath(false);
    }

    public File getPath(boolean getDirectory) {
        Object selected = ((IStructuredSelection) cmbDbNames.getSelection()).getFirstElement();
        if (selected instanceof File) {
            File f = (File) selected;
            return f.isDirectory() == getDirectory ? f : null;
        } else {
            return null;
        }
    }

    public void setSelection(IStructuredSelection selection) {
        cmbDbNames.setSelection(selection);
    }

    public void clearSelection() {
        cmbDbNames.setSelection(StructuredSelection.EMPTY);
    }

    public void addListenerToCombo(ISelectionChangedListener listener) {
        cmbDbNames.addSelectionChangedListener(listener);
    }

    public void addSyncedPicker(DbStorePicker picker) {
        syncedPickers.add(picker);
    }

    private void syncPickers(IStructuredSelection newSelection) {
        if (inSync) {
            return;
        }
        try {
            inSync = true;
            boolean isFile = newSelection.getFirstElement() instanceof File;
            for (DbStorePicker picker : syncedPickers) {
                if (!picker.cmbDbNames.getControl().isDisposed()) {
                    if (isFile) {
                        // updates to the file list do not auto propagate
                        // force a reload
                        picker.loadStore(newSelection);
                    } else {
                        picker.setSelection(newSelection);
                    }
                }
            }
        } finally {
            inSync = false;
        }
    }

    private class DbStoreSelectionListener implements ISelectionChangedListener {

        private ISelection previous = StructuredSelection.EMPTY;

        @Override
        public void selectionChanged(SelectionChangedEvent event) {
            IStructuredSelection sel = (IStructuredSelection) cmbDbNames.getSelection();
            if (sel.isEmpty()) {
                return;
            }
            Object selected = sel.getFirstElement();

            boolean revertSelection;
            if (selected instanceof DbInfo || selected instanceof File) {
                previous = sel;
                revertSelection = false;
                syncPickers(sel);
            } else if (selected instanceof LoadFileElement) {
                LoadFileElement loadEl = (LoadFileElement) selected;
                String pathToDump = loadEl.loadDir ? getDirPath() : getFilePath();
                if (pathToDump != null) {
                    File dumpFile = new File(pathToDump);
                    Deque<File> dumpHistory = stringToDumpFileHistory(prefStore.getString(PREF.DB_STORE_FILES));
                    dumpHistory.addFirst(dumpFile);
                    while (dumpHistory.size() > MAX_FILES_HISTORY) {
                        dumpHistory.removeLast();
                    }
                    prefStore.setValue(PREF.DB_STORE_FILES, dumpFileHistoryToPreference(dumpHistory));
                    loadStore(new StructuredSelection(dumpFile));
                    prefStore.setValue(PREF.LAST_OPENED_LOCATION,
                            loadEl.loadDir ? dumpFile.getAbsolutePath() : dumpFile.getParent());
                    revertSelection = false;
                } else {
                    revertSelection = true;
                }
            } else {
                // string or some other "unselectable" selection
                revertSelection = true;
            }

            if (revertSelection) {
                cmbDbNames.setSelection(previous);
            }
        }

        private String getFilePath() {
            FileDialog dialog = new FileDialog(getShell());
            dialog.setText(Messages.choose_dump_file_with_changes);
            dialog.setFilterExtensions(new String[] {"*.sql", "*"}); //$NON-NLS-1$ //$NON-NLS-2$
            dialog.setFilterNames(new String[] {
                    Messages.DiffPresentationPane_sql_file_filter,
                    Messages.DiffPresentationPane_any_file_filter});
            dialog.setFilterPath(prefStore.getString(PREF.LAST_OPENED_LOCATION));
            return dialog.open();
        }

        private String getDirPath() {
            DirectoryDialog dialog = new DirectoryDialog(getShell());
            dialog.setText("Choose exported DB or project directory...");
            dialog.setFilterPath(prefStore.getString(PREF.LAST_OPENED_LOCATION));
            return dialog.open();
        }
    }

    private class DbStoreChangeListener implements IPropertyChangeListener {

        @Override
        public void propertyChange(PropertyChangeEvent event) {
            if (PREF.DB_STORE.equals(event.getProperty())
                    && !Objects.equals(event.getNewValue(), event.getOldValue())) {
                UiSync.exec(DbStorePicker.this, new Runnable() {

                    @Override
                    public void run() {
                        if (!isDisposed()) {
                            loadStore();
                        }
                    }
                });
            }
        }
    }

    private static class DbStoreLabelProvider extends LabelProvider {

        @Override
        public String getText(Object element) {
            if (element instanceof DbInfo){
                return ((DbInfo) element).getName();
            }

            if (element instanceof File){
                return ((File) element).getName();
            }
            return super.getText(element);
        }
    }

    private static class LoadFileElement {

        private final boolean loadDir;

        public LoadFileElement(boolean loadDir) {
            this.loadDir = loadDir;
        }

        @Override
        public String toString() {
            return loadDir ? "Load from Directory..." : Messages.DbStorePicker_load_from_file;
        }
    }

    public static Deque<File> stringToDumpFileHistory(String preference) {
        String[] coordStrings = preference.split(DbInfo.DELIM_ENTRY);
        Deque<File> paths = new LinkedList<>();
        for (String path : coordStrings){
            File f = new File(path);
            if (f.exists() && !paths.contains(f)) {
                paths.add(f);
            }
        }
        return paths;
    }

    public static String dumpFileHistoryToPreference(Collection<File> dumps) {
        StringBuilder sb = new StringBuilder();
        for (File path : dumps){
            sb.append(path.getAbsolutePath());
            sb.append(DbInfo.DELIM_ENTRY);
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
