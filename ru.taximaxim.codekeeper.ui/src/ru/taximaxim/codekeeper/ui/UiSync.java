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
            if (ex.code != SWT.ERROR_WIDGET_DISPOSED) {
                throw ex;
            }
            // do nothing: UI is already dead
        }
    }

    private UiSync() {
    }
}
