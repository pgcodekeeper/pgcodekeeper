package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoredObject;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.IgnoredObjectPrefListEditor.BooleanChangeValues;

public class CheckEditingSupport extends EditingSupport {
    private final CheckboxCellEditor cellEditor;
    private final BooleanChangeValues type;

    public CheckEditingSupport(ColumnViewer viewer, BooleanChangeValues type) {
        super(viewer);
        cellEditor = new CheckboxCellEditor(((TableViewer)viewer).getTable());
        this.type = type;
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
            IgnoredObject data = (IgnoredObject) element;
            switch (type) {
            case IGNORE_CONTENT:
                return data.isIgnoreContent();
            case REGULAR:
                return data.isRegular();
            }
        }
        return null;
    }

    @Override
    protected void setValue(Object element, Object value) {
        if (element instanceof IgnoredObject) {
            IgnoredObject data = (IgnoredObject) element;
            boolean boolValue = (Boolean) value;
            switch (type) {
            case IGNORE_CONTENT:
                data.setIgnoreContent(boolValue);
                break;
            case REGULAR:
                data.setRegular(boolValue);
                break;
            }
        }
        getViewer().update(element, null);
    }
}