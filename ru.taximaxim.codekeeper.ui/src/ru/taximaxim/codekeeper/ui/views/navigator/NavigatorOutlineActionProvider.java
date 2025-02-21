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

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.texteditor.ITextEditor;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.sqledit.SegmentsWithParent;

public class NavigatorOutlineActionProvider extends CommonActionProvider {

    private ISelectionProvider provider;
    private OpenSegment openAction;

    @Override
    public void init(ICommonActionExtensionSite aSite) {
        super.init(aSite);
        provider = aSite.getViewSite().getSelectionProvider();
        openAction = new OpenSegment(Messages.PgNavigatorActionProvider_open_with_sql_editor);
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

    private class OpenSegment extends Action {

        private SegmentsWithParent segment;

        public OpenSegment(String text) {
            super(text);
        }

        @Override
        public boolean isEnabled() {
            ISelection selection = provider.getSelection();
            if (!selection.isEmpty()) {
                Object sel = ((IStructuredSelection) selection).getFirstElement();
                if (sel instanceof SegmentsWithParent seg) {
                    segment = seg;
                    return true;
                }
            }
            return false;
        }

        @Override
        public void run() {
            if (!isEnabled()) {
                return;
            }

            try {
                ITextEditor editor = (ITextEditor) IDE.openEditor(
                        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),
                        segment.getParentFile(), EDITOR.SQL, true);
                editor.setHighlightRange(segment.offset, segment.length, true);
                editor.selectAndReveal(segment.offset, segment.length);
            } catch (PartInitException e) {
                Log.log(e);
                ExceptionNotifier.notifyDefault(Messages.PgNavigatorActionProvider_failed_to_open_editor, e);
            }
        }
    }
}
