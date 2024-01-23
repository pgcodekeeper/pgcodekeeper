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
package ru.taximaxim.codekeeper.ui.sqledit;

import java.nio.file.Paths;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.texteditor.ITextEditor;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class SQLEditorHyperLink implements IHyperlink {

    private final String location;
    private final IRegion region;
    private final String label;
    private final IRegion regionHightLight;
    private final int lineNumber;
    private final String relativePath;
    private final DatabaseType dbType;
    private final String project;

    public SQLEditorHyperLink(IRegion region, IRegion regionHightLight, String label,
            String location, int lineNumber, DatabaseType dbType, String project) {
        this.region = region;
        this.regionHightLight = regionHightLight;
        this.location = location;
        this.label = label;
        this.lineNumber = lineNumber;
        this.dbType = dbType;
        this.project = project;
        IFile file = FileUtilsUi.getFileForLocation(location);
        relativePath = file == null ? location : file.getProjectRelativePath().toString();
    }

    @Override
    public IRegion getHyperlinkRegion() {
        return regionHightLight;
    }

    @Override
    public String getTypeLabel() {
        return label;
    }

    @Override
    public String getHyperlinkText() {
        return label + " - " + relativePath + ':' + lineNumber; //$NON-NLS-1$
    }

    @Override
    public void open() {
        try {
            ITextEditor editor = (ITextEditor) FileUtilsUi.openFileInSqlEditor(
                    Paths.get(location), project, dbType, false);
            editor.selectAndReveal(region.getOffset(), region.getLength());
        } catch (PartInitException ex) {
            ExceptionNotifier.notifyDefault(
                    Messages.ProjectEditorDiffer_error_opening_script_editor, ex);
        }
    }
}