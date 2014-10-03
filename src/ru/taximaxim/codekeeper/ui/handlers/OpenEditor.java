package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorInput;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;


public class OpenEditor extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IProject proj = getProject(event).getProject();        
        if (proj != null) {
            try {
                openEditor(HandlerUtil.getActiveWorkbenchWindow(event).getActivePage(), proj);
            } catch (PgCodekeeperUIException e) {
                ExceptionNotifier.showErrorDialog(
                        "Cannot open editor on project" + proj.getName(), e);
            }
        }
        return null;
    }

    static PgDbProject getProject(ExecutionEvent event) {
        ISelection sel = HandlerUtil.getActiveMenuSelection(event);
        IStructuredSelection selection = (IStructuredSelection) sel;
        Object firstElement = selection.getFirstElement();
        if (firstElement instanceof IProject) {
            IProject proj = (IProject)firstElement;
            try {
                if (proj.getNature(NATURE.ID) != null) {
                    return new PgDbProject(proj);
                }
            } catch (CoreException e) {
                // silently return null incorrect project
                return null;
            }
        }
        return null;
    }

    public static void openEditor(IWorkbenchPage page, IProject proj) throws PgCodekeeperUIException {
        ProjectEditorInput input = new ProjectEditorInput(proj.getName());
        try {
              page.openEditor(input, EDITOR.PROJECT);
          } catch (PartInitException e) {
              throw new PgCodekeeperUIException("Cannot open editor", e);
          }
    }
}
