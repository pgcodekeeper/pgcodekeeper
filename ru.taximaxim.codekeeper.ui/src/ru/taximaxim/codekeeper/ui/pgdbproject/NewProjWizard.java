package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.help.IWorkbenchHelpSystem;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.osgi.service.prefs.BackingStoreException;

import cz.startnet.utils.pgdiff.loader.JdbcTimezone;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.HELP;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dbstore.DbStorePicker;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.handlers.OpenEditor;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class NewProjWizard extends Wizard
implements IExecutableExtension, INewWizard {

    private PageRepo pageRepo;
    private PageDb pageDb;

    private final IPreferenceStore mainPrefStore;
    private PgDbProject props;
    private IConfigurationElement config;
    private IWorkbench workbench;
    private IStructuredSelection selection;
    private String charset;
    private String timezone;

    public NewProjWizard() {
        this.mainPrefStore = Activator.getDefault().getPreferenceStore();

        setWindowTitle(Messages.newProjWizard_new_pg_db_project);
        setDefaultPageImageDescriptor(ImageDescriptor.createFromURL(
                Activator.getDefault().getBundle().getResource(FILE.ICONAPPWIZ)));
        setNeedsProgressMonitor(true);
    }

    public PgDbProject getProject() {
        return props;
    }

    @Override
    public void addPages() {
        // page names shouldn't be localized, use page titles instead
        pageRepo = new PageRepo("main", selection); //$NON-NLS-1$
        addPage(pageRepo);
        pageDb = new PageDb("schema", mainPrefStore); //$NON-NLS-1$
        addPage(pageDb);
    }

    @Override
    public void createPageControls(Composite pageContainer) {
        super.createPageControls(pageContainer);

        IWorkbenchHelpSystem helpSystem = PlatformUI.getWorkbench().getHelpSystem();
        helpSystem.setHelp(pageRepo.getControl(), HELP.NEW_WIZARD);
        helpSystem.setHelp(pageDb.getControl(), HELP.NEW_WIZARD_INIT);
    }

    @Override
    public IWizardPage getNextPage(IWizardPage page) {
        if(page == pageRepo) {
            if (!checkMarkerExist()) {
                return pageDb;
            } else {
                return null;
            }
        }
        return super.getNextPage(page);
    }
    /**
     * Проверяет на наличие файла маркера в директории проекта
     * @return существует ли маркер
     */
    private boolean checkMarkerExist() {
        return new File(pageRepo.getLocationPath().toFile(), ApgdiffConsts.FILENAME_WORKING_DIR_MARKER)
                .exists();
    }

    @Override
    public boolean canFinish() {
        if (getContainer().getCurrentPage() == pageRepo && checkMarkerExist()) {
            return true;
        }
        return super.canFinish();
    }

    @Override
    public boolean performFinish() {
        try {
            props = PgDbProject.createPgDbProject(pageRepo.getProjectHandle(),
                    pageRepo.useDefaults() ? null : pageRepo.getLocationURI());
            IWorkingSet[] workingSets = pageRepo.getSelectedWorkingSets();
            workbench.getWorkingSetManager().addToWorkingSets(props.getProject(), workingSets);
            if (!checkMarkerExist()) {
                boolean initSuccess = false;
                try {
                    getContainer().run(true, true, new InitProjectFromSource(props, getDbSource()));
                    initSuccess = true;
                } catch (InvocationTargetException ex) {
                    ExceptionNotifier.notifyDefault(
                            Messages.newProjWizard_error_in_initializing_repo_from_source, ex);
                    return false;
                } catch (InterruptedException ex) {
                    // cancelled
                    return false;
                } finally {
                    if (!initSuccess) {
                        props.deleteFromWorkspace();
                    }
                }
            }

            BasicNewProjectResourceWizard.updatePerspective(config);
            BasicNewResourceWizard.selectAndReveal(props.getProject(),
                    workbench.getActiveWorkbenchWindow());

            props.openProject();
            try {
                props.setProjectCharset(charset);
                props.getPrefs().put(PROJ_PREF.TIMEZONE, timezone);
                props.getPrefs().flush();
            } catch (BackingStoreException e) {
                Log.log(Log.LOG_WARNING, "Error while flushing project properties!", e); //$NON-NLS-1$
            } catch (CoreException ex) {
                throw new PgCodekeeperUIException(ex.getLocalizedMessage(), ex);
            }

            OpenEditor.openEditor(
                    PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),
                    props.getProject());
        } catch (PgCodekeeperUIException e) {
            ExceptionNotifier.notifyDefault(Messages.NewProjWizard_error_creating_project, e);
            return false;
        }
        return true;
    }

    private DbSource getDbSource() throws PgCodekeeperUIException {
        DbSource src;
        DbInfo dbinfo = pageDb.getDbInfo();
        File dump;

        boolean forceUnixNewlines = props.getPrefs().getBoolean(PROJ_PREF.FORCE_UNIX_NEWLINES, true);
        charset = pageDb.getCharset();
        timezone = pageDb.getTimeZone();

        if(!pageDb.getInitial()){
            src = DbSource.fromDbObject(new PgDatabase(), ""); //$NON-NLS-1$
        } else if (dbinfo != null) {
            src = DbSource.fromDbInfo(dbinfo, mainPrefStore, forceUnixNewlines, charset, timezone);
        } else if ((dump = pageDb.getDumpPath()) != null) {
            src = DbSource.fromFile(forceUnixNewlines, dump, charset);
        } else {
            throw new PgCodekeeperUIException(Messages.initProjectFromSource_init_request_but_no_schema_source);
        }

        return src;
    }

    @Override
    public void setInitializationData(IConfigurationElement config,
            String propertyName, Object data) throws CoreException {
        this.config = config;
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.workbench = workbench;
        this.selection = selection;
    }
}

