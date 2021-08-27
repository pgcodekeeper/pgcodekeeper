package ru.taximaxim.codekeeper.ui.refactoring;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ide.IDE;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;

public class PgRefactory {

    private static final PgRefactory INSTANCE = new PgRefactory();

    public static PgRefactory getInstance() {
        return INSTANCE;
    }

    public void rename(Shell shell, PgObjLocation selection) {
        IFile file = FileUtilsUi.getFileForLocation(selection);
        if (file == null || !IDE.saveAllEditors(new IResource[] { file.getProject() }, true)) {
            return;
        }

        RenameDefinitionProcessor processor = new RenameDefinitionProcessor(selection);
        RenameRefactoring refactoring = new RenameRefactoring(processor);
        PgRenameRefactoringWizard wizard = new PgRenameRefactoringWizard(refactoring);
        RefactoringWizardOpenOperation op = new RefactoringWizardOpenOperation(wizard);

        try {
            op.run(shell, "Rename"); //$NON-NLS-1$
        } catch (InterruptedException e) {
            // cancelled
        }
    }
}
