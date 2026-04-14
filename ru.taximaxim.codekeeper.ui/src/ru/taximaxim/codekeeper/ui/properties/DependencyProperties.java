/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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
import java.nio.file.*;
import java.util.List;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.dialogs.PropertyPage;
import org.pgcodekeeper.core.database.base.loader.AbstractProjectLoader;
import org.pgcodekeeper.core.dependencieslist.DependenciesReader;
import org.pgcodekeeper.core.dependencieslist.Dependency;
import ru.taximaxim.codekeeper.ui.*;
import ru.taximaxim.codekeeper.ui.dialogs.DependencyEditorDialog;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;
import ru.taximaxim.codekeeper.ui.utils.ProjectUtils;

public final class DependencyProperties extends PropertyPage {

    private DependenciesListEditor editor;
    private Path depsFilePath;
    private IProject proj;

    @Override
    public void setElement(IAdaptable element) {
        super.setElement(element);
        proj = element.getAdapter(IProject.class);
        depsFilePath = Paths.get(proj.getLocationURI()).resolve(AbstractProjectLoader.ADDITIONAL_DEPENDENCIES_FILE);
    }

    @Override
    protected Control createContents(Composite parent) {
        DatabaseType dbType = ProjectUtils.getDatabaseType(proj);
        editor = new DependenciesListEditor(parent, dbType);

        List<Dependency> list = readObjects();
        editor.setInputList(list);
        return editor;
    }

    @Override
    public boolean performOk() {
        try {
            writeObjects(editor.getList());
            setValid(true);
            setErrorMessage(null);
        } catch (IOException e) {
            setErrorMessage(Messages.DependenciesProperties_error_save + e.getLocalizedMessage());
            setValid(false);
            return false;
        }
        return true;
    }

    private List<Dependency> readObjects() {
        return DependenciesReader.getDependencies(depsFilePath);
    }

    private void writeObjects(List<Dependency> list) throws IOException {
        List<String> lines = list.stream()
                .map(Dependency::toString)
                .toList();
        Files.write(depsFilePath, lines);
    }

    private static class DependenciesListEditor extends PrefListEditor<Dependency> {

        private String action;
        private DatabaseType dbType;

        public DependenciesListEditor(Composite parent, DatabaseType dbType) {
            super(parent);
            this.dbType = dbType;
            getViewer().addDoubleClickListener(event -> editObject());
        }

        @Override
        protected void addColumns(TableViewer viewer) {
            TableViewerColumn path = new TableViewerColumn(viewer, SWT.NONE);
            path.setLabelProvider(new ColumnLabelProvider() {

                @Override
                public String getText(Object element) {
                    Dependency obj = (Dependency) element;
                    return obj.toString();
                }
            });
        }

        @Override
        protected Dependency getNewObject(Dependency oldObject) {
            DependencyEditorDialog dialog = new DependencyEditorDialog(getShell(), oldObject, action, dbType);
            if (dialog.open() == Window.OK) {
                return dialog.getResult();
            }
            return null;
        }

        @Override
        protected String errorAlreadyExists(Dependency obj) {
            return Messages.DbStorePrefPage_already_present.formatted(obj.toString());
        }

        @Override
        protected void createButtonsForSideBar(Composite parent) {
            createButton(parent, ADD_ID, Messages.add, Activator.getEclipseImage(ISharedImages.IMG_OBJ_ADD));
            createButton(parent, COPY_ID, Messages.copy, Activator.getEclipseImage(ISharedImages.IMG_TOOL_COPY));
            createButton(parent, EDIT_ID, Messages.edit, Activator.getRegisteredImage(ProjectIcon.EDIT));
            createButton(parent, DELETE_ID, Messages.delete, Activator.getEclipseImage(ISharedImages.IMG_ETOOL_DELETE));
        }

        @Override
        protected void editObject() {
            action = Messages.DependencyProperties_edit_dependency;

            IStructuredSelection sel = getViewer().getStructuredSelection();
            if (!sel.isEmpty() && sel.getFirstElement() instanceof Dependency dep) {
                DependencyEditorDialog dialog = new DependencyEditorDialog(getShell(), dep, action, dbType);
                if (dialog.open() == Window.OK) {
                    Dependency result = dialog.getResult();
                    List<Dependency> list = getList();
                    list.set(list.indexOf(dep), result);
                    refresh();
                }
            }
        }

        @Override
        public void addNewObject(Dependency oldObject) {
            action = Messages.DependencyProperties_create_new_dependency;
            super.addNewObject(oldObject);
        }

        @Override
        protected void copyObject() {
            action = Messages.DependencyProperties_copy_dependency;
            super.copyObject();
        }
    }
}
