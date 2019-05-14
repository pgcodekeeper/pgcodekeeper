package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import org.eclipse.jface.viewers.ColumnViewer;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoredObject;
import ru.taximaxim.codekeeper.ui.prefs.AbstractTxtEditingSupport;

public class TxtNameEditingSupport extends
AbstractTxtEditingSupport<IgnoredObject, IgnoredObjectPrefListEditor> {

    public TxtNameEditingSupport(ColumnViewer viewer,
            IgnoredObjectPrefListEditor ignoredObjectPrefListEditor) {
        super(viewer, ignoredObjectPrefListEditor);
    }

    @Override
    protected boolean checkInstance(Object obj) {
        return obj instanceof IgnoredObject;
    }

    @Override
    protected String getText(Object obj) {
        return ((IgnoredObject) obj).getName();
    }

    @Override
    protected boolean checkEquals(IgnoredObject obj, Object selectedObj) {
        return obj.equals(selectedObj);
    }

    @Override
    protected IgnoredObject getCopyWithNewTxt(Object obj, String newText) {
        return ((IgnoredObject) obj).copy(newText);
    }
}
