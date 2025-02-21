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
package ru.taximaxim.codekeeper.ui.prefs;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.MessageFormat;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.ProjectIcon;
import ru.taximaxim.codekeeper.ui.UIConsts.CONN_TYPE_PREF;
import ru.taximaxim.codekeeper.ui.dbstore.ConnectionTypeInfo;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.xmlstore.ConnectioTypeXMLStore;

public final class ConnectionTypePrefPage extends PreferencePage
implements IWorkbenchPreferencePage  {

    private ConnectionTypePrefListEditor list;

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected Control createContents(Composite parent) {
        list = new ConnectionTypePrefListEditor(parent);
        list.setLayoutData(new GridData(GridData.FILL_BOTH));
        list.setInputList(ConnectioTypeXMLStore.readStoreFromXml());
        return list;
    }

    @Override
    public boolean performOk() {
        try {
            ConnectioTypeXMLStore.INSTANCE.writeObjects(list.getList());
            super.performOk();
            getPreferenceStore().setValue(CONN_TYPE_PREF.LAST_CONN_TYPE_CHANGE_TIME, System.currentTimeMillis());
            return true;
        } catch (IOException e) {
            setErrorMessage(e.getLocalizedMessage());
            return false;
        }
    }
}

final class ConnectionTypePrefListEditor extends PrefListEditor<ConnectionTypeInfo> {

    private String action;

    private Text textName;
    private ColorSelector color;

    private ConnectionTypeInfo type;

    protected ConnectionTypePrefListEditor(Composite parent) {
        super(parent);
        getViewer().addDoubleClickListener(event -> editObject());
    }

    @Override
    protected void addColumns(TableViewer viewer) {
        TableViewerColumn colName = new TableViewerColumn(viewer, SWT.NONE);
        colName.getColumn().setResizable(true);
        colName.getColumn().setText(Messages.connectionTypePrefPage_name);
        colName.setLabelProvider(new ColumnLabelProvider() {

            private final ResourceManager resourceManager = new LocalResourceManager(JFaceResources.getResources());

            @Override
            public String getText(Object element) {
                return ((ConnectionTypeInfo) element).getName();
            }

            @Override
            public Color getBackground(Object element) {
                return resourceManager.createColor(StringConverter.asRGB(((ConnectionTypeInfo) element).getColor()));
            }

            @Override
            public void dispose() {
                resourceManager.dispose();
                super.dispose();
            }
        });
    }

    @Override
    protected void createButtonsForSideBar(Composite parent) {
        createButton(parent, ADD_ID, Messages.add, Activator.getEclipseImage(ISharedImages.IMG_OBJ_ADD));
        createButton(parent, COPY_ID, Messages.copy, Activator.getEclipseImage(ISharedImages.IMG_TOOL_COPY));
        createButton(parent, EDIT_ID, Messages.edit, Activator.getRegisteredImage(ProjectIcon.EDIT));
        createButton(parent, DELETE_ID, Messages.delete, Activator.getEclipseImage(ISharedImages.IMG_ETOOL_DELETE));

        Button exportConTypes = createButton(parent, CLIENT_ID, Messages.connectionTypePrefPage_export,
                ProjectIcon.EXPORT);
        exportConTypes.setLayoutData(new GridData(SWT.DEFAULT, SWT.END, false, true));
        exportConTypes.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog dialog = new FileDialog(getShell(), SWT.SAVE);
                dialog.setText(Messages.connectionTypePrefPage_export);
                dialog.setFilterExtensions(new String[] { "*.xml", "*" }); //$NON-NLS-1$ //$NON-NLS-2$
                dialog.setFilterNames(new String[] { Messages.DbStorePrefPage_xml_files, Messages.DiffPresentationPane_any_file_filter });
                dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());

                String stringPath = dialog.open();
                if (stringPath != null) {
                    try {
                        new ConnectioTypeXMLStore(Paths.get(stringPath)).writeObjects(getList());
                    } catch (IOException ex) {
                        ExceptionNotifier.notifyDefault(Messages.connectionTypePrefPage_saving_error, ex);
                    }
                }
            }
        });

        Button importConTypes = createButton(parent, CLIENT_ID, Messages.connectionTypePrefPage_import,
                ProjectIcon.IMPORT);
        importConTypes.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
                dialog.setText(Messages.connectionTypePrefPage_import);
                dialog.setFilterExtensions(new String[] { "*.xml", "*" }); //$NON-NLS-1$ //$NON-NLS-2$
                dialog.setFilterNames(new String[] {Messages.DbStorePrefPage_xml_files, Messages.DiffPresentationPane_any_file_filter });
                dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());

                String stringPath = dialog.open();
                if (stringPath != null) {
                    try {
                        setInputList(new ConnectioTypeXMLStore(Paths.get(stringPath)).readObjects());
                    } catch (IOException ex) {
                        ExceptionNotifier.notifyDefault(Messages.connectionTypePrefPage_opening_error, ex);
                    }
                }
            }
        });
    }

    @Override
    protected void copyObject() {
        action = Messages.connectionTypePrefPage_copyType;
        super.copyObject();
    }

    @Override
    public void addNewObject(ConnectionTypeInfo oldObject) {
        action = Messages.connectionTypePrefPage_createType;
        super.addNewObject(oldObject);
    }

    @Override
    protected void editObject() {
        action = Messages.connectionTypePrefPage_editType;
        super.editObject();
    }

    @Override
    protected String errorAlreadyExists(ConnectionTypeInfo obj) {
        return MessageFormat.format(Messages.DbStorePrefPage_already_present, obj.getName());
    }

    @Override
    protected ConnectionTypeInfo getNewObject(ConnectionTypeInfo oldObject) {
        Dialog d = new Dialog(getShell()) {

            @Override
            protected Control createDialogArea(Composite parent) {
                parent.getShell().setText(action);

                String name = "";//$NON-NLS-1$
                String typeColor = "255,255,255";//$NON-NLS-1$

                if (oldObject != null) {
                    name = oldObject.getName();
                    typeColor = oldObject.getColor();
                }

                Composite container = (Composite) super.createDialogArea(parent);
                GridLayout layout = new GridLayout(2, false);
                layout.marginRight = 5;
                layout.marginLeft = 10;
                container.setLayout(layout);
                applyDialogFont(container);

                Label lbl = new Label(container, SWT.NONE);
                lbl.setText(Messages.connectionTypePrefPage_name);

                textName = new Text(container, SWT.BORDER);
                textName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
                textName.setText(name);

                Label lblColor = new Label(container, SWT.NONE);
                lblColor.setText(Messages.connectionTypePrefPage_color);

                color = new ColorSelector(container);
                color.setColorValue(StringConverter.asRGB(typeColor));

                return container;
            }

            @Override
            protected void okPressed() {
                type = new ConnectionTypeInfo(textName.getText(), StringConverter.asString(color.getColorValue()));
                super.okPressed();
            }
        };

        return d.open() == Window.OK ? type : null;
    }
}
