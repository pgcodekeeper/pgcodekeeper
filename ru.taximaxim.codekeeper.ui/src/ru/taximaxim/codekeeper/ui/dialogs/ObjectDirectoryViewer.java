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

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ObjectDirectoryViewer {

    private static final int COLUMN_WIDTH = 250;

    private final Composite parent;
    private TableViewer tableViewer;
    private final Map<String, String> dirMappings;
    private final boolean isEditable;

    public ObjectDirectoryViewer(Composite parent, Map<String, String> dirMappings, boolean isEditable) {
        this.parent = parent;
        this.dirMappings = dirMappings;
        this.isEditable = isEditable;
    }

    public void createViewer() {
        tableViewer = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER | SWT.MULTI);
        tableViewer.getTable().setHeaderVisible(true);
        tableViewer.setContentProvider(new IStructuredContentProvider() {

            @Override
            public Object[] getElements(Object inputElement) {
                return dirMappings.entrySet().stream()
                        .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                        .toArray();
            }
        });

        addColumns();
        tableViewer.setInput(dirMappings);
    }

    public void setEnabled(boolean enabled) {
        tableViewer.getTable().setEnabled(enabled);
    }

    public void restoreDefaults(Map<String, String> defaults) {
        dirMappings.putAll(defaults);
        tableViewer.refresh();
    }

    @SuppressWarnings("unchecked")
    private void addColumns() {
        TableViewerColumn type = new TableViewerColumn(tableViewer, SWT.NONE);
        type.getColumn().setResizable(true);
        type.getColumn().setText(Messages.ObjectDirectoryViewer_object_type);
        type.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                return ((Entry<String, String>) element).getKey();
            }
        });

        TableViewerColumn dirName = new TableViewerColumn(tableViewer, SWT.LEFT);
        dirName.getColumn().setResizable(true);
        dirName.getColumn().setText(Messages.ObjectDirectoryViewer_object_directory);
        dirName.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                return ((Entry<String, String>) element).getValue();
            }
        });
        dirName.setEditingSupport(new DirEditingSupport(tableViewer));

        type.getColumn().setWidth(COLUMN_WIDTH);
        dirName.getColumn().setWidth(COLUMN_WIDTH);
    }

    private class DirEditingSupport extends EditingSupport {

        private final CellEditor editor;

        public DirEditingSupport(TableViewer viewer) {
            super(viewer);
            this.editor = new TextCellEditor(viewer.getTable());
        }

        @Override
        protected CellEditor getCellEditor(Object element) {
            return editor;
        }

        @Override
        protected boolean canEdit(Object element) {
            return isEditable;
        }

        @Override
        @SuppressWarnings("unchecked")
        protected Object getValue(Object element) {
            return ((Entry<String, String>) element).getValue();
        }

        @Override
        @SuppressWarnings("unchecked")
        protected void setValue(Object element, Object value) {
            var dirNameValue = (String) value;
            if (dirNameValue.isBlank()) {
                return;
            }

            var dirEntry = (Entry<String, String>) element;
            dirMappings.put(dirEntry.getKey(), dirNameValue);
            dirEntry.setValue(dirNameValue);
            tableViewer.update(element, null);
        }
    }
}
