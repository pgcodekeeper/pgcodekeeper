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
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
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

        try {
            if (createMarker(HandlerUtil.getActiveShell(event), Paths.get(project.getLocationURI()))) {
                IProjectDescription description = project.getDescription();
                description.setNatureIds(new String[] {NATURE.ID});
                project.setDescription(description, null);
            }
        } catch (CoreException | IOException e) {
            Log.log(e);
        }

        return null;
    }

    public static boolean createMarker(Shell shell, Path path) throws FileNotFoundException {
        boolean isNeedCreate = true;

        if (!Files.exists(path.resolve(ApgdiffConsts.WORK_DIR_NAMES.SCHEMA.name())) ||
                !Files.exists(path.resolve(ApgdiffConsts.WORK_DIR_NAMES.EXTENSION.name()))) {
            MessageBox message = new MessageBox(shell, SWT.ICON_WARNING | SWT.YES | SWT.NO);
            message.setMessage(Messages.ConvertProject_convert_dialog_message);
            message.setText(Messages.ConvertProject_convert_dialog_title);
            isNeedCreate = message.open() == SWT.YES;
        }

        Path markerFile = path.resolve(ApgdiffConsts.FILENAME_WORKING_DIR_MARKER);
        if (isNeedCreate && Files.notExists(markerFile)) {
            AbstractModelExporter.writeProjVersion(markerFile.toFile());
        }

        return isNeedCreate;
    }
}
