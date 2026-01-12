/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.dialogs;

import org.eclipse.core.runtime.CoreException;
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
        Status status = new Status(IStatus.ERROR, PLUGIN_ID.THIS, message, ex);
        StatusManager.getManager().handle(status, StatusManager.SHOW | StatusManager.LOG);
    }

    public static void notifyCoreException(CoreException ex) {
        Status status = new Status(ex.getStatus().getSeverity(), PLUGIN_ID.THIS, ex.getLocalizedMessage(), ex);
        StatusManager.getManager().handle(status, StatusManager.SHOW | StatusManager.LOG);
    }

    private ExceptionNotifier() {
    }
}