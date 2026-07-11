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
package ru.taximaxim.codekeeper.ui.handlers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.pgcodekeeper.core.database.api.IDatabaseProvider;
import org.pgcodekeeper.core.database.api.loader.ILoader;
import org.pgcodekeeper.core.database.api.schema.IDatabase;
import org.pgcodekeeper.core.database.base.project.AbstractWorkDirs;
import org.pgcodekeeper.core.database.base.project.DirRule;

import ru.taximaxim.codekeeper.ui.DatabaseType;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.dialogs.ProjectNormalizationDialog;
import ru.taximaxim.codekeeper.ui.libraries.LibraryUtils;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.settings.UISettings;
import ru.taximaxim.codekeeper.ui.utils.ProjectUtils;
import ru.taximaxim.codekeeper.ui.utils.UIMonitor;

public final class NormalizeProject extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        ISelection sel = HandlerUtil.getActiveMenuSelection(event);
        PgDbProject proj = PgDbProject.getProject(sel);

        Shell shell = HandlerUtil.getActiveShell(event);
        if (ProjectUtils.checkVersionAndWarn(proj.getProject(), shell, false)) {
            normalizeProject(shell, proj);
        }

        return null;
    }

    private void normalizeProject(Shell shell, PgDbProject proj) {
        Path projectPath = proj.getProject().getLocation().toFile().toPath();
        var dbType = ProjectUtils.getDatabaseType(proj.getProject());

        var currentWorkDirs = ProjectUtils.createWorkDirs(dbType, AbstractWorkDirs.resolveAltDirsFile(projectPath));
        Map<String, String> currentMappings = ProjectUtils.getEditableDirMappings(currentWorkDirs);
        Map<String, String> defaults = ProjectUtils.getEditableDirMappings(
                ProjectUtils.createWorkDirs(dbType, null));

        var normalizationDialog = new ProjectNormalizationDialog(shell, currentMappings, defaults,
                currentWorkDirs.isSplitBySchema());
        if (normalizationDialog.open() != Window.OK) {
            return;
        }
        var newDirMappingsCopy = normalizationDialog.getDirMappings();
        var newSplitBySchema = normalizationDialog.isSplitBySchema();

        Log.log(Log.LOG_INFO, Messages.NormalizeProject_normalizing_project_projName.formatted(proj.getProjectName()));
        Job job = new Job(Messages.NormalizeProject_normalizing_project) {

            @Override
            protected IStatus run(IProgressMonitor monitor) {
                SubMonitor mon = SubMonitor.convert(monitor,
                        Messages.NormalizeProject_normalizing_project, 2);
                try {
                    boolean projectOnly = true;
                    Map<String, Object> oneTimePrefs = Map.of(DB_UPDATE_PREF.PROJECT_ONLY, projectOnly);
                    IDatabaseProvider provider = dbType.getDatabaseProvider();
                    var settings = new UISettings(proj.getProject(), oneTimePrefs, null);
                    settings.setMonitor(new UIMonitor(mon.newChild(1)));
                    ILoader loader = provider.getProjectLoader(
                            projectPath, settings,
                            Collections.emptyList(), Collections.emptyList(), Collections.emptyList(),
                            LibraryUtils.META_PATH);
                    IDatabase db = loader.loadAndAnalyze();

                    saveAltDirs(projectPath, dbType, newDirMappingsCopy, newSplitBySchema);

                    mon.newChild(1).subTask(Messages.NormalizeProject_exporting_project);
                    var updaterSettings = new UISettings(proj.getProject());

                    provider.getProjectUpdater(db, null, null, projectPath, false, updaterSettings)
                            .updateFull(projectOnly, currentWorkDirs);
                } catch (IOException ex) {
                    return new Status(IStatus.ERROR, PLUGIN_ID.THIS,
                            Messages.NormalizeProject_error_while_updating_project, ex);
                } catch (InterruptedException e) {
                    return Status.CANCEL_STATUS;
                }
                return Status.OK_STATUS;
            }
        };

        job.addJobChangeListener(new JobChangeAdapter() {

            @Override
            public void done(IJobChangeEvent event) {
                if (event.getResult().isOK()) {
                    try {
                        proj.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
                    } catch (CoreException ex) {
                        ExceptionNotifier.notifyDefault(
                                Messages.ProjectEditorDiffer_error_refreshing_project, ex);
                        return;
                    }
                    UiSync.exec(PlatformUI.getWorkbench().getDisplay(), () -> {
                        Shell parent = shell;
                        if (parent.isDisposed()) {
                            IWorkbenchWindow w = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
                            if (w == null) {
                                return;
                            }
                            parent = w.getShell();
                            if ((parent == null) || parent.isDisposed()) {
                                return;
                            }
                        }

                        MessageDialog.open(MessageDialog.INFORMATION,
                                parent, Messages.NormalizeProject_project_normalized,
                                Messages.NormalizeProject_project_normalized_success,
                                SWT.NONE);
                    });
                }
            }
        });

        job.setUser(true);
        job.schedule();

    }

    private void saveAltDirs(Path projectPath, DatabaseType dbType, Map<String, String> newMappings,
            boolean splitBySchema) throws IOException {
        Path altDirsFile = AbstractWorkDirs.resolveAltDirsFile(projectPath);
        var seed = new Properties();
        seed.setProperty(AbstractWorkDirs.IS_SPLIT_BY_SCHEMA, Boolean.toString(splitBySchema));
        try (var writer = Files.newBufferedWriter(altDirsFile, StandardCharsets.UTF_8)) {
            seed.store(writer, null);
        }

        var workDirs = ProjectUtils.createWorkDirs(dbType, altDirsFile);
        var mapping = workDirs.getDirMapping();
        for (var entry : newMappings.entrySet()) {
            DirRule rule = mapping.get(entry.getKey());
            if (rule != null) {
                rule.setDirName(entry.getValue());
            }
        }
        workDirs.saveAltDirs(projectPath);
    }
}
