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
package ru.taximaxim.codekeeper.ui.propertytests;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.ResourceUtil;

import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class ChangesJobTester extends SingletonJobTester {

    private static final String PROP = "isGetChangesRunning"; //$NON-NLS-1$
    public static final String EVAL_PROP = makeEvalProperty(PROP);

    @Override
    public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
        Object editor = receiver;
        if (editor instanceof SQLEditor sqlEditor) {
            editor = findProjectEditor(sqlEditor);
        }
        return editor != null && super.test(editor, property, args, expectedValue);
    }

    private static ProjectEditorDiffer findProjectEditor(SQLEditor editor) {
        IFile file = ResourceUtil.getFile(editor.getEditorInput());
        return file == null ? null : findProjectEditor(file.getProject());
    }

    public static ProjectEditorDiffer findProjectEditor(IProject proj) {
        for (IWorkbenchWindow w : PlatformUI.getWorkbench().getWorkbenchWindows()) {
            for (IWorkbenchPage p : w.getPages()) {
                for (IEditorReference e : p.getEditorReferences()) {
                    if (EDITOR.PROJECT.equals(e.getId())) {
                        ProjectEditorDiffer projEditor = (ProjectEditorDiffer) e.getEditor(false);
                        if (projEditor != null && projEditor.getProject().equals(proj)) {
                            return projEditor;
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String getProperty() {
        return PROP;
    }

    @Override
    public String getEvalProperty() {
        return EVAL_PROP;
    }
}
