package ru.taximaxim.codekeeper.ui.prefs;

import java.text.MessageFormat;
import java.util.ListIterator;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;

import ru.taximaxim.codekeeper.ui.CommonEditingSupport;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public abstract class AbstractTxtEditingSupport<T, K extends PrefListEditor<T>>
extends CommonEditingSupport<TextCellEditor> {

    protected final Class<T> klass;
    private final K prefListEditor;

    public AbstractTxtEditingSupport(ColumnViewer viewer, K prefListEditor, Class<T> klass) {
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
        if (klass.isInstance(element) && value instanceof String) {
            T el = klass.cast(element);
            String newText = (String) value;

            // for case when text parameter has not changed
            if (newText.equalsIgnoreCase(getText(el))) {
                return;
            }

            // for case when text parameter is empty
            if (newText.isEmpty()) {
                MessageBox mb = new MessageBox(getViewer().getControl().getShell(),
                        SWT.ICON_WARNING);
                mb.setText(Messages.PrefListEditor_cannot_add);
                mb.setMessage(Messages.txtNameEditingSupport_cannot_add_empty);
                mb.open();
                return;
            }

            ListIterator<T> objsIter = prefListEditor.getList().listIterator();
            T copy = getCopyWithNewTxt(el, newText);

            // for the case when the text parameter has duplicate
            // do not warn for the element we currently edit
            while (objsIter.hasNext()) {
                T iterObj = objsIter.next();
                if (iterObj != el && prefListEditor.checkDuplicate(iterObj, copy)) {
                    MessageBox mb = new MessageBox(getViewer().getControl().getShell(),
                            SWT.ICON_WARNING);
                    mb.setText(Messages.PrefListEditor_cannot_add);
                    mb.setMessage(MessageFormat.format(
                            Messages.IgnoredObjectPrefListEditor_already_present, newText));
                    mb.open();
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
