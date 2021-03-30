package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.dialogs.PropertyPage;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoreSchemaList;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoredObject;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.properties.IgnoredSchemaListEditorProperties;

public class IgnoredSchemasPrefPage extends PropertyPage
implements IWorkbenchPreferencePage {

    private IgnoredSchemaListEditorProperties listEditor;
    private IgnoreSchemaList ignore;

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected Control createContents(Composite parent) {
        ignore = InternalIgnoreList.readInternalIgnoreSchemaList();
        listEditor = IgnoredSchemaListEditorProperties.create(parent, ignore);
        listEditor.setInputList(new ArrayList<>(ignore.getList()));

        return listEditor;
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
        }
        return true;
    }

    private void writeList() throws IOException {
        IgnoreSchemaList list = new IgnoreSchemaList();
        boolean isWhite = !ignore.isShow();
        list.setShow(!isWhite);
        for (IgnoredObject rule : listEditor.getList()){
            rule.setShow(isWhite);
            list.add(rule);
        }
        byte[] out = list.getListCode().getBytes(StandardCharsets.UTF_8);
        Path listFile = InternalIgnoreList.getInternalIgnoreFile(FILE.IGNORED_SCHEMA);
        if (listFile != null) {
            try {
                Files.createDirectories(listFile.getParent());
            } catch (FileAlreadyExistsException ex) {
                // no action
            }
            Files.write(listFile, out, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        }
    }
}