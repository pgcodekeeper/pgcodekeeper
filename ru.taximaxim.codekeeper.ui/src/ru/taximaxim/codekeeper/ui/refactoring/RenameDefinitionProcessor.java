package ru.taximaxim.codekeeper.ui.refactoring;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class RenameDefinitionProcessor extends RenameProcessor {

    private static final String IDENTIFIER = "ru.taximaxim.codekeeper.ui.renameDefinitionProcessor"; //$NON-NLS-1$

    private final PgObjLocation selection;
    private String newName;

    public RenameDefinitionProcessor(PgObjLocation selection) {
        this.selection = selection;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    @Override
    public Object[] getElements() {
        return getReferences().toArray();
    }

    private List<PgObjLocation> getReferences() {
        IFile file = FileUtilsUi.getFileForLocation(selection);

        if (file == null) {
            return new ArrayList<>();
        }

        return PgDbParser.getParser(file.getProject()).getAllObjReferences()
                .filter(selection::compare).sorted((o1, o2) -> {

                    int result = o1.getFilePath().compareTo(o2.getFilePath());
                    if (result != 0) {
                        return result;
                    }

                    return Integer.compare(o1.getOffset(), o2.getOffset());
                }).collect(Collectors.toList());
    }

    public String getOldName() {
        return selection.getObjName();
    }

    @Override
    public String getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public String getProcessorName() {
        return "Rename reference"; //$NON-NLS-1$
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

        IFile file = null;
        TextFileChange fileChange = null;
        MultiTextEdit multiEdit = null;

        for (PgObjLocation ref : getReferences()) {
            IFile mfile = FileUtilsUi.getFileForLocation(ref);

            if (mfile == null) {
                continue;
            }

            if (!Objects.equals(file, mfile)) {
                file = mfile;
                multiEdit = new MultiTextEdit();
                fileChange = new TextFileChange(file.getName(), file);
                fileChange.setTextType("sql"); //$NON-NLS-1$
                fileChange.setEdit(multiEdit);
                change.add(fileChange);
            }

            multiEdit.addChild(new ReplaceEdit(ref.getOffset(), ref.getObjLength(),
                    newName));
        }

        return change;
    }

    @Override
    public RefactoringParticipant[] loadParticipants(RefactoringStatus status,
            SharableParticipants sharedParticipants) throws CoreException {
        return new RefactoringParticipant[0];
    }
}
