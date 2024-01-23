/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ltk.core.refactoring.CheckConditionsOperation;
import org.eclipse.ltk.core.refactoring.PerformRefactoringOperation;
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ide.IDE;

import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;

public class PgRefactory {

    private static final PgRefactory INSTANCE = new PgRefactory();

    public static PgRefactory getInstance() {
        return INSTANCE;
    }

    private PgRefactory() {
        //empty private constructor
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

    public void fixFileName(PgObjLocation selection) throws CoreException {
        RenameDefinitionProcessor processor = new RenameDefinitionProcessor(selection);
        RenameRefactoring refactoring = new RenameRefactoring(processor);
        processor.setNewName(selection.getBareName());
        PerformRefactoringOperation op = new PerformRefactoringOperation(refactoring, CheckConditionsOperation.ALL_CONDITIONS);
        ResourcesPlugin.getWorkspace().run(op, new NullProgressMonitor());
        FileUtilsUi.getFileForLocation(selection).refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor());
    }
}
