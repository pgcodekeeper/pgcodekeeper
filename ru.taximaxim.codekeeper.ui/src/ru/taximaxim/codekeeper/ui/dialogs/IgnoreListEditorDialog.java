/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.dialogs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.core.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoredObject;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.IgnoredObjectPrefListEditor;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.InternalIgnoreList;

public class IgnoreListEditorDialog extends Dialog {

    private final IgnoreList ignoreList = new IgnoreList();
    private final PrefListEditor<String> editor;
    private Path path;
    private IgnoredObjectPrefListEditor listEditor;

    public IgnoreListEditorDialog(Shell shell, Path path, PrefListEditor<String> editor) {
        super(shell);
        this.path = path;
        this.editor = editor;
        if (path != null) {
            InternalIgnoreList.readAppendList(path, ignoreList, true);
        }

        setShellStyle(SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE | SWT.RESIZE);
        setBlockOnOpen(false);
    }

    public IgnoreList getIgnoreList() {
        return ignoreList;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);
        GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
        data.widthHint = 600;
        data.heightHint = 400;
        composite.setLayoutData(data);

        listEditor = IgnoredObjectPrefListEditor.create(composite, ignoreList);
        listEditor.setLayoutData(new GridData(GridData.FILL_BOTH));
        listEditor.setInputList(new ArrayList<>(ignoreList.getList()));

        return composite;
    }

    @Override
    protected void okPressed() {
        ignoreList.clearList();

        for (IgnoredObject r : listEditor.getList()) {
            r.setShow(!ignoreList.isShow());
            ignoreList.add(r);
        }

        if (path == null) {
            FileDialog dialog = new FileDialog(getShell(), SWT.SAVE);
            dialog.setText(Messages.IgnoreListEditorDialog_save_ignore_file);
            dialog.setFilterExtensions(new String[] {"*.pgcodekeeperignore", "*"}); //$NON-NLS-1$ //$NON-NLS-2$
            dialog.setFilterNames(new String[] {
                    Messages.DbStoreEditorDialog_pgcodekeeperignore_files_filter,
                    Messages.DiffPresentationPane_any_file_filter});
            dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());

            String stringPath = dialog.open();
            if (stringPath != null) {
                path = Paths.get(stringPath);
                List<String> list = editor.getList();
                if (!list.contains(stringPath)) {
                    list.add(stringPath);
                    editor.getViewer().refresh();
                }
            } else {
                return;
            }
        }

        try {
            Files.write(path, ignoreList.getListCode().getBytes(StandardCharsets.UTF_8));
        } catch (IOException ex) {
            ExceptionNotifier.notifyDefault(MessageFormat.format(
                    Messages.IgnoreListEditorDialog_error_file, path), ex);
        }

        super.okPressed();
    }

    @Override
    protected boolean isResizable() {
        return true;
    }

    @Override
    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        shell.setText(Messages.IgnoreListEditorDialog_excluded_objects_list_editor);
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID,
                Messages.IgnoreListEditorDialog_save, true);
        createButton(parent, IDialogConstants.CANCEL_ID,
                Messages.IgnoreListEditorDialog_cancel, false);
    }
}
