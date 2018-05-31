package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoredObject;
import ru.taximaxim.codekeeper.ui.CommonEditingSupport;

class TypesEditingSupport extends CommonEditingSupport<ComboBoxViewerCellEditor> {

    protected static final String COMBO_TYPE_ALL = "ANY"; //$NON-NLS-1$

    public TypesEditingSupport(ColumnViewer viewer) {
        super(viewer, new ComboBoxViewerCellEditor((Composite) viewer.getControl(), SWT.READ_ONLY));
        ComboBoxViewerCellEditor cellEditor = getCellEditor(null);
        cellEditor.setLabelProvider(new LabelProvider());
        cellEditor.setContentProvider(ArrayContentProvider.getInstance());
        cellEditor.setInput(comboTypes());
    }

    protected static List<String> comboTypes() {
        List<String> objTypes = new ArrayList<>();
        objTypes.add(COMBO_TYPE_ALL);
        objTypes.addAll(EnumSet.complementOf(EnumSet.of(DbObjType.DATABASE, DbObjType.COLUMN))
                .stream().map(Enum::toString).sorted().collect(Collectors.toList()));

        return objTypes;
    }

    @Override
    protected Object getValue(Object element) {
        if (element instanceof IgnoredObject) {
            IgnoredObject data = (IgnoredObject)element;
            Set<DbObjType> typesList = data.getObjTypes();
            return typesList.isEmpty() ? TypesEditingSupport.COMBO_TYPE_ALL : typesList.iterator().next();
        }
        return null;
    }

    @Override
    protected void setValue(Object element, Object value) {
        if (element instanceof IgnoredObject && value instanceof String) {
            String type = (String) value;
            ((IgnoredObject) element).setObjTypes(COMBO_TYPE_ALL.equals(type) ?
                    EnumSet.noneOf(DbObjType.class) : EnumSet.of(DbObjType.valueOf(type)));
            getViewer().refresh();
        }
    }
}
