package ru.taximaxim.codekeeper.ui.dbstore;

import java.util.Map.Entry;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.ui.CommonEditingSupport;

public class TxtValueEditingSupport extends CommonEditingSupport<TextCellEditor> {

    public TxtValueEditingSupport(ColumnViewer viewer) {
        super(viewer, new TextCellEditor((Composite) viewer.getControl()));
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
            getViewer().refresh();
        }
    }
}
