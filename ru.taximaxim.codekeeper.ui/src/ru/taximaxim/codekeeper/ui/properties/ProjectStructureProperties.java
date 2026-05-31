/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.properties;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.dialogs.PropertyPage;
import org.pgcodekeeper.core.database.base.project.AbstractWorkDirs;

import ru.taximaxim.codekeeper.ui.dialogs.ObjectDirectoryViewer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.utils.ProjectUtils;

public final class ProjectStructureProperties extends PropertyPage {

    private Map<String, String> dirMappings;
    private boolean splitBySchema;

    @Override
    public void setElement(IAdaptable element) {
        noDefaultAndApplyButton();
        super.setElement(element);
        IProject project = element.getAdapter(IProject.class);
        var projectPath = project.getLocation().toPath();
        var dbType = ProjectUtils.getDatabaseType(project);
        var workDirs = ProjectUtils.createWorkDirs(dbType, AbstractWorkDirs.resolveAltDirsFile(projectPath));
        dirMappings = new LinkedHashMap<>(ProjectUtils.getEditableDirMappings(workDirs));
        splitBySchema = workDirs.isSplitBySchema();
    }

    @Override
    protected Control createContents(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        panel.setLayout(new GridLayout());

        Label description = new Label(panel, SWT.WRAP);
        description.setText(Messages.ProjectStructureProperties_description);
        description.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false));

        Button btnSplitBySchema = new Button(panel, SWT.CHECK);
        btnSplitBySchema.setText(Messages.ProjectStructureProperties_split_by_schema);
        btnSplitBySchema.setSelection(splitBySchema);
        btnSplitBySchema.setEnabled(false);

        Composite tableComposite = new Composite(panel, SWT.NONE);
        tableComposite.setLayout(new FillLayout());
        tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        new ObjectDirectoryViewer(tableComposite, dirMappings, false).createViewer();

        return panel;
    }
}
