package ru.taximaxim.codekeeper.ui.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

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
        int newHeapSizeGb = Integer.parseInt(combo.getItem(combo.getSelectionIndex()));

        // TODO add such logic
        // try {write to eclipse.ini file}
        // catch {show a message with information about editing a file manually}

        super.okPressed();
    }
}
