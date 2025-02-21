/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public final class Log {

    public static final int LOG_ERROR = IStatus.ERROR;
    public static final int LOG_WARNING = IStatus.WARNING;
    public static final int LOG_INFO = IStatus.INFO;
    public static final int LOG_DEBUG = IStatus.OK;

    public static void log(int level, String msg) {
        logInternal(level, msg, null);
    }

    /**
     * Log an exception at {@link IStatus#ERROR} level.
     */
    public static void log(Throwable ex) {
        logInternal(IStatus.ERROR, "Unexpected Exception", ex); //$NON-NLS-1$
    }

    public static void log(int level, String msg, Throwable ex) {
        logInternal(level, msg, ex);
    }

    private static void logInternal(int severity, String message,
            Throwable exception) {
        logToPlugin(new Status(severity, UIConsts.PLUGIN_ID.THIS, message,
                exception));
    }

    private static void logToPlugin(IStatus status) {
        Activator.getDefault().getLog().log(status);
    }
    
    private Log() {}
}
