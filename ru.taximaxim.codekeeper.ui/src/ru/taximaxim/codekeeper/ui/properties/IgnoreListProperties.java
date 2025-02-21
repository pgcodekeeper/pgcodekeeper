/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.dialogs.PropertyPage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.ProjectIcon;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.dialogs.IgnoreListEditorDialog;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;
import ru.taximaxim.codekeeper.ui.xmlstore.IgnoreListsXmlStore;

public class IgnoreListProperties extends PropertyPage {

    private IgnoreListEditor editor;
    private IgnoreListsXmlStore store;
    private IProject proj;

    @Override
    public void setElement(IAdaptable element) {
        super.setElement(element);
        proj = element.getAdapter(IProject.class);
        store = new IgnoreListsXmlStore(proj);
    }

    @Override
    protected Control createContents(Composite parent) {
        editor = new IgnoreListEditor(parent);

        List<String> list;
        try {
            list = store.readObjects();
        } catch (IOException e) {
            list = new ArrayList<>();
        }

        editor.setInputList(list);
        return editor;
    }

    @Override
    public boolean performOk() {
        try {
            store.writeObjects(editor.getList());
            setValid(true);
            setErrorMessage(null);
        } catch (IOException e) {
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
        button.setText(Messages.IgnoreListProperties_edit_pgcodekeeperignore);
        button.setToolTipText(Messages.IgnoreListProperties_default_ignore_tooltip);
        button.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    Path path = Paths.get(proj.getLocationURI()).resolve(FILE.IGNORED_OBJECTS);
                    if (Files.notExists(path)) {
                        Files.write(path, "SHOW ALL".getBytes(StandardCharsets.UTF_8)); //$NON-NLS-1$
                    }
                    new IgnoreListEditorDialog(getShell(), path, editor).open();
                } catch (IOException ex) {
                    Log.log(Log.LOG_ERROR, "Error while create file", ex); //$NON-NLS-1$
                }
            }
        });
    }

    public static class IgnoreListEditor extends PrefListEditor<String> {

        public IgnoreListEditor(Composite parent) {
            super(parent);
            getViewer().addDoubleClickListener(event -> editObject());
        }

        @Override
        protected void addColumns(TableViewer tableViewer) {
            TableViewerColumn col = new TableViewerColumn(tableViewer, SWT.NONE);
            col.setLabelProvider(new ColumnLabelProvider());
        }

        @Override
        protected String getNewObject(String oldObject) {
            FileDialog dialog = new FileDialog(getShell());
            dialog.setText(Messages.DbStoreEditorDialog_select_ignore_file);
            dialog.setFilterExtensions(new String[] {"*.pgcodekeeperignore", "*"}); //$NON-NLS-1$ //$NON-NLS-2$
            dialog.setFilterNames(new String[] {
                    Messages.DbStoreEditorDialog_pgcodekeeperignore_files_filter,
                    Messages.DiffPresentationPane_any_file_filter});
            dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());
            return dialog.open();
        }

        @Override
        protected String errorAlreadyExists(String obj) {
            return MessageFormat.format(Messages.DbStorePrefPage_already_present, obj);
        }

        @Override
        protected void createButtonsForSideBar(Composite parent) {
            createButton(parent, ADD_ID, Messages.add, Activator.getEclipseImage(ISharedImages.IMG_OBJ_ADD));
            Button btnNew = createButton(parent, CLIENT_ID, Messages.IgnoreListProperties_create_new_file,
                    Activator.getEclipseImage(ISharedImages.IMG_OBJ_FILE));
            btnNew.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent event) {
                    new IgnoreListEditorDialog(getShell(), null, IgnoreListEditor.this).open();
                }
            });
            createButton(parent, EDIT_ID, Messages.edit, Activator.getRegisteredImage(ProjectIcon.EDIT));
            createButton(parent, DELETE_ID, Messages.delete, Activator.getEclipseImage(ISharedImages.IMG_ETOOL_DELETE));
        }

        @Override
        protected void editObject() {
            IStructuredSelection sel = getViewer().getStructuredSelection();
            if (!sel.isEmpty()) {
                String path = (String) sel.getFirstElement();
                new IgnoreListEditorDialog(getShell(), Paths.get(path), IgnoreListEditor.this).open();
            }
        }
    }
}
