package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.IgnoredObjectPrefListEditor.BooleanChangeValues;

class YesNoEditingSupport extends EditingSupport {
    
    enum Values {
        NO(Messages.yesNoEditingSupport_no),
        YES(Messages.yesNoEditingSupport_yes);
        
        private String localizedName;
        
        private Values(String localizedName) {
            this.localizedName = localizedName;
        }
        @Override
        public String toString() {
            return localizedName;
        }
    }

    private ComboBoxViewerCellEditor cellEditor;
    private BooleanChangeValues type;
    private ColumnViewer viewer;
    
    public YesNoEditingSupport(ColumnViewer viewer, BooleanChangeValues type) {
        super(viewer);
        cellEditor = new ComboBoxViewerCellEditor((Composite) getViewer().getControl(), SWT.READ_ONLY);
        cellEditor.setLabelProvider(new LabelProvider());
        cellEditor.setContentProvider(new ArrayContentProvider());
        cellEditor.setInput(Values.values());
        this.type = type;
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
            IgnoredObject data = (IgnoredObject)element;
            return data.isRegular();
        }
        return null;
    }

    @Override
    protected void setValue(Object element, Object value) {
        if (element instanceof IgnoredObject && value instanceof Values) {
            IgnoredObject data = (IgnoredObject) element;
            Values newValue = (Values) value;
            boolean boolValue = newValue == Values.NO ? false : true;
            switch (type) {
            case IGNORE_CONTENT:
                if (data.isIgnoreContent() != boolValue) {
                    data.setIgnoreContent(boolValue);
                }
                break;
            case REGULAR:
                if (data.isRegular() != boolValue) {
                    data.setRegular(boolValue);
                }
                break;
            }
            viewer.refresh();
        }
    }
}

