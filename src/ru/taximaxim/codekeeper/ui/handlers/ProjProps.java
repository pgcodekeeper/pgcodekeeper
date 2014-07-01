package ru.taximaxim.codekeeper.ui.handlers;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dbstore.DbStorePickerDialog;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.prefs.FakePrefPageExtension;
import ru.taximaxim.codekeeper.ui.prefs.PrefDialogFactory;

public class ProjProps {
    
    @Execute
    private void execute(
            @Named(UIConsts.PREF_STORE) IPreferenceStore mainPrefs,
            @Named(IServiceConstants.ACTIVE_SHELL) Shell shell, PgDbProject proj) {
        FakePrefPageExtension[] propPages = {
                new FakePrefPageExtension("projprefs.0.pagerepo",  //$NON-NLS-1$
                        proj.getString(UIConsts.PROJ_PREF_REPO_TYPE)
                        + " Settings", new RepoSettingsPage(), null), //$NON-NLS-1$

                new FakePrefPageExtension("projprefs.1.pagedbsouce", //$NON-NLS-1$
                        "DB Source", new DbSrcPage(mainPrefs), null), //$NON-NLS-1$

                new FakePrefPageExtension("projprefs.2.pagemisc", //$NON-NLS-1$
                        "Miscellaneous", new MiscSettingPage(), null) }; //$NON-NLS-1$

        Log.log(Log.LOG_DEBUG, "About to show proj props dialog"); //$NON-NLS-1$
        
        PrefDialogFactory.show(shell, proj, propPages);
    }

    @CanExecute
    private boolean canExecute(PgDbProject proj) {
        return proj != null;
    }
}

class DbSrcPage extends FieldEditorPreferencePage {

    private final IPreferenceStore mainPrefs;

    private Group grpSourceDb;

    private CLabel lblWarn;

    private LocalResourceManager lrm;

    public DbSrcPage(IPreferenceStore mainPrefs) {
        super(GRID);

        this.mainPrefs = mainPrefs;
    }

    @Override
    protected void createFieldEditors() {
        this.lrm = new LocalResourceManager(JFaceResources.getResources(),
                getFieldEditorParent());

        RadioGroupFieldEditor radio = new RadioGroupFieldEditor(
                UIConsts.PROJ_PREF_SOURCE, "Source of the DB schema", 1, //$NON-NLS-1$
                new String[][] { { "None", UIConsts.PROJ_SOURCE_TYPE_NONE }, //$NON-NLS-1$
                        { "Dump file", UIConsts.PROJ_SOURCE_TYPE_DUMP }, //$NON-NLS-1$
                        { "Database", UIConsts.PROJ_SOURCE_TYPE_DB } }, //$NON-NLS-1$
                getFieldEditorParent(), true);
        addField(radio);

        grpSourceDb = new Group(getFieldEditorParent(), SWT.NONE);
        grpSourceDb.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        grpSourceDb.setText(Messages.ProjProps_settings_for_database_schema_source);

        final StringFieldEditor sfeName = new StringFieldEditor(
                UIConsts.PROJ_PREF_DB_NAME, Messages.ProjProps_db_name, grpSourceDb);
        addField(sfeName);

        final StringFieldEditor sfeUser = new StringFieldEditor(
                UIConsts.PROJ_PREF_DB_USER, Messages.ProjProps_db_user, grpSourceDb);
        addField(sfeUser);

        final StringFieldEditor sfePass = new StringFieldEditor(
                UIConsts.PROJ_PREF_DB_PASS, Messages.ProjProps_db_password, grpSourceDb);
        addField(sfePass);
        sfePass.getTextControl(grpSourceDb).setEchoChar('\u2022'); // •

        lblWarn = new CLabel(grpSourceDb, SWT.NONE);
        lblWarn.setImage(lrm.createImage(ImageDescriptor
                .createFromURL(Activator.getContext().getBundle()
                        .getResource(UIConsts.FILENAME_ICONWARNING))));
        lblWarn.setText(Messages.ProjProps_warning + Messages.ProjProps_providing_password_here_is_insecure
                + Messages.ProjProps_consider_using_pgpass_instead);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1);

