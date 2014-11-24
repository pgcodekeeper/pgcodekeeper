package ru.taximaxim.codekeeper.ui.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public final class OpenProjectUtils {

    static PgDbProject getProject(ExecutionEvent event) {
        ISelection sel = HandlerUtil.getActiveMenuSelection(event);
        IStructuredSelection selection = (IStructuredSelection) sel;
        Object firstElement = selection.getFirstElement();
        if (firstElement instanceof IProject) {
            IProject proj = (IProject)firstElement;
            try {
                if (proj.getNature(NATURE.ID) != null) {
                    return new PgDbProject(proj);
                }
            } catch (CoreException e) {
                // silently return null incorrect project
                return null;
            }
        }
        return null;
    }

    public static boolean checkVersionAndWarn(IProject proj, Shell parent,
            boolean warnNonBlockers) {
        StringBuilder err = new StringBuilder();
        boolean canContinue = checkVersion(proj, err);
        boolean isError = !canContinue;
        if (err.length() != 0 && isError | warnNonBlockers) {
            warnVersion(parent, err.toString(), isError);
        }
        return canContinue;
    }
    
    private static boolean checkVersion(IProject proj, StringBuilder message) {
        message.setLength(0);
        
        File markerFile = new File(proj.getLocation().toFile(),
                ApgdiffConsts.FILENAME_WORKING_DIR_MARKER);
        try (FileInputStream stream = new FileInputStream(markerFile)) {
            Properties props = new Properties();
            props.load(stream);
            
            String verStr = props.getProperty(
                    ApgdiffConsts.VERSION_PROP_NAME, "").trim(); //$NON-NLS-1$
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
            Version curVer = new Version(ApgdiffConsts.EXPORT_CURRENT_VERSION);
            if (ver.compareTo(curVer) > 0) {
                message.append(Messages.OpenProjectUtils_high_proj_version +
                        verStr + " > " + ApgdiffConsts.EXPORT_CURRENT_VERSION); //$NON-NLS-1$
                return false;
            }
            if (ver.compareTo(curVer) < 0) {
                message.append(Messages.OpenProjectUtils_low_proj_version);
                return true;
            }
            
        } catch (FileNotFoundException ex) {
            message.append(Messages.OpenProjectUtils_file + 
                    markerFile.getAbsolutePath() + Messages.OpenProjectUtils_is_missing);
            return false;
        } catch (IOException ex) {
            Log.log(ex);
            message.append(Messages.OpenProjectUtils_unexpected_version_error);
            return false;
        }
        return true;
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
