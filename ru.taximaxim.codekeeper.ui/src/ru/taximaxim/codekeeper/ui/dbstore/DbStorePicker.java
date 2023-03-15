/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.dbstore;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.IntUnaryOperator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
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
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.dialogs.PreferencesUtil;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF_PAGE;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.xmlstore.DbXmlStore;

public class DbStorePicker extends AbstractStorePicker implements IStorePicker {

    private static final LoadFileElement LOAD_FILE = new LoadFileElement(false);
    private static final LoadFileElement LOAD_DIR = new LoadFileElement(true);
    private static final OpenDbStore OPENDB = new OpenDbStore();
    private static final int MAX_FILES_HISTORY = 10;

    private Boolean isMsSql;
    private final IPreferenceStore prefStore = Activator.getDefault().getPreferenceStore();
    private final List<File> projects = new ArrayList<>();

    private final ComboViewer cmbDbNames;

    public DbStorePicker(Composite parent, boolean useFileSources, boolean useDirSources) {
        this(parent, DEFAULT_LENGTH, useFileSources, useDirSources);
    }

    public DbStorePicker(Composite parent, int chars, boolean useFileSources, boolean useDirSources) {
        super(parent, useFileSources, useDirSources);
        cmbDbNames = new ComboViewer(parent, SWT.READ_ONLY | SWT.DROP_DOWN) {
            @Override
            protected void fireSelectionChanged(SelectionChangedEvent event) {
                if (triggerEvent) {
                    super.fireSelectionChanged(event);
                }
            }
        };
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

    @Override
    protected Control getControl() {
        return cmbDbNames.getControl();
    }

    @Override
    public void setUseFileSources(boolean useFileSources) {
        super.setUseFileSources(useFileSources);
        loadStore(null);
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
        input.add(OPENDB);
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

    @Override
    public Object getSelection() {
        return ((IStructuredSelection) cmbDbNames.getSelection()).getFirstElement();
    }

    @Override
    public void setSelection(Object selection) {
        cmbDbNames.setSelection(selection == null ? StructuredSelection.EMPTY
                : new StructuredSelection(selection));
    }

    @Override
    public void setSelection(Object selection, boolean triggerEvent) {
        boolean oldTriggerEvent = this.triggerEvent;
        try {
            this.triggerEvent = triggerEvent;
            setSelection(selection);
        } finally {
            this.triggerEvent = oldTriggerEvent;
        }
    }

    @Override
    public void addSelectionListener(Runnable listener) {
        cmbDbNames.addSelectionChangedListener(e -> listener.run());
    }

    public void addMouseListener(MouseAdapter mouseAdapter) {
        cmbDbNames.getCombo().addMouseListener(mouseAdapter);
    }

    @Override
    public void filter(Boolean isMsSql) {
        this.isMsSql = isMsSql;
        cmbDbNames.refresh();
    }

    public void fixEclipseBug567652() {
        Combo combo = cmbDbNames.getCombo();
        LocalResourceManager lrm = new LocalResourceManager(JFaceResources.getResources(), combo);
        RGB rgb = combo.getForeground().getRGB();

        // separate workaround for invisible text on KDE
        // detach widget color from theme by using a modified version
        IntUnaryOperator modColor = c -> c == 255 ? c - 1 : c + 1;
        combo.setForeground(lrm.createColor(new RGB(
                modColor.applyAsInt(rgb.red),
                modColor.applyAsInt(rgb.green),
                modColor.applyAsInt(rgb.blue))));

        combo.setBackground(combo.getBackground());
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
                File dumpFile = chooseDbSource(prefStore, cmbDbNames.getControl().getShell(), loadEl.loadDir);

                if (dumpFile != null) {
                    loadStore(new StructuredSelection(dumpFile));
                    revertSelection = false;
                } else {
                    revertSelection = true;
                }
            } else if (selected instanceof OpenDbStore) {
                PreferencesUtil
                .createPreferenceDialogOn(cmbDbNames.getControl().getShell(), PREF_PAGE.DB_STORE, null, null)
                .open();
                revertSelection = true;
            } else {
                // string or some other "unselectable" selection
                revertSelection = true;
            }

            if (revertSelection) {
                cmbDbNames.setSelection(previous);
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
            return loadDir ? Messages.DbStorePicker_load_from_dir : Messages.DbStorePicker_load_from_file;
        }
    }

    private static class OpenDbStore {
        @Override
        public String toString() {
            return Messages.DbStorePicker_open_db_store;
        }
    }

}