package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import java.util.List;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoredObject;

public class TxtNameEditingSupport extends EditingSupport {

    private final TextCellEditor cellEditor;
    private final ColumnViewer viewer;
    private final IgnoredObjectPrefListEditor ignoredObjectPrefListEditor;

    public TxtNameEditingSupport(ColumnViewer viewer,
            IgnoredObjectPrefListEditor ignoredObjectPrefListEditor) {
        super(viewer);
        cellEditor = new TextCellEditor((Composite) viewer.getControl());
        this.viewer = viewer;
        this.ignoredObjectPrefListEditor = ignoredObjectPrefListEditor;
    }

    @Override
    protected CellEditor getCellEditor(Object element) {
        return cellEditor;
    }

    @Override
    protected boolean canEdit(Object element) {
        return true;
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
            viewer.refresh();
        }
    }
}
