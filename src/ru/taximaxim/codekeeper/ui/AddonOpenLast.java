 
package ru.taximaxim.codekeeper.ui;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.jface.preference.IPreferenceStore;

import ru.taximaxim.codekeeper.ui.handlers.LoadProj;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.recentprojs.RecentProjects;

public class AddonOpenLast {

 @Inject
    @Optional
    private void openLast(
            // FIXME workaround, see http://www.eclipse.org/forums/index.php/t/351144/
            // and https://bugs.eclipse.org/bugs/show_bug.cgi?id=378694
            // without @Named it doesn't register @EventTopic annotation,
            // calls the method on Addon creation and doesn't do anything afterwards
            @Named("__DUMMY__")
            @EventTopic(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE)
            final MApplication app,
            
            final EModelService model,
            
            @Named(UIConsts.PREF_STORE) final IPreferenceStore mainPrefs,
            
            final EPartService partService,
            
            @Preference(value=UIConsts.PREF_OPEN_LAST_ON_START) String prefOpenLast,

            @Preference(value = UIConsts.PREF_RECENT_PROJECTS) String prefRecentProjects,
            
            UISynchronize sync) {
        if (prefOpenLast != null && prefOpenLast.equals("true")) {
            String[] recent = RecentProjects.getRecent(prefRecentProjects);
            if (recent == null) {
                return;
            }
            
            String last = recent[0];
            final PgDbProject proj = new PgDbProject(last);
            
            if (proj.getProjectFile().isFile()) {
                proj.load();
                sync.asyncExec(new Runnable() {
                    
                    @Override
                    public void run() {
                        LoadProj.load(proj, app.getContext(), partService, model, app,
                                mainPrefs);
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
