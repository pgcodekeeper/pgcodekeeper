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
package ru.taximaxim.codekeeper.ui.dialogs;

import java.util.Collection;
import java.util.EnumSet;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ObjectTypeViewer {

    private static final Object[] TYPES_SORTED = EnumSet
            .complementOf(EnumSet.of(DbObjType.DATABASE, DbObjType.COLUMN))
            .stream().sorted((e1, e2) -> e1.name().compareTo(e2.name())).toArray();
    private static final Object[] ALL_TYPES_SORTED = EnumSet.allOf(DbObjType.class)
            .stream().sorted((e1, e2) -> e1.name().compareTo(e2.name())).toArray();

    private CheckboxTableViewer objViewer;

    public ObjectTypeViewer(Composite parent, String text, boolean needSelectButtons, boolean needAllTypes,
            Collection<DbObjType> types) {
        createTypesPart(parent, text, needAllTypes, types);
        if (needSelectButtons) {
            addSelectBtns(parent);
        }
    }

    private void createTypesPart(Composite parent, String text, boolean needAllTypes,
            Collection<DbObjType> types) {
        new Label(parent, SWT.NONE).setText(text);

        objViewer = CheckboxTableViewer.newCheckList(parent, SWT.BORDER);
        objViewer.setContentProvider(ArrayContentProvider.getInstance());
        objViewer.setLabelProvider(new LabelProvider() {

            @Override
            public String getText(Object element) {
                return ((DbObjType) element).getTypeName();
            }
        });

        objViewer.add(needAllTypes ? ALL_TYPES_SORTED : TYPES_SORTED);
        objViewer.setCheckedElements(types.toArray());
        objViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    }

    public void setAllSelected(boolean isSelected) {
        objViewer.setAllChecked(isSelected);
    }

    public Object[] getSelectedElements() {
        return objViewer.getCheckedElements();
    }

    private void addSelectBtns(Composite c) {
        Composite btnContainer = new Composite(c, SWT.NONE);
        btnContainer.setLayout(new GridLayout(2, false));
        btnContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

        Button btnSelectAll = new Button(btnContainer, SWT.BUTTON1);
        btnSelectAll.setText(Messages.select_all);
        btnSelectAll.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                objViewer.setAllChecked(true);
            }
        });
        Button btnClearAll = new Button(btnContainer, SWT.BUTTON1);
        btnClearAll.setText(Messages.clear_all);
        btnClearAll.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                objViewer.setAllChecked(false);
            }
        });
    }
}
