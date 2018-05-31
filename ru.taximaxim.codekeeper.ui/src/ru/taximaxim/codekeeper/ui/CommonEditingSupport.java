package ru.taximaxim.codekeeper.ui;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;

public abstract class CommonEditingSupport<T extends CellEditor> extends EditingSupport {

    private final T cellEditor;

    public CommonEditingSupport(ColumnViewer viewer, T cellEditor) {
        super(viewer);
        this.cellEditor = cellEditor;
    }

    @Override
    protected T getCellEditor(Object element) {
        return cellEditor;
    }

    @Override
    protected boolean canEdit(Object element) {
        return true;
    }
}
