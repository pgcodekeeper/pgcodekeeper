package ru.taximaxim.codekeeper.ui.refactoring;

import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;

public class PgRenameRefactoringWizard extends RefactoringWizard {

    public PgRenameRefactoringWizard(Refactoring refactoring) {
        super(refactoring, DIALOG_BASED_USER_INTERFACE);
    }

    @Override
    protected void addUserInputPages() {
        setDefaultPageTitle(getRefactoring().getName());
        addPage(new PgRenameRefactoringInputPage());
    }
}
