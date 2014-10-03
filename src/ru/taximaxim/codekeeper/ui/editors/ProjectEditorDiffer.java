package ru.taximaxim.codekeeper.ui.editors;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
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
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.XmlHistory;
import ru.taximaxim.codekeeper.ui.dialogs.CommitDialog;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.dialogs.ManualDepciesDialog;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.differ.DiffPresentationPane;
import ru.taximaxim.codekeeper.ui.differ.DiffTableViewer;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.fileutils.ProjectUpdater;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.parts.Console;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.sqledit.SqlScriptDialog;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class ProjectEditorDiffer extends MultiPageEditorPart {

    private PgDbProject proj;
    private DiffPresentationPane commit, diff;
    
    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        if (!(input instanceof ProjectEditorInput)) {
            throw new PartInitException("Input must be ProjectEditorInput");
        }
        ProjectEditorInput in = (ProjectEditorInput) input;
        this.proj = new PgDbProject(ResourcesPlugin.getWorkspace().getRoot()
                .getProject(in.getProjectName()));
        setPartName(in.getName());
        super.init(site, input);
        ResourcesPlugin.getWorkspace().addResourceChangeListener(editorUpdater);
    }
    
    @Override
    protected void createPages() {
        commit = new CommitPage(getContainer(), 
                Activator.getDefault().getPreferenceStore(), proj);
        setPageText(addPage(commit), "Commit");
        diff = new DiffPage(getContainer(), 
                Activator.getDefault().getPreferenceStore(), proj);
        setPageText(addPage(diff), "Diff");
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
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(editorUpdater);
        super.dispose();
    }
    
    private IResourceChangeListener editorUpdater = new IResourceChangeListener() {
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
    };
    
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
                    // TODO NPE
                    commit.reset();
                    diff.reset();                    
                }
            });
        }
    }
}

class CommitPage extends DiffPresentationPane {

    private final static String COMMENTS_HIST_ROOT = "comments"; //$NON-NLS-1$
    private final static String COMMENTS_HIST_EL = "c"; //$NON-NLS-1$
    private final static String COMMENTS_HIST_FILENAME = "commit_comments.xml"; //$NON-NLS-1$
    private final static int COMMENT_HIST_MAX_STORED = 40;
    
    private final IPreferenceStore mainPrefs;
    private final PgDbProject proj;
    private final XmlHistory history;
    
    private Text txtCommitComment;
    private Button btnPrevComments, btnCommit;
    
    public CommitPage(Composite parent, IPreferenceStore mainPrefs,
            PgDbProject proj) {
        super(parent, true, mainPrefs, proj);
        
        this.mainPrefs = mainPrefs;
        this.proj = proj;
        history = new XmlHistory.Builder(COMMENT_HIST_MAX_STORED, 
                COMMENTS_HIST_FILENAME, 
                COMMENTS_HIST_ROOT, 
                COMMENTS_HIST_EL).build();
    }
    
