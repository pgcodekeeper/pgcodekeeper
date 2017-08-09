package ru.taximaxim.codekeeper.ui.handlers;

import java.io.File;
import java.util.Deque;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.dbstore.DbStorePicker;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class AddFile extends AbstractHandler {
    private static final int MAX_FILES_HISTORY = 10;
    private final IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();

    // TODO remove sync after fixing bug with showing menu after closing dialog
    @Override
    public Object execute(ExecutionEvent event) {
        Shell s = HandlerUtil.getActiveShell(event);
        UiSync.exec(s, () -> addFile(s, event));
        return null;
    }

    private void addFile(Shell s, ExecutionEvent event) {
        if (!s.isDisposed()) {
            IWorkbenchPart part = HandlerUtil.getActiveEditor(event);
            if (part instanceof ProjectEditorDiffer) {
                FileDialog dialog = new FileDialog(s);
                dialog.setText(Messages.choose_dump_file_with_changes);
                dialog.setFilterExtensions(new String[] {"*.sql", "*"}); //$NON-NLS-1$ //$NON-NLS-2$
                dialog.setFilterNames(new String[] {
                        Messages.DiffPresentationPane_sql_file_filter,
                        Messages.DiffPresentationPane_any_file_filter});
                dialog.setFilterPath(mainPrefs.getString(PREF.LAST_OPENED_LOCATION));
                String pathToDump = dialog.open();
                if (pathToDump != null) {
                    ProjectEditorDiffer differ = (ProjectEditorDiffer) part;
                    File dumpFile = new File(pathToDump);
                    Deque<File> dumpHistory = DbStorePicker.stringToDumpFileHistory(
                            mainPrefs.getString(PREF.DB_STORE_FILES));
                    dumpHistory.addFirst(dumpFile);
                    while (dumpHistory.size() > MAX_FILES_HISTORY) {
                        dumpHistory.removeLast();
                    }
                    mainPrefs.setValue(PREF.DB_STORE_FILES, DbStorePicker.
                            dumpFileHistoryToPreference(dumpHistory));
                    mainPrefs.setValue(PREF.LAST_OPENED_LOCATION, dumpFile.getParent());
                    differ.getChanges(dumpFile);
                }
            }
        }
    }

    @Override
    public boolean isEnabled() {
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        return editor instanceof ProjectEditorDiffer;
    }
}