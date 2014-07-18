 
package ru.taximaxim.codekeeper.ui.addons;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.handlers.LoadProj;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.recentprojs.RecentProjects;



public class AddonOpenLast {

    @Inject
    @Optional
    private void openLast(
            @EventTopic(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE)
            final MApplication app,
            
            final EModelService model,
            
            @Named(UIConsts.PREF_STORE) final IPreferenceStore mainPrefs,
            
            final EPartService partService,
            
            @Preference(UIConsts.PREF_OPEN_LAST_ON_START) String prefOpenLast,

            @Preference(UIConsts.PREF_RECENT_PROJECTS) String prefRecentProjects,
            
            UISynchronize sync,
            
            final @Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
        if (prefOpenLast != null && prefOpenLast.equals("true")) {
            String[] recent = RecentProjects.getRecent(prefRecentProjects);
            if (recent == null) {
                return;
            }
            
            String last = recent[0];
            final PgDbProject proj = new PgDbProject(last);
            
            if (proj.getProjectFile().isFile()) {
                sync.syncExec(new Runnable() {
                    
                    @Override
                    public void run() {
                        LoadProj.load(proj, app.getContext(), partService, model, app,
                                mainPrefs, shell);
                    }
                });
            } else {
                Log.log(Log.LOG_WARNING, "Couldn't open last project at "
                        + proj.getProjectFile()
                        + ". Project pref store either doesn't exist or not a file.");
            }
        }
    }
}
