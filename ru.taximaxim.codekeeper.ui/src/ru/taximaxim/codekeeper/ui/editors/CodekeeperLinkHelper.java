package ru.taximaxim.codekeeper.ui.editors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.navigator.ILinkHelper;
import org.eclipse.ui.part.FileEditorInput;

public class CodekeeperLinkHelper implements ILinkHelper{

    @Override
    public IStructuredSelection findSelection(IEditorInput anInput) {
        StructuredSelection sel = null;
        if (anInput instanceof ProjectEditorInput) {
            ProjectEditorInput in = (ProjectEditorInput)anInput;
            sel = new StructuredSelection(in.getProject());
        } 
        if (sel == null) {
            IFile file = ResourceUtil.getFile(anInput);
            if (file != null) {
                sel = new StructuredSelection(file);
            }
        }
        return sel;
    }
    
    @Override
    public void activateEditor(IWorkbenchPage aPage,
            IStructuredSelection aSelection) {
        if (aSelection == null || aSelection.isEmpty()) {
            return;
        }
        IEditorInput input = null;
        Object element= aSelection.getFirstElement();
        if (element instanceof IProject) {
            IProject proj = (IProject)element;
            input = new ProjectEditorInput(proj.getName());
            
        } else if (element instanceof IFile) {
            input = new FileEditorInput((IFile) element);
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
