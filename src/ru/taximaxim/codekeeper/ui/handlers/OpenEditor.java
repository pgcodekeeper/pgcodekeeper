package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorInput;


public class OpenEditor extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        ISelection sel = HandlerUtil.getActiveMenuSelection(event);
        IStructuredSelection selection = (IStructuredSelection) sel;
        IWorkbenchPage page = PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getActivePage();

        Object firstElement = selection.getFirstElement();
        if (firstElement instanceof IProject) {
            IProject proj = (IProject)firstElement;
            ProjectEditorInput input = new ProjectEditorInput(proj.getName());
            try {
                page.openEditor(input, EDITOR.PROJECT);
              } catch (PartInitException e) {
                throw new RuntimeException(e);
              }
        }
        return null;
    }
}
