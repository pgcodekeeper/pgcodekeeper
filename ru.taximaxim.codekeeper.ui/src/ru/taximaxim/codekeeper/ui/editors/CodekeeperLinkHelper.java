package ru.taximaxim.codekeeper.ui.editors;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.navigator.ILinkHelper;

import ru.taximaxim.codekeeper.ui.libraries.FileLibrary;
import ru.taximaxim.codekeeper.ui.libraries.LibraryUtils;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorInput;

public class CodekeeperLinkHelper implements ILinkHelper {

    @Override
    public IStructuredSelection findSelection(IEditorInput anInput) {
        if (anInput instanceof ProjectEditorInput) {
            ProjectEditorInput in = (ProjectEditorInput) anInput;
            return new StructuredSelection(in.getProject());
        }

        if (anInput instanceof SQLEditorInput) {
            SQLEditorInput input = (SQLEditorInput) anInput;
            if (input.isReadOnly()) {
                return new StructuredSelection(LibraryUtils.createFileLib(
                        input.getPath(), input.getProject(), input.isMsSql()));
            }
        }

        return StructuredSelection.EMPTY;
    }

    @Override
    public void activateEditor(IWorkbenchPage aPage,
            IStructuredSelection aSelection) {
        if (aSelection == null || aSelection.isEmpty()) {
            return;
        }
        IEditorInput input = null;
        Object element = aSelection.getFirstElement();
        if (element instanceof IProject) {
            IProject proj = (IProject) element;
            input = new ProjectEditorInput(proj.getName());
        } else if (element instanceof FileLibrary) {
            FileLibrary lib = (FileLibrary) element;
            input = new SQLEditorInput(lib.getPath(), lib.isMsSql(), true);
        }
        if (input == null) {
            return;
        }
        IEditorPart editor = aPage.findEditor(input);
        if (editor != null) {
            aPage.activate(editor);
        }
    }
}
