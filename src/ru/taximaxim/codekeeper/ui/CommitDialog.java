package ru.taximaxim.codekeeper.ui;

import java.io.IOException;
import java.util.HashSet;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.differ.DiffTableViewer;
import ru.taximaxim.codekeeper.ui.differ.TreeDiffer;
import ru.taximaxim.codekeeper.ui.externalcalls.JGitExec;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class CommitDialog extends TrayDialog {
    
    private TreeElement filteredElements;
    private IPreferenceStore prefs;
    private String message;
    private DiffTableViewer dtvTop;
    private DiffTableViewer dtvBottom;
    private TreeDiffer treeDiffer;
    private TreeElement filteredDiffTree;
    private HashSet<TreeElement> shouldBeNew;
    
    public CommitDialog(Shell parentShell, TreeElement filteredElements,
            HashSet<TreeElement> shouldBeNew, IPreferenceStore mainPrefs, PgDbProject proj, TreeDiffer treeDiffer) {
        super(parentShell);
        
        this.filteredElements = filteredElements;
        this.prefs = mainPrefs;
        this.treeDiffer = treeDiffer;
        this.prefs = mainPrefs;
        this.shouldBeNew = shouldBeNew;
        
        try {
            message = Messages.commitPartDescr_the_following_changes_be_included_in_commit
                    + proj.getString(PROJ_PREF.REPO_URL)
                    + Messages.commitPartDescr_branch 
                    + new JGitExec().getCurrentBranch(proj.getRepoRoot());
        } catch (IOException ex) {
            throw new IllegalStateException(Messages.commitPartDescr_cannot_get_branch_name, ex);
        }
        setShellStyle(getShellStyle() | SWT.RESIZE);
    }
    
    @Override
    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        shell.setText(Messages.commitPartDescr_commit_confirmation);
     }
    
    @Override
    protected Control createDialogArea(Composite parent) {
        parent = (Composite) super.createDialogArea(parent);
        
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout gl = new GridLayout();
        gl.marginHeight = gl.marginWidth = 0;
        container.setLayout(gl);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        Label lblMessage = new Label(container, SWT.BORDER);
        lblMessage.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        lblMessage.setText(message);
        
        dtvTop = new DiffTableViewer(container, SWT.BORDER, prefs, true);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = 400;
        gd.widthHint = 600;
        dtvTop.setLayoutData(gd);
        dtvTop.setFilteredInput(filteredElements, treeDiffer);
        
        dtvBottom = new DiffTableViewer(container, SWT.BORDER, prefs, false);
        gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = 400;
        gd.widthHint = 600;
        dtvBottom.setLayoutData(gd);
        dtvBottom.setInputCollection(shouldBeNew, treeDiffer);
        // TODO fix size after initializing - not all labels/buttons are visible
        return parent;
    }
    
    public DiffTableViewer getTopTableViewer(){
        return dtvTop;
    }
    
    public DiffTableViewer getBottomTableViewer(){
        return dtvBottom;
    }
    
    @Override
    protected void okPressed() {
        this.filteredDiffTree = dtvTop.filterDiffTree();
        super.okPressed();
    }
    
    public TreeElement getDiffTree (){
        return this.filteredDiffTree;
    }
}
