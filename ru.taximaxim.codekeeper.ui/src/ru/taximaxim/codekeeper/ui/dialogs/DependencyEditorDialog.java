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
package ru.taximaxim.codekeeper.ui.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
import org.pgcodekeeper.core.database.api.schema.DbObjType;
import org.pgcodekeeper.core.database.api.schema.ObjectReference;
import org.pgcodekeeper.core.dependencieslist.Dependency;

import ru.taximaxim.codekeeper.ui.DatabaseType;
import ru.taximaxim.codekeeper.ui.differ.ObjectLevel;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public final class DependencyEditorDialog extends TrayDialog {

    private String action;
    private final Dependency initialDependencies;
    private Dependency result;
    private DatabaseType dbType;

    private Text txtSourceName;
    private Text txtTargetName;

    private ComboViewer comboTypeSource;
    private ComboViewer comboTypeTarget;

    public DependencyEditorDialog(Shell shell, Dependency initialEntry,
            String action, DatabaseType dbType) {
        super(shell);
        this.dbType = dbType;
        this.initialDependencies = initialEntry;
        this.action = action;
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(action);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        var list = ObjectLevel.getAllTypesForDbType(dbType, false);
        Composite area = (Composite) super.createDialogArea(parent);

        Composite composite = new Composite(area, SWT.NONE);
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        composite.setLayout(new GridLayout(3, false));

        // info label
        Label infoLabel = new Label(composite, SWT.WRAP);
        infoLabel.setText(Messages.DependenciesEditorDialog_source_depends_on_target);
        GridData infoLayout = new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1);
        infoLabel.setLayoutData(infoLayout);

        // separator
        Label separator = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
        separator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));

        // add space
        Label spacer = new Label(composite, SWT.NONE);
        spacer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
        ((GridData) spacer.getLayoutData()).heightHint = 5;

        // source
        comboTypeSource = createComboType(composite, list, Messages.DependenciesEditorDialog_parent_name);
        txtSourceName = createTextBox(composite);

        // target
        comboTypeTarget = createComboType(composite, list, Messages.DependenciesEditorDialog_depcy_name);
        txtTargetName = createTextBox(composite);

        if (initialDependencies != null) {
            fillFields(initialDependencies.source(), comboTypeSource, txtSourceName);
            fillFields(initialDependencies.target(), comboTypeTarget, txtTargetName);
        }

        return area;
    }

    private ComboViewer createComboType(Composite composite, List<DbObjType> list, String lblText) {
        new Label(composite, SWT.NONE).setText(lblText);

        ComboViewer cmbType = new ComboViewer(composite, SWT.READ_ONLY);
        cmbType.setContentProvider(ArrayContentProvider.getInstance());
        cmbType.setLabelProvider(LabelProvider.createTextProvider(
                element -> ((DbObjType) element).getTypeName()
            ));
        cmbType.setInput(list);
        cmbType.getCombo().select(0);
        return cmbType;
    }

    private Text createTextBox(Composite composite) {
        Text textBox = new Text(composite, SWT.BORDER);
        GridData gd = new GridData(SWT.FILL, SWT.DEFAULT, true, false);
        gd.minimumWidth = 200;
        textBox.setLayoutData(gd);
        return textBox;
    }

    private void fillFields(ObjectReference objRef, ComboViewer comboTypeViewer, Text objName) {
        comboTypeViewer.setSelection(new StructuredSelection(objRef.type()));
        objName.setText(objRef.getFullName() != null ? objRef.getFullName() : "");
    }

    @Override
    protected void okPressed() {
        var sourceName= txtSourceName.getText().trim();
        var targetName = txtTargetName.getText().trim();

        if (sourceName.isEmpty() || targetName.isEmpty()) {
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_WARNING);
            mb.setText(Messages.DependenciesEditorDialog_cannot_save);
            mb.setMessage(Messages.DependenciesEditorDialog_must_filled);
            mb.open();
            return;
        }

        var sourceRef = new ObjectReference(sourceName,
                (DbObjType) comboTypeSource.getStructuredSelection().getFirstElement());
        var targetRef = new ObjectReference(targetName,
                (DbObjType) comboTypeTarget.getStructuredSelection().getFirstElement());

        result = new Dependency(sourceRef, targetRef);
        super.okPressed();
    }

    public Dependency getResult() {
        return result;
    }

    @Override
    protected boolean isResizable() {
        return true;
    }
}
