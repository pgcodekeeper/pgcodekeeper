package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import java.util.List;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoredObject;
import ru.taximaxim.codekeeper.ui.CommonEditingSupport;

public class TxtNameEditingSupport extends CommonEditingSupport<TextCellEditor> {

    private final IgnoredObjectPrefListEditor ignoredObjectPrefListEditor;

    public TxtNameEditingSupport(ColumnViewer viewer,
            IgnoredObjectPrefListEditor ignoredObjectPrefListEditor) {
        super(viewer);
        cellEditor = new TextCellEditor((Composite) viewer.getControl());
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
            IgnoredObject newObjWithNewName = ((IgnoredObject) element).createSameObjWithName((String) value);
            List<IgnoredObject> ignoredObjectList = ignoredObjectPrefListEditor.getList();
            ignoredObjectList.remove(element);
            ignoredObjectList.add(newObjWithNewName);
            getViewer().refresh();
        }
    }
}
