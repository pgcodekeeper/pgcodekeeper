package ru.taximaxim.codekeeper.ui.prefs;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class SQLEditorMainPage extends PreferencePage implements
        IWorkbenchPreferencePage {

    public SQLEditorMainPage() {
        // TODO Auto-generated constructor stub
    }

    public SQLEditorMainPage(String title) {
        super(title);
        // TODO Auto-generated constructor stub
    }

    public SQLEditorMainPage(String title, ImageDescriptor image) {
        super(title, image);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(IWorkbench workbench) {
        // TODO Auto-generated method stub
    }

    @Override
    protected Control createContents(Composite parent) {
        // TODO Auto-generated method stub
        return new Composite(parent, SWT.NONE);
    }

}
