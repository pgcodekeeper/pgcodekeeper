package ru.taximaxim.codekeeper.ui.pgdbproject;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class MockDataWizard extends Wizard implements INewWizard {

    private MockDataPage page;
    private IStructuredSelection selection;
    private boolean isMsSql;

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.selection = selection;
        setDefaultPageImageDescriptor(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(FILE.ICONAPPWIZ)));
        try {
            Object element = selection.getFirstElement();
            if (element instanceof IResource) {
                isMsSql = ((IResource)element).getProject().hasNature(NATURE.MS);
            }
        } catch (CoreException ex) {
            Log.log(ex);
        }
    }

    @Override
    public boolean performFinish() {
        return page.createFile(isMsSql);
    }

    @Override
    public void addPages() {
        setWindowTitle(Messages.MockDataWizard_create_data);
        page = new MockDataPage(Messages.MockDataWizard_create_data_table, selection);
        addPage(page);
    }
}
