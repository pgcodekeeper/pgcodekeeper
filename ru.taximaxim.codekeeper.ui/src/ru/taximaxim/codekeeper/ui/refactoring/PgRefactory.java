package ru.taximaxim.codekeeper.ui.refactoring;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ide.IDE;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;

public class PgRefactory {

    private static final PgRefactory INSTANCE = new PgRefactory();

    public static PgRefactory getInstance() {
        return INSTANCE;
    }

    public void rename(Shell shell, PgObjLocation selection) {
        if (!IDE.saveAllEditors(new IResource[] { ResourcesPlugin.getWorkspace().getRoot() }, false)) {
            return;
        }

        RenameDefinitionProcessor processor = new RenameDefinitionProcessor(selection);
        RenameRefactoring refactoring = new RenameRefactoring(processor);
        PgRenameRefactoringWizard wizard = new PgRenameRefactoringWizard(refactoring);
        RefactoringWizardOpenOperation op = new RefactoringWizardOpenOperation(wizard);

        try {
            op.run(shell, "Rename"); //$NON-NLS-1$
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
