package ru.taximaxim.codekeeper.ui.pgdbproject;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class MockDataWizard extends Wizard implements INewWizard {

    private static String PART_ID_PROJECT_EXPLORER = "org.eclipse.ui.navigator.ProjectExplorer";
    private static String PART_ID_NAVIGATOR = "org.eclipse.ui.views.ResourceNavigator";

    private MockDataPage page;
    private IStructuredSelection selection;
    private IProject proj;

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.selection = selection;
        setDefaultPageImageDescriptor(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(FILE.ICONAPPWIZ)));
        defineProj(workbench, selection);
    }

    private void defineProj(IWorkbench workbench, IStructuredSelection selection) {
        Object element = selection.getFirstElement();

        if (element instanceof IResource) {
            // Getting IProject-object from directly selected element.
            proj = ((IResource)element).getProject();
        } else {
            // Getting IProject-object from 'ProjectExplorer' or 'Navigator' which already had selection.

            ISelectionService selectionService = PlatformUI.getWorkbench()
                    .getActiveWorkbenchWindow().getActivePage();
            ISelection selectionTree = selectionService.getSelection(PART_ID_PROJECT_EXPLORER);

            if (selectionTree == null) {
                selectionTree = selectionService.getSelection(PART_ID_NAVIGATOR);
            }

            if (selectionTree != null && selectionTree instanceof IStructuredSelection) {
                Object obj = ((IStructuredSelection)selectionTree).getFirstElement();
                if (obj instanceof IResource) {
                    proj = ((IResource)obj).getProject();
                }
            }
        }
    }

    @Override
    public boolean performFinish() {
        return page.createFile(proj);
    }

    @Override
    public void addPages() {
        if (proj == null) {
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_INFORMATION);
            mb.setText(Messages.MockDataPage_select_project);
            mb.setMessage(Messages.MockDataPage_select_project_msg);
            mb.open();
            getContainer().getShell().close();
            return;
        }
        setWindowTitle(Messages.MockDataWizard_create_data);
        page = new MockDataPage(Messages.MockDataWizard_create_data_table, selection);
        addPage(page);
    }
}
