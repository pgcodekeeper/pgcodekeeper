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
package ru.taximaxim.codekeeper.ui.editors;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.navigator.ILinkHelper;

import ru.taximaxim.codekeeper.ui.libraries.AbstractLibrary;
import ru.taximaxim.codekeeper.ui.libraries.FileLibrary;
import ru.taximaxim.codekeeper.ui.libraries.RootLibrary;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorInput;

public class CodekeeperLinkHelper implements ILinkHelper {

    @Override
    public IStructuredSelection findSelection(IEditorInput anInput) {
        // TODO expand tree and populate library objects before?
        if (anInput instanceof ProjectEditorInput in) {
            return new StructuredSelection(in.getProject());
        }

        return getSelection(anInput);
    }

    private StructuredSelection getSelection(IEditorInput anInput) {
        if (anInput instanceof SQLEditorInput input && input.isReadOnly()) {
            var inputPath = input.getPath();
            var root = RootLibrary.getRootLib(input.getProject());
            var children = root.getChildren().stream().filter(e -> inputPath.toString().contains(e.getName())).toList();

            var selection = getNestedLib(children, input.getPath());
            if (selection != null) {
                return new StructuredSelection(selection);
            }
        }

        return StructuredSelection.EMPTY;
    }

    private AbstractLibrary getNestedLib(List<AbstractLibrary> children, Path inputPath) {
        for (var child : children) {
            if (child instanceof FileLibrary) {
                if (Objects.equals(child.getPath(), inputPath)) {
                    return child;
                }
            } else {
                var lib = getNestedLib(child.getChildren(), inputPath);
                if (null != lib) {
                    return lib;
                }
            }
        }

        return null;
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
