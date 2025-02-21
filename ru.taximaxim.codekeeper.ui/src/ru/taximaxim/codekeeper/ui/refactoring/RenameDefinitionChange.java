/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.refactoring;

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
        IResource newRes = getModifiedResource().getParent().findMember(newName);
        if (newRes != null) {
            result.addFatalError(Messages.RenameDefinitionChange_error_resource_already_exists);
        }
        return result;
    }

}
