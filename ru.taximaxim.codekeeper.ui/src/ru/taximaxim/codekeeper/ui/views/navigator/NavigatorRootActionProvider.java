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
package ru.taximaxim.codekeeper.ui.views.navigator;

import java.text.MessageFormat;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;

import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.handlers.OpenEditor;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class NavigatorRootActionProvider extends CommonActionProvider {

    private ISelectionProvider provider;
    private OpenProject openAction;

    @Override
    public void init(ICommonActionExtensionSite aSite) {
        super.init(aSite);
        provider = aSite.getViewSite().getSelectionProvider();
        openAction = new OpenProject(Messages.NavigatorRootActionProvider_open_action);
    }

    @Override
    public void fillActionBars(IActionBars actionBars) {
        if (openAction.isEnabled()) {
            actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, openAction);
        }
    }

    @Override
    public void fillContextMenu(IMenuManager menu) {
        if (openAction.isEnabled()) {
            menu.appendToGroup(ICommonMenuConstants.GROUP_OPEN, openAction);
        }
    }

    private class OpenProject extends Action {

        private IProject proj;

        public OpenProject(String text) {
            super(text);
        }

        @Override
        public boolean isEnabled() {
            ISelection selection = provider.getSelection();
            if (!selection.isEmpty()) {
                Object sel = ((IStructuredSelection) selection).getFirstElement();
                if (sel instanceof OpenProjectFromNavigator project) {
                    proj = project.getProject();
                    return true;
                }
            }
            return false;
        }

        @Override
        public void run() {
            if (!isEnabled())
                return;

            try {
                OpenEditor.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), proj);
            } catch (PartInitException e) {
                ExceptionNotifier.notifyDefault(MessageFormat.format(
                        Messages.OpenEditor_error_open_project_editor, proj.getName()), e);
            }
        }
    }
}
