package ru.taximaxim.codekeeper.ui.pgdbproject;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ImportProjWizard extends Wizard implements IImportWizard {

    private PgImport pageOne;
    private IStructuredSelection selection;

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.selection = selection;
    }

    @Override
    public boolean performFinish() {
        return pageOne.createProject();
    }

    @Override
    public void addPages() {
        setWindowTitle(Messages.ImportProjWizard_title);
        pageOne = new PgImport("import page", selection); //$NON-NLS-1$
        addPage(pageOne);
    }
}
