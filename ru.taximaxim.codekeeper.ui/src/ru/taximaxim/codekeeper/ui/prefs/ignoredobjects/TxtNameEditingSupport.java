package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import java.util.ListIterator;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoredObject;
import ru.taximaxim.codekeeper.ui.CommonEditingSupport;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class TxtNameEditingSupport extends CommonEditingSupport<TextCellEditor> {

    private final IgnoredObjectPrefListEditor ignoredObjectPrefListEditor;

    public TxtNameEditingSupport(ColumnViewer viewer,
            IgnoredObjectPrefListEditor ignoredObjectPrefListEditor) {
        super(viewer, new TextCellEditor((Composite) viewer.getControl()));
        this.ignoredObjectPrefListEditor = ignoredObjectPrefListEditor;
    }

    @Override
    protected Object getValue(Object element) {
        if (element instanceof IgnoredObject) {
            return ((IgnoredObject) element).getName();
        }
        return null;
    }

    @Override
    protected void setValue(Object element, Object value) {
        if (element instanceof IgnoredObject && value instanceof String) {
            String text = (String) value;
            if (text.isEmpty()) {
                MessageBox mb = new MessageBox(getViewer().getControl().getShell(),
                        SWT.ICON_WARNING);
                mb.setText(Messages.PrefListEditor_cannot_add);
                mb.setMessage(Messages.txtNameEditingSupport_cannot_add_empty);
                mb.open();
                return;
            }

            ListIterator<IgnoredObject> ignoredObjsIter = ignoredObjectPrefListEditor
                    .getList().listIterator();
            while (ignoredObjsIter.hasNext()) {
                if (ignoredObjsIter.next().equals(element)) {
                    ignoredObjsIter.set(((IgnoredObject) element).copy(text));
                    break;
                }
            }
            getViewer().refresh();
        }
    }
}
