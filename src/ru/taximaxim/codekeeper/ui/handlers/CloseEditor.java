 
package ru.taximaxim.codekeeper.ui.handlers;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PART;

public class CloseEditor {
    
    @Inject
    @Named(IServiceConstants.ACTIVE_PART)
    private MPart part;
    
    @Execute
    private void execute(EPartService partService) {
        Log.log(Log.LOG_DEBUG, "Editor about to close: "  //$NON-NLS-1$
                + part.getPersistedState().get(PART.SQL_EDITOR_FILENAME));
        
        partService.hidePart(part);
    }
    
    @CanExecute
    private boolean canExecute() {
        String id = part.getElementId();
        return id.equals(PART.SQL_EDITOR);
    }
}