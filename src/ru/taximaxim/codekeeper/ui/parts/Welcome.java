 
package ru.taximaxim.codekeeper.ui.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.menus.IMenuService;

import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class Welcome {
    
    @Inject
    private MPart part;
    @Inject
    private EPartService partService;
    
    @Inject
    IMenuService menuService;
    
    @PostConstruct
    private void postConstruct(Composite parent) {
        parent.setLayout(new GridLayout());
        
        Label l = new Label(parent, SWT.BORDER);
        l.setText("Right-click me!");
        
        MenuManager mm = new MenuManager();
        menuService.populateContributionManager(mm, "popup:ru.taximaxim.codekeeper.popupmenu.welcometest");
        
        l.setMenu(mm.createContextMenu(l));
    }
    
    @Inject
    private void projectChanged(PgDbProject proj) {
        if (proj == null) {
            partService.activate(part);
        }
    }
}