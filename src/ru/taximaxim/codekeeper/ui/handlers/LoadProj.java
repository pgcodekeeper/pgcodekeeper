 
package ru.taximaxim.codekeeper.ui.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.parts.CommitPartDescr;
import ru.taximaxim.codekeeper.ui.parts.DiffPartDescr;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.recentprojs.RecentProjects;

public class LoadProj {
    
    @Execute
    private void execute(
            @Named(IServiceConstants.ACTIVE_SHELL)
            Shell shell,
            IEclipseContext ctx, EPartService partService, EModelService model,
            MApplication app, @Named(UIConsts.PREF_STORE) final IPreferenceStore mainPrefs) {
        DirectoryDialog dialog = new DirectoryDialog(shell);
        String path = dialog.open();
        if(path != null) {
            PgDbProject proj = new PgDbProject(path);
            if(proj.getProjectPropsFile().isFile()) {
                load(proj, ctx, partService, model, app, mainPrefs);
            } else {
                MessageBox mb = new MessageBox(shell);
                mb.setText("Load failed");
                mb.setMessage("Directory is not a valid project!"
                        + " Properties file not found!");
                mb.open();
            }
        }
    }
    
    public static void load(PgDbProject proj, IEclipseContext ctx, EPartService partService,
            EModelService model, MApplication app, IPreferenceStore mainPrefs) {
        Log.log(Log.LOG_INFO, "Opening project at " + proj.getProjectPropsFile());
        ctx.modify(PgDbProject.class, proj);
        
        CommitPartDescr.openNew(proj.getProjectDir(), partService, model, app);
        DiffPartDescr.openNew(proj.getProjectDir(), partService, model, app);
        RecentProjects.addRecent(proj.getProjectDir(), mainPrefs);
    }
}