package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import cz.startnet.utils.pgdiff.PgCodekeeperException;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class CommitProject extends AbstractHandler {
    boolean isEnable;

    @Override
    public Object execute(ExecutionEvent event) {
        IWorkbenchPart part = HandlerUtil.getActiveEditor(event);
        isEnable = part instanceof ProjectEditorDiffer;
        if (isEnable){
            ProjectEditorDiffer differ = (ProjectEditorDiffer) part;
            try {
                differ.commit();
            } catch (PgCodekeeperException ex) {
                ExceptionNotifier.notifyDefault(Messages.error_creating_dependency_graph, ex);
            }
        }
        return null;
    }

    @Override
    public boolean isEnabled() {
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        return editor instanceof ProjectEditorDiffer;
    }
}