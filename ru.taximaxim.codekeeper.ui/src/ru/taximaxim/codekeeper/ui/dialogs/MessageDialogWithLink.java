package ru.taximaxim.codekeeper.ui.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;

public class MessageDialogWithLink extends MessageDialog {

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
