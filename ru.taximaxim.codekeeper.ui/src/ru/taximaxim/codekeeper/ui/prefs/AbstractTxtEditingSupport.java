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
package ru.taximaxim.codekeeper.ui.prefs;

import java.util.ListIterator;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;
import ru.taximaxim.codekeeper.ui.CommonEditingSupport;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public abstract class AbstractTxtEditingSupport<T, K extends PrefListEditor<T>>
extends CommonEditingSupport<TextCellEditor> {

    protected final Class<T> klass;
    private final K prefListEditor;

    protected AbstractTxtEditingSupport(ColumnViewer viewer, K prefListEditor, Class<T> klass) {
        super(viewer, new TextCellEditor((Composite) viewer.getControl()));
        this.klass = klass;
        this.prefListEditor = prefListEditor;
    }

    @Override
    protected Object getValue(Object element) {
        if (klass.isInstance(element)) {
            return getText(klass.cast(element));
        }
        return null;
    }

    @Override
    protected void setValue(Object element, Object value) {
        if (klass.isInstance(element) && value instanceof String newText) {
            T el = klass.cast(element);
            // for case when text parameter has not changed
            if (newText.equalsIgnoreCase(getText(el))) {
                return;
            }

            // for case when text parameter is empty
            if (newText.isEmpty()) {
                MessageDialog.openWarning(getViewer().getControl().getShell(),
                        Messages.PrefListEditor_cannot_add, Messages.txtNameEditingSupport_cannot_add_empty);
                return;
            }

            ListIterator<T> objsIter = prefListEditor.getList().listIterator();
            T copy = getCopyWithNewTxt(el, newText);

            // for the case when the text parameter has duplicate
            // do not warn for the element we currently edit
            while (objsIter.hasNext()) {
                T iterObj = objsIter.next();
                if (iterObj != el && prefListEditor.checkDuplicate(iterObj, copy)) {
                    MessageDialog.openWarning(getViewer().getControl().getShell(), Messages.PrefListEditor_cannot_add,
                            Messages.IgnoredObjectPrefListEditor_already_present.formatted(newText));
                    return;
                }
            }

            while (objsIter.hasPrevious()) {
                if (objsIter.previous() == el) {
                    objsIter.set(copy);
                    break;
                }
            }
            getViewer().refresh();
        }
    }

    /**
     * Returns text of editable field.
     *
     * @param obj object which contains text of editable field.
     * @return text of editable field
     */
    protected abstract String getText(T obj);

    /**
     * Returns copy of given object with new text parameter.
     */
    protected abstract T getCopyWithNewTxt(T obj, String newText);
}
