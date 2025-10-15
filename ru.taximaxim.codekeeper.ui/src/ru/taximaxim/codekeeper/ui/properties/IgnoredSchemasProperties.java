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
import org.pgcodekeeper.core.ignorelist.IgnoreSchemaList;
import org.pgcodekeeper.core.ignorelist.IgnoredObject;

import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.IgnoredObjectPrefListEditor;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.InternalIgnoreList;

public class IgnoredSchemasProperties extends PropertyPage {

    private IgnoredObjectPrefListEditor listEditor;
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

        listEditor = IgnoredObjectPrefListEditor.createIgnoreSchemaEditor(parent, ignoreSchemaList);
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