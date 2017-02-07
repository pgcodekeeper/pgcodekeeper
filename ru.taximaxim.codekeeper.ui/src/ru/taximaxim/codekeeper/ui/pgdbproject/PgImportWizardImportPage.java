package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardDataTransferPage;
import org.eclipse.ui.dialogs.WorkingSetGroup;
import org.eclipse.ui.statushandlers.StatusManager;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.IMPORT_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class PgImportWizardImportPage extends WizardDataTransferPage {

    public static final String METADATA_FOLDER = ".metadata"; //$NON-NLS-1$
    private final static String STORE_DIRECTORIES = "WizardProjectsImportPage.STORE_DIRECTORIES";//$NON-NLS-1$
    private final static String STORE_NESTED_PROJECTS = "WizardProjectsImportPage.STORE_NESTED_PROJECTS"; //$NON-NLS-1$
    private Combo directoryPathField;
    private CheckboxTreeViewer projectsList;
    private Button nestedProjectsCheckbox;
    private boolean nestedProjects = false;
    private ProjectRecord[] selectedProjects = new ProjectRecord[0];
    private static String previouslyBrowsedDirectory = ""; //$NON-NLS-1$
    private Button browseDirectoriesButton;
    private String lastPath;
    private WorkingSetGroup workingSetGroup;
    private final IStructuredSelection currentSelection;
    private Button hideConflictingProjects;
    private final ConflictingProjectFilter conflictingProjectsFilter = new ConflictingProjectFilter();

    public PgImportWizardImportPage(String pageName) {
        super(pageName);
        this.currentSelection = null;
        setPageComplete(false);
        setTitle(Messages.PgImportWizardImportPage_project);
        setDescription(Messages.PgImportWizardImportPage_select_project);
    }

    @Override
    public void createControl(Composite parent) {

        initializeDialogUnits(parent);
        Composite workArea = new Composite(parent, SWT.NONE);
        setControl(workArea);

        workArea.setLayout(new GridLayout());
        workArea.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));

        createProjectsRoot(workArea);
        createProjectsList(workArea);
        createOptionsGroup(workArea);
        createWorkingSetGroup(workArea);
        restoreWidgetValues();
        Dialog.applyDialogFont(workArea);

    }

    private void createWorkingSetGroup(Composite workArea) {
        String[] workingSetIds = new String[] { IMPORT_PREF.RESOURCE_WORKING_SET, IMPORT_PREF.JAVA_WORKING_SET };
        workingSetGroup = new WorkingSetGroup(workArea, currentSelection, workingSetIds);
    }

    @Override
    protected void createOptionsGroupButtons(Group optionsGroup) {
        nestedProjectsCheckbox = new Button(optionsGroup, SWT.CHECK);
        nestedProjectsCheckbox.setText(Messages.PgImportWizardImportPage_nested_search);
        nestedProjectsCheckbox.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        nestedProjectsCheckbox.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                nestedProjects = nestedProjectsCheckbox.getSelection();
                updateProjectsList(directoryPathField.getText().trim(), true);
            }
        });

        hideConflictingProjects = new Button(optionsGroup, SWT.CHECK);
        hideConflictingProjects.setText(Messages.PgImportWizardImportPage_hide_project);
        hideConflictingProjects.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        hideConflictingProjects.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                projectsList.removeFilter(conflictingProjectsFilter);
                if (hideConflictingProjects.getSelection()) {
                    projectsList.addFilter(conflictingProjectsFilter);
                }
            }
        });
        Dialog.applyDialogFont(hideConflictingProjects);
    }

    private void createProjectsList(Composite workArea) {

        Label title = new Label(workArea, SWT.NONE);
        title.setText(Messages.PgImportWizardImportPage_projects);

        Composite listComposite = new Composite(workArea, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        layout.marginWidth = 0;
        layout.makeColumnsEqualWidth = false;
        listComposite.setLayout(layout);

        listComposite
        .setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL | GridData.FILL_BOTH));

        projectsList = new CheckboxTreeViewer(listComposite, SWT.BORDER);
        GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
        gridData.widthHint = new PixelConverter(projectsList.getControl()).convertWidthInCharsToPixels(25);
        gridData.heightHint = new PixelConverter(projectsList.getControl()).convertHeightInCharsToPixels(10);
        projectsList.getControl().setLayoutData(gridData);
        projectsList.setContentProvider(new ITreeContentProvider() {

            @Override
            public Object[] getChildren(Object parentElement) {
                return null;
            }

            @Override
            public Object[] getElements(Object inputElement) {
                return getProjectRecords();
            }

            @Override
            public boolean hasChildren(Object element) {
                return false;
            }

            @Override
            public Object getParent(Object element) {
                return null;
            }

            @Override
            public void dispose() {

            }

            @Override
            public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

            }

        });

        projectsList.setLabelProvider(new ProjectLabelProvider());

        projectsList.addCheckStateListener(new ICheckStateListener() {
            @Override
            public void checkStateChanged(CheckStateChangedEvent event) {
                ProjectRecord element = (ProjectRecord) event.getElement();
                if (element.hasConflicts() || element.isInvalidProject()) {
                    projectsList.setChecked(element, false);
                }
                setPageComplete(projectsList.getCheckedElements().length > 0);
            }
        });

        projectsList.setInput(this);
        projectsList.setComparator(new ViewerComparator());
        createSelectionButtons(listComposite);
    }

    private void createSelectionButtons(Composite listComposite) {
        Composite buttonsComposite = new Composite(listComposite, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.marginWidth = 0;
        layout.marginHeight = 0;
        buttonsComposite.setLayout(layout);

        buttonsComposite.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));

        Button selectAll = new Button(buttonsComposite, SWT.PUSH);
        selectAll.setText(Messages.PgImportWizardImportPage_select_all);
        selectAll.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                for (ProjectRecord selectedProject : selectedProjects) {
                    if (selectedProject.hasConflicts() || selectedProject.isInvalidProject()) {
                        projectsList.setChecked(selectedProject, false);
                    } else {
                        projectsList.setChecked(selectedProject, true);
                    }
                }
                setPageComplete(projectsList.getCheckedElements().length > 0);
            }
        });
        Dialog.applyDialogFont(selectAll);
        setButtonLayoutData(selectAll);

        Button deselectAll = new Button(buttonsComposite, SWT.PUSH);
        deselectAll.setText(Messages.PgImportWizardImportPage_deselect_all);
        deselectAll.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {

                projectsList.setCheckedElements(new Object[0]);
                setPageComplete(false);
            }
        });
        Dialog.applyDialogFont(deselectAll);
        setButtonLayoutData(deselectAll);

        Button refresh = new Button(buttonsComposite, SWT.PUSH);
        refresh.setText(Messages.PgImportWizardImportPage_refresh);
        refresh.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                updateProjectsList(directoryPathField.getText().trim(), true);
            }
        });
        Dialog.applyDialogFont(refresh);
        setButtonLayoutData(refresh);
    }

    private void createProjectsRoot(Composite workArea) {

        Composite projectGroup = new Composite(workArea, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        layout.makeColumnsEqualWidth = false;
        layout.marginWidth = 0;
        projectGroup.setLayout(layout);
        projectGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(projectGroup, SWT.NONE).setText(Messages.PgImportWizardImportPage_select_root_directory);

        // project location entry combo
        this.directoryPathField = new Combo(projectGroup, SWT.BORDER);

        GridData directoryPathData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
        directoryPathData.widthHint = new PixelConverter(directoryPathField).convertWidthInCharsToPixels(25);
        directoryPathField.setLayoutData(directoryPathData);

        // browse button
        browseDirectoriesButton = new Button(projectGroup, SWT.PUSH);
        browseDirectoriesButton.setText(Messages.PgImportWizardImportPage_browse);
        setButtonLayoutData(browseDirectoriesButton);

        browseDirectoriesButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                handleLocationDirectoryButtonPressed();
            }

        });

        directoryPathField.addTraverseListener(new TraverseListener() {
            @Override
            public void keyTraversed(TraverseEvent e) {
                if (e.detail == SWT.TRAVERSE_RETURN) {
                    e.doit = false;
                    updateProjectsList(directoryPathField.getText().trim(), false);
                }
            }

        });

        directoryPathField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(org.eclipse.swt.events.FocusEvent e) {
                updateProjectsList(directoryPathField.getText().trim(), false);
            }

        });

        directoryPathField.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                updateProjectsList(directoryPathField.getText().trim(), false);
            }
        });
    }

    private void updateProjectsList(final String path, boolean forceUpdate) {
        // on an empty path empty selectedProjects
        if (path == null || path.length() == 0) {
            setMessage(Messages.PgImportWizardImportPage_description);
            selectedProjects = new ProjectRecord[0];
            projectsList.refresh(true);
            projectsList.setCheckedElements(selectedProjects);
            setPageComplete(projectsList.getCheckedElements().length > 0);
            lastPath = path;
            return;
        }

        final File directory = new File(path);
        if (path.equals(lastPath) && !forceUpdate) {
            return;
        }
        try {
            getContainer().run(true, true, new IRunnableWithProgress() {
                @Override
                public void run(IProgressMonitor monitor) {

                    monitor.beginTask(Messages.PgImportWizardImportPage_searching_for_project, 100);
                    selectedProjects = new ProjectRecord[0];
                    Collection <File> files = new ArrayList <>();
                    monitor.worked(10);

                    if (directory.isDirectory()) {

                        if (!collectProjectFilesFromDirectory(files, directory, null, monitor)) {
                            return;
                        }
                        Iterator <File> filesIterator = files.iterator();
                        selectedProjects = new ProjectRecord[files.size()];
                        int index = 0;
                        monitor.worked(50);
                        monitor.subTask(Messages.PgImportWizardImportPage_progressing_result);
                        while (filesIterator.hasNext()) {
                            File file = new File(filesIterator.next().getAbsolutePath().
                                    replace(ApgdiffConsts.FILENAME_WORKING_DIR_MARKER,
                                            IProjectDescription.DESCRIPTION_FILE_NAME));
                            selectedProjects[index] = new ProjectRecord(file);
                            index++;
                        }
                    } else {
                        monitor.worked(60);
                    }
                    monitor.done();
                }

            });
        } catch (InterruptedException e) {
            // Nothing to do if the user interrupts.
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        lastPath = path;
        updateProjectsStatus();
    }

    private void updateProjectsStatus() {
        projectsList.refresh(true);
        ProjectRecord[] projects = getProjectRecords();

        boolean displayConflictWarning = false;
        boolean displayInvalidWarning = false;

        for (ProjectRecord project : projects) {
            if (project.hasConflicts() || project.isInvalidProject()) {
                projectsList.setGrayed(project, true);
                displayConflictWarning |= project.hasConflicts();
                displayInvalidWarning |= project.isInvalidProject();
            } else {
                projectsList.setChecked(project, true);
            }
        }

        if (displayConflictWarning && displayInvalidWarning) {
            setMessage(Messages.PgImportWizardImportPage_exist_or_corrupted, WARNING);
        } else if (displayConflictWarning) {
            setMessage(Messages.PgImportWizardImportPage_already_exist, WARNING);
        } else if (displayInvalidWarning) {
            setMessage(Messages.PgImportWizardImportPage_description_is_corrupted, WARNING);
        } else {
            setMessage(Messages.PgImportWizardImportPage_some_problem);
        }
        setPageComplete(projectsList.getCheckedElements().length > 0);
        if (selectedProjects.length == 0) {
            setMessage(Messages.PgImportWizardImportPage_no_project, WARNING);
        }
    }

    private boolean collectProjectFilesFromDirectory(Collection <File> files, File directory, Set <String> directoriesVisited,
            IProgressMonitor monitor) {

        if (monitor.isCanceled()) {
            return false;
        }
        monitor.subTask(NLS.bind(Messages.PgImportWizardImportPage_cheching, directory.getPath()));
        File[] contents = directory.listFiles();
        if (contents == null) {
            return false;
        }

        // Initialize recursion guard for recursive symbolic links
        if (directoriesVisited == null) {
            directoriesVisited = new HashSet<>();
            try {
                directoriesVisited.add(directory.getCanonicalPath());
            } catch (IOException e) {
                StatusManager.getManager().
                handle(new Status(IStatus.ERROR, IMPORT_PREF.ECLIPSE_IDE, 1, "Error: " + e, e)); //$NON-NLS-1$
            }
        }

        for (File file : contents) {
            if (file.isFile() && file.getName().equals(ApgdiffConsts.FILENAME_WORKING_DIR_MARKER)) {
                files.add(file);
                if (!nestedProjects) {
                    return true;
                }
            }
        }

        for (int i = 0; i < contents.length; i++) {
            if (contents[i].isDirectory()) {
                if (!contents[i].getName().equals(METADATA_FOLDER)) {
                    try {
                        String canonicalPath = contents[i].getCanonicalPath();
                        if (!directoriesVisited.add(canonicalPath)) {
                            continue;
                        }
                    } catch (IOException e) {
                        StatusManager.getManager().
                        handle(new Status(IStatus.ERROR, IMPORT_PREF.ECLIPSE_IDE, 1, "Error: " + e, e)); //$NON-NLS-1$
                    }
                    collectProjectFilesFromDirectory(files, contents[i], directoriesVisited, monitor);
                }
            }
        }
        return true;
    }

    protected void handleLocationDirectoryButtonPressed() {

        DirectoryDialog dialog = new DirectoryDialog(directoryPathField.getShell(), SWT.SHEET);
        dialog.setMessage(Messages.PgImportWizardImportPage_select_root_for_import);

        String dirName = directoryPathField.getText().trim();
        if (dirName.length() == 0) {
            dirName = previouslyBrowsedDirectory;
        }

        if (dirName.length() == 0) {
            dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());
        } else {
            File path = new File(dirName);
            if (path.exists()) {
                dialog.setFilterPath(new Path(dirName).toOSString());
            }
        }

        String selectedDirectory = dialog.open();
        if (selectedDirectory != null) {
            previouslyBrowsedDirectory = selectedDirectory;
            directoryPathField.setText(previouslyBrowsedDirectory);
            updateProjectsList(selectedDirectory, false);
        }

    }

    public boolean createProjects() {
        saveWidgetValues();

        final Object[] selected = projectsList.getCheckedElements();
        createdProjects = new ArrayList<>();
        WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
            @Override
            protected void execute(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                try {
                    monitor.beginTask("", selected.length); //$NON-NLS-1$
                    if (monitor.isCanceled()) {
                        throw new OperationCanceledException();
                    }
                    // Import as many projects as we can; accumulate errors to
                    // report to the user
                    MultiStatus status = new MultiStatus(IMPORT_PREF.ECLIPSE_IDE, 1,
                            Messages.PgImportWizardImportPage_exist_or_corrupted, null);
                    for (Object element : selected) {
                        status.add(createExistingProject((ProjectRecord) element, SubMonitor.convert(monitor,1)));
                    }
                    if (!status.isOK()) {
                        throw new InvocationTargetException(new CoreException(status));
                    }
                } finally {
                    monitor.done();
                }
            }
        };
        try {
            getContainer().run(true, true, op);
        } catch (InterruptedException e) {
            return false;
        } catch (InvocationTargetException e) {
            Throwable t = e.getTargetException();
            String message = Messages.PgImportWizardImportPage_creation_problem;
            IStatus status;
            if (t instanceof CoreException) {
                status = ((CoreException) t).getStatus();
            } else {
                status = new Status(IStatus.ERROR, IMPORT_PREF.ECLIPSE_IDE, 1, message, t);
            }
            updateProjectsStatus();
            ErrorDialog.openError(getShell(), message, null, status);
            return false;
        } finally {
            addToWorkingSets();
        }
        return true;
    }

    List<IProject> createdProjects;

    private void addToWorkingSets() {

        IWorkingSet[] selectedWorkingSets = workingSetGroup.getSelectedWorkingSets();
        if (selectedWorkingSets == null || selectedWorkingSets.length == 0) {
            return; // no Working set is selected
        }
        IWorkingSetManager workingSetManager = PlatformUI.getWorkbench().getWorkingSetManager();
        for (IProject element : createdProjects) {
            workingSetManager.addToWorkingSets(element, selectedWorkingSets);
        }
    }

    public IStatus createExistingProject(final ProjectRecord record, IProgressMonitor monitor)
            throws InterruptedException {
        String projectName = record.getProjectName();
        final IWorkspace workspace = ResourcesPlugin.getWorkspace();
        final IProject project = workspace.getRoot().getProject(projectName);
        createdProjects.add(project);
        if (!project.exists()) {
            record.getDescription().setLocationURI(record.getProjectSystemFile().getParentFile().toURI());
            try {
                project.create(record.getDescription(), null);
                project.open(null);
                PgDbProject.addNatureToProject(project);
            } catch (CoreException e) {
                throw new InterruptedException(e.getMessage());
            }
        }
        return Status.OK_STATUS;
    }

    public CheckboxTreeViewer getProjectsList() {
        return projectsList;
    }

    private IProject[] getProjectsInWorkspace() {
        return ResourcesPlugin.getWorkspace().getRoot().getProjects();
    }

    public ProjectRecord[] getProjectRecords() {
        List<ProjectRecord> projectRecords = new ArrayList<>();
        for (ProjectRecord selectedProject : selectedProjects) {
            String projectName = selectedProject.getProjectName();
            selectedProject.setConflicts((isProjectInWorkspacePath(projectName))
                    || isProjectInWorkspace(projectName));
            projectRecords.add(selectedProject);
        }
        return projectRecords.toArray(new ProjectRecord[projectRecords.size()]);
    }

    private boolean isProjectInWorkspacePath(String projectName) {
        final IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IPath wsPath = workspace.getRoot().getLocation();
        IPath localProjectPath = wsPath.append(projectName);
        return localProjectPath.toFile().exists();
    }

    private boolean isProjectInWorkspace(String projectName) {
        if (projectName == null) {
            return false;
        }
        IProject[] workspaceProjects = getProjectsInWorkspace();
        for (IProject workspaceProject : workspaceProjects) {
            if (projectName.equals(workspaceProject.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void restoreWidgetValues() {
        IDialogSettings settings = getDialogSettings();
        if (settings != null) {
            restoreFromHistory(settings, STORE_DIRECTORIES, directoryPathField);
            nestedProjects = settings.getBoolean(STORE_NESTED_PROJECTS);
            nestedProjectsCheckbox.setSelection(nestedProjects);
        }

        if (settings != null) {
            updateProjectsList(directoryPathField.getText(), false);
        }
    }

    private void restoreFromHistory(IDialogSettings settings, String key, Combo combo) {
        String[] sourceNames = settings.getArray(key);
        if (sourceNames == null) {
            return;
        }

        for (String sourceName : sourceNames) {
            combo.add(sourceName);
        }
    }

    @Override
    public void saveWidgetValues() {
        IDialogSettings settings = getDialogSettings();
        if (settings != null) {
            saveInHistory(settings, STORE_DIRECTORIES, directoryPathField.getText());
            settings.put(STORE_NESTED_PROJECTS, nestedProjectsCheckbox.getSelection());
        }
    }

    private void saveInHistory(IDialogSettings settings, String key, String value) {
        String[] sourceNames = settings.getArray(key);
        if (sourceNames == null) {
            sourceNames = new String[0];
        }
        sourceNames = addToHistory(sourceNames, value);
        settings.put(key, sourceNames);
    }

    @Override
    public void handleEvent(Event event) {
    }

    @Override
    protected boolean allowNewContainerName() {
        return true;
    }

    private final class ConflictingProjectFilter extends ViewerFilter {
        @Override
        public boolean select(Viewer viewer, Object parentElement, Object element) {
            return !((ProjectRecord) element).hasConflicts();
        }
    }

    private final class ProjectLabelProvider extends LabelProvider implements IColorProvider {
        @Override
        public String getText(Object element) {
            return ((ProjectRecord) element).getProjectLabel();
        }

        @Override
        public Color getBackground(Object element) {
            return null;
        }

        @Override
        public Color getForeground(Object element) {
            ProjectRecord projectRecord = (ProjectRecord) element;
            if (projectRecord.hasConflicts() || projectRecord.isInvalidProject()) {
                return getShell().getDisplay().getSystemColor(SWT.COLOR_GRAY);
            }
            return null;
        }
    }
}