package ru.taximaxim.codekeeper.ui.parts;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.contentmergeviewer.IMergeViewerContentProvider;
import org.eclipse.compare.contentmergeviewer.TextMergeViewer;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.LineNumberRulerColumn;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.ManualDepciesDialog;
import ru.taximaxim.codekeeper.ui.SqlScriptDialog;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.dbstore.DbPicker;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.differ.DiffTableViewer;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.differ.TreeDiffer;
import ru.taximaxim.codekeeper.ui.handlers.ProjSyncSrc;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class DiffPartDescr {

    @Inject
    private MPart part;

    @Inject
    UISynchronize sync;
    
    @Inject
    private EPartService partService;
    
    @Inject
    @Preference(UIConsts.PREF_PGDUMP_EXE_PATH)
    private String exePgdump;
    
    @Inject
    @Preference(UIConsts.PREF_PGDUMP_CUSTOM_PARAMS)
    private String pgdumpCustom;

    private Button btnGetLatest, btnAddDepcy;
    private DiffTableViewer diffTable;
    private Button btnNone, btnDump, btnDb;
    private Button btnGetChanges;
    private Composite containerSrc;
    private DbPicker dbSrc;
    private TextMergeViewer diffPane;
    /**
     * Remote DB.
     */
    private DbSource dbSource;
    /**
     * Local repo cache.
     */
    private DbSource dbTarget;
    
    /**
     * A collection of manually added object dependencies.
     * Keys are dependants, values are lists of dependencies.
     */
    private List<Entry<PgStatement, PgStatement>> manualDepcies = new LinkedList<>();

    @PostConstruct
    private void postConstruct(Composite parent, final PgDbProject proj,
            @Named(UIConsts.PREF_STORE) final IPreferenceStore mainPrefs,
            final EModelService model, final MApplication app) {
        final Shell shell = parent.getShell();
        
        parent.setLayout(new GridLayout());
        // upper container
        Composite containerUpper = new Composite(parent, SWT.NONE);
        GridLayout gl = new GridLayout(2, false);
        gl.marginHeight = gl.marginWidth = 0;
        containerUpper.setLayout(gl);
        containerUpper.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        btnGetLatest = new Button(containerUpper, SWT.PUSH);
        btnGetLatest.setText(Messages.diffPartDescr_get_latest);
        btnGetLatest.setEnabled(false);
        btnGetLatest.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (diffTable.getCheckedElementsCount() < 1){
                    MessageBox mb = new MessageBox(shell, SWT.ICON_INFORMATION);
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
                differ.setAdditionalDepcies(manualDepcies);
                
                try {
                    new ProgressMonitorDialog(shell).run(true, false, differ);
                } catch (InvocationTargetException ex) {
                    throw new IllegalStateException(
                            Messages.error_in_the_project_modifier_thread, ex);
                } catch (InterruptedException ex) {
                    // assume run() was called as non cancelable
                    throw new IllegalStateException(
                            Messages.project_modifier_thread_cancelled_shouldnt_happen,
                            ex);
                }

                SqlScriptDialog dialog = new SqlScriptDialog(shell,
                        SqlScriptDialog.INFORMATION, Messages.diffPartDescr_diff_script,
                        Messages.diffPartDescr_this_will_apply_selected_changes_to_your_database,
                        differ.getDiffDirect());
                
                if (btnDb.getSelection()) {
                    dialog.setDbParams(dbSrc.txtDbHost.getText(),
                            dbSrc.txtDbPort.getText(), dbSrc.txtDbName.getText(),
                            dbSrc.txtDbUser.getText(), dbSrc.txtDbPass.getText());
                }
                dialog.open();
            }
        });
        
        btnAddDepcy = new Button(containerUpper, SWT.PUSH);
        btnAddDepcy.setText(Messages.diffPartDescr_add_dependencies);
        btnAddDepcy.setEnabled(false);
        btnAddDepcy.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                ManualDepciesDialog dialog = new ManualDepciesDialog(shell,
                        manualDepcies, dbSource.getDbObject().flatten());
                if (dialog.open() == Dialog.OK) {
                    manualDepcies = dialog.getDepciesList();
                }
            }
        });
        // end upper commit comment container

        SashForm sashOuter = new SashForm(parent, SWT.VERTICAL | SWT.SMOOTH);
        sashOuter.setLayoutData(new GridData(GridData.FILL_BOTH));

        // middle container
        final Composite containerDb = new Composite(sashOuter, SWT.NONE);
        gl = new GridLayout(3, false);
        gl.marginHeight = gl.marginWidth = 0;
        gl.horizontalSpacing = gl.verticalSpacing = 2;
        containerDb.setLayout(gl);
        
        diffTable = new DiffTableViewer(containerDb, SWT.FILL, mainPrefs, false);
        diffTable.setLayoutData(new GridData(GridData.FILL_BOTH));
        diffTable.viewer.addSelectionChangedListener(new ISelectionChangedListener() {

                    @Override
                    public void selectionChanged(SelectionChangedEvent event) {
                        StructuredSelection selection = ((StructuredSelection) event
                                .getSelection());
                        
                        if (selection.size() != 1) {
                            diffPane.setInput(null);
                        } else {
                            TreeElement el = (TreeElement) selection.getFirstElement();
                            diffPane.setInput(el);
                        }
                    }
                });
        
        // flip button set up
        final Button btnFlipDbPicker = new Button(containerDb, SWT.PUSH | SWT.FLAT);
        btnFlipDbPicker.setText("\u25B8"); //$NON-NLS-1$
        GridData gd = new GridData(GridData.FILL_VERTICAL);
        gd.widthHint = 20;
        btnFlipDbPicker.setLayoutData(gd);
        btnFlipDbPicker.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                boolean open = containerSrc.getVisible();
                
                containerSrc.setVisible(!open);
                ((GridData) containerSrc.getLayoutData()).exclude = open;
                containerDb.layout();
                
                btnFlipDbPicker.setText(open ? "\u25C2" // ◂ //$NON-NLS-1$
                        : "\u25B8"); // ▸ //$NON-NLS-1$
            }
        });
        
        // middle right container
        containerSrc = new Composite(containerDb, SWT.NONE);
        gl = new GridLayout(2, false);
        gl.marginHeight = gl.marginWidth = 0;
        containerSrc.setLayout(gl);
        
        gd = new GridData(SWT.FILL, SWT.FILL, false, true);
        gd.minimumWidth = gd.minimumHeight = 300;
        containerSrc.setLayoutData(gd);
        
        Group grpSrc = new Group(containerSrc, SWT.NONE);
        grpSrc.setText(Messages.diffPartDescr_get_changes_for);
        grpSrc.setLayout(new GridLayout(3, false));

        btnNone = new Button(grpSrc, SWT.RADIO);
        btnNone.setText(Messages.none);
        btnNone.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                showDbPicker(false);
                btnGetChanges.setEnabled(false);
            }
        });

        btnDump = new Button(grpSrc, SWT.RADIO);
        btnDump.setText(Messages.dump);
        btnDump.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                showDbPicker(false);
                btnGetChanges.setEnabled(true);
            }
        });

        btnDb = new Button(grpSrc, SWT.RADIO);
        btnDb.setText(Messages.db);
        btnDb.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                showDbPicker(true);
                btnGetChanges.setEnabled(true);
            }
        });

        btnGetChanges = new Button(containerSrc, SWT.PUSH);
        btnGetChanges.setText(Messages.get_changes);
        btnGetChanges.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
                false));
        btnGetChanges.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (!ProjSyncSrc.sync(proj, shell, mainPrefs)) {
                    return;
                }
                
                dbTarget = DbSource.fromProject(proj);
                if (btnDump.getSelection()) {
                    FileDialog dialog = new FileDialog(shell);
                    dialog.setText(Messages.choose_dump_file_with_changes);
                    String dumpfile = dialog.open();
                    if (dumpfile != null) {
                        dbSource = DbSource.fromFile(dumpfile,
                                proj.getString(UIConsts.PROJ_PREF_ENCODING));
                    } else {
                        return;
                    }
                } else if (btnDb.getSelection()) {
                    int port;
                    try {
                        String sPort = dbSrc.txtDbPort.getText();
                        port = sPort.isEmpty()? 0 : Integer.parseInt(sPort);
                    } catch (NumberFormatException ex) {
                        MessageBox mb = new MessageBox(shell, SWT.ICON_ERROR);
                        mb.setText(Messages.bad_port);
                        mb.setMessage(Messages.port_must_be_a_number);
                        mb.open();
                        return;
                    }

                    dbSource = DbSource.fromDb(exePgdump, pgdumpCustom,
                            dbSrc.txtDbHost.getText(), port,
                            dbSrc.txtDbUser.getText(),
                            dbSrc.txtDbPass.getText(),
                            dbSrc.txtDbName.getText(),
                            proj.getString(UIConsts.PROJ_PREF_ENCODING));
                } else {
                    throw new IllegalStateException(
                            Messages.undefined_source_for_db_changes);
                }
                
                Log.log(Log.LOG_INFO, "Getting changes to generate script"); //$NON-NLS-1$
                TreeDiffer treediffer = new TreeDiffer(dbSource, dbTarget);
                try {
                    new ProgressMonitorDialog(shell).run(true, false, treediffer);
                } catch (InvocationTargetException ex) {
                    throw new IllegalStateException(Messages.error_in_differ_thread, ex);
                } catch (InterruptedException ex) {
                    // assume run() was called as non cancelable
                    throw new IllegalStateException(
                            Messages.differ_thread_cancelled_shouldnt_happen, ex);
                }

                diffTable.setInput(treediffer);
                diffPane.setInput(null);
                btnGetLatest.setEnabled(true);
                btnAddDepcy.setEnabled(true);
                manualDepcies.clear();
            }
        });

        dbSrc = new DbPicker(containerSrc, SWT.NONE, mainPrefs, false);
        dbSrc.setText(Messages.db_source);
        dbSrc.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2,
                1));

        boolean useDbPicker = false;
        String src = proj.getString(UIConsts.PROJ_PREF_SOURCE);
        if (src.equals(UIConsts.PROJ_SOURCE_TYPE_NONE)) {
            btnNone.setSelection(true);
            btnGetChanges.setEnabled(false);
        } else if (src.equals(UIConsts.PROJ_SOURCE_TYPE_DUMP)) {
            btnDump.setSelection(true);
        } else {
            btnDb.setSelection(true);
            useDbPicker = true;
        }
        showDbPicker(useDbPicker);

        if (useDbPicker) {
            dbSrc.txtDbName.setText(proj.getString(UIConsts.PROJ_PREF_DB_NAME));
            dbSrc.txtDbUser.setText(proj.getString(UIConsts.PROJ_PREF_DB_USER));
            dbSrc.txtDbPass.setText(proj.getString(UIConsts.PROJ_PREF_DB_PASS));
            dbSrc.txtDbHost.setText(proj.getString(UIConsts.PROJ_PREF_DB_HOST));
            dbSrc.txtDbPort.setText(String.valueOf(proj
                    .getInt(UIConsts.PROJ_PREF_DB_PORT)));
        }
        // end middle right container
        // end middle container

        CompareConfiguration conf = new CompareConfiguration();
        conf.setLeftEditable(false);
        conf.setRightEditable(false);
        
        diffPane = new TextMergeViewer(sashOuter, SWT.BORDER, conf) {
            
            @Override
            protected SourceViewer createSourceViewer(Composite parent, int textOrientation) {
                CompositeRuler ruler = new CompositeRuler();
                ruler.addDecorator(0, new LineNumberRulerColumn());
                
                return new SourceViewer(parent, ruler,
                        textOrientation | SWT.H_SCROLL | SWT.V_SCROLL);
            }
        };
        diffPane.setContentProvider(new IMergeViewerContentProvider() {
            
            @Override
            public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            }
            
            @Override
            public void dispose() {
            }
            
            @Override
            public boolean showAncestor(Object input) {
                return false;
            }
            
            @Override
            public void saveRightContent(Object input, byte[] bytes) {
            }
            
            @Override
            public void saveLeftContent(Object input, byte[] bytes) {
            }
            
            @Override
            public boolean isRightEditable(Object input) {
                return false;
            }
            
            @Override
            public boolean isLeftEditable(Object input) {
                return false;
            }
            
            @Override
            public String getRightLabel(Object input) {
                return Messages.diffPartDescr_from + proj.getString(UIConsts.PROJ_PREF_REPO_TYPE);
            }
            
            @Override
            public Image getRightImage(Object input) {
                return null;
            }
            
            @Override
            public Object getRightContent(Object input) {
                TreeElement el = (TreeElement) input;
                if (el != null && (el.getSide() == DiffSide.RIGHT
                        || el.getSide() == DiffSide.BOTH)) {
                    return new Document(
                            el.getPgStatement(dbTarget.getDbObject())
                                .getCreationSQL());
                } else {
                    return new Document();
                }
            }
            
            @Override
            public String getLeftLabel(Object input) {
                return Messages.diffPartDescr_to_database;
            }
            
            @Override
            public Image getLeftImage(Object input) {
                return null;
            }
            
            @Override
            public Object getLeftContent(Object input) {
                TreeElement el = (TreeElement) input;
                if (el != null && (el.getSide() == DiffSide.LEFT
                        || el.getSide() == DiffSide.BOTH)) {
                    return new Document(
                            el.getPgStatement(dbSource.getDbObject())
                                    .getCreationSQL());
                } else {
                    return new Document();
                }
            }
            
            @Override
            public String getAncestorLabel(Object input) {
                return null;
            }
            
            @Override
            public Image getAncestorImage(Object input) {
                return null;
            }
            
            @Override
            public Object getAncestorContent(Object input) {
                return null;
            }
        });
    }

    private void showDbPicker(boolean show) {
        ((GridData) dbSrc.getLayoutData()).exclude = !show;
        dbSrc.setVisible(show);

        dbSrc.getParent().layout();
    }

    @Inject
    private void changeProject(
            PgDbProject proj,
            @Optional
            @EventTopic(UIConsts.EVENT_REOPEN_PROJECT)
            PgDbProject proj2) {
        if (proj == null
                || !proj.getProjectFile().toString().equals(
                        part.getPersistedState().get(UIConsts.PART_DIFF_ID))) {
            sync.asyncExec(new Runnable() {
                
                @Override
                public void run() {
                    partService.hidePart(part);
                }
            });
        } else if (proj2 != null) {
            sync.asyncExec(new Runnable() {
                
                @Override
                public void run() {
                    diffTable.setInput(null);
                    diffPane.setInput(null);
                    btnGetLatest.setEnabled(false);
                    btnAddDepcy.setEnabled(false);
                    manualDepcies.clear();
                }
            });
        }
    }

    public static void openNew(String projectPath, EPartService partService,
            EModelService model, MApplication app) {
        for (MPart existingPart : model.findElements(app, UIConsts.PART_DIFF,
                MPart.class, null)) {
            if (projectPath.equals(existingPart.getPersistedState().get(
                    UIConsts.PART_DIFF_ID))) {
                partService.hidePart(existingPart);
                break;
            }
        }

        MPart diffPart = partService.createPart(UIConsts.PART_DIFF);
        diffPart.getPersistedState().put(UIConsts.PART_DIFF_ID, projectPath);
        ((MPartStack) model.find(UIConsts.PART_STACK_EDITORS, app))
                .getChildren().add(diffPart);
        partService.showPart(diffPart, PartState.CREATE);
    }
}