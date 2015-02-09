package ru.taximaxim.codekeeper.ui.editors;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.navigator.ILinkHelper;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;

public class LinkHelper implements ILinkHelper{

    @Override
    public IStructuredSelection findSelection(IEditorInput anInput) {
        StructuredSelection sel = null;
        if (anInput instanceof ProjectEditorInput) {
            ProjectEditorInput in = (ProjectEditorInput)anInput;
            sel = new StructuredSelection(in.getProject());
        }
        return sel;
    }

    @Override
    public void activateEditor(IWorkbenchPage aPage,
            IStructuredSelection aSelection) {
        if (aSelection == null || aSelection.isEmpty()) {
            return;
        }
        Object element= aSelection.getFirstElement();
        if (element instanceof ProjectEditorInput) {
            ProjectEditorInput in = (ProjectEditorInput)element;
            IEditorPart editor = aPage.findEditor(in);
            if (editor != null) {
                aPage.bringToTop(editor);
            } else {
                try {
                    aPage.openEditor(in, UIConsts.EDITOR.PROJECT);
                } catch (PartInitException e) {
                    Log.log(Log.LOG_ERROR, "Cannot open editor on input", e);
                }
            }
        }
    }

}
