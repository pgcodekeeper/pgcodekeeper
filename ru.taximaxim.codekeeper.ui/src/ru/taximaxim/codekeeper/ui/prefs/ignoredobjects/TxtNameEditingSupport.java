package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import org.eclipse.jface.viewers.ColumnViewer;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoredObject;
import ru.taximaxim.codekeeper.ui.prefs.AbstractTxtEditingSupport;

public class TxtNameEditingSupport extends
AbstractTxtEditingSupport<IgnoredObject, IgnoredObjectPrefListEditor> {

    public TxtNameEditingSupport(ColumnViewer viewer,
            IgnoredObjectPrefListEditor ignoredObjectPrefListEditor) {
        super(viewer, ignoredObjectPrefListEditor, IgnoredObject.class);
    }

    @Override
    protected String getText(IgnoredObject obj) {
        return obj.getName();
    }

    @Override
    protected IgnoredObject getCopyWithNewTxt(IgnoredObject obj, String newText) {
        return obj.copy(newText);
    }
}
