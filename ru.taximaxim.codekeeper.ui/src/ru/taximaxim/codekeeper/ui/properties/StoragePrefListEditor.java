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

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;

import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;

public class StoragePrefListEditor extends PrefListEditor<String> {

    public StoragePrefListEditor(Composite parent) {
        super(parent);
    }

    @Override
    protected void addColumns(TableViewer tableViewer) {
        TableViewerColumn col = new TableViewerColumn(tableViewer, SWT.NONE);
        col.setLabelProvider(new ColumnLabelProvider());
    }

    @Override
    protected String getNewObject(String oldObject) {
        FileDialog fd = new FileDialog(getShell(), SWT.OPEN);
        fd.setText(Messages.StoragePrefListEditor_open_snapshot);
        String[] filterExt = {"*.ser"}; //$NON-NLS-1$
        fd.setFilterExtensions(filterExt);
        return fd.open();
    }

    @Override
    protected String errorAlreadyExists(String obj) {
        return Messages.StoragePrefListEditor_file_already_added;
    }
}
