package ru.taximaxim.codekeeper.ui.dialogs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.heap.HeapSizeChecker;

/**
 * Dialog box for changing heap size.
 */
public class HeapSizeCheckerDialog extends Dialog {

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
        Path path = Paths.get(System.getProperty("eclipse.launcher")) //$NON-NLS-1$
                .resolve("eclipse.ini"); //$NON-NLS-1$
        try (Stream<String> lineStream = Files.lines(path, StandardCharsets.UTF_8)) {
            String xmxLineWintNewHeapSizeGb = new StringBuilder()
                    .append('-').append(HeapSizeChecker.XMX_HEAP_PARAMETER)
                    .append(Integer.parseInt(combo.getItem(combo.getSelectionIndex())))
                    .append("G").toString(); //$NON-NLS-1$

            List<String> lines = lineStream.collect(Collectors.toList());

            String xmxLine = lines.stream()
                    .filter(l -> l.contains(HeapSizeChecker.XMX_HEAP_PARAMETER))
                    .findAny().orElse(null);

            String newEclipseIniTex = null;
            if (xmxLine == null) {
                StringBuilder sb = new StringBuilder();
                for (String ln : lines) {
                    if (ln.contains("-vmargs")) { //$NON-NLS-1$
                        sb.append(ln).append("\n"); //$NON-NLS-1$
                        sb.append(xmxLineWintNewHeapSizeGb).append("\n"); //$NON-NLS-1$
                        continue;
                    }
                    sb.append(ln).append("\n"); //$NON-NLS-1$
                }
                newEclipseIniTex = sb.toString();
            } else {
                newEclipseIniTex = lines.stream()
                        .collect(Collectors.joining("\n")) //$NON-NLS-1$
                        .replace(xmxLine, xmxLineWintNewHeapSizeGb);
            }
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                writer.write(newEclipseIniTex);
                if (MessageDialog.openQuestion(Display.getDefault().getActiveShell(),
                        Messages.HeapSizeCheckerDialog_heap_size_updated,
                        Messages.HeapSizeCheckerDialog_restart_offer)) {
                    PlatformUI.getWorkbench().restart();
                }
            }
        } catch (IOException e) {
            // TODO show a message with information about editing a file manually
        } finally {
            super.okPressed();
        }
    }
}
