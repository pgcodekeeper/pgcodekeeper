package ru.taximaxim.codekeeper.ui.handlers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.MS_WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.AbstractModelExporter;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ConvertProject extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IStructuredSelection selection = HandlerUtil.getCurrentStructuredSelection(event);
        Object obj = selection.getFirstElement();

        if (!(obj instanceof IProject)) {
            return null;
        }

        IProject project = (IProject) obj;
        Shell shell = HandlerUtil.getActiveShell(event);

        int code = new MessageDialog(shell, Messages.ConvertProject_select_type_title,
                null, Messages.ConvertProject_select_type_desc, MessageDialog.CONFIRM,
                new String[] {"MS SQL", "PostgreSQL"}, 0).open(); //$NON-NLS-1$ //$NON-NLS-2$

        if (code == SWT.DEFAULT) {
            return null;
        }

        boolean isMsSql = code == Window.OK;

        try {
            if (createMarker(shell, Paths.get(project.getLocationURI()), isMsSql)) {
                String[] natures;
                if (isMsSql) {
                    natures = new String[] {NATURE.ID, NATURE.MS};
                } else {
                    natures = new String[] {NATURE.ID};
                }
                IProjectDescription description = project.getDescription();
                description.setNatureIds(natures);
                project.setDescription(description, null);
            }
        } catch (CoreException | IOException e) {
            Log.log(e);
        }

        return null;
    }

    public static boolean createMarker(Shell shell, Path path, boolean isMsSql) throws FileNotFoundException {
        boolean weirdProject;
        if (isMsSql) {
            // MS doesn't require all dirs to exist, warn if none found
            weirdProject = Arrays.stream(MS_WORK_DIR_NAMES.values())
                    .map(e -> path.resolve(e.getName()))
                    .allMatch(Files::notExists);
        } else {
            weirdProject = Arrays.stream(WORK_DIR_NAMES.values())
                    .map(e -> path.resolve(e.name()))
                    .anyMatch(Files::notExists);
        }
        if (weirdProject) {
            MessageBox message = new MessageBox(shell, SWT.ICON_WARNING | SWT.YES | SWT.NO);
            message.setMessage(Messages.ConvertProject_convert_dialog_message);
            message.setText(Messages.ConvertProject_convert_dialog_title);
            if (message.open() != SWT.YES) {
                return false;
            }
        }

        Path markerFile = path.resolve(ApgdiffConsts.FILENAME_WORKING_DIR_MARKER);
        if (Files.notExists(markerFile)) {
            AbstractModelExporter.writeProjVersion(markerFile.toFile());
        }
        return true;
    }
}
