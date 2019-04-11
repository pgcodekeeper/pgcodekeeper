package ru.taximaxim.codekeeper.ui.properties;


import java.text.MessageFormat;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
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
import org.eclipse.ui.ide.ResourceUtil;
import org.osgi.service.prefs.BackingStoreException;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dbstore.DbStorePicker;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class ProjectProperties extends PropertyPage {

    private Button btnForceUnixNewlines;
    private Button btnDisableParser;
    private Button btnBindProjToDb;
    private DbStorePicker storePicker;
    private Combo cmbTimezone;
    private CLabel lblWarn;
    private CLabel lblWarnPosix;

    private String projName;
    private DbInfo dbForBind;

    private IEclipsePreferences prefs;

    private boolean isMsSql;

    @Override
    public void setElement(IAdaptable element) {
        super.setElement(element);
        IProject project = element.getAdapter(IProject.class);
        projName = project.getName();
        prefs = new ProjectScope(project).getNode(UIConsts.PLUGIN_ID.THIS);
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

        String nameOfBoundDb = prefs.get(PROJ_PREF.NAME_OF_BOUND_DB, "");
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
        storePicker = new DbStorePicker(panel, Activator.getDefault().getPreferenceStore(),
                false, false, true);
        storePicker.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        storePicker.setSelection(dbForBind != null ? new StructuredSelection(dbForBind) : null);
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
        btnDisableParser.setSelection(false);
        btnForceUnixNewlines.setSelection(true);
        btnBindProjToDb.setSelection(false);
        storePicker.setSelection(StructuredSelection.EMPTY);
        if (!isMsSql) {
            cmbTimezone.setText(ApgdiffConsts.UTC);
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
    public boolean performOk() {
        try {
            fillPrefs();

            IWorkbenchPage activePage = PlatformUI.getWorkbench()
                    .getActiveWorkbenchWindow().getActivePage();
            IEditorPart activeEditor = activePage.getActiveEditor();
            if (activeEditor != null) {
                if (activeEditor instanceof ProjectEditorDiffer) {
                    ProjectEditorDiffer projEd = (ProjectEditorDiffer) activeEditor;
                    if (projName.equals(projEd.getProject().getName())) {
                        projEd.setCurrentDb(dbForBind);
                        // it's need to do for refresh state and content DbCombo
                        // of opened and active project editor, after setting of the binding
                        // in the project properties.
                        activePage.activate(activeEditor);
                    }
                } else if (activeEditor instanceof SQLEditor) {
                    SQLEditor sqlEd = (SQLEditor) activeEditor;
                    IResource res = ResourceUtil.getResource(sqlEd.getEditorInput());
                    if (res != null && projName.equals(res.getProject().getName())) {
                        sqlEd.setCurrentDb(dbForBind);
                        // it's need to do for refresh state and content DbCombo
                        // of opened and active sql editor, after setting of the
                        // binding in the project properties
                        activePage.activate(activeEditor);
                    }
                }
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
        prefs.putBoolean(PROJ_PREF.DISABLE_PARSER_IN_EXTERNAL_FILES, btnDisableParser.getSelection());
        prefs.putBoolean(PROJ_PREF.FORCE_UNIX_NEWLINES, btnForceUnixNewlines.getSelection());
        if (btnBindProjToDb.getSelection() && dbForBind != null) {
            setBoundDbToPref(prefs, dbForBind.getName());
        } else {
            prefs.put(PROJ_PREF.NAME_OF_BOUND_DB, "");
        }
        if (!isMsSql) {
            prefs.put(PROJ_PREF.TIMEZONE, cmbTimezone.getText());
        }
        prefs.flush();
        setValid(true);
        setErrorMessage(null);
    }

    public static void setBoundDbToPref(IEclipsePreferences prefs, String dbName) {
        prefs.put(PROJ_PREF.NAME_OF_BOUND_DB, dbName);
        prefs.put(PROJ_PREF.LAST_DB_STORE, dbName);
        prefs.put(PROJ_PREF.LAST_DB_STORE_EDITOR, dbName);
    }
}
