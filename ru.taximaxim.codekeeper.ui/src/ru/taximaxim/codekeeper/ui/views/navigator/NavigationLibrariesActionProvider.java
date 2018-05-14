package ru.taximaxim.codekeeper.ui.views.navigator;

import java.nio.file.Path;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class NavigationLibrariesActionProvider extends CommonActionProvider {

    private OpenLibrary openAction;

    @Override
    public void init(ICommonActionExtensionSite site) {
        openAction = new OpenLibrary(Messages.NavigationLibrariesActionProvider_open_library,
                site.getViewSite().getSelectionProvider());
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

    private static class OpenLibrary extends Action {

        private LibraryContainer segment;
        private final ISelectionProvider provider;

        public OpenLibrary(String text, ISelectionProvider provider) {
            super(text);
            this.provider = provider;
        }

        @Override
        public boolean isEnabled() {
            ISelection selection = provider.getSelection();
            if (!selection.isEmpty()) {
                Object sel = ((IStructuredSelection) selection).getFirstElement();
                if (sel instanceof LibraryContainer && ((LibraryContainer)sel).isEnableToOpen()) {
                    segment = (LibraryContainer) sel;
                    return true;
                }
            }
            return false;
        }

        @Override
        public void run() {
            if (isEnabled()) {
                Path path = segment.getPath();
                try {
                    FileUtilsUi.openFileInSqlEditor(path);
                } catch (PartInitException e) {
                    Log.log(e);
                    ExceptionNotifier.notifyDefault(
                            Messages.NavigationLibrariesActionProvider_failed_to_open_library, e);
                }
            }
        }
    }
}
