package ru.taximaxim.codekeeper.ui.dialogs;

import java.util.Collection;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.differ.DiffPaneViewer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DiffPaneDialog extends Dialog {

    private final TreeElement input;
    private final Collection<TreeElement> availableElements;
    private final DbSource dbProject;
    private final DbSource dbRemote;

    private DiffPaneViewer diffPane;

    public DiffPaneDialog(Shell parentShell, TreeElement el, Collection<TreeElement> availableElements,
            DbSource dbProject, DbSource dbRemote) {
        super(parentShell);
        this.input = el;
        this.availableElements = availableElements;
        this.dbProject = dbProject;
        this.dbRemote = dbRemote;

        setShellStyle(SWT.RESIZE | SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE);
        setBlockOnOpen(false);
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(Messages.diffPaneDialog_diff_to_selected_object);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);

        Composite container = new Composite(area, SWT.NONE);
        GridLayout gridLayout = new GridLayout();
        gridLayout.marginWidth = gridLayout.marginHeight = 0;
        container.setLayout(gridLayout);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.minimumHeight = 600;
        gd.minimumWidth = 1024;
        container.setLayoutData(gd);

        diffPane = new DiffPaneViewer(container, SWT.NONE);
        diffPane.setDbSources(dbProject, dbRemote);
        diffPane.setInput(input, availableElements);

        return area;
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    }

    @Override
    protected boolean isResizable() {
        return true;
    }
}
