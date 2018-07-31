package ru.taximaxim.codekeeper.ui.handlers;

import java.text.MessageFormat;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISources;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorInput;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class OpenEditor extends AbstractHandler {

    private IProject proj;

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        if (isEnabled() && proj != null) {
            try {
                openEditor(HandlerUtil.getActiveWorkbenchWindow(event).getActivePage(), proj);
            } catch (PartInitException e) {
                ExceptionNotifier.notifyDefault(MessageFormat.format(
                        Messages.OpenEditor_error_open_project_editor, proj.getName()), e);
            }
        }
        return null;
    }

    @Override
    public void setEnabled(Object evaluationContext) {
        proj = getSelectedProject(evaluationContext);
        try {
            setBaseEnabled(proj == null ? false : proj.hasNature(NATURE.ID));
        } catch (CoreException ex) {
            setBaseEnabled(false);
            Log.log(ex);
        }
    }

    private IProject getSelectedProject(Object ctx) {
        if (ctx instanceof IEvaluationContext) {
            Object sel = ((IEvaluationContext) ctx).getVariable(ISources.ACTIVE_CURRENT_SELECTION_NAME);
            if (sel instanceof IStructuredSelection) {
                Object el = ((IStructuredSelection) sel).getFirstElement();
                if (el instanceof IAdaptable) {
                    return ((IAdaptable) el).getAdapter(IProject.class);
                }
            }
        }
        return null;
    }

    public static void openEditor(IWorkbenchPage page, IProject proj) throws PartInitException {
        Log.log(Log.LOG_INFO, "Opening editor for project: " + proj.getName()); //$NON-NLS-1$
        Shell shell = page.getWorkbenchWindow().getShell();
        if (OpenProjectUtils.checkVersionAndWarn(proj, shell, true)) {
            try {
                OpenProjectUtils.checkLegacySchemas(proj, shell);
            } catch (CoreException ex) {
                ExceptionNotifier.notifyCoreException(ex);
                return;
            }

            ProjectEditorInput input = new ProjectEditorInput(proj.getName());
            page.openEditor(input, EDITOR.PROJECT);
        }
    }
}
