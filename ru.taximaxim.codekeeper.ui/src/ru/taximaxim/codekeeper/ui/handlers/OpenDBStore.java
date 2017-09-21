package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.ui.UIConsts.PREF_PAGE;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;

public class OpenDBStore extends AbstractHandler {

    // TODO remove sync after fixing bug with showing menu after closing dialog
    @Override
    public Object execute(ExecutionEvent event) {
        Shell s = HandlerUtil.getActiveShell(event);
        UiSync.exec(s, () -> addDB(s));
        return null;
    }

    private void addDB(Shell s) {
        if (!s.isDisposed()) {
            PreferencesUtil.createPreferenceDialogOn(s, PREF_PAGE.DB_STORE, null, null)
            .open();
        }
    }

    @Override
    public boolean isEnabled() {
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        return editor instanceof ProjectEditorDiffer;
    }
}