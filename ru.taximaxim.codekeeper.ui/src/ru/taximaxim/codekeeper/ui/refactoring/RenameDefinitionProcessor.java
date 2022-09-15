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

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgObjLocation.LocationType;
import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.AbstractModelExporter;
import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class RenameDefinitionProcessor extends RenameProcessor {

    private static final String IDENTIFIER = "ru.taximaxim.codekeeper.ui.renameDefinitionProcessor"; //$NON-NLS-1$

    private String newName;

    private final PgObjLocation selection;
    private final boolean isMsSql;
    private final IFile file;

    public RenameDefinitionProcessor(PgObjLocation selection) {
        this.selection = selection;
        this.file = FileUtilsUi.getFileForLocation(selection);
        this.isMsSql = file != null && OpenProjectUtils.checkMsSql(file.getProject());
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
        } else if (isMsSql) {
            quotedName = MsDiffUtils.quoteName(newName);
        } else {
            if (selection.getType() == DbObjType.USER_MAPPING || selection.getType() == DbObjType.CAST ) {
                quotedName = newName;
            } else {
                quotedName = PgDiffUtils.getQuotedName(newName);
            }
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
        switch (ref.getType()) {
        case TRIGGER:
        case RULE:
        case CONSTRAINT:
        case INDEX:
        case POLICY:
            return;
        default:
            break;
        }

        if (isMsSql) {
            String name;
            if (ref.getTable() != null) {
                name = ref.getSchema() + '.' + newName;
            } else {
                name = newName;
            }

            fileRenames.add(new RenameDefinitionChange(file.getFullPath(),
                    AbstractModelExporter.getExportedFilenameSql(name)));
        } else {
            fileRenames.add(new RenameDefinitionChange(file.getFullPath(),
                    AbstractModelExporter.getExportedFilenameSql(newName)));
            if (ref.getType() == DbObjType.SCHEMA) {
                // rename schema folder for PG
                fileRenames.add(new RenameDefinitionChange(file.getParent().getFullPath(),
                        FileUtils.getValidFilename(newName)));
            }
        }
    }

    @Override
    public RefactoringParticipant[] loadParticipants(RefactoringStatus status,
            SharableParticipants sharedParticipants) throws CoreException {
        return new RefactoringParticipant[0];
    }
}
