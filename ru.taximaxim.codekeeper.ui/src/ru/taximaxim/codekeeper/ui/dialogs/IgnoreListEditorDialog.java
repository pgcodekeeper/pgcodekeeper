package ru.taximaxim.codekeeper.ui.dialogs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.IgnoredObjectPrefListEditor;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.InternalIgnoreList;

public class IgnoreListEditorDialog extends Dialog {

    private IgnoreList currentIgnoreList;
    private Path currentIgnoreListPath;
    private IgnoredObjectPrefListEditor listEditor;
    private final PrefListEditor<String, ListViewer> editor;

    public IgnoreListEditorDialog(Shell shell, Path currentIgnoreListPath,
            PrefListEditor<String, ListViewer> editor) {
        super(shell);
        this.currentIgnoreListPath = currentIgnoreListPath;
        this.editor = editor;

        setShellStyle(SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE | SWT.RESIZE);
        setBlockOnOpen(false);
    }

    public IgnoreList getCurrentIgnoreList() {
        return currentIgnoreList;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);

        if (currentIgnoreListPath == null) {
            currentIgnoreList = new IgnoreList();
        } else {
            currentIgnoreList = InternalIgnoreList.readIgnoreList(currentIgnoreListPath);
        }

        GridLayout gridLayout = new GridLayout();
        gridLayout.marginHeight = 0;
        gridLayout.marginWidth = 0;
        composite.setLayout(gridLayout);
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        listEditor = new IgnoredObjectPrefListEditor(composite, currentIgnoreList);
        listEditor.setInputList(new ArrayList<>(currentIgnoreList.getList()));

        return composite;
    }

    @Override
    protected void okPressed() {
        listEditor.getList().forEach(r -> r.setShow(!currentIgnoreList.isShow()));
        currentIgnoreList.clearList();
        currentIgnoreList.addAll(listEditor.getList());

        byte[] out = currentIgnoreList.getListCode().getBytes(StandardCharsets.UTF_8);

        if (currentIgnoreListPath == null) {
            FileDialog dialog = new FileDialog(getShell(), SWT.SAVE);
            dialog.setText(Messages.IgnoreListEditorDialog_save_ignore_file);
            dialog.setFilterExtensions(new String[] {"*.pgcodekeeperignore", "*"}); //$NON-NLS-1$ //$NON-NLS-2$
            dialog.setFilterNames(new String[] {
                    Messages.DbStoreEditorDialog_pgcodekeeperignore_files_filter,
                    Messages.DiffPresentationPane_any_file_filter});
            dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());

            String stringPath = dialog.open();
            if (stringPath != null) {
                currentIgnoreListPath = Paths.get(stringPath);
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
            if (!currentIgnoreListPath.toFile().exists()) {
                Files.createFile(currentIgnoreListPath);
            }

            Files.write(currentIgnoreListPath, out, StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            ExceptionNotifier.notifyDefault(MessageFormat.format(
                    Messages.IgnoreListEditorDialog_error_file, currentIgnoreListPath), ex);
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

        shell.layout(true, true);
        final Point newSize = shell.computeSize(600, 400, true);
        shell.setSize(newSize);
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID,
                Messages.IgnoreListEditorDialog_save, true);
        createButton(parent, IDialogConstants.CANCEL_ID,
                Messages.IgnoreListEditorDialog_cancel, false);
    }
}
