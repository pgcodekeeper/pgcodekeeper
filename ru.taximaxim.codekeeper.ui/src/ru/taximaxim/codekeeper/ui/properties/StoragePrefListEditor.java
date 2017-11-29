package ru.taximaxim.codekeeper.ui.properties;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;

import ru.taximaxim.codekeeper.ui.UIConsts.PREF_PAGE;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;

public class StoragePrefListEditor extends PrefListEditor<String, ListViewer> {

    public StoragePrefListEditor(Composite parent) {
        super(parent, true, false, true);
    }

    @Override
    protected ListViewer createViewer(Composite parent) {
        ListViewer viewerObjs = new ListViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        GridData gd =  new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2);
        gd.widthHint = PREF_PAGE.WIDTH_HINT_PX;
        viewerObjs.getControl().setLayoutData(gd);

        viewerObjs.setContentProvider(ArrayContentProvider.getInstance());
        viewerObjs.setLabelProvider(new LabelProvider());
        return viewerObjs;
    }

    @Override
    protected String getNewObject(String oldObject) {
        FileDialog fd = new FileDialog(getShell(), SWT.OPEN);
        fd.setText("Open storage");
        String[] filterExt = {"*.ser"};
        fd.setFilterExtensions(filterExt);
        return fd.open();
    }

    @Override
    protected String errorAlreadyExists(String obj) {
        return "This file is already exists";
    }
}
