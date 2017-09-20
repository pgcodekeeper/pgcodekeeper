package ru.taximaxim.codekeeper.ui.handlers;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.dbstore.DbStorePicker;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;

public class AddFile extends AbstractHandler {

    private final IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();

    // TODO remove sync after fixing bug with showing menu after closing dialog
    @Override
    public Object execute(ExecutionEvent event) {
        Shell s = HandlerUtil.getActiveShell(event);
        UiSync.exec(s, () -> addFile(s, event));
        return null;
    }

    private void addFile(Shell s, ExecutionEvent event) {
        ProjectEditorDiffer differ = null;
        if (!s.isDisposed()) {
            IWorkbenchPart part = HandlerUtil.getActiveEditor(event);
            if (part instanceof ProjectEditorDiffer) {
                differ = (ProjectEditorDiffer) part;
            }
        }
        if (differ == null) {
            return;
        }

        File dumpFile = DbStorePicker.chooseDbSource(s, mainPrefs, false);
        if (dumpFile != null) {
            differ.getChanges(dumpFile);
        }
    }

    @Override
    public boolean isEnabled() {
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        return editor instanceof ProjectEditorDiffer;
    }
}