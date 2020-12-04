package ru.taximaxim.codekeeper.ui.refactoring;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.resource.RenameResourceChange;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class RenameDefinitionChange extends RenameResourceChange {
    private final String newName;

    public RenameDefinitionChange(IPath resourcePath, String newName) {
        super(resourcePath, newName);
        this.newName = newName;
    }

    @Override
    public RefactoringStatus isValid(IProgressMonitor pm)
            throws CoreException, OperationCanceledException {
        RefactoringStatus result = super.isValid(pm);
        if (result.hasFatalError()) {
            return result;
        }
        IContainer c= getModifiedResource().getParent();
        for (IResource member : c.members()) {
            if (member.getName().equals(newName)) {
                result.addFatalError(Messages.RenameDefinitionChange_error_resource_already_exists);
            }
        }
        return result;
    }

}