        if (getPreferenceStore().getString(UIConsts.PROJ_PREF_DB_PASS)
                .isEmpty()) {
            gd.exclude = true;
            lblWarn.setVisible(false);
        }

        lblWarn.setLayoutData(gd);

        final StringFieldEditor sfeHost = new StringFieldEditor(
                UIConsts.PROJ_PREF_DB_HOST, Messages.ProjProps_db_host, grpSourceDb);
        addField(sfeHost);

        final IntegerFieldEditor ifePort = new IntegerFieldEditor(
                UIConsts.PROJ_PREF_DB_PORT, Messages.ProjProps_db_port, grpSourceDb);
        addField(ifePort);

        Button btnStorePick = new Button(grpSourceDb, SWT.PUSH);
        btnStorePick.setText("..."); //$NON-NLS-1$
        btnStorePick.setLayoutData(new GridData(SWT.RIGHT, SWT.DEFAULT, false,
                false, 2, 1));
        btnStorePick.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                DbStorePickerDialog dialog = new DbStorePickerDialog(
                        getShell(), mainPrefs);
                if (dialog.open() == Dialog.OK) {
                    DbInfo db = dialog.getDbInfo();

                    sfeName.setStringValue(db.dbname);
                    sfeUser.setStringValue(db.dbuser);
                    sfePass.setStringValue(db.dbpass);
                    sfeHost.setStringValue(db.dbhost);
                    ifePort.setStringValue(String.valueOf(db.dbport));
                }
            }
        });

        if (!UIConsts.PROJ_SOURCE_TYPE_DB.equals(getPreferenceStore()
                .getString(UIConsts.PROJ_PREF_SOURCE))) {
            recursiveSetEnabled(grpSourceDb, false);
        }

        ((GridLayout) grpSourceDb.getLayout()).marginWidth = 5;
        ((GridLayout) grpSourceDb.getLayout()).marginHeight = 5;

        noDefaultAndApplyButton();
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        String prefName = ((FieldEditor) e.getSource()).getPreferenceName();

        if (UIConsts.PROJ_PREF_SOURCE.equals(prefName)) {
            if (!e.getNewValue().equals(e.getOldValue())) {
                recursiveSetEnabled(grpSourceDb,
                        UIConsts.PROJ_SOURCE_TYPE_DB.equals(e.getNewValue()));
            }
        } else if (UIConsts.PROJ_PREF_DB_PASS.equals(prefName)) {
            String oldVal = (String) e.getOldValue();
            String newVal = (String) e.getNewValue();

            if (oldVal.isEmpty() != newVal.isEmpty()) {
                GridData gd = (GridData) lblWarn.getLayoutData();

                gd.exclude = !gd.exclude;
                lblWarn.setVisible(!lblWarn.getVisible());

                getShell().pack();
                grpSourceDb.getParent().layout(false);
            }
        }

        super.propertyChange(e);
    }

    private void recursiveSetEnabled(Composite composite, boolean enabled) {
        composite.setEnabled(enabled);

        for (Control child : composite.getChildren()) {
            if (child instanceof Composite) {
                recursiveSetEnabled((Composite) child, enabled);
            } else {
                child.setEnabled(enabled);
            }
        }
    }
}

class RepoSettingsPage extends FieldEditorPreferencePage {

    private CLabel lblWarn;
    private LocalResourceManager lrm;

    public RepoSettingsPage() {
        super(GRID);
    }

