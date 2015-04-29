package ru.taximaxim.codekeeper.ui.prefs;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

public class StringPrefListEditor extends PrefListEditor<String> {

    public StringPrefListEditor(Composite parent, boolean doSorting) {
        super(parent, doSorting);
    }

    @Override
    protected String getObject(String name) {
        return name;
    }

    @Override
    protected void createViewer(Composite parent) {
        viewerObjs = new ListViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        viewerObjs.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

        viewerObjs.setContentProvider(new ArrayContentProvider());
        viewerObjs.setLabelProvider(new LabelProvider());
    }
}
