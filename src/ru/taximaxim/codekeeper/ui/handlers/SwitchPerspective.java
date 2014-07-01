 
package ru.taximaxim.codekeeper.ui.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListDialog;

import ru.taximaxim.codekeeper.ui.Log;

public class SwitchPerspective {
    @Execute
    private void execute(
            @Named(IServiceConstants.ACTIVE_SHELL)
            Shell shell,
            EModelService modelSrv, EPartService partSrv,
            MApplication app) {
        ListDialog dialog = new ListDialog(shell);
        dialog.setTitle(Messages.SwitchPerspective_open_perspective);
        
        dialog.setContentProvider(ArrayContentProvider.getInstance());
        dialog.setInput(modelSrv.findElements(
                app, null, MPerspective.class, null));
        
        dialog.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                return ((MPerspective) element).getLabel();
            }
        });
        
        if(dialog.open() == Dialog.OK) {
            Log.log(Log.LOG_DEBUG, "About to switch perspective"); //$NON-NLS-1$
            
            partSrv.switchPerspective((MPerspective)(dialog.getResult()[0]));
        }
    }
}