package ru.taximaxim.codekeeper.ui.prefs;

import java.text.MessageFormat;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

public class StringPrefListEditor extends PrefListEditor<String, ListViewer> {

    private final int viewerWidthHint;

    public StringPrefListEditor(Composite parent, boolean doSorting, boolean noMargins,
            int viewerWidthHint) {
        super(parent, doSorting, false, noMargins);
        this.viewerWidthHint = viewerWidthHint;
    }

    @Override
    protected String getNewObject(String oldObject) {
        InputDialog d = new InputDialog(getShell(), "New string...", "New string:", oldObject, null);
        return d.open() == InputDialog.OK ? d.getValue() : null;
    }

    @Override
    protected String errorAlreadyExists(String obj) {
        return MessageFormat.format("Element \"{0}\" is already present in the list!", obj);
    }

    @Override
    protected ListViewer createViewer(Composite parent) {
        ListViewer viewerObjs = new ListViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        GridData gd =  new GridData(SWT.FILL, SWT.FILL, true, true, 1, 4);
        gd.widthHint = viewerWidthHint;
        viewerObjs.getControl().setLayoutData(gd);

        viewerObjs.setContentProvider(ArrayContentProvider.getInstance());
        viewerObjs.setLabelProvider(new LabelProvider());
        return viewerObjs;
    }
}
