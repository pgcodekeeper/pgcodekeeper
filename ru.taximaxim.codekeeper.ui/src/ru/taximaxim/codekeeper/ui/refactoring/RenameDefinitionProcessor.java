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
package ru.taximaxim.codekeeper.ui.refactoring;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant;
import org.eclipse.ltk.core.refactoring.participants.RenameProcessor;
import org.eclipse.ltk.core.refactoring.participants.SharableParticipants;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.fileutils.FileUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation.LocationType;
import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class RenameDefinitionProcessor extends RenameProcessor {

    private static final String IDENTIFIER = "ru.taximaxim.codekeeper.ui.renameDefinitionProcessor"; //$NON-NLS-1$

    private String newName;

    private final PgObjLocation selection;
    private final DatabaseType dbType;
    private final IFile file;

    public RenameDefinitionProcessor(PgObjLocation selection) {
        this.selection = selection;
        this.file = FileUtilsUi.getFileForLocation(selection);
        this.dbType = file != null ? OpenProjectUtils.getDatabaseType(file.getProject()) : DatabaseType.PG;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    @Override
    public Object[] getElements() {
        return getReferences().toArray();
    }

    private Stream<PgObjLocation> getReferences() {
        if (file == null) {
            return Stream.empty();
        }

        return PgDbParser.getParser(file).getAllObjReferences()
                .filter(selection::compare)
                .filter(def -> def.isGlobal() || def.getFilePath().equals(selection.getFilePath()))
                .sorted((o1, o2) -> {

                    int result = o1.getFilePath().compareTo(o2.getFilePath());
                    if (result != 0) {
                        return result;
                    }

                    return Integer.compare(o1.getOffset(), o2.getOffset());
                });
    }

    public String getOldName() {
        return selection.getBareName();
    }

    @Override
    public String getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public String getProcessorName() {
        return Messages.RenameDefinitionProcessor_rename_object;
    }

    @Override
    public boolean isApplicable() {
        return true;
    }

    @Override
    public RefactoringStatus checkInitialConditions(IProgressMonitor pm) {
        return new RefactoringStatus();
    }

    @Override
    public RefactoringStatus checkFinalConditions(IProgressMonitor pm,
            CheckConditionsContext context) {
        return new RefactoringStatus();
    }

    @Override
    public Change createChange(IProgressMonitor pm) {
        CompositeChange change = new CompositeChange(getProcessorName());
        String quotedName;
        if (!selection.isGlobal()) {
            // do not quote alias
            quotedName = newName;
        } else if (dbType == DatabaseType.MS) {
            quotedName = MsDiffUtils.quoteName(newName);
        } else if (selection.getType() == DbObjType.USER_MAPPING || selection.getType() == DbObjType.CAST ) {
            quotedName = newName;
        } else if (dbType == DatabaseType.PG){
            quotedName = PgDiffUtils.getQuotedName(newName);
        } else {
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
        }

        IFile file = null;
        MultiTextEdit multiEdit = null;
        List<RenameDefinitionChange> fileRenames = new ArrayList<>();

        for (PgObjLocation ref : PgDiffUtils.sIter(getReferences())) {
            IFile mfile = FileUtilsUi.getFileForLocation(ref);

            if (mfile == null) {
                continue;
            }

            if (ref.getLocationType() == LocationType.DEFINITION) {
                addFileRenames(mfile, ref, fileRenames);
            }

            if (!Objects.equals(file, mfile)) {
                file = mfile;
                multiEdit = new MultiTextEdit();
                TextFileChange fileChange = new TextFileChange(file.getName(), file);
                fileChange.setTextType("sql"); //$NON-NLS-1$
                fileChange.setEdit(multiEdit);
                change.add(fileChange);
            }

            multiEdit.addChild(new ReplaceEdit(ref.getOffset(), ref.getObjLength(),
                    quotedName));
        }

        fileRenames.forEach(change::add);

        return change;
    }

    private void addFileRenames(IFile file, PgObjLocation ref, List<RenameDefinitionChange> fileRenames) {
        if (ref.getColumn() != null) {
            return;
        }

        switch (dbType) {
        case PG:
            fileRenames.add(new RenameDefinitionChange(file.getFullPath(),
                    ModelExporter.getExportedFilenameSql(newName)));
            if (ref.getType() == DbObjType.SCHEMA) {
                // rename schema folder for PG
                fileRenames.add(new RenameDefinitionChange(file.getParent().getFullPath(),
                        FileUtils.getValidFilename(newName)));
            }
            break;
        case MS:
            String name;
            if (ref.getTable() != null) {
                name = ref.getSchema() + '.' + newName;
            } else {
                name = newName;
            }

            fileRenames.add(new RenameDefinitionChange(file.getFullPath(),
                    ModelExporter.getExportedFilenameSql(name)));
            break;
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
        }
    }

    @Override
    public RefactoringParticipant[] loadParticipants(RefactoringStatus status,
            SharableParticipants sharedParticipants) throws CoreException {
        return new RefactoringParticipant[0];
    }
}
