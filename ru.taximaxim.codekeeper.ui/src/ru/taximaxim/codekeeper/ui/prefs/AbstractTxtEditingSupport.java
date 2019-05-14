package ru.taximaxim.codekeeper.ui.prefs;

import java.text.MessageFormat;
import java.util.ListIterator;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;

import ru.taximaxim.codekeeper.ui.CommonEditingSupport;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public abstract class AbstractTxtEditingSupport<T, K extends PrefListEditor<T, TableViewer>>
extends CommonEditingSupport<TextCellEditor> {

    private final K prefListEditor;

    public AbstractTxtEditingSupport(ColumnViewer viewer, K prefListEditor) {
        super(viewer, new TextCellEditor((Composite) viewer.getControl()));
        this.prefListEditor = prefListEditor;
    }

    @Override
    protected Object getValue(Object element) {
        if (checkInstance(element)) {
            return getText(element);
        }
        return null;
    }

    @Override
    protected void setValue(Object element, Object value) {
        if (checkInstance(element) && value instanceof String) {
            String newText = ((String) value);

            // for case when text parameter has not changed
            if (newText.equalsIgnoreCase(getText(element))) {
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

            // for the case when the text parameter has duplicate
            while (objsIter.hasNext()) {
                T iterObj = objsIter.next();
                if (!checkEquals(iterObj, element) && newText.equals(getText(iterObj))) {
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
                if (checkEquals(objsIter.previous(), element)) {
                    objsIter.set(getCopyWithNewTxt(element, newText));
                    break;
                }
            }
            getViewer().refresh();
        }
    }

    /**
     * Checks if the given object is an instance of a T-class.
     *
     * @param obj given object
     * @return true if it is an instance of a T-class
     */
    protected abstract boolean checkInstance(Object obj);

    /**
     * Returns text of editable field.
     *
     * @param obj object which contains text of editable field.
     * @return text of editable field
     */
    protected abstract String getText(Object obj);

    /**
     * Checks equals between the 'obj' and 'selectedObj' objects.
     *
     * @param obj object to compare
     * @param selectedObj selected object from list editor
     * @return true if object is equals
     */
    protected abstract boolean checkEquals(T obj, Object selectedObj);

    /**
     * Returns copy of given object with new text parameter.
     */
    protected abstract T getCopyWithNewTxt(Object obj, String newText);
}
