package ru.taximaxim.codekeeper.mainapp;

import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }

    @Override
    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new ActionBarAdvisor(configurer);
    }
    
    @Override
    public void preWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        configurer.setInitialSize(new Point(1280, 768));
        configurer.setShowMenuBar(true);
        configurer.setShowCoolBar(true);
        configurer.setShowPerspectiveBar(true);
        configurer.setShowStatusLine(true);
        configurer.setTitle("pgCodeKeeper"); //$NON-NLS-1$
    }
}
