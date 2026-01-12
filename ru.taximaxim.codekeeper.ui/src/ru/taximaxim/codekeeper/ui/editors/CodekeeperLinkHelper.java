/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.editors;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.navigator.ILinkHelper;

import ru.taximaxim.codekeeper.ui.libraries.FileLibrary;
import ru.taximaxim.codekeeper.ui.libraries.LibraryStorage;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorInput;

public class CodekeeperLinkHelper implements ILinkHelper {

    @Override
    public IStructuredSelection findSelection(IEditorInput anInput) {
        // TODO expand tree and populate library objects before?
        if (anInput instanceof ProjectEditorInput in) {
            return new StructuredSelection(in.getProject());
        }

        if (anInput instanceof SQLEditorInput input && input.isReadOnly()) {
            var selection = LibraryStorage.getLibrary(input.getPath().toString());
            if (selection != null) {
                return new StructuredSelection(selection);
            }
        }

        return StructuredSelection.EMPTY;
    }

    @Override
    public void activateEditor(IWorkbenchPage aPage, IStructuredSelection aSelection) {
        if (aSelection == null || aSelection.isEmpty()) {
            return;
        }
        IEditorInput input = null;
        Object element = aSelection.getFirstElement();
        if (element instanceof IProject proj) {
            input = new ProjectEditorInput(proj.getName());
        } else if (element instanceof FileLibrary lib) {
            input = new SQLEditorInput(lib.getPath(), lib.getProject(), lib.getDbType(), true);
        }
        if (input == null) {
            return;
        }
        IEditorPart editor = aPage.findEditor(input);
        if (editor != null) {
            aPage.activate(editor);
        }
    }
}
