package ru.taximaxim.codekeeper.ui.handlers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
                IProjectDescription description = project.getDescription();
                description.setNatureIds(new String[] {NATURE.ID});
                project.setDescription(description, null);
            }
        } catch (CoreException | IOException e) {
            Log.log(e);
        }

        return null;
    }

    public static boolean createMarker(Shell shell, Path path, boolean isMsSql) throws FileNotFoundException {
        boolean isNeedCreate = true;

        MessageBox message = new MessageBox(shell, SWT.ICON_WARNING | SWT.YES | SWT.NO);
        message.setMessage(Messages.ConvertProject_convert_dialog_message);
        message.setText(Messages.ConvertProject_convert_dialog_title);

        if (isMsSql) {
            for (MS_WORK_DIR_NAMES dir : ApgdiffConsts.MS_WORK_DIR_NAMES.values()) {
                if (!Files.exists(path.resolve(dir.getName()))) {
                    isNeedCreate = message.open() == SWT.YES;
                    break;
                }
            }
        } else if (!Files.exists(path.resolve(ApgdiffConsts.WORK_DIR_NAMES.SCHEMA.name())) ||
                !Files.exists(path.resolve(ApgdiffConsts.WORK_DIR_NAMES.EXTENSION.name()))) {
            isNeedCreate = message.open() == SWT.YES;
        }

        Path markerFile = path.resolve(ApgdiffConsts.FILENAME_WORKING_DIR_MARKER);
        if (isNeedCreate && Files.notExists(markerFile)) {
            AbstractModelExporter.writeProjVersion(markerFile.toFile());
        }

        return isNeedCreate;
    }
}