    @Override
    protected void createUpperContainer(final Composite container, GridLayout gl) {
        gl.numColumns = 3;
        container.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        txtCommitComment = new Text(container, SWT.BORDER | SWT.MULTI | 
                SWT.H_SCROLL | SWT.V_SCROLL);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.heightHint = 50;
        txtCommitComment.setLayoutData(gd);
        
        btnPrevComments = new Button(container, SWT.PUSH);
        btnPrevComments.setLayoutData(new GridData(SWT.DEFAULT, SWT.FILL, false,
                false));
        btnPrevComments.setText("\u25bc"); //$NON-NLS-1$
        btnPrevComments.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                showCommentsHistoryMenu(container);
            }
        });
        
        btnCommit = new Button(container, SWT.PUSH);
        btnCommit.setLayoutData(new GridData(SWT.DEFAULT, SWT.FILL, false,
                false));
        btnCommit.setText(Messages.commitPartDescr_commit);
        btnCommit.setEnabled(false);
        btnCommit.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                commit();
            }
        });
    }
    
    private void showCommentsHistoryMenu(Composite container) {
        List<String> comments = null;
        try {
            comments = history.getHistory();
        } catch (IOException e) {
           ExceptionNotifier.showErrorDialog("Cannot get comments", e);
        }
        MenuManager mmComments = new MenuManager();
        if (comments == null || comments.isEmpty()) {
            mmComments.add(new Action(Messages.commitPartDescr_no_previous_comments) {
                @Override
                public boolean isEnabled() {
                    return false;
                }
            });
        } else { 
            for (final String comment : comments) {
                String menuLabel = comment;
                if (menuLabel.length() > 120) {
                    menuLabel = menuLabel.substring(0, 120) + "..."; //$NON-NLS-1$
                }
                
                mmComments.add(new Action(menuLabel) {
                    @Override
                    public void run() {
                        txtCommitComment.setText(comment);
                        txtCommitComment.setFocus();
                    }
                });
            }
        }
        Menu menuComments = mmComments.createContextMenu(getShell());
        
        Point loc = btnPrevComments.getLocation();
        Rectangle rectBtn = btnPrevComments.getBounds();
        menuComments.setLocation(getShell().getDisplay().map(
                container, null,
                loc.x + rectBtn.width + 1, loc.y + rectBtn.height));
        menuComments.setVisible(true);
    }
    
    private void commit() {
        final String commitComment = txtCommitComment.getText();
        if (diffTable.getCheckedElementsCount() < 1){
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_INFORMATION);
            mb.setMessage(Messages.please_check_at_least_one_row);
            mb.setText(Messages.empty_selection);
            mb.open();
            return;
        }
        if (commitComment.isEmpty()) {
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_INFORMATION);
            mb.setMessage(Messages.commitPartDescr_comment_required);
            mb.setText(Messages.commitPartDescr_please_enter_a_comment_for_the_commit);
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
        
        try {
            history.addHistoryEntry(commitComment);
        } catch (IOException e) {
            ExceptionNotifier.showErrorDialog("Cannot add comment to history", e);
        }
        
        IRunnableWithProgress commitRunnable = new IRunnableWithProgress() {

            @Override
            public void run(IProgressMonitor monitor)
                    throws InvocationTargetException, InterruptedException {
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
                } catch (IOException e) {
                    throw new InvocationTargetException(e);
                }

                pm.done();
            }
        };

        try {
            Log.log(Log.LOG_INFO, "Commit pressed. Commiting to " + //$NON-NLS-1$
                    proj.getPrefs().get(PROJ_PREF.REPO_URL, ""));
            new ProgressMonitorDialog(getShell()).run(true, false, commitRunnable);
        } catch (InvocationTargetException ex) {
            throw new IllegalStateException(
                    Messages.error_in_the_project_modifier_thread, ex);
        } catch (InterruptedException ex) {
            // assume run() was called as non cancelable
            throw new IllegalStateException(
                    Messages.project_modifier_thread_cancelled_shouldnt_happen, ex);
        }

        Console.addMessage(Messages.commitPartDescr_success_project_updated);
    }
    
    @Override
    public final void reset() {
        txtCommitComment.setText(""); //$NON-NLS-1$
        btnCommit.setEnabled(false);
        super.reset();
    }
    
    @Override
    protected final void diffLoaded() {
        btnCommit.setEnabled(true);
    }
}

class DiffPage extends DiffPresentationPane {
    
    private final IPreferenceStore mainPrefs;
    private final PgDbProject proj;
    
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
        this.proj = proj;
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
                    ExceptionNotifier.showErrorDialog("Errors occurs while differing", e1);
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
                        Messages.database, proj.getPrefs().get(PROJ_PREF.REPO_TYPE, ""));
                if (dialog.open() == Dialog.OK) {
                    manualDepciesSource = dialog.getDepciesSourceList();
                    manualDepciesTarget = dialog.getDepciesTargetList();
                }
            }
        });
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

        Differ differ = new Differ(
                DbSource.fromFilter(dbSource, filtered, DiffSide.LEFT),
                DbSource.fromFilter(dbTarget,filtered, DiffSide.RIGHT),
                false);
        differ.setFullDbs(dbSource.getDbObject(), dbTarget.getDbObject());
        differ.setAdditionalDepciesSource(manualDepciesSource);
        differ.setAdditionalDepciesTarget(manualDepciesTarget);
        differ.runProgressMonitorDiffer(getShell());

        SqlScriptDialog dialog = new SqlScriptDialog(getShell(),
                SqlScriptDialog.INFORMATION, Messages.diffPartDescr_diff_script,
                Messages.diffPartDescr_this_will_apply_selected_changes_to_your_database,
                differ, dbSource.getDbObject().flatten(), 
                mainPrefs.getBoolean(DB_UPDATE_PREF.USE_PSQL_DEPCY));
        dialog.setDangerStatements(
                mainPrefs.getBoolean(DB_UPDATE_PREF.DROP_TABLE_STATEMENT), 
                mainPrefs.getBoolean(DB_UPDATE_PREF.ALTER_COLUMN_STATEMENT),
                mainPrefs.getBoolean(DB_UPDATE_PREF.DROP_COLUMN_STATEMENT));
        if (btnDb.getSelection()) {
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