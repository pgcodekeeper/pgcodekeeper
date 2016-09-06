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
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;
import ru.taximaxim.codekeeper.ui.sqledit.SegmentsWithParent;

public class PgNavigatorActionProvider extends CommonActionProvider {

    private ISelectionProvider provider;
    private OpenSegment openAction;

    @Override
    public void init(ICommonActionExtensionSite aSite) {
        provider = aSite.getViewSite().getSelectionProvider();
        openAction = new OpenSegment();
        openAction.setText(Messages.PgNavigatorActionProvider_open_with_sql_editor);
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

        @Override
        public boolean isEnabled() {
            ISelection selection = provider.getSelection();
            if (!selection.isEmpty()) {
                Object sel = ((IStructuredSelection) selection).getFirstElement();
                if (sel instanceof SegmentsWithParent) {
                    segment = (SegmentsWithParent) sel;
                    return true;
                }
            }
            return false;
        }

        @Override
        public void run() {
            if (isEnabled()) {
                try {
                    ITextEditor editor = (ITextEditor) IDE.openEditor(
                            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),
                            segment.getParentFile(), SQLEditor.ID, true);
                    editor.setHighlightRange(segment.offset, segment.length, true);
                    editor.selectAndReveal(segment.offset, segment.length);
                } catch (PartInitException e) {
                    Log.log(e);
                    ExceptionNotifier.notifyDefault(Messages.PgNavigatorActionProvider_failed_to_open_editor, e);
                }
            }
        }
    }
}
