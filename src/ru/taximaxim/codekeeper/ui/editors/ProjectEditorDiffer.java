package ru.taximaxim.codekeeper.ui.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.MultiPageEditorPart;

import ru.taximaxim.codekeeper.ui.differ.DiffPresentationPane;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class ProjectEditorDiffer extends MultiPageEditorPart {

    @Override
    protected void createPages() {
        int i;
        /*
        i = addPage(new CommitPage(getContainer(), mainPrefs, proj));
        setPageText(i, "Commit");*/
    }

    @Override
    public void doSave(IProgressMonitor monitor) {
    }

    @Override
    public void doSaveAs() {
    }

    @Override
    public boolean isSaveAsAllowed() {
        return false;
    }
}

class CommitPage extends DiffPresentationPane {
    
    public CommitPage(Composite parent, IPreferenceStore mainPrefs,
            PgDbProject proj) {
        super(parent, true, mainPrefs, proj);
    }
    
    @Override
    protected void createUpperContainer(Composite container) {
        
    }
}