package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IProject;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.UIProjectLoader;
import ru.taximaxim.codekeeper.ui.search.ReferenceSearchQuery;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class FindReferences extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);

        if (activeEditor instanceof SQLEditor) {
            SQLEditor editor = (SQLEditor) activeEditor;

            IProject proj = ((IFileEditorInput) editor.getEditorInput()).getFile().getProject();

            PgObjLocation ref = editor.getCurrentReference();

            if (ref != null) {
                NewSearchUI.activateSearchResultView();
                NewSearchUI.runQueryInBackground(new ReferenceSearchQuery(ref, proj));
            }
        }

        return null;
    }

    @Override
    public boolean isEnabled() {
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        return editor instanceof SQLEditor && UIProjectLoader.isInProject(editor.getEditorInput());
    }
}