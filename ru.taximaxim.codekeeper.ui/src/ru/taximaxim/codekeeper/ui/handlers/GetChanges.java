package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IProject;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorInput;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgUIDumpLoader;
import ru.taximaxim.codekeeper.ui.propertytests.ChangesJobTester;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class GetChanges extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        IEditorPart part = HandlerUtil.getActiveEditor(event);

        if (part instanceof ProjectEditorDiffer){
            ((ProjectEditorDiffer) part).getChanges();
        } else if (part instanceof SQLEditor && part.getEditorInput() instanceof IFileEditorInput) {
            try {
                SQLEditor sqlEditor = (SQLEditor) part;
                IProject proj = ((IFileEditorInput) sqlEditor.getEditorInput()).getFile().getProject();

                DbInfo remote = sqlEditor.getCurrentDb();
                ProjectEditorDiffer editor = ChangesJobTester.findProjectEditor(proj);
                if (editor == null) {
                    ProjectEditorDiffer.saveLastDb(remote, proj);
                    ProjectEditorInput projectEditorInput = new ProjectEditorInput(proj.getName());
                    editor = (ProjectEditorDiffer) sqlEditor.getSite().getPage()
                            .openEditor(projectEditorInput, EDITOR.PROJECT);
                } else {
                    editor.setCurrentDb(remote);
                    editor.getSite().getPage().activate(editor);
                }
                editor.getChanges();
            } catch (PartInitException e) {
                ExceptionNotifier.notifyDefault(e.getLocalizedMessage(), e);
            }
        }
        return null;
    }

    @Override
    public boolean isEnabled() {
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        return editor instanceof ProjectEditorDiffer ||
                (editor instanceof SQLEditor && PgUIDumpLoader.isInProject(editor.getEditorInput()));
    }
}