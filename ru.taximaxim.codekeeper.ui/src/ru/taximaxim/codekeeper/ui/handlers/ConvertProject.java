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

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.Consts.MS_WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.core.Consts.WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.model.exporter.AbstractModelExporter;
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

        DatabaseType dbType = code == Window.OK ? DatabaseType.MS : DatabaseType.PG;
        try {
            if (createMarker(shell, Paths.get(project.getLocationURI()), dbType)) {
                String[] natures;
                switch (dbType) {
                case PG:
                    natures = new String[] {NATURE.ID};
                    break;
                case MS:
                    natures = new String[] {NATURE.ID, NATURE.MS};
                    break;
                default:
                    throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
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

    public static boolean createMarker(Shell shell, Path path, DatabaseType dbType) throws IOException {
        boolean weirdProject;
        switch (dbType) {
        case PG:
            weirdProject = Arrays.stream(WORK_DIR_NAMES.values())
            .map(e -> path.resolve(e.name()))
            .allMatch(Files::notExists);
            break;
        case MS:
            // MS doesn't require all dirs to exist, warn if none found
            weirdProject = Arrays.stream(MS_WORK_DIR_NAMES.values())
            .map(e -> path.resolve(e.getDirName()))
            .allMatch(Files::notExists);
            break;
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
        }

        if (weirdProject) {
            MessageBox message = new MessageBox(shell, SWT.ICON_WARNING | SWT.YES | SWT.NO);
            message.setMessage(Messages.ConvertProject_convert_dialog_message);
            message.setText(Messages.ConvertProject_convert_dialog_title);
            if (message.open() != SWT.YES) {
                return false;
            }
        }

        Path markerFile = path.resolve(Consts.FILENAME_WORKING_DIR_MARKER);
        if (Files.notExists(markerFile)) {
            AbstractModelExporter.writeProjVersion(markerFile);
        }
        return true;
    }
}
