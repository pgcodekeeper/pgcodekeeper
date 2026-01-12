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
package ru.taximaxim.codekeeper.ui.utils;

import java.util.Locale;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;

public final class UiUtils {

    public static String getOS() {
        return System.getProperty("os.name", "generic").toLowerCase(Locale.ROOT); //$NON-NLS-1$ //$NON-NLS-2$
    }

    public static boolean isMac() {
        String os = getOS();
        return os.indexOf("mac") >= 0 || os.indexOf("darwin") >= 0; //$NON-NLS-1$ //$NON-NLS-2$
    }

    public static boolean isCommandCopy(IStructuredSelection selection, KeyEvent e) {
        return !selection.isEmpty() && isCommandCopy(e);
    }

    public static boolean isCommandCopy(KeyEvent e) {
        int key = e.stateMask;
        return (((key & SWT.CTRL) == SWT.CTRL) || ((key & SWT.COMMAND) == SWT.COMMAND)) && e.keyCode == 'c';
    }

    private UiUtils() {
        // only statics
    }
}
