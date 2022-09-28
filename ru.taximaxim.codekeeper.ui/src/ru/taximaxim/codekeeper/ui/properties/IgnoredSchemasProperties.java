package ru.taximaxim.codekeeper.ui.properties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.dialogs.PropertyPage;

import ru.taximaxim.codekeeper.core.model.difftree.IgnoreSchemaList;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoredObject;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.InternalIgnoreList;

public class IgnoredSchemasProperties extends PropertyPage {

    private IgnoredSchemaListEditor listEditor;
    private IgnoreSchemaList ignoreSchemaList;
    private IProject proj;

    @Override
    public void setElement(IAdaptable element) {
        super.setElement(element);
        proj = element.getAdapter(IProject.class);
    }

    @Override
    protected Control createContents(Composite parent) {
        Path listFile = Paths.get(proj.getLocationURI()).resolve(FILE.IGNORED_SCHEMA);
        ignoreSchemaList = InternalIgnoreList.getIgnoreSchemaList(listFile);

        listEditor = IgnoredSchemaListEditor.create(parent, ignoreSchemaList);
        listEditor.setInputList(new ArrayList<>(ignoreSchemaList.getList()));

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
        boolean isWhite = !ignoreSchemaList.isShow();
        list.setShow(!isWhite);
        for (IgnoredObject rule : listEditor.getList()){
            rule.setShow(isWhite);
            list.add(rule);
        }
        byte[] out = list.getListCode().getBytes(StandardCharsets.UTF_8);
        Path listFile = Paths.get(proj.getLocationURI()).resolve(FILE.IGNORED_SCHEMA);
        Files.createDirectories(listFile.getParent());
        Files.write(listFile, out);
    }
}