/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
import org.pgcodekeeper.core.Consts;
import org.pgcodekeeper.core.DatabaseType;

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
        cmbEncoding.getCombo().setText(Consts.UTF_8);
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

    public void filter(DatabaseType dbType) {
        storePicker.filter(dbType);
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

    public DbSource getDbSource(Map<String, Boolean> oneTimePrefs) {
        DbInfo dbInfo;
        File file;
        File dir;
        if ((dbInfo = storePicker.getDbInfo()) != null) {
            return DbSource.fromDbInfo(dbInfo, getEncoding(), pageDiff.getTimezone(), null, oneTimePrefs);
        } else if ((file = storePicker.getPathOfFile()) != null) {
            return DbSource.fromFile(file, null, oneTimePrefs);
        } else if ((dir = storePicker.getPathOfDir()) != null) {
            PgDbProject project = getProjectFromDir(dir);
            if (project != null) {
                return DbSource.fromProject(project, oneTimePrefs);
            } else {
                return DbSource.fromDirTree(dir.getAbsolutePath(), oneTimePrefs);
            }
        }
        return null;
    }

    private PgDbProject getProjectFromDir(File dir) {
        IContainer[] conts = ResourcesPlugin.getWorkspace().getRoot().findContainersForLocationURI(dir.toURI());
        IProject project = null;
        for (IContainer cont : conts) {
            if (cont instanceof IProject proj && proj.isOpen()) {
                if (project == null) {
                    project = proj;
                } else {
                    // ambiguous project: work as if with a plain directory
                    project = null;
                    break;
                }
            }
        }
        return project == null ? null : new PgDbProject(project);
    }

    @Override
    public void dispose() {
        storePicker.dispose();
        super.dispose();
    }
}
