package ru.taximaxim.codekeeper.ui.dialogs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
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
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts.HELP;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.differ.DiffTableViewer;
import ru.taximaxim.codekeeper.ui.differ.TreeDiffer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PreferenceInitializer;

public class CommitDialog extends TrayDialog {

    private final IPreferenceStore prefs;
    private final boolean egitCommitAvailable;

    private final TreeDiffer treeDiffer;
    private final Set<TreeElement> depcyElementsSet;
    private DiffTableViewer dtvTop;
    private DiffTableViewer dtvBottom;
    private Button btnAutocommit;
    private Label warningLbl;

    public CommitDialog(Shell parentShell,
            Set<TreeElement> depcyElementsSet, IPreferenceStore mainPrefs,
            TreeDiffer treeDiffer, boolean egitCommitAvailable) {
        super(parentShell);

        this.prefs = mainPrefs;
        this.egitCommitAvailable = egitCommitAvailable;
        this.treeDiffer = treeDiffer;
        this.depcyElementsSet = depcyElementsSet;

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

        dtvTop = new DiffTableViewer(gTop, SWT.NONE, prefs, null, true);
        gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = 300;
        gd.widthHint = 1000;
        dtvTop.setLayoutData(gd);
        List<TreeElement> result = new ArrayList<>();
        try {
            TreeElement.getSelected(treeDiffer.getDiffTree(), result);
        } catch (PgCodekeeperUIException e1) {
            Log.log(Log.LOG_ERROR, "Error while trying to get DiffTree", e1); //$NON-NLS-1$
        }
        dtvTop.setInputCollection(result, treeDiffer, false);

        if (depcyElementsSet != null){
            Group gBottom = new Group(container, SWT.NONE);
            gBottom.setLayout(new GridLayout());

            gd = new GridData(GridData.FILL_BOTH);
            gBottom.setLayoutData(gd);
            gBottom.setText(Messages.commitDialog_depcy_elements);

            dtvBottom = new DiffTableViewer(gBottom, SWT.NONE, prefs, null, false);
            gd = new GridData(GridData.FILL_BOTH);
            gd.heightHint = 300;
            gd.widthHint = 1000;
            dtvBottom.setLayoutData(gd);
            // выбрать все зависимые элементы для наката
            for (TreeElement el : depcyElementsSet) {
                el.setSelected(true);
            }
            dtvBottom.setInputCollection(depcyElementsSet, treeDiffer, false);
            dtvBottom.redraw();

            dtvBottom.addCheckStateListener(new ValidationCheckStateListener());
            warningLbl = new Label(gBottom, SWT.NONE);
            gd = new GridData(GridData.FILL_BOTH);
            warningLbl.setLayoutData(gd);
            warningLbl.setText(Messages.CommitDialog_unchecked_objects_can_occur_unexpected_errors);
            warningLbl.setForeground(getShell().getDisplay().getSystemColor(SWT.COLOR_RED));
            warningLbl.setVisible(false);
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
        PlatformUI.getWorkbench().getHelpSystem().setHelp(getShell(), HELP.DIALOG_UPDATE_PROJECT);
        return area;
    }

    public DiffTableViewer getBottomTableViewer(){
        return dtvBottom;
    }

    @Override
    public int open() {
        int res = super.open();
        if (res == CANCEL) {
            // Если пользователь нажал отмену - снять выделения с зависимых элементов
            if (depcyElementsSet != null) {
                for (TreeElement el : depcyElementsSet) {
                    el.setSelected(false);
                }
            }
        }
        return res;
    }

    /**
     * Задача этого класса - смотреть на снятие галочки с элемента и если
     * галочка снимается то проверить следующее: <br>
     * 1. Элемент удаляется: если есть выбранные родители - показать предупреждение; <br>
     * 2. Элемент создается: если есть выбранные дети - показать предупреждение
     * @author botov_av
     */
    private class ValidationCheckStateListener implements ICheckStateListener {

        @Override
        public void checkStateChanged(CheckStateChangedEvent event) {
            boolean showWarning = false;
            for (TreeElement el : depcyElementsSet) {
                if (!el.isSelected()) {
                    switch (el.getSide()) {
                    // удаляется
                    case LEFT:
                        TreeElement parent = el.getParent();
                        while (parent != null) {
                            if (parent.isSelected()) {
                                showWarning = true;
                                break;
                            }
                            parent = parent.getParent();
                        }
                        break;
                        // создается
                    case RIGHT:
                        showWarning = el.isSubTreeSelected();
                        break;
                    default:
                        break;
                    }
                }
            }
            warningLbl.setVisible(showWarning);
            getButton(OK).setEnabled(!showWarning);
        }
    }
}