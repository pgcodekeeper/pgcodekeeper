package ru.taximaxim.codekeeper.ui;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.parts.Console;

public class ExceptionNotifyHelper {
    public static void notifyAndThrow(IllegalStateException ex, Shell parent) throws IllegalStateException{
        MessageBox dialog = new MessageBox(parent, SWT.ERROR);
        dialog.setMessage(ex.getMessage());
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        Console.addMessage(sw.toString());
        dialog.open();
        pw.close();
        throw ex;
    }
}
