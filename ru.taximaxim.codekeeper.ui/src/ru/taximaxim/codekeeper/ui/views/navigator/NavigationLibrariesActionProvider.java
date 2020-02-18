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

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.libraries.FileLibrary;
import ru.taximaxim.codekeeper.ui.libraries.LibraryUtils;
import ru.taximaxim.codekeeper.ui.libraries.ZipLibrary;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class NavigationLibrariesActionProvider extends CommonActionProvider {

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
            if (sel instanceof FileLibrary) {
                try {
                    LibraryUtils.openLibrary((FileLibrary) sel);
                } catch (PartInitException e) {
                    Log.log(e);
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
                return sel instanceof ZipLibrary && ((ZipLibrary) sel).exists();
            }

            return false;
        }

        @Override
        public void run() {
            IStructuredSelection selection = (IStructuredSelection) getContext().getSelection();
            Object sel = selection.getFirstElement();
            if (sel instanceof ZipLibrary && ((ZipLibrary) sel).exists()) {
                try {
                    ((ZipLibrary) sel).clearCache();
                } catch (IOException e) {
                    Log.log(e);
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
            return selection.getFirstElement() instanceof ZipLibrary;
        }

        @Override
        public void run() {
            IStructuredSelection selection = (IStructuredSelection) getContext()
                    .getSelection();
            Object sel = selection.getFirstElement();
            if (sel instanceof ZipLibrary) {
                try {
                    ((ZipLibrary) sel).reload();
                } catch (IOException e) {
                    Log.log(e);
                    ExceptionNotifier.notifyDefault(
                            Messages.NavigationLibrariesActionProvider_failed_to_refresh_library, e);
                }
                refresh(sel);
            }
        }
    }
}
