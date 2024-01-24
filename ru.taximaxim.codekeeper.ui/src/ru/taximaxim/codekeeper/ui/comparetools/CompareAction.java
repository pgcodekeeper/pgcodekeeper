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
package ru.taximaxim.codekeeper.ui.comparetools;

import org.eclipse.compare.CompareUI;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IReusableEditor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;

public class CompareAction {

    public static void openCompareEditor(CompareInput input) {
        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        IEditorPart editor = findEditor(input, page);
        if (editor != null) {
            if (!editor.getEditorInput().equals(input)) {
                CompareUI.reuseCompareEditor(input, (IReusableEditor) editor);
            }
            page.activate(editor);
        } else {
            CompareUI.openCompareEditor(input);
        }
    }

    private static IEditorPart findEditor(CompareInput input, IWorkbenchPage page) {
        IEditorReference[] editorRefs = page.getEditorReferences();
        for (IEditorReference editorRef : editorRefs) {
            IEditorPart part = editorRef.getEditor(false);
            if (part instanceof IReusableEditor
                    && part.getEditorInput().equals(input)) {
                return part;
            }
        }

        if (Activator.getDefault().getPreferenceStore().getBoolean(PREF.REUSE_OPEN_COMPARE_EDITOR)) {
            for (IEditorReference editorRef : editorRefs) {
                IEditorPart part = editorRef.getEditor(false);
                if (part instanceof IReusableEditor
                        && part.getEditorInput() instanceof CompareInput) {
                    return part;
                }
            }
        }

        return null;
    }

    private CompareAction() {
    }
}
