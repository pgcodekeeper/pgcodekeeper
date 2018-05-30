package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoredObject;

public class TxtNameEditingSupport extends EditingSupport {

    private final TextCellEditor cellEditor;
    private final ColumnViewer viewer;

    public TxtNameEditingSupport(ColumnViewer viewer) {
        super(viewer);
        cellEditor = new TextCellEditor((Composite) viewer.getControl());
        this.viewer = viewer;
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
            ((IgnoredObject) element).setName((String) value);
            viewer.refresh();
        }
    }
}