    @Override
    protected void createFieldEditors() {
        this.lrm = new LocalResourceManager(JFaceResources.getResources(),
                getFieldEditorParent());
        String repoTypeName;
        String warningMessage;
        repoTypeName = UIConsts.PROJ_REPO_TYPE_GIT_NAME;
        warningMessage = Messages.ProjProps_warning_providing_password_here_is_insecure
                + Messages.ProjProps_this_password_will_show_up_in_logs
                + Messages.ProjProps_consider_using_ssh_authentication_instead;
        StringFieldEditor sfeUrl = new StringFieldEditor(
                UIConsts.PROJ_PREF_REPO_URL, repoTypeName + Messages.ProjProps_repo_url,
                getFieldEditorParent());
        addField(sfeUrl);
        sfeUrl.setEmptyStringAllowed(false);

        addField(new StringFieldEditor(UIConsts.PROJ_PREF_REPO_USER,
                repoTypeName + Messages.ProjProps_user, getFieldEditorParent()));

        StringFieldEditor sfePass = new StringFieldEditor(
                UIConsts.PROJ_PREF_REPO_PASS, repoTypeName + Messages.ProjProps_password,
                getFieldEditorParent());
        addField(sfePass);
        sfePass.getTextControl(getFieldEditorParent()).setEchoChar('\u2022'); // •

        lblWarn = new CLabel(getFieldEditorParent(), SWT.NONE);
        lblWarn.setImage(lrm.createImage(ImageDescriptor
                .createFromURL(Activator.getContext().getBundle()
                        .getResource(UIConsts.FILENAME_ICONWARNING))));

        lblWarn.setText(warningMessage);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1);

        if (getPreferenceStore().getString(UIConsts.PROJ_PREF_REPO_PASS)
                .isEmpty()) {
            gd.exclude = true;
            lblWarn.setVisible(false);
        }

        lblWarn.setLayoutData(gd);

        noDefaultAndApplyButton();
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        String prefName = ((FieldEditor) e.getSource()).getPreferenceName();

        if (UIConsts.PROJ_PREF_REPO_PASS.equals(prefName)) {
            String oldVal = (String) e.getOldValue();
            String newVal = (String) e.getNewValue();

            if (oldVal.isEmpty() != newVal.isEmpty()) {
                GridData gd = (GridData) lblWarn.getLayoutData();

                gd.exclude = !gd.exclude;
                lblWarn.setVisible(!lblWarn.getVisible());

                getShell().pack();
                lblWarn.getParent().layout(false);
            }
        }

        super.propertyChange(e);
    }
}

class MiscSettingPage extends FieldEditorPreferencePage {

    private String originalEncoding;

    private CLabel lblWarn;

    private LocalResourceManager lrm;

    public MiscSettingPage() {
        super(GRID);
    }

    @Override
    protected void createFieldEditors() {
        this.lrm = new LocalResourceManager(JFaceResources.getResources(),
                getFieldEditorParent());

        originalEncoding = getPreferenceStore().getString(
                UIConsts.PROJ_PREF_ENCODING);

        Set<String> charsets = Charset.availableCharsets().keySet();
        List<String[]> lstCharsets = new ArrayList<>(charsets.size());

        for (String charset : charsets) {
            lstCharsets.add(new String[] { charset, charset });
        }

        addField(new ComboFieldEditor(UIConsts.PROJ_PREF_ENCODING,
                Messages.ProjProps_project_encoding, lstCharsets.toArray(new String[lstCharsets
                        .size()][]), getFieldEditorParent()));

        lblWarn = new CLabel(getFieldEditorParent(), SWT.NONE);
        lblWarn.setImage(lrm.createImage(ImageDescriptor
                .createFromURL(Activator.getContext().getBundle()
                        .getResource(UIConsts.FILENAME_ICONWARNING))));
        lblWarn.setText(Messages.ProjProps_warning
                + Messages.ProjProps_encoding_of_existing_files_willnt_be_changed);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1);
        gd.exclude = true;
        lblWarn.setVisible(false);

        lblWarn.setLayoutData(gd);

        noDefaultAndApplyButton();
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        String prefName = ((FieldEditor) e.getSource()).getPreferenceName();

        if (UIConsts.PROJ_PREF_ENCODING.equals(prefName)) {
            String oldVal = (String) e.getOldValue();
            String newVal = (String) e.getNewValue();

            if (!oldVal.equals(newVal)) {
                boolean show = !newVal.equals(originalEncoding);

                GridData gd = (GridData) lblWarn.getLayoutData();

                gd.exclude = !show;
                lblWarn.setVisible(show);

                getShell().pack();
                lblWarn.getParent().layout(false);
            }
        }

        super.propertyChange(e);
    }
}