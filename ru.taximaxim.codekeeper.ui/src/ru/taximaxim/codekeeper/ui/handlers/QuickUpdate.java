
package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.sqledit.RollOnEditor;

public class QuickUpdate extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        IWorkbench wb = PlatformUI.getWorkbench();
        IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
        IWorkbenchPage page = win.getActivePage();
        IEditorPart editor = page.getActiveEditor();

        RollOnEditor rollOnEditor;
        if(editor instanceof RollOnEditor){
            rollOnEditor = (RollOnEditor)editor;
        } else {
            return null;
        }

        Log.log(Log.LOG_DEBUG, "QuickUpdate starting"); //$NON-NLS-1$

        if(rollOnEditor.runQuickUpdate()){
            IEditorReference[] editorsReferences = page.getEditorReferences();

            for(IEditorReference editorsReference : editorsReferences){
                if("ru.taximaxim.codekeeper.ui.projectEditorDiffer".equals(editorsReference.getId())){
                    IEditorPart projectEditor = editorsReference.getEditor(true);
                    if(projectEditor != null){
                        ProjectEditorDiffer projectEditorDiffer = (ProjectEditorDiffer)projectEditor;
                        projectEditorDiffer.getChanges();
                        page.activate(projectEditorDiffer);
                        break;
                    }
                }
            }
        }
        return null;
    }
}