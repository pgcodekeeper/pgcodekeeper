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
package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.core.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoredObject;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class IgnoredObjectsPrefPage extends PreferencePage
implements IWorkbenchPreferencePage {

    private IgnoredObjectPrefListEditor listEditor;
    private IgnoreList ignore;

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected Control createContents(Composite parent) {
        ignore = InternalIgnoreList.readInternalList();
        listEditor = IgnoredObjectPrefListEditor.create(parent, ignore);
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
        IgnoreList list = new IgnoreList();
        boolean isWhite = !ignore.isShow();
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