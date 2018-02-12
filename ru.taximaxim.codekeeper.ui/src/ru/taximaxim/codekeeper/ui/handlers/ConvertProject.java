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
import org.eclipse.jface.viewers.StructuredSelection;
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
        StructuredSelection selection = (StructuredSelection) HandlerUtil.getCurrentStructuredSelection(event);
        IProject project = (IProject) selection.getFirstElement();

        try {
            IProjectDescription description = project.getDescription();
            description.setNatureIds(new String[] {NATURE.ID});
            project.setDescription(description, null);
            createMarker(Paths.get(project.getLocationURI()));
        } catch (CoreException | IOException e) {
            Log.log(e);
        }

        return null;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static void createMarker(Path path) throws FileNotFoundException {
        Path markerFile = path.resolve(ApgdiffConsts.FILENAME_WORKING_DIR_MARKER);
        if (Files.notExists(markerFile) && MessageDialog.openQuestion(
                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                Messages.ConvertProject_convert_dialog_title,
                Messages.ConvertProject_convert_dialog_message)) {
            try (PrintWriter pw = new UnixPrintWriter(markerFile.toFile(), StandardCharsets.UTF_8)) {
                pw.println(ApgdiffConsts.VERSION_PROP_NAME + " = " //$NON-NLS-1$
                        + ApgdiffConsts.EXPORT_CURRENT_VERSION);
            }
        }
    }
}
