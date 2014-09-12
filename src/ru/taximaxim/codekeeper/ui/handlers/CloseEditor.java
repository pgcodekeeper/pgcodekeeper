 
package ru.taximaxim.codekeeper.ui.handlers;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PART;

public class CloseEditor extends E4HandlerWrapper {
    
    @Inject
    @Named(IServiceConstants.ACTIVE_PART)
    private MPart part;
    
    @Execute
    private void execute(IWorkbenchPage page, IViewPart viewPart) {
        Log.log(Log.LOG_DEBUG, "Editor about to close: "  //$NON-NLS-1$
                + part.getPersistedState().get(PART.SQL_EDITOR_FILENAME));
        
        page.hideView(viewPart);
    }
    
    @CanExecute
    private boolean canExecute() {
        return part == null ? false : 
            part.getElementId().indexOf(PART.SQL_EDITOR) == 0;
    }
}