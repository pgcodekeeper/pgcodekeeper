package ru.taximaxim.codekeeper.ui.editors;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.MultiPageEditorPart;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTreeApplier;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyTreeExtender;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts.COMMIT_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.HELP;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.consoles.ConsoleFactory;
import ru.taximaxim.codekeeper.ui.dialogs.CommitDialog;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.dialogs.ManualDepciesDialog;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.differ.DiffPresentationPane;
import ru.taximaxim.codekeeper.ui.differ.DiffTableViewer;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.fileutils.ProjectUpdater;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.sqledit.SqlScriptDialog;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class ProjectEditorDiffer extends MultiPageEditorPart implements IResourceChangeListener {

    private PgDbProject proj;
    private DiffPresentationPane commit, diff;
    private Image iCommit, iDiff;
    
    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        if (!(input instanceof ProjectEditorInput)) {
            throw new PartInitException(Messages.ProjectEditorDiffer_error_bad_input_type);
        }
        ProjectEditorInput in = (ProjectEditorInput) input;
        this.proj = new PgDbProject(ResourcesPlugin.getWorkspace().getRoot()
                .getProject(in.getProjectName()));
        setPartName(in.getName());
        super.init(site, input);
        ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
    }
    
    @Override
    protected void createPages() {
        int i;
        commit = new CommitPage(getContainer(), 
                Activator.getDefault().getPreferenceStore(), proj);
        i = addPage(commit);
        
        setPageText(i, Messages.ProjectEditorDiffer_page_text_commit);
        iCommit = ImageDescriptor.createFromURL(Activator.getContext().getBundle()
                .getResource(FILE.ICONBALLBLUE)).createImage();
        setPageImage(i, iCommit);
        
        diff = new DiffPage(getContainer(), 
                Activator.getDefault().getPreferenceStore(), proj);
        i = addPage(diff);
        
        setPageText(i, Messages.ProjectEditorDiffer_page_text_diff);
        iDiff = ImageDescriptor.createFromURL(Activator.getContext().getBundle()
                .getResource(FILE.ICONBALLRED)).createImage();
        setPageImage(i, iDiff);
    }

    @Override
    public void doSave(IProgressMonitor monitor) {
    }

    @Override
    public void doSaveAs() {
    }

    @Override
    public boolean isSaveAsAllowed() {
        return false;
    }
    
    @Override
    public void dispose() {
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
        
        super.dispose();
        iCommit.dispose();
        iDiff.dispose();
    }
    
    @Override
    public void resourceChanged(IResourceChangeEvent event) {
        switch (event.getType()) {
        case IResourceChangeEvent.PRE_CLOSE:
        case IResourceChangeEvent.PRE_DELETE:
            handlerCloseProject(event);
            break;
        case IResourceChangeEvent.POST_CHANGE:
            handleChangeProject(event);
            break;
        default:
            break;
        }
    }
    
    private void handlerCloseProject(IResourceChangeEvent event) {
        final IResource closingProject = event.getResource();
        Display.getDefault().asyncExec(new Runnable(){
            @Override
            public void run() {
                for (IWorkbenchPage page : getSite().getWorkbenchWindow().getPages()) {
                    ProjectEditorInput editorInput = 
                            (ProjectEditorInput) ProjectEditorDiffer.this.getEditorInput();
                    if (editorInput.getName().equals(closingProject.getName()))
                        page.closeEditor(page.findEditor(editorInput), true);
                }
            }
        });
    }
    
    private void handleChangeProject(IResourceChangeEvent event) {
        IResourceDelta rootDelta = event.getDelta();
        IResourceDelta thisproj = rootDelta.findMember(proj.getProject().getFullPath());
        if (thisproj != null) {
            Display.getDefault().asyncExec(new Runnable() {
                
                @Override
                public void run() {
                    if (commit != null && !commit.isDisposed()) {
                        commit.reset();
                    }
                    if (diff != null && !diff.isDisposed()) {
                        diff.reset();
                    }                   
                }
            });
        }
    }
}

class CommitPage extends DiffPresentationPane {

    private final IPreferenceStore mainPrefs;
    private final PgDbProject proj;
    
    private Button btnSave;
    
    public CommitPage(Composite parent, IPreferenceStore mainPrefs,
            PgDbProject proj) {
        super(parent, true, mainPrefs, proj);
        
        this.mainPrefs = mainPrefs;
        this.proj = proj;
    }
    
