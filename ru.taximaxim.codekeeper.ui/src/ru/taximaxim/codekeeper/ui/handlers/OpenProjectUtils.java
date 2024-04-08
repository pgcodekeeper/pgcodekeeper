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
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osgi.framework.Version;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.WorkDirs;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public final class OpenProjectUtils {

    static PgDbProject getProject(ExecutionEvent event) {
        try{
            ISelection sel = HandlerUtil.getActiveMenuSelection(event);
            IStructuredSelection selection = (IStructuredSelection) sel;
            if (selection == null){
                return null;
            }
            Object firstElement = selection.getFirstElement();
            if (firstElement instanceof IProject) {
                IProject proj = (IProject)firstElement;
                if (proj.getNature(NATURE.ID) != null) {
                    return new PgDbProject(proj);
                }
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

    public static void checkLegacySchemas(IProject proj, Shell shell) {
        try {
            doCheckLegacySchemas(proj, shell);
        } catch (CoreException ex) {
            ExceptionNotifier.notifyDefault(MessageFormat.format(
                    Messages.OpenProjectUtils_schema_convert_error, ex.getLocalizedMessage()), ex);
        }
    }

    /**
     * @throws CoreException only when user chose to convert project and the following process failed
     */
    private static void doCheckLegacySchemas(IProject proj, Shell shell) throws CoreException {
        IFolder schemasDir = proj.getFolder(WorkDirs.getDirectoryNameForType(DatabaseType.PG, DbObjType.SCHEMA));
        if (!schemasDir.exists()) {
            return;
        }

        List<IFile> schemas;
        try {
            schemas = Arrays.stream(schemasDir.members())
                    .filter(r -> r.getType() == IResource.FILE && "sql".equals(r.getFileExtension())) //$NON-NLS-1$
                    .map(IFile.class::cast)
                    .filter(OpenProjectUtils::checkLegacySchemaFile)
                    .collect(Collectors.toList());
        } catch (CoreException ex) {
            Log.log(ex);
            // we don't know whether user actually wants to convert
            // or even whether there's anything to convert
            // fail silently, this shouldn't happen anyway
            return;
        }

        if (!schemas.isEmpty()) {
            MessageBox mb = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
            mb.setText(Messages.OpenProjectUtils_update_format);
            mb.setMessage(MessageFormat.format(
                    Messages.OpenProjectUtils_update_warning,
                    proj.getName()));
            if (mb.open() != SWT.YES) {
                return;
            }
        } else {
            return;
        }

        IRunnableWithProgress runnable = monitor -> {
            SubMonitor m = SubMonitor.convert(monitor, Messages.OpenProjectUtils_updating_project, schemas.size() + 1);
            try {
                proj.refreshLocal(IResource.DEPTH_INFINITE, m.newChild(1));
                for (IResource r : schemas) {
                    SubMonitor sm = m.newChild(1);
                    IPath schemaPath = r.getProjectRelativePath().removeFileExtension();
                    if (!proj.exists(schemaPath)) {
                        proj.getFolder(schemaPath).create(false, true, sm.newChild(1));
                    }
                    // move relative to original
                    IPath newPath = schemaPath
                            .removeFirstSegments(schemaPath.segmentCount() - 1)
                            .append(r.getName());
                    r.move(newPath, false, sm.newChild(1));
                }
            } catch (CoreException e) {
                throw new InvocationTargetException(e, e.getLocalizedMessage());
            } finally {
                monitor.done();
            }
        };
        try {
            new ProgressMonitorDialog(shell).run(true, false, runnable);
        } catch (InvocationTargetException e) {
            Throwable t = e.getCause();
            if (t instanceof CoreException) {
                throw (CoreException) t;
            } else {
                throw new IllegalStateException(t.getLocalizedMessage(), e);
            }
        } catch (InterruptedException e) {
            // can't be cancelled
        }
    }

    private static boolean checkLegacySchemaFile(IFile f) {
        try (InputStream stream = f.getContents()) {
            byte[] bb = new byte[512];
            int size = stream.read(bb);
            // we check for an ASCII string so we don't care about real encoding
            // this won't work with UTF-16+, but at least it will work with UTF-8
            // and all single-byte/ASCII compatible encodings
            String s = new String(bb, 0, size, StandardCharsets.US_ASCII);
            return s.contains("CREATE SCHEMA"); //$NON-NLS-1$
        } catch(CoreException | IOException ex) {
            Log.log(ex);
            return false;
        }
    }

    private OpenProjectUtils() {
    }
}
