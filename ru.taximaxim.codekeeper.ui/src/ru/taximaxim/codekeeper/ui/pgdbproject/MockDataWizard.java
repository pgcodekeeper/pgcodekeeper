package ru.taximaxim.codekeeper.ui.pgdbproject;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class MockDataWizard extends Wizard implements INewWizard {

    private MockDataPage page;
    private IStructuredSelection selection;

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.selection = selection;
        setDefaultPageImageDescriptor(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(FILE.ICONAPPWIZ)));
    }

    @Override
    public boolean performFinish() {
        return page.createFile();
    }

    @Override
    public void addPages() {
        setWindowTitle(Messages.MockDataWizard_create_data);
        page = new MockDataPage(Messages.MockDataWizard_create_data_table, selection);
        addPage(page);
    }
}
