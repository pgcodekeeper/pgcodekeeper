package ru.taximaxim.codekeeper.ui.prefs.heap;

import java.text.MessageFormat;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.dialogs.HeapSizeCheckerDialog;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * It checks the heap size every time it starts
 * (it starts working immediately after the pgCodeKeeper starts and
 * could be turned on or off in the main preferences).
 */
public class HeapSizeChecker implements IStartup {

    private static final long MINIMAL_XMX_SIZE_BYTE = 1610612736;
    private static final int RECOMMENDED_XMX_SIZE_GB = 2;

    @Override
    public void earlyStartup() {
        IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();
        if (!mainPrefs.getBoolean(PREF.HEAP_SIZE_WARNING) ||
                MINIMAL_XMX_SIZE_BYTE < Runtime.getRuntime().maxMemory()) {
            return;
        }

        UiSync.exec(PlatformUI.getWorkbench().getDisplay(), () -> {
            IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
            if (activeWindow == null) {
                return;
            }

            Shell shell = activeWindow.getShell();

            MessageDialogWithToggle dialog = MessageDialogWithToggle.openYesNoQuestion(
                    shell, Messages.HeapSizeChecker_heap_size_warning_title,
                    MessageFormat.format(Messages.HeapSizeChecker_heap_size_warning,
                            RECOMMENDED_XMX_SIZE_GB),
                    Messages.HeapSizeChecker_do_not_ask_again,
                    false, mainPrefs, PREF.HEAP_SIZE_WARNING);

            if (IDialogConstants.YES_ID == dialog.getReturnCode()) {
                new HeapSizeCheckerDialog(shell).open();
            }
        });
    }
}
