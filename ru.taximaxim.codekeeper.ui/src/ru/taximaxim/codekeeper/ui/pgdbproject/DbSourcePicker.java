package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dbstore.DbMenuStorePicker;
import ru.taximaxim.codekeeper.ui.dbstore.IStorePicker;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

class DbSourcePicker extends Composite {

    private final PageDiff pageDiff;
    private final IStorePicker storePicker;
    private final ComboViewer cmbEncoding;

    public DbSourcePicker(Composite parent, String groupTitle, final PageDiff pageDiff) {
        super(parent, SWT.NONE);

        this.pageDiff = pageDiff;

        FillLayout fl = new FillLayout();
        fl.marginHeight = fl.marginWidth = 0;
        setLayout(fl);

        Group sourceComp = new Group(this, SWT.NONE);
        sourceComp.setLayout(new GridLayout(2, false));
        sourceComp.setText(groupTitle);

        new Label(sourceComp, SWT.NONE).setText(Messages.DbStorePicker_db_schema_source);

        storePicker = new DbMenuStorePicker(sourceComp, true, true);
        new Label(sourceComp, SWT.NONE).setText(Messages.diffWizard_target_encoding);

        cmbEncoding = new ComboViewer(sourceComp, SWT.BORDER | SWT.DROP_DOWN);
        cmbEncoding.setContentProvider(ArrayContentProvider.getInstance());
        cmbEncoding.setLabelProvider(new LabelProvider());
        cmbEncoding.setInput(UIConsts.ENCODINGS);
        cmbEncoding.getCombo().setText(ApgdiffConsts.UTF_8);
        cmbEncoding.getControl().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        storePicker.addSelectionListener(() -> {
            pageDiff.getWizard().getContainer().updateButtons();
            File dir = storePicker.getPathOfDir();
            PgDbProject project = null;
            boolean isProject = dir != null && (project = getProjectFromDir(dir)) != null;
            if (isProject) {
                try {
                    cmbEncoding.getCombo().setText(project.getProjectCharset());
                    pageDiff.setTimezone(project.getPrefs().get(PROJ_PREF.TIMEZONE, pageDiff.getTimezone()));
                } catch (CoreException ex) {
                    Log.log(ex);
                }
            }
            cmbEncoding.getControl().setEnabled(!isProject);
        });
    }

    public void filter(boolean isMsql) {
        storePicker.filter(isMsql);
    }

    public void setDbStore(Object selection) {
        storePicker.setSelection(selection);
    }

    public DbInfo getSelectedDbInfo() {
        return storePicker.getDbInfo();
    }

    public String getEncoding() {
        return cmbEncoding.getCombo().getText();
    }

    public DbSource getDbSource(boolean isMsSql, Map<String, Boolean> oneTimePrefs) {
        final boolean forceUnixNewlines = true; // true by default, check project if path is given
        DbInfo dbInfo;
        File file;
        File dir;
        if ((dbInfo = storePicker.getDbInfo()) != null) {
            return DbSource.fromDbInfo(dbInfo, forceUnixNewlines, getEncoding(),
                    pageDiff.getTimezone(), null, oneTimePrefs);
        } else if ((file = storePicker.getPathOfFile()) != null) {
            return DbSource.fromFile(forceUnixNewlines, file, getEncoding(),
                    isMsSql, null, oneTimePrefs);
        } else if ((dir = storePicker.getPathOfDir()) != null) {
            PgDbProject project = getProjectFromDir(dir);
            if (project != null) {
                return DbSource.fromProject(project, oneTimePrefs);
            } else {
                return DbSource.fromDirTree(forceUnixNewlines, dir.getAbsolutePath(),
                        getEncoding(), isMsSql, oneTimePrefs);
            }
        }
        return null;
    }

    private PgDbProject getProjectFromDir(File dir) {
        IContainer[] conts = ResourcesPlugin.getWorkspace().getRoot().findContainersForLocationURI(dir.toURI());
        IProject project = null;
        for (IContainer cont : conts) {
            if (cont instanceof IProject && ((IProject) cont).isOpen()) {
                if (project == null) {
                    project = (IProject) cont;
                } else {
                    // ambiguous project: work as if with a plain directory
                    project = null;
                    break;
                }
            }
        }
        return project == null ? null : new PgDbProject(project);
    }
}
