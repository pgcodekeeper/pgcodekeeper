package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoredObject;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class IgnoredObjectsPrefPage extends PreferencePage
implements IWorkbenchPreferencePage {

    private IgnoredObjectPrefListEditor listEditor;
    private Button btnIsWhite;

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected Control createContents(Composite parent) {
        GridLayout gridLayout = new GridLayout();
        gridLayout.marginHeight = 0;
        gridLayout.marginWidth = 0;
        parent.setLayout(gridLayout);
        parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        new Label(parent, SWT.NONE).setText(Messages.IgnoredObjectsPrefPage_these_objects_are_ignored_info);
        btnIsWhite = new Button(parent, SWT.CHECK);
        btnIsWhite.setText(Messages.IgnoredObjectsPrefPage_convert_to_white_list);

        IgnoreList ignore = InternalIgnoreList.readInternalList();
        btnIsWhite.setSelection(!ignore.isShow());

        listEditor = new IgnoredObjectPrefListEditor(parent);
        listEditor.setInputList(ignore.getList());

        return parent;
    }

    @Override
    protected void performDefaults() {
        listEditor.setInputList(new ArrayList<>());
        super.performDefaults();
    }

    @Override
    public boolean performOk() {
        try {
            writeList();
        } catch (IOException ex) {
            ExceptionNotifier.notifyDefault(Messages.IgnoredObjectsPrefPage_error_saving_ignores_list, ex);
            return false;
        } catch (URISyntaxException ex) {
            ExceptionNotifier.notifyDefault(Messages.IgnoredObjectsPrefPage_error_workspace_path, ex);
        }
        return true;
    }

    private void writeList() throws IOException, URISyntaxException {
        IgnoreList list = new IgnoreList();
        boolean isWhite = btnIsWhite.getSelection();
        list.setShow(!isWhite);
        for (IgnoredObject rule : listEditor.getList()){
            rule.setShow(isWhite);
            list.add(rule);
        }
        byte[] out = list.getListCode().getBytes(StandardCharsets.UTF_8);
        Path listFile = InternalIgnoreList.getInternalIgnoreFile();
        if (listFile != null) {
            try {
                Files.createDirectories(listFile.getParent());
            } catch (FileAlreadyExistsException ex) {
                // no action
            }
            Files.write(listFile, out, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            InternalIgnoreList.notifyListeners(list);
        }
    }
}