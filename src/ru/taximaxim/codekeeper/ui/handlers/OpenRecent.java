package ru.taximaxim.codekeeper.ui.handlers;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuItem;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.RecentProjects;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class OpenRecent {
    private MMenuItem menuItem;
    @Inject
    private EPartService partService;
    
    @CanExecute
    public boolean canExecute(@Optional MMenuItem menuItem) {
        this.menuItem = menuItem;
        return menuItem != null;
    }

    @Execute
    public void execute(final MApplication app, final EModelService model, 
            @Named(UIConsts.PREF_STORE) final IPreferenceStore mainPrefs,
            @Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
        CloseActiveProj.close(app.getContext());
        PgDbProject proj = new PgDbProject(menuItem.getLabel());
        
        if(proj.getProjectPropsFile().isFile()) {
            LoadProj.load(proj, app.getContext(), partService, model, app, mainPrefs);
        } else {
            MessageBox mb = new MessageBox(shell);
            mb.setText("Load failed");
            mb.setMessage("Directory is not a valid project!"
                    + " Properties file not found!");
            mb.open();
            RecentProjects.deleteRecent(menuItem.getLabel(), mainPrefs);
        }
    }
}
