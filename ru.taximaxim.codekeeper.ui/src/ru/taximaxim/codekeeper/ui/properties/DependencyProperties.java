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
package ru.taximaxim.codekeeper.ui.properties;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PropertyPage;
import org.eclipse.ui.navigator.CommonNavigator;
import org.osgi.service.prefs.BackingStoreException;

import ru.taximaxim.codekeeper.core.fileutils.FileUtils;
import ru.taximaxim.codekeeper.core.libraries.PgLibrary;
import ru.taximaxim.codekeeper.core.xmlstore.DependenciesXmlStore;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.libraries.LibraryUtils;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;

public class DependencyProperties extends PropertyPage {

    private final String defaultPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
    private Path xmlStorePath;
    private DependenciesXmlStore store;
    private IEclipsePreferences prefs;

    private DependenciesListEditor editor;
    private Button btnSafeMode;
    private Button btnLoadNested;
    private IProject proj;

    @Override
    public void setElement(IAdaptable element) {
        super.setElement(element);
        proj = element.getAdapter(IProject.class);
        xmlStorePath = Paths.get(proj.getLocation().append(DependenciesXmlStore.FILE_NAME).toString());
        store = new DependenciesXmlStore(xmlStorePath);
        prefs = new ProjectScope(proj).getNode(UIConsts.PLUGIN_ID.THIS);
    }

    @Override
    protected Control createContents(Composite parent) {
        Composite area = new Composite(parent, SWT.NONE);
        area.setLayout(new GridLayout());

        List<PgLibrary> input;
        boolean loadNested;
        try {
            input = store.readObjects();
            loadNested = store.readLoadNestedFlag();
        } catch (IOException e) {
            Log.log(e);
            input = new ArrayList<>();
            loadNested = false;
        }

        editor = new DependenciesListEditor(area);
        editor.setLayoutData(new GridData(GridData.FILL_BOTH));
        editor.setInputList(input);

        btnSafeMode = new Button(area, SWT.CHECK);
        btnSafeMode.setText(Messages.DependencyProperties_safe_mode);
        btnSafeMode.setToolTipText(Messages.DependencyProperties_safe_mode_desc);
        btnSafeMode.setSelection(prefs.getBoolean(PROJ_PREF.LIB_SAFE_MODE, true));

        btnLoadNested = new Button(area, SWT.CHECK);
        btnLoadNested.setText(Messages.DependencyProperties_load_nested);
        btnLoadNested.setToolTipText(Messages.DependencyProperties_load_dependencies);
        btnLoadNested.setSelection(loadNested);

        return area;
    }

    @Override
    public boolean performOk() {
        try {
            prefs.putBoolean(PROJ_PREF.LIB_SAFE_MODE, btnSafeMode.getSelection());
            prefs.flush();
            store.writeDependencies(editor.getList(), btnLoadNested.getSelection());
            refreshProject();
            setValid(true);
            setErrorMessage(null);
        } catch (IOException | BackingStoreException e) {
            setErrorMessage(MessageFormat.format(
                    Messages.projectProperties_error_occurs_while_saving_properties,
                    e.getLocalizedMessage()));
            setValid(false);
            return false;
        }
        return true;
    }

    @Override
    protected void contributeButtons(Composite parent) {
        ((GridLayout) parent.getLayout()).numColumns++;
        Button button = new Button(parent, SWT.PUSH);
        button.setText(Messages.DependencyProperties_clear_libraries_cache);
        button.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                MessageBox mbQuestion = new MessageBox(getShell(), SWT.ICON_QUESTION | SWT.YES | SWT.NO);
                mbQuestion.setText(Messages.DependencyProperties_clear_cache);
                mbQuestion.setMessage(Messages.DependencyProperties_clear_cache_descr);
                if (mbQuestion.open() != SWT.YES) {
                    return;
                }

                try {
                    FileUtils.deleteRecursive(LibraryUtils.META_PATH);
                } catch (IOException ex) {
                    ExceptionNotifier.notifyDefault(Messages.DependencyProperties_clear_cache_error, ex);
                }
            }
        });
    }

    private void refreshProject() {
        CommonNavigator view = (CommonNavigator)PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getActivePage().findView(IPageLayout.ID_PROJECT_EXPLORER);
        if (view != null) {
            view.getCommonViewer().refresh(proj);
        }
    }

    private class DependenciesListEditor extends PrefListEditor<PgLibrary> {

        private String action;

        public DependenciesListEditor(Composite parent) {
            super(parent);
            getViewer().addDoubleClickListener(event -> editObject());
        }

        @Override
        public boolean checkDuplicate(PgLibrary o1, PgLibrary o2) {
            return o1.getTitle().equals(o2.getTitle());
        }

        @Override
        protected PgLibrary getNewObject(PgLibrary oldObject) {
            DependencyEditorDialog dialog = new DependencyEditorDialog(getShell(), oldObject, action,
                    defaultPath, xmlStorePath);
            return dialog.open() == Window.OK ? dialog.getLibrary() : null;
        }

        @Override
        protected String errorAlreadyExists(PgLibrary obj) {
            return MessageFormat.format(Messages.DbStorePrefPage_already_present, obj.getPath());
        }

        @Override
        protected void addColumns(TableViewer viewer) {
            TableViewerColumn path = new TableViewerColumn(viewer, SWT.NONE);
            path.setLabelProvider(new ColumnLabelProvider() {

                @Override
                public String getText(Object element) {
                    PgLibrary obj = (PgLibrary) element;
                    return obj.getTitle();
                }
            });
        }

        @Override
        protected void createButtonsForSideBar(Composite parent) {
            createButton(parent, ADD_ID, Messages.add, Activator.getEclipseImage(ISharedImages.IMG_OBJ_ADD));
            createButton(parent, COPY_ID, Messages.copy, Activator.getEclipseImage(ISharedImages.IMG_TOOL_COPY));
            createButton(parent, EDIT_ID, Messages.edit, Activator.getRegisteredImage(FILE.ICONEDIT));
            createButton(parent, DELETE_ID, Messages.delete, Activator.getEclipseImage(ISharedImages.IMG_ETOOL_DELETE));
        }

        @Override
        protected void editObject() {
            action = Messages.DependencyProperties_edit_dependency;
            super.editObject();
        }

        @Override
        protected void copyObject() {
            action = Messages.DependencyProperties_copy_dependency;
            super.copyObject();
        }

        @Override
        public void addNewObject(PgLibrary oldObject) {
            action = Messages.DependencyProperties_create_new_dependency;
            super.addNewObject(oldObject);
        }
    }
}
