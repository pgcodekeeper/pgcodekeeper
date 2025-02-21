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
package ru.taximaxim.codekeeper.ui.dbstore;

import java.text.MessageFormat;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;

public class DbPropertyListEditor extends PrefListEditor<Entry<String, String>> {

    public DbPropertyListEditor(Composite parent) {
        super(parent);
    }

    @Override
    public boolean checkDuplicate(Entry<String, String> o1, Entry<String, String> o2) {
        return o1.getKey().equals(o2.getKey());
    }

    @Override
    protected Entry<String, String> getNewObject(Entry<String, String> oldObject) {
        NewDbPropertyDialog d = new NewDbPropertyDialog(getShell(), oldObject);
        return d.open() == Window.OK ? d.getProperty() : null;
    }

    @Override
    protected String errorAlreadyExists(Entry<String, String> obj) {
        return MessageFormat.format(
                Messages.DbPropertyListEditor_already_present, obj.getKey());
    }

    @Override
    protected void addColumns(TableViewer tableViewer) {
        TableViewerColumn name = new TableViewerColumn(tableViewer, SWT.NONE);
        name.getColumn().setResizable(true);
        name.getColumn().setText(Messages.DbPropertyListEditor_tbl_col_name);
        name.getColumn().setMoveable(true);
        name.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                Entry<?, ?> obj = (Entry<?, ?>) element;
                return obj.getKey().toString();
            }
        });

        TableViewerColumn value = new TableViewerColumn(tableViewer, SWT.NONE);
        value.getColumn().setResizable(true);
        value.getColumn().setText(Messages.DbPropertyListEditor_tbl_col_value);
        value.getColumn().setMoveable(true);
        value.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                Entry<?, ?> obj = (Entry<?, ?>) element;
                return obj.getValue().toString();
            }
        });

        value.setEditingSupport(new TxtValueEditingSupport(tableViewer));

        PixelConverter pc = new PixelConverter(tableViewer.getControl());
        name.getColumn().setWidth(150);
        value.getColumn().setWidth(pc.convertWidthInCharsToPixels(28));
    }
}

class NewDbPropertyDialog extends Dialog {

    private final Entry<String, String> objInitial;
    private Entry<String, String> property;
    private Text txtPropertyName;
    private Text txtPropertyValue;

    public Entry<String, String> getProperty() {
        return property;
    }

    public NewDbPropertyDialog(Shell shell, Entry<String, String> objInitial) {
        super(shell);
        this.objInitial = objInitial;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);

        Composite c = new Composite(composite, SWT.NONE);
        c.setLayout(new GridLayout(2,  false));
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = 600;
        c.setLayoutData(gd);

        new Label(c, SWT.LEFT).setText(Messages.DbPropertyListEditor_field_name);

        txtPropertyName = new Text(c, SWT.BORDER);
        txtPropertyName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(c, SWT.LEFT).setText(Messages.DbPropertyListEditor_field_value);

        txtPropertyValue = new Text(c, SWT.BORDER);
        txtPropertyValue.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        if (objInitial != null) {
            txtPropertyName.setText(objInitial.getKey());
            txtPropertyValue.setText(objInitial.getValue());
        }

        return composite;
    }

    @Override
    protected void okPressed() {
        property = new SimpleEntry<>(txtPropertyName.getText(), txtPropertyValue.getText());
        super.okPressed();
    }

    @Override
    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        shell.setText(Messages.DbPropertyListEditor_new_property);
    }

    @Override
    protected boolean isResizable() {
        return true;
    }
}
