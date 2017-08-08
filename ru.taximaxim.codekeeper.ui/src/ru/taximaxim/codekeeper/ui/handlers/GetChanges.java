package ru.taximaxim.codekeeper.ui.handlers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;

public class GetChanges extends AbstractHandler {
    private static volatile List<IWorkbenchPartSite> editorsWithGetChangesProcessing = new ArrayList<>();

    public static void removeEditor(IWorkbenchPartSite state) {
        editorsWithGetChangesProcessing.remove(state);
    }

    public static void addEditor(IWorkbenchPartSite state) {
        editorsWithGetChangesProcessing.add(state);
    }

    @Override
    public Object execute(ExecutionEvent event) {
        IWorkbenchPart part = HandlerUtil.getActiveEditor(event);

        if (part instanceof ProjectEditorDiffer){
            ProjectEditorDiffer differ = (ProjectEditorDiffer) part;
            String filePath = event.getParameter(UIConsts.EDITOR_COMMANDS.FILE_PATH);
            String coords = event.getParameter(UIConsts.EDITOR_COMMANDS.DB_COORDS);

            editorsWithGetChangesProcessing.add(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                    .getActivePage().getActiveEditor().getSite());

            if (filePath != null) {
                differ.getChanges(new File(filePath));
            } else if (coords != null) {
                differ.getChanges(new DbInfo(coords));
            } else {
                differ.getChanges();
            }
        }
        return null;
    }

    @Override
    public boolean isEnabled() {
        return !editorsWithGetChangesProcessing.contains(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getActivePage().getActiveEditor().getSite());
    }
}