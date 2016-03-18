package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.help.IWorkbenchHelpSystem;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.osgi.service.prefs.BackingStoreException;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts.DBSources;
import ru.taximaxim.codekeeper.ui.UIConsts.HELP;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbStorePicker;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
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

    public NewProjWizard() {
        setWindowTitle(Messages.newProjWizard_new_pg_db_project);
        setNeedsProgressMonitor(true);
        this.mainPrefStore = Activator.getDefault().getPreferenceStore();
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
        URI loc = pageRepo.getLocationURI();
        if (loc == null || (loc != null && !loc.isAbsolute())) {
            return false;
        }
        File sub = new File(loc);
        if (!new File(sub, ApgdiffConsts.FILENAME_WORKING_DIR_MARKER).exists()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean canFinish() {
        if (getContainer().getCurrentPage() == pageRepo && !checkMarkerExist()) {
            return false;
        }
        return super.canFinish();
    }

    @Override
    public boolean performFinish() {
        try {
            props = PgDbProject.getProjectFromIProjectHandle(
                    pageRepo.getProjectHandle(),
                    pageRepo.useDefaults() ? null : pageRepo.getLocationURI());

            Log.log(Log.LOG_INFO, "Creating new project properties"); //$NON-NLS-1$

            fillProjProps();

            if (!checkMarkerExist()) {
                try {
                    getContainer().run(true, true,
                            new InitProjectFromSource(mainPrefStore, props,
                                    pageDb.getDumpPath(), pageDb.getDbPass()));
                } catch (InvocationTargetException ex) {
                    props.deleteFromWorkspace();
                    ExceptionNotifier.notifyDefault(
                            Messages.newProjWizard_error_in_initializing_repo_from_source, ex);
                    return false;
                } catch (InterruptedException ex) {
                    // cancelled
                    props.deleteFromWorkspace();
                    return false;
                }
            }

            BasicNewProjectResourceWizard.updatePerspective(config);
            BasicNewResourceWizard.selectAndReveal(props.getProject(),
                    workbench.getActiveWorkbenchWindow());

            props.openProject();
            try {
                PgDbProject.addNatureToProject(props.getProject());
                props.getPrefs().flush();
            } catch (BackingStoreException e) {
                ExceptionNotifier.notifyDefault(
                        Messages.NewProjWizard_error_saving_projprefs, e);
                return false;
            } catch (CoreException e) {
                ExceptionNotifier.notifyDefault(
                        Messages.NewProjWizard_error_adding_nature, e);
                return false;
            }

            IWorkingSet[] workingSets = pageRepo.getSelectedWorkingSets();
            workbench.getWorkingSetManager().addToWorkingSets(props.getProject(),
                    workingSets);

            OpenEditor.openEditor(PlatformUI.getWorkbench()
                    .getActiveWorkbenchWindow().getActivePage(),
                    props.getProject());
        } catch (PgCodekeeperUIException e) {
            ExceptionNotifier.notifyDefault(Messages.NewProjWizard_error_creating_project, e);
            return false;
        }
        return true;
    }

    private void fillProjProps() {
        IEclipsePreferences newPrefs = props.getPrefs();
        setDbSource(newPrefs);
        newPrefs.put(PROJ_PREF.DB_NAME, pageDb.getDbName());
        newPrefs.put(PROJ_PREF.DB_USER, pageDb.getDbUser());
        newPrefs.put(PROJ_PREF.DB_HOST, pageDb.getDbHost());
        newPrefs.putInt(PROJ_PREF.DB_PORT, pageDb.getDbPort());
    }

    private void setDbSource(IEclipsePreferences newPrefs) {
        DBSources src;
        if (pageDb.isSourceDb()) {
            src = DBSources.SOURCE_TYPE_DB;
        } else if (pageDb.isSourceDump()) {
            src = DBSources.SOURCE_TYPE_DUMP;
        } else if (pageDb.isSourceJdbc()) {
            src = DBSources.SOURCE_TYPE_JDBC;
        } else {
            ExceptionNotifier.notifyDefault(
                    Messages.newProjWizard_no_schema_source_selected, null);
            return;
        }
        newPrefs.put(PROJ_PREF.SOURCE, src.toString());
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

class PageDb extends WizardPage implements Listener {

    private final IPreferenceStore mainPrefs;

    private Composite container;
    private DbStorePicker storePicker;

    public boolean isSourceDb() {
        return (storePicker.getDbInfo() != null && mainPrefs.getBoolean(PREF.PGDUMP_SWITCH)) ? true : false;
    }

    public boolean isSourceDump() {
        return (storePicker.getPathOfFile() != null && !storePicker.getPathOfFile().isEmpty()) ? true : false;
    }

    public boolean isSourceJdbc() {
        if (storePicker.getDbInfo() != null && !mainPrefs.getBoolean(PREF.PGDUMP_SWITCH)){
            return true;
        } else{
            return false;
        }
    }

    public String getDbName() {
        return storePicker.getDbInfo().getDbname();
    }

    public String getDbUser() {
        return storePicker.getDbInfo().getDbuser();
    }

    public String getDbPass() {
        return storePicker.getDbInfo().getDbpass();
    }

    public String getDbHost() {
        return storePicker.getDbInfo().getDbhost();
    }

    public int getDbPort() {
        return storePicker.getDbInfo().getDbport();
    }

    public String getDumpPath() {
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
        container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout(2, false));
        
        storePicker = new DbStorePicker(container, SWT.NONE, false, mainPrefs, true);
        storePicker.addListenerToCombo(SWT.Selection, this);

        setControl(container);
    }

    @Override
    public boolean isPageComplete() {
        if (storePicker.getDbInfo() != null || storePicker.getPathOfFile() != null){
            setErrorMessage(null);
            return true;
        } else {
            setErrorMessage("Select a db store or dump file!");
            return false;
        }
    }

    @Override
    public void handleEvent(Event event) {
        getWizard().getContainer().updateButtons();
        getWizard().getContainer().updateMessage();
    }
}