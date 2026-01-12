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
package ru.taximaxim.codekeeper.ui.prefs.heap;

import java.util.Locale;

import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UiSync;
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

            var appName = System.getProperty("eclipse.launcher.name");
            var iniFileName = appName.toLowerCase(Locale.ROOT) + ".ini";

            MessageDialogWithToggle.openWarning(shell, Messages.HeapSizeChecker_heap_size_warning_title,
                    Messages.HeapSizeChecker_heap_size_warning.formatted(RECOMMENDED_XMX_SIZE_GB, iniFileName, appName),
                    Messages.HeapSizeChecker_do_not_ask_again, false, mainPrefs, PREF.HEAP_SIZE_WARNING);
        });
    }
}
