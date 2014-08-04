 
package ru.taximaxim.codekeeper.ui.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.recentprojs.RecentProjects;

public class OpenLastProject {
    
    @Execute
    private void execute(
            final MApplication app,
            final EModelService model,
            final EPartService partService,
            
            @Named(UIConsts.PREF_STORE) final IPreferenceStore mainPrefs,
            @Preference(PREF.RECENT_PROJECTS) String prefRecentProjects,

            UISynchronize sync,
            final @Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
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
            Log.log(Log.LOG_WARNING,
                    "Couldn't open last project at " //$NON-NLS-1$
                            + proj.getProjectFile()
                            + ". Project pref store either doesn't exist or not a file."); //$NON-NLS-1$
        }
    }
    
    @CanExecute
    private boolean canExecute(
            @Preference(PREF.RECENT_PROJECTS) String prefRecentProjects) {
        return RecentProjects.getRecent(prefRecentProjects) != null;
    }
}