    @Override
    protected void createUpperContainer(final Composite container, GridLayout gl) {
        container.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        btnSave = new Button(container, SWT.PUSH);
        btnSave.setLayoutData(new GridData(SWT.DEFAULT, SWT.FILL, false,
                false));
        btnSave.setText(Messages.commitPartDescr_commit);
        btnSave.setEnabled(false);
        btnSave.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                commit();
            }
        });
        PlatformUI.getWorkbench().getHelpSystem().setHelp(this, HELP.MAIN_EDITOR);
    }
    
    private void commit() {
        if (diffTable.getCheckedElementsCount() < 1){
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_INFORMATION);
            mb.setMessage(Messages.please_check_at_least_one_row);
            mb.setText(Messages.empty_selection);
            mb.open();
            return;
        }
        boolean considerDepcy = mainPrefs.getBoolean(COMMIT_PREF.CONSIDER_DEPCY_IN_COMMIT);
        
        final TreeElement filtered = diffTable.filterDiffTree();
        
        DepcyTreeExtender dte = null;
        HashSet<TreeElement> sumNewAndDelete = null;
        TreeElement filteredWithNewAndDelete = null;
        
        if(considerDepcy){
            // Получить список зависимых от NEW/EDIT элементов
            dte = new DepcyTreeExtender(dbSource.getDbObject(), 
                    dbTarget.getDbObject(), filtered);
            HashSet<PgStatement> dependencies = dte.getDependenciesOfNew();
            PgDatabase depcyTargetDb = dte.getDepcyTargetDb();
            
            // Дополнительно пометить в таблице зависимости от NEW/EDIT и
            // получить новое фильтрованное дерево с этими зависимостями
            HashSet<TreeElement> elementsNewEditDependentFrom = 
                    dte.getDepcyElementsContainedInDb(diffTable.getCheckedElements(false),
                            dependencies, depcyTargetDb); 
            
            diffTable.setCheckedElements(elementsNewEditDependentFrom, true);
            TreeElement filteredWithNew = diffTable.filterDiffTree();
            diffTable.setCheckedElements(elementsNewEditDependentFrom, false);

            // Расширить дерево filteredWithNew элементами, зависящими от удаляемых
            dte = new DepcyTreeExtender(dbSource.getDbObject(), 
                    dbTarget.getDbObject(), filteredWithNew);
            filteredWithNewAndDelete = dte.getTreeCopyWithDepcy();
            // Получить список всех зависимостей для заполнения нижней 
            // таблицы CommitDialog'a
            // Эти зависимости - потомки filteredWithNewAndDelete
            sumNewAndDelete = dte.sumAllDepcies(elementsNewEditDependentFrom);
        }
        
        // display commit dialog
        CommitDialog cd = new CommitDialog(getShell(), filtered, sumNewAndDelete,
                mainPrefs, proj, treeDiffer);
        cd.setConflictingElements(considerDepcy ? dte.getConflicting() : null);
        if (cd.open() != CommitDialog.OK) {
            return;
        }
        
        TreeElement filteredTwiceWithAllDepcy = null;
        if(considerDepcy){
            // Убрать из списка всех элементов в filteredWithNewAndDelete те
            // элементы, с которых пользователь снял отметку в нижней таблице
            // FIXME убрать шелл, отделить логику от UI
            DiffTableViewer diffTable = new DiffTableViewer(new Shell(), SWT.NONE, mainPrefs, true);
            diffTable.setFilteredInput(filteredWithNewAndDelete, treeDiffer, false);
            Set<TreeElement> allElements = diffTable.getCheckedElements(false);
            allElements.removeAll(cd.getBottomTableViewer().getCheckedElements(false));
            filteredTwiceWithAllDepcy = 
                    filteredWithNewAndDelete.getFilteredCopy(allElements);
        }
        
        final TreeElement resultingTree = considerDepcy ? filteredTwiceWithAllDepcy : filtered;

        Log.log(Log.LOG_INFO, "Updating project " + proj.getProjectName()); //$NON-NLS-1$
        Job job = new Job(Messages.projectEditorDiffer_save_project) {

            @Override
            protected IStatus run(IProgressMonitor monitor) {
                SubMonitor pm = SubMonitor.convert(monitor,
                        Messages.commitPartDescr_commiting, 2);

                pm.newChild(1).subTask(Messages.commitPartDescr_modifying_db_model); // 1
                DiffTreeApplier applier = new DiffTreeApplier(dbSource
                        .getDbObject(), dbTarget.getDbObject(),
                        resultingTree);
                
                PgDatabase dbNew = applier.apply();

                pm.newChild(1).subTask(Messages.commitPartDescr_exporting_db_model); // 2
                try {
                    new ProjectUpdater(dbNew, proj).update();
                    pm.done();
                } catch (IOException e) {
                    return new Status(Status.ERROR, PLUGIN_ID.THIS, 
                            Messages.ProjectEditorDiffer_commit_error, e);
                }
                if (monitor.isCanceled()) {
                    return Status.CANCEL_STATUS;
                }
                return Status.OK_STATUS;
            }
        };
        
        job.addJobChangeListener(new JobChangeAdapter() {
            
            @Override
            public void done(IJobChangeEvent event) {
                if (event.getResult().isOK()) {
                    ConsoleFactory.write(Messages.commitPartDescr_success_project_updated);
                    try {
                        proj.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
                    } catch (CoreException e) {
                        ExceptionNotifier.showErrorDialog(Messages.ProjectEditorDiffer_error_refreshing_project, e);
                    }
                }
            }
        });
        job.setUser(true);
        job.schedule();
    }
    
    @Override
    public final void reset() {
        btnSave.setEnabled(false);
        super.reset();
    }
    
    @Override
    protected final void diffLoaded() {
        btnSave.setEnabled(true);
    }
}

