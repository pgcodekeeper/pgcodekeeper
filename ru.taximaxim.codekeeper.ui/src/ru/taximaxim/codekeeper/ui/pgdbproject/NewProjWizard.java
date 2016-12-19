package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
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
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
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
        return new File(pageRepo.getLocationPath().toFile(), ApgdiffConsts.FILENAME_WORKING_DIR_MARKER)
                .exists();
    }

    @Override
    public boolean canFinish() {
        if (getContainer().getCurrentPage() == pageRepo) {
            if (checkMarkerExist()) {
                return true;
            }
        }
        return super.canFinish();
    }

    @Override
    public boolean performFinish() {
        try {
            props = PgDbProject.getProjectFromIProjectHandle(
                    pageRepo.getProjectHandle(),
                    pageRepo.useDefaults() ? null : pageRepo.getLocationURI());
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
            workbench.getWorkingSetManager().addToWorkingSets(props.getProject(), workingSets);

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
        String charset;
        try {
            charset = props.getProjectCharset();
        } catch (CoreException ex) {
            throw new PgCodekeeperUIException(ex.getLocalizedMessage(), ex);
        }
        if (dbinfo != null) {
            String tz = props.getPrefs().get(PROJ_PREF.TIMEZONE, ApgdiffConsts.UTC);
            src = DbSource.fromDbInfo(dbinfo, mainPrefStore, forceUnixNewlines, charset, tz);
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

    private DbStorePicker storePicker;

    public DbInfo getDbInfo() {
        return storePicker.getDbInfo();
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
        container.setLayout(new FillLayout());

        storePicker = new DbStorePicker(container, SWT.NONE, mainPrefs, true, false);
        storePicker.addListenerToCombo(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                getWizard().getContainer().updateButtons();
                getWizard().getContainer().updateMessage();
            }
        });

        setControl(container);
    }

    @Override
    public boolean isPageComplete() {
        return storePicker.getDbInfo() != null || storePicker.getPathOfFile() != null;
    }
}