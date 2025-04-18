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

import java.io.IOException;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;

import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.libraries.CacheableLibrary;
import ru.taximaxim.codekeeper.ui.libraries.FileLibrary;
import ru.taximaxim.codekeeper.ui.libraries.RootLibrary;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.utils.FileUtilsUi;

public final class NavigationLibrariesActionProvider extends CommonActionProvider {

    private OpenLibrary openAction;
    private ClearLibrary clearAction;
    private RefreshLibrary refreshAction;

    @Override
    public void init(ICommonActionExtensionSite site) {
        super.init(site);
        openAction = new OpenLibrary();
        clearAction = new ClearLibrary();
        refreshAction = new RefreshLibrary();
    }

    @Override
    public void fillActionBars(IActionBars actionBars) {
        if (openAction.isEnabled()) {
            actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, openAction);
        }
        if (refreshAction.isEnabled()) {
            actionBars.setGlobalActionHandler(ActionFactory.REFRESH.getId(), refreshAction);
        }
    }

    @Override
    public void fillContextMenu(IMenuManager menu) {
        if (openAction.isEnabled()) {
            menu.appendToGroup(ICommonMenuConstants.GROUP_OPEN, openAction);
        }
        if (refreshAction.isEnabled()) {
            menu.appendToGroup(ICommonMenuConstants.GROUP_BUILD, refreshAction);
        }
        if (clearAction.isEnabled()) {
            menu.appendToGroup(ICommonMenuConstants.GROUP_BUILD, clearAction);
        }
    }

    private void refresh(Object element) {
        StructuredViewer viewer = getActionSite().getStructuredViewer();
        if (viewer != null && viewer.getControl() != null
                && !viewer.getControl().isDisposed()) {
            viewer.refresh(element);
        }
    }

    private class OpenLibrary extends Action {

        public OpenLibrary() {
            super(Messages.NavigationLibrariesActionProvider_open_library);
        }

        @Override
        public boolean isEnabled() {
            IStructuredSelection selection = (IStructuredSelection) getContext().getSelection();
            return selection.getFirstElement() instanceof FileLibrary;
        }

        @Override
        public void run() {
            IStructuredSelection selection = (IStructuredSelection) getContext().getSelection();
            Object sel = selection.getFirstElement();
            if (sel instanceof FileLibrary lib) {
                try {
                    FileUtilsUi.openFileInSqlEditor(lib.getPath(), lib.getProject(), lib.getDbType(), true);
                } catch (PartInitException e) {
                    ExceptionNotifier.notifyDefault(
                            Messages.NavigationLibrariesActionProvider_failed_to_open_library, e);
                }
            }
        }
    }

    private class ClearLibrary extends Action {

        public ClearLibrary() {
            super(Messages.NavigationLibrariesActionProvider_clear_library_cache);
        }

        @Override
        public boolean isEnabled() {
            ISelection selection = getContext().getSelection();
            if (!selection.isEmpty()) {
                Object sel = ((IStructuredSelection) selection).getFirstElement();
                return sel instanceof CacheableLibrary lib && lib.getParent() instanceof RootLibrary && lib.exists();
            }

            return false;
        }

        @Override
        public void run() {
            IStructuredSelection selection = (IStructuredSelection) getContext().getSelection();
            Object sel = selection.getFirstElement();
            if (sel instanceof CacheableLibrary lib && lib.exists()) {
                try {
                    lib.clear();
                } catch (IOException e) {
                    ExceptionNotifier.notifyDefault(
                            Messages.NavigationLibrariesActionProvider_failed_to_clear_library_cache, e);
                }
                refresh(sel);
            }
        }
    }

    private class RefreshLibrary extends Action {

        public RefreshLibrary() {
            super(Messages.NavigationLibrariesActionProvider_refresh_library);
        }

        @Override
        public boolean isEnabled() {
            IStructuredSelection selection = (IStructuredSelection) getContext().getSelection();
            return selection.getFirstElement() instanceof CacheableLibrary cl && cl.getParent() instanceof RootLibrary;
        }

        @Override
        public void run() {
            IStructuredSelection selection = (IStructuredSelection) getContext()
                    .getSelection();
            Object sel = selection.getFirstElement();
            if (sel instanceof CacheableLibrary lib) {
                try {
                    lib.refresh();
                } catch (IOException e) {
                    ExceptionNotifier.notifyDefault(
                            Messages.NavigationLibrariesActionProvider_failed_to_refresh_library, e);
                }
                refresh(sel);
            }
        }
    }
}
