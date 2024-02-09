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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.WorkDirs;
import ru.taximaxim.codekeeper.core.model.exporter.AbstractModelExporter;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
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

        var dialog = new ConvertProjectDialog(shell);
        if (dialog.open() == Window.OK) {
            convertProject(project, shell, dialog.getDbType());
        }

        return null;
    }

    private void convertProject(IProject project, Shell shell, DatabaseType dbType) {
        try {
            if (createMarker(shell, Paths.get(project.getLocationURI()), dbType)) {
                IProjectDescription description = project.getDescription();
                description.setNatureIds(OpenProjectUtils.getProjectNatures(dbType));
                project.setDescription(description, null);
            }
        } catch (CoreException | IOException e) {
            Log.log(e);
        }
    }

    public static boolean createMarker(Shell shell, Path path, DatabaseType dbType) throws IOException {
        boolean unknownProject = WorkDirs.getDirectoryNames(dbType).stream().map(path::resolve)
                .allMatch(Files::notExists);

        if (unknownProject) {
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

    private final class ConvertProjectDialog extends TrayDialog {

        private DatabaseType dbType;

        private ConvertProjectDialog(Shell shell) {
            super(shell);
        }

        @Override
        protected Control createDialogArea(Composite parent) {
            Composite area = (Composite) super.createDialogArea(parent);

            parent.getShell().setText(Messages.ConvertProject_select_type_title);

            new Label(area, SWT.NONE).setText(Messages.ConvertProject_select_type_desc);
            var cmbDbType = new ComboViewer(area);
            cmbDbType.setContentProvider(ArrayContentProvider.getInstance());
            cmbDbType.setLabelProvider(UIConsts.DATABASE_TYPE_PROVIDER);
            cmbDbType.setInput(DatabaseType.values());
            cmbDbType.addSelectionChangedListener(e -> {
                var sel = (StructuredSelection) cmbDbType.getSelection();
                dbType = (DatabaseType) sel.getFirstElement();
            });
            cmbDbType.setSelection(new StructuredSelection(DatabaseType.PG));
            return area;
        }

        DatabaseType getDbType() {
            return dbType;
        }
    }
}
