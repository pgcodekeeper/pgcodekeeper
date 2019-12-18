package ru.taximaxim.codekeeper.ui.prefs.heap;

import java.text.MessageFormat;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IStartup;

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

    private static final long RECOMMENDED_SIZE_IN_GB = 2;

    private final IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();

    @Override
    public void earlyStartup() {
        UiSync.exec(Display.getDefault(), () -> {
            if (mainPrefs.getBoolean(PREF.HEAP_SIZE_WARNING) && isHeapLessThanNecessary()) {
                Shell shell = Display.getDefault().getActiveShell();

                MessageDialogWithToggle dialog = MessageDialogWithToggle.openYesNoQuestion(
                        shell, Messages.HeapSizeChecker_heap_size_warning_title,
                        MessageFormat.format(Messages.HeapSizeChecker_heap_size_warning,
                                RECOMMENDED_SIZE_IN_GB),
                        Messages.HeapSizeChecker_do_not_ask_again,
                        false, null, null);

                mainPrefs.setValue(PREF.HEAP_SIZE_WARNING, !dialog.getToggleState());

                if (IDialogConstants.YES_ID == dialog.getReturnCode()) {
                    new HeapSizeCheckerDialog(shell).open();
                }
            }
        });
    }

    private boolean isHeapLessThanNecessary() {
        // TODO add logic for check heap size
        return true;
    }
}
