package ru.taximaxim.codekeeper.ui.pgdbproject;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class MockDataWizard extends Wizard implements INewWizard {

    private MockDataPage page;
    private IStructuredSelection selection;

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.selection = selection;
    }

    @Override
    public boolean performFinish() {
        return page.createFile();
    }

    @Override
    public void addPages() {
        setWindowTitle("Создать данные");
        page = new MockDataPage("Создать данные для таблицы", selection);
        addPage(page);
    }
}
