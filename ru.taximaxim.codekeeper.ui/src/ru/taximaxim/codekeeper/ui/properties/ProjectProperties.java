package ru.taximaxim.codekeeper.ui.properties;


import java.text.MessageFormat;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PropertyPage;
import org.osgi.service.prefs.BackingStoreException;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_BIND_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dbstore.DbStorePicker;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ProjectProperties extends PropertyPage {

    private Button btnEnableProjPref;
    private Button btnNoPrivileges;
    private Button btnEnableFuncDep;
    private Button btnSimplifyView;
    private Button btnUseGlobalIgnoreList;

    private Button btnForceUnixNewlines;
    private Button btnDisableParser;
    private Button btnBindProjToDb;
    private DbStorePicker storePicker;
    private Combo cmbTimezone;
    private CLabel lblWarn;
    private CLabel lblWarnPosix;

    private DbInfo dbForBind;

    private IEclipsePreferences prefs;
    private IEclipsePreferences dbBindPrefs;

    private boolean isMsSql;

    private boolean inApply;

    @Override
    public void setElement(IAdaptable element) {
        super.setElement(element);
        IProject project = element.getAdapter(IProject.class);
        prefs = new ProjectScope(project).getNode(UIConsts.PLUGIN_ID.THIS);
        dbBindPrefs = new ProjectScope(project).getNode(DB_BIND_PREF.DB_BINDING);
        isMsSql = OpenProjectUtils.checkMsSql(project);
    }

    @Override
    protected Control createContents(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout(2, false);
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        panel.setLayout(layout);

        btnDisableParser = new Button(panel, SWT.CHECK);
        btnDisableParser.setText(Messages.ProjectProperties_disable_parser_in_external_files);
        btnDisableParser.setLayoutData(new GridData(SWT.DEFAULT, SWT.DEFAULT, false, false, 2, 1));
        btnDisableParser.setSelection(prefs.getBoolean(PROJ_PREF.DISABLE_PARSER_IN_EXTERNAL_FILES, false));

        btnForceUnixNewlines = new Button(panel, SWT.CHECK);
        btnForceUnixNewlines.setText(Messages.ProjectProperties_force_unix_newlines);
        btnForceUnixNewlines.setToolTipText(Messages.ProjectProperties_force_unix_newlines_desc);
        btnForceUnixNewlines.setLayoutData(new GridData(SWT.DEFAULT, SWT.DEFAULT, false, false, 2, 1));
        btnForceUnixNewlines.setSelection(prefs.getBoolean(PROJ_PREF.FORCE_UNIX_NEWLINES, true));

        String nameOfBoundDb = dbBindPrefs.get(DB_BIND_PREF.NAME_OF_BOUND_DB, ""); //$NON-NLS-1$
        btnBindProjToDb = new Button(panel, SWT.CHECK);
        btnBindProjToDb.setText(Messages.ProjectProperties_binding_to_db_connection + ':');
        btnBindProjToDb.setSelection(!nameOfBoundDb.isEmpty());
        btnBindProjToDb.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                storePicker.setEnabled(btnBindProjToDb.getSelection());
                if (!btnBindProjToDb.getSelection()) {
                    storePicker.setSelection(StructuredSelection.EMPTY);
                }
            }
        });

        dbForBind = DbInfo.getLastDb(nameOfBoundDb);
        storePicker = new DbStorePicker(panel, false, false);
        storePicker.setSelection(dbForBind != null ? new StructuredSelection(dbForBind) : StructuredSelection.EMPTY);
        storePicker.setEnabled(btnBindProjToDb.getSelection());
        storePicker.addListenerToCombo(e -> dbForBind = storePicker.getDbInfo());

        if (!isMsSql) {
            new Label(panel, SWT.NONE).setText(Messages.projectProperties_timezone_for_all_db_connections);

            cmbTimezone = new Combo(panel, SWT.BORDER | SWT.DROP_DOWN);
            cmbTimezone.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
            cmbTimezone.setItems(UIConsts.TIME_ZONES.toArray(new String[UIConsts.TIME_ZONES.size()]));
            String tz = prefs.get(PROJ_PREF.TIMEZONE, ApgdiffConsts.UTC);
            cmbTimezone.setText(tz);
            cmbTimezone.addModifyListener(e -> checkSwitchWarnLbl());

            lblWarn = new CLabel(panel, SWT.NONE);
            lblWarn.setImage(Activator.getEclipseImage(ISharedImages.IMG_OBJS_WARN_TSK));
            lblWarn.setText(Messages.ProjectProperties_change_projprefs_warn);
            GridData gd = new GridData(SWT.FILL, SWT.DEFAULT, false, false, 2, 1);
            gd.exclude = true;
            lblWarn.setLayoutData(gd);
            lblWarn.setVisible(false);

            lblWarnPosix = new CLabel(panel, SWT.NONE);
            lblWarnPosix.setImage(Activator.getEclipseImage(ISharedImages.IMG_OBJS_WARN_TSK));
            lblWarnPosix.setText(Messages.ProjectProperties_posix_is_used_warn);
            gd = new GridData(SWT.FILL, SWT.DEFAULT, false, false, 2, 1);
            gd.exclude = true;
            lblWarnPosix.setLayoutData(gd);
            timeZoneWarn(tz);
        }

        Label lblSeparator = new Label(panel, SWT.SEPARATOR | SWT.HORIZONTAL);
        lblSeparator.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, false, false, 2, 1));

        boolean overridePref = prefs.getBoolean(PROJ_PREF.ENABLE_PROJ_PREF_ROOT, false);
        btnEnableProjPref = new Button(panel, SWT.CHECK);
        btnEnableProjPref.setText(Messages.ProjectProperties_enable_proj_prefs);
        btnEnableProjPref.setLayoutData(new GridData(SWT.DEFAULT, SWT.DEFAULT, false, false, 2, 1));
        btnEnableProjPref.setSelection(overridePref);
        btnEnableProjPref.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                btnNoPrivileges.setEnabled(btnEnableProjPref.getSelection());
                btnEnableFuncDep.setEnabled(btnEnableProjPref.getSelection());
                btnUseGlobalIgnoreList.setEnabled(btnEnableProjPref.getSelection());
                if (!isMsSql) {
                    btnSimplifyView.setEnabled(btnEnableProjPref.getSelection());
                }
            }
        });

        btnNoPrivileges = new Button(panel, SWT.CHECK);
        btnNoPrivileges.setText(Messages.dbUpdatePrefPage_ignore_privileges);
        GridData gd = new GridData(SWT.BEGINNING, SWT.DEFAULT, false, false, 2, 1);
        gd.horizontalIndent = 10;
        btnNoPrivileges.setLayoutData(gd);
        btnNoPrivileges.setSelection(prefs.getBoolean(PREF.NO_PRIVILEGES, false));
        btnNoPrivileges.setEnabled(overridePref);

        btnEnableFuncDep = new Button(panel, SWT.CHECK);
        btnEnableFuncDep.setText(Messages.GeneralPrefPage_enable_body_dependencies);
        btnEnableFuncDep.setToolTipText(Messages.GeneralPrefPage_body_depcy_tooltip);
        gd = new GridData(SWT.BEGINNING, SWT.DEFAULT, false, false, 2, 1);
        gd.horizontalIndent = 10;
        btnEnableFuncDep.setLayoutData(gd);
        btnEnableFuncDep.setSelection(prefs.getBoolean(PREF.ENABLE_BODY_DEPENDENCIES, false));
        btnEnableFuncDep.setEnabled(overridePref);

        if (!isMsSql) {
            btnSimplifyView = new Button(panel, SWT.CHECK);
            btnSimplifyView.setText(Messages.GeneralPrefPage_simplify_view);
            gd = new GridData(SWT.BEGINNING, SWT.DEFAULT, false, false, 2, 1);
            gd.horizontalIndent = 10;
            btnSimplifyView.setLayoutData(gd);
            btnSimplifyView.setSelection(prefs.getBoolean(PREF.SIMPLIFY_VIEW, false));
            btnSimplifyView.setEnabled(overridePref);
        }

        btnUseGlobalIgnoreList = new Button(panel, SWT.CHECK);
        btnUseGlobalIgnoreList.setText(Messages.ProjectProperties_use_global_ignore_list);
        gd = new GridData(SWT.BEGINNING, SWT.DEFAULT, false, false, 2, 1);
        gd.horizontalIndent = 10;
        btnUseGlobalIgnoreList.setLayoutData(gd);
        btnUseGlobalIgnoreList.setSelection(prefs.getBoolean(PROJ_PREF.USE_GLOBAL_IGNORE_LIST, true));
        btnUseGlobalIgnoreList.setEnabled(overridePref);

        return panel;
    }

    private void checkSwitchWarnLbl() {
        String tz = cmbTimezone.getText();
        GridData data = (GridData) lblWarn.getLayoutData();
        boolean show = !tz.equals(prefs.get(PROJ_PREF.TIMEZONE, ApgdiffConsts.UTC));
        data.exclude = !show;
        lblWarn.setVisible(show);
        lblWarn.getParent().layout();

        timeZoneWarn(tz);
    }

    private void timeZoneWarn(String tz) {
        GridData data = (GridData) lblWarnPosix.getLayoutData();
        if ((!ApgdiffConsts.UTC.equals(tz)
                && tz.startsWith(ApgdiffConsts.UTC)) == data.exclude)  {
            lblWarnPosix.setVisible(data.exclude);
            data.exclude = !data.exclude;
            lblWarnPosix.getParent().layout();
        }
    }

    @Override
    protected void performDefaults() {
        // overridable preferences
        IPreferenceStore mainPS = Activator.getDefault().getPreferenceStore();
        btnEnableProjPref.setSelection(false);
        btnNoPrivileges.setEnabled(btnEnableProjPref.getSelection());
        btnNoPrivileges.setSelection(mainPS.getBoolean(PREF.NO_PRIVILEGES));
        btnEnableFuncDep.setEnabled(btnEnableProjPref.getSelection());
        btnEnableFuncDep.setSelection(mainPS.getBoolean(PREF.ENABLE_BODY_DEPENDENCIES));
        btnUseGlobalIgnoreList.setEnabled(btnEnableProjPref.getSelection());
        btnUseGlobalIgnoreList.setSelection(true);

        // project preferences
        btnDisableParser.setSelection(false);
        btnForceUnixNewlines.setSelection(true);
        btnBindProjToDb.setSelection(false);
        storePicker.setSelection(StructuredSelection.EMPTY);
        if (!isMsSql) {
            cmbTimezone.setText(ApgdiffConsts.UTC);
            btnSimplifyView.setEnabled(btnEnableProjPref.getSelection());
            btnSimplifyView.setSelection(mainPS.getBoolean(PREF.SIMPLIFY_VIEW));
        }
        try {
            fillPrefs();
        } catch (BackingStoreException e) {
            setErrorMessage(MessageFormat.format(
                    Messages.projectProperties_error_occurs_while_saving_properties,
                    e.getLocalizedMessage()));
            setValid(false);
        }
    }

    @Override
    public boolean performCancel() {
        activateEditor();
        return super.performCancel();
    }

    @Override
    protected void performApply() {
        inApply = true;
        super.performApply();
        inApply = false;
    }

    @Override
    public boolean performOk() {
        try {
            fillPrefs();
            if (!inApply) {
                activateEditor();
            }
        } catch (BackingStoreException e) {
            setErrorMessage(MessageFormat.format(
                    Messages.projectProperties_error_occurs_while_saving_properties,
                    e.getLocalizedMessage()));
            setValid(false);
            return false;
        }
        return true;
    }

    private void fillPrefs() throws BackingStoreException {
        prefs.putBoolean(PROJ_PREF.ENABLE_PROJ_PREF_ROOT, btnEnableProjPref.getSelection());
        prefs.putBoolean(PREF.NO_PRIVILEGES, btnNoPrivileges.getSelection());
        prefs.putBoolean(PREF.ENABLE_BODY_DEPENDENCIES, btnEnableFuncDep.getSelection());
        prefs.putBoolean(PROJ_PREF.USE_GLOBAL_IGNORE_LIST, btnUseGlobalIgnoreList.getSelection());
        prefs.putBoolean(PROJ_PREF.DISABLE_PARSER_IN_EXTERNAL_FILES, btnDisableParser.getSelection());
        prefs.putBoolean(PROJ_PREF.FORCE_UNIX_NEWLINES, btnForceUnixNewlines.getSelection());
        dbBindPrefs.put(DB_BIND_PREF.NAME_OF_BOUND_DB, dbForBind != null ? dbForBind.getName() : ""); //$NON-NLS-1$
        if (!isMsSql) {
            prefs.put(PROJ_PREF.TIMEZONE, cmbTimezone.getText());
            prefs.putBoolean(PREF.SIMPLIFY_VIEW, btnSimplifyView.getSelection());
        }
        prefs.flush();
        dbBindPrefs.flush();
        setValid(true);
        setErrorMessage(null);
    }

    private void activateEditor() {
        IWorkbenchPage activePage = PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getActivePage();
        IEditorPart activeEditor = activePage.getActiveEditor();
        // it's need to do for refresh state and content DbCombo
        // of opened and active sql/project editor, after setting of the binding
        // in the project properties.
        activePage.activate(activeEditor);
    }
}
