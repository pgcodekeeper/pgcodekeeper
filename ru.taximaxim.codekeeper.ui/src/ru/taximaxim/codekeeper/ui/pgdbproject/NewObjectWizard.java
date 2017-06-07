package ru.taximaxim.codekeeper.ui.pgdbproject;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class NewObjectWizard extends Wizard implements INewWizard {

    private PgObject pageOne;
    private IStructuredSelection selection;

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.selection = selection;
    }

    @Override
    public boolean performFinish() {
        return pageOne.createFile();
    }

    @Override
    public void addPages() {
        setWindowTitle(Messages.PgObject_wizard_title);
        pageOne = new PgObject(Messages.PgObject_create_object, selection);
        addPage(pageOne);
    }
}