class DiffPage extends DiffPresentationPane {
    
    private final IPreferenceStore mainPrefs;
    
    private Button btnGetLatest, btnAddDepcy;

    /**
     * A collection of manually added object dependencies.
     * Keys are dependants, values are lists of dependencies.
     */
    private List<Entry<PgStatement, PgStatement>> manualDepciesSource = new LinkedList<>();
    private List<Entry<PgStatement, PgStatement>> manualDepciesTarget = new LinkedList<>();

    public DiffPage(Composite parent, IPreferenceStore mainPrefs,
            PgDbProject proj) {
        super(parent, false, mainPrefs, proj);
        this.mainPrefs = mainPrefs;
    }
    
    @Override
    protected void createUpperContainer(Composite container, GridLayout gl) {
        gl.numColumns = 2;
        container.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        btnGetLatest = new Button(container, SWT.PUSH);
        btnGetLatest.setText(Messages.diffPartDescr_get_latest);
        btnGetLatest.setEnabled(false);
        btnGetLatest.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    diff();
                } catch (PgCodekeeperUIException e1) {
                    ExceptionNotifier.showErrorDialog(Messages.ProjectEditorDiffer_diff_error, e1);
                }
            }
        });
        
        btnAddDepcy = new Button(container, SWT.PUSH);
        btnAddDepcy.setText(Messages.diffPartDescr_add_dependencies);
        btnAddDepcy.setEnabled(false);
        btnAddDepcy.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                ManualDepciesDialog dialog = new ManualDepciesDialog(getShell(),
                        manualDepciesSource, manualDepciesTarget,
                        dbSource.getDbObject().flatten(),
                        dbTarget.getDbObject().flatten(),
                        Messages.database, Messages.ProjectEditorDiffer_project);
                if (dialog.open() == Dialog.OK) {
                    manualDepciesSource = dialog.getDepciesSourceList();
                    manualDepciesTarget = dialog.getDepciesTargetList();
                }
            }
        });
        PlatformUI.getWorkbench().getHelpSystem().setHelp(this, HELP.MAIN_EDITOR);
    }
    
    private void diff() throws PgCodekeeperUIException {
        if (diffTable.getCheckedElementsCount() < 1){
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_INFORMATION);
            mb.setMessage(Messages.please_check_at_least_one_row);
            mb.setText(Messages.empty_selection);
            mb.open();
            return;
        }
        final TreeElement filtered = diffTable.filterDiffTree();

        final Differ differ = new Differ(
                DbSource.fromFilter(dbSource, filtered, DiffSide.LEFT),
                DbSource.fromFilter(dbTarget,filtered, DiffSide.RIGHT),
                false);
        differ.setFullDbs(dbSource.getDbObject(), dbTarget.getDbObject());
        differ.setAdditionalDepciesSource(manualDepciesSource);
        differ.setAdditionalDepciesTarget(manualDepciesTarget);
        
        Job job = differ.getDifferJob();
        job.addJobChangeListener(new JobChangeAdapter() {
            
            @Override
            public void done(IJobChangeEvent event) {
                if (event.getResult().isOK()) {
                    Display.getDefault().asyncExec(new Runnable() {
                        
                        @Override
                        public void run() {
                            if (DiffPage.this.isDisposed()) {
                                return;
                            }
                            showScriptDialog(differ);
                        }
                    });
                }
            }
        });
        job.setUser(true);
        job.schedule();
    }
    
    private void showScriptDialog(Differ differ) {
        SqlScriptDialog dialog = new SqlScriptDialog(getShell(),
                MessageDialog.INFORMATION, Messages.diffPartDescr_diff_script,
                Messages.diffPartDescr_this_will_apply_selected_changes_to_your_database,
                differ, dbSource.getDbObject().flatten(), 
                mainPrefs.getBoolean(DB_UPDATE_PREF.USE_PSQL_DEPCY));
        dialog.setDangerStatements(
                mainPrefs.getBoolean(DB_UPDATE_PREF.DROP_TABLE_STATEMENT), 
                mainPrefs.getBoolean(DB_UPDATE_PREF.ALTER_COLUMN_STATEMENT),
                mainPrefs.getBoolean(DB_UPDATE_PREF.DROP_COLUMN_STATEMENT));
        if (btnPgDump.getSelection() || btnJdbc.getSelection()) {
            dialog.setDbParams(dbSrc.txtDbHost.getText(),
                    dbSrc.txtDbPort.getText(), dbSrc.txtDbName.getText(),
                    dbSrc.txtDbUser.getText(), dbSrc.txtDbPass.getText());
        }
        dialog.open();
    }
    
    @Override
    public final void reset() {
        setButtonsClearDepcies(false);
        super.reset();
    }

    @Override
    protected final void diffLoaded() {
        setButtonsClearDepcies(true);
    }
    
    private void setButtonsClearDepcies(boolean state) {
        btnGetLatest.setEnabled(state);
        btnAddDepcy.setEnabled(state);
        manualDepciesSource.clear();
        manualDepciesTarget.clear();
    }
}
