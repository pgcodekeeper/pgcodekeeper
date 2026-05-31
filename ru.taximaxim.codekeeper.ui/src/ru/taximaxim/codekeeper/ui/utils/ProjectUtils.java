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
package ru.taximaxim.codekeeper.ui.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ide.ResourceUtil;
import org.osgi.framework.Version;
import org.pgcodekeeper.core.Consts;
import org.pgcodekeeper.core.database.api.project.IWorkDirs;
import org.pgcodekeeper.core.database.api.schema.DbObjType;
import org.pgcodekeeper.core.database.base.project.AbstractWorkDirs;
import org.pgcodekeeper.core.database.ch.project.ChWorkDirs;
import org.pgcodekeeper.core.database.ms.project.MsWorkDirs;
import org.pgcodekeeper.core.database.pg.project.PgWorkDirs;

import ru.taximaxim.codekeeper.ui.DatabaseType;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public final class ProjectUtils {

    public static final String NATURE_ID = UIConsts.PLUGIN_ID.THIS + ".nature"; //$NON-NLS-1$
    public static final String NATURE_MS = UIConsts.PLUGIN_ID.THIS + ".msnature"; //$NON-NLS-1$
    public static final String NATURE_CH = UIConsts.PLUGIN_ID.THIS + ".chnature"; //$NON-NLS-1$
    private static final String OVERRIDES = "OVERRIDES"; //$NON-NLS-1$

    public static Path getPath(IProject project) {
        return Paths.get(project.getLocationURI());
    }

    /**
     * Returns distinct top-level directory names derived from the given
     * {@link IWorkDirs} configuration. Used for UI heuristics (detecting
     * whether a folder looks like a project, hyperlink resolution, etc.).
     * In split-by-schema mode, sub-element directories (which live under
     * the schema container) are excluded.
     */
    public static List<String> getDefaultTopLevelDirNames(IWorkDirs workDirs) {
        boolean split = workDirs.isSplitBySchema();
        return workDirs.getDirMapping().values().stream()
                .filter(r -> !split || !r.isSubElement())
                .map(r -> r.getDirName().split("/")[0])
                .distinct()
                .toList();
    }

    /**
     * Returns a flat view of user-overridable type names to their current directory
     * names. Intended for settings dialogs that let users edit the project layout.
     */
    public static Map<String, String> getEditableDirMappings(IWorkDirs workDirs) {
        var result = new LinkedHashMap<String, String>();
        for (var entry : workDirs.getDirMapping().entrySet()) {
            result.put(entry.getKey(), entry.getValue().getDirName());
        }
        return result;
    }

    /**
     * Returns whether the path is a schema's own .sql file under the given layout.
     * Works for both split-by-schema and flat modes.
     */
    public static boolean isSchemaFile(IWorkDirs workDirs, IPath path) {
        String[] containerSegments = workDirs.getDirNameForType(DbObjType.SCHEMA).split("/"); //$NON-NLS-1$
        int expectedCount = containerSegments.length + (workDirs.isSplitBySchema() ? 2 : 1);
        if (path.segmentCount() != expectedCount || !path.lastSegment().endsWith(Consts.SQL_POSTFIX)) {
            return false;
        }
        for (int i = 0; i < containerSegments.length; i++) {
            if (!containerSegments[i].equals(path.segment(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Creates a {@link AbstractWorkDirs} instance for the given DBMS, optionally
     * applying overrides from {@code altDirsFile}. Pass {@code null} to get defaults.
     */
    public static AbstractWorkDirs createWorkDirs(DatabaseType dbType, Path altDirsFile) {
        return switch (dbType) {
            case PG -> new PgWorkDirs(altDirsFile);
            case MS -> new MsWorkDirs(altDirsFile);
            case CH -> new ChWorkDirs(altDirsFile);
        };
    }

    public static boolean isInProject(IEditorInput editorInput) {
        IResource res = ResourceUtil.getResource(editorInput);
        return res != null && isInProject(res);
    }

    public static boolean isInProject(IResourceDelta delta, DatabaseType dbType) {
        return isInProject(delta.getProjectRelativePath(), dbType);
    }

    public static boolean isOverridesFolder(IResourceDelta delta) {
        return OVERRIDES.equals(delta.getProjectRelativePath().segment(0));
    }


    public static boolean isInProject(IResource resource) {
        IProject project = resource.getProject();
        if (!isPgCodeKeeperProject(project)) {
            return false;
        }

        var dbType = getDatabaseType(project);
        return isInProject(resource.getProjectRelativePath(), dbType);
    }

    /**
     * @param path
     *            project relative path of checked resource
     * @return whether this resource is within the main database schema hierarchy
     */
    public static boolean isInProject(IPath path, DatabaseType dbType) {
        String dir = path.segment(0);
        return dir != null && (OVERRIDES.equals(dir)
                || dbType.getDatabaseProvider().getDirectoryNames().stream().anyMatch(dir::equals));
    }

    public static int countFiles(IContainer container) throws CoreException {
        int[] count = new int[1];
        container.accept(p -> {
            if (p.getType() == IResource.FILE) {
                ++count[0];
            }
            return true;
        }, 0);
        return count[0];
    }

    public static void configure(IProject project) throws CoreException {
        if (project.hasNature(NATURE_ID)) {
            project.getNature(NATURE_ID).configure();
        }

        if (project.hasNature(NATURE_MS)) {
            project.getNature(NATURE_MS).configure();
        }

        if (project.hasNature(NATURE_CH)) {
            project.getNature(NATURE_CH).configure();
        }
    }

    public static void deconfigure(IProject project) throws CoreException {
        if (project.hasNature(NATURE_ID)) {
            project.getNature(NATURE_ID).deconfigure();
        }

        if (project.hasNature(NATURE_MS)) {
            project.getNature(NATURE_MS).deconfigure();
        }

        if (project.hasNature(NATURE_CH)) {
            project.getNature(NATURE_CH).deconfigure();
        }
    }

    public static String[] getProjectNatures(DatabaseType dbType) {
        return switch (dbType) {
            case PG -> new String[] { NATURE_ID };
            case MS -> new String[] { NATURE_ID, NATURE_MS };
            case CH -> new String[] { NATURE_ID, NATURE_CH };
        default -> throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type.formatted(dbType));
        };
    }

    public static DatabaseType getDatabaseType(IProject proj) {
        try {
            if (proj.exists()) {
                if (proj.hasNature(NATURE_MS)) {
                    return DatabaseType.MS;
                }
                if (proj.hasNature(NATURE_CH)) {
                    return DatabaseType.CH;
                }
            }
        } catch (CoreException e) {
            Log.log(e);
        }
        return DatabaseType.PG;
    }

    public static boolean isPgCodeKeeperProject(IProject proj) {
        try {
            return proj != null && proj.exists() && proj.isOpen() && proj.hasNature(NATURE_ID);
        } catch (CoreException ex) {
            Log.log(Log.LOG_ERROR, Messages.ProjectUtils_nature_identifier_error.formatted(ex.getLocalizedMessage()),
                    ex);
            return false;
        }
    }

    public static boolean checkVersion(IProject proj, StringBuilder message) {
        message.setLength(0);

        File markerFile = new File(proj.getLocation().toFile(),
                Consts.FILENAME_WORKING_DIR_MARKER);
        try (FileInputStream stream = new FileInputStream(markerFile)) {
            Properties props = new Properties();
            props.load(stream);

            String verStr = props.getProperty(Consts.VERSION_PROP_NAME, "").trim(); //$NON-NLS-1$

            if (verStr.isEmpty()) {
                message.append(Messages.OpenProjectUtils_unknown_proj_version);
                return true;
            }

            Version ver;
            try {
                ver = new Version(verStr);
            } catch (IllegalArgumentException ex) {
                message.append(Messages.OpenProjectUtils_unknown_proj_version);
                return true;
            }
            Version curVer = new Version(Consts.EXPORT_CURRENT_VERSION);
            if (ver.compareTo(curVer) > 0) {
                message.append(Messages.OpenProjectUtils_high_proj_version)
                    .append(verStr)
                    .append(" > ") //$NON-NLS-1$
                    .append(Consts.EXPORT_CURRENT_VERSION);
                return false;
            }
            if (ver.compareTo(curVer) < 0) {
                message.append(Messages.OpenProjectUtils_low_proj_version);
                return true;
            }

        } catch (FileNotFoundException ex) {
            message.append(Messages.OpenProjectUtils_file.formatted(markerFile.getAbsolutePath()));
            return false;
        } catch (IOException ex) {
            Log.log(ex);
            message.append(Messages.OpenProjectUtils_unexpected_version_error);
            return false;
        }
        return true;
    }

    public static boolean checkVersionAndWarn(IProject proj, Shell parent,
            boolean warnNonBlockers) {
        StringBuilder err = new StringBuilder();
        final boolean canContinue = checkVersion(proj, err);
        final boolean isError = !canContinue;
        if (err.length() != 0 && (isError || warnNonBlockers)) {
            warnVersion(parent, err.toString(), isError);
        }
        return canContinue;
    }

    /**
     * Shows a message box with version warning.
     *
     * @param isError
     *            does the error block the project from opening
     */
    private static void warnVersion(Shell parent, String error, boolean isError) {
        MessageBox mb = new MessageBox(parent, isError ? SWT.ICON_ERROR : SWT.ICON_WARNING);
        mb.setText(Messages.OpenProjectUtils_version_error);

        String msg = isError ? Messages.OpenProjectUtils_proj_version_unsupported
                : Messages.OpenProjectUtils_proj_version_warn;
        mb.setMessage(msg + error);
        mb.open();
    }

    private ProjectUtils() {
        // only statics
    }
}
