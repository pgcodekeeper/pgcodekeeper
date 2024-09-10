/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osgi.framework.Version;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public final class OpenProjectUtils {

    static PgDbProject getProject(ExecutionEvent event) {
        try {
            ISelection sel = HandlerUtil.getActiveMenuSelection(event);
            IStructuredSelection selection = (IStructuredSelection) sel;
            if (selection == null){
                return null;
            }
            Object firstElement = selection.getFirstElement();
            if (firstElement instanceof IProject proj && proj.getNature(NATURE.ID) != null) {
                return new PgDbProject(proj);
            }
        } catch (CoreException ce){
            Log.log(Log.LOG_ERROR, ce.getMessage());
        }
        return null;
    }

    public static DatabaseType getDatabaseType(IProject proj) {
        try {
            if (proj.exists()) {
                if (proj.hasNature(UIConsts.NATURE.MS)) {
                    return DatabaseType.MS;
                }
                if (proj.hasNature(UIConsts.NATURE.CH)) {
                    return DatabaseType.CH;
                }
            }
        } catch (CoreException e) {
            Log.log(e);
        }
        return DatabaseType.PG;
    }

    public static String[] getProjectNatures(DatabaseType dbType) {
        String[] natures;
        switch (dbType) {
        case PG:
            natures = new String[] { NATURE.ID };
            break;
        case MS:
            natures = new String[] { NATURE.ID, NATURE.MS };
            break;
        case CH:
            natures = new String[] {NATURE.ID, NATURE.CH};
            break;
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
        }
        return natures;
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

    public static boolean checkVersion(IProject proj, StringBuilder message) {
        message.setLength(0);

        File markerFile = new File(proj.getLocation().toFile(),
                Consts.FILENAME_WORKING_DIR_MARKER);
        try (FileInputStream stream = new FileInputStream(markerFile)) {
            Properties props = new Properties();
            props.load(stream);

            String verStr = props.getProperty(
                    Consts.VERSION_PROP_NAME, "").trim(); //$NON-NLS-1$
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

    public static boolean isPgProject(IProject proj) throws CoreException {
        return proj.hasNature(NATURE.ID) && !proj.hasNature(NATURE.MS) && !proj.hasNature(NATURE.CH);
    }

    /**
     * Shows a message box with version warning.
     * @param isError does the error block the project from opening
     */
    private static void warnVersion(Shell parent, String error, boolean isError) {
        MessageBox mb = new MessageBox(
                parent, isError? SWT.ICON_ERROR : SWT.ICON_WARNING);
        mb.setText(Messages.OpenProjectUtils_version_error);

        String msg = isError? Messages.OpenProjectUtils_proj_version_unsupported :
            Messages.OpenProjectUtils_proj_version_warn;
        mb.setMessage(msg + error);
        mb.open();
    }

    private OpenProjectUtils() {
    }
}
