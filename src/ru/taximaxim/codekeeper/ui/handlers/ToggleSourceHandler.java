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

public class ToggleSourceHandler extends AbstractHandler implements IElementUpdater {
    private static Boolean stateOf = new Boolean(true);
    
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        ICommandService service = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
        
        stateOf = !stateOf;
        Command command = service.getCommand("ru.taximaxim.codekeeper.ui.toggle1");
        command.getState("ru.taximaxim.codekeeper.ui.toggle1state").setValue(stateOf);
        service.refreshElements("ru.taximaxim.codekeeper.ui.toggle1", null);

        Command command2 = service.getCommand("ru.taximaxim.codekeeper.ui.toggle2");
        command2.getState("ru.taximaxim.codekeeper.ui.toggle2state").setValue(stateOf);
        service.refreshElements("ru.taximaxim.codekeeper.ui.toggle2", null);

        return null;
    }

    @Override
    public void updateElement(UIElement element, Map parameters) {
        element.setChecked(stateOf);
        stateOf = !stateOf;
    }

}
