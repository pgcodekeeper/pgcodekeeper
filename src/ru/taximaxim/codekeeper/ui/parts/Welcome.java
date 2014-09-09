 
package ru.taximaxim.codekeeper.ui.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;

import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class Welcome {
    
    @Inject
    private IWorkbenchPage page;
    @Inject
    private IViewPart viewPart;
    
    @PostConstruct
    private void postConstruct(Composite parent) {
        parent.setLayout(new GridLayout());
    }
    
    @Inject
    private void projectChanged(PgDbProject proj) {
        if (proj == null) {
            page.activate(viewPart);
        }
    }
}