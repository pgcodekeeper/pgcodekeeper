package ru.taximaxim.codekeeper.ui.dialogs;

import java.text.MessageFormat;
import java.util.Map;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * Dialog box for filling in one-time preferences that will be used
 * when generating the script.
 */
public class ApplyCustomDialog extends Dialog {

    private Button btnScriptAddTransact;
    private Button btnCheckFuncBodies;
    private Button btnAlterColUsingExpr;
    private Button btnCreateIdxConcurrent;

    private final IEclipsePreferences projPS;
    private final boolean isMsSql;

    private final Map<String, Boolean> customSettings;

    public ApplyCustomDialog(Shell parentShell, IEclipsePreferences projPS,
            boolean isMsSql, Map<String, Boolean> customSettings) {
        super(parentShell);
        this.customSettings = customSettings;
        this.projPS = projPS;
        this.isMsSql = isMsSql;
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(Messages.DiffTableViewer_apply_to_custom);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        panel.setLayout(new GridLayout());

        new Label(panel, SWT.NONE).setText(MessageFormat
                .format(Messages.getChangesCustomDialog_custom_prefs_description,
                        Messages.DiffTableViewer_apply_to));

        btnScriptAddTransact = new Button(panel, SWT.CHECK);
        btnScriptAddTransact.setText(Messages.dbUpdatePrefPage_script_add_transaction);
        GridData gd = new GridData();
        gd.horizontalIndent = 10;
        btnScriptAddTransact.setLayoutData(gd);
        btnScriptAddTransact.setSelection(projPS.getBoolean(DB_UPDATE_PREF
                .SCRIPT_IN_TRANSACTION, false));

        btnCreateIdxConcurrent = new Button(panel, SWT.CHECK);
        btnCreateIdxConcurrent.setText(Messages.DbUpdatePrefPage_print_index_with_concurrently);
        gd = new GridData();
        gd.horizontalIndent = 10;
        btnCreateIdxConcurrent.setLayoutData(gd);
        btnCreateIdxConcurrent.setSelection(projPS.getBoolean(DB_UPDATE_PREF
                .PRINT_INDEX_WITH_CONCURRENTLY, false));

        if (!isMsSql) {
            btnCheckFuncBodies = new Button(panel, SWT.CHECK);
            btnCheckFuncBodies.setText(Messages.dbUpdatePrefPage_check_function_bodies);
            gd = new GridData();
            gd.horizontalIndent = 10;
            btnCheckFuncBodies.setLayoutData(gd);
            btnCheckFuncBodies.setSelection(projPS.getBoolean(DB_UPDATE_PREF
                    .CHECK_FUNCTION_BODIES, false));

            btnAlterColUsingExpr = new Button(panel, SWT.CHECK);
            btnAlterColUsingExpr.setText(Messages.dbUpdatePrefPage_switch_on_off_using);
            gd = new GridData();
            gd.horizontalIndent = 10;
            btnAlterColUsingExpr.setLayoutData(gd);
            btnAlterColUsingExpr.setSelection(projPS.getBoolean(DB_UPDATE_PREF
                    .USING_ON_OFF, false));
        }

        return panel;
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        super.createButtonsForButtonBar(parent);
        Button btnOk = getButton(IDialogConstants.OK_ID);
        btnOk.setLayoutData(new GridData(GridData.BEGINNING, GridData.CENTER, true, false));
        btnOk.setText(Messages.getChangesCustomDialog_run_with_specified_prefs);
    }

    @Override
    protected void okPressed() {
        customSettings.put(PROJ_PREF.ENABLE_PROJ_PREF_DB_UPDATE, true);
        customSettings.put(DB_UPDATE_PREF.SCRIPT_IN_TRANSACTION,
                btnScriptAddTransact.getSelection());
        customSettings.put(DB_UPDATE_PREF.PRINT_INDEX_WITH_CONCURRENTLY,
                btnCreateIdxConcurrent.getSelection());
        if (!isMsSql) {
            customSettings.put(DB_UPDATE_PREF.CHECK_FUNCTION_BODIES,
                    btnCheckFuncBodies.getSelection());
            customSettings.put(DB_UPDATE_PREF.USING_ON_OFF,
                    btnAlterColUsingExpr.getSelection());
        }

        super.okPressed();
    }
}
