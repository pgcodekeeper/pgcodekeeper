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
package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.pgcodekeeper.core.model.difftree.IgnoredObject;

import ru.taximaxim.codekeeper.ui.CommonEditingSupport;

public class CheckEditingSupport extends CommonEditingSupport<CheckboxCellEditor> {

    public enum BooleanChangeValues {
        REGULAR, IGNORE_CONTENT, QUALIFIED;
    }

    private final BooleanChangeValues type;

    public CheckEditingSupport(TableViewer tableViewer, BooleanChangeValues type) {
        super(tableViewer, new CheckboxCellEditor(tableViewer.getTable()));
        this.type = type;
    }

    @Override
    protected Object getValue(Object element) {
        if (element instanceof IgnoredObject data) {
            switch (type) {
            case IGNORE_CONTENT:
                return data.isIgnoreContent();
            case REGULAR:
                return data.isRegular();
            case QUALIFIED:
                return data.isQualified();
            }
        }
        return null;
    }

    @Override
    protected void setValue(Object element, Object value) {
        if (element instanceof IgnoredObject data) {
            boolean boolValue = (Boolean) value;
            switch (type) {
            case IGNORE_CONTENT:
                data.setIgnoreContent(boolValue);
                break;
            case REGULAR:
                data.setRegular(boolValue);
                break;
            case QUALIFIED:
                data.setQualified(boolValue);
                break;
            }
        }
        getViewer().update(element, null);
    }
}