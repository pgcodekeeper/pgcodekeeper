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
package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IProject;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.UIProjectLoader;
import ru.taximaxim.codekeeper.ui.search.ReferenceSearchQuery;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class FindReferences extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);

        if (activeEditor instanceof SQLEditor editor) {
            IProject proj = ((IFileEditorInput) editor.getEditorInput()).getFile().getProject();

            PgObjLocation ref = editor.getCurrentReference();
            if (ref != null) {
                NewSearchUI.activateSearchResultView();
                NewSearchUI.runQueryInBackground(new ReferenceSearchQuery(ref, proj));
            }
        }

        return null;
    }

    @Override
    public boolean isEnabled() {
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        return editor instanceof SQLEditor && UIProjectLoader.isInProject(editor.getEditorInput());
    }
}