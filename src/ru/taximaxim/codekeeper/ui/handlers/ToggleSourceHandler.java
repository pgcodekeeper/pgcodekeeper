package ru.taximaxim.codekeeper.ui.handlers;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.menus.UIElement;

import ru.taximaxim.codekeeper.ui.UIConsts.COMMAND;

public class ToggleSourceHandler extends AbstractHandler implements IElementUpdater {
    private static Boolean stateOf = true;
    
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        ICommandService service = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
        
        stateOf = !stateOf;
        Command command = service.getCommand(COMMAND.DEPCY_SRC);
        command.getState(COMMAND.DEPCY_SRC_STATE).setValue(stateOf);
        service.refreshElements(COMMAND.DEPCY_SRC, null);

        Command command2 = service.getCommand(COMMAND.DEPCY_TGT);
        command2.getState(COMMAND.DEPCY_TGT_STATE).setValue(stateOf);
        service.refreshElements(COMMAND.DEPCY_TGT, null);

        return null;
    }

    @Override
    public void updateElement(UIElement element, 
            @SuppressWarnings("rawtypes") Map parameters) {
        element.setChecked(stateOf);
        stateOf = !stateOf;
    }
}
