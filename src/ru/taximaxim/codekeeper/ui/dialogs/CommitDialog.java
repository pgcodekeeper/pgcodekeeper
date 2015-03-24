package ru.taximaxim.codekeeper.ui.dialogs;

import java.util.Collections;
import java.util.Set;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.differ.DiffTableViewer;
import ru.taximaxim.codekeeper.ui.differ.TreeDiffer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.prefs.PreferenceInitializer;

public class CommitDialog extends TrayDialog {
    
    private final TreeElement filtered;
    private final IPreferenceStore prefs;
    private final boolean egitCommitAvailable;
    
    private final TreeDiffer treeDiffer;
    private final Set<TreeElement> depcyElementsSet;
    private Set<?> conflictingElementsSet = Collections.EMPTY_SET;
    
    private DiffTableViewer dtvTop;
    private DiffTableViewer dtvBottom;
    private Button btnAutocommit;
    private PgDbProject proj;
    
    public CommitDialog(Shell parentShell, TreeElement filtered,
            Set<TreeElement> depcyElementsSet, IPreferenceStore mainPrefs,
            PgDbProject proj, TreeDiffer treeDiffer, boolean egitCommitAvailable) {
        super(parentShell);
        
        this.filtered = filtered;
        this.prefs = mainPrefs;
        this.egitCommitAvailable = egitCommitAvailable;
        this.treeDiffer = treeDiffer;
        this.depcyElementsSet = depcyElementsSet;
        this.proj = proj;
        
        setShellStyle(getShellStyle() | SWT.RESIZE);
    }
    
    @Override
    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        shell.setText(Messages.commitPartDescr_commit_confirmation);
    }
    
    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);
        
        Composite container = new Composite(area, SWT.NONE);
        GridLayout gl = new GridLayout();
        gl.marginHeight = gl.marginWidth = 0;
        container.setLayout(gl);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        new Label(container, SWT.NONE).setText(
                Messages.commitPartDescr_the_following_changes_be_included_in_commit);
        
        Group gTop = new Group(container, SWT.NONE);
        gTop.setLayout(new GridLayout());
        GridData gd = new GridData(GridData.FILL_BOTH);
        gTop.setLayoutData(gd);
        gTop.setText(Messages.commitDialog_user_selected_elements);
        
        dtvTop = new DiffTableViewer(gTop, SWT.NONE, prefs, proj, true);
        gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = 300;
        gd.widthHint = 1000;
        dtvTop.setLayoutData(gd);
        dtvTop.setFilteredInput(filtered, treeDiffer, false);
        
        if (depcyElementsSet != null){
            Group gBottom = new Group(container, SWT.NONE);
            gBottom.setLayout(new GridLayout());
            
            gd = new GridData(GridData.FILL_BOTH);
            gBottom.setLayoutData(gd);
            gBottom.setText(Messages.commitDialog_depcy_elements);
            
            dtvBottom = new DiffTableViewer(gBottom, SWT.NONE, prefs, proj, false);
            gd = new GridData(GridData.FILL_BOTH);
            gd.heightHint = 300;
            gd.widthHint = 1000;
            dtvBottom.setLayoutData(gd);
            dtvBottom.setInputCollection(depcyElementsSet, treeDiffer, false);
            dtvBottom.setCheckedElements(conflictingElementsSet.toArray(), false);
            dtvBottom.redraw();
        }
        
        btnAutocommit = new Button(container, SWT.CHECK);
        btnAutocommit.setText(Messages.commitPartDescr_show_commit_window);
        btnAutocommit.setSelection(prefs.getBoolean(PREF.CALL_COMMIT_COMMAND_AFTER_UPDATE));
        btnAutocommit.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                PreferenceInitializer.savePreference(prefs, 
                        PREF.CALL_COMMIT_COMMAND_AFTER_UPDATE, String.valueOf(btnAutocommit.getSelection()));
            }
        });
        btnAutocommit.setEnabled(egitCommitAvailable);
        return area;
    }
    
    public DiffTableViewer getBottomTableViewer(){
        return dtvBottom;
    }

    public void setConflictingElements(Set<?> conflictingElementsSet) {
        this.conflictingElementsSet = conflictingElementsSet;
    }
}
