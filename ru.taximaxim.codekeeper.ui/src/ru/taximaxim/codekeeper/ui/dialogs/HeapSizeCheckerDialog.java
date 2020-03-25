package ru.taximaxim.codekeeper.ui.dialogs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.List;
import java.util.stream.IntStream;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * Dialog box for changing heap size.
 */
public class HeapSizeCheckerDialog extends Dialog {

    private static final String LINK_ECLIPSE_INI_INFO = "https://wiki.eclipse.org/Eclipse.ini"; //$NON-NLS-1$
    private static final String VMARGS = "-vmargs"; //$NON-NLS-1$
    private static final String XMX = "-Xmx"; //$NON-NLS-1$

    private Combo combo;

    public HeapSizeCheckerDialog(Shell parentShell) {
        super(parentShell);
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(Messages.HeapSizeCheckerDialog_set_heap_size);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        panel.setLayout(new GridLayout(3, false));

        Label lblDescr = new Label(panel, SWT.NONE);
        lblDescr.setText(Messages.HeapSizeCheckerDialog_new_heap_size);
        GridData gd = new GridData();
        gd.horizontalIndent = 10;
        lblDescr.setLayoutData(gd);

        combo = new Combo(panel, SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
        for (int i = 2; i < 6; i++) {
            combo.add(Integer.toString(i));
        }
        combo.select(0);
        gd = new GridData();
        gd.horizontalIndent = 10;
        combo.setLayoutData(gd);

        new Label(panel, SWT.NONE).setText("Gb"); //$NON-NLS-1$

        return panel;
    }

    @Override
    protected void okPressed() {
        String selectedHeapSizeGb = combo.getItem(combo.getSelectionIndex());
        Path path = Paths.get(System.getProperty("eclipse.launcher")) //$NON-NLS-1$
                .getParent().resolve("eclipse.ini"); //$NON-NLS-1$
        try {
            String xmxLineWithNewHeapSizeGb = XMX + Integer.parseInt(selectedHeapSizeGb) + 'G';

            List<String> lines = Files.readAllLines(path);

            int xmxLineIdx = IntStream.range(0, lines.size())
                    .filter(i -> lines.get(i).startsWith(XMX))
                    .findFirst().orElse(-1);

            if (xmxLineIdx == -1) {
                int vmargsLineIdx = IntStream.range(0, lines.size())
                        .filter(i -> lines.get(i).equalsIgnoreCase(VMARGS))
                        .findFirst().orElse(-1);
                if (vmargsLineIdx != -1) {
                    lines.add(vmargsLineIdx + 1, xmxLineWithNewHeapSizeGb);
                } else {
                    lines.add(VMARGS);
                    lines.add(xmxLineWithNewHeapSizeGb);
                }
            } else {
                lines.set(xmxLineIdx, xmxLineWithNewHeapSizeGb);
            }

            Files.write(path, lines);

            MessageDialog.openInformation(getShell(),
                    Messages.HeapSizeCheckerDialog_heap_size_updated,
                    Messages.HeapSizeCheckerDialog_restart_offer);
        } catch (IOException e) {
            Log.log(e);
            new MessageDialogWithLink(getShell(),
                    Messages.HeapSizeCheckerDialog_manual_heap_editing_title,
                    MessageFormat.format(Messages.HeapSizeCheckerDialog_manual_heap_editing,
                            selectedHeapSizeGb, path.toAbsolutePath(), e.getLocalizedMessage()),
                    MessageDialog.ERROR,
                    Messages.HeapSizeCheckerDialog_manual_heap_editing_link,
                    LINK_ECLIPSE_INI_INFO).open();
        } finally {
            super.okPressed();
        }
    }
}
