package ru.taximaxim.codekeeper.ui.differ;

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
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
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;
import org.osgi.service.prefs.BackingStoreException;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dbstore.DbStorePicker;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorSelectionProvider;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.InternalIgnoreList;

// TODO this class is very tightly bound with ProjectEdittorDiffer
// refactor and put into separate package
public abstract class DiffPresentationPane extends Composite {

    protected final ProjectEditorDiffer projEditor;
    protected final IPreferenceStore mainPrefs;
    protected final PgDbProject proj;
    private DbInfo lastRemote;
    protected DbSource dbProject, dbRemote;
    protected TreeElement diffTree;

    protected final LocalResourceManager lrm;
    private final Composite containerUpper;
    private final Composite contNotifications;
    private final Label lblNotificationText;
    private final Button btnDismissRefresh;

    protected final DbStorePicker storePicker;
    private final Button btnGetChanges;
    private final DiffTableViewer diffTable;
    private final DiffPaneViewer diffPane;

    public DiffPresentationPane(Composite parent, IPreferenceStore mainPrefs,
            PgDbProject proj, ProjectEditorDiffer projEditor) {
        super(parent, SWT.NONE);

        this.setLayout(new GridLayout());
        this.lrm = new LocalResourceManager(JFaceResources.getResources(), this);
        this.proj = proj;
        this.mainPrefs = mainPrefs;
        this.projEditor = projEditor;

        // notifications container
        // simplified for 1 static notification
        // refactor into multiple child composites w/ description class
        // for multiple dynamic notifications if necessary
        contNotifications = new Group(this, SWT.BORDER);
        contNotifications.setLayout(new GridLayout(4, false));

        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.exclude = true;
        contNotifications.setVisible(false);
        contNotifications.setLayoutData(gd);

        Label lblWarnIcon = new Label(contNotifications, SWT.NONE);
        lblWarnIcon.setImage(Activator.getEclipseImage(ISharedImages.IMG_OBJS_WARN_TSK));
        lblWarnIcon.setLayoutData(new GridData(SWT.DEFAULT, SWT.BOTTOM, false, true));

        Label lblNotification = new Label(contNotifications, SWT.NONE);
        lblNotification.setText(Messages.DiffPresentationPane_attention);
        lblNotification.setLayoutData(new GridData(SWT.DEFAULT, SWT.BOTTOM, false, true));
        lblNotification.setForeground(getDisplay().getSystemColor(SWT.COLOR_LIST_SELECTION));
        lblNotification.setFont(lrm.createFont(FontDescriptor.createFrom(
                lblNotification.getFont()).withStyle(SWT.BOLD).increaseHeight(2)));

        lblNotificationText = new Label(contNotifications, SWT.NONE);
        lblNotificationText.setLayoutData(new GridData(SWT.DEFAULT, SWT.BOTTOM, false, true));

        btnDismissRefresh = new Button(contNotifications, SWT.PUSH | SWT.FLAT);
        btnDismissRefresh.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(FILE.ICONCLOSE))));
        btnDismissRefresh.setToolTipText(Messages.DiffPresentationPane_dismiss);
        btnDismissRefresh.setLayoutData(new GridData(SWT.DEFAULT, SWT.BOTTOM, false, true));

        btnDismissRefresh.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                hideNotificationArea();
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

        // upper right part
        storePicker = new DbStorePicker(containerUpper, SWT.NONE, mainPrefs, true, false);
        storePicker.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
        storePicker.setSelection(new StructuredSelection(DbInfo.preferenceToStore(
                proj.getPrefs().get(PROJ_PREF.LAST_DB_STORE, "")))); //$NON-NLS-1$

        btnGetChanges = new Button(containerUpper, SWT.PUSH);
        btnGetChanges.setText(Messages.get_changes);
        btnGetChanges.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(FILE.ICONREFRESH))));
        btnGetChanges.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
        btnGetChanges.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                DiffPresentationPane.this.projEditor.getChanges();
            }
        });
        // end upper container

        SashForm sashOuter = new SashForm(this, SWT.VERTICAL | SWT.SMOOTH);
        sashOuter.setLayoutData(new GridData(GridData.FILL_BOTH));

        diffTable = new DiffTableViewer(sashOuter, false);
        diffTable.setLayoutData(new GridData(GridData.FILL_BOTH));
        diffTable.getViewer().addPostSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();

                if (selection.size() != 1) {
                    diffPane.setInput(null, null);
                } else {
                    TreeElement el = (TreeElement) selection.getFirstElement();
                    diffPane.setInput(el, diffTable.getElements());
                }
            }
        });
        diffTable.getViewer().addDoubleClickListener(new IDoubleClickListener() {

            @Override
            public void doubleClick(DoubleClickEvent e) {
                TreeElement el = (TreeElement) ((IStructuredSelection) e.getSelection()).getFirstElement();
                openElementInEditor(el);
            }
        });

        diffTable.getViewer().addPostSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                // bind both to postselection for performance
                ProjectEditorSelectionProvider sp = DiffPresentationPane.this.projEditor.getSelectionProvider();
                sp.fireSelectionChanged(event);
                sp.firePostSelectionChanged(event);
            }
        });

        diffPane = new DiffPaneViewer(sashOuter, SWT.NONE);
    }

    private void openElementInEditor(TreeElement el) {
        if (el != null && el.getSide() != DiffSide.RIGHT) {
            try {
                projEditor.getSite().getPage().openEditor(
                        new FileEditorInput(proj.getProject().getFile(
                                Path.fromOSString(ModelExporter.getRelativeFilePath(
                                        el.getPgStatement(dbProject.getDbObject()), true)))),
                        EDITOR.SQL);
            } catch (PartInitException e) {
                ExceptionNotifier.notifyDefault(e.getLocalizedMessage(), e);
            }
        }
    }

    public DbInfo getLastRemote() {
        return lastRemote;
    }

    public DbSource getRemoteDbSource() throws CoreException {
        DbSource dbRemote = null;

        IEclipsePreferences projProps = proj.getPrefs();
        boolean forceUnixNewlines = projProps.getBoolean(PROJ_PREF.FORCE_UNIX_NEWLINES, true);
        lastRemote = storePicker.getDbInfo();
        File dumpfile;
        if (lastRemote != null) {
            dbRemote = DbSource.fromDbInfo(lastRemote, mainPrefs, forceUnixNewlines,
                    proj.getProjectCharset(), projProps.get(PROJ_PREF.TIMEZONE, ApgdiffConsts.UTC));
        } else if ((dumpfile = storePicker.getPathOfFile()) != null) {
            dbRemote = DbSource.fromFile(forceUnixNewlines, dumpfile, proj.getProjectCharset());
        } else {
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_WARNING);
            mb.setText(Messages.DiffPresentationPane_cannot_get_changes);
            mb.setMessage(Messages.DiffPresentationPane_select_db_source);
            mb.open();
        }
        return dbRemote;
    }

    public void saveDbPrefs() throws BackingStoreException {
        DbInfo storeDB = storePicker.getDbInfo();
        if (storeDB != null) {
            IEclipsePreferences projProps = proj.getPrefs();
            projProps.put(PROJ_PREF.LAST_DB_STORE, storeDB.toString());
            projProps.flush();
        }
    }

    /**
     * @param container
     *            has {@link GridLayout} with 0 margins set by default
     * @param gl
     *            pre-made {@link GridLayout} of the container
     */
    protected abstract void createUpperContainer(Composite container, GridLayout gl);

    public void setInput(DbSource dbProject, DbSource dbRemote, TreeElement diffTree) {
        this.dbProject = dbProject;
        this.dbRemote = dbRemote;
        this.diffTree = diffTree;
        diffPane.setDbSources(dbProject, dbRemote);
        diffPane.setInput(null, null);

        IgnoreList ignoreList = null;
        if (diffTree != null) {
            ignoreList = InternalIgnoreList.readInternalList();
            InternalIgnoreList.readAppendList(
                    proj.getPathToProject().resolve(FILE.IGNORED_OBJECTS), ignoreList);
        }
        diffTable.setInput(dbProject, dbRemote, diffTree, ignoreList);
    }

    public void reset() {
        setInput(null, null, null);
    }

    public void hideNotificationArea() {
        showNotificationArea(false, null);
    }

    private void showNotificationArea(boolean visible, String message) {
        if (diffTree == null && visible) {
            // since there's only one notification about diff sides changing
            // we can skip showing it if the pane is empty (has no diff loaded)
            return;
        }
        if (message != null) {
            lblNotificationText.setText(message);
        }
        ((GridData) contNotifications.getLayoutData()).exclude = !visible;
        contNotifications.setVisible(visible);
        this.layout();
        if (visible) {
            btnDismissRefresh.setFocus();
        }
    }

    public void notifyProjectChanged() {
        if (!isDisposed()) {
            showNotificationArea(true, Messages.DiffPresentationPane_project_modified);
            reset();
        }
    }

    public void resetRemoteChanged() {
        // may be called off UI thread so check that we're still alive
        if (!isDisposed()) {
            showNotificationArea(true, Messages.DiffPresentationPane_remote_changed_notification);
            reset();
        }
    }

    /**
     * @return number of checked elements
     */
    protected int warnCheckedElements() {
        int checked = diffTable.getCheckedElementsCount();
        if (checked < 1) {
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_INFORMATION);
            mb.setMessage(Messages.please_check_at_least_one_row);
            mb.setText(Messages.empty_selection);
            mb.open();
        }
        return checked;
    }
}
