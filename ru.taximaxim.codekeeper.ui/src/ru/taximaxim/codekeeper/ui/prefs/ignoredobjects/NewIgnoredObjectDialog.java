/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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

import java.util.EnumSet;
import java.util.Set;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoredObject;
import ru.taximaxim.codekeeper.ui.dialogs.ObjectTypeViewer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class NewIgnoredObjectDialog extends InputDialog {

    private final IgnoredObject objInitial;
    private IgnoredObject ignoredObject;
    private Button btnPattern;
    private Button btnContent;
    private Button btnQualified;
    private ObjectTypeViewer objTypeViewer;
    private Set<DbObjType> types;
    private final boolean isIgnoreSchemaList;

    public IgnoredObject getIgnoredObject() {
        return ignoredObject;
    }

    public NewIgnoredObjectDialog(Shell shell, IgnoredObject objInitial, boolean isIgnoreSchemaList) {
        super(shell, Messages.IgnoredObjectPrefListEditor_new_ignored, Messages.IgnoredObjectPrefListEditor_object_name,
                objInitial == null ? null : objInitial.getName(),
                        text ->  text.isEmpty() ? Messages.IgnoredObjectPrefListEditor_enter_name : null);
        this.objInitial = objInitial;
        this.isIgnoreSchemaList = isIgnoreSchemaList;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);

        Composite c = new Composite(composite, SWT.NONE);
        c.setLayout(new GridLayout());
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = isIgnoreSchemaList ? 60 : 410;
        c.setLayoutData(gd);

        btnPattern = new Button(c, SWT.CHECK);
        btnPattern.setText(Messages.IgnoredObjectPrefListEditor_pattern);

        if (!isIgnoreSchemaList) {
            btnContent = new Button(c, SWT.CHECK);
            btnContent.setText(Messages.IgnoredObjectPrefListEditor_contents);

            btnQualified = new Button(c, SWT.CHECK);
            btnQualified.setText(Messages.IgnoredObjectPrefListEditor_qualified_name);

            if (objInitial != null) {
                btnContent.setSelection(objInitial.isIgnoreContent());
                btnQualified.setSelection(objInitial.isQualified());
            }

            types = objInitial == null ? EnumSet.noneOf(DbObjType.class) : objInitial.getObjTypes();
            objTypeViewer = new ObjectTypeViewer(c, Messages.ignoredObjectPrefListEditor_type, true, false, types, null);
        }
        if (objInitial != null) {
            btnPattern.setSelection(objInitial.isRegular());
        }
        return composite;
    }

    @Override
    protected void okPressed() {
        if (!isIgnoreSchemaList) {
            types.clear();
            for (Object obj : objTypeViewer.getSelectedElements()) {
                types.add((DbObjType)obj);
            }
        }

        ignoredObject = new IgnoredObject(getValue(), btnPattern.getSelection(),
                (!isIgnoreSchemaList && btnContent.getSelection()),
                (!isIgnoreSchemaList && btnQualified.getSelection()),
                isIgnoreSchemaList ? EnumSet.noneOf(DbObjType.class) : types);
        super.okPressed();
    }

    @Override
    protected boolean isResizable() {
        return true;
    }
}
