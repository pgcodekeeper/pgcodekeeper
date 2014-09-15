package ru.taximaxim.codekeeper.ui.parts;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DiffPaneDialog extends Dialog {

    private DbSource dbSource;
    private DbSource dbTarget;
    private DiffPaneViewer diffPane;
    private Object input;
    private boolean reverseSide;

    public DiffPaneDialog(Shell parentShell, DbSource dbSource,
            DbSource dbTarget, boolean reverseSide) {
        super(parentShell);
        setShellStyle(SWT.RESIZE | SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE);
        setBlockOnOpen(false);
        this.dbSource = dbSource;
        this.dbTarget = dbTarget;
        this.reverseSide = reverseSide;
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(Messages.diffPaneDialog_diff_to_selected_object);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        parent = (Composite) super.createDialogArea(parent);

        Composite container = new Composite(parent, SWT.NONE);
        GridLayout gridLayout = new GridLayout();
        gridLayout.marginWidth = gridLayout.marginHeight = 0;
        container.setLayout(gridLayout);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.minimumHeight = 480;
        gd.minimumWidth = 800;
        container.setLayoutData(gd);

        diffPane = new DiffPaneViewer(container, SWT.NONE, dbSource, dbTarget,
                reverseSide);
        diffPane.setInput(input);

        return parent;
    }
    
    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
                true);
    }

    public void setInput(Object input) {
        this.input = input;
    }
}
