package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.TableViewer;

import ru.taximaxim.codekeeper.core.model.difftree.IgnoredObject;
import ru.taximaxim.codekeeper.ui.CommonEditingSupport;

public class CheckEditingSupport extends CommonEditingSupport<CheckboxCellEditor> {

    public enum BooleanChangeValues {
        REGULAR, IGNORE_CONTENT, QUALIFIED;
    }

    private final BooleanChangeValues type;

    public CheckEditingSupport(TableViewer tableViewer, BooleanChangeValues type) {
        super(tableViewer, new CheckboxCellEditor(tableViewer.getTable()));
        this.type = type;
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
            case QUALIFIED:
                return data.isQualified();
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
            case QUALIFIED:
                data.setQualified(boolValue);
                break;
            }
        }
        getViewer().update(element, null);
    }
}