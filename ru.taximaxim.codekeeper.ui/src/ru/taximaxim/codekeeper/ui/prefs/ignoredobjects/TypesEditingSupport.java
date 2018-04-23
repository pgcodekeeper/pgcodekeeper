package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoredObject;

class TypesEditingSupport extends EditingSupport {

    protected static final String COMBO_TYPE_ALL = "ALL";

    private final ComboBoxViewerCellEditor cellEditor;
    private final ColumnViewer viewer;

    public TypesEditingSupport(ColumnViewer viewer) {
        super(viewer);
        cellEditor = new ComboBoxViewerCellEditor((Composite) viewer.getControl(), SWT.READ_ONLY);
        cellEditor.setLabelProvider(new LabelProvider());
        cellEditor.setContentProvider(ArrayContentProvider.getInstance());
        cellEditor.setInput(comboTypes());
        this.viewer = viewer;
    }

    protected static List<String> comboTypes() {
        List<String> objTypes = new ArrayList<>();
        objTypes.add(COMBO_TYPE_ALL);
        objTypes.addAll(Arrays.stream(DbObjType.values())
                .filter(e -> e != DbObjType.DATABASE && e != DbObjType.COLUMN)
                .map(Enum::toString).sorted().collect(Collectors.toList()));
        return objTypes;
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
            List<String> typesList = data.getObjTypes();
            return typesList.isEmpty() ? TypesEditingSupport.COMBO_TYPE_ALL : typesList.get(0);
        }
        return null;
    }

    @Override
    protected void setValue(Object element, Object value) {
        if (element instanceof IgnoredObject && value instanceof String) {
            ((IgnoredObject) element).setObjTypes(Arrays.asList((String) value));
            viewer.refresh();
        }
    }
}
