package ru.taximaxim.codekeeper.ui.dialogs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.heap.HeapSizeChecker;

/**
 * Dialog box for changing heap size.
 */
public class HeapSizeCheckerDialog extends Dialog {

    private static final String LINK_ECLIPSE_INI_INFO = "https://wiki.eclipse.org/Eclipse.ini"; //$NON-NLS-1$
    private static final String VMARGS = "-vmargs"; //$NON-NLS-1$

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
        try (Stream<String> lineStream = Files.lines(path, StandardCharsets.UTF_8)) {
            String xmxLineWintNewHeapSizeGb = new StringBuilder()
                    .append('-').append(HeapSizeChecker.XMX_HEAP_PARAMETER)
                    .append(Integer.parseInt(selectedHeapSizeGb))
                    .append('G').toString();

            List<String> lines = lineStream.collect(Collectors.toList());

            String xmxLine = lines.stream()
                    .filter(l -> l.contains(HeapSizeChecker.XMX_HEAP_PARAMETER))
                    .findAny().orElse(null);

            String newEclipseIniTex = null;
            if (xmxLine == null) {
                int index = lines.indexOf(VMARGS);
                if (index != -1) {
                    lines.add(index, xmxLineWintNewHeapSizeGb);
                } else {
                    lines.add(VMARGS);
                    lines.add(xmxLineWintNewHeapSizeGb);
                }
                newEclipseIniTex = String.join("\n", lines); //$NON-NLS-1$
            } else {
                newEclipseIniTex = String.join("\n", lines) //$NON-NLS-1$
                        .replace(xmxLine, xmxLineWintNewHeapSizeGb);
            }

            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                writer.write(newEclipseIniTex);
                // not dialog with question because of:
                // "https://bugs.eclipse.org/bugs/show_bug.cgi?id=323565"
                MessageDialog.openInformation(Display.getDefault().getActiveShell(),
                        Messages.HeapSizeCheckerDialog_heap_size_updated,
                        Messages.HeapSizeCheckerDialog_restart_offer);
            }
        } catch (IOException e) {
            new MessageDialogWithLink(getShell(),
                    Messages.HeapSizeCheckerDialog_manual_heap_editing_title,
                    MessageFormat.format(Messages.HeapSizeCheckerDialog_manual_heap_editing,
                            selectedHeapSizeGb, path.toAbsolutePath()), MessageDialog.ERROR,
                    Messages.HeapSizeCheckerDialog_manual_heap_editing_link,
                    LINK_ECLIPSE_INI_INFO).open();
        } finally {
            super.okPressed();
        }
    }

    private static class MessageDialogWithLink extends MessageDialog {

        private final String linkText;
        private final String link;

        public MessageDialogWithLink(Shell parentShell, String dialogTitle,
                String dialogMessage, int dialogImageType, String linkText, String link) {
            super(parentShell, dialogTitle, null, dialogMessage, dialogImageType,
                    0, new String[] {IDialogConstants.OK_LABEL});
            this.linkText = linkText;
            this.link = link;
        }

        @Override
        protected Control createCustomArea(Composite parent) {
            Composite panel = new Composite(parent, SWT.NONE);
            panel.setLayout(new GridLayout());

            Link linkHint = new Link(panel, SWT.WRAP);
            GridData gd = new GridData();
            gd.horizontalIndent = 60;
            linkHint.setLayoutData(gd);
            linkHint.setText(linkText + " <a>" + link + "</a>"); //$NON-NLS-1$ //$NON-NLS-2$
            linkHint.addSelectionListener(new SelectionAdapter()  {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    Program.launch(link);
                }
            });
            return panel;
        }
    }
}
