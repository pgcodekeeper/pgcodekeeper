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
package ru.taximaxim.codekeeper.ui.handlers;

import java.text.MessageFormat;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISources;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorInput;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.utils.ProjectUtils;

public final class OpenEditor extends AbstractHandler {

    private IProject proj;

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        if (isEnabled() && proj != null) {
            try {
                openEditor(HandlerUtil.getActiveWorkbenchWindow(event).getActivePage(), proj);
            } catch (PartInitException e) {
                ExceptionNotifier.notifyDefault(MessageFormat.format(
                        Messages.OpenEditor_error_open_project_editor, proj.getName()), e);
            }
        }
        return null;
    }

    @Override
    public void setEnabled(Object evaluationContext) {
        proj = getSelectedProject(evaluationContext);
        setBaseEnabled(ProjectUtils.isPgCodeKeeperProject(proj));
    }

    private IProject getSelectedProject(Object ctx) {
        if (ctx instanceof IEvaluationContext evaluation) {
            Object sel = evaluation.getVariable(ISources.ACTIVE_CURRENT_SELECTION_NAME);
            if (sel instanceof IStructuredSelection ss) {
                Object el = ss.getFirstElement();
                if (el instanceof IAdaptable adaptable) {
                    return adaptable.getAdapter(IProject.class);
                }
            }
        }
        return null;
    }

    public static void openEditor(IWorkbenchPage page, IProject proj) throws PartInitException {
        Log.log(Log.LOG_INFO, "Opening editor for project: " + proj.getName()); //$NON-NLS-1$
        Shell shell = page.getWorkbenchWindow().getShell();
        if (ProjectUtils.checkVersionAndWarn(proj, shell, true)) {
            ProjectEditorInput input = new ProjectEditorInput(proj.getName());
            page.openEditor(input, EDITOR.PROJECT);
        }
    }
}
