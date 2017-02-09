package ru.taximaxim.codekeeper.ui.pgdbproject;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

public class ImportProjWizard extends Wizard implements IImportWizard {

    private PgImport pageOne;

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        //nothing to initialize
    }

    @Override
    public boolean performFinish() {
        return pageOne.createProject();
    }

    @Override
    public void addPages() {
        pageOne = new PgImport("import page");
        addPage(pageOne);
    }
}
