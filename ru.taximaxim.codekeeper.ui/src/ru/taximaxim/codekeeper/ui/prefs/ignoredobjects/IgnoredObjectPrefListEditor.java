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
package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

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
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.pgcodekeeper.core.ignorelist.IIgnoreList;
import org.pgcodekeeper.core.ignorelist.IgnoreList;
import org.pgcodekeeper.core.ignorelist.IgnoreSchemaList;
import org.pgcodekeeper.core.ignorelist.IgnoredObject;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.ProjectIcon;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;

public class IgnoredObjectPrefListEditor extends PrefListEditor<IgnoredObject> {

    private final boolean isIgnoreSchemaList;

    private IgnoredObjectPrefListEditor(Composite parent, boolean isIgnoreSchemaList) {
        super(parent);
        this.isIgnoreSchemaList = isIgnoreSchemaList;
        getViewer().addDoubleClickListener(event -> editObject());
    }

    public static IgnoredObjectPrefListEditor create(Composite parent, IgnoreList ignoreList) {
        fillComposite(parent, ignoreList,
                Messages.IgnoredObjectsPrefPage_these_objects_are_ignored_info,
                Messages.IgnoredObjectsPrefPage_these_objects_are_ignored_info_white);
        return new IgnoredObjectPrefListEditor(parent, false);
    }

    public static IgnoredObjectPrefListEditor createIgnoreSchemaEditor(Composite parent, IgnoreSchemaList ignoreList) {
        fillComposite(parent, ignoreList,
                Messages.IgnoredSchemaPrefListEditor_black_list_schema_ignor,
                Messages.IgnoredSchemaPrefListEditor_white_list_schema_ignor);
        return new IgnoredObjectPrefListEditor(parent, true);
    }

    private static void fillComposite(Composite composite, IIgnoreList ignoreList,
            String blackDescripton, String whiteDescripton) {
        Label descriptionLabel = new Label(composite, SWT.NONE);
        descriptionLabel.setText(blackDescripton);

        Composite compositeRadio = new Composite(composite, SWT.NONE);
        GridLayout gridRadioLayout = new GridLayout(2, false);
        gridRadioLayout.marginHeight = 0;
        gridRadioLayout.marginWidth = 0;
        compositeRadio.setLayout(gridRadioLayout);
        compositeRadio.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

        Button btnIsBlack = new Button (compositeRadio, SWT.RADIO);

        btnIsBlack.setText (Messages.IgnoredObjectsPrefPage_convert_to_black_list);
        btnIsBlack.setSelection(ignoreList.isShow());
        btnIsBlack.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                ignoreList.setShow(true);
                descriptionLabel.setText(blackDescripton);
                composite.layout();
            }
        });

        Button btnIsWhite = new Button(compositeRadio, SWT.RADIO);
        btnIsWhite.setText(Messages.IgnoredObjectsPrefPage_convert_to_white_list);
        btnIsWhite.setSelection(!ignoreList.isShow());
        btnIsWhite.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                ignoreList.setShow(false);
                descriptionLabel.setText(whiteDescripton);
                composite.layout();
            }
        });
    }

    @Override
    protected void createButtonsForSideBar(Composite parent) {
        createButton(parent, ADD_ID, Messages.add, Activator.getEclipseImage(ISharedImages.IMG_OBJ_ADD));
        createButton(parent, EDIT_ID, Messages.edit, Activator.getRegisteredImage(ProjectIcon.EDIT));
        createButton(parent, DELETE_ID, Messages.delete, Activator.getEclipseImage(ISharedImages.IMG_ETOOL_DELETE));
    }

    @Override
    protected IgnoredObject getNewObject(IgnoredObject oldObject) {
        NewIgnoredObjectDialog d = new NewIgnoredObjectDialog(getShell(), oldObject, isIgnoreSchemaList);
        return d.open() == Window.OK ? d.getIgnoredObject() : null;
    }

    @Override
    protected String errorAlreadyExists(IgnoredObject obj) {
        return Messages.IgnoredObjectPrefListEditor_already_present.formatted(obj.getName());
    }

    @Override
    protected void addColumns(TableViewer tableViewer) {
        TableViewerColumn name = new TableViewerColumn(tableViewer, SWT.NONE);
        name.getColumn().setResizable(true);
        name.getColumn().setText(Messages.ignoredObjectPrefListEditor_name);
        name.getColumn().setMoveable(true);
        name.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                IgnoredObject obj = (IgnoredObject) element;
                StringBuilder sb = new StringBuilder();
                return obj.appendRuleCode(sb, false).toString();
            }
        });
    }
}
