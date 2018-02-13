package ru.taximaxim.codekeeper.ui.handlers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
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
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
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
            if (createMarker(Paths.get(project.getLocationURI()))) {
                IProjectDescription description = project.getDescription();
                description.setNatureIds(new String[] {NATURE.ID});
                project.setDescription(description, null);
            }
        } catch (CoreException | IOException e) {
            Log.log(e);
        }

        return null;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static boolean createMarker(Path path) throws FileNotFoundException {
        boolean isNeedCreate = true;

        if (!Files.exists(path.resolve(ApgdiffConsts.WORK_DIR_NAMES.SCHEMA.name())) ||
                !Files.exists(path.resolve(ApgdiffConsts.WORK_DIR_NAMES.EXTENSION.name()))) {
            isNeedCreate = MessageDialog.openQuestion(
                    PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                    Messages.ConvertProject_convert_dialog_title,
                    Messages.ConvertProject_convert_dialog_message);
        }

        Path markerFile = path.resolve(ApgdiffConsts.FILENAME_WORKING_DIR_MARKER);
        if (isNeedCreate && Files.notExists(markerFile)) {
            try (PrintWriter pw = new UnixPrintWriter(markerFile.toFile(), StandardCharsets.UTF_8)) {
                pw.println(ApgdiffConsts.VERSION_PROP_NAME + " = " //$NON-NLS-1$
                        + ApgdiffConsts.EXPORT_CURRENT_VERSION);
            }
        }

        return isNeedCreate;
    }
}
