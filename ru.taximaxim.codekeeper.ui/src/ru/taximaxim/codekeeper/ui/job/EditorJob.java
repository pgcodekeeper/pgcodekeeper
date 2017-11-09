package ru.taximaxim.codekeeper.ui.job;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.IEditorPart;

public abstract class EditorJob extends Job {

    private final IEditorPart editorPart;

    public EditorJob(String name, IEditorPart editorPart) {
        super(name);
        this.editorPart = editorPart;
    }

    public IEditorPart getEditorPart() {
        return editorPart;
    }
}
