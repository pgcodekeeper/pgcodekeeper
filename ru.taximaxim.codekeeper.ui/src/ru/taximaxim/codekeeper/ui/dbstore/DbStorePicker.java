package ru.taximaxim.codekeeper.ui.dbstore;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.xmlstore.DbXmlStore;

public class DbStorePicker {

    private static final int DEFAULT_LENGTH = 26;

    private static final String DELIM_ENTRY = "\n"; //$NON-NLS-1$

    private static final LoadFileElement LOAD_FILE = new LoadFileElement(false);
    private static final LoadFileElement LOAD_DIR = new LoadFileElement(true);
    private static final int MAX_FILES_HISTORY = 10;

    private boolean useFileSources;
    private Boolean isMsSql;
    private final boolean useDirSources;
    private final IPreferenceStore prefStore = Activator.getDefault().getPreferenceStore();
    private final List<File> projects = new ArrayList<>();

    private final ComboViewer cmbDbNames;

    public DbStorePicker(Composite parent, boolean useFileSources, boolean useDirSources) {
        this(parent, DEFAULT_LENGTH, useFileSources, useDirSources);
    }

    public DbStorePicker(Composite parent, int chars, boolean useFileSources, boolean useDirSources) {
        this.useFileSources = useFileSources;
        this.useDirSources = useDirSources;

        cmbDbNames = new ComboViewer(parent, SWT.READ_ONLY | SWT.DROP_DOWN);
        cmbDbNames.setContentProvider(ArrayContentProvider.getInstance());
        cmbDbNames.setLabelProvider(new DbStoreLabelProvider());
        cmbDbNames.addSelectionChangedListener(new DbStoreSelectionListener());
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = new PixelConverter(cmbDbNames.getControl()).convertWidthInCharsToPixels(chars);
        cmbDbNames.getControl().setLayoutData(gd);

        final IPropertyChangeListener listener = e -> UiSync.exec(parent, () -> {
            if (!parent.isDisposed()) {
                loadStore(null);
            }
        });

        DbXmlStore.INSTANCE.addListener(listener);
        cmbDbNames.getControl().addDisposeListener(e -> DbXmlStore.INSTANCE.deleteListener(listener));

        if (useDirSources) {
            // load projects in ctor for now, Workspace listener and dynamic list may be added later
            IProject[] projs = ResourcesPlugin.getWorkspace().getRoot().getProjects();
            for (int i = 0; i < MAX_FILES_HISTORY && i < projs.length; ++i) {
                try {
                    if (projs[i].isOpen() && projs[i].hasNature(NATURE.ID)) {
                        this.projects.add(projs[i].getLocation().toFile());
                    }
                } catch (CoreException ex) {
                    Log.log(ex);
                }
            }
        }

        cmbDbNames.addFilter(new ViewerFilter() {

            @Override
            public boolean select(Viewer viewer, Object parentElement, Object el) {
                return isMsSql == null || !(el instanceof DbInfo) || ((DbInfo) el).isMsSql() == isMsSql;
            }
        });

        loadStore(null);
    }

    public void loadStore(boolean useFileSources) {
        this.useFileSources = useFileSources;
        loadStore(null);
    }

    public void setComboEnabled(boolean enabled) {
        cmbDbNames.getControl().setEnabled(enabled);
    }

    public boolean isComboEnabled() {
        return cmbDbNames.getControl().getEnabled();
    }

    private void loadStore(ISelection newSelection) {
        ISelection selection = newSelection == null ? cmbDbNames.getSelection() : newSelection;

        List<DbInfo> store = DbInfo.readStoreFromXml();
        Collection<File> files;
        if (useFileSources || useDirSources) {
            files = stringToDumpFileHistory(prefStore.getString(PREF.DB_STORE_FILES));
        } else {
            files = Collections.emptyList();
        }

        List<Object> input = new ArrayList<>(store.size() + files.size() + projects.size() + 4);
        input.addAll(store);
        if (useFileSources) {
            input.add("─────────────────"); //$NON-NLS-1$
            input.add(LOAD_FILE);
            for (File f : files) {
                if (f.isFile()) {
                    input.add(f);
                }
            }
        }
        if (useDirSources) {
            input.add("─────────────────"); //$NON-NLS-1$
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

    public File getPathOfDir() {
        return getPath(true);
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

    public void addMouseListener(MouseAdapter mouseAdapter) {
        cmbDbNames.getCombo().addMouseListener(mouseAdapter);
    }

    public void setEnabled(boolean enabled) {
        cmbDbNames.getCombo().setEnabled(enabled);
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
            } else if (selected instanceof LoadFileElement) {
                LoadFileElement loadEl = (LoadFileElement) selected;
                File dumpFile = chooseDbSource(loadEl.loadDir);
                if (dumpFile != null) {
                    loadStore(new StructuredSelection(dumpFile));
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

        private File chooseDbSource(boolean dir) {
            String pathToDump = dir ? getDirPath() : getFilePath();
            if (pathToDump == null) {
                return null;
            }

            File dumpFile = new File(pathToDump);
            Deque<File> dumpHistory = stringToDumpFileHistory(prefStore.getString(PREF.DB_STORE_FILES));
            dumpHistory.addFirst(dumpFile);
            while (dumpHistory.size() > MAX_FILES_HISTORY) {
                dumpHistory.removeLast();
            }
            prefStore.setValue(PREF.DB_STORE_FILES, dumpFileHistoryToPreference(dumpHistory));
            prefStore.setValue(PREF.LAST_OPENED_LOCATION,
                    dir ? dumpFile.getAbsolutePath() : dumpFile.getParent());
            return dumpFile;
        }

        private String getFilePath() {
            FileDialog dialog = new FileDialog(cmbDbNames.getControl().getShell());
            dialog.setText(Messages.choose_dump_file_with_changes);
            dialog.setFilterExtensions(new String[] {"*.sql", "*"}); //$NON-NLS-1$ //$NON-NLS-2$
            dialog.setFilterNames(new String[] {
                    Messages.DiffPresentationPane_sql_file_filter,
                    Messages.DiffPresentationPane_any_file_filter});
            dialog.setFilterPath(prefStore.getString(PREF.LAST_OPENED_LOCATION));
            return dialog.open();
        }

        private String getDirPath() {
            DirectoryDialog dialog = new DirectoryDialog(cmbDbNames.getControl().getShell());
            dialog.setText(Messages.DbStorePicker_choose_dir);
            dialog.setFilterPath(prefStore.getString(PREF.LAST_OPENED_LOCATION));
            return dialog.open();
        }

        private String dumpFileHistoryToPreference(Collection<File> dumps) {
            StringBuilder sb = new StringBuilder();
            for (File path : dumps){
                sb.append(path.getAbsolutePath());
                sb.append(DELIM_ENTRY);
            }
            sb.setLength(sb.length() - 1);
            return sb.toString();
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
            return loadDir ? Messages.DbStorePicker_load_from_dir : Messages.DbStorePicker_load_from_file;
        }
    }

    private Deque<File> stringToDumpFileHistory(String preference) {
        String[] coordStrings = preference.split(DELIM_ENTRY);
        Deque<File> paths = new LinkedList<>();
        for (String path : coordStrings){
            File f = new File(path);
            if (f.exists() && !paths.contains(f)) {
                paths.add(f);
            }
        }
        return paths;
    }

    public void filter(Boolean isMsSql) {
        this.isMsSql = isMsSql;
        cmbDbNames.refresh();
    }

    public void dispose() {
        cmbDbNames.getControl().dispose();
    }
}
