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
package ru.taximaxim.codekeeper.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;

public final class UiSync {

    public static void exec(Widget w, Runnable r) {
        try {
            exec(w.getDisplay(), r);
        } catch (SWTException ex) {
            if (ex.code != SWT.ERROR_WIDGET_DISPOSED) {
                throw ex;
            }
            // do nothing: UI is already dead
        }
    }

    public static void exec(Display d, Runnable r) {
        try {
            d.asyncExec(r);
        } catch (SWTException ex) {
            if (ex.code != SWT.ERROR_DEVICE_DISPOSED) {
                throw ex;
            }
            // do nothing: UI is already dead
        }
    }

    private UiSync() {
    }
}
