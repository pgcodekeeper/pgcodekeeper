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
package ru.taximaxim.codekeeper.ui.dbstore;

import java.util.Map.Entry;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.ui.CommonEditingSupport;

public class TxtValueEditingSupport extends CommonEditingSupport<TextCellEditor> {

    public TxtValueEditingSupport(ColumnViewer viewer) {
        super(viewer, new TextCellEditor((Composite) viewer.getControl()));
    }

    @Override
    protected Object getValue(Object element) {
        if (element instanceof Entry) {
            Entry<?, ?> data = (Entry<?, ?>) element;
            return data.getValue();
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void setValue(Object element, Object value) {
        if (element instanceof Entry && value instanceof String) {
            ((Entry<String, String>) element).setValue((String) value);
            getViewer().refresh();
        }
    }
}
