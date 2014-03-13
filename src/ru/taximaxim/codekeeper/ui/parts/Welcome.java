 
package ru.taximaxim.codekeeper.ui.parts;

import javax.inject.Inject;
import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class Welcome {
    
    @Inject
    private MPart part;
    @Inject
    private EPartService partService;
    
    @PostConstruct
    private void postConstruct(Composite parent) {
    }
    
    @Inject
    private void projectChanged(PgDbProject proj) {
        if(proj == null) {
            partService.activate(part);
        }
    }
}