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

import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.core.model.difftree.IgnoreSchemaList;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoredObject;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.CheckEditingSupport;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.CheckEditingSupport.BooleanChangeValues;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.IgnoredObjectPrefListEditor;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.NewIgnoredObjectDialog;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.TxtNameEditingSupport;

public class IgnoredSchemaListEditor extends IgnoredObjectPrefListEditor {

    public static IgnoredSchemaListEditor create(Composite parent, IgnoreSchemaList ignoreList) {
        IgnoredObjectPrefListEditor.fillComposite(parent, ignoreList,
                Messages.IgnoredSchemaPrefListEditor_black_list_schema_ignor,
                Messages.IgnoredSchemaPrefListEditor_white_list_schema_ignor);
        return new IgnoredSchemaListEditor(parent);
    }

    private IgnoredSchemaListEditor(Composite parent) {
        super(parent);
    }

    @Override
    protected IgnoredObject getNewObject(IgnoredObject oldObject) {
        NewIgnoredObjectDialog d = new NewIgnoredObjectDialog(getShell(), oldObject, true);
        return d.open() == Window.OK ? d.getIgnoredObject() : null;
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
                return obj.getName();
            }
        });
        name.setEditingSupport(new TxtNameEditingSupport(tableViewer, this));

        String ballotBoxWithCheck = "\u2611"; //$NON-NLS-1$
        String ballotBox = "\u2610"; //$NON-NLS-1$

        TableViewerColumn isRegular = new TableViewerColumn(tableViewer, SWT.CENTER);
        isRegular.getColumn().setResizable(true);
        isRegular.getColumn().setText(Messages.ignoredObjectPrefListEditor_regular);
        isRegular.getColumn().setMoveable(true);
        isRegular.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                return ((IgnoredObject)element).isRegular() ? ballotBoxWithCheck : ballotBox;
            }
        });
        isRegular.setEditingSupport(new CheckEditingSupport(tableViewer, BooleanChangeValues.REGULAR));

        PixelConverter pc = new PixelConverter(tableViewer.getControl());
        name.getColumn().setWidth(pc.convertWidthInCharsToPixels(30));
        isRegular.getColumn().setWidth(pc.convertWidthInCharsToPixels(10));
    }
}
