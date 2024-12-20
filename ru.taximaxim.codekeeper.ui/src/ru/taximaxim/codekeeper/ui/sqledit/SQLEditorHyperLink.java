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
package ru.taximaxim.codekeeper.ui.sqledit;

import java.nio.file.Paths;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.texteditor.ITextEditor;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.WorkDirs;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.libraries.LibraryUtils;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class SQLEditorHyperLink implements IHyperlink {

    private static final String DEPENDENCIES_FOLDER = LibraryUtils.META_PATH.toString();

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
        int index = relativePath.indexOf(DEPENDENCIES_FOLDER);
        if (-1 == index) {
            return label + " - " + relativePath + ':' + lineNumber; //$NON-NLS-1$
        }

        var temp = relativePath.substring(index + DEPENDENCIES_FOLDER.length());
        return temp.substring(0, temp.indexOf('_')) + " : " + label + " - " //$NON-NLS-1$ //$NON-NLS-2$
                + temp.substring(temp.indexOf('/') + 1, temp.length()) + ':' + lineNumber;
    }

    @Override
    public void open() {
        try {
            ITextEditor editor = (ITextEditor) FileUtilsUi.openFileInSqlEditor(
                    Paths.get(location), project, dbType, isLib());
            editor.selectAndReveal(region.getOffset(), region.getLength());
        } catch (PartInitException ex) {
            ExceptionNotifier.notifyDefault(
                    Messages.ProjectEditorDiffer_error_opening_script_editor, ex);
        }
    }

    /**
     * check it library or not
     *
     * @return true if it's library, and false if not
     */
    private boolean isLib() {
        var isInProjectDir = WorkDirs.getDirectoryNames(dbType).stream().anyMatch(location::contains);
        return location.contains(DEPENDENCIES_FOLDER) || !isInProjectDir;
    }
}