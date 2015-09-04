package ru.taximaxim.codekeeper.ui.dialogs;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusManager;

import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;

/**
 * Helper class for notifying user of exceptions thrown.<br>
 * Logs messages to standard StatusManager.
 *
 * @author ryabinin_av
 */
public final class ExceptionNotifier {

    public static void notifyDefault(String message, Throwable ex) {
        Status status = new Status(IStatus.ERROR, PLUGIN_ID.THIS,
                message, ex);
        StatusManager.getManager().handle(status, StatusManager.SHOW | StatusManager.LOG);
    }

    private ExceptionNotifier() {}
}