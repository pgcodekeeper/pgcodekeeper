/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_BIND_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class PgDbProject {

    private final IProject project;
    private IEclipsePreferences prefs;

    public IProject getProject() {
        return project;
    }

    public IEclipsePreferences getPrefs() {
        IEclipsePreferences prefs = this.prefs;
        if (prefs == null) {
            prefs = getPrefs(project, true);
            this.prefs = prefs;
        }
        return prefs;
    }

    public IEclipsePreferences getDbBindPrefs() {
        return getPrefs(project, false);
    }

    public String getProjectName() {
        return project.getName();
    }

    public String getProjectCharset() throws CoreException {
        return project.getDefaultCharset(true);
    }

    public void setProjectCharset(String charset) throws CoreException {
        project.setDefaultCharset(charset, null);
    }

    public Path getPathToProject() {
        return Paths.get(project.getLocationURI());
    }

    /**
     * Удалить проект из workspace, не удаляя содержимое
     */
    public void deleteFromWorkspace() throws CoreException {
        project.delete(false, true, null);
    }

    public void openProject() throws CoreException {
        project.open(null);
    }

    public PgDbProject(IProject newProject) {
        this.project = newProject;
    }

    public static PgDbProject createPgDbProject(IProject newProject, URI location,
            DatabaseType dbType) throws CoreException {
        if (!newProject.exists()) {
            IProjectDescription desc = newProject.getWorkspace()
                    .newProjectDescription(newProject.getName());

            String [] natures;
            switch (dbType) {
            case PG:
                natures = new String[] {NATURE.ID};
                break;
            case MS:
                natures = new String[] {NATURE.ID, NATURE.MS};
                break;
            default:
                throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
            }


            desc.setLocationURI(location);
            desc.setNatureIds(natures);
            newProject.create(desc, null);
            newProject.open(IResource.BACKGROUND_REFRESH, null);
            newProject.refreshLocal(IResource.BACKGROUND_REFRESH, null);
            newProject.getNature(NATURE.ID).configure();
            if (dbType == DatabaseType.MS) {
                newProject.getNature(NATURE.MS).configure();
            }
        }
        return new PgDbProject(newProject);
    }

    /**
     * @return pgCodeKeeper project preferences or null if wrong project
     */
    public static IEclipsePreferences getPrefs(IProject proj, boolean isProject) {
        try {
            if (proj.hasNature(NATURE.ID)) {
                return new ProjectScope(proj)
                        .getNode(isProject ? PLUGIN_ID.THIS : DB_BIND_PREF.DB_BINDING);
            }
        } catch (CoreException ex) {
            Log.log(ex);
        }
        return null;
    }
}
