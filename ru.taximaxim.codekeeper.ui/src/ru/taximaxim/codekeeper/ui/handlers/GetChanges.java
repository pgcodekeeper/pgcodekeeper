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
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorInput;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.UIProjectLoader;
import ru.taximaxim.codekeeper.ui.propertytests.ChangesJobTester;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class GetChanges extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        IEditorPart part = HandlerUtil.getActiveEditor(event);

        if (part instanceof ProjectEditorDiffer projEditor) {
            projEditor.getChanges();
        } else if (part instanceof SQLEditor sqlEditor && part.getEditorInput() instanceof IFileEditorInput) {
            try {
                IProject proj = ((IFileEditorInput) sqlEditor.getEditorInput()).getFile().getProject();

                DbInfo remote = sqlEditor.getCurrentDb();
                if (remote == null) {
                    MessageBox mb = new MessageBox(HandlerUtil.getActiveShell(event), SWT.ICON_INFORMATION);
                    mb.setText(Messages.UpdateDdl_select_source);
                    mb.setMessage(Messages.UpdateDdl_select_source_msg);
                    mb.open();
                    return null;
                }
                ProjectEditorDiffer editor = ChangesJobTester.findProjectEditor(proj);
                if (editor == null) {
                    ProjectEditorDiffer.saveLastDb(remote, proj);
                    ProjectEditorInput projectEditorInput = new ProjectEditorInput(proj.getName());
                    editor = (ProjectEditorDiffer) sqlEditor.getSite().getPage()
                            .openEditor(projectEditorInput, EDITOR.PROJECT);
                } else {
                    editor.setCurrentDb(remote);
                    editor.getSite().getPage().activate(editor);
                }
                editor.getChanges();
            } catch (PartInitException e) {
                ExceptionNotifier.notifyDefault(e.getLocalizedMessage(), e);
            }
        }
        return null;
    }

    @Override
    public boolean isEnabled() {
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        return editor instanceof ProjectEditorDiffer ||
                (editor instanceof SQLEditor && UIProjectLoader.isInProject(editor.getEditorInput()));
    }
}