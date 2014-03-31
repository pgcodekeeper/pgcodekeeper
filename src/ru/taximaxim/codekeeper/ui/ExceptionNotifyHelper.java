package ru.taximaxim.codekeeper.ui;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.parts.Console;

public class ExceptionNotifyHelper {
    public static void notifyAndThrow(IllegalStateException ex, Shell parent) throws IllegalStateException{
        MessageDialog dialog = new MessageDialog(parent, "", null,
                ex.getMessage(), MessageDialog.ERROR, new String[] { "OK" }, 0);
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        Console.addMessage(sw.toString());
        dialog.open();
        throw ex;
    }
}
