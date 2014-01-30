 
package ru.taximaxim.codekeeper.ui.parts;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTreeApplier;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.dbstore.DbPicker;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.differ.DiffTreeViewer;
import ru.taximaxim.codekeeper.ui.differ.TreeDiffer;
import ru.taximaxim.codekeeper.ui.externalcalls.SvnExec;
import ru.taximaxim.codekeeper.ui.fileutils.Dir;
import ru.taximaxim.codekeeper.ui.fileutils.TempDir;
import ru.taximaxim.codekeeper.ui.handlers.CloseActiveProj;
import ru.taximaxim.codekeeper.ui.handlers.LoadProj;
import ru.taximaxim.codekeeper.ui.handlers.ProjSyncSrc;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class CommitPartDescr {
	
    @Inject
    private MPart part;
    @Inject
    private EPartService partService;
    
    private Text txtCommitComment;
    private Button btnCommit;
    private DiffTreeViewer diffTree;
    private Button btnNone, btnDump, btnDb;
    private Button btnGetChanges;
    private DbPicker dbSrc;
    private Text txtDb, txtSvn;
    
    /**
     * Local SVN cache.
     */
    private DbSource dbSource;
    /**
     * Remote DB.
     */
    private DbSource dbTarget;
    
	@PostConstruct
	private void postConstruct(Composite parent, final PgDbProject proj,
	        @Named(UIConsts.PREF_STORE)
	        final IPreferenceStore mainPrefs,
	        @Named(IServiceConstants.ACTIVE_SHELL)
	        final Shell shell,
	        @Preference(value=UIConsts.PREF_PGDUMP_EXE_PATH)
	        final String exePgdump,
	        @Preference(value=UIConsts.PREF_SVN_EXE_PATH)
	        final String exeSvn,
	        final EModelService model,
	        final MApplication app) {
	    parent.setLayout(new GridLayout());
	    
	    // upper container
	    Composite containerUpper = new Composite(parent, SWT.NONE);
	    GridLayout gl = new GridLayout(2, false);
	    gl.marginHeight = gl.marginWidth = 0;
	    containerUpper.setLayout(gl);
	    containerUpper.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    txtCommitComment = new Text(containerUpper, SWT.BORDER |  SWT.MULTI);
	    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	    gd.heightHint = 80;
	    txtCommitComment.setLayoutData(gd);
	    
	    btnCommit = new Button(containerUpper, SWT.PUSH);
	    btnCommit.setLayoutData(new GridData(SWT.DEFAULT, SWT.FILL, false, false));
	    btnCommit.setText("Commit");
	    btnCommit.setEnabled(false);
	    btnCommit.addSelectionListener(new SelectionAdapter() {
	        @Override
	        public void widgetSelected(SelectionEvent e) {
	            final String commitComment = txtCommitComment.getText();
	            if(commitComment.isEmpty()) {
	                MessageBox mb = new MessageBox(shell, SWT.ICON_INFORMATION);
	                mb.setMessage("Comment required");
	                mb.setText("Please enter a comment for the commit.");
	                mb.open();
	                return;
	            }
	            
	            final TreeElement filtered = diffTree.filterDiffTree();
	            IRunnableWithProgress commitRunnable = new IRunnableWithProgress() {
                    
                    @Override
                    public void run(IProgressMonitor monitor) throws InvocationTargetException,
                            InterruptedException {
                        SubMonitor pm = SubMonitor.convert(monitor, "Committing", 3);
                        
                        pm.newChild(1).subTask("Modifying DB model..."); // 1
                        DiffTreeApplier applier = new DiffTreeApplier(
                                dbSource.getDbObject(), dbTarget.getDbObject(), filtered);
                        PgDatabase dbNew = applier.apply();
                        
                        pm.newChild(1).subTask("Exporting new DB model..."); // 2
                        File dirSvn = proj.getProjectSchemaDir();
                        try {
                            try(TempDir tmpSvnMeta = new TempDir("tmp_svn_meta_")) {
                                File svnMetaProj = new File(dirSvn, ".svn");
                                File svnMetaTmp = new File(tmpSvnMeta.get(), ".svn");
                                
                                svnMetaProj.renameTo(svnMetaTmp);
                                Dir.deleteRecursive(dirSvn);
                                
                                new ModelExporter(
                                        dirSvn.getAbsolutePath(), dbNew, 
                                        proj.getString(UIConsts.PROJ_PREF_ENCODING))
                                .export();
                                
                                svnMetaTmp.renameTo(svnMetaProj);
                            }
                            
                            pm.newChild(1).subTask("SVN committing..."); // 3
                            SvnExec svn = new SvnExec(exeSvn, proj);
                            svn.svnRmMissing(dirSvn);
                            svn.svnAddAll(dirSvn);
                            svn.svnCi(dirSvn, commitComment);
                        } catch(IOException ex) {
                            throw new InvocationTargetException(ex,
                                    "IOException while modifying project!");
                        }
                        
                        monitor.done();
                    }
                };
                
                try {
                    new ProgressMonitorDialog(shell).run(true, false, commitRunnable);
                } catch(InvocationTargetException ex) {
                    throw new IllegalStateException(
                            "Error in the project modifier thread", ex);
                } catch(InterruptedException ex) {
                    // assume run() was called as non cancelable
                    throw new IllegalStateException(
                            "Project modifier thread cancelled. Shouldn't happen!", ex);
                }

                Console.addMessage("SUCCESS: Project updated!");
                
                // reopen project because file structure has been changed
                CloseActiveProj.close(app.getContext());
                LoadProj.load(proj, app.getContext(), partService, model, app);
	        }
        });
	    // end upper commit comment container
	    
	    SashForm sashOuter = new SashForm(parent, SWT.VERTICAL | SWT.SMOOTH);
	    sashOuter.setLayoutData(new GridData(GridData.FILL_BOTH));
	    
	    // middle container
	    SashForm sashDb = new SashForm(sashOuter, SWT.HORIZONTAL | SWT.SMOOTH);
	    sashDb.setSashWidth(8);
	    
	    diffTree = new DiffTreeViewer(sashDb, SWT.NONE);
	    diffTree.viewer.addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                TreePath[] paths = ((TreeSelection) event.getSelection()).getPaths();
                if(paths.length < 1) {
                    return;
                }
                
                TreeElement el = (TreeElement) paths[0].getLastSegment();
                if(el.getType() == DbObjType.CONTAINER || el.getType() == DbObjType.DATABASE) {
                    return;
                }
                
                if(el.getSide() == DiffSide.LEFT || el.getSide() == DiffSide.BOTH) {
                    txtSvn.setText(el.getPgStatement(dbSource.getDbObject()).getCreationSQL());
                } else {
                    txtSvn.setText("");
                }
                if(el.getSide() == DiffSide.RIGHT || el.getSide() == DiffSide.BOTH) {
                    txtDb.setText(el.getPgStatement(dbTarget.getDbObject()).getCreationSQL());
                } else {
                    txtDb.setText("");
                }
            }
        });

	    //     middle right container
	    Composite containerSrc = new Composite(sashDb, SWT.NONE);
	    gl = new GridLayout(2, false);
	    gl.marginHeight = gl.marginWidth = 0;
	    containerSrc.setLayout(gl);
	    
	    Group grpSrc = new Group(containerSrc, SWT.NONE);
	    grpSrc.setText("Get changes from");
	    grpSrc.setLayout(new GridLayout(3, false));
	    
	    btnNone = new Button(grpSrc, SWT.RADIO);
	    btnNone.setText("None");
	    btnNone.addSelectionListener(new SelectionAdapter() {
	        @Override
	        public void widgetSelected(SelectionEvent e) {
	            showDbPicker(false);
	            btnGetChanges.setEnabled(false);
	        }
        });
	    
	    btnDump = new Button(grpSrc, SWT.RADIO);
	    btnDump.setText("Dump");
	    btnDump.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                showDbPicker(false);
                btnGetChanges.setEnabled(true);
            }
        });
	    
	    btnDb = new Button(grpSrc, SWT.RADIO);
        btnDb.setText("DB");
        btnDb.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                showDbPicker(true );
                btnGetChanges.setEnabled(true);
            }
        });
        
        btnGetChanges = new Button(containerSrc, SWT.PUSH);
        btnGetChanges.setText("Get Changes");
        btnGetChanges.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        btnGetChanges.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    if(!ProjSyncSrc.sync(proj, shell, mainPrefs)) {
                        return;
                    }
                } catch(InvocationTargetException | IOException ex) {
                    throw new IllegalStateException(
                            "Unexpected error while trying to sync SVN cache!", ex);
                }
                dbSource = DbSource.fromProject(proj);
                
                if(btnDump.getSelection()) {
                    FileDialog dialog = new FileDialog(shell);
                    dialog.setText("Choose dump file with changes...");
                    String dumpfile = dialog.open();
                    if(dumpfile != null) {
                        dbTarget = DbSource.fromFile(dumpfile,
                                proj.getString(UIConsts.PROJ_PREF_ENCODING));
                    } else {
                        return;
                    }
                } else if(btnDb.getSelection()) {
                    int port;
                    try {
                        port = Integer.parseInt(dbSrc.txtDbPort.getText());
                    } catch(NumberFormatException ex) {
                        MessageBox mb = new MessageBox(shell, SWT.ICON_ERROR);
                        mb.setText("Bad port!");
                        mb.setMessage("Port must be a number!");
                        return;
                    }
                    
                    dbTarget = DbSource.fromDb(exePgdump,
                            dbSrc.txtDbHost.getText(), port,
                            dbSrc.txtDbUser.getText(),
                            dbSrc.txtDbPass.getText(),
                            dbSrc.txtDbName.getText(),
                            proj.getString(UIConsts.PROJ_PREF_ENCODING));
                } else {
                    throw new IllegalStateException("Undefined source for DB changes!");
                }
                
                TreeDiffer treediffer = new TreeDiffer(dbSource, dbTarget);
                try {
                    new ProgressMonitorDialog(shell).run(true, false, treediffer);
                } catch(InvocationTargetException ex) {
                    throw new IllegalStateException("Error in differ thread", ex);
                } catch(InterruptedException ex) {
                    // assume run() was called as non cancelable
                    throw new IllegalStateException(
                            "Differ thread cancelled. Shouldn't happen!", ex);
                }
                
                diffTree.setTreeInput(treediffer.getDiffTree());
                
                txtDb.setText("");
                txtSvn.setText("");
                
                btnCommit.setEnabled(true);
            }
        });
	    
	    dbSrc = new DbPicker(containerSrc, SWT.NONE, mainPrefs, false);
	    dbSrc.setText("DB Source");
	    dbSrc.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2, 1));
	    
	    boolean useDbPicker = false;
	    String src = proj.getString(UIConsts.PROJ_PREF_SOURCE);
	    if(src.equals(UIConsts.PROJ_SOURCE_TYPE_NONE)) {
	        btnNone.setSelection(true);
	        btnGetChanges.setEnabled(false);
	    } else if(src.equals(UIConsts.PROJ_SOURCE_TYPE_DUMP)) {
	        btnDump.setSelection(true);
	    } else {
	        btnDb.setSelection(true);
	        useDbPicker = true;
	    }
	    showDbPicker(useDbPicker);
	    
	    if(useDbPicker) {
	        dbSrc.txtDbName.setText(proj.getString(UIConsts.PROJ_PREF_DB_NAME));
	        dbSrc.txtDbUser.setText(proj.getString(UIConsts.PROJ_PREF_DB_USER));
	        dbSrc.txtDbPass.setText(proj.getString(UIConsts.PROJ_PREF_DB_PASS));
	        dbSrc.txtDbHost.setText(proj.getString(UIConsts.PROJ_PREF_DB_HOST));
	        dbSrc.txtDbPort.setText(String.valueOf(proj.getInt(UIConsts.PROJ_PREF_DB_PORT)));
	    }
	    //     end middle right container
	    
	    sashDb.setWeights(new int[] { 7750, 2250 });
        // end middle container
	    
	    // lower diff container
	    SashForm sashDiff = new SashForm(sashOuter, SWT.HORIZONTAL | SWT.SMOOTH);
	    sashDiff.setSashWidth(8);
	    
	    Composite containerLeft = new Composite(sashDiff, SWT.NONE);
	    gl = new GridLayout();
        gl.marginHeight = gl.marginWidth = 0;
	    containerLeft.setLayout(gl);
	    
	    Label l = new Label(containerLeft, SWT.RIGHT);
	    l.setText("Database version >  >");
	    l.setLayoutData(new GridData(SWT.RIGHT, SWT.DEFAULT, false, false));
	    txtDb = new Text(containerLeft, 
	            SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI | SWT.READ_ONLY);
	    txtDb.setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));
        txtDb.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
	    txtDb.setLayoutData(new GridData(GridData.FILL_BOTH));
	    
	    Composite containerRight = new Composite(sashDiff, SWT.NONE);
	    gl = new GridLayout();
        gl.marginHeight = gl.marginWidth = 0;
	    containerRight.setLayout(gl);
	    
	    new Label(containerRight, SWT.NONE).setText("> SVN version");
	    txtSvn = new Text(containerRight, 
	            SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI  |SWT.READ_ONLY);
        txtSvn.setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));
        txtSvn.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
	    txtSvn.setLayoutData(new GridData(GridData.FILL_BOTH));
	    // end lower diff container
        
	    // changeProject(proj);
	}
	
	private void showDbPicker(boolean show) {
	    ((GridData) dbSrc.getLayoutData()).exclude = !show;
	    dbSrc.setVisible(show);
	    
	    dbSrc.getParent().layout();
	}
	
	@Inject
	private void changeProject(PgDbProject proj) {
        if(proj == null
                || !proj.getProjectDir().equals(
                        part.getPersistedState().get(UIConsts.PART_SYNC_ID))) {
            partService.hidePart(part);
        }
	}
	
	public static void openNew(String projectPath, EPartService partService,
	        EModelService model, MApplication app) {
	    for(MPart existingPart : model.findElements(app, UIConsts.PART_SYNC,
	            MPart.class, null)) {
	        if(projectPath.equals(existingPart.getPersistedState().get(UIConsts.PART_SYNC_ID))) {
	            partService.hidePart(existingPart);
	            break;
	        }
	    }
	    
	    MPart syncPart = partService.createPart(UIConsts.PART_SYNC);
	    syncPart.getPersistedState().put(UIConsts.PART_SYNC_ID, projectPath);
	    ((MPartStack) model.find(UIConsts.PART_STACK_EDITORS, app)).getChildren().add(syncPart);
	    partService.activate(syncPart);
	}
}