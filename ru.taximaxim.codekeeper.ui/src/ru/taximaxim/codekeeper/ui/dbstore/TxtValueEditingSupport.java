package ru.taximaxim.codekeeper.ui.dbstore;

import java.util.Map.Entry;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

public class TxtValueEditingSupport extends EditingSupport {

    private final TextCellEditor cellEditor;
    private final ColumnViewer viewer;

    public TxtValueEditingSupport(ColumnViewer viewer) {
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
            viewer.refresh();
        }
    }
}
