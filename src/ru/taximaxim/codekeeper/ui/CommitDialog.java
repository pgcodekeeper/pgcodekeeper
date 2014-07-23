package ru.taximaxim.codekeeper.ui;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.differ.DiffTableViewer;

public class CommitDialog extends TrayDialog {
    
    private TreeElement treeDiffer;
    private IPreferenceStore prefs;
    private String title;
    private String message;
    
    public CommitDialog(Shell parentShell, String title,
            String message, TreeElement treeDiffer,
            IPreferenceStore mainPrefs) {
        super(parentShell);
        this.title = title;
        this.message = message;
        this.treeDiffer = treeDiffer;
        this.prefs = mainPrefs;
    }
    
    @Override
    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        shell.setText(title);
     }
    
    @Override
    protected Control createDialogArea(Composite parent) {
        parent = (Composite) super.createDialogArea(parent);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        
        Label lblMessage = new Label(parent, SWT.BORDER);
        lblMessage.setLayoutData(gd);
        lblMessage.setText(message);
        
        DiffTableViewer dtv = new DiffTableViewer(parent, SWT.None, prefs, true);
        gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = 400;
        gd.widthHint = 600;
        dtv.setLayoutData(gd);
        dtv.setInputTreeElement(treeDiffer);
        return parent;
    }
}
