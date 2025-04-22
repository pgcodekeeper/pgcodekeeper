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
package ru.taximaxim.codekeeper.ui.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
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

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.WorkDirs;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public final class ProjectUtils {

    private static final String NATURE_ID = UIConsts.PLUGIN_ID.THIS + ".nature"; //$NON-NLS-1$
    private static final String NATURE_MS = UIConsts.PLUGIN_ID.THIS + ".msnature"; //$NON-NLS-1$
    private static final String NATURE_CH = UIConsts.PLUGIN_ID.THIS + ".chnature"; //$NON-NLS-1$

    public static boolean isInProject(IEditorInput editorInput) {
        IResource res = ResourceUtil.getResource(editorInput);
        return res != null && isInProject(res);
    }

    public static boolean isInProject(IResourceDelta delta, DatabaseType dbType) {
        return isInProject(delta.getProjectRelativePath(), dbType);
    }

    public static boolean isOverridesFolder(IResourceDelta delta) {
        return WorkDirs.OVERRIDES.equals(delta.getProjectRelativePath().segment(0));
    }

    public static boolean isInProject(IResource resource) {
        IProject project = resource.getProject();
        if (!isPgCodeKeeperProject(project)) {
            return false;
        }

        DatabaseType dbType = getDatabaseType(project);
        return isInProject(resource.getProjectRelativePath(), dbType);
    }

    /**
     * @param path
     *            project relative path of checked resource
     * @return whether this resource is within the main database schema hierarchy
     */
    public static boolean isInProject(IPath path, DatabaseType dbType) {
        String dir = path.segment(0);
        return dir != null && (WorkDirs.OVERRIDES.equals(dir)
                || WorkDirs.getDirectoryNames(dbType).stream().anyMatch(dir::equals));
    }

    /**
     * @param path
     *            project relative path
     * @param dbType
     *            type of project
     * @return whether the path corresponds to a schema sql file
     */
    public static boolean isSchemaFile(IPath path, DatabaseType dbType) {
        return switch (dbType) {
            case PG -> isPgSchemaFile(path);
            case MS -> isMsSchemaFile(path);
            case CH -> isChSchemaFile(path);
            default -> throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
        };
    }

    /**
     * @param path
     *            project relative path
     * @return whether the path corresponds to a schema sql file like this: /SCHEMA/schema_name/schema_name.sql
     */
    private static boolean isPgSchemaFile(IPath path) {
        int c = path.segmentCount();
        return c == 3
                && path.segment(0).equals(WorkDirs.PG_SCHEMA)
                && path.segment(c - 1).endsWith(".sql"); //$NON-NLS-1$
    }

    /**
     * @param path
     *            project relative path
     * @return whether the path corresponds to a schema sql file like this: /Security/Schemas/schema_name.sql
     */
    private static boolean isMsSchemaFile(IPath path) {
        return path.segmentCount() == 3
                && WorkDirs.MS_SECURITY.equals(path.segment(0))
                && WorkDirs.MS_SCHEMAS.equals(path.segment(1))
                && path.segment(2).endsWith(".sql"); //$NON-NLS-1$
    }

    private static boolean isChSchemaFile(IPath path) {
        return path.segmentCount() == 3
                && path.segment(0).equals(WorkDirs.CH_DATABASE)
                && path.segment(2).endsWith(".sql");
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
            default -> throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
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
            Log.log(Log.LOG_ERROR, "Project nature identifier error" + ex.getLocalizedMessage(), ex); //$NON-NLS-1$
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

            String verStr = props.getProperty(
                    Consts.VERSION_PROP_NAME, "") //$NON-NLS-1$
                .trim();
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
            message.append(MessageFormat.format(Messages.OpenProjectUtils_file,
                    markerFile.getAbsolutePath()));
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