class PageRepo extends WizardNewProjectCreationPage {

    private static final String WORKING_SET_ID = "org.eclipse.ui.resourceWorkingSetPage"; //$NON-NLS-1$

    private final IStructuredSelection selection;

    PageRepo(String pageName, IStructuredSelection selection) {
        super(pageName);
        this.selection = selection;

        setTitle(Messages.newProjWizard_new_pg_db_project);
        setDescription(Messages.NewProjWizard_create_project);
    }

    @Override
    public void createControl(final Composite parent) {
        super.createControl(parent);
        createWorkingSetGroup((Composite) getControl(), selection,
                new String[] { WORKING_SET_ID });
    }
}

class PageDb extends WizardPage {

    private final IPreferenceStore mainPrefs;
    private Button initial;
    private DbStorePicker storePicker;
    private Combo timezoneCombo, charsetCombo;

    public DbInfo getDbInfo() {
        return storePicker.getDbInfo();
    }

    public String getCharset(){
        return charsetCombo.getText();
    }

    public Boolean getInitial(){
        return initial.getSelection();
    }

    public String getTimeZone(){
        return timezoneCombo.getText();
    }

    public File getDumpPath() {
        return storePicker.getPathOfFile();
    }

    PageDb(String pageName, IPreferenceStore mainPrefs) {
        super(pageName, pageName, null);
        this.mainPrefs = mainPrefs;

        setTitle(Messages.NewProjWizard_proj_init);
        setDescription(Messages.NewProjWizard_proj_init_src);
    }

    @Override
    public void createControl(final Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout(3,false));

        //char sets
        new Label(container, SWT.NONE).setText(Messages.NewProjWizard_select_charset);

        GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
        data.horizontalSpan = 2;
        charsetCombo = new Combo(container, SWT.DROP_DOWN );
        charsetCombo.setLayoutData(data);
        charsetCombo.setItems((String[]) UIConsts.ENCODINGS.toArray());
        //set default encoding UTF-8
        charsetCombo.select(0);

        //time zones
        new Label(container, SWT.NONE).setText(Messages.NewProjWizard_select_time_zone);

        timezoneCombo = new Combo(container, SWT.NONE);
        timezoneCombo.setItems((String[]) UIConsts.TIME_ZONES.toArray());
        timezoneCombo.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
        //set default time zone UTC
        timezoneCombo.select(12);

        Button time = new Button(container,SWT.PUSH);
        time.setText(Messages.NewProjWizard_get_from_db);
        time.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                try{
                    String timezone = new JdbcTimezone().getTimeZone( getDbInfo().getDbHost(),
                            getDbInfo().getDbPort(), getDbInfo().getDbUser(),
                            getDbInfo().getDbPass(), getDbInfo().getDbName(),
                            ApgdiffConsts.UTF_8, ApgdiffConsts.UTC);
                    if (timezone!=null){
                        timezoneCombo.setText(timezone);
                        setMessage(null);
                    } else {
                        setMessage(Messages.NewProjWizard_cannot_read_timezone, WARNING);
                    }
                }
                catch (NullPointerException npe) {
                    setMessage(Messages.NewProjWizard_incorrect_data_source, WARNING);
                }
            }
        });

        //initial block
        Group group = new Group(container, SWT.NONE);
        data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
        data.horizontalSpan = 3;
        group.setLayoutData(data);
        group.setLayout(new GridLayout());
        group.setText(Messages.NewProjWizard_initializing_title);

        initial = new Button(group, SWT.CHECK);
        initial.setSelection(true);
        initial.setText(Messages.NewProjWizard_initializing_check);
        initial.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                storePicker.initial(initial.getSelection());
                getWizard().getContainer().updateButtons();
            }
        });
        initial.pack();

        storePicker = new DbStorePicker(group, SWT.NONE, mainPrefs, true, false);
        storePicker.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
        storePicker.addListenerToCombo(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                getWizard().getContainer().updateButtons();
                getWizard().getContainer().updateMessage();
            }
        });
        storePicker.pack();

        setControl(container);
    }

    @Override
    public boolean isPageComplete() {
        return !initial.getSelection() || storePicker.getDbInfo() != null || storePicker.getPathOfFile() != null ;
    }
}