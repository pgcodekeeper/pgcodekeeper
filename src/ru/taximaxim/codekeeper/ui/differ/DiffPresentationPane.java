package ru.taximaxim.codekeeper.ui.differ;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelectionChangedListener;
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
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.MessageBox;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbPicker;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public abstract class DiffPresentationPane extends Composite {

    // should be true for commit, false for diff script
    private final boolean isProjSrc;

    private final String exePgdump;
    private final String pgdumpCustom;

    protected final DiffTableViewer diffTable;
    private final Composite containerSrc;
    protected final Button btnNone, btnDump, btnDb;
    private final Button btnGetChanges;
    protected final DbPicker dbSrc;
    private final DiffPaneViewer diffPane;

    protected DbSource dbSource;
    protected DbSource dbTarget;
    protected TreeDiffer treeDiffer;

    private void setDbSource(DbSource dbSource) {
        this.dbSource = dbSource;
        if (diffPane != null) {
            diffPane.setDbTarget(dbSource);
        }
    }

    private void setDbTarget(DbSource dbTarget) {
        this.dbTarget = dbTarget;
        if (diffPane != null) {
            diffPane.setDbSource(dbTarget);
        }
    }

    public DiffPresentationPane(Composite parent, boolean projIsSrc,
            final IPreferenceStore mainPrefs, final PgDbProject proj) {
        super(parent, SWT.NONE);
        setLayout(new GridLayout());

        this.isProjSrc = projIsSrc;
        exePgdump = mainPrefs.getString(PREF.PGDUMP_EXE_PATH);
        pgdumpCustom = mainPrefs.getString(PREF.PGDUMP_CUSTOM_PARAMS);
        final IEclipsePreferences projProps = proj.getPrefs();

        // upper container
        Composite containerUpper = new Composite(this, SWT.NONE);
        containerUpper.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        // initialize default layout for customizable container
        GridLayout gl = new GridLayout();
        gl.marginHeight = gl.marginWidth = 0;
        containerUpper.setLayout(gl);

        createUpperContainer(containerUpper, gl);
        // end upper container

        SashForm sashOuter = new SashForm(this, SWT.VERTICAL | SWT.SMOOTH);
        sashOuter.setLayoutData(new GridData(GridData.FILL_BOTH));

        // middle container
        final Composite containerDb = new Composite(sashOuter, SWT.NONE);
        gl = new GridLayout(3, false);
        gl.marginHeight = gl.marginWidth = 0;
        gl.horizontalSpacing = gl.verticalSpacing = 2;
        containerDb.setLayout(gl);

        diffTable = new DiffTableViewer(containerDb, SWT.NONE, mainPrefs, false);
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
        gd.minimumWidth = 300;
        containerSrc.setLayoutData(gd);

        Group grpSrc = new Group(containerSrc, SWT.NONE);
        grpSrc.setText(isProjSrc ? Messages.commitPartDescr_get_changes_from
                : Messages.diffPartDescr_get_changes_for);
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
        btnGetChanges.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        btnGetChanges.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                loadChanges(proj, projProps, mainPrefs);
            }
        });

        dbSrc = new DbPicker(containerSrc, SWT.NONE, mainPrefs, false);
        dbSrc.setText(Messages.db_source);
        dbSrc.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2, 1));

        boolean useDbPicker = false;
        String src = projProps.get(PROJ_PREF.SOURCE, "");
        if (src.equals(PROJ_PREF.SOURCE_TYPE_NONE)) {
            btnNone.setSelection(true);
            btnGetChanges.setEnabled(false);
        } else if (src.equals(PROJ_PREF.SOURCE_TYPE_DUMP)) {
            btnDump.setSelection(true);
        } else {
            btnDb.setSelection(true);
            useDbPicker = true;
        }
        showDbPicker(useDbPicker);

        if (useDbPicker) {
            dbSrc.txtDbName.setText(projProps.get(PROJ_PREF.DB_NAME, ""));
            dbSrc.txtDbUser.setText(projProps.get(PROJ_PREF.DB_USER, ""));
            dbSrc.txtDbPass.setText(projProps.get(PROJ_PREF.DB_PASS, ""));
            dbSrc.txtDbHost.setText(projProps.get(PROJ_PREF.DB_HOST, ""));
            dbSrc.txtDbPort
                    .setText(String.valueOf(projProps.getInt(PROJ_PREF.DB_PORT, 0)));
        }
        // end middle right container
        // end middle container

        diffPane = new DiffPaneViewer(sashOuter, SWT.NONE, isProjSrc ? dbSource
                : dbTarget, isProjSrc ? dbTarget : dbSource, !isProjSrc);
    }

    private void showDbPicker(boolean show) {
        ((GridData) dbSrc.getLayoutData()).exclude = !show;
        dbSrc.setVisible(show);

        dbSrc.getParent().layout();
    }

    private void loadChanges(PgDbProject proj, IEclipsePreferences projProps,
            IPreferenceStore mainPrefs) {
       /* if (!ProjSyncSrc.sync(proj, getShell(), mainPrefs)) {
            return;
        }*/

        DbSource dbsProj, dbsRemote;
        dbsProj = DbSource.fromProject(proj);
        if (btnDump.getSelection()) {
            FileDialog dialog = new FileDialog(getShell());
            dialog.setText(Messages.choose_dump_file_with_changes);
            String dumpfile = dialog.open();
            if (dumpfile == null) {
                return;
            }
            dbsRemote = DbSource
                    .fromFile(dumpfile, projProps.get(PROJ_PREF.ENCODING, ""));
        } else if (btnDb.getSelection()) {
            int port;
            try {
                String sPort = dbSrc.txtDbPort.getText();
                port = sPort.isEmpty() ? 0 : Integer.parseInt(sPort);
            } catch (NumberFormatException ex) {
                MessageBox mb = new MessageBox(getShell(), SWT.ICON_ERROR);
                mb.setText(Messages.bad_port);
                mb.setMessage(Messages.port_must_be_a_number);
                mb.open();
                return;
            }

            dbsRemote = DbSource.fromDb(exePgdump, pgdumpCustom,
                    dbSrc.txtDbHost.getText(), port, dbSrc.txtDbUser.getText(),
                    dbSrc.txtDbPass.getText(), dbSrc.txtDbName.getText(),
                    projProps.get(PROJ_PREF.ENCODING, ""));
        } else {
            throw new IllegalStateException(Messages.undefined_source_for_db_changes);
        }

        setDbSource(isProjSrc ? dbsProj : dbsRemote);
        setDbTarget(isProjSrc ? dbsRemote : dbsProj);

        Log.log(Log.LOG_INFO, "Getting changes for diff"); //$NON-NLS-1$
        treeDiffer = new TreeDiffer(dbSource, dbTarget);
        try {
            new ProgressMonitorDialog(getShell()).run(true, false, treeDiffer);
        } catch (InvocationTargetException ex) {
            throw new IllegalStateException(Messages.error_in_differ_thread, ex);
        } catch (InterruptedException ex) {
            // assume run() was called as non cancelable
            throw new IllegalStateException(
                    Messages.differ_thread_cancelled_shouldnt_happen, ex);
        }

        activateControls();
        diffTable.setInput(treeDiffer, !isProjSrc);
        diffPane.setInput(null);
    }

    /**
     * @param container
     *            has {@link GridLayout} with 0 margins set by default
     * @param gl
     *            pre-made {@link GridLayout} of the container
     */
    protected abstract void createUpperContainer(Composite container, GridLayout gl);
    
    protected abstract void activateControls();
    
    public void changeProject() {
        diffTable.setInput(null, false);
        diffPane.setInput(null);
    };
}
