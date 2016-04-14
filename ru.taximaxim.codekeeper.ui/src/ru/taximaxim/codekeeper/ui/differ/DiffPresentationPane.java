package ru.taximaxim.codekeeper.ui.differ;

import java.io.File;
import java.text.MessageFormat;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.DBSources;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.dbstore.DbStorePicker;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public abstract class DiffPresentationPane extends Composite {

    // should be true for commit, false for diff script
    private final boolean isProjSrc;

    private final Composite containerUpper;
    private final Composite contNotifications;
    private final Button btnDismissRefresh;
    protected final DiffTableViewer diffTable;
    private final Composite containerDb;
    private final Button btnGetChanges;
    private final DiffPaneViewer diffPane;
    private DbStorePicker storePicker;

    protected DBSources selectedDBSource = DBSources.SOURCE_TYPE_JDBC;
    protected DbSource dbSource;
    protected DbSource dbTarget;
    protected TreeDiffer treeDiffer;

    protected final IPreferenceStore mainPrefs;
    protected final PgDbProject proj;

    protected final LocalResourceManager lrm;

    public DiffPresentationPane(Composite parent, boolean projIsSrc,
            final IPreferenceStore mainPrefs, final PgDbProject proj) {
        super(parent, SWT.NONE);
        
        this.setLayout(new GridLayout());
        this.lrm = new LocalResourceManager(JFaceResources.getResources(), this);
        this.isProjSrc = projIsSrc;
        this.proj = proj;
        this.mainPrefs = mainPrefs;

        // notifications container
        // simplified for 1 static notification
        // refactor into multiple child composites w/ description class
        // for multiple dynamic notifications if necessary
        contNotifications = new Group(this, SWT.BORDER);
        contNotifications.setLayout(new GridLayout(5, false));

        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.exclude = true;
        contNotifications.setVisible(false);
        contNotifications.setLayoutData(gd);

        Label lblWarnIcon = new Label(contNotifications, SWT.NONE);
        lblWarnIcon.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(FILE.ICONWARNING))));
        lblWarnIcon.setLayoutData(new GridData(SWT.DEFAULT, SWT.BOTTOM, false, true));

        Label lblNotification = new Label(contNotifications, SWT.NONE);
        lblNotification.setText(Messages.DiffPresentationPane_attention);
        lblNotification.setLayoutData(new GridData(SWT.DEFAULT, SWT.BOTTOM, false, true));
        lblNotification.setForeground(getDisplay().getSystemColor(SWT.COLOR_LIST_SELECTION));
        lblNotification.setFont(lrm.createFont(FontDescriptor.createFrom(
                lblNotification.getFont()).withStyle(SWT.BOLD).increaseHeight(2)));

        Label l = new Label(contNotifications, SWT.NONE);
        l.setText(Messages.DiffPresentationPane_project_modified);
        l.setLayoutData(new GridData(SWT.DEFAULT, SWT.BOTTOM, false, true));


        btnDismissRefresh = new Button(contNotifications, SWT.PUSH | SWT.FLAT);
        btnDismissRefresh.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(FILE.ICONCLOSE))));
        btnDismissRefresh.setToolTipText(Messages.DiffPresentationPane_dismiss);
        btnDismissRefresh.setLayoutData(new GridData(SWT.DEFAULT, SWT.BOTTOM, false, true));

        btnDismissRefresh.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                showNotificationArea(false);
            }
        });
        // end notifications container

        // upper container
        containerUpper = new Composite(this, SWT.NONE);
        containerUpper.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        GridLayout gl = new GridLayout(3, false);
        gl.marginHeight = gl.marginWidth = 0;
        containerUpper.setLayout(gl);

        // upper left part
        Composite contUpperLeft = new Composite(containerUpper, SWT.NONE);
        contUpperLeft.setLayoutData(new GridData(GridData.FILL_BOTH));
        // initialize default layout for customizable container
        gl = new GridLayout();
        gl.marginHeight = gl.marginWidth = 0;
        contUpperLeft.setLayout(gl);
        createUpperContainer(contUpperLeft, gl);        
        
        storePicker = new DbStorePicker(containerUpper, SWT.NONE, false, mainPrefs, true);

        // upper right part
        btnGetChanges = new Button(containerUpper, SWT.PUSH);
        btnGetChanges.setText(Messages.get_changes);

        gd = new GridData(SWT.RIGHT, SWT.FILL, false, true);
        gd.widthHint = btnGetChanges.computeSize(SWT.DEFAULT, SWT.DEFAULT).x;
        gd.minimumWidth = btnGetChanges.computeSize(SWT.DEFAULT, SWT.DEFAULT).x;
        gd.horizontalIndent = 20;
        btnGetChanges.setLayoutData(gd);
        // end upper container

        SashForm sashOuter = new SashForm(this, SWT.VERTICAL | SWT.SMOOTH);
        sashOuter.setLayoutData(new GridData(GridData.FILL_BOTH));

        // middle container
        containerDb = new Composite(sashOuter, SWT.NONE);
        gl = new GridLayout(3, false);
        gl.marginHeight = gl.marginWidth = 0;
        gl.horizontalSpacing = gl.verticalSpacing = 2;
        containerDb.setLayout(gl);

        diffTable = new DiffTableViewer(containerDb, SWT.NONE, mainPrefs, proj, false);
        diffTable.setLayoutData(new GridData(GridData.FILL_BOTH));
        diffTable.getViewer().addPostSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection selection = ((IStructuredSelection) event
                        .getSelection());

                if (selection.size() != 1) {
                    diffPane.setInput(null);
                } else {
                    TreeElement el = (TreeElement) selection.getFirstElement();
                    diffPane.setInput(el);
                }
            }
        });

        diffPane = new DiffPaneViewer(sashOuter, SWT.NONE, isProjSrc ? dbSource
                : dbTarget, isProjSrc ? dbTarget : dbSource, !isProjSrc);

        diffTable.getViewer().addDoubleClickListener(new IDoubleClickListener() {

            @Override
            public void doubleClick(DoubleClickEvent e) {
                TreeElement el = (TreeElement) ((IStructuredSelection) e.getSelection()).getFirstElement();
                openElementInEditor(el, proj);
            }
        });
    }
    
    public DbStorePicker getDbStorePicker(){
        return storePicker;
    }
    
    public Button getButton(){
        return btnGetChanges;
    }

    public void setTitleColor(RGB color){
        if (color == null){
            containerUpper.setBackground(null);
        } else {
            containerUpper.setBackground(lrm.createColor(color));
            containerUpper.setBackgroundMode(SWT.INHERIT_FORCE);
        }
    }

    private void openElementInEditor(TreeElement el, PgDbProject proj){
        if (el != null && el.getSide() != (isProjSrc ? DiffSide.RIGHT : DiffSide.LEFT)){
            PgDatabase projectDb = isProjSrc ? dbSource.getDbObject() : dbTarget.getDbObject();
            File projectDir = proj.getPathToProject().toFile();
            File file = new File(projectDir, "SCHEMA"); //$NON-NLS-1$

            TreeElement parentEl = el.getParent();
            String parentExportedFileName = parentEl == null ?
                    null : ModelExporter.getExportedFilename(parentEl.getPgStatement(projectDb));

            switch(el.getType()){
            case EXTENSION:
                file = new File(projectDir, "EXTENSION"); //$NON-NLS-1$
                break;
            case SEQUENCE:
                file = new File(new File(file, parentExportedFileName), "SEQUENCE"); //$NON-NLS-1$
                break;
            case VIEW:
                file = new File(new File(file, parentExportedFileName), "VIEW"); //$NON-NLS-1$
                break;
            case TABLE:
                file = new File(new File(file, parentExportedFileName), "TABLE"); //$NON-NLS-1$
                break;
            case FUNCTION:
                file = new File(new File(file, parentExportedFileName), "FUNCTION"); //$NON-NLS-1$
                break;
            case CONSTRAINT:
            case INDEX:
            case TRIGGER:
                el = parentEl;
                String schemaName = ModelExporter.getExportedFilename(
                        parentEl.getParent().getPgStatement(projectDb));
                file = new File(new File(file, schemaName), "TABLE"); //$NON-NLS-1$
                break;
            case RULE:
                String schemaName4Rule = ModelExporter.getExportedFilename(
                        parentEl.getParent().getPgStatement(projectDb));
                if (parentEl.getType() == DbObjType.TABLE){
                    file = new File(new File(file, schemaName4Rule), "TABLE");//$NON-NLS-1$
                } else {
                    if (parentEl.getType() == DbObjType.VIEW){
                        file = new File(new File(file, schemaName4Rule), "VIEW");//$NON-NLS-1$
                    } else {
                        Log.log(Log.LOG_ERROR, DiffPresentationPane.class + ": " + el.getName() + "rule out of table or view");
                    }
                }
                el = parentEl;
                break;
            default:
                break;
            }

            file = new File(file,
                    ModelExporter.getExportedFilename(el.getPgStatement(projectDb)) + ".sql"); //$NON-NLS-1$

            if (file.exists() && file.isFile()) {
                Log.log(Log.LOG_INFO, "Opening editor for file " + file.getAbsolutePath()); //$NON-NLS-1$

                IFileStore fileStore = EFS.getLocalFileSystem().getStore(file.toURI());
                IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

                try {
                    IDE.openEditorOnFileStore( page, fileStore );
                } catch (PartInitException e) {
                    ExceptionNotifier.notifyDefault(
                            MessageFormat.format(Messages.could_not_open_editor_for_file,
                                    file.getAbsolutePath()), e);
                }
            } else {
                Log.log(Log.LOG_WARNING, "Editor will not be opened for file " +  //$NON-NLS-1$
                        file.getAbsolutePath() + " because it is either nonexistent or not a file."); //$NON-NLS-1$
            }
        }
    }

    /**
     * @param container
     *            has {@link GridLayout} with 0 margins set by default
     * @param gl
     *            pre-made {@link GridLayout} of the container
     */
    protected abstract void createUpperContainer(Composite container, GridLayout gl);
    
    public void setDbSource(DbSource dbSource) {
        this.dbSource = dbSource;
        setDiffPaneDb(isProjSrc, dbSource);
    }

    public void setDbTarget(DbSource dbTarget) {
        this.dbTarget = dbTarget;
        setDiffPaneDb(!isProjSrc, dbTarget);
    }
    
    public void setTreeDiffer(TreeDiffer treeDiffer){
        this.treeDiffer = treeDiffer;
    }

    private void setDiffPaneDb(boolean isDbSrc, DbSource db) {
        if (diffPane != null) {
            if (isDbSrc) {
                diffPane.setDbSource(db);
            } else {
                diffPane.setDbTarget(db);
            }
        }
    }

    public DiffTableViewer getDiffTable() {
        return diffTable;
    }
    /**
     * Allows clients to make actions after a diff has been loaded.
     */
    public void diffLoaded() {
    }
    
    public void setInputs(TreeDiffer treeDiffer, boolean isProjSrc){
        diffTable.setInput(treeDiffer, isProjSrc);
        diffPane.setInput(null);
    }

    public void clearInputs() {
        diffTable.setInput(null, isProjSrc);
        diffPane.setInput(null);
    }

    public void reset() {
        clearInputs();
        if (dbTarget != null && dbSource != null) {
            showNotificationArea(true);
        }
    }

    public void showNotificationArea(boolean visible) {
        ((GridData) contNotifications.getLayoutData()).exclude = !visible;
        contNotifications.setVisible(visible);
        this.layout();
        if (visible) {
            btnDismissRefresh.setFocus();
        }
    }
}
